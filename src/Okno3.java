import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olaskierbiszewska on 15.11.15.
 */
public class Okno3 extends JFrame {
    private JPanel rootPanel;
    private JPanel leftPointsPanel;
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
    private JButton testDataButton;
    private JTextArea textArea1;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel chartPanel;
    private JLabel xy;

    public void setLabelArea(JLabel labelArea) {
        this.labelArea = labelArea;
    }
    private List<Point> myPointsList = new ArrayList();


    public Okno3() {
        super("App");
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);

        obliczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float area = calculateAreaUserData();
                System.out.print("area" + area);
                labelArea.setText("Pole: " + calculateAreaUserData() + " Obwód: " + String.format("%.2f", calculatePerimeter()));
                chartPanel.repaint();
            }
        });

        textArea1.setText("Wprowadź współrzędne (x,y)\n kolejnych punktów");

        testDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setTestData();
                Okno3.this.setTestData();
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Okno3.this.reprintChart();
            }
        });
    }

    private void reprintChart(){
        if(myPointsList.size()>0){
            chartPanel.repaint();
        }
    }

//    @Override
//    public void paint(Graphics g) {
//        chartPanel.repaint();
//        if(myPointsList.size()>0){
//            for(int i=0; i<myPointsList.size(); ++i){
//                if(i==myPointsList.size()-1){
//                    g.drawLine(myPointsList.get(i).x*100,myPointsList.get(i).y*100,
//                            myPointsList.get(0).x*100, myPointsList.get(0).y*100);
//                }else{
//                    g.drawLine(myPointsList.get(i).x*100, myPointsList.get(i).y*100,
//                            myPointsList.get(i+1).x*100, myPointsList.get(i+1).y*100);
//                }
//            }
//        }
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
        t2y.setText("3");
        t3x.setText("4");
        t3y.setText("4");
        t4x.setText("5");
        t4y.setText("1");
    }

    public void readTextFieldsData(){
        myPointsList.clear();
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
        ((JPanelChart) chartPanel).setMyPointsList(myPointsList);
    }
    private double calculatePerimeter(){
        this.readTextFieldsData();
        double perimeter = 0;
        for(int i=0; i<myPointsList.size(); ++i){
            if(i==myPointsList.size()-1){
                perimeter += this.pointsDistance(myPointsList.get(i), myPointsList.get(0));
            }else{
                perimeter += this.pointsDistance(myPointsList.get(i), myPointsList.get(i+1));
            }
        }
        System.out.print("perimeter: " + perimeter);
        return perimeter;
    }

    private double pointsDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y - p1.y),2));
    }

    private float calculateAreaUserData(){
        this.readTextFieldsData();
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        chartPanel = new JPanelChart();

    }
}
