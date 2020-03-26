package sorting.jollyJumpers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * UVa Problem 10038 - Jolly Jumpers
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=979
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n, previous, current, value;
        boolean isJolly;
        Integer[] numbers;
        while (s.hasNext()) {
            n = s.nextInt();
            numbers = new Integer[n-1];

            // Initialize control variables
            isJolly = true;

            previous = s.nextInt();
            for (int i=0; i<n-1;i++) {
                current = s.nextInt();
                value = Math.abs(current-previous);
                previous=current;
                numbers[i] = value;
            }

            // check if is jolly
            Arrays.sort(numbers);
            if (numbers.length>1) {
                for (int i = 0; i < n-1; i++)
                    if (numbers[i] != i+1) {
                        isJolly = false;
                        break;
                    }
            }

            System.out.println(isJolly?"Jolly": "Not jolly");
        }
    }
}
