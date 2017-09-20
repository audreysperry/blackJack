package com.audreysperry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private int playerHandTotal;
    private ArrayList<Card> playerCards = new ArrayList<Card>();
    private int aceCount;
    private boolean hasBlackJack;
    private boolean playerWon;
    private int cashOnHand = 100;


    public void newGame(Deck deck) {
        playerCards.clear();
        Card card1 = deck.drawRandomCard();
        Card card2 = deck.drawRandomCard();
        int card1value = card1.getFaceValue();
        int card2value = card2.getFaceValue();
        if (card1value == 11) {
            aceCount++;
        }
        if (card2value == 11) {
            aceCount++;
        }
        playerHandTotal = card1value + card2value;
        playerCards.add(card1);
        playerCards.add(card2);

        if(aceCount > 0 && playerHandTotal > 21) {
            playerHandTotal -= 10;
            aceCount--;
        }

        if (playerHandTotal == 21) {
            hasBlackJack = true;
        }
    }

    public void increaseCash() {
        cashOnHand = cashOnHand + 15;
    }
    public void reduceCash() {
        cashOnHand = cashOnHand - 10;
    }

    public int getCashOnHand() {
        return cashOnHand;
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

    public void showPlayerCards() {
        for (int i = 0; i < playerCards.size(); i++) {
            System.out.println("Card: "  + playerCards.get(i).getRankName() + " of " + playerCards.get(i).getSuit());
        }
    }

    public int getAceCount() {
        return aceCount;
    }

    public boolean checkIfPlayerHasBlackJack(){
        if (playerHandTotal ==21) {
            return true;
        }
        return false;
    }
    public boolean playerHasBlackJack() {
        return hasBlackJack;
    }

    public void hit(Deck deck) {
        Card newCard = deck.drawRandomCard();
        playerCards.add(newCard);
        int cardValue = newCard.getFaceValue();
        if (cardValue == 11) {
            aceCount++;
        }
        increasePlayerHandTotal(cardValue);
        if (this.getPlayerHandTotal() > 21 && aceCount > 0) {
            this.playerHandTotal -= 10;
            aceCount--;

        }
    }

    public boolean checkBust() {
        if(playerHandTotal > 21) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getplayerWon() {
        return playerWon;
    }

    public void win() {
        System.out.println("You hit blackjack!");
        System.out.println("Your hand totaled " + playerHandTotal);
        cashOnHand = cashOnHand + 15; 

    }

    public void lose() {
        System.out.println("Sorry you busted.");
        System.out.println("Your hand totaled " + playerHandTotal);
    }
}
