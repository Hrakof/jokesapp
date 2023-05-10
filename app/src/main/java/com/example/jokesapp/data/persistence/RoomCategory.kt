package com.example.jokesapp.data.persistence

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "categories", indices = [Index(value = ["name"], unique = true)])
data class RoomCategory (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
)