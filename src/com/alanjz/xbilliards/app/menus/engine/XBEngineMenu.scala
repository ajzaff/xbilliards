package com.alanjz.xbilliards.app.menus.engine

import javax.swing.JMenuItem

import com.alanjz.xbilliards.app.menus.XBMenu

class XBEngineMenu extends XBMenu("Engine") {
  add(new JMenuItem("Start engine"))
  add(new JMenuItem("Stop engine"))
  add(new JMenuItem("Ponder engine"))
  add(new JMenuItem("Settings"))
  add(new JMenuItem("About"))
}
