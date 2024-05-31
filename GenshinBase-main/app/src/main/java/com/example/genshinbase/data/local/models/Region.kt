package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "region")
class Region (
    @PrimaryKey(autoGenerate = true)
    val regionId: Long = 0,
    val name: String,
)