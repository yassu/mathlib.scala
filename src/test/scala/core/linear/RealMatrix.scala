package mathlib.test.linear
import mathlib.linear.RealMatrix
import mathlib.linear.RealVector

class RealMatrixSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    val v = new RealMatrix(new RealVector(1.0))
    v must_== new RealMatrix(new RealVector(1.0))
  }
}
