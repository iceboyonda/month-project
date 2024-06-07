package com.example.genshinbase.ui.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.domain.models.CharacterUI
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainState (
    val characters: List<CharacterUI>
) {
    companion object {
        val InitState = MainState(
            characters = emptyList()
        )
    }
}