package tachiyomi.domain.manga.interactor

import tachiyomi.domain.manga.repository.CustomMangaRepository

class GetCustomMangaInfo(
    private val customMangaRepository: CustomMangaRepository,
) {

    fun get(mangaId: Long) = customMangaRepository.get(mangaId)
}
