/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beginning.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
    private Handler handler;
    
    private float alpha = 1;
    private float width, height;  
    private Color color;    //determines color of trail's object
    private float life;   //determines life of trail

    public Trail(float x, float y,Color color, float width, float height, float life, ID id, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
        
    }

    @Override
    public void tick() {
        if(alpha>life){     //if object in trail have an life, his visibility decrease by 0.001;
            alpha -= life - 0.001f;
        }else handler.removeObject(this);   //if not - removes object
        
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
        
        g2d.setComposite(makeTransparent(1));

    }

    //Render out transparency in objects
    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
