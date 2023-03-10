import java.io.*;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the path of the dir u want to display its data : ");
        String dirPath = scan.nextLine();
        displayFileData(dirPath);

        System.out.println("\n");
        String firstFilePath = "basedir/data/dataset_1.txt";
        readFirstFile(firstFilePath);
    }

    public static void displayFileData(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Reading file: " + file.getName());
                try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = read.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readFirstFile(String path) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(path));
            String line = read.readLine();
            String[] section = line.split(" ");
            int a,b;
            a = Integer.parseInt(section[0]);
            b = Integer.parseInt(section[1]);

            System.out.println("a + b = "+(a+b));
            System.out.println("a * b = "+(a*b));
            System.out.println("a + b*b = "+(a + b*b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
