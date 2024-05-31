package com.example.genshinbase.data.local.util

import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.RarityUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponTypeUI

object BaseUtil {

    suspend fun insertCharacters(repository: GenshinRepositoryImpl, doSuccess: () -> Unit) {
        val regionTest = repository.insertRegion(RegionUI(0, name = "Test"))
        // Вставка данных о типах оружия
        val bowType = repository.insertWeaponType(WeaponTypeUI(0, "Bow"))
        val catalystType = repository.insertWeaponType(WeaponTypeUI(0, "Catalyst"))
        val claymoreType = repository.insertWeaponType(WeaponTypeUI(0, "Claymore"))
        val swordType = repository.insertWeaponType(WeaponTypeUI(0, "Sword"))
        val polearmType = repository.insertWeaponType(WeaponTypeUI(0, "Polearm"))

        // Вставка данных об элементах
        val pyroElement = repository.insertElement(ElementUI(0, "Pyro"))
        val hydroElement = repository.insertElement(ElementUI(0, "Hydro"))
        val electroElement = repository.insertElement(ElementUI(0, "Electro"))
        val cryoElement = repository.insertElement(ElementUI(0, "Cryo"))
        val geoElement = repository.insertElement(ElementUI(0, "Geo"))
        val anemoElement = repository.insertElement(ElementUI(0, "Anemo"))
        val noneElement = repository.insertElement(ElementUI(0, "None"))

        // Вставка данных о редкости
        val fourStarRarity = repository.insertRarity(RarityUI(0, 4))
        val fiveStarRarity = repository.insertRarity(RarityUI(0, 5))

        // Вставка данных о персонажах
        val characters = listOf(
            CharacterUI(1, "Thoma", polearmType.weaponTypeId, 0, fourStarRarity.rarityId, pyroElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Thoma_Game.png"),
            CharacterUI(2, "Gorou", bowType.weaponTypeId, 0, fourStarRarity.rarityId, geoElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/f/f4/Character_Gorou_Game.png"),
            CharacterUI(3, "Itto", claymoreType.weaponTypeId, 0, fiveStarRarity.rarityId, geoElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/a/ae/Character_Arataki_Itto_Game.png"),
            CharacterUI(4, "Yun Jin", polearmType.weaponTypeId, 0, fourStarRarity.rarityId, geoElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/a/a2/Character_Yun_Jin_Game.png"),
            CharacterUI(5, "Shenhe", polearmType.weaponTypeId, 0, fiveStarRarity.rarityId, cryoElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/3/35/Character_Shenhe_Game.png"),
            CharacterUI(6, "Yae", catalystType.weaponTypeId, 0, fiveStarRarity.rarityId, electroElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/d/d1/Character_Yae_Miko_Game.png"),
            CharacterUI(7, "Ayato", swordType.weaponTypeId, 0, fiveStarRarity.rarityId, hydroElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/8/8f/Character_Kamisato_Ayato_Game.png"),
            CharacterUI(8, "Yelan", bowType.weaponTypeId, 0, fiveStarRarity.rarityId, hydroElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Yelan_Game.png"),
                CharacterUI(9, "Aloy", bowType.weaponTypeId, 0, fiveStarRarity.rarityId, cryoElement.elementId, "https://static.wikia.nocookie.net/gensin-impact/images/3/34/Character_Aloy_Game.png")
        )

        characters.forEach {
            repository.insertCharacter(it)
        }
        doSuccess()
    }

}