import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olaskierbiszewska on 15.11.15.
 */
public class Okno3 extends JFrame implements ActionListener{
    private JPanel rootPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JTextField t0x;
    private JTextField t0y;
    private JTextField t1x;
    private JTextField t1y;
    private JTextField t2x;
    private JTextField t2y;
    private JTextField t3x;
    private JTextField t4x;
    private JTextField t3y;
    private JTextField t4y;
    private JButton obliczButton;

    private JLabel labelArea;
    public void setLabelArea(JLabel labelArea) {
        this.labelArea = labelArea;
    }



    private float circuit;
    private float area;
    private Point[] myPoints = new Point[5];
    private List<Point> myPointsList = new ArrayList();


    public Okno3() {
        super("yolo");
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);

        obliczButton.addActionListener(this);
        this.setTestData();
        //area = this.calculateArea();
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

    public void setTestData(){
        t0x.setText("1");
        t0y.setText("1");
        t1x.setText("2");
        t1y.setText("4");
        t2x.setText("3");
        t2y.setText("4");
        t3x.setText("4");
        t3y.setText("4");
        t4x.setText("5");
        t4y.setText("1");
    }

    public float calculateAreaUserData(){
        JTextField[] fieldsArray = {t0x, t0y, t1x, t1y, t2x, t2y, t3x, t3y, t4x, t4y};
        Integer x = 0;
        Integer y = 0;
        int length = fieldsArray.length;
        for(int i=0; i<length; ++i){
            if(i==0 || i%2==0){
                if((!fieldsArray[i].getText().equals("")) && (!fieldsArray[i+1].getText().equals(""))){
                    x = Integer.parseInt(fieldsArray[i].getText());
                    y = Integer.parseInt(fieldsArray[i+1].getText());
                    myPointsList.add(new Point(x,y));
                }
            }
        }
        int num_points = myPointsList.size();
        Point[] pts = new Point[num_points + 1];
        for(int i=0; i<myPointsList.size(); ++i){
            pts[i] = myPointsList.get(i);
        }
        pts[num_points] = myPointsList.get(0); //!!
        float area = 0;
        for (int i = 0; i < num_points; ++i){
            area +=(pts[i + 1].x - pts[i].x) * (pts[i + 1].y + pts[i].y) / 2;
        }
        return area;
    }

    public void actionPerformed(ActionEvent ae) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if(ae.getSource() == obliczButton) {
            float area = this.calculateAreaUserData();
            System.out.print("area" + area);
            labelArea.setText("Pole: " + this.calculateAreaUserData());
        }
    }
}
