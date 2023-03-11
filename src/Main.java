import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
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

        //f) Print the name of empty directories
        System.out.println("\nEmpty dir : ");
        String dirPath = "basedir/";
        printEmptyDir(dirPath);

        //g) Name of the largest dir
        System.out.println("\nLargest dir : ");
        File directory = new File(dirPath);
        System.out.println("The dir with the most number of files is : "+largestFiledDir(directory));

        //h) Deepest nested path
        System.out.println("\nLargest dir : ");
        System.out.println("The deepest nested path is : "+deepestPath(directory));

        //i) Free device space remaining
        System.out.println("\nRemaining free device space : ");
        System.out.println("Free remaining space : "+getDeviceFreeSpace(directory)+" MG");

        //j) HardDisks info
        System.out.println("\nHardDisks info : ");
        getHDInfo();
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

    public static void printEmptyDir(String path) {
        File dir = new File(path);
        if (!dir.isDirectory()) {
            return;
        }

        if (dir.list().length == 0) {
            System.out.println(dir.getPath());
        } else {
            for (File file : dir.listFiles()) {
                printEmptyDir(file.getPath());
            }
        }
    }

    public static void biggestDirName(String path) {
        File dir = new File(path);
        File baseDir = new File("basedir/");
        String biggestDir = dir.getName();
        if (!dir.isDirectory()) {
            return;
        }

        if(dir.list().length != 0 ){
            for (File file : dir.listFiles()) {
                if (Integer.parseInt(numberOfFiles(file)) > Integer.parseInt(numberOfFiles(baseDir))) {

                }
            }
        }
    }

    public static int getFilesNum(File dir) {
        int filesNumber = 0;
        int subDirectories = 0;
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
        if (subDirectories > 0) {
            for (File subDir : files) {
                if (subDir.isDirectory()) {
                    filesNumber += getFilesNum(subDir);
                }
            }
        }
        return filesNumber;
    }

    public static String largestFiledDir(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("No directory found!");
            return null;
        }
        int maxFileCount = -1;
        String directoryName = null;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    int fileCount = getFilesNum(file);
                    if (fileCount > maxFileCount) {
                        maxFileCount = fileCount;
                        directoryName = file.getPath();
                    }
                }
            }
        }
        return directoryName;
    }


    public static int getDirDepth(File file) {
        int depth = 0;
        while (file.getParentFile() != null) {
            depth++;
            file = file.getParentFile();
        }
        return depth;
    }

    public static String deepestPath(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("No directory found!");
            return null;
        }
        File[] files = dir.listFiles();
        String deepestPath = dir.getAbsolutePath();
        int deepestLevel = getDirDepth(dir);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String subPath = deepestPath(file);
                    if (subPath != null) {
                        int subLevel = getDirDepth(file);
                        if (subLevel > deepestLevel) {
                            deepestPath = subPath;
                            deepestLevel = subLevel;
                        }
                    }
                }
            }
        }
        return deepestPath;
    }

    public static long getDeviceFreeSpace(File file) {
        long freeSpace = file.getFreeSpace();
        return freeSpace/1000000;
    }

    public static void getHDInfo() {
        File[] roots = File.listRoots();
        int numOfDisks = roots.length;
        System.out.println("Number of storage devices: " + numOfDisks);

        System.out.println("Names of storage devices:");
        for (int i = 0; i < numOfDisks; i++) {
            System.out.println(roots[i].getPath());
        }
    }
}
