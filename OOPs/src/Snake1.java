import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake1 extends JPanel implements KeyListener, ActionListener {
    int x = 0, y = 0, moveBy=0;

    int[] sq = new int[144];
    int presentsq=0;

    Timer tm = new Timer(300, this);



    public Snake1() {

        tm.start(); //start the timer ticking
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i=0; i < 143; i++) {
            if(sq[i]==1) {
                x = (i % 12) * 50;
                y = ((int) (i / 12)) * 50;


                g.setColor(Color.BLUE);
                g.fillRect(x, y, 50, 50);
                /*g.drawOval(x,y,50,50);
                g.fillOval(x+15,y+15,5,5);
                g.fillOval(x+35,y+15,5,5);
                g.fillOval(x+25,y+25,5,5);
                g.drawOval(x+25,y+35,10,10);
                g.drawLine(x+25,y+50,x+25,y+150);
                g.drawLine(x+25,y+50,x,y+100);
                g.drawLine(x+25,y+50,x+50,y+100);
                g.drawLine(x+25,y+150,x,y+200);
                g.drawLine(x+25,y+150,x+50,y+200);*/
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_DOWN){

            moveBy = 12;
        }
        else if (key == KeyEvent.VK_UP){

            moveBy = -12;
        }
        else if (key == KeyEvent.VK_LEFT){

            moveBy = -1;
        }
        else if (key == KeyEvent.VK_RIGHT){

            moveBy = 1;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(x + " | " + y);

        presentsq = presentsq + moveBy;
        sq[presentsq] = 1;

        repaint();
    }
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        JFrame jf = new JFrame();

        Snake1 g1 = new Snake1();
        jf.add(g1);

        jf.setTitle("My Game");
        jf.setSize(600, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
