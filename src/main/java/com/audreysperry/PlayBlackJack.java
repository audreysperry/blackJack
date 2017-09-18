package com.audreysperry;


import java.util.Scanner;

public class PlayBlackJack {
    public static void main(String[] args) {
        Deck blackJackDeck = new Deck();
        Player player = new Player(blackJackDeck);
        Dealer dealer = new Dealer(blackJackDeck);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Black Jack");

        for (int i = 0; i < player.getPlayerCards().size(); i++) {
            System.out.println("Card: "  + player.getPlayerCards().get(i).getRankName() + " of " + player.getPlayerCards().get(i).getSuit());

        }
        System.out.println("Your hand totals " + player.getPlayerHandTotal());
        System.out.println("The dealers visible card is: " + dealer.getDealerCards().get(0).getRankName() + " of " + dealer.getDealerCards().get(0).getSuit());

//    
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
