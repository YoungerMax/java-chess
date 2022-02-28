package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class BishopPiece extends AbstractPiece {
    public BishopPiece(Team team) {
        super(team);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public Tile[] getAvailableMoves(Board board) {
        List<Tile> possibleMoves = new ArrayList<>();

        for (int diagonal = 1; diagonal < Board.SIZE; diagonal++) {
            if (!board.tiles[currentTile.x + diagonal][currentTile.y + diagonal].isOccupied() && board.tiles[currentTile.x + diagonal][currentTile.y + diagonal] != null) { //up right
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