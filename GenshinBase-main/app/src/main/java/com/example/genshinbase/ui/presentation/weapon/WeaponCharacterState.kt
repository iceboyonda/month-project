package com.example.genshinbase.ui.presentation.weapon

import com.example.genshinbase.domain.models.WeaponUI

data class WeaponCharacterState(
    val weapons: List<WeaponUI>
) {
    companion object {
        val InitState = WeaponCharacterState(
            emptyList()
        )
    }
}