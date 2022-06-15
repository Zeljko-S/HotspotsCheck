package com.example.hotspotscheck.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.models.VisitDate

class CheckViewModel : ViewModel(){

    private val _checkhotspots = mutableStateListOf<Hotspot>()
    val checkHotspots: List<Hotspot>
        get() = _checkhotspots

   /* var hotspot : Hotspot? = null*/


    private val _dates = mutableStateListOf<VisitDate>()
    val dates: List<VisitDate>
        get() = _dates

    fun addCheck(datum: VisitDate) {
        _dates.add(datum)
    }

    fun removeCheck(datum: VisitDate) {
        _dates.remove(datum)
    }

    fun checkVisit(datum: VisitDate): Boolean {
        return _dates.contains(datum)
    }

    fun addCheck(hotspot: Hotspot) {
        _checkhotspots.add(hotspot)
    }

    fun removeCheck(hotspot: Hotspot) {
        _checkhotspots.remove(hotspot)
    }

    fun checkVisit(hotspot: Hotspot): Boolean {
        return _checkhotspots.contains(hotspot)
    }

    fun changeVisitDate(hotspot: Hotspot, newdate: String?) {
        hotspot.visitdate = newdate
    }
}