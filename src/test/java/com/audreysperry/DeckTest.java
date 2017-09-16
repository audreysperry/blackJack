package com.audreysperry;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class DeckTest {
    @Test
    public void CreatingADeckCreates52Cards() throws Exception {
        Deck sut = new Deck();
        assertEquals(sut.getDeckSize(), 52);
    }

    @Test
    public void DrawCardReducesDeckSizeByOne() throws Exception {
        Deck sut = new Deck();
        sut.drawCard();
        assertEquals(sut.getDeckSize(), 51);

    }

    @Test
    public void DrawingRandomCardReducesDeckSizeByOne() throws Exception {
        Deck sut = new Deck();
        sut.drawRandomCard();
        assertEquals(sut.getDeckSize(), 51);
    }

    @Test
    public void DrawingTwoRandomCardsInARowReducedDeckSizeByTwo() throws Exception {
        Deck sut = new Deck();
        Card randomCard1 = sut.drawRandomCard();
        Card randomCard2 = sut.drawRandomCard();
        assertEquals(sut.getDeckSize(), 50);
    }
}
