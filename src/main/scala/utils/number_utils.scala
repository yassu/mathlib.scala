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
  def numberString(xs: List[Double], units: List[String]): String = {
    val stringWithSgn = xs.zip(units).collect { case t if t._1 != 0.0 => t }.
      map(term => termString(term._1, term._2, withPositiveSgn=true)).mkString(" ")
    if(stringWithSgn == "")
      "0.0"
    else if(stringWithSgn.startsWith("+ "))
      stringWithSgn.drop("+ ".size)
    else
      stringWithSgn
  }
}
