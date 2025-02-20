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

public class levelSix {
    public static void run(List<Player> players, int numRounds) {

        players.sort((p1, p2) -> Double.compare(p2.getTotalScore(), p1.getTotalScore()));
        
        double highestScore = players.get(0).getTotalScore();
        double secondHighestScore = players.size() > 1 ? players.get(1).getTotalScore() : 0;

        for (Player player : players) {
            if (player.getTotalScore() == highestScore && highestScore == secondHighestScore) {
                player.setFinalScore(0.5); 
            } else if (player.getTotalScore() == highestScore) {
                player.setFinalScore(1); 
            } else {
                player.setFinalScore(0);
            }
        }

        System.out.println("\n--- Final Scores ---");
        for (Player player : players) {
            System.out.println(player.getName() + " (Final Score: " + player.getFinalScore() + ")");
        }
    }
}
