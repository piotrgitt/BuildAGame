/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beginning.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Piotr
 */
public class Shop extends MouseAdapter {
    Handler handler;
    HUD hud;
    Game game;
    
    
    private int B1 = 100;
    private int B2 = 100;
    private int B3 = 100;
    
    
    public Shop(Handler handler, HUD hud, Game game){
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }
    
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("hack13", 1, 42));
        g.drawString("SHOP", (int) (Game.WIDTH/2-100), 50);
        
        g.setFont(new Font("Arial", 1, 12));
        
        //BOX 1
        g.drawString("Upgrade health", 110, 120);
        g.drawString("Cost " + B1, 110, 140);
        g.drawRect(100, 100, 100, 100);
        
        //BOX 2
        g.drawString("Refill speed", 270, 120);
        g.drawString("Cost " + B2, 270, 140);
        g.drawRect(260, 100, 100, 100);
        
        //BOX 3
        g.drawString("Restore Health", 410, 120);
        g.drawString("Cost " + B3, 410, 140);
        g.drawRect(400, 100, 100, 100);
        
        g.drawString("SCORE: " + hud.getScore(), (int) (Game.WIDTH/2-50), 400);        
    
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        
        if(game.gameState == GameState.Shop){
            //BOX 1     ADD HEALTH
            if(mouseOver(mx,my, 100,100, 100,100)){
                if(hud.getScore() >= B1){
                    hud.setScore(hud.getScore()-B1);
                    B1+=100;
                    hud.bounds += 20;
                    //hud.HEALTH = (100 + (hud.bounds/2));
                }
            }

            //BOX 2     ADD SPEED
            if(mouseOver(mx,my, 260,100, 100,100)){
                if(hud.getScore() >= B2){
                    hud.setScore(hud.getScore()-B2);
                    B2+=400;
                    handler.playerSpeed++;
                }
            }

            //BOX 3     RESTORE HEALTH
            if(mouseOver(mx,my, 400,100, 100,100)){
                if(hud.getScore() >= B3){
                    hud.setScore(hud.getScore()-B3);
                    hud.HEALTH = (100 + (hud.bounds/2));
                }
            }    
        }   
    }
    
    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if(mouseX > x && mouseX < x+width ){
            if(mouseY > y & mouseY < y+height){
                return true;
            }else return false;
        }else return false;
    }
}
