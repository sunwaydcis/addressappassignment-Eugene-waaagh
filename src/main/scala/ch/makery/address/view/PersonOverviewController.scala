package ch.makery.address.view
import ch.makery.address.model.Person
import ch.makery.address.MainApp
import scalafx.scene.control.{TableView, TableColumn, Label}
import scalafxml.core.macros.sfxml
import scalafx.beans.property.{StringProperty}
import ch.makery.address.util.DateUtil._

@sfxml
class PersonOverviewController(
                                private val personTable : TableView[Person],
                                private val firstNameColumn : TableColumn[Person, String],
                                private val lastNameColumn : TableColumn[Person, String],
                                private val firstNameLabel : Label,
                                private val lastNameLabel : Label,
                                private val streetLabel : Label,
                                private val postalCodeLabel : Label,
                                private val cityLabel :  Label,
                                private val  birthdayLabel : Label
                              ) {

  private def showPersonDetails(person: Option[Person]) = {
    person match {
      case Some(person) =>
        // Fill the labels with info from the person object.
        firstNameLabel.text <== person.firstName
        lastNameLabel.text <== person.lastName
        streetLabel.text <== person.street
        cityLabel.text <== person.city;
        postalCodeLabel.text = person.postalCode.value.toString
        birthdayLabel.text = person.date.value.asString

      case None =>
        // Person is null, remove all the text.
        firstNameLabel.text.unbind()
        lastNameLabel.text.unbind()
        streetLabel.text.unbind()
        cityLabel.text.unbind()

        firstNameLabel.text = ""
        lastNameLabel.text = ""
        streetLabel.text = ""
        postalCodeLabel.text = ""
        cityLabel.text = ""
        birthdayLabel.text = ""
    }
  }

  // initialize Table View display contents model
  personTable.items = MainApp.personData
  // initialize columns's cell values
  firstNameColumn.cellValueFactory = {
    _.value.firstName
  }
  lastNameColumn.cellValueFactory = {
    _.value.lastName
  }

  showPersonDetails(None)

  import scalafx.Includes._
  personTable.selectionModel.value.selectedItem.onChange((a, b, c) => {
    showPersonDetails(Option(c))
  })
}