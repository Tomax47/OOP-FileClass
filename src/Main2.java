import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter the number of dirs to create : ");
//        int n = scan.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter the path to create a directory: ");
//            String path = scan.nextLine();
//            System.out.print("Enter the name of the dir : ");
//            String dirName = scan.nextLine();
//            createDir(path,dirName);
//        }

//        System.out.print("Enter the number of files to create : ");
//        int m = scan.nextInt();
//        scan.nextLine();
//        for (int i = 0; i < m; i++) {
//            String path = "basedir/Picture/";
//            System.out.print("Enter the name of the file : ");
//            String fileName = scan.nextLine();
//            createFile(path,fileName);
//        }

//        System.out.print("\nEnter the path of the file u wanna change : ");
//        String path = scan.nextLine();
//        System.out.print("Enter the name of the file : ");
//        String file = scan.nextLine();
//        System.out.print("Enter the new name of the file : ");
//        String newName = scan.nextLine();
//        renameFile(path, file ,newName);


        //Move the file
//        System.out.print("\nEnter the path of the file u wanna move : ");
//        String path = scan.nextLine();
//        System.out.print("Enter the path of the targeted dir : ");
//        String targetDir = scan.nextLine();
//        moveToDir(path,targetDir);

//        System.out.print("Enter the path of the file u wanna delete : ");
//        String path = scan.nextLine();
//        deleteFile(path);


//        System.out.print("How many files u wanna delete from the dir Picture : ");
//        int n = scan.nextInt();
//        deleteFiles(n);

        System.out.print("Enter the path of the dir u wanna delete : ");
        String dirPath = scan.nextLine();
        File dir = new File(dirPath);
        deleteDir(dir);
    }

    public static void createDir(String path, String dirName) {

        File file = new File(path+dirName);

        boolean bool = file.mkdir();
        if(bool){
            System.out.println("Directory created successfully");
        }else{
            System.out.println("Couldn't create specified directory");
        }
    }

    public static void createFile(String path, String fileName) {
        File file = new File(path+fileName+".txt");

        try {
            boolean isFileCreated = file.createNewFile();

            if (isFileCreated) {
                System.out.println("File has been created!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("An unknown error occurred while creating the file!");
            e.printStackTrace();
        }
    }

    public static void renameFile(String path, String filename, String newName) {
        File file = new File(path+filename);
        File newFile = new File(path+newName);

        boolean isFileRenamed = file.renameTo(newFile);

        if (isFileRenamed) {
            System.out.println("Name has been changed! " + newName);
        } else {
            System.out.println("Couldn't change the name!");
            return;
        }
    }

    public static void moveToDir(String path, String targetDir) {
        File file = new File(path);
        File targetedDir = new File(targetDir);

        boolean fileIsMoved = file.renameTo(new File(targetedDir, file.getName()));
        if (fileIsMoved) {
            System.out.println("File has been moved to " + targetDir);
        } else {
            System.out.println("Couldn't move the file!");
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path);

        boolean fileDeleted = file.delete();
        if (fileDeleted) {
            System.out.println("File has been deleted!");
        } else {
            System.out.println("Couldn't delete the file!");
        }
    }

    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDir(file);
                }
            }
        }
        boolean dirDeleted = dir.delete();
        if (dirDeleted) {
            System.out.println("Directory has been deleted!");
        } else {
            System.out.println("Couldn't delete the directory!");
        }
    }

    public static void deleteFiles(int n) {
        if (n == 0) {
            return;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the path of the file u wanna delete : ");
        String path = scan.nextLine();
        File file = new File(path);

        boolean fileDeleted = file.delete();
        if (fileDeleted) {
            System.out.println("File has been deleted!");
            deleteFiles(n - 1);
        } else {
            System.out.println("Couldn't delete the file!");
            deleteFiles(n - 1);
        }
    }


}
