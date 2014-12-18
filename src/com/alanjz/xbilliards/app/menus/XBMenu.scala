package com.alanjz.xbilliards.app.menus

import javax.swing.{JMenuItem, JMenu}

abstract class XBMenu(name : String) {
  private val menu = new JMenu(name)

  def add(menuItem: JMenuItem) = menu.add(menuItem)

  def add(menu: JMenu) = menu.add(menu)

  def addSeparator() : Unit = menu.addSeparator()
}

object XBMenu {
  implicit def toJMenu(lhs : XBMenu) : JMenu = lhs.menu
}