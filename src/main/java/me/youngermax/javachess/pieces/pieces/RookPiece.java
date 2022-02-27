package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

public class RookPiece extends AbstractPiece {

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        for (int i = 0; i < Board.SIZE; i++) {
            if (!board.tiles[currentTile.x][currentTile.y + i].isOccupied() && board.tiles[currentTile.x][currentTile.y + i] != null) { //up
                return new Tile[]{
                        board.tiles[currentTile.x][currentTile.y + i]
                };
            } else if (!board.tiles[currentTile.x][currentTile.y - i].isOccupied() && board.tiles[currentTile.x][currentTile.y - i] != null) { //down
                return new Tile[]{
                        board.tiles[currentTile.x][currentTile.y - i]
                };
            } else if (!board.tiles[currentTile.x + i][currentTile.y].isOccupied() && board.tiles[currentTile.x + i][currentTile.y] != null) { //right
                return new Tile[]{
                        board.tiles[currentTile.x + i][currentTile.y]
                };
            } else if (!board.tiles[currentTile.x - i][currentTile.y].isOccupied() && board.tiles[currentTile.x - i][currentTile.y] != null) { //left
                return new Tile[]{
                        board.tiles[currentTile.x - i][currentTile.y]
                };
            }
        }
        return new Tile[] {};
    }
}