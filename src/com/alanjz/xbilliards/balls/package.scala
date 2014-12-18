package com.alanjz.xbilliards

import com.alanjz.xbilliards.balls.colors.BallColor
import com.alanjz.xbilliards.balls.colors._

package object balls {

  sealed abstract class StandardBall(val color : BallColor, val name : String) extends Ball

  object StandardBall {
    implicit def ordering[A <: StandardBall with Numbered] : Ordering[A] = new Ordering[A] {
      override def compare(x : A, y : A) : Int = x.number - y.number
    }
  }

  case object CueBall extends StandardBall(White, "cue")

  case object OneBall extends StandardBall(Yellow, "one") with Numbered {
    override val number : Int = 1
  }

  case object TwoBall extends StandardBall(Blue, "two") with Numbered {
    override val number : Int = 2
  }

  case object ThreeBall extends StandardBall(Red, "three") with Numbered {
    override val number : Int = 3
  }

  case object FourBall extends StandardBall(Purple, "four") with Numbered {
    override val number : Int = 4
  }

  case object FiveBall extends StandardBall(Orange, "five") with Numbered {
    override val number : Int = 5
  }

  case object SixBall extends StandardBall(Green, "six") with Numbered {
    override val number : Int = 6
  }

  case object SevenBall extends StandardBall(Brown, "seven") with Numbered {
    override val number : Int = 7
  }

  case object EightBall extends StandardBall(Black, "eight") with Numbered {
    override val number : Int = 8
  }

  case object NineBall extends StandardBall(Yellow, "nine") with Numbered {
    override val number : Int = 9
  }

  case object TenBall extends StandardBall(Blue, "ten") with Numbered {
    override val number : Int = 10
  }

  case object ElevenBall extends StandardBall(Red, "eleven") with Numbered {
    override val number : Int = 11
  }

  case object TwelveBall extends StandardBall(Purple, "twelve") with Numbered {
    override val number : Int = 12
  }

  case object ThirteenBall extends StandardBall(Orange, "thirteen") with Numbered {
    override val number : Int = 13
  }

  case object FourteenBall extends StandardBall(Green, "fourteen") with Numbered {
    override val number : Int = 14
  }

  case object FifteenBall extends StandardBall(Brown, "fifteen") with Numbered {
    override val number : Int = 15
  }
}
