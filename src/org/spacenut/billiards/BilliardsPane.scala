package org.spacenut.billiards

import javax.swing.JPanel
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Color
import javax.imageio.ImageIO
import scala.io.BufferedSource
import java.io.File
import org.spacenut.billiards.BilliardsApp._
import java.awt.Graphics2D
import java.awt.RenderingHints
import math.{atan2,sqrt,pow,min}

class BilliardsPane extends JPanel {
  setPreferredSize(new Dimension(1000, 600))
  
  val table = ImageIO.read(new File("images/tablesc.png"))
  val cue = ImageIO.read(new File("images/cue.png"))
  
  override def paint(g: Graphics) {
    var g2d = g.create().asInstanceOf[Graphics2D]
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    g2d.setColor(Color.black)
    g2d.fillRect(0, 0, getWidth(), getHeight())
    g2d.translate(ballManager.tableOffset.x, ballManager.tableOffset.y)
    
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

    // Draw the balls to the table
    val iter = ballManager.balls.iterator()
    val size = BilliardsBall.size
    while(iter.hasNext()) {
      val ball = iter.next();
      g2d.setColor(ball.color)
      g2d.fillOval(ball.pt.x.toInt-size/2, ball.pt.y.toInt-size/2, size,size)
    }
    
    // Draw the cue ball's bounding box
    /*val cueBallRect = cueBall.bounds2D
    g2d.drawRect(cueBallRect.x.toInt,cueBallRect.y.toInt,
        cueBallRect.width.toInt,cueBallRect.height.toInt)*/
    
    /*
     * Draw the cue floating around the cue ball
     */
    val tableOffset = ballManager.tableOffset
    val cueBallCenter = cueBall.pt
    val mouse = 
      if(events.dragging)
        (events.dragPoint.x-tableOffset.x, events.dragPoint.y-2*tableOffset.y)
      else
        (events.mouse._1-tableOffset.x, events.mouse._2-2*tableOffset.y)
    val cueX = cueBallCenter.x-mouse._1
    val cueY = cueBallCenter.y-mouse._2
    val dragOffset =
      if(events.dragging)
        min(100, sqrt(pow(events.dragPoint.x-events.mouse._1,2) +
            pow(events.dragPoint.y-events.mouse._2,2))).toInt
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