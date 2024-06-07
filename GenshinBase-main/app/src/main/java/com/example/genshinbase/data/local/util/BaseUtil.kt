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

    //заполнение данныъ
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
        val noneElement = repository.insertElement(ElementUI(6, "None"))

        // Вставка данных о редкости
        val fourStarRarity = repository.insertRarity(RarityUI(0, 4))
        val fiveStarRarity = repository.insertRarity(RarityUI(1, 5))

        // Вставка данных о материалах
        val material1 = repository.insertMaterial(Material(1, "Филанемо гриб", "https://static.wikia.nocookie.net/genshin-impact/images/1/1f/%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82_%D0%93%D1%80%D0%B8%D0%B1_%D1%84%D0%B8%D0%BB%D0%B0%D0%BD%D0%B5%D0%BC%D0%BE.png/revision/latest?cb=20210219225022&path-prefix=ru", "Гриб, растущий в тени крыш. Является любимым материалом для приготовления лекарств у горожан Мондштадта.", fourStarRarity))
        val material2 = repository.insertMaterial(Material(2, "Лилия Калла", "https://static.wikia.nocookie.net/genshin-impact/images/c/cc/%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82_%D0%9B%D0%B8%D0%BB%D0%B8%D1%8F_%D0%BA%D0%B0%D0%BB%D0%BB%D0%B0.png/revision/latest?cb=20210215163856&path-prefix=ru", "Цветок, растущий у водоемов. Его свежий вкус делает его популярным ингредиентом для готовки.", fourStarRarity))
        val material3 = repository.insertMaterial(Material(3, "Фиолетовая трава", "https://static.wikia.nocookie.net/genshin-impact/images/f/fa/%D0%94%D0%B5%D0%BA%D0%BE%D1%80_%D0%9C%D1%80%D0%B0%D1%87%D0%BD%D0%BE%D0%B5_%D0%B2%D0%B5%D0%BB%D0%B8%D0%BA%D0%BE%D0%BB%D0%B5%D0%BF%D0%B8%D0%B5.png/revision/latest?cb=20221102161057&path-prefix=ru", "Трава, растущая на высоких утесах. Обладает сильными лечебными свойствами.", fourStarRarity))
        val material4 = repository.insertMaterial(Material(4, "Цветок Сесилии", "https://static.wikia.nocookie.net/genshin-impact/images/4/42/%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82_%D0%A1%D0%B5%D1%81%D0%B8%D0%BB%D0%B8%D1%8F.png/revision/latest?cb=20210505072548&path-prefix=ru", "Цветок, который растет только на Ветряной террасе. Нежный, но устойчивый к погодным условиям.", fourStarRarity))
        val material5 = repository.insertMaterial(Material(5, "Перец цзеюнь", "https://static.wikia.nocookie.net/genshin-impact/images/1/14/%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82_%D0%9F%D0%B5%D1%80%D0%B5%D1%86.png/revision/latest?cb=20201122082221&path-prefix=ru", "Перец, растущий в горах. Его жгучий вкус придает силу.", fourStarRarity))
        val material6 = repository.insertMaterial(Material(6, "Лилия Глазурь", "https://static.wikia.nocookie.net/genshin-impact/images/1/1b/%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82_%D0%93%D0%BB%D0%B0%D0%B7%D1%83%D1%80%D0%BD%D0%B0%D1%8F_%D0%BB%D0%B8%D0%BB%D0%B8%D1%8F.png/revision/latest?cb=20210219230610&path-prefix=ru", "Цветок, который излучает свет. В прошлом он использовался для создания специальных свечей.", fourStarRarity))
        val material7 = repository.insertMaterial(Material(7, "Анемон ветреницы", "https://static.wikia.nocookie.net/gensin-impact/images/0/0a/Item_Windwheel_Aster.png", "Цветок, растущий в ветреных местах. Его лепестки крутятся подобно ветряной мельнице.", fourStarRarity))
        val material8 = repository.insertMaterial(Material(8, "Маленькая ламповая трава", "https://static.wikia.nocookie.net/genshin-impact/images/e/e1/%D0%9A%D0%BE%D0%BC%D0%BF%D0%BB%D0%B5%D0%BA%D1%82_%D0%9A%D0%B0%D0%BC%D0%BD%D0%B8_%D0%B8_%D1%82%D1%80%D0%B0%D0%B2%D0%B0.png/revision/latest?cb=20221022155017&path-prefix=ru", "Трава, светящаяся в темноте. Любима авантюристами за свою яркость.", fourStarRarity))
        val material9 = repository.insertMaterial(Material(9, "Сердце Бога", "https://static.wikia.nocookie.net/genshin-impact/images/5/5c/%D0%A1%D0%B5%D1%80%D0%B4%D1%86%D0%B5_%D0%91%D0%BE%D0%B3%D0%B0_%D0%90%D0%BD%D0%B5%D0%BC%D0%BE.png/revision/latest?cb=20221111034638&path-prefix=ru", "Редкий коралл, который можно найти на глубине. Считается талисманом удачи.", fiveStarRarity))
        val material10 = repository.insertMaterial(Material(10, "Ледяной цветок камифубуки", "https://static.wikia.nocookie.net/genshin-impact/images/1/13/%D0%A1%D0%BE%D0%B7%D0%B2%D0%B5%D0%B7%D0%B4%D0%B8%D0%B5_%D0%9B%D0%B5%D0%B4%D1%8F%D0%BD%D0%BE%D0%B9_%D1%86%D0%B2%D0%B5%D1%82%D0%BE%D0%BA_%D0%BA%D0%B0%D0%BC%D0%B8%D1%84%D1%83%D0%B1%D1%83%D0%BA%D0%B8.png/revision/latest?cb=20211206090105&path-prefix=ru", "Редкий цветок, растущий в суровых зимних условиях. Его лепестки сияют, как лед.", fiveStarRarity))

        val weaponThoma = repository.insertWeapon(Weapon(1, "Копьё Фавония", fourStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/f/fc/Оружие_Копьё_Фавония_Возвышение.png/revision/latest?cb=20210130213806&path-prefix=ru"))
        val weaponGorou = repository.insertWeapon(Weapon(2, "Боевой Лук Фавония", fourStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/7/7c/Оружие_Боевой_лук_Фавония_Возвышение.png/revision/latest?cb=20210123123134&path-prefix=ru"))
        val weaponItto = repository.insertWeapon(Weapon(3, "Краснорогий камнеруб", fourStarRarity, claymoreType, "https://static.wikia.nocookie.net/genshin-impact/images/9/98/Оружие_Краснорогий_камнеруб_Возвышение.png/revision/latest?cb=20211214154256&path-prefix=ru"))
        val weaponYunJin = repository.insertWeapon(Weapon(4, "Небесная ось", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/1/14/Оружие_Небесная_ось_Возвышение.png/revision/latest?cb=20210204170922&path-prefix=ru"))
        val weaponShenhe = repository.insertWeapon(Weapon(5, "Усмиритель бед", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/d/de/Оружие_Усмиритель_бед_Возвышение.png/revision/latest?cb=20220105055008&path-prefix=ru"))
        val weaponYae = repository.insertWeapon(Weapon(6, "Истина кагура", fiveStarRarity, catalystType, "https://static.wikia.nocookie.net/genshin-impact/images/1/16/Оружие_Истина_кагура_Возвышение.png/revision/latest?cb=20220216100108&path-prefix=ru"))
        val weaponAyato = repository.insertWeapon(Weapon(7, "Харан гэппаку фуцу", fiveStarRarity, swordType, "https://static.wikia.nocookie.net/genshin-impact/images/a/a2/Оружие_Харан_гэппаку_фуцу_Возвышение.png/revision/latest?cb=20220330082554&path-prefix=ru"))
        val weaponYelan = repository.insertWeapon(Weapon(8, "Аква симулякрум", fiveStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/5/51/Оружие_Аква_симулякрум_Возвышение.png/revision/latest?cb=20220531142404&path-prefix=ru"))
        val weaponAloy = repository.insertWeapon(Weapon(9, "Хищник", fourStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/7/73/Оружие_Хищник_Возвышение.png/revision/latest?cb=20210908105809&path-prefix=ru"))
        val weaponHuTao = repository.insertWeapon(Weapon(10, "Посох Хомы", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/c/c3/Оружие_Посох_Хомы_Возвышение.png/revision/latest?cb=20210321105051&path-prefix=ru"))
        val weaponEula = repository.insertWeapon(Weapon(11, "Песнь разбитых сосен", fiveStarRarity, claymoreType, "https://static.wikia.nocookie.net/genshin-impact/images/4/4a/Оружие_Песнь_разбитых_сосен_Возвышение.png/revision/latest?cb=20210518162541&path-prefix=ru"))
        val weaponKlee = repository.insertWeapon(Weapon(12, "Молитва святым ветрам", fiveStarRarity, catalystType, "https://static.wikia.nocookie.net/genshin-impact/images/1/14/Оружие_Молитва_святым_ветрам_Возвышение.png/revision/latest?cb=20210219132013&path-prefix=ru"))
        val weaponAlbedo = repository.insertWeapon(Weapon(13, "Киноварное веретено", fourStarRarity, swordType, "https://static.wikia.nocookie.net/genshin-impact/images/d/d3/Оружие_Киноварное_веретено_Возвышение.png/revision/latest?cb=20211126045130&path-prefix=ru"))
        val weaponKaeya = repository.insertWeapon(Weapon(14, "Кагоцурубэ Иссин", fourStarRarity, claymoreType, "https://static.wikia.nocookie.net/genshin-impact/images/4/43/Оружие_Кагоцурубэ_Иссин_Возвышение.png/revision/latest?cb=20220713072207&path-prefix=ru"))
        val weaponAyaka = repository.insertWeapon(Weapon(15, "Рассекающий туман", fiveStarRarity, swordType, "https://static.wikia.nocookie.net/genshin-impact/images/0/0c/Оружие_Рассекающий_туман_Возвышение.png/revision/latest?cb=20210722041050&path-prefix=ru"))
        val weaponNevi = repository.insertWeapon(Weapon(16, "Обряд вечного течения", fiveStarRarity, catalystType, "https://static.wikia.nocookie.net/genshin-impact/images/9/93/Оружие_Обряд_вечного_течения_Возвышение.png/revision/latest?cb=20230927130516&path-prefix=ru"))
        val weaponSetos = repository.insertWeapon(Weapon(17, "Приближённый короля", fourStarRarity, bowType, "https://genshin-impact.fandom.com/ru/wiki/Приближённый_короля?file=Оружие+Приближённый+короля+Возвышение.png"))
        val weaponCyno = repository.insertWeapon(Weapon(18,  "Посох алых песков", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/genshin-impact/images/a/ad/Оружие_Посох_алых_песков_Возвышение.png/revision/latest?cb=20220929144525&path-prefix=ru"))
        val weaponGanyu = repository.insertWeapon(Weapon(19, "Лук Амоса", fiveStarRarity, bowType, "https://static.wikia.nocookie.net/genshin-impact/images/4/41/Оружие_Лук_Амоса_Возвышение.png/revision/latest?cb=20210220142847&path-prefix=ru"))
        val weaponKazuha = repository.insertWeapon(Weapon(20, "Клятва свободы", fiveStarRarity, swordType, "https://static.wikia.nocookie.net/genshin-impact/images/d/df/Оружие_Клятва_свободы_Возвышение.png/revision/latest?cb=20210630032048&path-prefix=ru"))


        // Вставка данных о персонажах
        val characters = listOf(
            CharacterModel(1, "Тома", weaponThoma, regionInazuma, fourStarRarity, pyroElement, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Thoma_Game.png", "Тома — верный домоправитель клана Камисато, известный своей надежностью и доброжелательностью."),
            CharacterModel(2, "Горо", weaponGorou, regionInazuma, fourStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/f/f4/Character_Gorou_Game.png", "Горо — смелый и надежный генерал армии Ватацуми, всегда готов защищать своих товарищей."),
            CharacterModel(3, "Итто", weaponItto, regionInazuma, fiveStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/a/ae/Character_Arataki_Itto_Game.png", "Итто — лидер банды Аратаки, известный своей мощной силой и беззаботным характером."),
            CharacterModel(4, "Юнь Цзинь ", weaponYunJin, regionLiYe, fourStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/a/a2/Character_Yun_Jin_Game.png", "Юнь Цзинь — талантливая актриса из Ли Юэ, сочетающая традиции и современность в своих выступлениях."),
            CharacterModel(5, "Шень Хэ", weaponShenhe, regionLiYe, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/gensin-impact/images/3/35/Character_Shenhe_Game.png", "Шэньхэ — загадочная воительница из Ли Юэ, обладающая мощной ледяной силой."),
            CharacterModel(6, "Яэ Мико", weaponYae, regionInazuma, fiveStarRarity, electroElement, "https://static.wikia.nocookie.net/gensin-impact/images/d/d1/Character_Yae_Miko_Game.png", "Яэ Мико — умная и загадочная жрица Храма Наруками, владеющая электро элементом."),
            CharacterModel(7, "Аято", weaponAyato, regionInazuma, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/gensin-impact/images/8/8f/Character_Kamisato_Ayato_Game.png", "Аято Камисато — глава клана Камисато, известный своей мудростью и стратегическим мышлением."),
            CharacterModel(8, "Е Лань", weaponYelan, regionLiYe, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Yelan_Game.png", "Е Лань — таинственная и элегантная разведчица, обладающая мастерством обращения с луком."),
            CharacterModel(9, "Элой", weaponAloy, regionNone, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/gensin-impact/images/3/34/Character_Aloy_Game.png", "Элой — охотница из другого мира, сражающаяся с механическими существами и владеющая крио силой."),
            CharacterModel(10, "Ху Тао", weaponHuTao, regionLiYe, fiveStarRarity, pyroElement, "https://static.wikia.nocookie.net/genshin-impact/images/d/de/Персонаж_Ху_Тао_В_игре.png/revision/latest?cb=20211205141248&path-prefix=ru", "Хозяйка ритуального бюро «Ваншэн» в семьдесят седьмом поколении. Она унаследовала этот бизнес в достаточно юном возрасте."),
            CharacterModel(11, "Эола", weaponEula, regionMond, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/genshin-impact/images/9/97/Персонаж_Эола_В_игре.png/revision/latest?cb=20220203114353&path-prefix=ru", "Рыцарь Морская пена из старинного рода аристократов Мондштадта, капитан разведывательного отряда рыцарей Ордо Фавониус. Будучи потомком древней аристократии, она присоединилась к рыцарям Ордо Фавониус, их заклятым врагам. Причины этого поступка и по сей день остаются загадкой для всего Мондштадта."),
            CharacterModel(12, "Кли", weaponKlee, regionMond, fiveStarRarity, pyroElement, "https://static.wikia.nocookie.net/genshin-impact/images/2/26/Персонаж_Кли_В_игре.png/revision/latest?cb=20211221151256&path-prefix=ru", "Эксперт по взрывчатке и частый гость темницы Ордо Фавониус. Также известна, как «Ускользающее солнце»."),
            CharacterModel(13, "Альбедо", weaponAlbedo, regionMond, fiveStarRarity, geoElement, "https://static.wikia.nocookie.net/genshin-impact/images/5/5b/Персонаж_Альбедо_В_игре.png/revision/latest?cb=20211205141021&path-prefix=ru", "Гений, именуемый Принцем мела. Главный алхимик и глава исследовательской команды Ордо Фавониус."),
            CharacterModel(14, "Кэйа", weaponKaeya, regionMond, fourStarRarity, cryoElement, "https://static.wikia.nocookie.net/genshin-impact/images/5/56/Персонаж_Кэйа_В_игре.png/revision/latest?cb=20220815201311&path-prefix=ru", "Капитан Ордо Фавониус выглядит довольно экзотично. Несмотря на дружелюбие и приветливость, от него веет странным холодком."),
            CharacterModel(15, "Аяка", weaponAyaka, regionInazuma, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/genshin-impact/images/f/ff/Персонаж_Аяка_В_игре.png/revision/latest?cb=20210721134619&path-prefix=ru", "Наследница клана Камисато комиссии Ясиро. Благородна и изящна, мудра и сильна."),
            CharacterModel(16, "Нёвиллет", weaponNevi, regionFontain, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/genshin-impact/images/a/ae/Персонаж_Нёвиллет_В_игре.png/revision/latest?cb=20231005095226&path-prefix=ru", "Верховный судья Фонтейна, или же юдекс, прославился своей безукоризненной беспристрастностью."),
            CharacterModel(17, "Сетос", weaponSetos, regionSumeru, fourStarRarity, electroElement, "https://static.wikia.nocookie.net/genshin-impact/images/4/48/Персонаж_Сетос_В_игре.png/revision/latest?cb=20240515050137&path-prefix=ru", "Наследник Храма Молчания, что несёт тайны песков."),
            CharacterModel(18, "Сайно", weaponCyno, regionSumeru, fiveStarRarity, electroElement, "https://static.wikia.nocookie.net/genshin-impact/images/a/ab/Персонаж_Сайно_В_игре.png/revision/latest?cb=20221001172302&path-prefix=ru", "Генерал махаматра, который осуществляет надзор над всеми учёными Академии. Говорят, в работе он по эффективности превосходит «Великую Ваювьястру» Кшахревара."),
            CharacterModel(19, "Гань Юй", weaponGanyu, regionLiYe, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/genshin-impact/images/8/8a/Персонаж_Гань_Юй_В_игре.png/revision/latest?cb=20220108162825&path-prefix=ru", "Главный секретарь павильона Лунного моря. В её жилах течёт кровь мифического зверя цилиня."),
            CharacterModel(20, "Кадзуха", weaponKazuha, regionInazuma, fiveStarRarity, anemoElement, "https://static.wikia.nocookie.net/genshin-impact/images/8/85/Персонаж_Кадзуха_В_игре.png/revision/latest?cb=20210629151416&path-prefix=ru", "Ронин-самурай из Инадзумы, который нашёл приют на флоте Южного Креста в Ли Юэ. Этот добрый и беззаботный молодой человек многое пережил в прошлом.")
        )

        characters.forEach {
            repository.insertCharacterModel(it)
        }
        doSuccess()
    }
}
