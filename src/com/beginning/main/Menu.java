package com.beginning.main;

import com.beginning.main.GameState;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter{
    private Game game;
    private Handler handler;
    
    public Menu(Game game, Handler handler){
        this.game = game;   
        this.handler = handler;
    }
    
    
    
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        
        if(game.gameState == GameState.Menu){
            
            //(PLAY BUTTON
            if(mouseOver(mouseX, mouseY, 170, 80, 300, 90)){
                game.gameState = GameState.Game;
            }

            //HELP BUTTON
            if(mouseOver(mouseX, mouseY, 170, 200, 300, 90)){ 
                game.gameState = GameState.Help;
            }

            //QUIT BUTTON
            if(mouseOver(mouseX, mouseY, 170, 320, 300, 90)){
                System.exit(0);
            }
        
        }
        
        
        
        if(game.gameState == GameState.Help){
            if(mouseOver(mouseX, mouseY, 50, 380, 200, 60)){
                game.gameState = GameState.Menu;
            }
        }
        //BACK BUTTON
        
    }
    
    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if(mouseX > x && mouseX < x+width ){
            if(mouseY > y & mouseY < y+height){
                return true;
                
            }else return false;
        }else return false;
    }
    
    public void mouseReleased(MouseEvent e){
    
    }
    
    
    public void render(Graphics g){
        
        //MENU SYSTEM
        if(game.gameState == GameState.Menu){
            Font font1 = new Font("arial", 11, 34);
            g.setFont(font1);

            g.setColor(Color.WHITE);
            g.drawRoundRect(170, 80, 300, 90,10, 10);
            g.drawString("PLAY", 270, 140);

            g.drawRoundRect(170, 200, 300, 90,10, 10);
            g.drawString("HELP", 270, 140+120);

            g.drawRoundRect(170, 320, 300, 90,10, 10);
            g.drawString("QUIT", 270, 140+240); 
        }
        
        //HELP STATE
        if(game.gameState == GameState.Help){
            Font font1 = new Font("arial", 11, 34);
            Font font2 = new Font("arial", 11, 16);
            g.setFont(font1);

            g.setColor(Color.WHITE);
            g.drawString("HELP", 270, 140);
            g.drawRoundRect(50, 380, 200, 60,10, 10);
            g.drawString("BACK", 100, 422);
            
            g.setFont(font2);
            g.drawString("Use 'arrows' to move around and avoid enemies!", 100, 250);
        }
    }
    
    
    public void tick(){
        
    }
    
    
}
