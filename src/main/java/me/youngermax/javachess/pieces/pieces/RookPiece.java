package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RookPiece extends AbstractPiece {
    public RookPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        List<Tile> possibleMoves = new ArrayList<>();

        // up
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x, currentTile.y + i);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // down
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x, currentTile.y - i);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // left
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x - i, currentTile.y);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // right
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x + i, currentTile.y);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // remove all null moves
        possibleMoves.removeIf(Objects::isNull);

        return possibleMoves.toArray(new Tile[0]);
    }
}