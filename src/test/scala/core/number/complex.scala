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
  "#*" >> {
    val z1 = new Complex(1, 2)
    val z2 = new Complex(3, 5)
    (z1 * z2) must_== new Complex(-7, 11)
  }
  "#/" >> {
    val z1 = new Complex(1, 2)
    val z2 = new Complex(3, 5)
    (z1 / z2 * z2) must_== new Complex(1, 2)
  }
  // "toString" >> {
  //   "toString1" >> {
  //     val z = new Complex(1, 2)
  //     z.toString must_== "1.0 + 2.0 i"
  //   }
  //   "toString2" >> {
  //     val z = new Complex(1, -2)
  //     z.toString must_== "1.0 - 2.0 i"
    // }
  // }
}
