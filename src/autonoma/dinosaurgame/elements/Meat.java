/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.dinosaurgame.elements;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Kamii
 */
public class Meat extends Sprite{
    private Image meatImage;

    public Meat(int x, int y, int width, int height) {
        super(x, y, width, height, null); 
        meatImage = new ImageIcon(getClass().getResource("/autonoma/dinosaurgame/images/meat.png")).getImage();
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(meatImage, x, y, width, height, null);
    }       
}
