package com.audreysperry;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private int[] rank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int deckSize = 0;
    
    
    public Deck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                    cards.add(new Card(suits[i], rank[j]));
                    deckSize++;

            }
            
        }
    }

    public int getDeckSize() {
        return deckSize;
    }

    public Card drawCard() {
        deckSize--;
       return cards.remove(0);
    }

    public Card drawRandomCard() {
        deckSize--;
        Random index = new Random();
        int n = index.nextInt(cards.size());
        Card removedCard = cards.remove(n);
        return removedCard;
    }






}
