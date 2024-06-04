package com.example.genshinbase.data.local.util

import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Material
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.RarityUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponTypeUI

object BaseUtil {

    //заполнение данных
    suspend fun insertData(repository: GenshinRepositoryImpl, doSuccess: () -> Unit) {
        val regionMond = repository.insertRegion(RegionUI(0, name = "Мондштадт"))
        val regionLiYe = repository.insertRegion(RegionUI(1, name = "Ли Юэ"))
        val regionInazuma = repository.insertRegion(RegionUI(2, name = "Инадзума"))
        val regionSumeru = repository.insertRegion(RegionUI(3, name = "Сумеру"))
        val regionFontain = repository.insertRegion(RegionUI(4, name = "Фонтейн"))
        val regionNone = repository.insertRegion(RegionUI(5, name = "Не из этого мира"))

        // Вставка данных о типах оружия
        val bowType = repository.insertWeaponType(WeaponTypeUI(0, "Bow"))
        val catalystType = repository.insertWeaponType(WeaponTypeUI(1, "Catalyst"))
        val claymoreType = repository.insertWeaponType(WeaponTypeUI(2, "Claymore"))
        val swordType = repository.insertWeaponType(WeaponTypeUI(4, "Sword"))
        val polearmType = repository.insertWeaponType(WeaponTypeUI(5, "Polearm"))

        // Вставка данных об элементах
        val pyroElement = repository.insertElement(ElementUI(0, "Pyro"))
        val hydroElement = repository.insertElement(ElementUI(1, "Hydro"))
        val electroElement = repository.insertElement(ElementUI(2, "Electro"))
        val cryoElement = repository.insertElement(ElementUI(3, "Cryo"))
        val geoElement = repository.insertElement(ElementUI(4, "Geo"))
        val anemoElement = repository.insertElement(ElementUI(5, "Anemo"))
        val dendroElement = repository.insertElement(ElementUI(6, "Dendro"))

        // Вставка данных о редкости
        val fourStarRarity = repository.insertRarity(RarityUI(0, 4))
        val fiveStarRarity = repository.insertRarity(RarityUI(1, 5))

        // Вставка данных о материалах
        val material1 = repository.insertMaterial(Material(1, "Гриб филанемо", "https://static.wikia.nocookie.net/genshin-impact/images/1/1f/Предмет_Гриб_филанемо.png/revision/latest?cb=20210219225022&path-prefix=ru", "Грибы филанемо можно найти исключительно в регионе Мондштадта. Их можно найти на стенах и крышах домов, особенно в Мондштадте и Спрингвейле. Также грибы можно купить у Клорис в Долине Ветров.", regionMond))
        val material2 = repository.insertMaterial(Material(2, "Лилия калла", "https://static.wikia.nocookie.net/genshin-impact/images/c/cc/Предмет_Лилия_калла.png/revision/latest?cb=20210215163856&path-prefix=ru", "Цветок, растущий у воды. Его лепестки достаточно твёрдые, но после приготовления становятся мягкими, сладкими и немножко горьковатыми на вкус.", regionMond))
        val material3 = repository.insertMaterial(Material(3, "Цветок цинсинь", "https://static.wikia.nocookie.net/genshin-impact/images/9/9a/Предмет_Цветок_цинсинь.png/revision/latest?cb=20210113075451&path-prefix=ru", "Цветок цинсинь можно найти исключительно в регионе Ли Юэ. Цветок цинсинь часто растет на возвышенностях Ли Юэ, особенно на вершинах гор. Также данный цветок можно купить в хижине «Бубу» у Травника Гуя в Ли Юэ и у Бабака в Порт-Ормасе в Сумеру.", regionLiYe))
        val material4 = repository.insertMaterial(Material(4, "Цвет сакуры", "https://static.wikia.nocookie.net/genshin-impact/images/6/6e/Предмет_Цвет_сакуры.png/revision/latest?cb=20210721135039&path-prefix=ru", "В открытом мире цвет сакуры выглядит как облако парящих в воздухе розовых лепестков, которые можно найти по всему острову Наруками; особенно большое скопление лепестков можно встретить на горе Ёго у Великого храма Наруками.", regionInazuma))
        val material5 = repository.insertMaterial(Material(5, "Скарабей", "https://static.wikia.nocookie.net/genshin-impact/images/f/fd/Предмет_Скарабей.png/revision/latest?cb=20220928132528&path-prefix=ru", "Жук, который находит покой в огромном океане песков. Золотой узор на панцире намекает на его глубокую связь с древними руинами, которыми усеяна пустыня.", regionSumeru))
        val material6 = repository.insertMaterial(Material(6, "Лилия Глазурь", "https://static.wikia.nocookie.net/genshin-impact/images/1/1b/%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82_%D0%93%D0%BB%D0%B0%D0%B7%D1%83%D1%80%D0%BD%D0%B0%D1%8F_%D0%BB%D0%B8%D0%BB%D0%B8%D1%8F.png/revision/latest?cb=20210219230610&path-prefix=ru", "Цветок, который излучает свет. В прошлом он использовался для создания специальных свечей.", fourStarRarity))
        val material7 = repository.insertMaterial(Material(7, "Анемон ветреницы", "https://static.wikia.nocookie.net/gensin-impact/images/0/0a/Item_Windwheel_Aster.png", "Цветок, растущий в ветреных местах. Его лепестки крутятся подобно ветряной мельнице.", fourStarRarity))
        val material8 = repository.insertMaterial(Material(8, "Маленькая ламповая трава", "https://static.wikia.nocookie.net/genshin-impact/images/e/e1/%D0%9A%D0%BE%D0%BC%D0%BF%D0%BB%D0%B5%D0%BA%D1%82_%D0%9A%D0%B0%D0%BC%D0%BD%D0%B8_%D0%B8_%D1%82%D1%80%D0%B0%D0%B2%D0%B0.png/revision/latest?cb=20221022155017&path-prefix=ru", "Трава, светящаяся в темноте. Любима авантюристами за свою яркость.", fourStarRarity))
        val material9 = repository.insertMaterial(Material(9, "Сердце Бога", "https://static.wikia.nocookie.net/genshin-impact/images/5/5c/%D0%A1%D0%B5%D1%80%D0%B4%D1%86%D0%B5_%D0%91%D0%BE%D0%B3%D0%B0_%D0%90%D0%BD%D0%B5%D0%BC%D0%BE.png/revision/latest?cb=20221111034638&path-prefix=ru", "Редкий коралл, который можно найти на глубине. Считается талисманом удачи.", fiveStarRarity))
        val material10 = repository.insertMaterial(Material(10, "Ледяной цветок камифубуки", "https://static.wikia.nocookie.net/genshin-impact/images/1/13/%D0%A1%D0%BE%D0%B7%D0%B2%D0%B5%D0%B7%D0%B4%D0%B8%D0%B5_%D0%9B%D0%B5%D0%B4%D1%8F%D0%BD%D0%BE%D0%B9_%D1%86%D0%B2%D0%B5%D1%82%D0%BE%D0%BA_%D0%BA%D0%B0%D0%BC%D0%B8%D1%84%D1%83%D0%B1%D1%83%D0%BA%D0%B8.png/revision/latest?cb=20211206090105&path-prefix=ru", "Редкий цветок, растущий в суровых зимних условиях. Его лепестки сияют, как лед.", fiveStarRarity))

        // Вставка данных об оружии
        val weaponThoma = repository.insertWeapon(Weapon(0, "Копьё Фавония", fourStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/f/fc/Оружие_Копьё_Фавония_Возвышение.png/revision/latest?cb=20210130213806&path-prefix=ru"))
        val weaponGorou = repository.insertWeapon(Weapon(1, "Боевой Лук Фавония", fourStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/7/7c/Оружие_Боевой_лук_Фавония_Возвышение.png/revision/latest?cb=20210123123134&path-prefix=ru"))
        val weaponItto = repository.insertWeapon(Weapon(2, "Краснорогий камнеруб", fourStarRarity, claymoreType, "https://static.wikia.nocookie.net/genshin-impact/images/9/98/Оружие_Краснорогий_камнеруб_Возвышение.png/revision/latest?cb=20211214154256&path-prefix=ru"))
        val weaponYunJin = repository.insertWeapon(Weapon(3, "Небесная ось", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/1/14/Оружие_Небесная_ось_Возвышение.png/revision/latest?cb=20210204170922&path-prefix=ru"))
        val weaponShenhe = repository.insertWeapon(Weapon(4, "Усмиритель бед", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/d/de/Оружие_Усмиритель_бед_Возвышение.png/revision/latest?cb=20220105055008&path-prefix=ru"))
        val weaponYae = repository.insertWeapon(Weapon(5, "Истина кагура", fiveStarRarity, catalystType, "https://static.wikia.nocookie.net/genshin-impact/images/1/16/Оружие_Истина_кагура_Возвышение.png/revision/latest?cb=20220216100108&path-prefix=ru"))
        val weaponAyato = repository.insertWeapon(Weapon(6, "Харан гэппаку фуцу", fiveStarRarity, swordType, "https://static.wikia.nocookie.net/genshin-impact/images/a/a2/Оружие_Харан_гэппаку_фуцу_Возвышение.png/revision/latest?cb=20220330082554&path-prefix=ru"))
        val weaponYelan = repository.insertWeapon(Weapon(7, "Аква симулякрум", fiveStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/5/51/Оружие_Аква_симулякрум_Возвышение.png/revision/latest?cb=20220531142404&path-prefix=ru"))
        val weaponAloy = repository.insertWeapon(Weapon(8, "Хищник", fourStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/7/73/Оружие_Хищник_Возвышение.png/revision/latest?cb=20210908105809&path-prefix=ru"))

        // Вставка данных о персонажах
        val characters = listOf(
            CharacterModel(1, "Тома", weaponThoma, regionInazuma, fourStarRarity, pyroElement, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Thoma_Game.png", "Тома — верный домоправитель клана Камисато, известный своей надежностью и доброжелательностью."),
            CharacterModel(2, "Горо", weaponGorou, regionInazuma, fourStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/f/f4/Character_Gorou_Game.png", "Горо — смелый и надежный генерал армии Ватадзуми, всегда готов защищать своих товарищей."),
            CharacterModel(3, "Итто", weaponItto, regionInazuma, fiveStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/a/ae/Character_Arataki_Itto_Game.png", "Итто — лидер банды Аратаки, известный своей мощной силой и беззаботным характером."),
            CharacterModel(4, "Юнь Цзинь ", weaponYunJin, regionLiYe, fourStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/a/a2/Character_Yun_Jin_Game.png", "Юнь Цзинь — талантливая актриса из Ли Юэ, сочетающая традиции и современность в своих выступлениях."),
            CharacterModel(5, "Шень Хэ", weaponShenhe, regionLiYe, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/gensin-impact/images/3/35/Character_Shenhe_Game.png", "Шэньхэ — загадочная воительница из Ли Юэ, обладающая мощной ледяной силой."),
            CharacterModel(6, "Яэ Мико", weaponYae, regionInazuma, fiveStarRarity, electroElement, "https://static.wikia.nocookie.net/gensin-impact/images/d/d1/Character_Yae_Miko_Game.png", "Яэ Мико — умная и загадочная жрица Гранд Наруками, владеющая электро элементом."),
            CharacterModel(7, "Аято", weaponAyato, regionInazuma, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/gensin-impact/images/8/8f/Character_Kamisato_Ayato_Game.png", "Аято Камисато — глава клана Камисато, известный своей мудростью и стратегическим мышлением."),
            CharacterModel(8, "Е Лань", weaponYelan, regionLiYe, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Yelan_Game.png", "Е Лань — таинственная и элегантная разведчица, обладающая мастерством обращения с луком."),
            CharacterModel(9, "Элой", weaponAloy, regionNone, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/gensin-impact/images/3/34/Character_Aloy_Game.png", "Элой — охотница из другого мира, сражающаяся с механическими существами и владеющая крио силой.")
        )

        characters.forEach {
            repository.insertCharacterModel(it)
        }
        doSuccess()
    }
}
