package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

public class KingPiece extends AbstractPiece {
    @Override
    public String getName() {
        return "King";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        if (!board.tiles[currentTile.x][currentTile.y + 1].isOccupied() && board.tiles[currentTile.x][currentTile.y + 1] != null) { //up
            return new Tile[]{
                    board.tiles[currentTile.x][currentTile.y + 1]
            };
        } else if (!board.tiles[currentTile.x][currentTile.y - 1].isOccupied() && board.tiles[currentTile.x][currentTile.y - 1] != null) { //down
            return new Tile[]{
                    board.tiles[currentTile.x][currentTile.y - 1]
            };
        } else if (!board.tiles[currentTile.x + 1][currentTile.y].isOccupied() && board.tiles[currentTile.x + 1][currentTile.y] != null) { //right
            return new Tile[]{
                    board.tiles[currentTile.x + 1][currentTile.y]
            };
        } else if (!board.tiles[currentTile.x - 1][currentTile.y].isOccupied() && board.tiles[currentTile.x - 1][currentTile.y] != null) { //left
            return new Tile[]{
                    board.tiles[currentTile.x - 1][currentTile.y]
            };
        } else if (!board.tiles[currentTile.x + 1][currentTile.y + 1].isOccupied() && board.tiles[currentTile.x + 1][currentTile.y + 1] != null) { //up right
            return new Tile[]{
                    board.tiles[currentTile.x + 1][currentTile.y + 1]
            };
        } else if (!board.tiles[currentTile.x - 1][currentTile.y + 1].isOccupied() && board.tiles[currentTile.x - 1][currentTile.y + 1] != null) { //up left
            return new Tile[]{
                    board.tiles[currentTile.x - 1][currentTile.y + 1]
            };
        } else if (!board.tiles[currentTile.x - 1][currentTile.y - 1].isOccupied() && board.tiles[currentTile.x - 1][currentTile.y - 1] != null) { //down left
            return new Tile[]{
                    board.tiles[currentTile.x - 1][currentTile.y - 1]
            };
        } else if (!board.tiles[currentTile.x + 1][currentTile.y - 1].isOccupied() && board.tiles[currentTile.x + 1][currentTile.y - 1] != null) { //down right
            return new Tile[]{
                    board.tiles[currentTile.x + 1][currentTile.y - 1]
            };
        }


        return new Tile[] {};
    }

}
