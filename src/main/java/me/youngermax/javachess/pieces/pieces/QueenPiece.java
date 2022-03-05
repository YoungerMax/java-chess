package me.youngermax.javachess.pieces.pieces;

import me.youngermax.javachess.board.Board;
import me.youngermax.javachess.board.Team;
import me.youngermax.javachess.board.Tile;
import me.youngermax.javachess.pieces.AbstractPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        // rook abilities
        this.addBishopTilesToPossibleMoves(board, possibleMoves);

        // bishop abilities
        this.addRookTilesToPossibleMoves(board, possibleMoves);

        // remove all null moves
        possibleMoves.removeIf(Objects::isNull);

        return possibleMoves.toArray(new Tile[0]);
    }

    private void addRookTilesToPossibleMoves(Board board, List<Tile> possibleMoves) {
        // up
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x, currentTile.y + i);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // down
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x, currentTile.y - i);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // left
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x - i, currentTile.y);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // right
        for (int i = 1; Board.SIZE > i; i++) {
            Tile tile = board.getVacantTileAt(currentTile.x + i, currentTile.y);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }
    }

    private void addBishopTilesToPossibleMoves(Board board, List<Tile> possibleMoves) {
        // check diagonal up + right
        for (int upRight = 1; upRight < Board.SIZE; upRight++) {
            Tile tile = board.getVacantTileAt(currentTile.x + upRight, currentTile.y + upRight);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // check diagonal up + left
        for (int upLeft = 1; upLeft < Board.SIZE; upLeft++) {
            Tile tile = board.getVacantTileAt(currentTile.x - upLeft, currentTile.y + upLeft);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // check diagonal down + right
        for (int downRight = 1; downRight < Board.SIZE; downRight++) {
            Tile tile = board.getVacantTileAt(currentTile.x + downRight, currentTile.y - downRight);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }

        // check diagonal down + left
        for (int downLeft = 1; downLeft < Board.SIZE; downLeft++) {
            Tile tile = board.getVacantTileAt(currentTile.x - downLeft, currentTile.y - downLeft);

            if (tile != null) {
                possibleMoves.add(tile);
            } else {
                break;
            }
        }
    }
}
