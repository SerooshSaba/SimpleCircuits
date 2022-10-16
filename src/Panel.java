import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    private Timer timer;

    private float centerx = 0;
    private float centery = 0;
    private float scale = 1;

    Panel() {
        this.setPreferredSize(new Dimension(1920,1080));

        this.timer = new Timer(100, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timer.start();
    }

    public void paint( Graphics g ) {
        Graphics2D graphics = (Graphics2D) g;

        // Render position and scale
        graphics.setColor(Color.BLACK);
        graphics.drawString( "x:" + this.centerx,10,750);
        graphics.drawString( "y:" + this.centery,10,770);
        graphics.drawString( Float.toString(this.scale),10,790);
    }

    public void moveMouse( float x, float y ) {
        this.centerx += x * this.scale;
        this.centery += y * this.scale;
    }

    public void scrollWheel( int value ) {
        if ( value == 1 ) {
            this.scale *= 1.5;
        }
        else {
            this.scale *= 0.6;
        }
    }

}