
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {
    
    
    public Player(int x, int y, ID id){
        super(x, y, id);
        velX=random.nextInt(11)+1;
        velY=random.nextInt(11)+1;
    }


    public void tick() {
        x = x + velX;
        y = y + velY;
        
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
        
    }
    
   
    
    
}
