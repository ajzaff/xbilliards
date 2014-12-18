package com.alanjz.xbilliards.app.menus.view

import javax.swing.JMenuItem

import com.alanjz.xbilliards.app.menus.XBMenu

class XBViewMenu extends XBMenu("View") {
  add(new JMenuItem("Comments"))
  add(new JMenuItem("Tags"))
}
