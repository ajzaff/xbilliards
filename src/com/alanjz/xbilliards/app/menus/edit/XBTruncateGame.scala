package com.alanjz.xbilliards.app.menus.edit

import java.awt.event.{ActionEvent, KeyEvent}

import com.alanjz.xbilliards.app.menus.XBMenuItem

class XBTruncateGame extends XBMenuItem("Truncate Game", KeyEvent.VK_END) {
  override val act = (_ : ActionEvent) => {}
}
