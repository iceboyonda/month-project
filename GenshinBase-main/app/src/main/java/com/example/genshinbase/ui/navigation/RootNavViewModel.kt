package com.example.genshinbase.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.data.local.util.BaseUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootNavViewModel @Inject constructor(private val genshinRepositoryImpl: GenshinRepositoryImpl) :
    ViewModel() {

    val stateFlow = MutableStateFlow(RootNavState.InitState)

    fun checkData() {
        viewModelScope.launch {
            val data = genshinRepositoryImpl.getAllCharacters()
            if (data.isEmpty()) {
                BaseUtil.insertData(genshinRepositoryImpl) {
                    stateFlow.tryEmit(stateFlow.value.copy(loadData = true))
                }
            } else {
                stateFlow.tryEmit(stateFlow.value.copy(loadData = true))
            }
        }
    }
}