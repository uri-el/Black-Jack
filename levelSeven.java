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

public class levelSeven {
    public static void run(List<Player> players, Deck deck) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase("Computer")) {
                performComputerTurn(player, deck);
            }
        }
    }

    private static void performComputerTurn(Player player, Deck deck) {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty. Computer cannot make a move.");
            return;
        }

        int bestSwapIndex = -1;
        Card bestNewCard = null;
        int currentMaxScore = player.getMaxSuitScore();

        for (int i = 0; i < player.getHand().size(); i++) {
            Card oldCard = player.getHand().get(i);

            if (!deck.isEmpty()) {
                Card newCard = deck.dealCard(); 

                player.getHand().set(i, newCard);
                int newScore = player.getMaxSuitScore();

                if (newScore > currentMaxScore) {
                    currentMaxScore = newScore;
                    bestSwapIndex = i;
                    bestNewCard = newCard;
                }

                player.getHand().set(i, oldCard);
            }
        }

        System.out.println(player.getName() + "'s turn:");
        System.out.println(player.getName() + " is evaluating its options...");
        if (bestSwapIndex != -1 && bestNewCard != null) {
            Card oldCard = player.getHand().set(bestSwapIndex, bestNewCard);
            System.out.println(player.getName() + " swapped " + oldCard + " for " + bestNewCard);
        } else {
            System.out.println(player.getName() + " chose not to swap.");
        }

        System.out.println(player.getName() + "'s updated hand: " + player.getHand());

        int totalValue = player.calculateHandValue();
        System.out.println(player.getName() + "'s total hand value: " + totalValue);
        System.out.println(); 
    }
}
