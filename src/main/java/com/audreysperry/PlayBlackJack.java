package com.audreysperry;


import java.util.Scanner;

public class PlayBlackJack {

    public static void main(String[] args) {
        Deck blackJackDeck = new Deck();
        Player player = new Player(blackJackDeck);
        Dealer dealer = new Dealer(blackJackDeck);
        Scanner scanner = new Scanner(System.in);

        while (player.getCashOnHand() > 0) {
            System.out.println("Let's play Black Jack");
            player.reduceCash();
            player.showPlayerCards();

            System.out.println("Your hand totals " + player.getPlayerHandTotal());

            if (player.playerHasBlackJack() == true) {
                System.out.println("You win! ");
            } else {
                System.out.println("The dealers visible card is: " + dealer.getDealerCards().get(0).getRankName() + " of " + dealer.getDealerCards().get(0).getSuit());
                System.out.println("Would you like to hit or stand?");
                System.out.println("your ace count is" + player.getAceCount());
            }

            String userHitOrStand = scanner.nextLine();

            while (userHitOrStand.equals("hit")) {

                player.hit(blackJackDeck);
                if (player.checkBust()) {
                    break;
                }
                userHitOrStand = scanner.nextLine();

            }

            if (userHitOrStand.equals("stand")) {
                dealer.hit(blackJackDeck);
            }

            dealer.checkWinner(player);
            break;
        }

    }

}
