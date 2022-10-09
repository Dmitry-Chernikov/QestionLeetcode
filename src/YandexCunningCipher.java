import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;


public class YandexCunningCipher {
    public void getCipher() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countCandidate = Integer.parseInt(br.readLine());
        StringBuilder rez = new StringBuilder();

        for (int i = 0; i < countCandidate; i++) {
            String[] infoCandidate = br.readLine().split(",");

            Integer sumDate = 0;
            for (int j = 0; j < infoCandidate[3].length(); j++) {
                sumDate = sumDate + Integer.parseInt(String.valueOf(infoCandidate[3].charAt(j)));
            }

            Integer sumMonth = 0;
            for (int j = 0; j <  infoCandidate[4].length(); j++) {
                sumMonth = sumMonth + Integer.parseInt(String.valueOf(infoCandidate[4].charAt(j)));
            }

            Integer sumDateMonth = sumDate + sumMonth;

            Integer numCharAlphabet = (int)infoCandidate[0].charAt(0) - 64;


            String pars = new StringBuilder(infoCandidate[0]).append(infoCandidate[1]).append(infoCandidate[2]).reverse().toString();
            pars = pars.replaceAll("(.)(?=.*\\1)", "");
            pars = new StringBuilder(pars).reverse().toString();
            //String pars = new StringBuilder(infoCandidate[0]).append(infoCandidate[1]).append(infoCandidate[2]).toString();
            //pars = pars.replaceAll("(.)(?=(.*))(?<=(?=\\1.*?\\1\\2$).+)", "");

            Integer sizeSymbol = pars.length();

            Integer cipher = sizeSymbol + (sumDateMonth * 64) + (numCharAlphabet * 256);

            String convert = Integer.toHexString(cipher);

            rez.append(convert.substring(convert.length() - 3).toUpperCase()).append(" ");
        }
        System.out.println(rez);
    }
}
