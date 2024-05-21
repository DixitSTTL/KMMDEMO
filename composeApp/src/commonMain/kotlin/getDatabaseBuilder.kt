import androidx.room.RoomDatabase
import common.database.AppDatabase
import org.koin.core.KoinApplication

expect fun getDatabaseBuilder(applicationContext: KoinApplication): RoomDatabase.Builder<AppDatabase>
