package com.audreysperry;

import java.util.ArrayList;

public class Dealer {
    private int dealerHandTotal;
    private ArrayList<Card> dealerCards = new ArrayList<Card>();

    public int getDealerHandTotal() {
        return dealerHandTotal;
    }

    public void setDealerHandTotal(int dealerHandTotal) {
        this.dealerHandTotal = dealerHandTotal;
    }

    public void increaseDealerHandTotal(int newCardValue) {
        dealerHandTotal += newCardValue;
    }

    public ArrayList<Card> getDealerCards() {
        return dealerCards;
    }

    public void addToDealerCards(Card drawnCard) {
        dealerCards.add(drawnCard);
    }
}
