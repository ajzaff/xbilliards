package com.alanjz.xbilliards.app

import javax.swing.JFrame

final class XBFrame {

  /*
   * Configure the game window
   */

  private val frame = new JFrame("XBilliards")
  frame.add(new XBGraphicsPanel(XBApp.game)) // add the billiards view

  /*
   * Configure the game menu
   */

  frame.setJMenuBar(new XBMenuBar) // set the menu bar
  frame.pack() // pack the frame

  /*
   * Display the window, center it,
   * and do final initialization
   */

  frame.setResizable(false)
  frame.setLocationRelativeTo(null)
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setVisible(true)

  // Add some events
  frame.addMouseMotionListener(XBApp.mouse)
  frame.addMouseListener(XBApp.mouse)
}

object XBFrame {
  implicit def toJFrame(lhs : XBFrame) : JFrame = lhs.frame
}


