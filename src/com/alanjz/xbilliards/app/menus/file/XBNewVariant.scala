package com.alanjz.xbilliards.app.menus.file

import java.awt.event.{ActionEvent, InputEvent, KeyEvent}

import com.alanjz.xbilliards.app.menus.XBMenuItem

class XBNewVariant extends XBMenuItem("New variant",
  KeyEvent.VK_V,
  InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK)
{

  override val act = (_ : ActionEvent) => {}
}