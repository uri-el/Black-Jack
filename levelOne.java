/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.CW10356268;

/**
 *
 * @author satee
 */

import java.util.List;
import java.util.Scanner;

public class levelOne {
    public static int run(List<Player> players, Deck deck) {
        Scanner scanner = new Scanner(System.in);

        int numPlayers;
        do {
            System.out.print("Enter the number of players (2-6): ");
            numPlayers = scanner.nextInt();
        } while (numPlayers < 2 || numPlayers > 6);

        scanner.nextLine(); 

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
            if (name.equalsIgnoreCase("Computer")) {
                System.out.println("Player " + i + " is controlled by the computer.");
            }
        }

        int numRounds;
        do {
            System.out.print("Enter the number of rounds to play: ");
            numRounds = scanner.nextInt();
        } while (numRounds <= 0);

        return numRounds;
    }
}
