package main.java.arraysstrings;

/*
 * Click `Run` to execute the snippet below!
 */

import java.util.ArrayList;
import java.util.List;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


class UserCreditMatch {

    public static void main(String[] args) {
        UserCreditMatch solution = new UserCreditMatch();
        int[] users = new int[]{1, 2, 3, 4, 5};
        int[] cards = new int[]{1, 2, 3, 4, 5};
        List<int[]> result = solution.findUserCardMatch(users, cards);
        for (int[] entry : result) {
            System.out.println(entry[0] + "," + entry[1]);
        }
    }

    private int getMatch(int userId, int cardId) {
        if (userId == cardId) {
            return 0;
        } else if (userId < cardId) {
            return -1;
        } else {
            return 1;
        }


    }

    public List<int[]> findUserCardMatch(int[] users, int[] cards) {
        List<int[]> result = new ArrayList<>();
        int n = users.length;
        int m = cards.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int match = getMatch(users[i], cards[j]);
                if (match == 0) {
                    result.add(new int[]{users[i], cards[j]});
                    continue;
                }
            }
        }

        return result;

    }
}


/*
Your previous Plain Text content is preserved below:

There are n users with credit profiles represented by array [U1, U2, ...... Un] and n cards represented by array [C1, C2, C3 ,... Cn]. Given that there is exactly 1 matching card to each user and that the user is either overqualified or under-qualified for the rest.
If we have a function fn which returns -1 for underqualified, 0 for exact match and 1 for overqualified when called for any user and card combination given to you, write a function which returns an array of tuples of matching user and card.

U1 -> [1,0,0,0]
fn(U, C) -> 0
         -> 1 user is overqualified

users = [1,2,3,4,5]
cards = [1,2,3,4,5]


 */