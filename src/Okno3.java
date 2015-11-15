import javax.swing.*;
import java.awt.*;

/**
 * Created by olaskierbiszewska on 15.11.15.
 */
public class Okno3 extends JFrame{
    private JButton button1;
    private JPanel rootPanel;

    public Okno3() {
        super("yolo");
        pack();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
