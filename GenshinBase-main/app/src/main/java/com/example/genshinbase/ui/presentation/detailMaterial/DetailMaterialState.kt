package com.example.genshinbase.ui.presentation.detailMaterial

import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.MaterialUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponUI

data class DetailMaterialState(
    val materialUI: MaterialUI
) {
    companion object {
        val InitState = DetailMaterialState(
            materialUI = MaterialUI(
                0, "", "", "", 0
            )
        )
    }
}