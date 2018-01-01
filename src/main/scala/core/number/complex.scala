package mathlib.number

case class Complex(x: Double, y: Double) {
  def unary_+(): Complex = this
  def unary_-(): Complex = new Complex(-x, -y)
  def +(that: Complex): Complex = new Complex(
    x + that.x,
    y + that.y
  )
}
