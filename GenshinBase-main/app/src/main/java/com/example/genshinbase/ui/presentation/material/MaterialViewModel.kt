package com.example.genshinbase.ui.presentation.material

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class MaterialViewModel @Inject constructor(private val genshinRepositoryImpl: GenshinRepositoryImpl) :
    ViewModel() {

    val state = MutableStateFlow(MaterialState.InitState)

    init {
        loadMaterial("")
    }

    private fun loadMaterial(query: String) {
        viewModelScope.launch {
            val material = genshinRepositoryImpl.queryMaterial(query)
            state.tryEmit(state.value.copy(material = material))
        }
    }

    fun changeQuery(query: String = "") {
        runBlocking {
            state.tryEmit(state.value.copy(query = query))
        }
        loadMaterial(query)
    }


}