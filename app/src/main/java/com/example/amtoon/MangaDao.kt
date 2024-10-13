
//                    TRIED TO IMPLEMENT BUT LACK OF KNOWLEDGE :(

//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//@Dao
//interface MangaDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertManga(manga: dataclassmanga)
//
//    @Query("SELECT * FROM manga_table WHERE id = :mangaId LIMIT 1")
//    suspend fun getMangaById(mangaId: String): dataclassmanga?
//
//    @Query("SELECT * FROM manga_table WHERE isFavorite = 1")
//    suspend fun getAllFavorites(): List<dataclassmanga>
//
//    @Query("DELETE FROM manga_table WHERE id = :mangaId")
//    suspend fun deleteManga(mangaId: String)
//
//    @Query("SELECT COUNT(*) FROM manga_table WHERE id = :mangaId")
//    suspend fun isPresent(mangaId: String): Int // Returns the count of the manga item
//}
