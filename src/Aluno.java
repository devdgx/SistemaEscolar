public class Aluno {

    private String nome;
    private int idade;
    private  int matricula;
    private int [] notas;
    private static int contadorDeMatricula = 1;

    //Objeto é criando  add com numero de matricula
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;

        this.matricula = contadorDeMatricula;
        contadorDeMatricula++;

        this.notas = new int[3];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }



}
