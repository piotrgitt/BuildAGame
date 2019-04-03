/**
 *
 * Class going to update and render all of our objects in room
 * Class going to loop over all objects in the game and update them and render them on the screen
 */
package com.beginning.main;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {
    LinkedList<GameObject> objects = new LinkedList<GameObject>();
    
    /**
     * looping trough all game objects
     * 
     */
    public void tick(){
        for(int i=0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);  //get 
            
            tempObject.tick(); 
        }
    }
    
    /**
     * looping trough all game objects and render them
     */
    public void render(Graphics g){
        for(int i=0; i<objects.size(); i++){
            GameObject tempObject = objects.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.objects.add(object);
    }
    
    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
    
    public void removeAllEnemies(){
        for(int i=objects.size()-1; i>0; i--){
            GameObject tempObject = objects.get(i);
            if(tempObject.id == ID.BasicEnemy || tempObject.id == ID.FastEnemy || tempObject.id == ID.SmartEnemy) {
                
                objects.remove(i);
            }
        }
    }
    
    
    
}
