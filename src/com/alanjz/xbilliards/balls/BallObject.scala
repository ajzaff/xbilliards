package com.alanjz.xbilliards.balls

import java.awt.Color
import java.awt.geom.{Point2D, Rectangle2D}

class BallObject(val ball : Ball, val pt: Point2D.Double) {
  
  /**
   * The velocity of the ball
   */
  
  val vel = new Point2D.Double()
  
  /**
   * Gets the rectangular bounds of this ball
   */
  
  def bounds2D = new Rectangle2D.Double(pt.x - BallObject.size/2, pt.y - BallObject.size/2, BallObject.size,BallObject.size)
}

object BallObject {
  
  /**
   * The typical diameter of a billiards ball.
   *
   * In pixels.
   */
  
  val size = 24
}