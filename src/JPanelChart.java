import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olaskierbiszewska on 16.11.15.
 */
public class JPanelChart extends JPanel {
    public List<Point> getMyPointsList() {
        return myPointsList;
    }

    public void setMyPointsList(List<Point> myPointsList) {
        this.myPointsList = myPointsList;
    }

    private java.util.List<Point> myPointsList = new ArrayList();

    JPanelChart() {
        // set a preferred size for the custom panel.
        //setPreferredSize(new Dimension(420,420));
    }

    @Override
    public void paint(Graphics g) {
        int margin = 30;
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth() - 30, this.getHeight() - 30);
        g.setColor(Color.black);
        //TODO obliczyc unit zeby zmiescla sie cala figura?
        int unit = 5;
        //X axis
        int xX1 = 0;
        int xY1 = this.getHeight()/2;
        int xX2 = this.getWidth()-margin;
        int xY2 = this.getHeight()/2;
        g.drawLine(xX1, xY1, xX2, xY2);
        //X arrow
        g.drawLine(xX2-5, xY1-5, xX2, xY2);
        g.drawLine(xX2-5, xY1+5, xX2, xY2);
        //X ruler
        for(int i=0; i<xX2-unit; i+=unit){
            g.drawLine(xX1,xY1-2,xX1,xY1+2);
            xX1 +=unit;
        }

        //Y axis
        int yX1 = this.getWidth()/2;
        int yY1 = 0;
        int yX2 = this.getWidth()/2;
        int yY2 = this.getHeight()-margin;
        g.drawLine(yX1,yY1,yX2, yY2);
        //Y arrow
        g.drawLine(yX1-5,yY1+5,yX1, yY1);
        g.drawLine(yX1+5,yY1+5,yX1, yY1);

        //Y ruler
        yY1+=unit;
        for(int i=0; i<(yY2-unit); i+=unit){
            g.drawLine(yX1-2,yY1,yX1+2,yY1);
            yY1 +=unit;
        }
    }
}
