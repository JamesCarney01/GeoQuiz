package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val IS_CHEATER_KEY = "IS_CHEATER_KEY"
private const val TAG = "CheaterViewModel"

class CheaterViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)
}