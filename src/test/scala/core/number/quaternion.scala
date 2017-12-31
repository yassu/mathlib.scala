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
  "#real" >> {
    val q = new Quaternion(1.0, 0.0, 0.0, 0.0)
    q.real must_== 1.0
  }
  "conjugate" >> {
    val q = new Quaternion(1.0, 2.0, 3.0, 4.0)
    q.conjugate must_== new Quaternion(1.0, -2.0, -3.0, -4.0)
  }
  "abs" >> {
    var q = new Quaternion(2.0, 3.0, 5.0, 7.0)
    val value = q.abs
    val expected_value = 9.32737
    val error = 0.00001
    val isOk = value > expected_value - error && value < expected_value + error
    isOk must beTrue
  }
  "isApproximated" >> {
    val realValue = new Quaternion(1.000001, 0.99999, 1.000001, -0.000001)
    val expectedValue = new Quaternion(1.0, 1.0, 1.0, 0.0)
    val isOk = expectedValue.isApproximated(realValue, 0.00001)
    isOk must beTrue
  }
  "#+" >> {
    "for real number" >> {
      val q = new Quaternion(1.0, 2.0, 3.0, 4.0)
      q + 2.0 must_== new Quaternion(3.0, 2.0, 3.0, 4.0)
    }
    "for Quaternion" >> {
      val q1 = new Quaternion(1.0, 2.0, 3.0, 4.0)
      val q2 = new Quaternion(5.0, 6.0, 7.0, 8.0)
      q1 + q2 must_== new Quaternion(6.0, 8.0, 10.0, 12.0)
    }
  }
  "#-" >> {
    val q1 = new Quaternion(2.0, 3.0, 5.0, 7.0)
    val q2 = new Quaternion(13.0, 17.0, 19.0, 23.0)
    q1 - q2 must_== new Quaternion(-11.0, -14.0, -14.0, -16.0)
  }
  "#*" >> {
    val q1 = new Quaternion(1.0, 2.0, 3.0, 4.0)
    val q2 = new Quaternion(5.0, 6.0, 7.0, 8.0)
    q1 * q2 must_== new Quaternion(-60.0, 12, 30, 24)
  }
  "#/" >> {
    "for Quaternion" >> {
      val q1 = new Quaternion(1.0, 2.0, 3.0, 4.0)
      val q2 = new Quaternion(2.0, 3.0, 4.0, 5.0)
      val isOk = ((q1/q2) * q2).isApproximated(q1, 0.00001)
      isOk must beTrue
    }
    "for Real number" >> {
      val q = new Quaternion(1.0, 2.0, 3.0, 4.0)
      val isOk = (q / 2.0).isApproximated( new Quaternion(0.5, 1.0, 1.5, 2.0), 0.00001)
      isOk must beTrue
    }
  }
  "#toString" >> {
    val q = new Quaternion(1.0, 2.0, 3.0, 4.0)
    q.toString must_== "1.0 + 2.0 i + 3.0 j + 4.0 k"
  }
}
