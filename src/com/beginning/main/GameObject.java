/**
 * 
 * Abstract super class of all objects in our game
 */
package com.beginning.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class  GameObject {
    
    Random random = new Random();       
    protected ID id;       
    
    protected int x, y;
    protected int velX, velY; 
    
    

    
    //Constuctor
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    
    
    /**
     * Abstract methods - only for using by inherent classes(like player)
     */
    public abstract void tick();
    public abstract void render(Graphics g);
    //using renctangle to handle all the collisions
    //Its Java library Class
    //Return TRUE or FALSE
    public abstract Rectangle getBounds();
    
    
    
    
    
    

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    
    
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    
    
    public int getVelX() {
        return velX;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }

    
    
    public int getVelY() {
        return velY;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    
    
    
    /**
     * Here Get and Set are for an object!
     */
    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    
}
