package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*

class DetailView : View("My View") {
    override val root: VBox by fxml("/ui/view/DetailView.fxml")

    var master: MasterView? = null

    /* Properties for FXML*/
    val textLabel: Label by fxid()

    init {
        println("DetailView1 mostrado")
    }
}
