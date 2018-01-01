package mathlib.utils

object NumberUtils {
  def termString(x: Double, unit: String) = x + (
      if (unit == "1")
        ""
      else
        s" $unit"
    )
}
