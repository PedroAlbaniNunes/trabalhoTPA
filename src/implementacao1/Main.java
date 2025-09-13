package implementacao1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja que a lista seja ordenada? (s/n)"); //perguntar pra saber qual método vai ter que usar pra adicionar
        String resposta = sc.nextLine();

        ListaEncadeada<Aluno> lista;
        if (resposta.equalsIgnoreCase("s")) {
            lista = new ListaEncadeada<>(true, new ComparadorAlunoPorMatricula());
        } else {
            lista = new ListaEncadeada<>(false, new ComparadorAlunoPorMatricula());
        }

        int opcao;
        do {
            System.out.println("\n================================");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Remover aluno");
            System.out.println("3. Conferir aluno");
            System.out.println("4. Pesquisar aluno");
            System.out.println("5. Ver lista de alunos");
            System.out.println("0. Sair");
            System.out.println("================================");
            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite a matrícula do aluno: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o nome do aluno: ");
                    String nome = sc.nextLine();
                    Aluno aluno = new Aluno(matricula, nome);
                    lista.adicionar(aluno); //se for ordenada, usa o inserirOrdenado, se não for, usa o inserirNoFinal
                }
                case 2 -> {
                    System.out.print("Digite a matrícula do aluno a ser removido: ");
                    int matricula = sc.nextInt(); //pega só a matrícula, porque o equals na classe implementacao1.Aluno só compara matrícula, então não precisa do nome
                    sc.nextLine();
                    Aluno aluno = new Aluno(matricula, "");
                    Aluno removido = lista.remover(aluno);
                    if (removido != null) {
                        System.out.println("implementacao1.Aluno removido: " + removido);
                    } else {
                        System.out.println("implementacao1.Aluno não encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Digite a matrícula do aluno a ser conferido: ");
                    int matricula = sc.nextInt(); //mesma coisa do case 2
                    sc.nextLine();
                    Aluno aluno = new Aluno(matricula, "");
                    boolean existe = lista.contemElemento(aluno);
                    if (existe) {
                        System.out.println("O aluno está na lista.");
                    } else {
                        System.out.println("O aluno não está na lista.");
                    }
                }
                case 4 -> {
                    System.out.print("Digite a matrícula do aluno a ser pesquisado: ");
                    int matricula = sc.nextInt(); //mesma coisa do case 2
                    sc.nextLine();
                    Aluno aluno = new Aluno(matricula, "");
                    Aluno encontrado = lista.pesquisar(aluno);
                    if (encontrado != null) {
                        System.out.println("implementacao1.Aluno encontrado: " + encontrado);
                    } else {
                        System.out.println("implementacao1.Aluno não encontrado.");
                    }
                }
                case 5 -> System.out.println("Lista de alunos:\n" + lista);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");

            }
        } while (opcao != 0);

    }
}