package me.youngermax.javachess.board;

import me.youngermax.javachess.exception.AlreadyOccupiedException;
import me.youngermax.javachess.pieces.pieces.*;

public class Board {
    public static final int SIZE = 8;

    public Tile[][] tiles = new Tile[SIZE][SIZE];

    public Board() {
        this.populateBoard();
    }

    private void populateBoard() {
        for (int x = 0; SIZE > x; x++) {
            for (int y = 0; SIZE > y; y++) {
                this.tiles[x][y] = new Tile(x, y);
            }
        }

        try {
            this.tiles[0][0].setOccupyingPiece(new RookPiece());
            this.tiles[0][1].setOccupyingPiece(new KnightPiece());
            this.tiles[0][2].setOccupyingPiece(new BishopPiece());
            this.tiles[0][3].setOccupyingPiece(new KingPiece());
            this.tiles[0][4].setOccupyingPiece(new QueenPiece());
            this.tiles[0][5].setOccupyingPiece(new BishopPiece());
            this.tiles[0][6].setOccupyingPiece(new KnightPiece());
            this.tiles[0][7].setOccupyingPiece(new RookPiece());

            for (int i = 0; SIZE > i; i++) {
                this.tiles[1][i].setOccupyingPiece(new PawnPiece());
            }
        } catch (AlreadyOccupiedException e) {
            // this should not be thrown
            throw new RuntimeException("tile was occupied before board was populated, something went wrong");
        }
    }
}
