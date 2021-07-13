package main.java.topcodingquestion.arraysandstrings;

import main.java.topcodingquestion.utilities.AssortedMethods;

import java.util.Arrays;

/**
 * Write a method to shuffle a deck of card.It must be a perfect shuffle
 * CTCI - 17.2
 */
public class Shuffle {

    public static int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) return cards;
        shuffleArrayRecursively(cards, i - 1);//Shuffle earlier part
        int k = AssortedMethods.randomIntInRange(0, i);//Pick random index to swap
        /*
        Swap element at k and i
         */
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;
        /* Return shuffled array */
        return cards;
    }

    public static void shuffleArrayIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = AssortedMethods.randomIntInRange(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }

    }

    public static void main(String[] args) {
        int[] cards = AssortedMethods.randomArray(52, 1, 52);
        System.out.println(Arrays.toString(cards));
        shuffleArrayIteratively(cards);
        System.out.println(Arrays.toString(cards));
    }
}
