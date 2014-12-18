package com.alanjz.xbilliards.app

import javax.swing.JMenuBar

import com.alanjz.xbilliards.app.menus.edit.XBEditMenu
import com.alanjz.xbilliards.app.menus.engine.XBEngineMenu
import com.alanjz.xbilliards.app.menus.file.XBFileMenu
import com.alanjz.xbilliards.app.menus.help.XBHelpMenu
import com.alanjz.xbilliards.app.menus.mode.XBModeMenu
import com.alanjz.xbilliards.app.menus.options.XBOptionsMenu
import com.alanjz.xbilliards.app.menus.view.XBViewMenu

final class XBMenuBar {
  private val menu = new JMenuBar
  menu.add(new XBFileMenu)
  menu.add(new XBEditMenu)
  menu.add(new XBViewMenu)
  menu.add(new XBModeMenu)
  menu.add(new XBEngineMenu)
  menu.add(new XBOptionsMenu)
  menu.add(new XBHelpMenu)
}

object XBMenuBar {
  implicit def toJMenuBar(lhs : XBMenuBar) : JMenuBar = lhs.menu
}