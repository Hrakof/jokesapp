package com.example.jokesapp.data.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
class RoomJoke {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}