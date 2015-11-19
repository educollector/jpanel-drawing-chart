import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private int calculateUnit(){
        int max = Integer.MIN_VALUE;
        for(Point p:myPointsList){
            if(Math.abs(p.x)>max){
                max = Math.abs(p.x);
            }
            if(Math.abs(p.y)>max){
                max = Math.abs(p.y);
            }
        }
        return myPointsList.size()>0 ? (this.getWidth()/2)/max/2 : 15;
    }

    @Override
    public void paint(Graphics g) {
        int margin = 30;
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth() - 30, this.getHeight() - 30);
        g.setColor(Color.black);
        int unit = this.calculateUnit();
        int shiftX = this.getWidth() / 2;
        int shiftY = this.getHeight() / 2;
        //X axis
        int xX1 = 0;
        int xY1 = this.getHeight() / 2;
        int xX2 = this.getWidth() - margin;
        int xY2 = xY1;
        g.drawLine(xX1, xY1, xX2, xY2);
        //X arrow
        g.drawLine(xX2 - 5, xY1 - 5, xX2, xY2);
        g.drawLine(xX2 - 5, xY1 + 5, xX2, xY2);
        //X ruler
        int crossPoint = 0; //X value indicating cross point od X and Y
        for (int i = 0; i < xX2 - unit; i += unit) {
            g.drawLine(xX1, xY1 - 2, xX1, xY1 + 2);
            xX1 += unit;
            crossPoint++;
        }

        //Y axis
        int yX1 = (crossPoint/2)*unit;
        int yY1 = 0;
        int yX2 = yX1;
        int yY2 = this.getHeight() - margin;
        g.drawLine(yX1, yY1, yX2, yY2);
        //Y arrow
        g.drawLine(yX1 - 5, yY1 + 5, yX1, yY1);
        g.drawLine(yX1 + 5, yY1 + 5, yX1, yY1);

        //Y ruler
        //down
        int jump = xY1;
        for (int i = 0; i < this.getHeight()/2-margin; i += unit) {
            g.drawLine(yX1 - 2, jump, yX1 + 2, jump);
            jump += unit;
        }
        //up
        jump = xY1;
        for (int i = this.getHeight()/2; i > (0 + unit); i -= unit) {
            g.drawLine(yX1 - 2, jump, yX1 + 2, jump);
            jump -= unit;
        }


        //draw shape
        if (myPointsList.size() > 0) {
            this.lagrangePolynomial(5.0f);
            g.setColor(Color.green);
            for (int i = 0; i < myPointsList.size(); ++i) {
                Point curr = myPointsList.get(i);
                int nextPointIndex = i < myPointsList.size() - 1 ? i + 1 : 0;
                Point next = myPointsList.get(nextPointIndex);
                g.drawLine(
                        curr.x * unit + (crossPoint/2)*unit,
                        -curr.y * unit + shiftY,
                        next.x * unit + (crossPoint/2)*unit,
                        -next.y * unit + shiftY
                );
            }
            //draw function
            g.drawLine(38,1,4,57);
            int prevX=-3;
            int prevY = (int)this.lagrangePolynomial(prevX);
            int nextX = 0;
            int nextY = 0;
            for(int i=0; i < 5; i++){
                nextX += unit;
                nextY = (int)this.lagrangePolynomial(i);
                g.drawLine(
                        prevX * unit + (crossPoint/2)*unit ,
                        prevY * unit + shiftY,
                        nextX * unit + (crossPoint/2)*unit,
                        nextY * unit + shiftY
                );
                prevX = nextX;
                prevY = nextY;

            }
        }
    }


    private int lagrangePolynomial(float myX) {
        //Declaration of the scanner variable
        Scanner myScanner = new Scanner(System.in);

        //Declaration of variables
        int count, count2;

        float [] arrayx = new float[myPointsList.size()]; //Array limit 199
        float [] arrayy = new float[myPointsList.size()]; //Array limit 199

        for(int i=0; i< myPointsList.size(); ++i){
            arrayx[i] = (float)myPointsList.get(i).x;
            arrayy[i] = (float)myPointsList.get(i).y;
        }


        //The arbitrary value, x to be entered for
        //which the value of y can be known
        float x = myX;
        float y = 0; //The corresponding value, f(x)=y
        float numerator; //The numerator
        float denominator;  //The denominator



        //first Loop for the polynomial calculation
        for(count = 0; count<myPointsList.size(); count++)
        {
            //Initialisation of variable
            numerator = 1; denominator = 1;

            //second Loop for the polynomial calculation
            for (count2 = 0; count2<myPointsList.size(); count2++)
            {
                if (count2 != count)
                {
                    numerator = numerator * (x - arrayx[count2]);
                    denominator = denominator * (arrayx[count] - arrayx[count2]);
                }
            }
            y = y + (numerator/denominator) * arrayy[count];
        }
        System.out.println("YOLO ____When x = " + x + "," + " y = " +  y);
        return (int)y;
    }
}
