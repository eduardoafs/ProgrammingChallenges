package other.texQuotes;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UVa Problem 272 - Tex Quotes
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=4&page=show_problem&problem=208
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader scan = new InputStreamReader(System.in);

        boolean even = true;

        int v = scan.read();

        char c;
        while (v!=-1) {
            c= (char) v;
            if (c=='"') {
                System.out.print(even ? "``" : "''");
                even = !even;
            }
            else
                System.out.print(c);
            v = scan.read();
        }
    }
}
