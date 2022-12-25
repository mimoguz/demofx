package fx.demo.widgets.texts

import fx.demo.Util.*

import scalafx.scene.control.Label

object Labels:
  def styled(textValue: String, styleClass: String): Label =
    new Label(textValue) by (_.styleClass += styleClass)

  def styled(textValue: ObservableStringValue, styleClass: String): Label =
    new Label by { lbl =>
      lbl.styleClass += styleClass
      lbl.text <== textValue
    }

  inline def h1(textValue: String): Label = styled(textValue, "label-h1")

  inline def h1(textValue: ObservableStringValue): Label = styled(textValue, "label-h1")

  inline def h2(textValue: String): Label = styled(textValue, "label-h2")

  inline def h2(textValue: ObservableStringValue): Label = styled(textValue, "label-h2")

  inline def h3(textValue: String): Label = styled(textValue, "label-h3")

  inline def h3(textValue: ObservableStringValue): Label = styled(textValue, "label-h3")

  inline def h4(textValue: String): Label = styled(textValue, "label-h4")

  inline def h4(textValue: ObservableStringValue): Label = styled(textValue, "label-h4")

  inline def prompt(textValue: String): Label = styled(textValue, "label-prompt")

  inline def prompt(textValue: ObservableStringValue): Label = styled(textValue, "label-prompt")

  inline def data(textValue: String): Label = styled(textValue, "label-data")

  inline def data(textValue: ObservableStringValue): Label = styled(textValue, "label-data")
end Labels
