package com.alanjz.xbilliards.app.menus

import java.awt.event.{ActionListener, ActionEvent}
import javax.swing.{KeyStroke, JMenuItem}

/**
 * Created by alan on 12/17/14.
 */
abstract class XBMenuItem(val name : String,
                          key : Int,
                          modifiers : Int = 0)
{
  val act : (ActionEvent => Unit)

  private final val menuItem = new JMenuItem(name) {
    setAccelerator(KeyStroke.getKeyStroke(key, modifiers))
    addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent) = act(e)
    })
  }
}

object XBMenuItem {
  implicit def toJMenuItem(lhs : XBMenuItem) : JMenuItem = lhs.menuItem
}