package com.alanjz.xbilliards.app

import java.awt.geom.Point2D
import javax.swing.JFrame

import com.alanjz.xbilliards.app.events.XBMouse
import com.alanjz.xbilliards.balls._
import com.alanjz.xbilliards.game.Game
import com.alanjz.xbilliards.math.CollisionManager

object XBApp extends App {

  var game = new Game
  val mouse = new XBMouse
  val frame = new XBFrame

  while(true) {
    frame.repaint()
    Thread.sleep(20)
  }
}