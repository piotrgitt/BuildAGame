
package com.beginning.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Player extends GameObject {
    
    public Handler handler;
    
    public Player(int x, int y, ID id, Handler handler){
       super(x, y, id);
       this.handler=handler;
    }


    @Override
    public void tick() {
        
        x = x + velX;
        y = y + velY;
        
        
        x = Game.clamp(x, 0, Game.WIDTH-32); //every tick check 
        y = Game.clamp(y, 0, Game.HEIGHT-32); 
        
        colission();
    }


    @Override
    public void render(Graphics g) {
        Graphics2D g2d;
        g2d = (Graphics2D)g;//change type of 'g' for Grarphics2d for collision bounding
        
        
        
        g.setColor(Color.blue);   //set color of render object
        g.fillRect(x, y, 32, 32);  //fill renctangle - Dimenstion of him is 16x16px
        
        //Collision border of player
        //g.setColor(Color.red);
        //g2d.draw(getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
    public void colission(){
        GameObject tempObject;
        for(int i=0; i<handler.objects.size(); i++){
            tempObject = handler.objects.get(i);
            //Loop is iterating for all objects in game. When an object is BasicEnemy colission code is turning on
            if(tempObject.getId() == ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code - what happens when we collide with ANY another object
                    HUD.HEALTH-=4;
                }
            }
        }
    
    }
    
   
    
    
}
