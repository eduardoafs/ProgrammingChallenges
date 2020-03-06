package other.decoder;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UVa Problem 458 - The Decoder
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=399
 * FIXME wrong answer
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader scan = new InputStreamReader(System.in);

        int v = scan.read();

        char c;
        while (v!=-1) {
            c = (char) ((v>=39 && v<=131) ? (v-7) : v);
            System.out.print(c);
            v = scan.read();
        }
    }
}
