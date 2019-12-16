import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gamex extends JPanel implements ActionListener {
    int x = 100, y = 100, moveBy = 25, moveBx = 20;

    Timer tm = new Timer(100, this);


    public Gamex() {

        tm.start(); //start the timer ticking
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(x, y, 50, 50);
        // g.fillOval(x, y+200, 50, 50  );
        g.drawRect(x, y, 200,200);
        g.fillRect(x+100, y, 50, 50);
        g.fillRect(x+50, y+50, 50, 50);
        g.fillRect(x+150, y+50, 50, 50);
        g.fillRect(x, y+100, 50, 50);
        g.fillRect(x+100, y+100, 50, 50);
        g.fillRect(x+50, y+150, 50, 50);
        g.fillRect(x+150, y+150, 50, 50);
        g.drawLine(x-50, y, x+250,y );
        g.drawLine(x-50,y, x+100, y-100);
        g.drawLine(x+100,y-100, x+250, y);

    }

    public void actionPerformed(ActionEvent e) {

        // System.out.println(x + " | " + y);

        if (x <= 0) {
            x = 0;
            moveBy = 25;
        }

        if (x >= 1000) {
            x = 1000;
            moveBy = -25;
        }

        if (y <= 0) {
            //dir = 'd';
            y = 0;
            moveBx = 20;
        }

        if (y >= 500) {
            //dir = 'u';
            y = 500;
            moveBx = -20;
        }

        x = x + moveBy;
        y = y + moveBx;
        repaint();
    }


    public static void main(String[] args) {

        JFrame jf = new JFrame();

        Gamex g1 = new Gamex();
        jf.add(g1);

        jf.setTitle("My Game");
        jf.setSize(600, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
