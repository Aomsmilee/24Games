import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Intd extends JFrame {
    private JPanel panelintd;
    private JButton back;
    private AppHome appHome;

    public Intd(AppHome appHome2) {
        this.appHome = appHome2;

        setTitle("Introduction");
        setSize(360, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ใส่ไอคอน
        ImageIcon icon = new ImageIcon("image/icon.png"); // เปลี่ยน path เป็นที่อยู่ของไอคอนของคุณ
        setIconImage(icon.getImage());

        panelintd = new BackIntd();

        back = new JButton("Back");
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        back.setOpaque(false);//หลังใส
        back.setContentAreaFilled(false);//พทปุ่มจะไม่มีสีเข้ามา
        back.setBorderPainted(false);//ไม่แสดงขอบ

        panelintd.setLayout(null); // ตั้งค่า Layout ให้เป็น null เพื่อให้เราสามารถกำหนดตำแหน่งของปุ่มเอง
        Dimension panelSize = panelintd.getPreferredSize();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    backHome(); // เรียกใช้เมธอด backHome เมื่อปุ่ม Back ถูกคลิก
                }
            }
        });
        back.setBounds((panelSize.width - 215) / 2, (panelSize.height + 270) / 2, 200, 60);
        panelintd.add(back);

        setContentPane(panelintd);
        setVisible(true);
    }

    private void backHome() {
        dispose(); // ปิดหน้าต่างปัจจุบัน
        AppHome home = new AppHome(); // เปิดหน้าต่าง AppHome อีกครั้ง
    }
}
