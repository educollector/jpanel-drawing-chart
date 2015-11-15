import javax.swing.*;
import java.awt.*;

/**
 * Created by olaskierbiszewska on 15.11.15.
 */
public class Okno3 extends JFrame{
    private JPanel rootPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JTextField textField1;
    private JTextField textField2;

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
