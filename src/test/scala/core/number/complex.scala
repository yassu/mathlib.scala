package mathlib.test.number
import mathlib.number.Complex

class ComplexSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    "#WithAllArguments" >> {
      val z = new Complex(1, 2)
      z must_== new Complex(1, 2)
    }
  }
  "#unary_+" >> {
    val z = new Complex(1, 2)
    +z must_== new Complex(1, 2)
  }
  "#unary_-" >> {
    val z = new Complex(1, 2)
    -z must_== new Complex(-1, -2)
  }
  "#+" >> {
    val z1 = new Complex(2, 3)
    val z2 = new Complex(5, 7)
    (z1 + z2) must_== new Complex(7, 10)
  }
  "#-" >> {
    val z1 = new Complex(2, 3)
    val z2 = new Complex(5, 7)
    (z1 - z2) must_== new Complex(-3, -4)
  }
}
