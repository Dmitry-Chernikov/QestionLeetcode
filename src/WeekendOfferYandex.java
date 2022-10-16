import java.io.*;
import java.util.Arrays;

public class WeekendOfferYandex {


    public void EvenOddMatrix() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.parseInt(reader.readLine());
        n = (n * 2) + 1;
        Integer[][] matrix = new Integer[n][n];
        Integer line = 1;
        Integer column = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) {
                    matrix[row][col] = 0;
                } else {
                    if (row % 2 == 0) {
                        if (col % 2 != 0) {
                            matrix[row][col] = line;
                            line++;
                        }
                        if (col % 2 == 0) {
                            matrix[col][row] = column * -1;
                            column++;
                        }
                    }
                    if (row % 2 != 0) {
                        if (col % 2 == 0) {
                            matrix[row][col] = line;
                            line++;
                        }
                        if (col % 2 != 0) {
                            matrix[col][row] = column * -1;
                            column++;
                        }
                    }
                }

            }
        }

        //Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
        //Arrays.stream(matrix).map(Arrays::toString).forEach(writer::write);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        reader.close();
        writer.close();
    }

    public void PhotoFeed() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        double w = Double.parseDouble(reader.readLine());
        int[] line2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Integer n = line2[0];
        int k = line2[1];
        double minH = 0;
        double maxH = 0;

        double ScaleH = 0;


        for (int i = 0; i < n; i++) {
            double[] bufSizePhoto = Arrays.stream(reader.readLine().split("x")).mapToDouble(Double::valueOf).toArray();
            ScaleH = ScaleH + ((bufSizePhoto[1] * w) / bufSizePhoto[0]);

            if (k == n){
                minH = ScaleH;
            }else {
                for (int j = i; j < k; j++) {
                    minH = ScaleH;
                }
                i = i + (k-1);
            }
            maxH = ScaleH;

        }

        System.out.println((int)Math.ceil(minH));
        System.out.println((int)Math.ceil(maxH));

        reader.close();
        writer.close();
    }
}
