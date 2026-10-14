
package gestaodeestudantesobjecto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;

import java.util.Scanner;

public class MetodosDoEstudante {
    
    static Scanner ler = new Scanner(System.in);
    static Estudante[] estudantes = new Estudante[30];
    static int indice = 0;
    
    public static void adicionarEstudante() {
        if (indice < estudantes.length) {
            System.out.print("Digite o codigo do estudante: ");
            int codigo = Integer.parseInt(ler.nextLine());
            System.out.print("Digite o nome do estudante: ");
            String nome = ler.nextLine();

            System.out.print("Digite a primeira nota: ");
            double teste1 = Double.parseDouble(ler.nextLine());

            System.out.print("Digite a segunda nota: ");
            double teste2 = Double.parseDouble(ler.nextLine());

            Estudante estudante = new Estudante(
                codigo,
                nome,
                teste1,
                teste2
            );

            estudantes[indice] = estudante;
            indice++;
            System.out.println("Estudante adicionado com sucesso!");
        } else {
            System.out.println("Limite de estudantes atingido.");
        }
    }
    
    public static void guardarEstudantes() {
        try {
            FileOutputStream file =new FileOutputStream("estudantes.bin");
            ObjectOutputStream escrever = new ObjectOutputStream(file);
            for (int i = 0; i < indice; i++) {
                escrever.writeObject(estudantes[i]);
            }

            escrever.close();
            file.close();
            
            System.out.println("Estudantes guardados com sucesso!");
        } catch (IOException e) {
        System.out.println("Erro ao guardar os estudantes: "+ e.getMessage());
        }
    }
    
    public static void lerEstudantes() {
        indice = 0;
        try {
            FileInputStream file = new FileInputStream("estudantes.bin");
            ObjectInputStream ler = new ObjectInputStream(file);
            
            while (true) {
                try {
                    Estudante estudante = (Estudante) ler.readObject();
                    if (indice < estudantes.length) {
                    estudantes[indice] = estudante;
                    indice++;
                } else {
                    System.out.println("Limite de 30 estudantes atingido.");
                    break;
                }
                }catch (EOFException e) {
                break;
            }
            }
            ler.close();
            file.close();

            System.out.println("Estudantes carregados com sucesso!");
            } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());

            } catch (ClassNotFoundException e) {
                System.out.println("A classe Estudante não foi encontrada.");
        }
    }
    
    public static void listarEstudante() {
        if (indice == 0) {
            System.out.println("Não existem estudantes cadastrados.");
        } else{
            System.out.println("\n==========================================");
            System.out.println("          LISTA DE ESTUDANTES");
            System.out.println("==========================================");

            for (int i = 0; i < indice; i++) {
                System.out.println(estudantes[i]);
            }
            System.out.println("==========================================");
        }
    }
    
    public static void removerUltimoEstudante() {
        if (indice == 0) {
            System.out.println("Não existem estudantes para remover.");
        } else{
            Estudante removido = estudantes[indice - 1];
            estudantes[indice - 1] = null;
            indice--;
            System.out.println("Estudante removido com sucesso: "+ removido.getNome());
            guardarEstudantes();
        }
    }
}
