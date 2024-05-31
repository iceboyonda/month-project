package com.example.genshinbase.di

import android.app.Application
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.data.local.util.BaseUtil
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class GenshinApp : Application()
