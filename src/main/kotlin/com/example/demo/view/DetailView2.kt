package com.example.demo.view

import com.jfoenix.controls.JFXTextField
import javafx.concurrent.Task
import javafx.scene.layout.VBox
import tornadofx.*
import javafx.concurrent.WorkerStateEvent
import java.beans.EventHandler


class DetailView2 : View("My View") {
    override val root: VBox by fxml ("/ui/view/DetailView2.fxml")

    val inputText : JFXTextField by fxid()

    var master: MasterView? = null


    fun botonPresionado() {

    }
}
