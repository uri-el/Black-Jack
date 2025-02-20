/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.CW10356268;

/**
 *
 * @author satee
 */

public class Card {
    private final String suit;
    private final String rank;
    private int value;

    public Card(String suit, int rank) {
        if (suit.equals("Joker")) {
            this.suit = "Joker";
            this.rank = "Joker";
            this.value = 0; 
        } else {
            this.suit = suit;

            if (rank == 1) {
                this.rank = "A";
                this.value = 11; 
            } else if (rank >= 2 && rank <= 10) {
                this.rank = String.valueOf(rank);
                this.value = rank; 
            } else if (rank >= 11 && rank <= 13) {
                switch (rank) {
                    case 11:
                        this.rank = "J";
                        break;
                    case 12:
                        this.rank = "Q";
                        break;
                    case 13:
                        this.rank = "K";
                        break;
                    default:
                        this.rank = "";
                }
                this.value = 10; 
            } else {
                throw new IllegalArgumentException("Invalid rank: " + rank);
            }
        }
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return suit.equals("Joker") ? "Joker" : rank + " of " + suit;
    }
}
