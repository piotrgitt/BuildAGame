/*
 * Class inhereted of GameObject Class
 */
package gameClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static java.lang.Double.NaN;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    
    float distX;
    float distY;
    float distance;

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        
        for(int i=0; i<handler.objects.size();i++){
            if(handler.objects.get(i).id == ID.Player) player = handler.objects.get(i);
        }
        



    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        /**
         * 
         * if an Enemy hits our window wall, his velocity will reverse - he just
         * bounce off(multiplying by -1)
         * 
         */
        
        if (x > Game.WIDTH - 16 || x < 0) {
            velX *= -1;
        }
        if (y > Game.HEIGHT - 16 || y < 0) {
            velY *= -1;
        }
        
        
        
        distX = x - player.getX()-8;
        distY = y - player.getY()-8;
        
        
        distance = (int) Math.hypot(distX, distY);
        if(distance == 0){
            velX = 0.00001f;
            velY = 0.00001f;
        }
        
        /*
        System.out.println("VEL X: "+velX);
        System.out.println("VEL Y: "+velY);
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        */
        
        //distX * Z, gdzie Z określa szybkość poruszania się (0 - nie porrusza się, 5 - w chuj szybko)
        velY = (float) ((-1.0f/distance) * distY);
        velX = (float) ((-1.0f/distance) * distX);
        
        //Glitch fix (better to do own Exception)
        if(Float.isNaN(velX)){
           velX = 0;
           velY = 0;
        }
       
        

        
        
        

        handler.addObject(new Trail(x, y, Color.green, 16.0f, 16.0f, 0.025f, ID.Trail, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);  //set color of render object
        g.fillRect((int)x, (int)y, 16, 16);  //fill renctangle - Dimenstion of him is 16x16px
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);  //16 x 16 is dimensions of our rectangle
    }

}

