import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI extends JFrame implements ActionListener {
    SudokuGUI() {
        this.setTitle("Sudoku");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel gameField = new JPanel();
        gameField.setLayout(new GridLayout(3, 3, 3, 3));
        this.add(gameField, BorderLayout.CENTER);

        for (int i = 0; i < 9; i++) {
            JPanel block = new JPanel();
            block.setLayout(new GridLayout(3, 3));

            for (int j = 0; j < 9; j++) {
                JButton cell = new JButton((j + 1) + "");

                block.add(cell);
                cell.setFocusable(false);
            }

            gameField.add(block);
        }

//        for (Component comp : this.getComponents()) {
//            if (comp instanceof JPanel) {
//                for (int i = 0; i < 9; i++) {
//                    JButton cell = new JButton(i + "");
//
//                    comp.add(cell);
//                    cell.setFocusable(false);
//                }
//            }
//        }

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            Object oldCell = e.getSource();
            JButton newCell = new JButton("3");
            e.getSource() = newCell;
        }
    }
}
