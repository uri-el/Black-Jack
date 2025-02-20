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

public class levelNine {
    public static void run(List<Player> players, Deck deck) {
        System.out.println("\n--- Joker Cards in Play ---");

        for (Player player : players) {
            Card jokerCard = findJokerCard(player.getHand());
            if (jokerCard != null) {
                applyJokerEffect(player, jokerCard);
            } else {
                System.out.println(player.getName() + " does not have a Joker card.");
            }
        }
    }

    private static Card findJokerCard(List<Card> hand) {
        for (Card card : hand) {
            if (card.getSuit().equals("Joker")) {
                return card;
            }
        }
        return null;
    }

    private static void applyJokerEffect(Player player, Card jokerCard) {
        int currentHandValue = calculateHandValue(player.getHand());
        System.out.println(player.getName() + "'s current hand value: " + currentHandValue);

        if (currentHandValue < 21) {
            int jokerValue = 21 - currentHandValue; 
            System.out.println("Joker fills the gap with value: " + jokerValue);
            System.out.println(player.getName() + "'s hand is now worth 21!");
            if (jokerCard == null) {
    System.out.println("No Joker card to apply effect.");
    return;
}

        } else {
            System.out.println("Hand value is already 21 or higher. Joker stays at value: 0.");
        }

        System.out.println(); 
    }

    private static int calculateHandValue(List<Card> hand) {
        int totalValue = 0;
        for (Card card : hand) {
            if (!card.getSuit().equals("Joker")) { 
                totalValue += card.getValue();
            }
        }
        return totalValue;
    }
}
