package application;

import java.io.*;

public class Program {
    public static void main (String[] args){
        String pathFile = "C:\\Users\\alish\\IdeaProjects\\JavaFiles\\Presentation.txt";

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
    }
}
