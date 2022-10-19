import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    public Main() {
    }

    private static void createAndShowGUI() {
        JFrame var0 = new JFrame("Hello World Swing Example");
        var0.setLayout(new FlowLayout());
        var0.setSize(500, 360);
        var0.setDefaultCloseOperation(3);
        JLabel var1 = new JLabel("Hello World Swing");
        Border var2 = BorderFactory.createLineBorder(Color.BLACK);
        var1.setBorder(var2);
        var1.setPreferredSize(new Dimension(150, 100));
        var1.setText("Hello World Swing");
        var1.setHorizontalAlignment(0);
        var1.setVerticalAlignment(0);
        var0.add(var1);
        var0.setVisible(true);
    }

    public static void main(String[] var0) {
        createAndShowGUI();
    }
}


