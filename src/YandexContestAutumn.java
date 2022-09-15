import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class YandexContestAutumn {
    private final static char plagiarism = 'P';
    private final static char suspicious = 'S';
    private final static char innocent = 'I';

    public void alisaPlagiarism() throws IOException {
        long start = 0;
        long stop = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        start = System.nanoTime();
        String match = "";
        String rez = "";
        Boolean included = true;
        int size = a.length();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b.charAt(i) == a.charAt(i)) {
                    rez = rez + plagiarism;
                    break;
                }
                if (b.charAt(i) == a.charAt(j) && i != j && a.charAt(j) != b.charAt(j) && a.charAt(i) != b.charAt(i) && match.indexOf(j) == -1 ) {
                    rez = rez + suspicious;
                    match = match + String.valueOf(j);
                    included = false;
                    break;
                }

            }
            if (included) {
                rez = rez + innocent;
            } else {
                included = true;
            }
        }

        System.out.println(rez);
        stop = System.nanoTime();
        System.out.println("IndexOf: " + (stop-start));
    }

    public void alisaPlagiarismArrChar() throws IOException {
        long start = 0;
        long stop = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        start = System.nanoTime();
        //HashMap<Integer, Character> tableMatch = new HashMap<>();
        StringBuilder match = new StringBuilder();
        //String match = "";
        char[] rez = new char[a.length];
        Boolean included = true;
        int size = a.length;

        for (int i = 0; i < size; i++) {
            if (b[i] == a[i]) {
                rez[i] = plagiarism;
                continue;
            }
            for (int j = 0; j < size; j++) {
                //if (b[i] == a[j] && i != j && a[j] != b[j] && a[i] != b[i] && !tableMatch.containsKey(j) ) {
                if (b[i] == a[j] && i != j && a[j] != b[j] && a[i] != b[i] && match.indexOf(String.valueOf(j)) == -1 ) {
                //if (b[i] == a[j] && i != j && a[j] != b[j] && a[i] != b[i] && match.indexOf(j) == -1 ) {
                    rez[i] = suspicious;
                    //tableMatch.put(j, a[j]);
                    match.append(j);
                    //match = match + j;
                    included = false;
                    break;
                }
            }
            if (included) {
                rez[i] = innocent;
            } else {
                included = true;
            }
        }

        System.out.println(rez);
        stop = System.nanoTime();
        System.out.println("IndexOf: " + (double) (stop - start) /1000000);
    }
}
