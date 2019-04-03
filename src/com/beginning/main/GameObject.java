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
    
    protected float x, y;
    protected float velX, velY; 
    
    

    
    //Constuctor
    public GameObject(float x, float y, ID id){
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
    //getBounds() - used for colission borrder of GameObjects
    public abstract Rectangle getBounds();
    
    
    
    
    
        
    
    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }

    
    
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    
    
    public float getVelX() {
        return velX;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }

    
    
    public float getVelY() {
        return velY;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }
    
    
    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    
}
