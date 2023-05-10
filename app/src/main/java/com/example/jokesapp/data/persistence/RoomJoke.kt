package com.example.jokesapp.data.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class RoomJoke (
    @PrimaryKey
    var id: String,

    var text: String,
    @ColumnInfo(name = "category_name")
    var categoryName: String,
)