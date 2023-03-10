import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dir = new File("basedir/dir0/");
        int filesNumber=0, subDirectories=0;

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        filesNumber++;
                    } else if (file.isDirectory()) {
                        subDirectories++;
                    }
                }
            }
        } else {
            System.out.println("No directory found!");
            return;
        }

        System.out.println("Number of files: " + filesNumber);
        System.out.println("Number of subDirectories: " + subDirectories);

        System.out.println("\n");
        getFileName(dir);
        System.out.println("\n");
        System.out.println(numberOfFiles(dir));

        File Yolka = new File("basedir/dir0/Yolka.txt");
        System.out.println("The abs path of the elka files : "+outputPath(Yolka));


        //Printing the nested files and dir in baseDir
        System.out.println("\n");
        printNestedFilesDir(dir,0);

    }

    public static void getFileName(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
            }
        } else {
            System.out.println("No dir found!");
        }
    }

    public static String numberOfFiles(File dir) {
        int generalFiles=0, txtFiles=0;
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        generalFiles++;
                        if (file.getName().endsWith(".txt")) {
                            txtFiles++;
                        }
                    }
                }
            }
        } else {
            System.out.println("No directory found!");
        }

        return "General files number : "+generalFiles+"\n/txt files numbers : "+txtFiles;
    }

    public static String outputPath(File file){
        return file.getAbsolutePath();
    }

    public static void printNestedFilesDir(File dir, int a) {
        File[] files = dir.listFiles();
        for (File file : files) {
            for (int i = 0; i < a; i++) {
                System.out.print("\t");
            }
            System.out.println(file.getName());
            if (file.isDirectory()) {
                printNestedFilesDir(file, a + 1);
            }
        }
    }

    public static void printEmptyDir(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {

            }
        } else {
            System.out.println("No directory found!");
        }
    }
}
