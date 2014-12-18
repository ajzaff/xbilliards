package com.alanjz.xbilliards.app.events

import java.awt.Point
import java.awt.event.{MouseMotionListener, MouseEvent, MouseListener}

final class XBMouse {

  private val mouseObject = new MouseMotionListener with MouseListener
  {
    override def mouseMoved(e: MouseEvent) = _mouseMoved(e)
    override def mouseDragged(e: MouseEvent) = _mouseDragged(e)
    override def mouseEntered(e: MouseEvent) = _mouseEntered(e)
    override def mouseExited(e: MouseEvent) = _mouseExited(e)
    override def mouseClicked(e: MouseEvent) = _mouseClicked(e)
    override def mousePressed(e: MouseEvent) = _mousePressed(e)
    override def mouseReleased(e: MouseEvent) = _mouseReleased(e)
  }

  private def _mouseMoved(e: MouseEvent) {
    mousePoint = (e.getX, e.getY)
  }

  private def _mouseDragged(e: MouseEvent) {
    mousePoint = (e.getX, e.getY)
    drag = true
  }

  private def _mouseEntered(e: MouseEvent) {

  }

  private def _mouseExited(e: MouseEvent) {

  }

  private def _mouseClicked(e: MouseEvent) {

  }

  private def _mousePressed(e: MouseEvent) {
    dragPoint.setLocation(e.getX, e.getY)
  }

  private def _mouseReleased(e: MouseEvent) {
    dragPoint.setLocation(0,0)
    drag = false
  }

  private var mousePoint = (0,0)
  private var drag = false
  val dragPoint = new Point()
  def mouse = mousePoint
  def dragging = drag
}

object XBMouse {
  implicit def toMouseMotionListenerWithMouseListener(lhs : XBMouse) :
    MouseMotionListener with MouseListener = lhs.mouseObject
}