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
}
