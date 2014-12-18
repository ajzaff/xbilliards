package com.alanjz.xbilliards.math

import java.awt.Point
import java.awt.geom.Rectangle2D

import com.alanjz.xbilliards.balls.BallObject

import scala.collection.parallel.mutable

class CollisionManager {
  
  /**
   * The typical table offset
   */
  
  val tableOffset = new Point(50,50)
  
  /**
   * The table rectangular bounds
   */
  
  val tableRect = new Rectangle2D.Float(48f,48f,803f,403f)
  
  /**
   * The top-left collision polygon
   */
  
  val topLeft = new Rectangle2D.Float(79f,37f,348f,11f)
  
  /**
   * The top-right collision polygon
   */
  
  val topRight = new Rectangle2D.Float(472f,37f,348f,11f)
  
  /**
   * The bottom-left collision polygon
   */
  
  val bottomLeft = new Rectangle2D.Float(79f,451f,348f,11f)
  
  /**
   * The bottom-right collision polygon
   */
  
  val bottomRight = new Rectangle2D.Float(472f,451f,348f,11f)
  
  /**
   * The rear collision polygon
   */
  
  val back = new Rectangle2D.Float(37f,80f,11f,338f)
  
  /**
   * The front collision polygon
   */
  
  val front = new Rectangle2D.Float(851f,80f,11f,338f)
  
  /**
   * Set of active balls on the table
   */
  
  val balls = new mutable.ParHashSet[BallObject]()
  
  /**
   * Update the game state with elastic collisions
   */
  
  def update() {
    val iter = balls.iterator
    while(iter.hasNext) {
      val ball = iter.next()
      ball.pt.setLocation(ball.vel.x + ball.pt.x, ball.vel.y + ball.pt.y)
      performCollision(ball)
      slowDown(ball)
    }
  }
  
  /**
   * Slows down the ball by a variable multiplicative factor
   */
  private def slowDown(b: BallObject) {
    b.vel.setLocation(b.vel.x*.992, b.vel.y*.992)
    if(b.vel.x + b.vel.y < .2) {
      b.vel.setLocation(0,0)
    }
  }
  
  
  /**
   * Set of collision flagged balls;
   * The balls which have just collided and will
   * not collide again until in the clear or in a pocket
   */
  
  private val collisionFlaggedBalls = new mutable.ParHashSet[BallObject]()
  
  /**
   * Sense a collision and act on it
   */
  
  private def performCollision(b: BallObject) {
    val flagged = collisionFlaggedBalls.contains(b)
    
    if(!flagged && bottomLeft.intersects(b.bounds2D)) {
      b.vel.setLocation(b.vel.x, -b.vel.y)
      collisionFlaggedBalls += b
    }
    
    else if(!flagged && bottomRight.intersects(b.bounds2D)) {
      b.vel.setLocation(b.vel.x, -b.vel.y)
      collisionFlaggedBalls += b
    }
    
    else if(!flagged && topLeft.intersects(b.bounds2D)) {
      b.vel.setLocation(b.vel.x, -b.vel.y)
      collisionFlaggedBalls += b
    }
    
    else if(!flagged && topRight.intersects(b.bounds2D)) {
      b.vel.setLocation(b.vel.x, -b.vel.y)
      collisionFlaggedBalls+= b
    }
    
    else if(!flagged && back.intersects(b.bounds2D)) {
      b.vel.setLocation(-b.vel.x, b.vel.y)
      collisionFlaggedBalls += b
    }
    
    else if(!flagged && front.intersects(b.bounds2D)) {
      b.vel.setLocation(-b.vel.x, b.vel.y)
      collisionFlaggedBalls+= b
    }
    
    // Remove the collision flag;
    // it is safe to collide again
    else {
      collisionFlaggedBalls -= b
    }
  }
}