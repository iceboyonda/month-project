package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "weapon", foreignKeys = [
    ForeignKey(
        entity = Rarity::class,
        parentColumns = ["rarityId"],
        childColumns = ["rarityId"],
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = WeaponType::class,
        parentColumns = ["weaponTypeId"],
        childColumns = ["weaponTypeId"],
        onDelete = ForeignKey.CASCADE
    ),
])
data class Weapon(
    @PrimaryKey(autoGenerate = true)
    val weaponId: Long = 0,
    val name: String,
    val rarityId: Long,
    val weaponTypeId: Long,
)