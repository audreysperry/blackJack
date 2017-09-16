package com.audreysperry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private int playerHandTotal;
    private ArrayList<Card> playerCards = new ArrayList<Card>();

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
