package me.youngermax.javachess.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.exception.AlreadyOccupiedException;
import me.youngermax.javachess.exception.CannotMoveException;

import java.util.Arrays;

public abstract class AbstractPiece implements Piece {
    protected final Team team;
    protected Tile currentTile;

    public AbstractPiece(Team team) {
        this.team = team;
    }

    @Override
    public Tile getCurrentTile() {
        return currentTile;
    }

    @Override
    public void moveToTile(Board board, Tile tile) throws CannotMoveException {
        // check if the piece can move to the new tile
        if (currentTile != null && !Arrays.asList(this.getAvailableMoves(board)).contains(tile)) {
            throw new CannotMoveException("cannot move to tile, it's already occupied");
        }

        // this is the old tile now
        if (currentTile != null) currentTile.leave();

        // move
        tile.setOccupyingPiece(this);
        currentTile = tile;
    }

    @Override
    public Team getTeam() {
        return this.team;
    }
}
