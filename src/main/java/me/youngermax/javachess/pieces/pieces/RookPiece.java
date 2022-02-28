package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class RookPiece extends AbstractPiece {
    public RookPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {

        List<Tile> possibleMoves = new ArrayList<>();

        for (int i = 0; i < Board.SIZE; i++) {
            if (board.tiles[currentTile.x][currentTile.y + i] != null && !board.tiles[currentTile.x][currentTile.y + i].isOccupied()) { //up
                possibleMoves.add(board.tiles[currentTile.x][currentTile.y + i]);
            } else if (board.tiles[currentTile.x][currentTile.y - i] != null && !board.tiles[currentTile.x][currentTile.y - i].isOccupied()) { //down
                possibleMoves.add(board.tiles[currentTile.x][currentTile.y - i]);
            } else if (board.tiles[currentTile.x + i][currentTile.y] != null && !board.tiles[currentTile.x + i][currentTile.y].isOccupied()) { //right
                possibleMoves.add(board.tiles[currentTile.x + i][currentTile.y]);
            } else if (board.tiles[currentTile.x - i][currentTile.y] != null && !board.tiles[currentTile.x - i][currentTile.y].isOccupied()) { //left
                possibleMoves.add(board.tiles[currentTile.x - i][currentTile.y]);
            }
        }
        return possibleMoves.toArray(new Tile[0]);
    }
}