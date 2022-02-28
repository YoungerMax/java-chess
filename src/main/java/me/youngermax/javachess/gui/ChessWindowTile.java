package me.youngermax.javachess.gui;

import me.youngermax.javachess.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessWindowTile extends JButton {
    private static final Color TILE_COLOR_EVEN = Color.LIGHT_GRAY;
    private static final Color TILE_COLOR_ODD = Color.DARK_GRAY;

    private final Tile tile;

    public ChessWindowTile(Tile tile) {
        this.tile = tile;

        this.setBackground(isEvenPiece(tile.x, tile.y) ? TILE_COLOR_EVEN : TILE_COLOR_ODD); // background color
        this.setForeground(isEvenPiece(tile.x, tile.y) ? TILE_COLOR_ODD : TILE_COLOR_EVEN); // text color
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

    private class TileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ChessWindowTile guiTile = ChessWindowTile.this;

            // todo do something here
            // TODO: proper logging
            System.out.printf("DEBUG: (%d, %d) clicked%n", guiTile.tile.x, guiTile.tile.y);
        }
    }
}