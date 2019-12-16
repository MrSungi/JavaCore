import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



class Snake2 extends JPanel implements KeyListener, ActionListener {
    int x = 0, y = 0;

    int[] sq = new int[144];
    int presentsq = 0;

    Timer tm = new Timer(100, this);


    public Snake2() {

        tm.start(); //start the timer ticking
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
       /* g.drawOval(x,y,50,50);
        g.fillOval(x+15,y+15,5,5);
        g.fillOval(x+35,y+15,5,5);
        g.fillOval(x+25,y+25,5,5);
        g.drawLine(x+15,y+35,x+25,40);
        g.drawLine(x+25,y+40,x+35,35);
        g.drawLine(x+25,y+50,x+25,y+150);
        g.drawLine(x+25,y+50,x,y+100);
        g.drawLine(x+25,y+50,x+50,y+100);
        g.drawLine(x+25,y+150,x,y+200);
        g.drawLine(x+25,y+150,x+50,y+200);*/
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_DOWN) {

            presentsq = presentsq + 12;
        } else if (key == KeyEvent.VK_UP) {

            presentsq = presentsq - 12;
        } else if (key == KeyEvent.VK_LEFT) {

            presentsq = presentsq - 1;
        } else if (key == KeyEvent.VK_RIGHT) {

            presentsq = presentsq + 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(x + " | " + y);

        x = (presentsq % 12) * 50;
        y = ((int) (presentsq / 12)) * 50;

        repaint();
    }
}
////////////////////////////////////////////////////////////////////////////

class Snake3 extends JPanel implements KeyListener, ActionListener {
    int z = 550, k = 0;

    int[] sq = new int[144];
    int presentsq2 = 0;

    Timer tm = new Timer(100, this);


    public Snake3() {

        tm.start(); //start the timer ticking
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(z, k, 50, 50);
       /* g.drawOval(x,y,50,50);
        g.fillOval(x+15,y+15,5,5);
        g.fillOval(x+35,y+15,5,5);
        g.fillOval(x+25,y+25,5,5);
        g.drawLine(x+15,y+35,x+25,40);
        g.drawLine(x+25,y+40,x+35,35);
        g.drawLine(x+25,y+50,x+25,y+150);
        g.drawLine(x+25,y+50,x,y+100);
        g.drawLine(x+25,y+50,x+50,y+100);
        g.drawLine(x+25,y+150,x,y+200);
        g.drawLine(x+25,y+150,x+50,y+200);*/
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_S) {

            presentsq2 = presentsq2 + 12;
        } else if (key == KeyEvent.VK_W) {

            presentsq2 = presentsq2 - 12;
        } else if (key == KeyEvent.VK_A) {

            presentsq2 = presentsq2 - 1;
        } else if (key == KeyEvent.VK_D) {

            presentsq2 = presentsq2 + 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(z + " | " + k);

        z = (presentsq2 % 12) * 50;
        k = ((int) (presentsq2 / 12)) * 50;

        repaint();
    }
}

public class SnakeMulti extends JPanel{
    public static void main(String[] args) {

        JFrame jf = new JFrame();

        Snake2 g1 = new Snake2();
        Snake3 g2 = new Snake3();



        jf.add(g1);
        jf.add(g2);

        jf.setTitle("My Game");
        jf.setSize(600, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
