package com.example.genshinbase.ui.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val genshinRepositoryImpl: GenshinRepositoryImpl) :
    ViewModel() {

    val stateFlow = MutableStateFlow(MainState.InitState)

    fun loadCharacter() {
        viewModelScope.launch {
            val characters = genshinRepositoryImpl.getAllCharacters()
            stateFlow.tryEmit(
                stateFlow.value.copy(
                    characters = characters
                )
            )
        }
    }

}