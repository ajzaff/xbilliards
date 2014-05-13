package org.spacenut.billiards

import javax.swing.JFrame
import javax.swing.JMenuBar
import javax.swing.JMenu
import javax.swing.JMenuItem
import java.awt.Color
import java.awt.geom.Point2D
import javax.swing.KeyStroke
import java.awt.event.KeyEvent
import java.awt.event.InputEvent
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

object BilliardsApp extends App {
  
  /*
   * Configure the game window
   */
  
  val frame = new JFrame("XBilliards")
  frame.add(new BilliardsPane) // add the billiards view
  
  /*
   * Configure the game menu
   */
  
  val menu = new JMenuBar()
  menu.add(new JMenu("File") {
    
    // New game section
    add(new JMenuItem("New Game") {
      val ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);
      setAccelerator(ctrlN);
    })
    add(new JMenuItem("New Variant") {
      val altShiftV = KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK);
      setAccelerator(altShiftV);
    })
    addSeparator()
    
    // Load game/position section
    add(new JMenuItem("Load Game") {
      val ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
      setAccelerator(ctrlO);
    })
    addSeparator()
    
    // Save game section
    add(new JMenuItem("Save Game") {
      val ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
      setAccelerator(ctrlS);
    })
    addSeparator()
    
    add(new JMenuItem("Quit") {
      val ctrlQ = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);
      setAccelerator(ctrlQ);
      
      addActionListener(new ActionListener() {
        override def actionPerformed(e: ActionEvent) {
          System.exit(0)
        }
      })
    })
  })
  menu.add(new JMenu("Edit") {
    
    // Game manager section
    add(new JMenuItem("Truncate Game") {
      val end = KeyStroke.getKeyStroke(KeyEvent.VK_END, 0);
      setAccelerator(end);
    })
    addSeparator()
    
    // Game manager section
    add(new JMenuItem("Edit Comment"))
    add(new JMenuItem("Edit Tags"))
    addSeparator()
    
    // Control section
    add(new JMenuItem("Backward"))
    add(new JMenuItem("Forward"))
    add(new JMenuItem("Back to Start"))
    add(new JMenuItem("Forward to End"))
  })
  menu.add(new JMenu("View") {
    
    // Annotation
    add(new JMenuItem("Comments"))
    add(new JMenuItem("Tags"))
  })
  menu.add(new JMenu("Mode") {
    
    // Game mode
    add(new JMenuItem("Machine"))
    add(new JMenuItem("Two Machines"))
    add(new JMenuItem("Analysis"))
  })
  menu.add(new JMenu("Engine") {
    add(new JMenuItem("Load Engine"))
  })
  menu.add(new JMenu("Options") {
    add(new JMenuItem("Preferences"))
  })
  menu.add(new JMenu("Help") {
    add(new JMenuItem("About"))
  })

  frame.setJMenuBar(menu) // set the menu bar
  frame.pack() // pack the frame
  
  /*
   * Display the window, center it,
   * and do final initialization
   */

  frame.setResizable(false)
  frame.setLocationRelativeTo(null)
  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setVisible(true)
  
  /*
   * Add a few balls to the table
   */
  val ballManager = new BilliardsCollisionManager
  val events = new BilliardsEvents
  
  // Add some events
  frame.addMouseMotionListener(events)
  frame.addMouseListener(events)
  
  val cueBall = new BilliardsBall(Color.white, new Point2D.Float(500f, 400f))
  ballManager.balls.add(cueBall)
  
  ballManager.balls.add(new BilliardsBall(Color.black, new Point2D.Float(200f, 231f)))
  ballManager.balls.add(new BilliardsBall(Color.green, new Point2D.Float(311f, 153f)))
  
  /*
   * Run the game loop
   */
  
  while(true) {
    frame.repaint()
    ballManager.update
    Thread.sleep(20)
  }
}