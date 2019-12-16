import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends JPanel implements KeyListener, ActionListener {
    int x = 0, y = 0;
    int a = 550, b = 550;

    int[] sq = new int[144];
    int presentsq=0;
    int presentsq2=143;

    Timer tm = new Timer(100, this);



    public Snake() {

        tm.start(); //start the timer ticking
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);




            g.setColor(Color.RED);
                g.fillRect(a,b,50,50);
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 50, 50);
            }                                   // g.drawOval(x,y,50,50);
                                                    // g.fillOval(x+15,y+15,5,5);
                                                    // g.fillOval(x+35,y+15,5,5);
                                                    // g.fillOval(x+25,y+25,5,5);
                                                    // g.drawLine(x+15,y+35,x+25,40);
                                                    // g.drawLine(x+25,y+40,x+35,35);
                                                    // g.drawLine(x+25,y+50,x+25,y+150);
                                                    // g.drawLine(x+25,y+50,x,y+100);
                                                    // g.drawLine(x+25,y+50,x+50,y+100);
                                                    // g.drawLine(x+25,y+150,x,y+200);
                                                    // g.drawLine(x+25,y+150,x+50,y+200);





    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());

        int key = e.getKeyCode();

////////////////BLUE MOVEMENT////////////////////////////////////////////

        if(key == KeyEvent.VK_DOWN){
            if(132 <= presentsq){
                presentsq = presentsq - 132;
            }
            else presentsq = presentsq + 12;
        }
        else if (key == KeyEvent.VK_UP){
            if(0<= presentsq && presentsq<=11){
                presentsq = presentsq + 132;
            }
            else presentsq = presentsq - 12;
        }
        else if (key == KeyEvent.VK_LEFT){
            if(presentsq%12 == 0){
                presentsq = presentsq +11;
            }
            else presentsq = presentsq - 1;
        }
        else if (key == KeyEvent.VK_RIGHT){
            if(presentsq%12 == 11){
                presentsq = presentsq -11;
            }

            else presentsq = presentsq + 1;
        }
 ////////////////////RED MOVEMENT////////////////////////////

        if(key == KeyEvent.VK_S){
            if(132 <= presentsq2){
                presentsq2 = presentsq2 - 132;
            }
            else presentsq2 = presentsq2 + 12;
        }
        else if (key == KeyEvent.VK_W){
            if(0<= presentsq2 && presentsq2<=11){
                presentsq2 = presentsq2 + 132;
            }
            else presentsq2 = presentsq2 - 12;
        }
        else if (key == KeyEvent.VK_A){
            if(presentsq2%12 == 0){
                presentsq2 = presentsq2 +11;
            }
            else presentsq2 = presentsq2 - 1;
        }
        else if (key == KeyEvent.VK_D){
            if(presentsq2%12 == 11){
                presentsq2 = presentsq2 -11;
            }

            else presentsq2 = presentsq2 + 1;
        }
 ///////////////////////////////////////////////////
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Blue: " + x + " | " + y);
        System.out.println("Red: " + x + " | " + y);
        System.out.println("Present square BLUE: " + presentsq);;
        System.out.println("Present square RED: " + presentsq2);;


        x= (presentsq % 12)*50;
        y= ( (int)(presentsq / 12) ) *50;
        //////////////////////////////////////
        a= (presentsq2 % 12)*50;
        b= ( (int)(presentsq2 / 12) ) *50;

        repaint();
    }
//////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        JFrame jf = new JFrame();

        Snake g1 = new Snake();
        jf.add(g1);

        jf.setTitle("My Game");
        jf.setSize(600, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}