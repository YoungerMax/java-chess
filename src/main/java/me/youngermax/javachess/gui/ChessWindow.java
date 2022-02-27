package me.youngermax.javachess.gui;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;

import javax.swing.*;
import java.awt.*;

public class ChessWindow extends JFrame {
    private static final int TILE_SIZE = 80;

    private Board board;

    public ChessWindow(Board board) {
        this.board = board;

        this.setLayout(new GridLayout(Board.SIZE, Board.SIZE));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess");

        this.setSize(Board.SIZE * TILE_SIZE, Board.SIZE * TILE_SIZE);

        this.populate();
    }

    public void populate() {
        for (int row = 0; Board.SIZE > row; row++) {
            for (int col = 0; Board.SIZE > col; col++) {
                this.add(new JButton());
            }
        }
    }

    public void update(Board board) {
        // todo update method
    }
}
