package fx.demo.widgets

import java.time.{LocalDate, LocalDateTime, ZoneOffset}
import java.time.format.DateTimeFormatter
import scala.util.Try

object DateWidgets:
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy")
  val jsonFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
  def formatDate(date: LocalDate): String = date.format(formatter)
  def dateFromJson(jsonDateTime: String): Option[LocalDate] =
    Try(LocalDateTime.parse(jsonDateTime, DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC)).toLocalDate)
      .toOption