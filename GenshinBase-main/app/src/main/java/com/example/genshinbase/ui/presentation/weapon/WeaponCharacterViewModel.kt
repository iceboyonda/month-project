package com.example.genshinbase.ui.presentation.weapon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeaponCharacterViewModel @Inject constructor(private val genshinRepositoryImpl: GenshinRepositoryImpl): ViewModel() {

    val state = MutableStateFlow(WeaponCharacterState.InitState)

    fun loadWeapons() {
        viewModelScope.launch {
            val weapons = genshinRepositoryImpl.getAllWeapons()
            state.tryEmit(state.value.copy(weapons = weapons))
        }
    }

}