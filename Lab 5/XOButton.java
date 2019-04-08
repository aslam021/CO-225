
/* Author : Aslam M.M.M
   Reg.No: E/15/021
   CO-225 / Lab 05
   TicTacToe game

   This code will manage the buttons of grid layout
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class XOButton extends JButton implements ActionListener {
    private int pos;
    public static int turn = 1;
    static Bord game = new Bord();
    JButton but = new JButton();

    public XOButton(int i) {
        this.addActionListener(this);
        this.pos = i;
    }

    public void actionPerformed(ActionEvent e) {

        int player = turn % 2;
        if (player == 0) {
            player = 2;
            TicTacToe.lbl.setText("  It's Player 1's Turn");
            this.setBackground(Color.lightGray);
        } else {
            TicTacToe.lbl.setText("  It's Player 2's Turn");
            this.setBackground(Color.darkGray);
        }

        this.setText(String.valueOf(player));
        this.setEnabled(false);

        game.drawBord(this.pos, player); // updating the choice to the bord

        if (game.winChance(player) != 0) { // checking for winning chances
            TicTacToe.lbl.setText("<html>&emsp&emsp&nbsp GAME OVER..!<br/> &nbsp Previous winner: Player "
                    + String.valueOf(player) + " </html>");
            JOptionPane.showMessageDialog(null, "Congratulations Player " + player + "..!   You WON", "Game Result",
                    JOptionPane.INFORMATION_MESSAGE);
            TicTacToe.in.setText("Play Again");
            TicTacToe.in.setBackground(Color.green);

            // disabling the GUI grid buttons
            for (int i = 0; i < 9; i++) {
                TicTacToe.button[i].setEnabled(false);
            }

        } else if (turn == 9) {
            TicTacToe.lbl.setText("<html>&emsp&emsp GAME OVER..!<br/> &nbsp Previous game drawn </html>");
            JOptionPane.showMessageDialog(null, "       Game Drawn", "Game Result", JOptionPane.INFORMATION_MESSAGE);
            TicTacToe.in.setText("Play Again");
            TicTacToe.in.setBackground(Color.green);
        }
        turn++;
    }

}