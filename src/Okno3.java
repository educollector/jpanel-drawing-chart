import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olaskierbiszewska on 15.11.15.
 */
public class Okno3 extends JFrame{
    private JPanel rootPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JTextField t1x;
    private JTextField t1y;
    private JTextField t2x;
    private JTextField t2y;
    private JTextField t3x;
    private JTextField t3y;
    private JTextField t4x;
    private JTextField t5x;
    private JTextField t4y;
    private JTextField t5y;

    private float circuit;
    private float area;
    private Point[] myPoints = new Point[5];


    public Okno3() {
        super("yolo");
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);

        JTextField[] fieldsArray = {t1x,t1y,t2x,t2y,t3x,t3y,t4x,t4y,t5x,t5y};

        //for(int i=0; i<8; ++i){
            //if(fieldsArray[i] && fieldsArray[i+1]) {
                int x = Integer.parseInt(t1x.getText());
                int y = Integer.parseInt(t1y.getText());
        myPoints[0] = new Point(x,y);
                x = Integer.parseInt(t2x.getText());
                y = Integer.parseInt(t2y.getText());
        myPoints[1] = new Point(x,y);
                x = Integer.parseInt(t3x.getText());
                y = Integer.parseInt(t3y.getText());
        myPoints[2] = new Point(x,y);
                x = Integer.parseInt(t4x.getText());
                y = Integer.parseInt(t4y.getText());
        myPoints[3] = new Point(x,y);
                x = Integer.parseInt(t5x.getText());
                y = Integer.parseInt(t5y.getText());
        myPoints[5] = new Point(x,y);
        //}
       // }

        area = this.calculateArea();
    }

//    @Override
//    public void paint(Graphics g)
//    {
//        g.drawLine(100,100, 200, 200);
//
//    }


    private float calculateArea(){
        Point[] Points = new Point[4];
        int[] xTab = {1,1,3,3};
        int[] yTab = {1,4,4,1};
        for(int i=0; i<4; ++i){
            Points[i] = new Point(xTab[i], yTab[i]);
        }
        int num_points = Points.length;
        Point[] pts = new Point[num_points + 1];
        for(int i=0; i<4; ++i){
            pts[i] = Points[i];
        }
        pts[num_points] = Points[0]; //!!
        float area = 0;
        for (int i = 0; i < num_points; ++i){
            area +=(pts[i + 1].x - pts[i].x) * (pts[i + 1].y + pts[i].y) / 2;
        }
        return area;
    }

    private float calculateAreaUserData(){
        int num_points = myPoints.length;
        Point[] pts = new Point[num_points + 1];
        for(int i=0; i<4; ++i){
            pts[i] = myPoints[i];
        }
        pts[num_points] = myPoints[0]; //!!
        float area = 0;
        for (int i = 0; i < num_points; ++i){
            area +=(pts[i + 1].x - pts[i].x) * (pts[i + 1].y + pts[i].y) / 2;
        }
        return area;
    }
}
