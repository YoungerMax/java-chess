package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

public class KnightPiece extends AbstractPiece {
    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        if (!board.tiles[currentTile.x + 1][currentTile.y + 2].isOccupied() && board.tiles[currentTile.x + 1][currentTile.y + 2] != null) { //right 1 up 2
            return new Tile[]{
                    board.tiles[currentTile.x + 1][currentTile.y + 2]
            };
        } else if (!board.tiles[currentTile.x + 2][currentTile.y + 1].isOccupied() && board.tiles[currentTile.x + 2][currentTile.y + 1] != null) { //right 2 up 1
            return new Tile[]{
                    board.tiles[currentTile.x + 2][currentTile.y + 1]
            };
        } else if (!board.tiles[currentTile.x + 2][currentTile.y - 1].isOccupied() && board.tiles[currentTile.x + 1][currentTile.y - 2] != null) { //right 2 down 1
            return new Tile[]{
                    board.tiles[currentTile.x + 2][currentTile.y - 1]
            };
        } else if (!board.tiles[currentTile.x + 1][currentTile.y - 2].isOccupied() && board.tiles[currentTile.x + 1][currentTile.y - 2] != null) { //right 1 down 2
            return new Tile[]{
                    board.tiles[currentTile.x + 1][currentTile.y - 2]
            };
        } else if (!board.tiles[currentTile.x - 1][currentTile.y - 2].isOccupied() && board.tiles[currentTile.x - 1][currentTile.y - 2] != null) { //left 1 down 2
            return new Tile[]{
                    board.tiles[currentTile.x - 1][currentTile.y - 2]
            };
        } else if (!board.tiles[currentTile.x - 2][currentTile.y + 1].isOccupied() && board.tiles[currentTile.x - 2][currentTile.y + 1] != null) { //left 2 up 1
            return new Tile[]{
                    board.tiles[currentTile.x - 2][currentTile.y + 1]
            };
        } else if (!board.tiles[currentTile.x - 2][currentTile.y - 1].isOccupied() && board.tiles[currentTile.x - 2][currentTile.y - 1] != null) { //right 2 up 1
            return new Tile[]{
                    board.tiles[currentTile.x - 2][currentTile.y - 1]
            };
        }
        return new Tile[] {};
    }
}