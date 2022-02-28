package me.youngermax.javachess.gui;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;

import javax.swing.*;
import java.awt.*;

public class ChessWindow extends JFrame {
    private static final int TILE_SIZE = 80;

    private static final Color TILE_COLOR_EVEN = Color.LIGHT_GRAY;
    private static final Color TILE_COLOR_ODD = Color.DARK_GRAY;

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
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                JButton btn = new JButton();

                if (col % 2 == row % 2) {
                    btn.setBackground(TILE_COLOR_EVEN);
                } else {
                    btn.setBackground(TILE_COLOR_ODD);
                }

                this.add(btn);
            }

        }
    }

    public void update(Board board) {
        // todo update method
    }
}
