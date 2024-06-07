package com.example.genshinbase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Element
import com.example.genshinbase.data.local.models.Material
import com.example.genshinbase.data.local.models.Rarity
import com.example.genshinbase.data.local.models.Region
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.models.WeaponType
import com.example.genshinbase.data.local.repository.GenshinRepository


//схема базы данных
@Database(
    entities = [CharacterModel::class, Element::class, Rarity::class, Region::class, Weapon::class, WeaponType::class, Material::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun genshinDao(): GenshinRepository
}