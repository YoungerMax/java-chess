package me.youngermax.javachess.gui;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ChessWindow extends JFrame {
    private static final int TILE_SIZE = 100;

    protected final Board board;
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
        for (int x = 0; Board.SIZE > x; x++) {
            for (int y = 0; Board.SIZE > y; y++) {
                // yes, this is goofy, but gridlayout adds components the other way
                Tile tile = board.tiles[y][x];
                ChessWindowTile btn = new ChessWindowTile(tile, this);

                this.tiles[y][x] = btn;
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
                StringBuilder builder = new StringBuilder();

                if (tile.isOccupied()) {
                    builder.append(tile.getOccupyingPiece().getName());
                    builder.append(" (").append(tile.getOccupyingPiece().getTeam().id).append(")");
                } else {
                    builder.append("(").append(tile.x).append(", ").append(tile.y).append(")");
                }

                if (this.tiles[tile.x][tile.y] == null) continue;

                this.tiles[tile.x][tile.y].setText(builder.toString());
            }
        }
    }

    public void highlightTiles(Tile[] tiles) {
        for (Tile tile : tiles) {
            System.out.println("Available: (" + tile.x + ", " + tile.y + ")");
            this.tiles[tile.x][tile.y].highlight();
        }
    }

    public void unhighlightTiles(Tile[] tiles) {
        for (Tile tile : tiles) {
            this.tiles[tile.x][tile.y].unhighlight();
        }
    }
}
