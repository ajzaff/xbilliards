package com.alanjz.xbilliards.app.menus.file

import java.awt.event.{ActionEvent, InputEvent, KeyEvent}

import com.alanjz.xbilliards.app.menus.XBMenuItem

class XBSaveGame extends XBMenuItem("Save game",KeyEvent.VK_S, InputEvent.CTRL_MASK) {
  override val act = (_ : ActionEvent) => {}
}