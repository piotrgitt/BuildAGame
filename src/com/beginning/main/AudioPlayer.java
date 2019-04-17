package com.beginning.main;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author Piotr
 */
public class AudioPlayer {

    /**
     *Sound and music maps
     */
    public static Map<String, Sound> soundMap = new HashMap<String,Sound>();
    public static Map<String, Music> musicMap = new HashMap<String,Music>();
    
    /**
     * Load all sounds method
     */
    public static void load(){
        try {
            soundMap.put("click_sound", new Sound("C:\\Users\\Piotr\\Documents\\NetBeansProjects\\Build a Game\\Music\\click_sound.ogg"));
            musicMap.put("music", new Music("Music/background_music.ogg"));
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Music getMusic(String key){
        return musicMap.get(key);
    }
    
    public static Sound getSound(String key){
        return soundMap.get(key);
    }
    
    
}
