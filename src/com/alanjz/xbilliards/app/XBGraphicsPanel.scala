package com.alanjz.xbilliards.app

import java.awt._
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel
import com.alanjz.xbilliards.balls.{Numbered, CueBall, BallObject}
import com.alanjz.xbilliards.game.Game

import scala.math.{atan2, min, pow, sqrt}

class XBGraphicsPanel(game : Game) {

  private val panel = new JPanel() {
    setPreferredSize(new Dimension(1000, 600))
    override def paint(g : Graphics) = _paint(g)
  }

  val table = ImageIO.read(new File("images/table.png"))
  val cue = ImageIO.read(new File("images/cue.png"))
  
  private def _paint(g: Graphics) {

    val g2d = g.create().asInstanceOf[Graphics2D]
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    
    g2d.setColor(Color.black)
    g2d.fillRect(0, 0, panel.getWidth, panel.getHeight)
    g2d.translate(game.collisionManager.tableOffset.x, game.collisionManager.tableOffset.y)
    
    // Draw the table
    g2d.drawImage(table, 0, 0, null)

    // Draw collision bounds for debugging
    /*g2d.setColor(Color.red)
    g2d.drawRect(ballManager.topLeft.x.toInt,ballManager.topLeft.y.toInt,
        ballManager.topLeft.width.toInt,ballManager.topLeft.height.toInt)
    g2d.drawRect(ballManager.topRight.x.toInt,ballManager.topRight.y.toInt,
        ballManager.topRight.width.toInt,ballManager.topRight.height.toInt)
    g2d.drawRect(ballManager.bottomLeft.x.toInt,ballManager.bottomLeft.y.toInt,
        ballManager.bottomLeft.width.toInt,ballManager.bottomLeft.height.toInt)
    g2d.drawRect(ballManager.bottomRight.x.toInt,ballManager.bottomRight.y.toInt,
        ballManager.bottomRight.width.toInt,ballManager.bottomRight.height.toInt)
    g2d.drawRect(ballManager.back.x.toInt,ballManager.back.y.toInt,
        ballManager.back.width.toInt,ballManager.back.height.toInt)
    g2d.drawRect(ballManager.front.x.toInt,ballManager.front.y.toInt,
        ballManager.front.width.toInt,ballManager.front.height.toInt)
    
    g2d.setColor(Color.green)
    g2d.drawRect(ballManager.tableRect.x.toInt,ballManager.tableRect.y.toInt,
        ballManager.tableRect.width.toInt,ballManager.tableRect.height.toInt) */

    if(game.collisionManager.balls.isEmpty) return

    // Draw the balls to the table
    val iter = game.collisionManager.balls.iterator
    val size = BallObject.size
    while(iter.hasNext) {
      val ball = iter.next()
      g2d.setColor(ball.ball.color)
      g2d.fillOval(ball.pt.x.toInt-size/2, ball.pt.y.toInt-size/2, size,size)

      ball.ball match {
        case n : Numbered =>
          g2d.setColor(new Color(0,0,0,127))
          g2d.fillOval(ball.pt.x.toInt-size/3, ball.pt.y.toInt-size/3, 2*size/3,2*size/3)
          g2d.setColor(Color.white)
          g2d.setFont(new Font("monospace", Font.BOLD, 14))
          val stringWidth = g2d.getFontMetrics.stringWidth(n.number.toString)
          val height = g2d.getFontMetrics.getHeight
          val dh = g2d.getFontMetrics.getDescent
          g2d.drawString(n.number.toString,
            ball.pt.x.toInt-stringWidth/2, ball.pt.y.toInt+height/2-dh/2)
        case _ =>
      }
    }
    
    // Draw the cue ball's bounding box
    /*val cueBallRect = cueBall.bounds2D
    g2d.drawRect(cueBallRect.x.toInt,cueBallRect.y.toInt,
        cueBallRect.width.toInt,cueBallRect.height.toInt)*/
    
    /*
     * Draw the cue floating around the cue ball
     */
    val tableOffset = game.collisionManager.tableOffset
    val cueBall = game.collisionManager.balls.find(_.ball == CueBall).get
    val cueBallCenter = cueBall.pt
    val mouse = 
      if(XBApp.mouse.dragging)
        (XBApp.mouse.dragPoint.x-tableOffset.x, XBApp.mouse.dragPoint.y-2*tableOffset.y)
      else
        (XBApp.mouse.mouse._1-tableOffset.x, XBApp.mouse.mouse._2-2*tableOffset.y)
    val cueX = cueBallCenter.x-mouse._1
    val cueY = cueBallCenter.y-mouse._2
    val dragOffset =
      if(XBApp.mouse.dragging)
        min(100, sqrt(pow(XBApp.mouse.dragPoint.x-XBApp.mouse.mouse._1,2) +
            pow(XBApp.mouse.dragPoint.y-XBApp.mouse.mouse._2,2))).toInt
      else 0
    
    // Draw a line from the mouse to the cue ball
    //g2d.setColor(Color.red)
    //g2d.drawLine(mouse._1, mouse._2, cueBallCenter.x.toInt, cueBallCenter.y.toInt)
    
    //g2d.dispose()
    //g2d = g.create().asInstanceOf[Graphics2D]
    
    g2d.translate(cueBall.pt.x, cueBall.pt.y)
    g2d.rotate(atan2(cueY, cueX))
    g2d.drawImage(cue, -560-size/2-dragOffset, -5, null)
  }
}

object XBGraphicsPanel {
  implicit def toJPanel(lhs : XBGraphicsPanel) : JPanel = lhs.panel
}