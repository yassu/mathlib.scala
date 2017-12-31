package mathlib.test.core.number
import mathlib.core.number._

import org.specs2._

class QuaternionSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    "#WithAllArguments" >> {
      val q = new Quaternion(1.0, 2.0, 3.0, 4.0)
      q must_== new Quaternion(1.0, 2.0, 3.0, 4.0)
    }
    "#WithOnlyRealComponent" >> {
      val q = new Quaternion(1.0)
      q must_== new Quaternion(1.0, 0.0, 0.0, 0.0)
    }
  }
  "#+" >> {
    val q1 = new Quaternion(1.0, 2.0, 3.0, 4.0)
    val q2 = new Quaternion(5.0, 6.0, 7.0, 8.0)
    q1 + q2 must_== new Quaternion(6.0, 8.0, 10.0, 12.0)
  }
}
