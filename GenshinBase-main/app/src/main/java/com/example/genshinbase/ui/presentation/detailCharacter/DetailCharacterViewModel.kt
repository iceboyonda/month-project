package com.example.genshinbase.ui.presentation.detailCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbase.data.local.repository.GenshinRepository
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.ui.presentation.main.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailCharacterViewModel @Inject constructor(private val genshinRepository: GenshinRepositoryImpl) :
    ViewModel() {

    val stateFlow = MutableStateFlow(DetailCharacterState.InitState)

    fun loadCharacter(characterId: Long) {
        viewModelScope.launch {
            val character = genshinRepository.getCharacterById(id = characterId)
            stateFlow.tryEmit(
                stateFlow.value.copy(
                    characterUI = character
                )
            )
        }
    }
}