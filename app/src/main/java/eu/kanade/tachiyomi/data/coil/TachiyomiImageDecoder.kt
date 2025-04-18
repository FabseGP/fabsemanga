package eu.kanade.tachiyomi.data.coil

import android.os.Build
import coil3.ImageLoader
import coil3.asCoilImage
import coil3.decode.DecodeResult
import coil3.decode.Decoder
import coil3.decode.ImageSource
import coil3.fetch.SourceFetchResult
import coil3.request.Options
import coil3.request.allowRgb565
import eu.kanade.tachiyomi.util.storage.CbzCrypto
import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.model.FileHeader
import okio.BufferedSource
import tachiyomi.core.common.util.system.ImageUtil
import tachiyomi.decoder.ImageDecoder

/**
 * A [Decoder] that uses built-in [ImageDecoder] to decode images that is not supported by the system.
 */
class TachiyomiImageDecoder(private val resources: ImageSource, private val options: Options) : Decoder {

    override suspend fun decode(): DecodeResult {
        // SY -->
        var zip4j: ZipFile? = null
        var entry: FileHeader? = null

        if (resources.sourceOrNull()?.peek()?.use { CbzCrypto.detectCoverImageArchive(it.inputStream()) } == true) {
            if (resources.source().peek().use { ImageUtil.findImageType(it.inputStream()) == null }) {
                zip4j = ZipFile(resources.file().toFile().absolutePath)
                entry = zip4j.fileHeaders.firstOrNull {
                    it.fileName.equals(CbzCrypto.DEFAULT_COVER_NAME, ignoreCase = true)
                }

                if (zip4j.isEncrypted) zip4j.setPassword(CbzCrypto.getDecryptedPasswordCbz())
            }
        }
        val decoder = resources.sourceOrNull()?.use {
            zip4j.use { zipFile ->
                ImageDecoder.newInstance(zipFile?.getInputStream(entry) ?: it.inputStream())
            }
        }
        // SY <--

        check(decoder != null && decoder.width > 0 && decoder.height > 0) { "Failed to initialize decoder" }

        val bitmap = decoder.decode(rgb565 = options.allowRgb565)
        decoder.recycle()

        check(bitmap != null) { "Failed to decode image" }

        return DecodeResult(
            image = bitmap.asCoilImage(),
            isSampled = false,
        )
    }

    class Factory : Decoder.Factory {

        override fun create(result: SourceFetchResult, options: Options, imageLoader: ImageLoader): Decoder? {
            if (!isApplicable(result.source.source())) return null
            return TachiyomiImageDecoder(result.source, options)
        }

        private fun isApplicable(source: BufferedSource): Boolean {
            val type = source.peek().inputStream().buffered().use { stream ->
                ImageUtil.findImageType(stream)
            }
            // SY -->
            source.peek().inputStream().use { stream ->
                if (CbzCrypto.detectCoverImageArchive(stream)) return true
            }
            // SY <--
            return when (type) {
                ImageUtil.ImageType.AVIF, ImageUtil.ImageType.JXL -> true
                ImageUtil.ImageType.HEIF -> Build.VERSION.SDK_INT < Build.VERSION_CODES.O
                else -> false
            }
        }

        override fun equals(other: Any?) = other is Factory

        override fun hashCode() = javaClass.hashCode()
    }
}
