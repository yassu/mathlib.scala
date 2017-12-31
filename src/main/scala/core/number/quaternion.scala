package mathlib.core.number

case class Quaternion(x0: Double, x1: Double, x2: Double, x3: Double) {
  def this(x0: Double) = this(x0, 0, 0, 0)
  def abs():Double = Math.sqrt(
    Math.pow(x0, 2) + Math.pow(x1, 2) + Math.pow(x2, 2) + Math.pow(x3, 2))
  def +(that: Quaternion) = new Quaternion(
    x0 + that.x0,
    x1 + that.x1,
    x2 + that.x2,
    x3 + that.x3
  )
  def -(that: Quaternion) = new Quaternion(
    x0 - that.x0,
    x1 - that.x1,
    x2 - that.x2,
    x3 - that.x3
  )
  def *(that: Quaternion) = new Quaternion(
    this.x0 * that.x0 - this.x1 * that.x1 - this.x2 * that.x2 - this.x3 * that.x3,
    this.x0 * that.x1 + this.x1 * that.x0 + this.x2 * that.x3 - this.x3 * that.x2,
    this.x0 * that.x2 - this.x1 * that.x3 + this.x2 * that.x0 + this.x3 * that.x1,
    this.x0 * that.x3 + this.x1 * that.x2 - this.x2 * that.x1 + this.x3 * that.x0
  )
  override def toString: String = s"$x0 + $x1 i + $x2 j + $x3 k"
}
