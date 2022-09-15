import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class YadexContest {
    public void alisaCod() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] w = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rez = 0;
        //System.out.println(n);
        //System.out.println(Arrays.toString(w));
        //int[] arr = IntStream.rangeClosed(97, 122).toArray();
        //System.out.println(Arrays.toString(arr));
        HashMap<Integer, String> tableButeChar = new HashMap<>(26);
        for (int i = 0; i < 27; i++) {
            if (i == 26){
                tableButeChar.put((int) Math.pow(2,i), Character.toString(32));
            }else{
                tableButeChar.put((int) Math.pow(2,i), Character.toString(97 + i));
            }

        }

        //tableButeChar.forEach((key, value) -> System.out.println(key + ":" + value));

        for (int i = 0; i < n; i++) {
            //System.out.println(w[i] - rez);
            System.out.print(tableButeChar.get(Math.abs(w[i] - rez)));
            rez = w[i];
        }

    }

    public void  hexagon () throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] w = new String[n[1]];
        int i = 0 ;
        while (br.ready()) {
            w[i] = br.readLine();
        }
        Arrays.stream(n).forEach(System.out::println);
        Arrays.stream(w).forEach(System.out::println);

    }
}
