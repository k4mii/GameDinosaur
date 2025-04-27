/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.dinosaurgame.elements;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Kamii
 */
public class Rock extends Sprite{
    private Image rockImage;

    public Rock(int x, int y, int width, int height) {
        super(x, y, width, height, null); 
        rockImage = new ImageIcon(getClass().getResource("/autonoma/dinosaurgame/images/rock.png")).getImage();
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(rockImage, x, y, width, height, null);
    } 
}
