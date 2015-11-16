import javax.swing.*;
import java.awt.*;
import java.util.*;
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(myPointsList.size()>0){
            for(int i=0; i<myPointsList.size(); ++i){
                if(i==myPointsList.size()-1){
                    g.drawLine(myPointsList.get(i).x*100,myPointsList.get(i).y*100,
                            myPointsList.get(0).x*100, myPointsList.get(0).y*100);
                }else{
                    g.drawLine(myPointsList.get(i).x*100, myPointsList.get(i).y*100,
                            myPointsList.get(i+1).x*100, myPointsList.get(i+1).y*100);
                }
            }
        }
    }
}
