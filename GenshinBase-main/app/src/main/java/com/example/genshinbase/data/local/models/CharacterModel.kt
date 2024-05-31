package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "character",
    foreignKeys = [
        ForeignKey(
            entity = WeaponType::class,
            parentColumns = ["weaponTypeId"],
            childColumns = ["weaponTypeId"],
            onDelete = ForeignKey.CASCADE
        ),
//        ForeignKey(
//            entity = Region::class,
//            parentColumns = ["regionId"],
//            childColumns = ["regionId"],
//            onDelete = ForeignKey.CASCADE
//        ),
        ForeignKey(
            entity = Rarity::class,
            parentColumns = ["rarityId"],
            childColumns = ["rarityId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Element::class,
            parentColumns = ["elementId"],
            childColumns = ["elementId"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
)
data class CharacterModel(
    @PrimaryKey(autoGenerate = true)
    val characterId: Long = 0,
    val name: String,
    val weaponTypeId: Long,
    val regionId: Long,
    val rarityId: Long,
    val elementId: Long,
    val url: String
)