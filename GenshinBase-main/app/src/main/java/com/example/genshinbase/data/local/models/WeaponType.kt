package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "weaponType")
data class WeaponType(
    @PrimaryKey(autoGenerate = true)
    val weaponTypeId: Long = 0,
    val name: String
)