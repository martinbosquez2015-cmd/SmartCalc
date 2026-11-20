package com.example.smartcalc
/*
* El motivo de esta clase kotlin es el implementar una clase application de la libreria MAterial 3
* que cambie colores de los botones segun el fondo de pantalla del dispositivo del usuario, y tambien
* soporte modos claros y oscuros
* */

import android.app.Application
import com.google.android.material.color.DynamicColors


class App: Application (){
    override fun onCreate(){
        super.onCreate()

        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}