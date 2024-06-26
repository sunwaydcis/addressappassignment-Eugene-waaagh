package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.TextField
import scalafxml.core.macros.sfxml

@sfxml
class WelcomeController(private val text1: TextField,
                        private val text2: TextField) {

  text2.text <==> text1.text

  //Can do on change to call the health of pokemon
  //most likely be used for login and stuff, parse in value to a temp variable

  text1.text.onChange((_, _, c) => {
    println(text2.text.value.toDouble + c.toDouble)
  })

  text2.text.onChange((_, _, c) => {
    println(text1.text.value.toDouble + c.toDouble)
  })
  def handleGetStarted(): Unit = {
    MainApp.showPersonOverview()
  }
}