package com.alanjz.xbilliards.balls

import java.awt.Color

/**
 * Created by alan on 12/17/14.
 */
package object colors {

  abstract class BallColor(awtColor : Color) {
    def toAwtColor = awtColor
  }

  object BallColor {
    implicit def toAwtColor(lhs: BallColor) : Color = lhs.toAwtColor
  }

  sealed abstract class StandardColor(awtColor : Color) extends BallColor(awtColor)

  case object White extends StandardColor(Color.white)
  case object Blue extends StandardColor(Color.blue)
  case object Purple extends StandardColor(new Color(127, 0, 255))
  case object Black extends StandardColor(Color.black)
  case object Yellow extends StandardColor(Color.yellow)
  case object Red extends StandardColor(Color.red)
  case object Green extends StandardColor(Color.green)
  case object Orange extends StandardColor(Color.orange)
  case object Brown extends StandardColor(new Color(102, 51, 0))
}
