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
import java.util.ArrayList;

public class RunAllLevels {

    public static void main(String[] args) {
        System.out.println("Welcome to Suit 21 Game!");
        List<Player> players = new ArrayList<>();

        System.out.println("\n--- Game begins! ---");

        players.clear();

        int numRounds = levelOne.run(players, new Deck());

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("\n--- Round " + round + " begins! ---");

            Deck deck = new Deck();
            deck.shuffle();

            boolean roundEnded = false;

            for (Player player : players) {
                List<Card> initialHand = deck.dealCards(5);
                player.setHand(initialHand);
                System.out.println(player.getName() + "'s hand: " + player.getHand());
                System.out.println(player.getName() + "'s maximum score from a single suit: " + player.getMaxSuitScore());
                System.out.println();
            }

            while (!roundEnded) {
                for (Player player : players) {
                    if (deck.isEmpty()) {
                        System.out.println("The deck is empty. Ending the round.");
                        roundEnded = true;
                        break; 
                    }

                    if (player.getName().equalsIgnoreCase("Computer")) {
                        System.out.println(player.getName() + "'s turn:");
                        levelSeven.run(List.of(player), deck); 
                    } else {
                        System.out.println(player.getName() + "'s turn:");
                        levelThree.run(List.of(player), deck); 
                    }
                    if (player.getMaxSuitScore() == 21) {
                        System.out.println(player.getName() + " scored 21 and wins the round!");
                        roundEnded = true;
                        break; 
                    }
                }
            }

            levelNine.run(players, deck);
            levelFive.run(players);

            boolean pointsAwarded = false;
            for (Player player : players) {
                if (player.getMaxSuitScore() == 21) {
                    System.out.println(player.getName() + " scored 21!");
                    pointsAwarded = true;
                }
            }

            if (!pointsAwarded && !deck.isEmpty()) {
                System.out.println("No points awarded this round.");
            }
        }

        levelSix.run(players, numRounds);

        System.out.println("\n--- Game Over! ---");
    }
}
