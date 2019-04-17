/*
 * Class inhereted of GameObject Class
 */
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    Random r = new Random();
    Color rgbColor;

    public MenuParticle(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = r.nextInt(14)-7; //from -6 to 6
        velY = r.nextInt(14)-7;//from -6 to 6
        if(velX == 0){
            velX=1;
        }
        if(velY == 0){
            velY=1;
        }
       
        //creating new colorr
        
        rgbColor = new Color(r.nextInt(122), r.nextInt(122), r.nextInt(155)+100 ); //RGB
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        /**
         * if an Enemy hits our window wall, his velocity will reverse - he just
         * bounce off(multiplying by -1)
         */
        if (x > Game.WIDTH - 16 || x < 0) {
            velX *= -1;
        }
        if (y > Game.HEIGHT - 16 || y < 0) {
            velY *= -1;
        }

        handler.addObject(new Trail(x, y, rgbColor, 16.0f, 16.0f, 0.05f, ID.Trail, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(rgbColor);  //set color of render object
        g.fillRect((int)x, (int)y, 16, 16);  //fill renctangle - Dimenstion of him is 16x16px
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);  //16 x 16 is dimensions of our rectangle
    }

}
