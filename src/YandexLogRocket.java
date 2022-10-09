import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class YandexLogRocket {
    private final static String a = "A";
    private final static String b = "B";
    private final static String s = "S";
    private final static String c = "C";

    public void sortLog() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeRowLog = Integer.parseInt(br.readLine());

        HashMap<Integer, ArrayList<Rocket>> rockets = new HashMap<>();

        StringBuilder rez = new StringBuilder();

        for (int i = 0; i < sizeRowLog; i++) {
            String[] infoCandidate = br.readLine().split(" ");

            if (rockets.get(Integer.parseInt(infoCandidate[3])) == null) {
                rockets.put(Integer.parseInt(infoCandidate[3]), new ArrayList<Rocket>());
            }
            rockets.get(Integer.parseInt(infoCandidate[3])).add(new Rocket(Integer.parseInt(infoCandidate[0]),
                                                                            Integer.parseInt(infoCandidate[1]),
                                                                            Integer.parseInt(infoCandidate[2]),
                                                                            infoCandidate[4]));

        }

        for (Map.Entry<Integer, ArrayList<Rocket>> e : rockets.entrySet()) {
           e.setValue(e.getValue().stream().
                                           sorted((o1, o2) -> o1.day.compareTo(o2.day)).
                                                collect(Collectors.toCollection(ArrayList::new)) );

        }

        for (Map.Entry<Integer, ArrayList<Rocket>> e : rockets.entrySet()) {
            Integer minStart = 0;
            Integer minStop = 0;
            Integer sumMin = 0;
            for (Rocket rocket:e.getValue()) {
                if (rocket.status().equals(a) ){
                     minStart = (rocket.day * 1440) + (rocket.hour * 60) + rocket.minute;
                }

                if (rocket.status().equals(s) || rocket.status().equals(c)){
                    minStop = (rocket.day * 1440) + (rocket.hour * 60) + rocket.minute;
                }
                if (minStart != 0 && minStop != 0){
                    sumMin = sumMin + (minStop - minStart);
                    minStart = 0;
                    minStop = 0;
                }
            }
            rez.append(sumMin).append(" ");
        }
        System.out.println(rez);
    }
}

class Rocket {
    Integer day;
    Integer hour;
    Integer minute;
    String status;
    Rocket(Integer day, Integer hour, Integer minute, String status){
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.status = status;
    }

    public String status() {
        return status;
    }
}
