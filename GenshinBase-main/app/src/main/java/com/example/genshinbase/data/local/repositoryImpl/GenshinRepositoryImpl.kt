package com.example.genshinbase.data.local.repositoryImpl

import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Element
import com.example.genshinbase.data.local.models.Rarity
import com.example.genshinbase.data.local.models.Region
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.models.WeaponType
import com.example.genshinbase.data.local.repository.GenshinRepository
import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.RarityUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponTypeUI
import com.example.genshinbase.domain.models.WeaponUI
import javax.inject.Inject

class GenshinRepositoryImpl @Inject constructor(private val genshinRepository: GenshinRepository) {

    suspend fun insertCharacter(characterUI: CharacterUI): Long {
        val character = CharacterModel(
            name = characterUI.name,
            weaponTypeId = characterUI.weaponTypeId,
            regionId = characterUI.regionId,
            rarityId = characterUI.rarity,
            elementId = characterUI.elementId,
            url = characterUI.url
        )
        return genshinRepository.insert(character)
    }

    suspend fun getCharacterById(id: Long): CharacterUI? {
        val character = genshinRepository.getCharacterById(id)
        return character?.let {
            CharacterUI(
                characterId = it.characterId,
                name = it.name,
                weaponTypeId = it.weaponTypeId,
                regionId = it.regionId,
                rarity = it.rarityId,
                elementId = it.elementId,
                url = it.url
            )
        }
    }

    suspend fun getAllCharacters(): List<CharacterUI> {
        val characters = genshinRepository.getAllCharacters()
        return characters.map {
            val rarity = genshinRepository.getRarityById(it.rarityId)
            CharacterUI(
                characterId = it.characterId,
                name = it.name,
                weaponTypeId = it.weaponTypeId,
                regionId = it.regionId,
                rarity = (rarity?.starts?: 1).toLong(),
                elementId = it.elementId,
                url = it.url
            )
        }
    }

    suspend fun deleteCharacter(characterUI: CharacterUI) {
        val character = CharacterModel(
            characterId = characterUI.characterId,
            name = characterUI.name,
            weaponTypeId = characterUI.weaponTypeId,
            regionId = characterUI.regionId,
            rarityId = characterUI.rarity,
            elementId = characterUI.elementId,
            url = characterUI.url
        )
        genshinRepository.delete(character)
    }

    suspend fun insertElement(elementUI: ElementUI): Element {
        val element = Element(
            name = elementUI.name
        )
        val id = genshinRepository.insert(element)
        return element.copy(elementId = id)
    }

    suspend fun getElementById(id: Long): ElementUI? {
        val element = genshinRepository.getElementById(id)
        return element?.let {
            ElementUI(
                elementId = it.elementId,
                name = it.name
            )
        }
    }

    suspend fun getAllElements(): List<ElementUI> {
        val elements = genshinRepository.getAllElements()
        return elements.map {
            ElementUI(
                elementId = it.elementId,
                name = it.name
            )
        }
    }

    suspend fun deleteElement(elementUI: ElementUI) {
        val element = Element(
            elementId = elementUI.elementId,
            name = elementUI.name
        )
        genshinRepository.delete(element)
    }

    suspend fun insertRarity(rarityUI: RarityUI): Rarity {
        val rarity = Rarity(
            starts = rarityUI.stars
        )
        val id = genshinRepository.insert(rarity)
        return rarity.copy(
            rarityId = id
        )
    }

    suspend fun getRarityById(id: Long): RarityUI? {
        val rarity = genshinRepository.getRarityById(id)
        return rarity?.let {
            RarityUI(
                rarityId = it.rarityId,
                stars = it.starts
            )
        }
    }

    suspend fun getAllRarities(): List<RarityUI> {
        val rarities = genshinRepository.getAllRarities()
        return rarities.map {
            RarityUI(
                rarityId = it.rarityId,
                stars = it.starts
            )
        }
    }

    suspend fun deleteRarity(rarityUI: RarityUI) {
        val rarity = Rarity(
            rarityId = rarityUI.rarityId,
            starts = rarityUI.stars
        )
        genshinRepository.delete(rarity)
    }

    suspend fun insertRegion(regionUI: RegionUI): Long {
        val region = Region(
            name = regionUI.name
        )
        return genshinRepository.insert(region)
    }

    suspend fun getRegionById(id: Long): RegionUI? {
        val region = genshinRepository.getRegionById(id)
        return region?.let {
            RegionUI(
                regionId = it.regionId,
                name = it.name
            )
        }
    }

    suspend fun getAllRegions(): List<RegionUI> {
        val regions = genshinRepository.getAllRegions()
        return regions.map {
            RegionUI(
                regionId = it.regionId,
                name = it.name
            )
        }
    }

    suspend fun deleteRegion(regionUI: RegionUI) {
        val region = Region(
            regionId = regionUI.regionId,
            name = regionUI.name
        )
        genshinRepository.delete(region)
    }

    suspend fun insertWeaponType(weaponTypeUI: WeaponTypeUI): WeaponType {
        val weaponType = WeaponType(
            name = weaponTypeUI.name
        )
        val weaponTypeId = genshinRepository.insert(weaponType)
        return weaponType.copy(weaponTypeId = weaponTypeId)
    }

    suspend fun getWeaponTypeById(id: Long): WeaponTypeUI? {
        val weaponType = genshinRepository.getWeaponTypeById(id)
        return weaponType?.let {
            WeaponTypeUI(
                weaponTypeId = it.weaponTypeId,
                name = it.name
            )
        }
    }

    suspend fun getAllWeaponTypes(): List<WeaponTypeUI> {
        val weaponTypes = genshinRepository.getAllWeaponTypes()
        return weaponTypes.map {
            WeaponTypeUI(
                weaponTypeId = it.weaponTypeId,
                name = it.name
            )
        }
    }

    suspend fun deleteWeaponType(weaponTypeUI: WeaponTypeUI) {
        val weaponType = WeaponType(
            weaponTypeId = weaponTypeUI.weaponTypeId,
            name = weaponTypeUI.name
        )
        genshinRepository.delete(weaponType)
    }

    suspend fun insertWeapon(weaponUI: WeaponUI): Long {
        val weapon = Weapon(
            name = weaponUI.name,
            rarityId = weaponUI.rarityId,
            weaponTypeId = weaponUI.weaponTypeId
        )
        return genshinRepository.insert(weapon)
    }

    suspend fun getWeaponById(id: Long): WeaponUI? {
        val weapon = genshinRepository.getWeaponById(id)
        return weapon?.let {
            WeaponUI(
                weaponId = it.weaponId,
                name = it.name,
                rarityId = it.rarityId,
                weaponTypeId = it.weaponTypeId
            )
        }
    }

    suspend fun getAllWeapons(): List<WeaponUI> {
        val weapons = genshinRepository.getAllWeapons()
        return weapons.map {
            WeaponUI(
                weaponId = it.weaponId,
                name = it.name,
                rarityId = it.rarityId,
                weaponTypeId = it.weaponTypeId
            )
        }
    }

    suspend fun deleteWeapon(weaponUI: WeaponUI) {
        val weapon = Weapon(
            weaponId = weaponUI.weaponId,
            name = weaponUI.name,
            rarityId = weaponUI.rarityId,
            weaponTypeId = weaponUI.weaponTypeId
        )
        genshinRepository.delete(weapon)
    }

}