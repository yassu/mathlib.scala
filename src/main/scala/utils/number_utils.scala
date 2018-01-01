package mathlib.utils

object NumberUtils {
  def termString(x: Double, unit: String, withPositiveSgn: Boolean=false) =
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
