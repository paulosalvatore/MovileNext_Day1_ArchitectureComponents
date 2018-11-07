package br.com.paulosalvatore.movilenext_day1_architecturecomponents.seekbar

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {
    val seekbarValue = MutableLiveData<Int>()
}
