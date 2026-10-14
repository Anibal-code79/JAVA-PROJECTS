
package gestaodeestudantesobjecto;

import java.util.Scanner;

public class GestaoDeEstudantesObjecto {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("==========================================");
            System.out.println("          GESTÃO DE ESTUDANTES");
            System.out.println("==========================================");
            System.out.println("1 - Adicionar estudante");
            System.out.println("2 - Guardar estudantes");
            System.out.println("3 - Carregar estudantes");
            System.out.println("4 - Listar estudantes");
            System.out.println("5 - Remover último estudante");
            System.out.println("0 - Sair");
            System.out.println("==========================================");
            
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1:
                    MetodosDoEstudante.adicionarEstudante();
                    break;
                case 2:
                    MetodosDoEstudante.guardarEstudantes();
                    break;
                case 3:
                    MetodosDoEstudante.lerEstudantes();
                    break;
                case 4:
                    MetodosDoEstudante.listarEstudante();
                    break;
                case 5:
                    MetodosDoEstudante.removerUltimoEstudante();
                    break;
                case 0:
                    System.out.println(
                            "Programa encerrado com sucesso."
                    );
                    break;
                default:
                    System.out.println(
                            "Opção inválida!"
                    );
            }
        } while (opcao != 0);
        ler.close();
    }
}
