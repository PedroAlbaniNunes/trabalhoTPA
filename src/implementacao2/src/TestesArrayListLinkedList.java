package implementacao2.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestesArrayListLinkedList {

    private final List<Aluno> arrayListOriginal;
    private final List<Aluno> linkedListOriginal;

    public TestesArrayListLinkedList(List<Aluno> alunos) { //cria as listas originais
        this.arrayListOriginal = new ArrayList<>(alunos);
        this.linkedListOriginal = new LinkedList<>(alunos);
    }

    private long medirTempo(Runnable operacao) { //timer pra medir o tempo de execução de cada operação
        long inicio = System.nanoTime();
        operacao.run();
        long fim = System.nanoTime();
        return fim - inicio;
    }


    //NOS TESTES VAMOS FAZER A CRIAÇÃO DE LISTAS CÓPIA PARA CADA UM, POIS APÓS A PRIMEIRA INSERÇÃO, AS LISTAS ORIGINAIS SERIAM MODIFICADAS
    public void executarTestesDeInsercao(Aluno aluno) {
        System.out.println("\n--- Testes de Inserção ---");

        // Inserção no Fim
        List<Aluno> arrayListCopiaFim = new ArrayList<>(arrayListOriginal);
        long tempoArrayFim = medirTempo(() -> arrayListCopiaFim.add(aluno));

        List<Aluno> linkedListCopiaFim = new LinkedList<>(linkedListOriginal);
        long tempoLinkedFim = medirTempo(() -> linkedListCopiaFim.add(aluno));
        System.out.println("============================");
        System.out.println("INSERÇÃO NO FIM");
        System.out.println("ARRAYLIST: " + tempoArrayFim + " ns");
        System.out.println("LINKEDLIST: " + tempoLinkedFim + " ns");
        System.out.println("============================");

        // Inserção no Início
        List<Aluno> arrayListCopiaInicio = new ArrayList<>(arrayListOriginal);
        long tempoArrayInicio = medirTempo(() -> arrayListCopiaInicio.add(0, aluno));

        List<Aluno> linkedListCopiaInicio = new LinkedList<>(linkedListOriginal);
        long tempoLinkedInicio = medirTempo(() -> linkedListCopiaInicio.add(0, aluno));
        System.out.println("============================");
        System.out.println("INSERÇÃO NO INÍCIO");
        System.out.println("ARRAYLIST: " + tempoArrayInicio + " ns");
        System.out.println("LINKEDLIST: " + tempoLinkedInicio + " ns");
        System.out.println("============================");


        // Inserção no Meio
        int meio = arrayListOriginal.size() / 2;
        List<Aluno> arrayListCopiaMeio = new ArrayList<>(arrayListOriginal);
        long tempoArrayMeio = medirTempo(() -> arrayListCopiaMeio.add(meio, aluno));

        List<Aluno> linkedListCopiaMeio = new LinkedList<>(linkedListOriginal);
        long tempoLinkedMeio = medirTempo(() -> linkedListCopiaMeio.add(meio, aluno));
        System.out.println("============================");
        System.out.println("INSERÇÃO NO MEIO");
        System.out.println("ARRAYLIST: " + tempoArrayMeio + " ns");
        System.out.println("LINKEDLIST: " + tempoLinkedMeio + " ns");
        System.out.println("============================");
    }

    public void executarTestesDeBusca() {
        System.out.println("\n--- Testes de Busca ---");

        // Busca no Fim
        int ultimo = arrayListOriginal.size() - 1;
        long tempoArrayFim = medirTempo(() -> arrayListOriginal.get(ultimo));
        long tempoLinkedFim = medirTempo(() -> linkedListOriginal.get(ultimo));
        System.out.println("============================");
        System.out.println("BUSCA NO FIM");
        System.out.println("ARRAYLIST: " + tempoArrayFim + " ns");
        System.out.println("LINKEDLIST: " + tempoLinkedFim + " ns");
        System.out.println("============================");

        // Busca no Penúltimo
        int penultimo = arrayListOriginal.size() - 2;
        long tempoArrayPenultimo = medirTempo(() -> arrayListOriginal.get(penultimo));
        long tempoLinkedPenultimo = medirTempo(() -> linkedListOriginal.get(penultimo));
        System.out.println("============================");
        System.out.println("BUSCA NO PENÚLTIMO");
        System.out.println("ARRAYLIST: " + tempoArrayPenultimo + " ns");
        System.out.println("LINKEDLIST: " + tempoLinkedPenultimo + " ns");
        System.out.println("============================");

        // Busca no Meio
        int meio = arrayListOriginal.size() / 2;
        long tempoArrayMeio = medirTempo(() -> arrayListOriginal.get(meio));
        long tempoLinkedMeio = medirTempo(() -> linkedListOriginal.get(meio));
        System.out.println("============================");
        System.out.println("BUSCA NO MEIO");
        System.out.println("ARRAYLIST: " + tempoArrayMeio + " ns");
        System.out.println("LINKEDLIST: " + tempoLinkedMeio + " ns");
        System.out.println("============================");
    }
}