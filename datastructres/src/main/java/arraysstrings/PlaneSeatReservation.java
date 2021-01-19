package main.java.arraysstrings;

import java.util.*;

/*
 *
 * 1A 3C 2B 40G 5A
 *
 */
public class PlaneSeatReservation {

    public int getAvailableSeats(int n, String s) {
        String str[] = s.split(" ");
        List<String> occupied = new ArrayList<>();
        int available = 0;

        occupied = Arrays.asList(str);

        for(int i = 1; i<= n ; i++) {

            if(!occupied.contains(i+"A") && !occupied.contains(i+"B") && !occupied.contains(i+"C")) {
                available++;
            }
            if(!(occupied.contains(i+"D") && occupied.contains(i+"G"))  && !(occupied.contains(i+"E") || occupied.contains(i+"F"))) {
                available++;
            }
            if(!occupied.contains(i+"H") && !occupied.contains(i+"J") && !occupied.contains(i+"K")) {
                available++;
            }
        }
        return available;
    }

    public int solution(int N, String S) {
        if(S.length()==0 || S == ""){
            return N*3;
        }
        Map<String, Set<String>> reserveSeats = new HashMap<>();
        String[] str = S.split(" ");
        int maximumAvailability = 0;


        for(int i =0; i<str.length; i++){
            String row = str[i].substring(0,1);
            String column = str[i].substring(1);
            if(reserveSeats.containsKey(row)){
                reserveSeats.get(row).add(column);
            }
            else{
                reserveSeats.put(row,new HashSet<String>());
                reserveSeats.get(row).add(column);
            }
        }
        for(int i =1; i<=N; i++){
            if(reserveSeats.containsKey(String.valueOf(i))){
                Set<String> reservedSeat = reserveSeats.get(String.valueOf(i));
                if(!reservedSeat.contains("A") && !reservedSeat.contains("B") && !reservedSeat.contains("C")){
                    maximumAvailability++;
                }
                if(!(reservedSeat.contains("D") && reservedSeat.contains("G")) && !(reservedSeat.contains("E")
                || reservedSeat.contains("F"))){
                    maximumAvailability++;
                }
                if(!reservedSeat.contains("H") && !reservedSeat.contains("J") && !reservedSeat.contains("K")){
                    maximumAvailability++;
                }
            }
            else {
                maximumAvailability +=3;
            }
        }
        return maximumAvailability;

    }

    public static void main(String[] args) {
        int N=99;
        String S = "1A";
        PlaneSeatReservation planeSeatReservation = new PlaneSeatReservation();
        System.out.println(planeSeatReservation.solution(N,S));
    }
}