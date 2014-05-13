package org.spacenut.billiards

import java.awt.event.MouseMotionListener
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.Point

class BilliardsEvents extends MouseMotionListener with MouseListener {
  
  private var mousePoint = (0,0)
  private var drag = false
  
  val dragPoint = new Point()
  def mouse = mousePoint
  def dragging = drag
  def mouseMoved(e: MouseEvent) {
    mousePoint = (e.getX(), e.getY())
  }
  
  def mouseDragged(e: MouseEvent) {
    mousePoint = (e.getX(), e.getY())
    drag = true
  }
  
  def mouseEntered(e: MouseEvent) {
    
  }
  
  def mouseExited(e: MouseEvent) {
    
  }
  
  def mouseClicked(e: MouseEvent) {
    
  }
  
  def mousePressed(e: MouseEvent) {
    dragPoint.setLocation(e.getX(), e.getY())
  }
  
  def mouseReleased(e: MouseEvent) {
    dragPoint.setLocation(0,0)
    drag = false
  }
}