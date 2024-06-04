package com.example.genshinbase.ui.presentation.detailCharacter

import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponUI

data class DetailCharacterState(
    val characterUI: CharacterUI
) {
    companion object {
        val InitState = DetailCharacterState(
            characterUI = CharacterUI(
                0,
                "",
                WeaponUI(0, "", 0, 0, ""),
                RegionUI(0, ""),
                0,
                ElementUI(0, ""),
                "",
                ""
            )
        )
    }
}