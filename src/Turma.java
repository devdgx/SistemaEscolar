public class Turma {

    private int numeroSala;
    private static int contadorDeTurma = 1;
    private static int quantidadeMaxima = 20;
    private Aluno[] alunos = new Aluno[quantidadeMaxima];


    public Turma() {
        this.numeroSala = contadorDeTurma;
        contadorDeTurma++;

    }


    public boolean adicionarAlunoNaTurma(Aluno aluno) {
        for (int i = 0; i < alunos.length; i++) {

            if (alunos[i] == null) {
                alunos[i] = aluno;
                return true;

            }
        }
        return false;
    }

    public void listarAlunos(){
        for (Aluno aluno : alunos){
            if (aluno != null){
                System.out.println("Aluno: " + aluno.getNome());
            }
        }
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public static int getContadorDeTurma() {
        return contadorDeTurma;
    }

    public static void setContadorDeTurma(int contadorDeTurma) {
        Turma.contadorDeTurma = contadorDeTurma;
    }

    public static int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public static void setQuantidadeMaxima(int quantidadeMaxima) {
        Turma.quantidadeMaxima = quantidadeMaxima;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }
}
