package implementacao2.src;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "src/implementacao2/inputs/alunos10000000.txt";

        System.out.println("Lendo o arquivo: " + nomeArquivo);
        List<Aluno> alunos = LeitorArquivos.lerAlunos(nomeArquivo);

        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos tá vazia");
            return;
        }

        TestesArrayListLinkedList testes = new TestesArrayListLinkedList(alunos);

        // Aluno aleatório para ser inserido nos testes
        Aluno novoAluno = new Aluno("NovoAluno", "MATR9999", 85);

        // Executa os testes
        testes.executarTestesDeInsercao(novoAluno);
        testes.executarTestesDeBusca();
    }
}