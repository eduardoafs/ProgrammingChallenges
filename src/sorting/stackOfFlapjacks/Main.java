package sorting.stackOfFlapjacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * UVa Problem 120 - Stack of Flapjacks
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=56
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        ArrayList<Integer> arr = new ArrayList<Integer>(30);
        while (scan.hasNextLine()) {
            arr.clear();
            line = scan.nextLine();
            String[] values = line.split("\\s+");
            for (String value : values) {
                arr.add(Integer.parseInt(value));
            }
            // output original stack
            System.out.println(line);

            // variation of selection sort
            for (int i=arr.size()-1; i>0;i--) {
                // find the greatest element
                Integer greaterIndex = i;

                for (int a=0; a<i;a++) {
                    if (arr.get(a)>arr.get(greaterIndex)) {
                        greaterIndex = a;
                    }
                }
                // now have to put the element in the last position
                if (greaterIndex!=i) {
                    // if the greater element is in first position, will flip in i position
                    if (greaterIndex!=0) {
                        // needs to perform 2 flips, one to put the element in first position, other to put in right position
                        flip(arr,greaterIndex); // first flip is to put element in position 0
                    }
                    flip(arr, i); // flip to i position
                }
            }
            System.out.println("0");
        }
    }

    public static void flip(List list, int pos) {
        // prinst the flip
        System.out.print(list.size()-pos+ " ");
        for (int i=0, j=pos; i<j ;i++,j--) {
            Collections.swap(list, i, j);
        }
    }
}
