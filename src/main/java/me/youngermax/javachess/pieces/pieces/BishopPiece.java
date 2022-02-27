package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

public class BishopPiece extends AbstractPiece {
    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {

        for (int diagonal = 1; diagonal < Board.SIZE; diagonal++) {
            if (!board.tiles[currentTile.x + diagonal][currentTile.y + diagonal].isOccupied() && board.tiles[currentTile.x + diagonal][currentTile.y + diagonal] != null) { //up right
                return new Tile[]{
                        board.tiles[currentTile.x + diagonal][currentTile.y + diagonal]
                };
            } else if (!board.tiles[currentTile.x - diagonal][currentTile.y + diagonal].isOccupied() && board.tiles[currentTile.x - diagonal][currentTile.y + diagonal] != null) { //up left
                return new Tile[]{
                        board.tiles[currentTile.x - diagonal][currentTile.y + diagonal]
                };
            } else if (!board.tiles[currentTile.x - diagonal][currentTile.y - diagonal].isOccupied() && board.tiles[currentTile.x - diagonal][currentTile.y - diagonal] != null) { //down left
                return new Tile[]{
                        board.tiles[currentTile.x - diagonal][currentTile.y - diagonal]
                };
            } else if (!board.tiles[currentTile.x + diagonal][currentTile.y - diagonal].isOccupied() && board.tiles[currentTile.x + diagonal][currentTile.y - diagonal] != null) { //down right
                return new Tile[]{
                        board.tiles[currentTile.x + diagonal][currentTile.y - diagonal]
                };
            }
        }
        return new Tile[] {};
    }
}