package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "rarity")
data class Rarity(
    @PrimaryKey(autoGenerate = false)
    val rarityId: Long = 0,
    val starts: Int
)