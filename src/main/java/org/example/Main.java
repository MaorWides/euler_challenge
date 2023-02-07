package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(problem1(0, 1000)); //233168
        System.out.println(problem2(1, 2, 4000000)); //4613732
    }
    public static long problem1(int min, int max) {
        long sum = 0;
         for (int i = min; i < max; i++) {
            if (i % 3 == 0){
                sum += i;
            }
            else if (i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }
    public static long problem2(int first1, int first2, int max){
        long sum = 0;
        if (first1 % 2 == 0){
            sum += first1;
        }
        while(first2 <= max){
            if (first2 % 2 == 0){
                sum += first2;
            }
            first1 += first2;
            if (first1 > max){
                return sum;
            }
            if (first1 % 2 == 0){
                sum += first1;
            }
            first2 += first1;
        }
        return sum;
    }
}