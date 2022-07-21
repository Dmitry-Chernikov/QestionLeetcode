/**
 * MinimumAmountOfTimeToFillCups
 * Минимальное количество времени для заполнения чашек
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-07-21, чт, 13:51
 */
public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        boolean flagStop = true;
        int bufMax = 0, bufMin = 0;
        int bufIndexMax = 0;
        int bufIndexMin = amount.length - 1;
        int countSecond = 0;

        while (flagStop){
            bufMax = 0;
            for (byte i = 0; i < amount.length; i++) {
                if (bufMax < amount[i] && amount[i] != 0) {
                    bufMax = amount[i];
                    bufIndexMax = i;
                }
            }
            bufMin = bufMax;
            for (byte i = 0; i < amount.length; i++) {
                if (bufIndexMax != i){
                    if (bufMin >= amount[i] && amount[i] != 0) {
                        bufMin = amount[i];
                        bufIndexMin = i;
                    }
                }
            }

            if (amount[bufIndexMax] != 0 && amount[bufIndexMin] != 0 && bufIndexMax != bufIndexMin ){
                amount[bufIndexMax]--;
                amount[bufIndexMin]--;
                countSecond++;
            }else {
                if (amount[bufIndexMax] != 0){
                    amount[bufIndexMax]--;
                    countSecond++;
                }else{
                    flagStop = false;
                }
            }
        }
        return countSecond;
    }
}
