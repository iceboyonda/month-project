package com.example.genshinbase.ui.presentation.detailMaterial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailMaterialViewModel @Inject constructor(private val genshinRepository: GenshinRepositoryImpl) :
    ViewModel() {

    val stateFlow = MutableStateFlow(DetailMaterialState.InitState)

    fun loadMaterial(materialId: Long) {
        viewModelScope.launch {
            val material = genshinRepository.getMaterialById(id = materialId)
            stateFlow.tryEmit(
                stateFlow.value.copy(
                    materialUI = material
                )
            )
        }
    }
}