package com.alanjz.xbilliards.app.menus.file

import java.awt.event.{ActionEvent, InputEvent, KeyEvent}

import com.alanjz.xbilliards.app.menus.XBMenuItem

class XBLoadGame extends XBMenuItem("Load game",KeyEvent.VK_O, InputEvent.CTRL_MASK) {
  override val act = (_ : ActionEvent) => {}
}