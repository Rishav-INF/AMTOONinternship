//import androidx.room.Database

//                    TRIED TO IMPLEMENT BUT LACK OF KNOWLEDGE :(

//import androidx.room.Room
//import androidx.room.RoomDatabase
//import android.content.Context
//
//@Database(entities = [dataclassmanga::class], version = 1, exportSchema = false)
//abstract class MangaDatabase : RoomDatabase() {
//    abstract fun mangaDao(): MangaDao // Access to DAO
//    companion object {
//        @Volatile
//        private var INSTANCE: MangaDatabase? = null
//
//        fun getDatabase(context: Context): MangaDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MangaDatabase::class.java,
//                    "manga_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
