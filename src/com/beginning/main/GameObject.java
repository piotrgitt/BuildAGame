/**
 * 
 * Abstract super class of all objects in our game
 */
package com.beginning.main;

import java.awt.Graphics;
import java.util.Random;

public abstract class  GameObject {
    
    protected int x, y;
    protected int velX, velY; 
    
    Random random = new Random();       
    protected ID id;    //instance of ID class
    
    /**
     * Constructor for objects basic parameters
     */
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    /**
     * Abstract method - only for using by inherent classes(like player)
     */
    public abstract void tick();
    public abstract void render(Graphics g);

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