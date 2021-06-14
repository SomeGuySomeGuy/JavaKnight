/**
 * [Enemy.java]
 * Description: The class for enemies
 * @author Jonathan, Ray, Wajeeh
 * @version 1.0, May 28, 2021
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;

abstract class Enemy extends Character {

 private Player player;


 public void draw(Graphics g, double offSetX, double offSetY) {

  g.setColor(Color.RED);
  g.drawImage(this.getSprite(), (int) (getX() - getWidth() / 2 - offSetX), (int) (getY() - getHeight() / 2 - offSetY), null);
 }

 public void getHit(Player player) {

  for (int i = 0; i < (player.getProjectilesList()).size(); i++) {

   if (player.getProjectilesList().get(i).getHitbox().intersects(this.getHitbox())) {
    
    this.setHealth(this.getHealth() - player.getWeapon().getDamage());
    player.getProjectilesList().remove(i);
   }

  }
  
 }


 public abstract void attack(Player player,BufferedImage sprite);
 
 

 Enemy(double x, double y, int width, int height, String name, BufferedImage sprite, double health, Weapon weapon) {
  super(x, y, width, height, name, sprite, health, weapon);
   
 }

}