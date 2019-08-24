package com.example.demo.app

import com.example.demo.view.MasterView
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.App

class MyApp: App(MasterView::class, Styles::class){
    override fun start(stage: Stage) {
        fullScreenBuild(stage)
        super.start(stage)
    }

    private fun fullScreenBuild(stage: Stage) {
        stage.initStyle(StageStyle.UNDECORATED)
        stage.isMaximized = true
    }
}