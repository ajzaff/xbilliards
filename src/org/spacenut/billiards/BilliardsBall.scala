package org.spacenut.billiards

import java.awt.Color
import java.awt.Point
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import org.spacenut.billiards.BilliardsBall._

class BilliardsBall(val color: Color, val pt: Point2D.Float) {
  
  /**
   * The velocity of the ball
   */
  
  val vel = new Point2D.Float()
  
  /**
   * Gets the rectangular bounds of this ball
   */
  
  def bounds2D = new Rectangle2D.Float(pt.x - size/2, pt.y - size/2, size,size)
}

object BilliardsBall {
  
  /**
   * The typical diameter of a billiards ball
   */
  
  val size = 24
}