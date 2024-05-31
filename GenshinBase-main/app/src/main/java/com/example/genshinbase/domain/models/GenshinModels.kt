package com.example.genshinbase.domain.models

data class CharacterUI(
    val characterId: Long,
    val name: String,
    val weaponTypeId: Long,
    val regionId: Long,
    val rarity: Long,
    val elementId: Long,
    val url: String
)

data class ElementUI(
    val elementId: Long,
    val name: String
)

data class RarityUI(
    val rarityId: Long,
    val stars: Int
)

data class RegionUI(
    val regionId: Long,
    val name: String
)

data class WeaponTypeUI(
    val weaponTypeId: Long,
    val name: String
)

data class WeaponUI(
    val weaponId: Long,
    val name: String,
    val rarityId: Long,
    val weaponTypeId: Long
)