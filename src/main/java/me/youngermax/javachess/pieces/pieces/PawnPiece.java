package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

public class PawnPiece extends AbstractPiece {
    public PawnPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        // todo implement an extra move on first turn

        return new Tile[] {
                board.getVacantTileAt(currentTile.x, currentTile.y + 1)
        };
    }
}
