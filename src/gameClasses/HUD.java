/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameClasses;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    //number of player's health
    public static float HEALTH = 100.0f;
    private float greenValue;
    private int score = 0;
    private int level = 1;
    
    
    /**
     * tick for HUD
     */
    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0.0f, 100.0f);    // 0 and 100  - maximum and minimum health value
        greenValue = Game.clamp(greenValue, 0.0f, 255.0f);

        greenValue = HEALTH * 2;
        score++;
    }
    
    /**
     * render hud method
     * @param g (Graphic object)
     */
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);

        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        //draw out score and level
        g.drawString("Score: " + score, 14, 68);
        g.drawString("Level: " + level, 14, 82);

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
