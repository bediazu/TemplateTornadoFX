package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.MasterController
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Border
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import tornadofx.*

/*
    RECOMENDACION DEL PROGRAMADOR:

     AL HACER CLICK EN CUALQUIERA DE LOS DOS BOTONES DE SECCION,
     SE DEBE PODER MOSTRAR EL CONTENIDO ACTUALIZADO DEL CONTENIDO NUEVO CON SUS CAMBIOS ANTERIORES.
     POR TANTO:

     - PUEDO EFECTUAR PROGRAMACION REACTIVA PARA LOS COMPONENTES QUE SE VAN A VISUALIZAR.
     - PUEDO LLAMAR A UN CONTROLADOR QUE EJECUTA UNA FUNCION CADA VEZ QUE APRETE UN BOTON (CREAR UNA CLASE PADRE DEL BOTON).
     - HACER UN BIND(LLAMADA ASINCRONA DE JAVAFX) AL TEXTO DESDE UN CONTROLADOR INICIAL DE LA PANTALLA PRINCIPAL.

     SOLUCION:

     - CREO QUE DEBEMOS APROVECHAR LA FUNCION DE JAVAFX, DEBIDO A QUE PODEMOS REALIZAR SINCRONIA ENTRE COMPONENTES.
     ESTO BRINDA UNA FUNCIONALIDAD GENIAL, PUEDES HACER QUE HAYA UN CLON EXACTO DE "ALGO", SEA EL TEXTO, LA ALTURA DEL
     COMPONENTE, EL COLOR DE FONDO, ETC.

     PARA ELLO DEBEMOS CONSIDERAR QUE LA SINCRONIZACION DEBE HACERSE LUEGO DE LA INSTANCIACION DE LAS VISTAS.
     ES POR ELLO QUE LLAMAMOS A "startAsync()" Y NO REALIZAMOS LAS INSTRUCCION EN EL "init" DE CADA VISTA.

     UNA SOLUCION ELEGANTE :D

 */
class MasterView : View("Hello TornadoFX") {
    override val root: BorderPane by fxml("/ui/view/MasterView.fxml")


    val detailView1: DetailView by inject()
    val detailView2: DetailView2 by inject()


    init {
        detailView1.master = this
        detailView2.master = this
        startAsync()
    }

    fun startAsync(){
        detailView1.textLabel.textProperty().bind(detailView2.inputText.textProperty())
    }

    fun switchScreen1() {

        root.center = detailView1.root
    }

    fun switchScreen2() {
        root.center = detailView2.root
    }
}


/*
class MasterView : View("Hello TornadoFX") {
    override val root: BorderPane by fxml("/ui/view/MasterView.fxml")


     val detailView1: DetailView by inject()
     val detailView2: DetailView2 by inject()

    val mapOfParam = mapOf("root" to root, "detailView1" to detailView1, "detailView2" to detailView2)

    val controller: MasterController by inject(params = mapOfParam)

    init {
        detailView1.master = this
        detailView2.master = this
    }
}

class MasterController: Controller() {

    val detailView1 : DetailView by param()
    val detailView2: DetailView2 by param()

    val root: BorderPane by param()

    companion object Hola {
        fun holi(){
            print("holi")
        }
    }

    fun startAsync(detailView1: DetailView){
        detailView1.textLabel.textProperty().bind(detailView2.inputText.textProperty())
    }

    fun switchScreen1() {

        root.center = detailView1.root
    }

    fun switchScreen2() {
        root.center = detailView2.root
    }


}

*/