package com.alanjz.xbilliards.app.menus.file

import java.awt.event.{ActionEvent, InputEvent, KeyEvent}

import com.alanjz.xbilliards.app.XBApp
import com.alanjz.xbilliards.app.menus.XBMenuItem

class XBNewGame extends XBMenuItem("New game", KeyEvent.VK_N, InputEvent.CTRL_MASK) {
  override val act = (_ : ActionEvent) => {
    XBApp.game.start()
  }
}