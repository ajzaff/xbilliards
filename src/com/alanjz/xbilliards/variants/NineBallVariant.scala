package com.alanjz.xbilliards.variants
import java.awt.geom.Point2D.Double

import com.alanjz.xbilliards.balls._
import com.alanjz.xbilliards.math.CollisionManager

import scala.util.Random

case object NineBallVariant extends Variant {
  val name = "nine-ball"
  override def newRack(cm : CollisionManager) : Unit = {
    val ballSize = BallObject.size
    val nineBall = new Double(652, 249)
    val oneBall = new Double(652-2*ballSize, 249)
    val locations = List(
      new Double(652-ballSize, 249-ballSize/2),
      new Double(652-ballSize, 249+ballSize/2),
      new Double(652, 249-ballSize),
      new Double(652, 249+ballSize),
      new Double(652+ballSize, 249-ballSize/2),
      new Double(652+ballSize, 249+ballSize/2),
      new Double(652+2*ballSize, 249)
    )
    val balls = Random.shuffle(List(
      TwoBall, ThreeBall, FourBall, FiveBall, SixBall, SevenBall, EightBall
    ))

    cm.balls += new BallObject(CueBall, new Double(205, 244))
    cm.balls += new BallObject(OneBall, oneBall)
    cm.balls += new BallObject(NineBall, nineBall)
    for(i <- 0 to 6) {
      cm.balls += new BallObject(balls(i), locations(i))
    }
  }
}