package i0.sealights;

public class Euler {
    private static final int div_1 = 3;
    private static final int div_2 = 5;
    public long sumMultiplesInRange(int min, int max) {
        long sum = 0;
         for (int i = min; i < max; i++) {
            if (i % div_1 == 0){
                sum += i;
            }
            else if (i % div_2 == 0){
                sum += i;
            }
        }
        return sum;
    }
    public long sumEvenFibonacciInRange(int first1, int first2, int max){
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
    public int largesPrimeFactor(long number){
        int max = -1;
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (isPrime(i) && number % i == 0){
                max = i;
            }
        }
        return max;
    }

    public boolean isPrime(long number) {
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}