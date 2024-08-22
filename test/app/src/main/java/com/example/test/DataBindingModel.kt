// DataBindingModel.kt
package com.example.test

import androidx.databinding.BaseObservable

class DataBindingModel : BaseObservable(){
    var text: String = "Initial Text"

    // Method to update text
    fun updateText(){
        text = "iii"
    }
}
