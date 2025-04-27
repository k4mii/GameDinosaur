/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.dinosaurgame.elements;

import autonoma.dinosaurgame.sounds.ReproducirSonido;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Kamii
 */
public class Dinosaur extends Sprite{
    public static final int STEP = 10;
    public static final int EAT_SIZE = 10;
    public static final int MIN_SIZE = 10;
    private Image dinoImage;
    private ReproducirSonido soundPlayer = new ReproducirSonido();

    
    public Dinosaur(int x, int y, int width, int height) {
        super(x, y, width, height, null);
        
        dinoImage = new ImageIcon(getClass().getResource("/autonoma/dinosaurgame/images/dino.png")).getImage();
   
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(dinoImage, x, y, width, height, null);
    }
    
    public void grow(){
    
        width += EAT_SIZE;
        height += EAT_SIZE;
    }
    
    public void decrease(){
        if(width > MIN_SIZE && height > MIN_SIZE){
            width -= EAT_SIZE;
            height -= EAT_SIZE;           
        }
        
    }

    
public void handleKey(KeyEvent e, int anchoPantalla, int altoPantalla){
    int nuevoX = x;
    int nuevoY = y;

    switch(e.getKeyCode()){
        case KeyEvent.VK_UP:
            nuevoY -= STEP;
            break;
                
        case KeyEvent.VK_DOWN:
            nuevoY += STEP;
            break;
                
        case KeyEvent.VK_LEFT:
            nuevoX -= STEP;
            break;
                
        case KeyEvent.VK_RIGHT:
            nuevoX += STEP;
            break;
    }
    
    if (nuevoX >= 0 && nuevoX + width <= anchoPantalla && nuevoY >= 0 && nuevoY + height <= altoPantalla) {
        x = nuevoX;
        y = nuevoY;
    }
    }  


    public void playEatMeatSound() {
        ReproducirSonido.playSound("/autonoma/dinosaurgame/sounds/eat.wav");
    }

    public void playEatRockSound() {
        ReproducirSonido.playSound("/autonoma/dinosaurgame/sounds/rock.wav");
    }


}
