
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BossEnemy extends GameObject {

    private Handler handler;
    private int timer = 200;
    private int timer2 = 80;
    private int spawn;
    private boolean readyToFire = false;
    private int chanceToFireBullet; // highier number - less chance to shot an bullet
    private BufferedImage bossImage;
    

    public BossEnemy(float x, float y, ID id, Handler handler, int chanceToFireBullet) {
        super(x, y, id);

        this.handler = handler;
        
        velX = 0.0f;
        velY = 0.85f;
        
        this.chanceToFireBullet = chanceToFireBullet;
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        
        bossImage = ss.grabImage(1, 5, 96, 96);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        
        if (x > Game.WIDTH - 96 || x < 0) {
            velX *= -1;
        }
//        if (y > Game.HEIGHT - 96 || y < 0) {  //Collision with top and bottom walls
//            velY *= -1;
//        }
        
        //handler.addObject(new Trail(x, y, Color.red, 96.0f, 96.0f, 0.025f, ID.Trail, handler));
        
        if(timer == 0) {
            
            velY = 0;
            timer2--;
            
        } else timer --;
        
        if(timer2 == 0) {
            velX = 3;
            readyToFire = true;
        }
        
        //SPAWN BULLET SECTION --------------------
        if(readyToFire == true){
            spawn = random.nextInt(chanceToFireBullet);
            if(spawn == 0){
                handler.addObject(new BossBullet(x+40, y+66, ID.BossBullet, handler));
           }
        }
        
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);                        //set color of boss
        g.fillRect((int)x, (int)y, 96, 96);           //fill renctangle - Dimenstion of him is 16x16px
        g.drawImage(bossImage, (int)x, (int)y, null);
    }   

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 96 );  //16 x 16 is dimensions of our rectangle
    }

}
