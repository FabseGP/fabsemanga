# detekt

## Metrics

* 343 number of properties

* 330 number of functions

* 72 number of classes

* 15 number of packages

* 53 number of kt files

## Complexity Report

* 4,060 lines of code (loc)

* 3,010 source lines of code (sloc)

* 2,104 logical lines of code (lloc)

* 446 comment lines of code (cloc)

* 663 cyclomatic complexity (mcc)

* 404 cognitive complexity

* 48 number of total code smells

* 14% comment source ratio

* 315 mcc per 1,000 lloc

* 22 code smells per 1,000 lloc

## Findings (48)

### complexity, TooManyFunctions (3)

Too many functions inside a/an file/class/object/interface always indicate a violation of the single responsibility principle. Maybe the file/class/object/interface wants to manage too many things at once. Extract functionality which clearly belongs together.

[Documentation](https://detekt.dev/docs/rules/complexity#toomanyfunctions)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/core/security/SecurityPreferences.kt:10:7
```
Class 'SecurityPreferences' with '11' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
7  import tachiyomi.i18n.MR
8  import tachiyomi.i18n.sy.SYMR
9  
10 class SecurityPreferences(
!!       ^ error
11     private val preferenceStore: PreferenceStore,
12 ) {
13 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:42:8
```
Object 'CbzCrypto' with '23' functions detected. Defined threshold inside objects is set to '11'
```
```kotlin
39  * passwords before storing
40  * them in Shared Preferences
41  */
42 object CbzCrypto {
!!        ^ error
43     const val DATABASE_NAME = "tachiyomiEncrypted.db"
44     const val DEFAULT_COVER_NAME = "cover.jpg"
45     private val securityPreferences: SecurityPreferences by injectLazy()

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/exh/log/Logging.kt:1:1
```
File '/home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/exh/log/Logging.kt' with '29' functions detected. Defined threshold inside files is set to '11'
```
```kotlin
1 package exh.log
! ^ error
2 
3 import android.util.Log
4 import com.elvishew.xlog.Logger

```

### exceptions, InstanceOfCheckForException (1)

Instead of catching for a general exception type and checking for a specific exception type, use multiple catch blocks.

[Documentation](https://detekt.dev/docs/rules/exceptions#instanceofcheckforexception)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/lang/RxCoroutineBridge.kt:80:25
```
Instead of catching for a general exception type and checking for a specific exception type, use multiple catch blocks.
```
```kotlin
77                     emitter.onCompleted()
78                 } catch (e: Throwable) {
79                     // Ignore `CancellationException` as error, since it indicates "normal cancellation"
80                     if (e !is CancellationException) {
!!                         ^ error
81                         emitter.onError(e)
82                     } else {
83                         emitter.onCompleted()

```

### exceptions, SwallowedException (1)

The caught exception is swallowed. The original exception could be lost.

[Documentation](https://detekt.dev/docs/rules/exceptions#swallowedexception)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:168:18
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
165                 zip.getInputStream(zip.fileHeaders.firstOrNull())
166             }
167             return true
168         } catch (e: Exception) {
!!!                  ^ error
169             logcat(LogPriority.WARN) {
170                 "Wrong CBZ archive password for: ${zip4j.file.name} in: ${zip4j.file.parentFile?.name}"
171             }

```

### exceptions, TooGenericExceptionCaught (2)

The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptioncaught)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:168:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
165                 zip.getInputStream(zip.fileHeaders.firstOrNull())
166             }
167             return true
168         } catch (e: Exception) {
!!!                  ^ error
169             logcat(LogPriority.WARN) {
170                 "Wrong CBZ archive password for: ${zip4j.file.name} in: ${zip4j.file.parentFile?.name}"
171             }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/lang/RxCoroutineBridge.kt:78:26
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
75                 try {
76                     emitter.onNext(block())
77                     emitter.onCompleted()
78                 } catch (e: Throwable) {
!!                          ^ error
79                     // Ignore `CancellationException` as error, since it indicates "normal cancellation"
80                     if (e !is CancellationException) {
81                         emitter.onError(e)

```

### formatting, CommentWrapping (4)

Reports mis-indented code

[Documentation](https://detekt.dev/docs/rules/formatting#commentwrapping)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/NetworkHelper.kt:16:6
```
A block comment in between other elements on the same line is disallowed
```
```kotlin
13 import java.util.concurrent.TimeUnit
14 
15 /* SY --> */
16 open /* SY <-- */ class NetworkHelper(
!!      ^ error
17     private val context: Context,
18     private val preferences: NetworkPreferences,
19     // SY -->

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/NetworkHelper.kt:25:10
```
A block comment in between other elements on the same line is disallowed
```
```kotlin
22 ) {
23 
24     /* SY --> */
25     open /* SY <-- */val cookieJar = AndroidCookieJar()
!!          ^ error
26 
27     /* SY --> */
28     open /* SY <-- */val client: OkHttpClient = run {

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/NetworkHelper.kt:28:10
```
A block comment in between other elements on the same line is disallowed
```
```kotlin
25     open /* SY <-- */val cookieJar = AndroidCookieJar()
26 
27     /* SY --> */
28     open /* SY <-- */val client: OkHttpClient = run {
!!          ^ error
29         val builder = OkHttpClient.Builder()
30             .cookieJar(cookieJar)
31             .connectTimeout(30, TimeUnit.SECONDS)

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/NetworkHelper.kt:72:10
```
A block comment in between other elements on the same line is disallowed
```
```kotlin
69     @Deprecated("The regular client handles Cloudflare by default")
70     @Suppress("UNUSED")
71     /* SY --> */
72     open /* SY <-- */val cloudflareClient: OkHttpClient = client
!!          ^ error
73 
74     fun defaultUserAgentProvider() = preferences.defaultUserAgent().get().trim()
75 }

```

### formatting, MultiLineIfElse (8)

Detects multiline if-else statements without braces

[Documentation](https://detekt.dev/docs/rules/formatting#multilineifelse)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:240:20
```
Missing { ... }
```
```kotlin
237         } catch (zipException: ZipException) {
238             if (zipException.type == ZipException.Type.WRONG_PASSWORD) {
239                 true
240             } else {
!!!                    ^ error
241                 throw zipException
242             }
243         }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:256:4
```
Missing { ... }
```
```kotlin
253         } catch (zipException: ZipException) {
254             if (zipException.type == ZipException.Type.WRONG_PASSWORD) {
255                 false
256             } else {
!!!    ^ error
257                 throw zipException
258             }
259         }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:261:14
```
Missing { ... }
```
```kotlin
258             }
259         }
260     }
261 
!!!              ^ error
262     fun UniFile.addStreamToZip(inputStream: InputStream, filename: String, password: CharArray? = null) {
263         val zipOutputStream =
264             if (password != null) {

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:263:43
```
Missing { ... }
```
```kotlin
260     }
261 
262     fun UniFile.addStreamToZip(inputStream: InputStream, filename: String, password: CharArray? = null) {
263         val zipOutputStream =
!!!                                           ^ error
264             if (password != null) {
265                 ZipOutputStream(this.openOutputStream(), password)
266             } else {

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:281:7
```
Missing { ... }
```
```kotlin
278                 input.copyTo(output)
279             }
280         }
281     }
!!!       ^ error
282 
283     fun UniFile.addFilesToZip(files: List<UniFile>, password: CharArray? = null) {
284         val zipOutputStream =

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:283:23
```
Missing { ... }
```
```kotlin
280         }
281     }
282 
283     fun UniFile.addFilesToZip(files: List<UniFile>, password: CharArray? = null) {
!!!                       ^ error
284         val zipOutputStream =
285             if (password != null) {
286                 ZipOutputStream(this.openOutputStream(), password)

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:319:58
```
Missing { ... }
```
```kotlin
316                 }
317             ) {
318                 if (fileHeader?.fileName == filename) return zipInputStream
319             }
!!!                                                          ^ error
320         } catch (zipException: ZipException) {
321             if (zipException.type == ZipException.Type.WRONG_PASSWORD) {
322                 logcat(LogPriority.WARN) {

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:358:61
```
Missing { ... }
```
```kotlin
355             }
356             return coverHeader?.fileName?.let { getZipInputStream(it) }
357         } catch (zipException: ZipException) {
358             if (zipException.type == ZipException.Type.WRONG_PASSWORD) {
!!!                                                             ^ error
359                 logcat(LogPriority.WARN) {
360                     "Wrong CBZ archive password for: ${this.name} in: ${this.parentFile?.name}"
361                 }

```

### formatting, NoBlankLineBeforeRbrace (2)

Detects blank lines before rbraces

[Documentation](https://detekt.dev/docs/rules/formatting#noblanklinebeforerbrace)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:311:1
```
Unexpected blank line(s) before "}"
```
```kotlin
308         var fileHeader: LocalFileHeader?
309 
310         if (this.isEncryptedZip()) zipInputStream.setPassword(getDecryptedPasswordCbz())
311 
!!! ^ error
312         try {
313             while (run {
314                     fileHeader = zipInputStream.nextEntry

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:346:72
```
Unexpected blank line(s) before "}"
```
```kotlin
343             ) {
344                 fileHeaderList.add(fileHeader)
345             }
346 
!!!                                                                        ^ error
347             var coverHeader = fileHeaderList
348                 .mapNotNull { it }
349                 .sortedWith { f1, f2 -> f1.fileName.compareToCaseInsensitiveNaturalOrder(f2.fileName) }

```

### formatting, NoConsecutiveBlankLines (3)

Reports consecutive blank lines

[Documentation](https://detekt.dev/docs/rules/formatting#noconsecutiveblanklines)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:276:1
```
Needless blank line(s)
```
```kotlin
273         if (password != null) setZipParametersEncrypted(zipParameters)
274         zipOutputStream.putNextEntry(zipParameters)
275 
276         zipOutputStream.use { output ->
!!! ^ error
277             inputStream.use { input ->
278                 input.copyTo(output)
279             }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:281:1
```
Needless blank line(s)
```
```kotlin
278                 input.copyTo(output)
279             }
280         }
281     }
!!! ^ error
282 
283     fun UniFile.addFilesToZip(files: List<UniFile>, password: CharArray? = null) {
284         val zipOutputStream =

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:338:76
```
Needless blank line(s)
```
```kotlin
335 
336         if (this.isEncryptedZip()) zipInputStream.setPassword(getDecryptedPasswordCbz())
337 
338         try {
!!!                                                                            ^ error
339             while (run {
340                     fileHeader = zipInputStream.nextEntry
341                     fileHeader != null

```

### formatting, Wrapping (2)

Reports missing newlines (e.g. between parentheses of a multi-line function call

[Documentation](https://detekt.dev/docs/rules/formatting#wrapping)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:316:17
```
Missing newline before ")"
```
```kotlin
313             while (run {
314                     fileHeader = zipInputStream.nextEntry
315                     fileHeader != null
316                 }
!!!                 ^ error
317             ) {
318                 if (fileHeader?.fileName == filename) return zipInputStream
319             }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:342:9
```
Missing newline before ")"
```
```kotlin
339             while (run {
340                     fileHeader = zipInputStream.nextEntry
341                     fileHeader != null
342                 }
!!!         ^ error
343             ) {
344                 fileHeaderList.add(fileHeader)
345             }

```

### naming, FunctionNaming (1)

Function names should follow the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionnaming)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/Requests.kt:67:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
64         .build()
65 }
66 
67 fun PATCH(
!!     ^ error
68     url: String,
69     headers: Headers = DEFAULT_HEADERS,
70     body: RequestBody = DEFAULT_BODY,

```

### naming, TopLevelPropertyNaming (10)

Top level property names should follow the naming convention set in the projects configuration.

[Documentation](https://detekt.dev/docs/rules/naming#toplevelpropertynaming)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/DohProviders.kt:8:11
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
5  import okhttp3.dnsoverhttps.DnsOverHttps
6  import java.net.InetAddress
7  
8  const val PREF_DOH_ADGUARD = 1
!            ^ error
9  const val PREF_DOH_LIBREDNS = 2
10 const val PREF_DOH_MULLVAD = 3
11 const val PREF_DOH_QUAD9 = 4

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/DohProviders.kt:9:11
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
6  import java.net.InetAddress
7  
8  const val PREF_DOH_ADGUARD = 1
9  const val PREF_DOH_LIBREDNS = 2
!            ^ error
10 const val PREF_DOH_MULLVAD = 3
11 const val PREF_DOH_QUAD9 = 4
12 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/network/DohProviders.kt:10:11
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
7  
8  const val PREF_DOH_ADGUARD = 1
9  const val PREF_DOH_LIBREDNS = 2
10 const val PREF_DOH_MULLVAD = 3
!!           ^ error
11 const val PREF_DOH_QUAD9 = 4
12 
13 // AdGuard "Default" DNS works too but for the sake of making sure no site is blacklisted,

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:-1:-1
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
1 package eu.kanade.tachiyomi.util.storage
2 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:-1:-1
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
1 package eu.kanade.tachiyomi.util.storage
2 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:-1:-1
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
1 package eu.kanade.tachiyomi.util.storage
2 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:365:48
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
362                 return null
363             } else {
364                 throw zipException
365             }
!!!                                                ^ error
366         }
367     }
368 }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:366:18
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
363             } else {
364                 throw zipException
365             }
366         }
!!!                  ^ error
367     }
368 }
369 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:366:51
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
363             } else {
364                 throw zipException
365             }
366         }
!!!                                                   ^ error
367     }
368 }
369 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:369:27
```
Top level constant names should match the pattern: [A-Z][A-Za-z0-9]*
```
```kotlin
366         }
367     }
368 }
369 
!!!                           ^ error
370 private const val BUFFER_SIZE = 2048
371 private const val KEY_SIZE = 256
372 private const val IV_SIZE = 16

```

### style, MagicNumber (10)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/core/security/SecurityPreferences.kt:25:77
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
22     // SY -->
23     fun authenticatorTimeRanges() = this.preferenceStore.getStringSet("biometric_time_ranges", mutableSetOf())
24 
25     fun authenticatorDays() = this.preferenceStore.getInt("biometric_days", 0x7F)
!!                                                                             ^ error
26 
27     fun sqlPassword() = this.preferenceStore.getString(Preference.privateKey("sql_password"), "")
28 

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:144:28
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
141 
142     private fun generateAndEncryptSqlPw() {
143         val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
144         val password = (1..32).map {
!!!                            ^ error
145             charPool[SecureRandom().nextInt(charPool.size)]
146         }.joinToString("", transform = { it.toString() })
147         securityPreferences.sqlPassword().set(encrypt(password, encryptionCipherSql))

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:193:41
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
190     fun createComicInfoPadding(): String? {
191         return if (getPasswordProtectDlPref()) {
192             val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
193             List(SecureRandom().nextInt(100) + 42) { charPool.random() }.joinToString("")
!!!                                         ^ error
194         } else {
195             null
196         }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:193:48
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
190     fun createComicInfoPadding(): String? {
191         return if (getPasswordProtectDlPref()) {
192             val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
193             List(SecureRandom().nextInt(100) + 42) { charPool.random() }.joinToString("")
!!!                                                ^ error
194         } else {
195             null
196         }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/storage/CbzCrypto.kt:222:31
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
219     }
220 
221     fun detectCoverImageArchive(stream: InputStream): Boolean {
222         val bytes = ByteArray(128)
!!!                               ^ error
223         if (stream.markSupported()) {
224             stream.mark(bytes.size)
225             stream.read(bytes, 0, bytes.size).also { stream.reset() }

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/system/ImageUtil.kt:246:29
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
243         val height = imageBitmap.height
244         val width = imageBitmap.width
245 
246         val centerPadding = 96 / (max(1, viewHeight) / height).coerceAtLeast(1)
!!!                             ^ error
247 
248         val leftSourcePart = Rect(0, 0, width / 2, height)
249         val rightSourcePart = Rect(width / 2, 0, width, height)

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/system/ImageUtil.kt:681:55
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
678     fun addPaddingToImageExif(imageFile: File) {
679         try {
680             val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
681             val padding = List(SecureRandom().nextInt(16384) + 16384) { charPool.random() }.joinToString("")
!!!                                                       ^ error
682             val exif = ExifInterface(imageFile.absolutePath)
683             exif.setAttribute("UserComment", padding)
684             exif.saveAttributes()

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/system/ImageUtil.kt:681:64
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
678     fun addPaddingToImageExif(imageFile: File) {
679         try {
680             val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
681             val padding = List(SecureRandom().nextInt(16384) + 16384) { charPool.random() }.joinToString("")
!!!                                                                ^ error
682             val exif = ExifInterface(imageFile.absolutePath)
683             exif.setAttribute("UserComment", padding)
684             exif.saveAttributes()

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/system/ImageUtil.kt:734:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
731         )
732 
733         canvas.drawBitmap(imageBitmap, imageBitmap.rect, upperPart, null)
734         progressCallback?.invoke(98)
!!!                                  ^ error
735         val bottomPart = Rect(
736             if (!isLTR) 0 else width + centerMargin,
737             (maxHeight - height2) / 2,

```

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/tachiyomi/core/common/util/system/ImageUtil.kt:743:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
740         )
741 
742         canvas.drawBitmap(imageBitmap2, imageBitmap2.rect, bottomPart, null)
743         progressCallback?.invoke(99)
!!!                                  ^ error
744 
745         val output = ByteArrayOutputStream()
746         result.compress(Bitmap.CompressFormat.JPEG, 100, output)

```

### style, UnusedPrivateMember (1)

Private function is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivatemember)

* /home/fabse/Repositories/fabsemanga/core/common/src/main/kotlin/eu/kanade/tachiyomi/util/system/DeviceUtil.kt:33:17
```
Private function `getSystemProperty` is unused.
```
```kotlin
30     }
31 
32     @SuppressLint("PrivateApi")
33     private fun getSystemProperty(key: String?): String? {
!!                 ^ error
34         return try {
35             Class.forName("android.os.SystemProperties")
36                 .getDeclaredMethod("get", String::class.java)

```

generated with [detekt version 1.23.5](https://detekt.dev/) on 2024-03-04 17:46:07 UTC
