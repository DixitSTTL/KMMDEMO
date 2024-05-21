package common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import androidx.sqlite.execSQL
import common.data.model.DataEmployee
import common.data.model.DataMoreCars
import common.database.dao.CarDao
import common.database.dao.EmployeeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [DataMoreCars::class, DataEmployee::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
    abstract fun carDao(): CarDao
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {

        override fun migrate(connection: SQLiteConnection) {
            connection.execSQL(
                "CREATE TABLE IF NOT EXISTS `DataEmployee` (" +
                        "`id` INTEGER PRIMARY KEY NOT NULL," +
                        "`name` TEXT NOT NULL," +
                        "`department` TEXT NOT NULL)"
            );
        }
    }
    return builder
        .addMigrations(MIGRATION_1_2)
        .fallbackToDestructiveMigrationFrom(true)
        .fallbackToDestructiveMigration(true)
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}