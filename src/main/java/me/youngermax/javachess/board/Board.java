package me.youngermax.javachess.board;

import me.youngermax.javachess.exception.AlreadyOccupiedException;
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
            this.tiles[0][0].setOccupyingPiece(new RookPiece(this.team1));
            this.tiles[0][1].setOccupyingPiece(new KnightPiece(this.team1));
            this.tiles[0][2].setOccupyingPiece(new BishopPiece(this.team1));
            this.tiles[0][3].setOccupyingPiece(new KingPiece(this.team1));
            this.tiles[0][4].setOccupyingPiece(new QueenPiece(this.team1));
            this.tiles[0][5].setOccupyingPiece(new BishopPiece(this.team1));
            this.tiles[0][6].setOccupyingPiece(new KnightPiece(this.team1));
            this.tiles[0][7].setOccupyingPiece(new RookPiece(this.team1));

            for (int i = 0; SIZE > i; i++) {
                this.tiles[1][i].setOccupyingPiece(new PawnPiece(this.team1));
            }

            // team 2
            this.tiles[SIZE - 1][0].setOccupyingPiece(new RookPiece(this.team2));
            this.tiles[SIZE - 1][1].setOccupyingPiece(new KnightPiece(this.team2));
            this.tiles[SIZE - 1][2].setOccupyingPiece(new BishopPiece(this.team2));
            this.tiles[SIZE - 1][3].setOccupyingPiece(new KingPiece(this.team2));
            this.tiles[SIZE - 1][4].setOccupyingPiece(new QueenPiece(this.team2));
            this.tiles[SIZE - 1][5].setOccupyingPiece(new BishopPiece(this.team2));
            this.tiles[SIZE - 1][6].setOccupyingPiece(new KnightPiece(this.team2));
            this.tiles[SIZE - 1][7].setOccupyingPiece(new RookPiece(this.team2));

            for (int i = 0; SIZE > i; i++) {
                this.tiles[SIZE - 2][i].setOccupyingPiece(new PawnPiece(this.team2));
            }
        } catch (AlreadyOccupiedException e) {
            // this should not be thrown
            throw new RuntimeException("tile was occupied before board was populated, something went wrong");
        }
    }
}
