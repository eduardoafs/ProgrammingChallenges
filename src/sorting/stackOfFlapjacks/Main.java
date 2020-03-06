package sorting.stackOfFlapjacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

                for (int a=i; a<arr.size();a++) {
                    if (arr.get(a)>arr.get(greaterIndex)) {
                        greaterIndex = a;
                    }
                }
                // now have to put the element in the last position
                if (greaterIndex!=i) {
                    System.out.print(i+1);
                    //Collections.swap(arr, i, greaterIndex);
                    flip(arr,greaterIndex);
                }
            }
        }
    }

    public static void flip(List list, int pos) {
        for (int i=0, j=pos; i<j ;i++,j--) {
            Collections.swap(list, i, j);
        }
    }
}
