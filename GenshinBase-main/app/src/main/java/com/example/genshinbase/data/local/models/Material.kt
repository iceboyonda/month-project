package com.example.genshinbase.data.local.models

import androidx.compose.runtime.Composable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "material")
data class Material(
    @PrimaryKey(autoGenerate = false)
    val materialId: Long,
    val title: String,
    val url: String,
    val description: String,
    val rarityId: Long
)