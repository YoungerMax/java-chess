package me.youngermax.javachess.gui;

import me.youngermax.javachess.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// a JButton, but with extra logic for chess
public class ChessWindowTile extends JButton {
    private static final Color TILE_COLOR_EVEN = new Color(210, 180, 140);
    private static final Color TILE_COLOR_ODD = new Color(189,154,122);
    private static final Color TILE_COLOR_HIGHLIGHT = Color.BLUE;

    private final Tile tile;
    private final ChessWindow window;

    public ChessWindowTile(Tile tile, ChessWindow window) {
        this.tile = tile;
        this.window = window;

        // set the background color
        this.setBackground(isEvenPiece(tile.x, tile.y) ? TILE_COLOR_EVEN : TILE_COLOR_ODD);

        // set the text color
        this.setForeground(Color.BLACK);

        // add a click listener
        this.addActionListener(new TileActionListener());
    }

    private boolean isEvenPiece(int x, int y) {
        return x % 2 == y % 2;
    }

    // antialias text so it looks good and isn't pixelated
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        super.paintComponent(graphics);
    }

    public void highlight() {
        this.setBackground(TILE_COLOR_HIGHLIGHT);
    }

    public void unhighlight() {
        this.setBackground(isEvenPiece(tile.x, tile.y) ? TILE_COLOR_EVEN : TILE_COLOR_ODD);
    }

    private class TileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ChessWindowTile guiTile = ChessWindowTile.this;

            // TODO: proper logging
            System.out.printf("DEBUG: (%d, %d) clicked%n", guiTile.tile.x, guiTile.tile.y);

            // make sure there is a piece on the clicked tile
            if (guiTile.tile.isOccupied()) {
                System.out.println("Tile is occupied");

                // show the available tiles that the piece can move to
                guiTile.window.highlightTiles(
                        guiTile.tile.getOccupyingPiece().getAvailableMoves(guiTile.window.board)
                );
            }
        }
    }
}
