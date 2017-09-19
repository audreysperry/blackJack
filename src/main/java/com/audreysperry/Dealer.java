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
    
    public void showDealerCards() {
        for (Card card: dealerCards) {
            System.out.println("Dealer card: " + card.getRankName() + " of " + card.getSuit());
        }
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

    public void hit(Deck deck) {
        while (dealerHandTotal < 17) {
            Card newCard = (deck.drawRandomCard());
            dealerCards.add(newCard);
            int cardValue = newCard.getFaceValue();
            increaseDealerHandTotal(cardValue);
            showDealerCards();
            System.out.println("Dealers hand value: " + getDealerHandTotal());
        }
    }

    public void checkWinner(Player player) {
        if (player.getPlayerHandTotal() > this.getDealerHandTotal()) {
            System.out.println("The player wins!");

        } else if (this.getDealerHandTotal() > 21){
            System.out.println("The dealer busted. You win.");
        } else if (player.getPlayerHandTotal() < this.getDealerHandTotal() && this.getDealerHandTotal() < 21) {
            System.out.println(" The dealer won.");
        } else {
            System.out.println("Game error");
        }
        System.out.println("Player hand total: " + player.getPlayerHandTotal());
        System.out.println("Dealer hand total: " + this.getDealerHandTotal());
    }
}
