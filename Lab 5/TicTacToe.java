
/* Author : Aslam M.M.M
   Reg.No: E/15/021
   CO-225 / Lab 05
   TicTacToe game

   **RUN THE CODE FROM HERE
*/

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener {
    public JPanel p = new JPanel();

    static XOButton button[] = new XOButton[9];
    static JButton in;
    static JLabel lbl;

    public static void main(String[] args) {
        new TicTacToe();
    }

    public TicTacToe() {
        super("Tic Tac Toe");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(3, 3, 3, 3));

        in = new JButton(); // a button for other options like reset, play again
        lbl = new JLabel(); // to provide current status of the game

        // creating the game bord (grid layout)
        for (int i = 0; i < 9; i++) {
            button[i] = new XOButton(i);
            p.add(button[i]);
        }

        lbl.setText("  It's Player 1's Turn");

        in.setBorderPainted(true);
        in.setPreferredSize(new Dimension(100, 30));
        in.setText("RESET");
        in.setBounds(179, 1, 120, 30);
        add(in);
        add(lbl);
        in.addActionListener(this);
        p.setPreferredSize(new Dimension(300, 300));
        add(p, BorderLayout.SOUTH);
        setSize(300, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // resetting the Game Board
        for (int i = 0; i < 9; i++) {
            XOButton.game.drawBord(i, 0);
        }

        this.dispose();
        XOButton.turn = 1;
        main(null);
    }
}