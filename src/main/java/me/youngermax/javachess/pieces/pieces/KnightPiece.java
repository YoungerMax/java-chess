package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KnightPiece extends AbstractPiece {
    public KnightPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        List<Tile> possibleMoves = new ArrayList<>();

        possibleMoves.add(board.getVacantTileAt(currentTile.x + 1, currentTile.y + 2));
        possibleMoves.add(board.getVacantTileAt(currentTile.x + 2, currentTile.y + 1));

        possibleMoves.add(board.getVacantTileAt(currentTile.x + 1, currentTile.y - 2));
        possibleMoves.add(board.getVacantTileAt(currentTile.x + 2, currentTile.y - 1));

        possibleMoves.add(board.getVacantTileAt(currentTile.x - 1, currentTile.y - 2));
        possibleMoves.add(board.getVacantTileAt(currentTile.x - 2, currentTile.y - 1));

        possibleMoves.add(board.getVacantTileAt(currentTile.x - 1, currentTile.y + 2));
        possibleMoves.add(board.getVacantTileAt(currentTile.x - 2, currentTile.y + 1));

        // remove all null moves
        possibleMoves.removeIf(Objects::isNull);

        return possibleMoves.toArray(new Tile[0]);
    }
}