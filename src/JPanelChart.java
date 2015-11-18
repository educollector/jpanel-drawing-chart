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
        System.out.println("paint");
        super.paint(g);
    }
}
