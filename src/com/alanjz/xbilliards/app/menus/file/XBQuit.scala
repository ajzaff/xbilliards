package com.alanjz.xbilliards.app.menus.file

import java.awt.event.{ActionEvent, ActionListener, InputEvent, KeyEvent}
import javax.swing.{JMenuItem, KeyStroke}

import com.alanjz.xbilliards.app.menus.XBMenuItem

class XBQuit extends XBMenuItem("Quit", KeyEvent.VK_Q, InputEvent.CTRL_MASK) {
  override val act = (_ : ActionEvent) => System.exit(0)
}
