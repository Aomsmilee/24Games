import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackPlay extends JPanel {
    Image backgroudImage;

    BackPlay() {
        backgroudImage = new ImageIcon(getClass().getResource("image/bgp.png")).getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroudImage, 0, 0, getWidth(),getHeight(),null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 600); // กำหนดขนาดของ JPanel
    }
    
}