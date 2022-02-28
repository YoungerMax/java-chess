package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class QueenPiece extends AbstractPiece {
    public QueenPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        List<Tile> possibleMoves = new ArrayList<>();

        //rook abilities
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
        //bishop abilities
        for (int diagonal = 1; diagonal < Board.SIZE; diagonal++) {
            if (board.tiles[currentTile.x + diagonal][currentTile.y + diagonal] != null && !board.tiles[currentTile.x + diagonal][currentTile.y + diagonal].isOccupied()) { //up right
                possibleMoves.add(board.tiles[currentTile.x + diagonal][currentTile.y + diagonal]);
            } else if (board.tiles[currentTile.x - diagonal][currentTile.y + diagonal] != null && !board.tiles[currentTile.x - diagonal][currentTile.y + diagonal].isOccupied()) { //up left
                possibleMoves.add(board.tiles[currentTile.x - diagonal][currentTile.y + diagonal]);
            } else if (board.tiles[currentTile.x - diagonal][currentTile.y - diagonal] != null && !board.tiles[currentTile.x - diagonal][currentTile.y - diagonal].isOccupied()) { //down left
                possibleMoves.add(board.tiles[currentTile.x - diagonal][currentTile.y - diagonal]);
            } else if (board.tiles[currentTile.x + diagonal][currentTile.y - diagonal] != null && !board.tiles[currentTile.x + diagonal][currentTile.y - diagonal].isOccupied()) { //down right
                possibleMoves.add(board.tiles[currentTile.x + diagonal][currentTile.y - diagonal]);
            }
        }

        return possibleMoves.toArray(new Tile[0]);
    }
}
