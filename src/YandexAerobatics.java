import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YandexAerobatics {
    public void getInfoAerobatics() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Discipline> disciplines = new ArrayList<>();

        int countDisc = Integer.parseInt(br.readLine());
        for (int i = 0; i < countDisc; i++) {
            String[] str = br.readLine().split(",");
            disciplines.add(new Discipline(str[0], Integer.parseInt(str[1])));
        }

        int countParty = Integer.parseInt(br.readLine());
        String nameParty = null;
        for (int i = 0; i < countParty; i++) {
            String[] str = br.readLine().split(",");
            nameParty = str[0];
            String nameDisc = str[1];//Имя дисциплины
            int methodCount = Integer.parseInt(str[2]);//Количество приёмов
            int fineCount = Integer.parseInt(str[3]);//Количество штрафов

            for (Discipline discipline : disciplines) {
                if (discipline.nameDisc.equals(nameDisc)) {//Совподение название дисциплины
                    if (discipline.getSizeParty() < discipline.maxNumParty) {//Проверка на максимальное число участников
                        discipline.addParty(nameParty, methodCount, fineCount);
                    } else {
                        Party partyBuf = null;
                        int bufMaxMet = methodCount;
                        int bufMinFine = fineCount;
                        for (Party party : discipline.parties) {
                            if (bufMaxMet > party.methodCount) {
                                bufMaxMet = party.methodCount;
                                partyBuf = party;
                            }
                            if (bufMaxMet == party.methodCount && bufMinFine < party.fineCount) {
                                bufMinFine = party.fineCount;
                                partyBuf = party;
                            }
                        }
                        if (partyBuf != null) {
                            discipline.addParty(partyBuf, nameParty, methodCount, fineCount);
                        }
                    }
                }
            }
        }

        //disciplines.stream().flatMap(discipline -> discipline.parties.stream()).sorted((o1, o2) -> o1.nameParty.compareTo(o2.nameParty)).forEach(s -> System.out.println(s.nameParty));
        disciplines.stream().flatMap(discipline -> discipline.parties.stream().map(party -> party.nameParty)).sorted().forEach(s -> System.out.println(s));
/*        ArrayList<String> outStr = new ArrayList<>();
        for (Discipline discipline: disciplines) {
            outStr.addAll(discipline.parties.stream().map(party -> party.nameParty).toList()) ;
        }
        Collections.sort(outStr);
        outStr.forEach(s -> System.out.println(s));*/
    }
}

class Discipline {
    String nameDisc; //Имя дисциплины
    int maxNumParty; //Максимальное число участников
    ArrayList<Party> parties = new ArrayList<>(); //Массив участников

    Discipline(String nameDisc, int maxNumParty) {
        this.nameDisc = nameDisc;
        this.maxNumParty = maxNumParty;
    }

    public void addParty(String nameParty, int methodCount, int fineCount) {
        parties.add(new Party(nameParty, methodCount, fineCount));
    }

    public void addParty(Party replaceParty, String nameParty, int methodCount, int fineCount) {
        parties.set(parties.indexOf(replaceParty), new Party(nameParty, methodCount, fineCount));
    }

    public int getSizeParty() {
        return parties.size();
    }
}

class Party {
    String nameParty; //Имя участника
    int methodCount; //Количество приёмов
    int fineCount; //Количество штрафов

    Party(String nameParty, int methodCount, int fineCount) {
        this.nameParty = nameParty;
        this.methodCount = methodCount;
        this.fineCount = fineCount;
    }
}
