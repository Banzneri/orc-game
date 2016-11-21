package com.company;

import java.util.*;

public class World {
    static final char ORC = 'O';
    static final char FLOOR = '.';
    static final char PLAYER = '@';

    private int height = 15;
    private int width = 35;
    private Player player;
    private char[][] tiles;
    private List<Orc> orcs;

    public World(Player player) {
        this.player = player;
        tiles = new char[width][height];
        orcs = new ArrayList<>();
        loadTiles();
        generateOrcs();
    }

    public char getTile(int x, int y) {
        return tiles[x][y];
    }

    void loadTiles() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                this.tiles[x][y] = FLOOR;
            }
        }
    }

    void printTiles(String prompt) {
        for(int y = 0; y < height; y++ ) {
            for(int x = 0; x < width; x++) {
                if(player.getX() == x && player.getY() == y)
                    System.out.print(PLAYER);
                else if(containsOrc(x, y))
                    System.out.print(ORC);
                else
                    System.out.print(FLOOR);
            }
            System.out.println();
        }
        System.out.print(prompt);
    }

    void generateOrcs() {
        for(int i = 0; i < 5; i++) {
            Random rng = new Random();
            int randX = rng.nextInt(width);
            int randY = rng.nextInt(height);
            while(tiles[randX][randY] != FLOOR) {
                randX = rng.nextInt(width);
                randY = rng.nextInt(height);
            }
            orcs.add(new Orc(randX, randY, 10, 10, 5));
        }
    }

    boolean containsOrc(int x, int y) {
        for(Orc orc: orcs) {
            if(orc.getX() == x && orc.getY() == y) {
                return true;
            }
        }
        return false;
    }

    Orc getOrc(int x, int y) {
        for(Orc orc: orcs) {
            if(orc.getX() == x && orc.getY() == y) {
                return orc;
            }
        }
        return null;
    }

    void killOrc(int x, int y) {
        for(int i = 0; i < orcs.size(); i++) {
            if(orcs.get(i).getX() == x && orcs.get(i).getY() == y) {
                orcs.remove(i);
            }
        }
    }

    Player getPlayer() {
        return player;
    }

    void refresh() {
        for(int y = 0; y < height; y++ ) {
            for (int x = 0; x < width; x++) {
                if(containsOrc(x, y)) {
                    getOrc(x, y).move(this);
                }
            }
        }
    }

    boolean tileExists(int x, int y) {
        return (x < width && x >= 0) && (y < height && y >= 0);
    }

}
