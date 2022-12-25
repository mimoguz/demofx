package fx.demo

import scalafx.beans.property.Property
import scalafx.beans.value.ObservableValue


object Util:
  type ObservableStringValue = ObservableValue[String, String]

  type NumberProperty = Property[Number, Number]

  extension[T] (t: T)
    infix def by(f: T => Unit): T =
      f(t)
      t
