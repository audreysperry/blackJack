package com.audreysperry;

public class Card {
    private int rank;
    private String suit;


    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getFaceValue() {

            if (rank == 1) {
                return 11;
            } else if (rank == 11 || rank == 12 || rank == 13) {
                return 10;
            } else {
                return rank;
            }
        }

    public String getRankName() {
        if (rank == 1) {
            return "Ace";
        } else if (rank == 11) {
            return "Jack";
        } else if (rank == 12) {
            return "Queen";
        } else if (rank == 13) {
            return "King";
        } else {
            return String.valueOf(rank);
        }
    }


    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

}
