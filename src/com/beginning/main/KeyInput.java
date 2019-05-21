package com.beginning.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private boolean[] keyDown = new boolean[4];
    
    public Game game;
    private Handler handler;
    public GameObject tempObject;//just an teporary object
    public float tempVel;//just an tempoary variable
    
    /**
     * Konstruktor
     * @param handler
     * @param game 
     */
    public KeyInput(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        
        keyDown[0] = false; // UP - key
        keyDown[1] = false; // DOWN - key
        keyDown[2] = false; // RIGHT - key
        keyDown[3] = false; // LEFT - key
    }
    
    
    /**
     * @param e 
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i=0; i<handler.objects.size();i++){
            tempObject = handler.objects.get(i);
            /**
             * 
             * key events for Player
             */
            if (tempObject.getId() == ID.Player ){
                if(key == KeyEvent.VK_UP)    {tempObject.setVelY(-4); keyDown[0] = true;}
                if(key == KeyEvent.VK_DOWN)  {tempObject.setVelY(4);  keyDown[1] = true;}
                if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(4);  keyDown[2] = true;}
                if(key == KeyEvent.VK_LEFT)  {tempObject.setVelX(-4); keyDown[3] = true;}
            }
            
        }
       // if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        if (key == KeyEvent.VK_P) {
            if(game.gameState == GameState.Game){
                if(!Game.paused) Game.paused = true;
                else Game.paused = false;
            }
        }   
        
    }
    
    /**
     * 
     * @param e 
     */
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
            
        for(int i=0; i<handler.objects.size();i++){
            tempObject = handler.objects.get(i);
            /**
             * 
             * key events for Player
             */
            if (tempObject.getId() == ID.Player ){
                if(key == KeyEvent.VK_UP)    keyDown[0] = false;
                if(key == KeyEvent.VK_DOWN)  keyDown[1] = false;
                if(key == KeyEvent.VK_RIGHT) keyDown[2] = false;
                if(key == KeyEvent.VK_LEFT)  keyDown[3] = false;
                
                //vertical movement (up, down)
                if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                
                //horizontal movement(left, right)
                if(!keyDown[2] & !keyDown[3]) tempObject.setVelX(0);
            }
            
        }
    }
}
