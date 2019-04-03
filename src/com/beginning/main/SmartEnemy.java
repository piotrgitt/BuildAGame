package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    
    int distX;
    int distY;
    int distance;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        
        for(int i=0; i<handler.objects.size();i++){
            if(handler.objects.get(i).id == ID.Player) player = handler.objects.get(i);
        }
        
        velX=0;
        velY=0;


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
        
        
        
        distX = x - player.getX();
        distY = y - player.getY();
        distance = (int) Math.hypot(distX, distY);
        
        //distX * Z, gdzie Z określa szybkość poruszania się (0 - nie porrusza się, 5 - w chuj szybko)
        velX = (int)((-1/(float)distance)*((float)distX*1.8f));
        velY = (int)((-1/(float)distance)*((float)distY*1.8f));

        System.out.println("VEL X: "+velX);
        System.out.println("VEL Y: "+velY);
        
        

        handler.addObject(new Trail(x, y, Color.green, 16, 16, 0.025f, ID.Trail, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);  //set color of render object
        g.fillRect(x, y, 16, 16);  //fill renctangle - Dimenstion of him is 16x16px
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);  //16 x 16 is dimensions of our rectangle
    }

}
