package main.java.arraysstrings;

public class Divisibility {
    public void solution(int N) {
        // write your code in Java SE 8
        for (int i = 1; i <= N; i++) {
            boolean isDivisibleZBy2 = checkIfNumberIsDivisibleBy2(i);
            boolean isDivisibleZBy3 = checkIfNumberIsDivisibleBy3(i);
            boolean isDivisibleZBy5 = checkIfNumberIsDivisibleBy5(i);
            if (isDivisibleZBy2){
                if(isDivisibleZBy2&&isDivisibleZBy3){
                    System.out.println("CodilityTest");
                }
                else if(isDivisibleZBy2&&isDivisibleZBy5){
                    System.out.println("CodilityCoders");
                }
                else{
                    System.out.println("Codility");
                }

            }
            else if(isDivisibleZBy3){
                if(isDivisibleZBy3&&isDivisibleZBy5){
                    System.out.println("TestCoders");
                }else{
                    System.out.println("Test");
                }

            }
            else if(isDivisibleZBy5){

                    System.out.println("Coders");

            }
            else{
                System.out.println(i);
            }
        }

    }

    public boolean checkIfNumberIsDivisibleBy2(int N) {
        return N % 2 == 0;
    }

    public boolean checkIfNumberIsDivisibleBy3(int N) {
        return N % 3 == 0;
    }

    public boolean checkIfNumberIsDivisibleBy5(int N) {
        return N % 5 == 0;
    }

    public static void main(String[] args) {
        Divisibility divisibility = new Divisibility();
        divisibility.solution(24);
    }
}

