package implementacao2.src;

public class Aluno {
    private String nome;
    private String matricula;
    private int nota;

    public Aluno(String nome, String matricula, int nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public int getnota() { return nota; }

    @Override
    public String toString() {
        return matricula + " - " + nome + " - " + nota;
    }
}
