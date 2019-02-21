package com.beginning.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    public GameObject tempObject;
    public int tempVel;
    //Constructor
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    
    //Methods
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i=0; i<handler.object.size();i++){
            tempObject = handler.object.get(i);
            /**
             * 
             * key events for Player
             */
            if (tempObject.getId() == ID.Player ){
                if(key == KeyEvent.VK_UP){
                    tempObject.setVelY(-3);
                }
                if(key == KeyEvent.VK_DOWN){
                    tempObject.setVelY(3);
                }
                if(key == KeyEvent.VK_RIGHT){
                    tempObject.setVelX(3);
                }
                if(key == KeyEvent.VK_LEFT){
                    tempObject.setVelX(-3);
                }
            }
            
        }
       // if(key == KeyEvent.VK_ESCAPE) System.exit(1);
            
        
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
            
        for(int i=0; i<handler.object.size();i++){
            tempObject = handler.object.get(i);
            /**
             * 
             * key events for Player
             */
            if (tempObject.getId() == ID.Player ){
                if(key == KeyEvent.VK_UP){
                    tempObject.setVelY(0);
                }
                if(key == KeyEvent.VK_DOWN){
                    tempObject.setVelY(0);
                }
                if(key == KeyEvent.VK_RIGHT){
                    tempObject.setVelX(0);
                }
                if(key == KeyEvent.VK_LEFT){
                    tempObject.setVelX(0);
                }
            }
            
        }
    }
}
