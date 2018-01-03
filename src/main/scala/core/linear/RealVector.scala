package mathlib.linear
import mathlib.utils.NumberUtils

case class RealVector(xs: Double*) {
  def abs2(): Double = xs.map(x => x * x).sum
  def abs(): Double = Math.sqrt(abs2)
  def isApproximated(that: RealVector): Boolean =
    NumberUtils.isApproximated(this.xs.toList, that.xs.toList)
  def unary_+(): RealVector = this
  def unary_-(): RealVector = {
    val ys = xs.map(-_)
    new RealVector(ys:_*)
  }
}
