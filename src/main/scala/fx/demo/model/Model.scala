package fx.demo.model

import scalafx.beans.property.*
import scalafx.beans.binding.BooleanBinding
import scalafx.Includes.*

class Model:
  val property1Property: StringProperty = StringProperty("")
  def property1: String = property1Property.value
  def property1_=(value: String): Unit = property1Property.value = value

  val property2Property: StringProperty = StringProperty("")
  def property2: String = property2Property.value
  def property2_=(value: String): Unit = property2Property.value = value

  private val _property3: BooleanProperty = BooleanProperty(false)
  def property3Property: ReadOnlyBooleanProperty = _property3
  def bindProperty3(binding: BooleanBinding) = _property3 <== binding
