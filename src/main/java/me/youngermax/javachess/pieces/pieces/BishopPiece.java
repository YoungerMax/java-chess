package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class BishopPiece extends AbstractPiece {
    public BishopPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        List<Tile> possibleMoves = new ArrayList<>();

        // check diagonal up + right
        for (int upRight = 1; upRight < Board.SIZE; upRight++) {
            Tile tile = board.getVacantTileAt(currentTile.x + upRight, currentTile.y + upRight);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // check diagonal up + left
        for (int upLeft = 1; upLeft < Board.SIZE; upLeft++) {
            Tile tile = board.getVacantTileAt(currentTile.x - upLeft, currentTile.y + upLeft);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // check diagonal down + right
        for (int downRight = 1; downRight < Board.SIZE; downRight++) {
            Tile tile = board.getVacantTileAt(currentTile.x + downRight, currentTile.y - downRight);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // check diagonal down + left
        for (int downLeft = 1; downLeft < Board.SIZE; downLeft++) {
            Tile tile = board.getVacantTileAt(currentTile.x - downLeft, currentTile.y - downLeft);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        return possibleMoves.toArray(new Tile[0]);
    }
}