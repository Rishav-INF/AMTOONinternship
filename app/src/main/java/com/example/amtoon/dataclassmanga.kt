import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "manga_table")
data class dataclassmanga(
    @PrimaryKey val id: String,
    val title: String,
    val creator: String,
    val description: String,
    val episodes: Int,
    val imageLink: String,
    val reads: Int,
    val release: String,
    val isFavorite: Boolean // Make sure this matches the type and name used in the database
)
