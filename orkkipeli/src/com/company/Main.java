package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("outside main loop");
        Player player = new Player(0, 0, 10, 10, 5);
        World world = new World(player);

        while (true) {
            System.out.println("In main loop");
            world.printTiles(player.showHp());
            Scanner scan = new Scanner(System.in);
            String cmd = scan.next();
            switch (cmd) {
                case "w": player.move(0, -1, world);
                          break;
                case "a": player.move(-1, 0, world);
                          break;
                case "s": player.move(0, 1, world);
                          break;
                case "d": player.move(1, 0, world);
                          break;
            }
            world.refresh();
            if(player.getHp() <= 0) {
                System.out.println("You died!");
                break;
            }
        }
    }
}
