package implementacao2.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivos {

    public static List<Aluno> lerAlunos(String nomeArquivo) {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            reader.readLine();

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 3) {
                    String matricula = partes[0];
                    String nome = partes[1];
                    int nota = (int) Float.parseFloat(partes[2]);
                    alunos.add(new Aluno(nome, matricula, nota));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
        return alunos;
    }
}