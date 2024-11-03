// Задача 4. Логирование операций с массивом во время поиска
// минимального и максимального элементов
// Реализуйте метод поиска минимального и максимального элементов массива.
// После нахождения каждого элемента (минимального и максимального),
// сделайте запись в лог-файл log.txt в формате год-месяц-день
// час:минуты {минимальный элемент}, {максимальный элемент}.


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

class ArrayOperations {
    private static File log;
    private static FileWriter fileWriter;

    public static void findMinMax(int[] arr) {
        // Реализуйте метод для поиска минимального и максимального элемента

        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);

            int min = arr[0];
            int max = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
                logStep(min, max);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static void logStep(int min, int max) {
        // Реализуйте метод для записи состояния в лог-файл

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
            String timestamp = dateFormat.format(new Date());
            fileWriter.write(timestamp + " " + min + ", " + max + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class task4 {
    public static void main(String[] args) {
        int[] arr = {};
        
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        if (args.length == 0) {
            arr = new int[]{9, 4, 8, 3, 1};
        } else {
            arr = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        ArrayOperations ans = new ArrayOperations();
        ans.findMinMax(arr);
        
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
