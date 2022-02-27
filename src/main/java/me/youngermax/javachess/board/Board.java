package me.youngermax.javachess.board;

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

        // todo implement pieces
        this.tiles[0][0] = null; // TODO: rook
        this.tiles[0][1] = null; // TODO: knight
        this.tiles[0][2] = null; // TODO: bishop
        this.tiles[0][3] = null; // TODO: king
        this.tiles[0][4] = null; // TODO: queen
        this.tiles[0][5] = null; // TODO: bishop
        this.tiles[0][6] = null; // TODO: knight
        this.tiles[0][7] = null; // TODO: rook

        for (int i = 0; SIZE > i; i++) {
            this.tiles[1][i] = null; // todo pawn
        }
    }
}
