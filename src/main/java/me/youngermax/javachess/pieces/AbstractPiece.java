package me.youngermax.javachess.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.exception.AlreadyOccupiedException;
import me.youngermax.javachess.exception.CannotMoveException;

import java.util.Arrays;

public abstract class AbstractPiece implements Piece {
    protected Tile currentTile;

    @Override
    public Tile getCurrentTile() {
        return currentTile;
    }

    @Override
    public void moveToTile(Board board, Tile tile) throws CannotMoveException, AlreadyOccupiedException {
        // check if the piece can move to the new tile
        if (!Arrays.asList(this.getAvailableMoves(board)).contains(tile)) {
            throw new CannotMoveException("cannot move to tile, it's already occupied");
        }

        // this is the old tile now
        currentTile.leave();

        // move
        tile.setOccupyingPiece(this);
        currentTile = tile;
    }
}
