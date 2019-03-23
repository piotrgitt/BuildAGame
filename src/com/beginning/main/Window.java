package com.beginning.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends Canvas {
    
    private static final long serialVerionUID = -24084060033728354L;
    
    /**
     * window constructor parameters
     * 
     */
    public Window(float width, float height, String title, Game game){
        JFrame frame = new JFrame(title);
        
        game.setPreferredSize(new Dimension((int)width, (int)height));
        game.setMaximumSize(new Dimension((int)width, (int)height));
        game.setMinimumSize(new Dimension((int)width, (int)height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        
        game.start();       //starting our game
    }
    
}
