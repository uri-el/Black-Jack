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

public class levelTwo {
    public static void run(List<Player> players) {

        for (Player player : players) {
            int maxScore = player.getMaxSuitScore();
            
            System.out.println(player.getName() + "'s maximum score from a single suit: " + maxScore);
        }
    }
}
