package other.soundex;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UVa Problem 10260 - Soundex
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=14&page=show_problem&problem=1201
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader scan = new InputStreamReader(System.in);

        int v = scan.read();

        char c= '\0';
        String soundex = "";
        int codeLast = 0;
        int code = 0;
        while (v != -1) {
            codeLast = code;
            c = (char) v;
            switch (c) {
                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    code=1;
                    break;
                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    code=2; break;
                case 'D':
                case 'T':
                    code=3; break;
                case 'L':
                    code=4;
                    break;
                case 'M':
                case 'N':
                    code=5;
                    break;
                case 'R':
                    code=6;
                    break;
                case '\n':
                    code=-1;
                    break;
                default:
                    code=0;
                    // do nothing
            }
            if (code==-1) {
                System.out.println(soundex);
                soundex="";
            }
            if (code>0 && code!=codeLast) {
                soundex+=Integer.toString(code);
            }
            v = scan.read();
        }
    }
}
