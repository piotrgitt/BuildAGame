/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    //number of player's health
    public static float HEALTH = 100.0f;
    private float greenValue;
    private int score = 0;
    private int level = 1;
    public int bounds = 0;
    
    
    /**
     * tick for HUD
     */
    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0.0f, 100.0f+bounds);    // 0 and 100  - maximum and minimum health value
        greenValue = HEALTH * 2;
        greenValue = Game.clamp(greenValue, 0.0f, 255.0f);
        score++;
    }
    
    /**
     * render hud method
     * @param g (Graphic object)
     */
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200+bounds, 32);

        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);

        g.setColor(Color.white);
        g.drawRect(15, 15, 200+bounds, 32);

        //draw out score and level
        g.drawString("Score: " + score, 14, 68);
        g.drawString("Level: " + level, 14, 82);
        g.drawString("Press SPACE to acces SHOP", 14, 96);

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
