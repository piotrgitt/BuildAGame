
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {
    
    
    public Player(int x, int y, ID id){
       super(x, y, id);
    }


    @Override
    public void tick() {
        
        x = x + velX;
        y = y + velY;
        
        
        x = Game.clamp(x, 0, Game.WIDTH-32);    
        y = Game.clamp(y, 0, Game.HEIGHT-32); 
    }


    @Override
    public void render(Graphics g) {
        if(id == ID.Player){
            g.setColor(Color.green);
        }
 
        g.fillRect(x, y, 32, 32);
        
    }
    
   
    
    
}
