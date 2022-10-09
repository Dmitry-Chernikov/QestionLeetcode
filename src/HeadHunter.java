import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HeadHunter {

    public void getSumGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstString = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxSizeResume = Math.max(firstString[0], firstString[1]);

        List<Integer> stackA = new ArrayList<>();
        List<Integer> stackB = new ArrayList<>();

        for (int i = 0; i < maxSizeResume; i++) {
            String[] bufResume = br.readLine().split(" ");
            if (i < firstString[0]) {
                stackA.add(Integer.parseInt(bufResume[0]));
            }
            if (i < firstString[1]) {
                stackB.add(Integer.parseInt(bufResume[1]));
            }
        }
        stackA.sort(Integer::compareTo);
        stackB.sort(Integer::compareTo);

        int bufSumSalary = 0;
        int countResume = 0;

        for (int i = 0; i < maxSizeResume; i++) {
            if (stackA.get(i) <= stackB.get(i)) {
                if (i < firstString[0]) {
                    bufSumSalary = bufSumSalary + stackA.get(i);
                    if (bufSumSalary <= firstString[2]) {
                        if (bufSumSalary == firstString[2]) break;
                        countResume++;
                    }
                }

                if (i < firstString[1]) {
                    bufSumSalary = bufSumSalary + stackB.get(i);
                    if (bufSumSalary <= firstString[2]) {
                        countResume++;
                    }
                }
            }

            if (stackB.get(i) < stackA.get(i)) {
                if (i < firstString[1]) {
                    bufSumSalary = bufSumSalary + stackB.get(i);
                    if (bufSumSalary <= firstString[2]) {
                        if (bufSumSalary == firstString[2]) break;
                        countResume++;
                    }
                }

                if (i < firstString[0]) {
                    bufSumSalary = bufSumSalary + stackA.get(i);
                    if (bufSumSalary <= firstString[2]) {
                        countResume++;
                    }
                }
            }

            if (bufSumSalary >= firstString[2]) break;
        }

        System.out.println(countResume);

    }

    public void getSquareRegion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstString = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Integer[][] field = new Integer[firstString[1]][firstString[0]];
        Queue<Plot> plotsQueue = new LinkedList<>();
        List<Region> regions = new ArrayList<>();
        //field //Поле
        //plot //Учаток;
        //Region //Регион

        for (int i = 0; i < firstString[1]; i++) {
            int[] bufField = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j = 0; j < firstString[0]; j++) {
                field[i][j] = bufField[j];
            }
        }

        for (int row = 0; row < firstString[1]; row++) {
            for (int col = 0; col < firstString[0]; col++) {
                if (field[row][col] == 1) {
                    plotsQueue.offer(new Plot(row, col));
                    regions.add(new Region(row, col, 1));

                    while (!plotsQueue.isEmpty()) {
                        int sizeQueue = plotsQueue.size();
                        for (int i = 0; i < sizeQueue; i++) {
                            assert plotsQueue.peek() != null;
                            Integer r = plotsQueue.peek().row;
                            Integer c = plotsQueue.peek().col;
                            field[r][c] = 0;

                            //Определение координат региона
                            if (c < regions.get(regions.size() - 1).startCol) {
                                regions.get(regions.size() - 1).startCol = c;
                            }

                            if (c > regions.get(regions.size() - 1).endCol) {
                                regions.get(regions.size() - 1).endCol = c;
                            }

                            if (r > regions.get(regions.size() - 1).endRow) {
                                regions.get(regions.size() - 1).endRow = r;
                            }

                            //Поиск участка
                            if (r != firstString[1] - 1) { // если не последняя строка
                                if (field[r + 1][c] == 1) { // смотрим нижнее значение
                                    plotsQueue.offer(new Plot(r + 1, c));
                                    regions.get(regions.size() - 1).fertilePlot++;
                                    field[r + 1][c] = 0;
                                }
                            }

                            if (r != 0) { // если строка не первая
                                if (field[r - 1][c] == 1) { // смотрим верхнее значение
                                    plotsQueue.offer(new Plot(r - 1, c));
                                    regions.get(regions.size() - 1).fertilePlot++;
                                    field[r - 1][c] = 0;
                                }
                            }


                            if (c != 0) { //если не первая колонока
                                if (r != 0) { // если строка не первая
                                    if (field[r - 1][c - 1] == 1) { // смотрим слева верхнее значение
                                        plotsQueue.offer(new Plot(r - 1, c - 1));
                                        regions.get(regions.size() - 1).fertilePlot++;
                                        field[r - 1][c - 1] = 0;
                                    }
                                }

                                if (field[r][c - 1] == 1) { // смотрим слева значение
                                    plotsQueue.offer(new Plot(r, c - 1));
                                    regions.get(regions.size() - 1).fertilePlot++;
                                    field[r][c - 1] = 0;
                                }

                                if (r != firstString[1] - 1) { // если не последняя строка
                                    if (field[r + 1][c - 1] == 1) { // смотрим слева низ значение
                                        plotsQueue.offer(new Plot(r + 1, c - 1));
                                        regions.get(regions.size() - 1).fertilePlot++;
                                        field[r + 1][c - 1] = 0;
                                    }
                                }
                            }

                            if (c != firstString[0] - 1) { // если не последняя колонка
                                if (r != 0) { // если строка не первая
                                    if (field[r - 1][c + 1] == 1) { // смотрим слева верхнее значение
                                        plotsQueue.offer(new Plot(r - 1, c + 1));
                                        regions.get(regions.size() - 1).fertilePlot++;
                                        field[r - 1][c + 1] = 0;
                                    }
                                }

                                if (field[r][c + 1] == 1) { // смотрим справа значение
                                    plotsQueue.offer(new Plot(r, c + 1));
                                    regions.get(regions.size() - 1).fertilePlot++;
                                    field[r][c + 1] = 0;
                                }

                                if (r != firstString[1] - 1) { // если не последня строка
                                    if (field[r + 1][c + 1] == 1) { // смотрим справа низ значение
                                        plotsQueue.offer(new Plot(r + 1, c + 1));
                                        regions.get(regions.size() - 1).fertilePlot++;
                                        field[r + 1][c + 1] = 0;
                                    }
                                }
                            }

                            plotsQueue.poll();
                        }
                    }
                    regions.get(regions.size() - 1).initBenefitPurchase();
                }
            }
        }

        if (regions.isEmpty()){
            System.out.println(0);
        }else {
            Float maxEffReg = regions.stream().map(reg -> reg.effectRegion).max(Comparator.naturalOrder()).get(); //максимальная эффективность
            long countEffReg = regions.stream().filter(region -> region.effectRegion.equals(maxEffReg)).count(); //подсчёт одинаковых по количеству плодородной земли

            Integer maxSpace =  regions.stream().map(reg -> reg.space).max(Comparator.naturalOrder()).get(); //максимальная площадь

            //Integer maxFertilePlot = regions.stream().map(reg -> reg.fertilePlot).max(Comparator.naturalOrder()).get(); //максимальное количество плодородной земли
            //long countFertilePlot = regions.stream().filter(region -> region.fertilePlot.equals(maxFertilePlot)).count(); //подсчёт одинаковых по количеству плодородной земли

            if (countEffReg > 1){
                regions.stream().filter(region -> region.effectRegion.equals(maxEffReg))
                                .filter(region -> region.space == maxSpace)
                                .limit(1)
                                .forEach(region -> System.out.println(region.space));
            }

            //if (countFertilePlot > 1){
            //    regions.stream().filter(region -> region.fertilePlot.equals(maxFertilePlot))
            //                    .filter(region -> region.space == maxSpace)
            //                    .forEach(region -> System.out.println(region.space));
            //}

            if (countEffReg == 1 /* && countFertilePlot == 1 */){
                regions.stream().filter(region -> region.effectRegion == maxEffReg)
                                .limit(1)
                                .forEach(region -> System.out.println(region.space));
            }

        }

    }
}

class Region {
    Integer startRow; //Начало строки региона
    Integer startCol; //Начало колонги региона
    Integer endRow; //Конец строки региона
    Integer endCol; //Конец колонки региона
    Integer fertilePlot; //Количество плодородной земли
    Integer space; //Площадь
    Float effectRegion; // Эффективность этого региона

    public Region(Integer startRow, Integer startCol, Integer fertilePlot) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = startRow;
        this.endCol = startCol;
        this.fertilePlot = fertilePlot;
    }

    public void initBenefitPurchase() {
        if (this.endCol == this.startCol && this.endRow == this.startRow){
            this.space = 10;
        }else{
            this.space = ((this.endCol - this.startCol) + 1) * ((this.endRow - this.startRow) + 1);
        }

        this.effectRegion = this.fertilePlot.floatValue() / this.space.floatValue();
    }
}

class Plot {
    Integer row;
    Integer col;

    public Plot(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }
}
