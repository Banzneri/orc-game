package com.company;

public class GameObject {
    private int x;
    private int y;
    private String name;
    private String desc;
    private char glyph;

    public GameObject(int x, int y, String name, String desc,
                      char glyph) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.desc = desc;
        this.glyph = glyph;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public char getGlyph() {
        return glyph;
    }

    public void setGlyph(char glyph) {
        this.glyph = glyph;
    }
}
