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

public class levelThree {
    public static void run(List<Player> players, Deck deck) {
        Scanner scanner = new Scanner(System.in);
        for (Player player : players) {
            System.out.print(player.getName() + ", do you want to swap a card? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                System.out.print("Enter the position of the card to swap (1-5): ");
                int cardIndex = scanner.nextInt() - 1;
                scanner.nextLine(); 
                if (cardIndex >= 0 && cardIndex < player.getHand().size()) {
                    Card oldCard = player.getHand().get(cardIndex);
                    Card newCard = deck.dealCard();
                    if (newCard != null) {
                        player.getHand().set(cardIndex, newCard);
                        System.out.println("Swapped " + oldCard + " for " + newCard);
                    } else {
                        System.out.println("No cards left in the deck to swap.");
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            System.out.println(player.getName() + "'s updated hand: " + player.getHand());

            int totalValue = player.calculateHandValue();
            System.out.println(player.getName() + "'s total hand value: " + totalValue);
            System.out.println(); 
        }
    }
}
