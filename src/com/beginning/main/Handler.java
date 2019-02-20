/**
 *
 * Class going to update and render all of our objects in room
 * Class going to loop over all objects in the game and update them and render them on the screen
 */
package com.beginning.main;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    /**
     * looping trough all game objects
     * 
     */
    public void tick(){
        for(int i=0; i < object.size(); i++){
            GameObject tempObject = object.get(i);  //get 
            /**
             * running a method tick coming from
             * GameObject(ex. tick() method from player object)
             */
            tempObject.tick(); 
        }
    }
    
    /**
     * looping trough all game objects
     * 
     */
    public void render(Graphics g){
        for(int i=0; i<object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    
    
}
