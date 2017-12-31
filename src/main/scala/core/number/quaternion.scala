package mathlib.core.number

case class Quaternion(x0: Double, x1: Double, x2: Double, x3: Double) {
  def this(x0: Double) = this(x0, 0, 0, 0)
  def real(): Double = x0
  def conjugate(): Quaternion = new Quaternion(x0, -x1, -x2, -x3)
  def abs():Double = Math.sqrt((this * this.conjugate).real)
  def isApproximated(that: Quaternion, precision: Double) =
    (x0 - that.x0).abs < precision &&
    (x1 - that.x1).abs < precision &&
    (x2 - that.x2).abs < precision &&
    (x3 - that.x3).abs < precision
  def +(that: Quaternion) = new Quaternion(
    x0 + that.x0,
    x1 + that.x1,
    x2 + that.x2,
    x3 + that.x3
  )
  def +(y: Double) = new Quaternion(
    x0 + y,
    x1,
    x2,
    x3
  )
  def -(that: Quaternion) = new Quaternion(
    x0 - that.x0,
    x1 - that.x1,
    x2 - that.x2,
    x3 - that.x3
  )
  def -(y: Double) = new Quaternion(
    x0 - y,
    x1,
    x2,
    x3
  )
  def *(that: Quaternion) = new Quaternion(
    this.x0 * that.x0 - this.x1 * that.x1 - this.x2 * that.x2 - this.x3 * that.x3,
    this.x0 * that.x1 + this.x1 * that.x0 + this.x2 * that.x3 - this.x3 * that.x2,
    this.x0 * that.x2 - this.x1 * that.x3 + this.x2 * that.x0 + this.x3 * that.x1,
    this.x0 * that.x3 + this.x1 * that.x2 - this.x2 * that.x1 + this.x3 * that.x0
  )
  def /(that: Quaternion): Quaternion = this * that.conjugate / Math.pow(that.abs, 2)
  def /(y: Double): Quaternion = {
    new Quaternion(
      this.x0 / y,
      this.x1 / y,
      this.x2 / y,
      this.x3 / y
    )
  }
  override def toString: String = s"$x0 + $x1 i + $x2 j + $x3 k"
}
