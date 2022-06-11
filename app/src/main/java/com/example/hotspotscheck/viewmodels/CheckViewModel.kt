package com.example.hotspotscheck.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.hotspotscheck.models.Hotspot

class CheckViewModel : ViewModel(){

    private val _checkhotspots = mutableStateListOf<Hotspot>()
    val checkHotspots: List<Hotspot>
        get() = _checkhotspots

    fun addCheck(hotspot: Hotspot) {
        _checkhotspots.add(hotspot)
    }

    fun removeCheck(hotspot: Hotspot) {
        _checkhotspots.remove(hotspot)
    }

    fun checkVisit(hotspot: Hotspot): Boolean {
        return _checkhotspots.contains(hotspot)
    }

    fun changeVisitDate(hotspot: Hotspot, newdate: String) {
        hotspot.visitdate = newdate
    }
}