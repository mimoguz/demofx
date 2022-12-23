package fx.demo.widgets

import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{Background, BackgroundFill, BackgroundImage, BackgroundSize, CornerRadii}
import javafx.scene.layout.Background as jfxBackground
import scalafx.geometry.Insets
import scalafx.scene.paint.Color

import scala.util.Try

object ImageWidgets:
  def scaledImageFromUrl(url: String, fitW: Double): ImageView =
    new ImageView:
      Try(new Image(url, true)).foreach(image = _)
      fitWidth = fitW
      preserveRatio = true

  def stretchedImageBackgroundFromUrl(url: String): Background =
    val backgroundSize = BackgroundSize(
      width = BackgroundSize.Auto,
      height = BackgroundSize.Auto,
      widthAsPercentage = false,
      heightAsPercentage = false,
      contain = true,
      cover = true
    )
    Try(Image(url, true))
      .map(img => Background(Array(BackgroundImage(img, null, null, null, backgroundSize))))
      .getOrElse(Background(Array(BackgroundFill(Color.Black, CornerRadii(0), Insets(0)))))
end ImageWidgets
