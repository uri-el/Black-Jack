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
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        reset();
    }

    public void reset() {
        cards.clear();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 1; rank <= 13; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
        addJokers(2); 
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private void addJokers(int count) {
        for (int i = 0; i < count; i++) {
            cards.add(new Card("Joker", 0));
        }
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public List<Card> dealCards(int number) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Card card = dealCard();
            if (card != null) {
                hand.add(card);
            }
        }
        return hand;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }
}
