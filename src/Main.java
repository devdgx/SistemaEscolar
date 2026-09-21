import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Aluno [] alunos = new Aluno[20];
        Aluno aluno = null;

        Turma [] turmas = new Turma[5];

        Turma turma = null;


        int opcao;
        do {
            System.out.println("  =====================");
            System.out.println("    SISTEMA ESCOLAR");
            System.out.println("  ====================");


            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Cadastrar Turma ");
            System.out.println("3- Listar Alunos");
            System.out.println("4- Adicionar Notas");
            System.out.println("5- Busca Alunos");
            System.out.println("6- Ver Situação Do Aluno");
            System.out.println("7- Adicionar aluno na turma");
            System.out.println("8- Ver Alunos em turma");
            System.out.println("0- Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome Aluno: ");
                    String nomeNovoAluno = scanner.next();

                    System.out.println("Idade");
                    int idadeNovoAluno = scanner.nextInt();
                    scanner.nextLine();

                    aluno = new Aluno(nomeNovoAluno, idadeNovoAluno);


                    //Add os Objetos e colocando eles em uma Arrays
                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] == null) {
                            alunos[i] = aluno;
                            System.out.println("Matricula do Aluno: " + alunos[i].getMatricula());
                            break;
                        }


                    }
                    System.out.println("Aluno Cadastrado...");
                    break;

                case 2:

                    for (int i = 0; i < turmas.length; i++) {
                        if (turmas[i] == null) {
                            turmas[i] = new Turma();
                            System.out.println("Numero de ID da sala " + turmas[i].getNumeroSala());
                            break;
                        }
                    }
                    System.out.println("Turma criada! ");

                    break;
                case 3:
                    //Percorrendo cada objeto usando for

                    boolean alunosCadastrado = false;
                    System.out.println("#####ALUNOS#####");
                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null) {
                            alunosCadastrado = true;
                            System.out.println("Nome: " + alunos[i].getNome());
                            System.out.println("Idade: " + alunos[i].getIdade());
                            System.out.println("Matricula: " + alunos[i].getMatricula() + "\n");
                            if (alunos[i].getTurma() != null) {
                                System.out.println("Numero da Turma: " + alunos[i].getTurma().getNumeroSala());
                            } else {
                                System.out.println("Aluno sem Turma!");
                            }
                        }
                    }

                    if (alunosCadastrado == false) {
                        System.out.println("Nenhum aluno Cadastrado!");
                    }


                    break;

                case 4:
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
                                if (alunos[i].getTurma() != null) {
                                    System.out.println("Numero da Turma: " + alunos[i].getTurma().getNumeroSala());
                                } else {
                                    System.out.println("Aluno Sem turma");
                                }

                                for (int j = 0; j < alunos[i].getNotas().length; j++) {
                                    System.out.print(j + 1 + "° Nota:  ");
                                    int notaAluno = scanner.nextInt();

                                    alunos[i].getNotas()[j] = notaAluno;
                                    //Add notas dentro da arrys


                                }
                                System.out.println("Notas Adicionadas");

                                break;
                            }

                        }
                    }


                    if (matriculaEncotrada == false) {
                        System.out.println("Matricula Não Encontrada");
                    }


                    break;

                case 5:

                    // busca o aluno!

                    boolean matriculaEncontradaBuscar = false;

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
                                    System.out.println(j + 1 + "° Nota: " + alunos[i].getNotas()[j]);
                                }


                                break;
                            }
                        }
                    }
                    if (matriculaEncontradaBuscar == false) {
                        System.out.println("Aluno não Encontrado!");
                    }

                    break;
                case 6:

                    System.out.print("Digite a Matricula Do Aluno: ");
                    int matriculaSituacaoAluno = scanner.nextInt();

                    boolean matriculaEncontrada = false;
                    double notas = 0;
                    double media = 0;
                    double total = 0;

                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null) {
                            if (matriculaSituacaoAluno == alunos[i].getMatricula()) {
                                matriculaEncontrada = true;
                                for (int j = 0; j < alunos[i].getNotas().length; j++) {

                                    notas = alunos[i].getNotas()[j];
                                    total += notas;
                                }
                                System.out.println("Aluno: " + alunos[i].getNome());
                                media += (total / alunos[i].getNotas().length);

                                System.out.println("Media: " + media);

                                String resultado = (media >= 7) ? "Aprovado" : (media >= 5 && media <= 7) ? "Recuperação" : "Reprovado";
                                System.out.println("Status: "+resultado);

                            }
                        }
                    }

                    if (matriculaEncontrada == false) {
                        System.out.println("Aluno Não Encontrado!");
                    }

                    break;



                case 7:
                    System.out.println("Qual ID aluno você quer adicionar na turma: ");

                    int buscarIdAluno = scanner.nextInt();

                    System.out.println("Qual turma vc quer adicionar o aluno: ");

                    int idSala = scanner.nextInt();

                    boolean alunoEncontrado = false;
                    boolean turmaEncontrada = false;
                    for (int i = 0; i < alunos.length; i++) {
                        if (alunos[i] != null) {
                            if (buscarIdAluno == alunos[i].getMatricula()) {
                                alunoEncontrado = true;

                                for (int j = 0; j < turmas.length; j++) {
                                    if (turmas[j] != null) {
                                        if (idSala == turmas[j].getNumeroSala()) {
                                            turmaEncontrada = true;
                                            boolean alunoAdicionado = turmas[j].adicionarAlunoNaTurma(alunos[i]);

                                            if (alunoAdicionado == true){
                                                alunos[i].setTurma(turmas[j]);
                                                System.out.println("Aluno foi adicionado na Turma!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (alunoEncontrado != true) {
                        System.out.println("Aluno não Encontrado!");
                    }

                    if (turmaEncontrada != true) {
                        System.out.println("Turma não Encontrada!");
                    }
                    break;


                case 8:

                    boolean EncontradaTurma = false;
                    System.out.println("Numero da turma: ");
                    int numeroDaTurma = scanner.nextInt();


                    for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] != null){
                                if (numeroDaTurma == turmas[i].getNumeroSala()){
                                    EncontradaTurma = true;
                                    turmas[i].listarAlunos();
                                }
                        }
                    }

                    if (EncontradaTurma == false){
                        System.out.println("Nenhum Turma Cadastrada!");
                    }



            }
        } while (opcao != 0);
    }
}




