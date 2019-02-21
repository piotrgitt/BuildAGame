/*
 * Class inhereted of GameObject Class
 */
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;


public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id){
        super(x,y,id);
        velX=5;
        velY=5;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        
        /**
         * if an Enemy hits our window wall, his velocity will reverse - he just bounce off
         */
        if(x>Game.WIDTH - 16 || x<0) velX*=-1;      
        if(y>Game.HEIGHT - 16 || y<0) velY*=-1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);  //set color of render object
        g.fillRect(x, y, 16, 16);  //fill renctangle - Dimenstion of him is 16x16px
    }
}
