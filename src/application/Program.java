package application;

import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){
        String pathDoc = "C:\\Users\\alish\\IdeaProjects\\JavaFiles\\Presentation.txt";
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathDoc))){

            String hasText = bufferedReader.readLine();
            while (hasText != null) {
                System.out.println(hasText);
                hasText = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter(pathDoc, true))){

            System.out.print("\nDo you want to write to file? (Y/N): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.print("\nADD A TEXT TO FILE: ");
                String text = scanner.nextLine();
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.write(text);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.print("Enter the address file: ");
            String fileAddress = scanner.nextLine();
            File file = new File(fileAddress);

            File[] folders = file.listFiles(File::isDirectory);
            System.out.println("\nFOLDERS: ");
            for (File folder : folders) {
                System.out.println(folder);
            }

            File[] fileDoc = file.listFiles(File::isFile);
            System.out.println("\nFILES: ");
            folders = file.listFiles(File::isDirectory);
            for (File doc: fileDoc) {
                System.out.println(doc);
            }

            boolean success = new File(fileAddress + "\\subdiretory").mkdir();
            System.out.println("Directory created: " + success);
        }
        catch (NullPointerException e) {
            System.out.println("Error: the path file don't exists.");
        }
    }

}
