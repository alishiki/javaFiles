package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){
        File file = new File ("C:\\Users\\alish\\IdeaProjects\\JavaFiles\\Presentation.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }
}
