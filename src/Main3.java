import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        System.out.print("Enter the path of the dir u want to display its data : ");
//        String dirPath = scan.nextLine();
//        displayFileData(dirPath);

        System.out.println("\nOperations on a & b : ");
        String firstFilePath = "basedir/data/dataset_1.txt";
        readFirstFile(firstFilePath);

        //b) Get even numbers
        System.out.println("\nEven number ");
        String secondFilePath = "basedir/data/dataset_2.txt";
        getEvenNumbers(secondFilePath);

        //c) Less than 9999
        System.out.println("\nNumbers less than 9999 ");
        String thirdFilePath = "basedir/data/dataset_3.txt";
        lessThan9999(thirdFilePath);

        //d) Largest number
        System.out.println("\nThe largest number ");
        String fourthFilePath = "basedir/data/dataset_4.txt";
        theLargestNumber(fourthFilePath);

        //e) Display in uppercase form
        System.out.println("\nUppercase display : ");
        String fifthFilePath = "basedir/data/dataset_5.txt";
        displayInUppercase(fifthFilePath);
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

    public static void getEvenNumbers(String path) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(path));
            String line; int evenNumbers=0;
            while((line = read.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num % 2 == 0) {
                        evenNumbers++;
                    }
                }
            }

            System.out.println("Number of even numbers is :"+evenNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lessThan9999(String path) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(path));
            String line;
            while((line = read.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num < 9999) {
                        System.out.println(num);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void theLargestNumber(String path) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(path));
            String line; int largestNumber = 0;
            while((line = read.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num > largestNumber) {
                        largestNumber = num;
                    }
                }
            }

            FileWriter add = new FileWriter(path,true);
            add.write(String.valueOf(" "+largestNumber));
            add.close();
            System.out.println("The largest number is : "+largestNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayInUppercase(String path){
        try {
            BufferedReader read = new BufferedReader(new FileReader(path));
            String line;
            while ((line = read.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    System.out.println(word.toUpperCase(Locale.ROOT));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
