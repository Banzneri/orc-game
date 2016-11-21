package com.company;

public class Player extends GameObject {
    public int hp;
    public int maxHp;
    public int attack;

    public Player(int x, int y, int hp, int maxHp, int attack) {
        super(x, y, "Player", "The hero.", '@');
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = this.hp + hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void move(int x, int y, World world) {
        int newX = super.getX() + x;
        int newY = super.getY() + y;
        if(world.tileExists(newX, newY)) {
            if(world.containsOrc(newX, newY)) {
                int dmg = getAttack();
                world.getOrc(newX, newY).setHp(-dmg);
                if (world.getOrc(newX, newY).getHp() <= 0)
                    world.killOrc(newX, newY);
            }
            else if(world.getTile(newX, newY) == World.FLOOR) {
                super.setX(newX);
                super.setY(newY);
            }
        }
    }

    public String showHp() {
        String str = hp + "/" + maxHp + "> ";
        return str;
    }
}