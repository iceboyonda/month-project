package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "element")
data class Element(
    @PrimaryKey(autoGenerate = true)
    val elementId: Long = 1,
    val name: String
)