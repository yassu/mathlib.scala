package mathlib.test.linear
import mathlib.linear.RealVector

class RealVectorSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    val v = new RealVector(2.0, 3.0)
    v must_== new RealVector(2.0, 3.0)
  }
  "#abs2" >> {
    val v = new RealVector(1.0, -2.0, 3.0)
    v.abs2 must_== 14.0
  }
  "#abs" >> {
    val v = new RealVector(1.0, -2.0, 3.0)
    v.abs must_== Math.sqrt(14.0)
  }
  "#isApproximated" >> {
    "same" >> {
      val v1 = new RealVector(1.0, -2.0, 3.0)
      val v2 = new RealVector(1.0, -2.0, 3.0)
      v1.isApproximated(v2) must beTrue
    }
    "uncorrect" >> {
      val v1 = new RealVector(1.0, -2.0, 3.0)
      val v2 = new RealVector(0.9, -1.9, 3.1)
      v1.isApproximated(v2) must beFalse
    }
  }
  "unary_+" >> {
    val v = new RealVector(1.0, -2.0, 3.0)
    +v must_== v
  }
  "unary_-" >> {
    val v = new RealVector(1.0, -2.0, 3.0)
    -v must_== new RealVector(-1.0, 2.0, -3.0)
  }
}
