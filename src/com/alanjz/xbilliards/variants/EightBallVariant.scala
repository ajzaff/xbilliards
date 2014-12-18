package com.alanjz.xbilliards.variants

import com.alanjz.xbilliards.math.CollisionManager

case object EightBallVariant extends Variant {
  val name = "eight-ball"
  override def newRack(cm : CollisionManager) = ???
}