package com.example.genshinbase.ui.navigation

data class RootNavState(
    val loadData: Boolean,
) {
    companion object {
        val InitState = RootNavState(
            loadData = false
        )
    }
}
