package com.example.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _checkboxState = MutableLiveData<Boolean>(false)
    val checkboxState: LiveData<Boolean> get() = _checkboxState

    fun setCheckboxState(state: Boolean) {
        _checkboxState.value = state
    }
}