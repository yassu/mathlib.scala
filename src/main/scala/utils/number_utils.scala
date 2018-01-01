package mathlib.utils

object NumberUtils {
  def termString(x: Double, unit: String, withPositiveSgn: Boolean=false): String = {
    if (x == 0.0)
      return "0.0"

    (
      if (x > 0.0 && withPositiveSgn)
        "+ "
      else if (x >= 0.0)
        ""
      else
        "- "
    ) +
    x.abs + (
      if (unit == "1")
        ""
      else
        s" $unit"
    )
  }
}
