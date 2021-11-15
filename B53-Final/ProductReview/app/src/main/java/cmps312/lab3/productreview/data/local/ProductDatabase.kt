package cmps312.lab3.productreview.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [/* add entities here*/], version = 2, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {


    abstract fun productDao(): ProductDao



    companion object {
        @Volatile
        private var database: ProductDatabase? = null


        @Synchronized
        fun getDatabase(context: Context): ProductDatabase {
            if (database == null) {
                database = Room.databaseBuilder(context.applicationContext,
                    ProductDatabase::class.java,
                    "product_db")
                    .fallbackToDestructiveMigration().build()
            }
            return database as ProductDatabase
        }
    }
}