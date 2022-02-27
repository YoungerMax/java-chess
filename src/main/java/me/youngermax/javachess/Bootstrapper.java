package me.youngermax.javachess;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.gui.ChessWindow;

public class Bootstrapper {
    public static void main(String[] args) {
        new ChessWindow(new Board()).setVisible(true);
    }
}
