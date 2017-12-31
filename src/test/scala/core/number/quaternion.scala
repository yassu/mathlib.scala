package mathlib.test.core.number
import mathlib.core.number._

import org.specs2._

class QuaternionSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    "#WithAllArguments" >> {
      val q = new Quaternion(1.0, 2.0, 3.0, 4.0)
      q must_== new Quaternion(1.0, 2.0, 3.0, 4.0)
    }
  }
}
