package me.youngermax.javachess.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.exception.AlreadyOccupiedException;
import me.youngermax.javachess.exception.CannotMoveException;

public interface Piece {
    String getName();

    Tile[] getAvailableMoves(Board board);

    Tile getCurrentTile();

    void moveToTile(Board board, Tile tile) throws CannotMoveException, AlreadyOccupiedException;

    Team getTeam();
}
