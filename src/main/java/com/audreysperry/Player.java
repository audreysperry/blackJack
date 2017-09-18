package com.audreysperry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private int playerHandTotal;
    private ArrayList<Card> playerCards = new ArrayList<Card>();
    private int aceCount;

    public Player(Deck deck) {
        Card card1 = deck.drawRandomCard();
        Card card2 = deck.drawRandomCard();
        int card1value = card1.getFaceValue();
        int card2value = card2.getFaceValue();
        playerHandTotal = card1value + card2value;
        playerCards.add(card1);
        playerCards.add(card2);
    }
    public int getPlayerHandTotal() {
        return playerHandTotal;
    }

    public void setPlayerHandTotal(int playerHandTotal) {
        this.playerHandTotal = playerHandTotal;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public void addToPlayerCards(Card playerCard) {
        playerCards.add(playerCard);
    }

    public void increasePlayerHandTotal(int newCardValue) {
        playerHandTotal += newCardValue;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }



}
