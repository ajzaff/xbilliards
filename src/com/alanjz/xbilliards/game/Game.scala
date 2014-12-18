package com.alanjz.xbilliards.game

import com.alanjz.xbilliards.math.CollisionManager
import com.alanjz.xbilliards.variants.NineBallVariant

/**
 * Created by alan on 12/17/14.
 */
class Game extends Runnable {

  val thread = new Thread(this)
  val collisionManager = new CollisionManager
  val variant = NineBallVariant
  private var playing = false

  def isPlaying = playing

  def start(): Unit = {
    if(!isPlaying) {
      playing = true
      variant.newRack(collisionManager)
      thread.start()
    }
  }

  def stop() : Unit = {
    playing = false
  }

  def run() : Unit = {
    while(playing) {
      collisionManager.update()
      Thread sleep 20
    }
  }
}