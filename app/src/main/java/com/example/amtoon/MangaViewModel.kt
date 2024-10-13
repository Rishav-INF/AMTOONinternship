

//                    TRIED TO IMPLEMENT BUT LACK OF KNOWLEDGE :(

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope

//import kotlinx.coroutines.launch
//
//class MangaViewModel(private val repository: MangaRepository) : ViewModel() {
//
//    // This function will handle adding/removing manga from favorites
//    fun toggleFavorite(manga: dataclassmanga) {
//        viewModelScope.launch {
//            if (repository.isMangaFavorite(manga.id)) {
//                // If it's already in the database, remove it
//                repository.deleteManga(manga.id)
//            } else {
//                // If it's not in the database, add it
//                repository.insertManga(manga)
//            }
//        }
//    }
//
//    // Other ViewModel functions can remain unchanged
//}
