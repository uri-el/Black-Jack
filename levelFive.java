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

public class levelFive {
    public static void run(List<Player> players) {
        List<Player> winners = new ArrayList<>();

        for (Player player : players) {
            int maxScore = player.getMaxSuitScore();
            if (maxScore == 21 && !player.hasScoredThisRound()) {
                winners.add(player);
            }
        }

        if (!winners.isEmpty()) {
            double pointsPerWinner = 1.0 / winners.size(); 
            for (Player winner : winners) {
                winner.addScore(pointsPerWinner);
                winner.markScored(); 
                System.out.println(winner.getName() + " scored 21!");
                System.out.println(winner.getName() + " awarded " + pointsPerWinner + " point(s).");
            }
        } else {
            System.out.println("No points awarded this round.");
        }
    }
}
