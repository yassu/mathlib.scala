package mathlib.number
import mathlib.utils.NumberUtils

case class RealInt(n: Int) {
  def abs(): Int = n.abs
  def unary_+(): RealInt = this
  def unary_-(): RealInt = new RealInt(-n)
}
