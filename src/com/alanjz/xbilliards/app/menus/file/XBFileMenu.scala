package com.alanjz.xbilliards.app.menus.file

import javax.swing.JMenu

import com.alanjz.xbilliards.app.menus.XBMenu

/**
 * Created by alan on 12/17/14.
 */
class XBFileMenu extends XBMenu("File") {
  add(new XBNewGame)
  add(new XBNewVariant)
  addSeparator()
  add(new XBLoadGame)
  addSeparator()
  add(new XBSaveGame)
  addSeparator()
  add(new XBQuit)
}
