package me.youngermax.javachess.board;

import me.youngermax.javachess.exception.CannotMoveException;
import me.youngermax.javachess.pieces.pieces.*;

public class Board {
    public static final int SIZE = 8;

    private final Team team1 = new Team(0);
    private final Team team2 = new Team(1);

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
            // team 1
            new RookPiece(this.team1).moveToTile(this, this.tiles[0][0]);
            new KnightPiece(this.team1).moveToTile(this, this.tiles[1][0]);
            new BishopPiece(this.team1).moveToTile(this, this.tiles[2][0]);
            new KingPiece(this.team1).moveToTile(this, this.tiles[3][0]);
            new QueenPiece(this.team1).moveToTile(this, this.tiles[4][0]);
            new BishopPiece(this.team1).moveToTile(this, this.tiles[5][0]);
            new KnightPiece(this.team1).moveToTile(this, this.tiles[6][0]);
            new RookPiece(this.team1).moveToTile(this, this.tiles[7][0]);

            for (int i = 0; SIZE > i; i++) {
                //new PawnPiece(this.team1).moveToTile(this, this.tiles[i][1]);
            }

            // team 2
            new RookPiece(this.team2).moveToTile(this, this.tiles[0][SIZE - 1]);
            new KnightPiece(this.team2).moveToTile(this, this.tiles[1][SIZE - 1]);
            new BishopPiece(this.team2).moveToTile(this, this.tiles[2][SIZE - 1]);
            new KingPiece(this.team2).moveToTile(this, this.tiles[3][SIZE - 1]);
            new QueenPiece(this.team2).moveToTile(this, this.tiles[4][SIZE - 1]);
            new BishopPiece(this.team2).moveToTile(this, this.tiles[5][SIZE - 1]);
            new KnightPiece(this.team2).moveToTile(this, this.tiles[6][SIZE - 1]);
            new RookPiece(this.team2).moveToTile(this, this.tiles[7][SIZE - 1]);

            for (int i = 0; SIZE > i; i++) {
                new PawnPiece(this.team2).moveToTile(this, this.tiles[i][SIZE - 2]);
            }
        } catch (CannotMoveException e) {
            // this should not be thrown
            throw new RuntimeException("tile was occupied before board was populated, something went wrong");
        }
    }

    // safely (no java.lang.ArrayIndexOutOfBoundsException) get a tile at (x, y)
    public Tile getTileAt(int x, int y) {
        if (x > -1 && y > -1 && this.tiles.length > x && this.tiles[x].length > y) {
            return this.tiles[x][y];
        }

        return null;
    }

    public Tile getVacantTileAt(int x, int y) {
        Tile t = getTileAt(x, y);

        return t == null || t.isOccupied() ? null : t;
    }
}
