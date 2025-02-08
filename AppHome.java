import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AppHome {
    private JFrame frame;
    private JPanel panel;
    private JButton startGameButton;
    private JButton introduceButton;
    private Intd intdFrame;


    public AppHome() {
        //หน้าต่าง
        frame = new JFrame();
        frame.setTitle("MathChallenge 24");
        frame.setSize(360, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ใส่ไอคอน
        ImageIcon icon = new ImageIcon("image/icon.png"); // เปลี่ยน path เป็นที่อยู่ของไอคอนของคุณ
        frame.setIconImage(icon.getImage());

        panel = new BackApp();

        startGameButton = new JButton("Start Game");
        startGameButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        startGameButton.setOpaque(false);//หลังใส
        startGameButton.setContentAreaFilled(false);//พทปุ่มจะไม่มีสีเข้ามา
        startGameButton.setBorderPainted(false);//ไม่แสดงขอบ
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == startGameButton) {
                    frame.dispose();
                    Math24 game = new Math24();
                }
            }
        });
        panel.setLayout(null); // ตั้งค่า Layout ให้เป็น null เพื่อให้เราสามารถกำหนดตำแหน่งของปุ่มเอง
        Dimension panelSize = panel.getPreferredSize();
        startGameButton.setBounds((panelSize.width - 215) / 2, (panelSize.height - 55) / 2, 200, 60);
        panel.add(startGameButton);

        // ปุ่ม Introduce
        introduceButton = new JButton("Introduce");
        introduceButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        introduceButton.setOpaque(false);
        introduceButton.setContentAreaFilled(false);
        introduceButton.setBorderPainted(false);
        introduceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == introduceButton) {
                    // สร้างอ็อบเจ็กต์ Intd ด้วยการส่งตัวแปร AppHome ตัวเองเข้าไป
                    intdFrame = new Intd(AppHome.this);
                    frame.dispose(); // ปิดหน้าต่างปัจจุบัน
                }
            }
        });
        introduceButton.setBounds((panelSize.width - 215) / 2, (panelSize.height + 100) / 2, 200, 60);
        panel.add(introduceButton);
        
        // กำหนด JPanel เป็นพื้นหลังของ JFrame
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AppHome home = new AppHome();
    }
}
