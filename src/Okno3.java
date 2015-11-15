import javax.swing.*;
import java.awt.*;

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

    public Okno3() {
        super("yolo");
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);
    }

//    @Override
//    public void paint(Graphics g)
//    {
//        g.drawLine(100,100, 200, 200);
//
//    }
}
