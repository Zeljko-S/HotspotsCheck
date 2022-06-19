package com.example.hotspotscheck.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.screens.HotspotScreen

class CheckViewModel : ViewModel(){

    private val _checkhotspots = mutableStateListOf<Hotspot>()
    val checkHotspots: List<Hotspot>
        get() = _checkhotspots

    private val _planhotspots = mutableStateListOf<Hotspot>()
    val planhotspots: List<Hotspot>
        get() = _planhotspots



    fun addCheck(hotspot: Hotspot) {
        _checkhotspots.add(hotspot)
    }

    fun removeCheck(hotspot: Hotspot) {

        var hotspotremover = hotspot
        _checkhotspots.forEach {
            if ( it.cityid == hotspot.cityid && it.id == hotspot.id ) hotspotremover = it
        }
        _checkhotspots.remove(hotspotremover)

    }

    fun checkVisit(hotspot: Hotspot): Boolean {
        var used = false
        _checkhotspots.forEach {
            if ( it.cityid == hotspot.cityid && it.id == hotspot.id ) used = true
        }
        return used

       // return _checkhotspots.contains(hotspot)

    }

    fun changeVisitDate(hotspot: Hotspot, newdate: String?) {

        _checkhotspots.forEach { inlisthotspot ->
            if (inlisthotspot.id == hotspot.id && inlisthotspot.cityid == hotspot.cityid) {
                inlisthotspot.visitdate = newdate
            }
        }
    }

    fun filterCheckedHotspot(hotspot: Hotspot) : Hotspot? {

        val help = _checkhotspots
        val help3: List<Hotspot>
        if (help.isNotEmpty()) {
            val help2 = help.filter { it.cityid == hotspot.cityid }
            help3 = help2.filter { it.id == hotspot.id }
            return if (help3.isNotEmpty()) {
                help3[0]
            } else null

        } else return null

    }

    fun addPlan(hotspot: Hotspot) {
        _planhotspots.add(hotspot)
    }

    fun removePlan(hotspot: Hotspot) {

        var hotspotremover = hotspot
        _checkhotspots.forEach {
            if ( it.cityid == hotspot.cityid && it.id == hotspot.id ) hotspotremover = it
        }
        _planhotspots.remove(hotspotremover)

    }

    fun checkPlan(hotspot: Hotspot): Boolean {
        var used = false
        _planhotspots.forEach {
            if ( it.cityid == hotspot.cityid && it.id == hotspot.id ) used = true
        }
        return used
     //   return _planhotspots.contains(hotspot)

    }

}