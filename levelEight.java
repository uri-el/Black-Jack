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
import java.util.Scanner;

public class levelEight {
    public static void run(List<Player> players, Deck deck) {
        Scanner scanner = new Scanner(System.in);
        List<RoundInfo> replayData = new ArrayList<>();

        boolean gameWon = false;
        while (!gameWon && deck.size() >= players.size() * 5) {
            RoundInfo roundInfo = new RoundInfo();

            for (Player player : players) {
                List<Card> hand = deck.dealCards(5);
                player.setHand(hand);
                roundInfo.addPlayerHand(player.getName(), new ArrayList<>(hand));
            }

            List<Player> winners = new ArrayList<>();
            for (Player player : players) {
                int maxScore = player.getMaxSuitScore();
                roundInfo.addPlayerMaxScore(player.getName(), maxScore);
                if (maxScore == 21) {
                    winners.add(player);
                }
            }

            replayData.add(roundInfo);

            if (!winners.isEmpty()) {
                for (Player winner : winners) {
                    System.out.println(winner.getName() + " scored 21!");
                }
                gameWon = true;
            }
        }

        System.out.print("View replay? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            for (RoundInfo round : replayData) {
                System.out.println(round);
            }
        }
    }

    private static class RoundInfo {
        private final List<String> playerHands;
        private final List<String> playerScores;

        public RoundInfo() {
            this.playerHands = new ArrayList<>();
            this.playerScores = new ArrayList<>();
        }

        public void addPlayerHand(String playerName, List<Card> hand) {
            playerHands.add(playerName + "'s hand: " + hand);
        }

        public void addPlayerMaxScore(String playerName, int maxScore) {
            playerScores.add(playerName + "'s max score: " + maxScore);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < playerHands.size(); i++) {
                sb.append(playerHands.get(i)).append("\n").append(playerScores.get(i)).append("\n");
            }
            return sb.toString();
        }
    }
}
