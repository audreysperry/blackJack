package com.audreysperry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private int playerHandTotal;
    private ArrayList<Card> playerCards = new ArrayList<Card>();
    private int aceCount;
    private boolean hasBlackJack;
    private double cashOnHand = 100;

    public Player(Deck deck) {
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

    public void reduceCash() {
        cashOnHand = cashOnHand - 10;
    }

    public double getCashOnHand() {
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

    public boolean playerHasBlackJack() {
        return hasBlackJack;
    }

    public void hit(Deck deck) {
        Card newCard = deck.drawRandomCard();
        playerCards.add(newCard);
        int cardValue = newCard.getFaceValue();
        System.out.println(cardValue);
        if (cardValue == 11) {
            aceCount++;
        }
        increasePlayerHandTotal(cardValue);
        if (this.getPlayerHandTotal() > 21 && aceCount > 0) {
            this.playerHandTotal -= 10;
            aceCount--;
            this.showPlayerCards();
            System.out.println("Your hand totals " + this.getPlayerHandTotal());
            System.out.println("Would you like to hit or stand?");
        } else if (this.getPlayerHandTotal() > 21) {
            this.showPlayerCards();
            System.out.println("Your hand totaled " + this.getPlayerHandTotal());
            System.out.println("Sorry you lose");

        } else if (this.getPlayerHandTotal() < 21) {
            this.showPlayerCards();
            System.out.println("Your hand totals " + this.getPlayerHandTotal());
            System.out.println("Would you like to hit or stand?");
        } else if (this.getPlayerHandTotal() == 21) {
            System.out.println("You win! ");
            this.showPlayerCards();
            System.out.println("Your hand totals: " + this.getPlayerHandTotal());
        } else {
            System.out.println("Game error");
        }
    }

    public boolean checkBust() {
        if(playerHandTotal > 21) {
            return true;
        } else {
            return false;
        }
    }
}
