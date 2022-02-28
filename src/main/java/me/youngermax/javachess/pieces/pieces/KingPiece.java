package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class KingPiece extends AbstractPiece {
    public KingPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {

        List<Tile> possibleMoves = new ArrayList<>();

        if (board.tiles[currentTile.x][currentTile.y + 1] != null && !board.tiles[currentTile.x][currentTile.y + 1].isOccupied()) { //up
            possibleMoves.add(board.tiles[currentTile.x][currentTile.y + 1]);
        } else if (board.tiles[currentTile.x][currentTile.y - 1] != null && !board.tiles[currentTile.x][currentTile.y - 1].isOccupied()) { //down
            possibleMoves.add(board.tiles[currentTile.x][currentTile.y - 1]);
        } else if (board.tiles[currentTile.x + 1][currentTile.y] != null && !board.tiles[currentTile.x + 1][currentTile.y].isOccupied()) { //right
            possibleMoves.add(board.tiles[currentTile.x + 1][currentTile.y]);
        } else if (board.tiles[currentTile.x - 1][currentTile.y] != null && !board.tiles[currentTile.x - 1][currentTile.y].isOccupied()) { //left
            possibleMoves.add(board.tiles[currentTile.x - 1][currentTile.y]);
        } else if (board.tiles[currentTile.x + 1][currentTile.y + 1] != null && !board.tiles[currentTile.x + 1][currentTile.y + 1].isOccupied()) { //up right
            possibleMoves.add(board.tiles[currentTile.x + 1][currentTile.y + 1]);
        } else if (board.tiles[currentTile.x - 1][currentTile.y + 1] != null && !board.tiles[currentTile.x - 1][currentTile.y + 1].isOccupied()) { //up left
            possibleMoves.add(board.tiles[currentTile.x - 1][currentTile.y + 1]);
        } else if (board.tiles[currentTile.x - 1][currentTile.y - 1] != null && !board.tiles[currentTile.x - 1][currentTile.y - 1].isOccupied()) { //down left
            possibleMoves.add(board.tiles[currentTile.x - 1][currentTile.y - 1]);
        } else if (board.tiles[currentTile.x + 1][currentTile.y - 1] != null && !board.tiles[currentTile.x + 1][currentTile.y - 1].isOccupied()) { //down right
            possibleMoves.add(board.tiles[currentTile.x + 1][currentTile.y - 1]);
        }

        return possibleMoves.toArray(new Tile[0]);
    }
}