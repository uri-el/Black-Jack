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

public class Player {
    private final String name;
    private final List<Card> hand;
    private double totalScore;
    private double finalScore;
    private boolean scoredThisRound;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.totalScore = 0;
        this.finalScore = 0;
        this.scoredThisRound = false;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> newHand) {
        hand.clear();
        hand.addAll(newHand);
    }

    public int getMaxSuitScore() {
        int[] suitScores = new int[4];
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (Card card : hand) {
            for (int i = 0; i < suits.length; i++) {
                if (card.getSuit().equals(suits[i])) {
                    suitScores[i] += card.getValue();
                }
            }
        }
        int maxScore = 0;
        for (int score : suitScores) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public int calculateHandValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank().equals("A")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10; 
            aceCount--;
        }

        return total;
    }

    public void addScore(double score) {
        totalScore += score;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setFinalScore(double score) {
        finalScore = score;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public boolean hasScoredThisRound() {
        return scoredThisRound;
    }

    public void markScored() {
        this.scoredThisRound = true;
    }

    public void resetScoredStatus() {
        this.scoredThisRound = false;
    }

    @Override
    public String toString() {
        return name + " (Score: " + totalScore + ")";
    }
}
