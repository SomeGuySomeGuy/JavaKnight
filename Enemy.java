/**
 * [Enemy.java]
 * Description: The class for enemies
 * @author Jonathan, Ray, Wajeeh
 * @version 1.0, May 28, 2021
 */

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;


abstract class Enemy extends Character {

  /**
   * draw
   * method to draw the enemy
   * @param g, the graphics object, offSetX, how much the x is off by, offSetY, how much the y is off by
   */
 public void draw(Graphics g, double offSetX, double offSetY) {

  g.setColor(Color.RED);
  g.drawImage(this.getSprite(), (int) (getX() - getWidth() / 2 - offSetX), (int) (getY() - getHeight() / 2 - offSetY), null);
 }

 /**
  * getHit
  * method to detect if a player projectile hits the enemy and reduces health as well if hit
  * @param player, the player
  */
 public void getHit(Player player) {

  for (int i = 0; i < (player.getProjectilesList()).size(); i++) {

   if (player.getProjectilesList().get(i).getHitbox().intersects(this.getHitbox())) {
    
    this.setHealth(this.getHealth() - player.getWeapon().getDamage());
    player.getProjectilesList().remove(i);
   }

  }
  
 }


 /**
  * attack
  * abstract method to attack the player
  * @param player, the player
  */
 public abstract void attack(Player player);
 
 
//constructor 
 Enemy(double x, double y, int width, int height, String name, BufferedImage sprite, double health, Weapon weapon) {
  super(x, y, width, height, name, sprite, health, weapon);
   
 }

}