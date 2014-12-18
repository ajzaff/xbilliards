package com.alanjz.xbilliards.variants

import com.alanjz.xbilliards.math.CollisionManager

/**
 * Created by alan on 12/17/14.
 */
abstract class Variant {
  val name : String
  def newRack(cm : CollisionManager) : Unit
}
