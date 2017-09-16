package com.audreysperry;


import java.util.Scanner;

public class PlayBlackJack {
    public static void main(String[] args) {
        Deck blackJackDeck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Black Jack");
        Card userCard1 = blackJackDeck.drawRandomCard();
        Card userCard2 = blackJackDeck.drawRandomCard();
        int userCard1Value = userCard1.getFaceValue();
        int userCard2Value = userCard2.getFaceValue();

        player.addToPlayerCards(userCard1);
        player.increasePlayerHandTotal(userCard1Value);
        player.addToPlayerCards(userCard2);
        player.increasePlayerHandTotal(userCard2Value);

        Card dealerCard1 = blackJackDeck.drawRandomCard();
        int dealerCard1Value = dealerCard1.getFaceValue();
        Card dealerCard2 = blackJackDeck.drawRandomCard();
        int dealerCard2Value = dealerCard2.getFaceValue();

        dealer.addToDealerCards(dealerCard1);
        dealer.increaseDealerHandTotal(dealerCard1Value);
        dealer.addToDealerCards(dealerCard2);
        dealer.increaseDealerHandTotal(dealerCard2Value);

        System.out.println("Your first card is: " + userCard1.getRankName() + " of " + userCard1.getSuit());
        System.out.println("Your second card is: " + userCard2.getRankName() + " of " + userCard2.getSuit());
        System.out.println("Your hand totals: " + player.getPlayerHandTotal());
        System.out.println("The dealers card is: " + dealerCard1.getRankName() + " of " + dealerCard1.getSuit());

        System.out.println("Would you like to hit or stand?");
        String userHitOrStand = scanner.nextLine();

        if (userHitOrStand.equals("hit")) {

            Card newUserCard = blackJackDeck.drawRandomCard();
            player.addToPlayerCards(newUserCard);
            int newUserCardValue = newUserCard.getFaceValue();
            player.increasePlayerHandTotal(newUserCardValue);
            System.out.println("Your next card is: " + newUserCard.getRankName() + " of " + newUserCard.getSuit());
            System.out.println("Your hand now totals: " + player.getPlayerHandTotal());

        } else if (userHitOrStand.equals("stand")) {
            System.out.println("you're standing");
        }

    }
}
