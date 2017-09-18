package com.audreysperry;

import java.util.ArrayList;

public class Dealer {
    private int dealerHandTotal;
    private ArrayList<Card> dealerCards = new ArrayList<Card>();
    private int aceCount;


    public Dealer(Deck deck) {
        Card card1 = deck.drawRandomCard();
        Card card2= deck.drawRandomCard();
        int card1value = card1.getFaceValue();
        int card2value = card2.getFaceValue();
        dealerHandTotal = card1value + card2value;
        dealerCards.add(card1);
        dealerCards.add(card2);

        for (int i = 0; i < dealerCards.size(); i++) {
            if (dealerCards.get(i).getFaceValue() == 11) {
                aceCount++;
            }

        }

    }
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
