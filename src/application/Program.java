package application;

import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){
        String pathFile = "C:\\Users\\alish\\IdeaProjects\\JavaFiles\\Presentation.txt";
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))){
            /*
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            Poderia ter sido instanciado dentro do bloco ao invés do try-with-resource,
            Mas, é interessante pois não precisa do bloco finally para fechar os arquivos.
            */
            String hasText = bufferedReader.readLine();
            while (hasText != null) {
                System.out.println(hasText);
                hasText = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter(pathFile, true))){
            /*
            No FileWriter(pathFile, true), sem o "true", toda vez que executasse o arquivo,
            o conteúdo seria apagado e criaria um novo arquivo de texto.
             */
            System.out.print("\nADD A TEXT TO FILE: ");
            String text = scanner.nextLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write(text);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
