package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

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

        if (board.tiles[currentTile.x + 1][currentTile.y + 2] != null && !board.tiles[currentTile.x + 1][currentTile.y + 2].isOccupied()) { //right 1 up 2
            possibleMoves.add(board.tiles[currentTile.x + 1][currentTile.y + 2]);
        } else if (board.tiles[currentTile.x + 2][currentTile.y + 1] != null && !board.tiles[currentTile.x + 2][currentTile.y + 1].isOccupied()) { //right 2 up 1
            possibleMoves.add(board.tiles[currentTile.x + 2][currentTile.y + 1]);
        } else if (board.tiles[currentTile.x + 1][currentTile.y - 2] != null && !board.tiles[currentTile.x + 2][currentTile.y - 1].isOccupied()) { //right 2 down 1
            possibleMoves.add(board.tiles[currentTile.x + 2][currentTile.y - 1]);
        } else if (board.tiles[currentTile.x + 1][currentTile.y - 2] != null && !board.tiles[currentTile.x + 1][currentTile.y - 2].isOccupied()) { //right 1 down 2
            possibleMoves.add(board.tiles[currentTile.x + 1][currentTile.y - 2]);
        } else if (board.tiles[currentTile.x - 1][currentTile.y - 2] != null && !board.tiles[currentTile.x - 1][currentTile.y - 2].isOccupied()) { //left 1 down 2
            possibleMoves.add(board.tiles[currentTile.x - 1][currentTile.y - 2]);
        } else if (board.tiles[currentTile.x - 2][currentTile.y + 1] != null && !board.tiles[currentTile.x - 2][currentTile.y + 1].isOccupied()) { //left 2 up 1
            possibleMoves.add(board.tiles[currentTile.x - 2][currentTile.y + 1]);
        } else if (board.tiles[currentTile.x - 2][currentTile.y - 1] != null && !board.tiles[currentTile.x - 2][currentTile.y - 1].isOccupied()) { //right 2 up 1
            possibleMoves.add(board.tiles[currentTile.x - 2][currentTile.y - 1]);
        }

        return possibleMoves.toArray(new Tile[0]);
    }
}