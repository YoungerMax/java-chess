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
        Color posOneTileColor;
        Color posTwoTileColor;

        boolean colorTurn = true;

        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                JButton btn = new JButton();

                btn.setForeground(Color.BLACK);

                if (row % 2 == 0) {
                    posOneTileColor = Color.LIGHT_GRAY;
                    posTwoTileColor = Color.DARK_GRAY;
                } else {
                    posOneTileColor = Color.DARK_GRAY;
                    posTwoTileColor = Color.LIGHT_GRAY;
                }

                if (colorTurn) {
                    btn.setBackground(posOneTileColor);
                    colorTurn = false;
                } else {
                    btn.setBackground(posTwoTileColor);
                    colorTurn = true;
                }

                this.add(btn);
            }

        }
    }

    public void update(Board board) {
        // todo update method
    }
}
