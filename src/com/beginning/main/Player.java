package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    public Handler handler;
    private BufferedImage player_image;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        
        player_image = ss.grabImage(1, 1, 32, 32);
    }

    @Override
    public void tick() {

        x = x + velX;
        y = y + velY;

        x = Game.clamp(x, 0, Game.WIDTH - 32);  
        y = Game.clamp(y, 0, Game.HEIGHT - 32);

        colission();    //Every tick it check colission with enemies
        //handler.addObject(new Trail(x, y, Color.blue, 32, 32, 0.025f, ID.Trail, handler));
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d;
        g2d = (Graphics2D) g;//change type of 'g' for Grarphics2d for collision bounding
        
        
        //Player Render
        g.setColor(Color.blue);   //set color of render object
        g.fillRect((int)x, (int)y, 32, 32);  //fill renctangle - Dimension of him is 16x16px
        g.drawImage(player_image, (int)x, (int)y, null);
        //Collision border of player
        //g.setColor(Color.red);
        //g2d.draw(getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void colission() {
        GameObject tempObject;
        for (int i = 0; i < handler.objects.size(); i++) {
            tempObject = handler.objects.get(i);
            //Loop is iterating for all objects in game. When an object have an ID below(ex. BossBullet) colission code is turning on
            if (tempObject.getId() == ID.BasicEnemy ||
                    tempObject.getId() == ID.FastEnemy ||
                    tempObject.getId() == ID.SmartEnemy ||
                    tempObject.getId() == ID.BossBullet ||
                    tempObject.getId() == ID.HardEnemy ||
                    tempObject.getId() == ID.BossEnemy ){
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code - what happens when intersect is going with object above(in big OR statement)
                    HUD.HEALTH -= 3.0f;
                }
            }
        }

    }

}
