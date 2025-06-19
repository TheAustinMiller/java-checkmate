import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckmateGUI extends JFrame {

    public CheckmateGUI() {
        setTitle("CHECKMATE!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));
        createGUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void createGUI() {
        JPanel holeCardPanel = new JPanel(new BorderLayout());
        holeCardPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel card1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        card1Panel.add(new JLabel("Card 1:"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CheckmateGUI gui = new CheckmateGUI();
            gui.setVisible(true);
        });
    }
}
