package com.example.genshinbase.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "character",
    foreignKeys = [
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
    val characterId: Long = 1,
    val name: String,
    val weaponId: Long,
    val regionId: Long,
    val rarityId: Long,
    val elementId: Long,
    val url: String,
    val description: String
)