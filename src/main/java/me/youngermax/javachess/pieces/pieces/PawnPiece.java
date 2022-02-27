package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

// todo implement all other pieces
public class PawnPiece extends AbstractPiece {
    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        // todo implement an extra move on first turn

        if (!board.tiles[currentTile.x][this.currentTile.y + 1].isOccupied()) {
            return new Tile[] {
                    board.tiles[currentTile.x][this.currentTile.y + 1]
            };
        } else {
            return new Tile[] {};
        }
    }
}
