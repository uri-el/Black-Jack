/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.CW10356268;

/**
 *
 * @author satee
 */

import java.util.ArrayList;
import java.util.List;

public class levelFour {
    public static void run(List<Player> players, Deck deck) {
            boolean roundCompleted = false;

            while (!roundCompleted && deck.size() >= players.size() * 5) {
                for (Player player : players) {
                    List<Card> hand = deck.dealCards(5);
                    player.setHand(hand);
                }

                List<Player> winners = new ArrayList<>();
                for (Player player : players) {
                    int maxScore = player.getMaxSuitScore();
                    if (maxScore == 21) {
                        winners.add(player);
                    }
                }

                if (!winners.isEmpty()) {
                    for (Player winner : winners) {
                        System.out.println(winner.getName() + " scored 21!");
                    }
                    roundCompleted = true;
                }

                if (deck.size() < players.size() * 5) {
                    System.out.println("Insufficient cards for another round.");
                    break;
                }
            }
        }
    }
