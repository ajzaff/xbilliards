package com.alanjz.xbilliards.app.menus.edit

import javax.swing.JMenuItem

import com.alanjz.xbilliards.app.menus.XBMenu

class XBEditMenu extends XBMenu("Edit") {
  add(new XBTruncateGame)
  addSeparator()
  add(new JMenuItem("Edit Comment"))
  add(new JMenuItem("Edit Tags"))
  addSeparator()
  add(new JMenuItem("Backward"))
  add(new JMenuItem("Forward"))
  add(new JMenuItem("Back to Start"))
  add(new JMenuItem("Forward to End"))
}
