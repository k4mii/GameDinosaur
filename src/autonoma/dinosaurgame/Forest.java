/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.dinosaurgame;

import autonoma.dinosaurgame.elements.Dinosaur;
import autonoma.dinosaurgame.elements.Meat;
import autonoma.dinosaurgame.elements.Rock;
import autonoma.dinosaurgame.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Kamii
 */
public class Forest extends Sprite{
    private Dinosaur dino;
    private ArrayList<Meat> meats = new ArrayList<>();
    private ArrayList<Rock> rocks = new ArrayList<>();
    
    public Forest (int x, int y, int width, int height)
    {
        super(x, y, width, height, Color.PINK);
        
        dino = new Dinosaur(100, 100, 50, 50);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
        dino.draw(g);
        
        for(Meat meat : meats)
            meat.draw(g);
        
        for(Rock rock : rocks)
            rock.draw(g);
    }
    
    
    public void handleKey(KeyEvent e, int anchoPantalla, int altoPantalla)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                dino.handleKey(e,  anchoPantalla, altoPantalla);
                
                checkForMeatsEaten();
                checkForRocksEaten();
            break;
            
            case KeyEvent.VK_A:
                addMeat();
                addRock();
            break;
        } 

    }
    
    private void checkForMeatsEaten(){
        for(int i=0; i<meats.size(); i++)
        {
            Meat meat = meats.get(i);
            
            if(dino.hit(meat))
            {
                meats.remove(meat);
                i --;
                
                dino.grow();
                dino.playEatMeatSound();
            }
        }
    }


    private void checkForRocksEaten(){
        for(int i=0; i<rocks.size(); i++)
        {
            Rock rock = rocks.get(i);
            
            if(dino.hit(rock))
            {
                rocks.remove(rock);
                i --;
                
                dino.decrease();
                dino.playEatRockSound();
            }
        }
    }    
    private void addMeat(){
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        Meat meat = new Meat(x, y, 25, 25);
        
        meats.add(meat);
    }   
    
    private void addRock(){
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        Rock rock = new Rock(x, y, 25, 25);
        
        rocks.add(rock);
    }


}
