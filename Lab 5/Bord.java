/* Author : Aslam M.M.M
   Reg.No: E/15/021
   CO-225 / Lab 05
   TicTacToe game

   This code will save the datas and find find the winner 
*/

public class Bord {
    static int bord[][] = new int[3][3];

    public void drawBord(int i, int player) {
        switch (i) {
        case 0:
            bord[0][0] = player;
            break;
        case 1:
            bord[0][1] = player;
            break;
        case 2:
            bord[0][2] = player;
            break;
        case 3:
            bord[1][0] = player;
            break;
        case 4:
            bord[1][1] = player;
            break;
        case 5:
            bord[1][2] = player;
            break;
        case 6:
            bord[2][0] = player;
            break;
        case 7:
            bord[2][1] = player;
            break;
        case 8:
            bord[2][2] = player;
            break;
        }
    }

    public int winChance(int player) {

        // row wise winng chances;
        for (int a[] : bord) {
            if (a[0] == player && a[1] == player && a[2] == player) {
                return player;
            }
        }

        // col wise wining chance
        for (int a = 0; a <= 2; a++) {
            if (bord[0][a] == player && bord[1][a] == player && bord[2][a] == player) {
                return player;
            }
        }

        if (bord[0][0] == player && bord[1][1] == player && bord[2][2] == player) {
            return player;
        }

        if (bord[0][2] == player && bord[1][1] == player && bord[2][0] == player) {
            return player;
        }

        return 0;
    }
}