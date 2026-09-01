import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Aluno [] alunos = new Aluno[20];
        Aluno aluno = null;

        int opcao;
        do {
            System.out.println("===================================");
            System.out.println("    SISTEMA ESCOLAR");
            System.out.println("====================");


            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Listar Alunos");
            System.out.println("3- Adicionar Notas");
            System.out.println("4- Buscar Alunos");
            System.out.println("5- Ver Situação Do Aluno");
            System.out.println("0- Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Nome Aluno: ");
                    String nomeNovoAluno = scanner.next();

                    System.out.println("Idade");
                    int idadeNovoAluno = scanner.nextInt();
                    scanner.nextLine();

                    aluno = new Aluno(nomeNovoAluno, idadeNovoAluno);


                    //Add os Objetos e colocando eles em uma Arrays
                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] == null){
                            alunos[i] = aluno;
                            break;
                        }


                    }

                    System.out.println("Aluno Cadastrado...");
                    break;

                case 2:
                    //Percorrendo cada objeto usando for
                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null) {
                            System.out.println("Nome: " + alunos[i].getNome());
                            System.out.println("Idade: " + alunos[i].getIdade());
                            System.out.println("Matricula: "+ alunos[i].getMatricula() + "\n");
                            //alunos[i] esta percorrendo cada Objeto do tipo
                        }
                    }


                    break;

                case 3:
                    System.out.print("Digite Matricula Do Aluno:  ");
                    int matriculaAluno = scanner.nextInt();

                    boolean matriculaEncotrada = false;

                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null) {

                            if (matriculaAluno == alunos[i].getMatricula()) {

                                matriculaEncotrada = true;

                                System.out.println("Nome: " + alunos[i].getNome());
                                System.out.println("idade: " + alunos[i].getIdade());
                                System.out.println("matricula: " + alunos[i].getMatricula());

                                for (int j = 0; j < alunos[i].getNotas().length; j++) {
                                    System.out.print(j + 1 + "° Nota:  ");
                                    int notaAluno = scanner.nextInt();

                                    alunos[i].getNotas()[j] = notaAluno;
                                    //Add notas dentro da arrys


                                }

                                break;
                            }

                        }
                    }


                    if (matriculaEncotrada == false){
                        System.out.println("Matricula Não Encontrada");
                    }


                    break;

                case 4:

                    // busca o aluno!

                    boolean matriculaEncontradaBuscar =  false;

                    System.out.print("Matricula Do Aluno: ");
                    int buscarAlunoMatricula = scanner.nextInt();


                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null) {
                            if (alunos[i].getMatricula() == buscarAlunoMatricula) {

                                matriculaEncontradaBuscar = true;

                                System.out.println("Aluno: " + alunos[i].getNome());
                                System.out.println("Idade: " + alunos[i].getIdade());
                                System.out.println("Matricula: " + alunos[i].getMatricula());

                                System.out.println("==NOTAS==");
                                for (int j = 0; j < alunos[i].getNotas().length; j++) {
                                    System.out.println( j + 1 + "° Nota: " + alunos[i].getNotas()[j]);
                                }


                                break;
                            }
                        }
                    }
                    if (matriculaEncontradaBuscar == false){
                        System.out.println("Aluno não Encontrado!");
                    }

                    break;
                case 5:

                    System.out.print("Digite a Matricula Do Aluno: ");
                    int matriculaSituacaoAluno = scanner.nextInt();

                    double notas = 0;
                    double media = 0;
                    double total = 0;

                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null){
                            if (matriculaSituacaoAluno == alunos[i].getMatricula()){

                                for (int j = 0; j < alunos[i].getNotas().length; j++) {

                                    notas = alunos[i].getNotas()[j];
                                    total += notas;
                                }

                                media += ( total / alunos[i].getNotas().length );
                            }
                        }
                    }

                    String resultado = (media >= 7)? "Aprovado" : (media >= 5 && media <=7)? "Recuperação": "Reprovado";

                    System.out.println(resultado);
                    break;
            }

        } while (opcao != 0);
    }
}