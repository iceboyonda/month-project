package com.example.genshinbase.ui.presentation.material

import com.example.genshinbase.domain.models.MaterialUI

data class MaterialState (
    val material: List<MaterialUI>,
    val query: String
) {
    companion object {
        val InitState = MaterialState(
            material = emptyList(),
            query = ""
        )
    }
}