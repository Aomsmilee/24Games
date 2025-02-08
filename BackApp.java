import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackApp extends JPanel {
    Image backgroudImage;

    BackApp() {
        backgroudImage = new ImageIcon(getClass().getResource("image/bkg.png")).getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroudImage, 0, 0, getWidth(),getHeight(),null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(360, 500); // กำหนดขนาดของ JPanel
    }
}