package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class PersonOverviewController() {
  def handleGetStarted(): Unit = {
    MainApp.showPersonOverview()
  }
}