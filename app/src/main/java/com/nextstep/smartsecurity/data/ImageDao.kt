package com.nextstep.smartsecurity.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(image: Image)

    @Query("SELECT * FROM images ORDER BY timestamp DESC")
    fun getAllImages(): LiveData<List<Image>>

    @Query("SELECT * FROM images WHERE cameraId = :id LIMIT 1")
    suspend fun getImageById(id: Int): Image?
}