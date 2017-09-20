package com.audreysperry;


import java.util.Scanner;

public class PlayBlackJack {

    public static void main(String[] args) {
        Deck blackJackDeck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);
        int playAgain = 1;

        while (player.getCashOnHand() > 0 && playAgain == 1) {
            player.newGame(blackJackDeck);
            dealer.newGame(blackJackDeck);
            System.out.println("Let's play Black Jack");
            player.reduceCash();
            System.out.println("Your cash on hand: $" + player.getCashOnHand());
            player.showPlayerCards();

            System.out.println("Your hand totals " + player.getPlayerHandTotal());

            if (player.checkIfPlayerHasBlackJack() == true) {
                System.out.println("You win! ");
                player.increaseCash();
            } else {
                System.out.println("The dealers visible card is: " + dealer.getDealerCards().get(0).getRankName() + " of " + dealer.getDealerCards().get(0).getSuit());
                System.out.println("Would you like to hit or stand?");
            }
            Scanner scanner2 = new Scanner(System.in);
            String userHitOrStand = scanner2.nextLine();

            while (userHitOrStand.equals("hit")) {

                player.hit(blackJackDeck);
                if (player.checkBust()) {
                    player.lose();
                    break;
                }
                if (player.checkIfPlayerHasBlackJack()){
                    player.win();
                    break;
                }
                player.showPlayerCards();
                System.out.println("Your hand totals " + player.getPlayerHandTotal());
                System.out.println("Would you like to hit or stand?");
                Scanner scanner3 = new Scanner(System.in);
                userHitOrStand = scanner3.nextLine();

            }
            if (userHitOrStand.equals("stand")) {
                dealer.hit(blackJackDeck);
                dealer.checkWinner(player);
            }

            System.out.println("Would you like to play again? (1) Yes, (2), No.");
            System.out.println("Your cash remaining is $" + player.getCashOnHand());
            playAgain = scanner.nextInt();
        }


    }

}
