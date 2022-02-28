package me.youngermax.javachess.board;

import me.youngermax.javachess.exception.AlreadyOccupiedException;
import me.youngermax.javachess.pieces.Piece;

public class Tile {
    public final int x;
    public final int y;

    private Piece occupyingPiece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    public void setOccupyingPiece(Piece piece) throws AlreadyOccupiedException {
        if (isOccupied()) {
            throw new AlreadyOccupiedException();
        }

        occupyingPiece = piece;
    }

    public void leave() {
        occupyingPiece = null;
    }

    public boolean isOccupied() {
        return occupyingPiece != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tile) {
            Tile tile = (Tile) o;

            return tile.x == this.x && tile.y == this.y;
        }

        return false;
    }
}
