package me.youngermax.javachess.exception;

import me.youngermax.javachess.board.Tile;

public class AlreadyOccupiedException extends CannotMoveException {
    public AlreadyOccupiedException(Tile tile) {
        super("tile at (%d, %d) is already occupied");
    }
}
