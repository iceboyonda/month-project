package com.example.genshinbase.data.local.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Element
import com.example.genshinbase.data.local.models.Material
import com.example.genshinbase.data.local.models.Rarity
import com.example.genshinbase.data.local.models.Region
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.models.WeaponType



//запросы к БД
@Dao
interface GenshinRepository {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterModel): Long

    @Query("SELECT * FROM character WHERE characterId = :id")
    suspend fun getCharacterById(id: Long): CharacterModel

    @Query("SELECT * FROM character")
    suspend fun getAllCharacters(): List<CharacterModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(element: Element): Long

    @Query("SELECT * FROM element WHERE elementId = :id")
    suspend fun getElementById(id: Long): Element



    @Insert
    suspend fun insert(rarity: Rarity): Long

    @Query("SELECT * FROM rarity WHERE rarityId = :id")
    suspend fun getRarityById(id: Long): Rarity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(region: Region): Long

    @Query("SELECT * FROM region WHERE regionId = :id")
    suspend fun getRegionById(id: Long): Region


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weaponType: WeaponType): Long

    @Query("SELECT * FROM weaponType WHERE weaponTypeId = :id")
    suspend fun getWeaponTypeById(id: Long): WeaponType?

    @Query("SELECT * FROM weaponType")
    fun getAllWeaponTypes(): List<WeaponType>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weapon: Weapon): Long

    @Query("SELECT * FROM weapon WHERE weaponId = :id")
    suspend fun getWeaponById(id: Long): Weapon

    @Query("SELECT * FROM weapon")
    suspend fun getAllWeapons(): List<Weapon>

    @Query("SELECT * FROM material")
    suspend fun getAllMaterial(): List<Material>

    @Query("SELECT * FROM material WHERE title LIKE :query")
    suspend fun searchMaterial(query: String): List<Material>

    @Query("SELECT * FROM material where materialId = :materialId")
    suspend fun getMaterialById(materialId: Long): Material

    @Insert
    suspend fun insertMaterial(material: Material): Long

}