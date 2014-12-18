package com.alanjz.xbilliards.app.menus.mode

import javax.swing.JMenuItem

import com.alanjz.xbilliards.app.menus.XBMenu

/**
 * Created by alan on 12/17/14.
 */
class XBModeMenu extends XBMenu("Mode") {
  add(new JMenuItem("Machine"))
  add(new JMenuItem("Two Machines"))
  add(new JMenuItem("Analysis"))
}
