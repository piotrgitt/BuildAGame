
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
        
        
    }


    @Override
    public void render(Graphics g) {
        if(id == ID.Player){
            g.setColor(Color.green);
        }
 
        g.fillRect(x, y, 32, 32);
        
    }
    
   
    
    
}
