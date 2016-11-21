package com.company;

import java.util.Random;

public class Orc extends GameObject {
    private int hp;
    private int maxHp;
    private int attack;

    public Orc(int x, int y, int hp, int maxHp, int attack) {
        super(x, y, "Orc", "An ugly orc.", 'O');
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int attack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void move(World world) {
        Random rng = new Random();
        int randX = rng.nextInt(3) - 1;
        int randY = rng.nextInt(3) - 1;
        int newX = super.getX() + randX;
        int newY = super.getY() + randY;
        if(world.tileExists(newX, newY)) {
            if(world.getPlayer().getX() == newX && world.getPlayer().getY() == newY) {
                int dmg = this.attack();
                world.getPlayer().setHp(-dmg);
            }
            else if(world.getTile(newX, newY) == World.FLOOR){
                super.setX(newX);
                super.setY(newY);
            }
        }
    }
}
