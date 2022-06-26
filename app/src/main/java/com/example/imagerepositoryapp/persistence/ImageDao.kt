package com.example.imagerepositoryapp.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imagerepositoryapp.Image

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageList(Images:List<Image>)

    @Query("SELECT * from IMAGE WHERE id=:id_")
    fun getImage(id_ :Long):LiveData<Image>

    @Query("SELECT * FROM IMAGE WHERE")
    suspend fun getImageList():List<Image>
}