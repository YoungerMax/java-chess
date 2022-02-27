package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

public class QueenPiece extends AbstractPiece {

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        //rook abilities
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
        //bishop abilities
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

        return new Tile[0];
    }
}
