package com.example.genshinbase.data.local.repositoryImpl

import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Element
import com.example.genshinbase.data.local.models.Material
import com.example.genshinbase.data.local.models.Rarity
import com.example.genshinbase.data.local.models.Region
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.models.WeaponType
import com.example.genshinbase.data.local.repository.GenshinRepository
import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.MaterialUI
import com.example.genshinbase.domain.models.RarityUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponTypeUI
import com.example.genshinbase.domain.models.WeaponUI
import javax.inject.Inject


//Обрабатываем запросы с БД, чтобы вернуть ответ на экран
class GenshinRepositoryImpl @Inject constructor(private val genshinRepository: GenshinRepository) {

    suspend fun insertCharacterModel(characterModel: CharacterModel): Long {
        return genshinRepository.insert(characterModel)
    }

    suspend fun getCharacterById(id: Long): CharacterUI {
        val character = genshinRepository.getCharacterById(id)
        val weapon = genshinRepository.getWeaponById(character.weaponId)
        val region = genshinRepository.getRegionById(character.regionId)
        val element = genshinRepository.getElementById(character.elementId)
        val rarity = genshinRepository.getRarityById(character.rarityId)
        val weaponRarity = genshinRepository.getRarityById(weapon.rarityId)
        return character.let {
            CharacterUI(
                characterId = it.characterId,
                name = it.name,
                region = RegionUI(regionId = region.regionId, name = region.name),
                rarity = rarity.starts.toLong(),
                element = ElementUI(elementId = element.elementId, name = element.name),
                url = it.url,
                weapon = weapon.let {
                    WeaponUI(
                        weaponId = it.weaponId,
                        name = it.name,
                        rarity = weaponRarity.starts.toLong(),
                        weaponTypeId = it.weaponTypeId,
                        url = it.url
                    )
                },
                description = it.description
            )
        }
    }

    suspend fun getAllCharacters(): List<CharacterUI> {
        val characters = genshinRepository.getAllCharacters()
        return characters.map {
            val character = it
            val weapon = genshinRepository.getWeaponById(character.weaponId)
            val region = genshinRepository.getRegionById(character.regionId)
            val element = genshinRepository.getElementById(character.elementId)
            val rarity = genshinRepository.getRarityById(character.rarityId)
            val weaponRarity = genshinRepository.getRarityById(weapon.rarityId)
            character.let {
                println(it)
                CharacterUI(
                    characterId = it.characterId,
                    name = it.name,
                    region = RegionUI(regionId = region.regionId, name = region.name),
                    rarity = rarity.starts.toLong(),
                    element = ElementUI(elementId = element.elementId, name = element.name),
                    url = it.url,
                    weapon = weapon.let {
                        WeaponUI(
                            weaponId = it.weaponId,
                            name = it.name,
                            rarity = weaponRarity.starts.toLong(),
                            weaponTypeId = it.weaponTypeId,
                            url = it.url
                        )
                    },
                    description = it.description
                )
            }
        }
    }


    suspend fun insertElement(elementUI: ElementUI): Long {
        val element = Element(
            elementId = elementUI.elementId,
            name = elementUI.name
        )
        val id = genshinRepository.insert(element)
        return id
    }


    suspend fun insertRarity(rarityUI: RarityUI): Long {
        val rarity = Rarity(
            rarityId = rarityUI.rarityId,
            starts = rarityUI.stars
        )
        val id = genshinRepository.insert(rarity)
        return id
    }


    suspend fun insertRegion(regionUI: RegionUI): Long {
        val region = Region(
            regionId = regionUI.regionId,
            name = regionUI.name
        )
        return genshinRepository.insert(region)
    }


    suspend fun insertWeaponType(weaponTypeUI: WeaponTypeUI): Long {
        val weaponType = WeaponType(
            weaponTypeId = weaponTypeUI.weaponTypeId,
            name = weaponTypeUI.name
        )
        val weaponTypeId = genshinRepository.insert(weaponType)
        return weaponTypeId
    }

    suspend fun insertWeapon(weaponModel: Weapon): Long {

        val weapon = Weapon(
            weaponId = weaponModel.weaponId,
            name = weaponModel.name,
            rarityId = weaponModel.rarityId,
            weaponTypeId = weaponModel.weaponTypeId,
            url = weaponModel.url
        )
        return genshinRepository.insert(weapon)
    }


    suspend fun getAllWeapons(): List<WeaponUI> {
        val weapons = genshinRepository.getAllWeapons()
        return weapons.map {
            val rarity = genshinRepository.getRarityById(it.rarityId)
            WeaponUI(
                weaponId = it.weaponId,
                name = it.name,
                rarity = rarity.starts.toLong(),
                weaponTypeId = it.weaponTypeId,
                url = it.url
            )
        }
    }

    suspend fun getAllMaterial(): List<MaterialUI> {
        val material = genshinRepository.getAllMaterial()

        return material.map {
            val rarity = genshinRepository.getRarityById(it.rarityId)
            MaterialUI(it.materialId, it.title, it.url, it.description, rarity.starts.toLong())
        }
    }

    suspend fun queryMaterial(query: String): List<MaterialUI> {
        val material = genshinRepository.searchMaterial("%$query%")
        return material.map {
            val rarity = genshinRepository.getRarityById(it.rarityId)
            MaterialUI(it.materialId, it.title, it.url, it.description, rarity.starts.toLong())
        }
    }

    suspend fun insertMaterial(material: Material): Long {
        val materialId = genshinRepository.insertMaterial(material)
        return materialId
    }

    suspend fun getMaterialById(id: Long): MaterialUI {
        val it = genshinRepository.getMaterialById(id)
        val rarity = genshinRepository.getRarityById(it.rarityId)
        return MaterialUI(
            it.materialId, it.title, it.url, it.description, rarity.starts.toLong()
        )
    }

}