package mathlib.core.number

case class Quaternion(x0: Double, x1: Double, x2: Double, x3: Double) {
  def this(x0: Double) = this(x0, 0, 0, 0)
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
  override def toString: String = s"$x0 + $x1 i + $x2 j + $x3 k"
}
