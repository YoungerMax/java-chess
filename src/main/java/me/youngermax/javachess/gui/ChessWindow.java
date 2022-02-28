package me.youngermax.javachess.gui;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;

import javax.swing.*;
import java.awt.*;

public class ChessWindow extends JFrame {
    private static final int TILE_SIZE = 100;

    private Board board;
    private ChessWindowTile[][] tiles = new ChessWindowTile[Board.SIZE][Board.SIZE];

    public ChessWindow(Board board) {
        this.board = board;

        this.setLayout(new GridLayout(Board.SIZE, Board.SIZE));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess");

        this.setSize(Board.SIZE * TILE_SIZE, Board.SIZE * TILE_SIZE);

        this.populate(board);
        this.update(board);
    }

    public void populate(Board board) {
        for (Tile[] tiles : board.tiles) {
            for (Tile tile : tiles) {
                ChessWindowTile btn = new ChessWindowTile(tile);
                this.tiles[tile.x][tile.y] = btn;
                this.add(btn);
            }
        }
    }

    private boolean isEvenPiece(int x, int y) {
        return x % 2 == y % 2;
    }

    public void update(Board board) {
        for (Tile[] tiles : board.tiles) {
            for (Tile tile : tiles) {
                this.tiles[tile.x][tile.y].setText(tile.getOccupyingPiece() == null ? "" : tile.getOccupyingPiece().getName() + " (" + tile.getOccupyingPiece().getTeam().id + ")");
            }
        }
    }
}
