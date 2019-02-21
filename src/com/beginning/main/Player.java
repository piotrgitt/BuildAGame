
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {
    
    
    public Player(int x, int y, ID id){
       super(x, y, id);
    }


    public void tick() {
        x = x + velX;
        y = y + velY;
        
    }


    public void render(Graphics g) {
        if(id == ID.Player){
            g.setColor(Color.red);
        }
        else if(id == ID.Player2){
            g.setColor(Color.white);
        }
        
        g.fillRect(x, y, 32, 32);
        
    }
    
   
    
    
}
