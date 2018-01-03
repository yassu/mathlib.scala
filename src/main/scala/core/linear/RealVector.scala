package mathlib.linear
import mathlib.utils.NumberUtils

/*
TODO: Doubleではなく RealDoubleなるものを使うようにする
*/
case class RealVector(xs: Double*) {
  def abs2(): Double = xs.map(x => x * x).sum
  def abs(): Double = Math.sqrt(abs2)
  def isApproximated(that: RealVector): Boolean =
    NumberUtils.isApproximated(this.xs.toList, that.xs.toList)
  def unary_+(): RealVector = this
  def unary_-(): RealVector = new RealVector(xs.map(-_): _*)
  def +(that: RealVector): RealVector = new RealVector(
    xs.zip(that.xs).map(t => t._1 + t._2): _*)
  def -(that: RealVector): RealVector = new RealVector(
    xs.zip(that.xs).map(t => t._1 - t._2): _*)
  override def toString: String =
    "(" + xs.map(x => NumberUtils.termString(x, "1")).mkString(", ") + ")"
}
