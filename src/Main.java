public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Aluno> l = new ListaEncadeada<Aluno>(true, new ComparadorAlunoPorMatricula()); //Criar uma lista encadeada ordenada
        ListaEncadeada<Aluno> l2 = new ListaEncadeada<Aluno>( false, new ComparadorAlunoPorMatricula()); //Criar uma lista encadeada não ordenada
        Aluno a1 = new Aluno(1, "Alice");
        Aluno a2 = new Aluno(2, "Bob");
        Aluno a3 = new Aluno(3, "Charlie");
        Aluno a4 = new Aluno(5, "Diana");
        Aluno a5 = new Aluno(6, "Eve");
        Aluno a6 = new Aluno(0, "Frank");
        Aluno a7 = new Aluno(4, "Grace");
        Aluno a8 = new Aluno(7, "Hank");

        //Add elementos na lista ordenada
        l.adicionar(a5);
        l.adicionar(a3);
        l.adicionar(a1);
        l.adicionar(a2);
        l.adicionar(a4);

        //Add elementos na lista não ordenada
        l2.adicionar(a4);
        l2.adicionar(a2);
        l2.adicionar(a5);
        l2.adicionar(a1);
        l2.adicionar(a3);

        //Imprimir as listas
        System.out.println(l); //Deve imprimir na ordem: 1 - Alice, 2 - Bob, 3 - Charlie, 4 - Diana, 5 - Eve
        System.out.println(l2); //Deve imprimir na ordem: 4 - Diana, 2 - Bob, 5 - Eve, 1 - Alice, 3 - Charlie

        System.out.println("\n------------------");
        System.out.println("Adicionando alunos");
        l.adicionar(a6);
        l.adicionar(a7);
        l.adicionar(a8);
        System.out.println(l); //Deve imprimir na ordem: 0 - Frank, 1 - Alice, 2 - Bob, 3 - Charlie, 4 - Diana, 5 - Eve, 6 - Grace, 7 - Hank
        System.out.println("\nBuscando alunos em lista ordenada");
        System.out.println("Encontrou o aluno com matrícula 3? " + l.contemElemento(new Aluno(3, ""))); //Deve retornar true
        System.out.println("Dados do aluno com matrícula 3: " + l.pesquisar(new Aluno(3, ""))); //Deve retornar "3 - Charlie"

        System.out.println("\nRemovendo aluno em lista ordenada");
        System.out.println("Removendo aluno com matrícula 3: " + l.remover(new Aluno(3, "")));
        System.out.println("Encontrou o aluno com matrícula 3? " + l.contemElemento(new Aluno(3, ""))); // Deve retornar false
        System.out.println("------------------");

        System.out.println("\n------------------");
        System.out.println("Adicionando alunos");
        l2.adicionar(a6);
        l2.adicionar(a7);
        l2.adicionar(a8);
        System.out.println(l2); //Deve imprimir na ordem: 4 - Diana, 2 - Bob, 5 - Eve, 1 - Alice, 3 - Charlie, 0 - Frank, 6 - Grace, 7 - Hank
        System.out.println("\nBuscando alunos em lista não ordenada");
        System.out.println("Encontrou o aluno com matrícula 3? " + l2.contemElemento(new Aluno(3, ""))); //Deve retornar true
        System.out.println("Dados do aluno com matrícula 3: " + l2.pesquisar(new Aluno(3, ""))); //Deve retornar "3 - Charlie"

        System.out.println("\nRemovendo aluno em lista não ordenada");
        System.out.println("Removendo aluno com matrícula 3: " + l2.remover(new Aluno(3, "")));
        System.out.println("Encontrou o aluno com matrícula 3? " + l2.contemElemento(new Aluno(3, ""))); // Deve retornar false
        System.out.println("------------------");
    }
}
