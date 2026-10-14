
package arraylistgestaodeestudantes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class MetodosDoEstudante {

    static ArrayList<Estudante> estudantes = new ArrayList<>();

    public static void adicionarEstudante() {
        
        String codigoTexto = JOptionPane.showInputDialog("Codigo do estudante:");
        if (codigoTexto == null) return; 

        String nome = JOptionPane.showInputDialog("Nome do estudante:");
        if (nome == null) return;

        String teste1Texto = JOptionPane.showInputDialog("Nota do Teste 1:");
        if (teste1Texto == null) return;

        String teste2Texto = JOptionPane.showInputDialog("Nota do Teste 2:");
        if (teste2Texto == null) return;

        try {
            int codigo = Integer.parseInt(codigoTexto);
            double teste1 = Double.parseDouble(teste1Texto);
            double teste2 = Double.parseDouble(teste2Texto);

            Estudante estudante = new Estudante(codigo, nome, teste1, teste2);
            estudantes.add(estudante);

            JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Codigo ou notas invalidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void guardarEstudantes() {
        try (FileWriter file = new FileWriter("estudantes.txt");
             BufferedWriter escrever = new BufferedWriter(file)) {

            for (int i = 0; i < estudantes.size(); i++) {
                Estudante estudante = estudantes.get(i);
                escrever.write(
                        estudante.getCodigo() + ";" + estudante.getNome()
                        + ";" + estudante.getTeste1() + ";" + estudante.getTeste2()
                );
                escrever.newLine();
            }

            JOptionPane.showMessageDialog(null, "Estudantes guardados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar estudantes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void lerEstudantes() {
        try (FileReader file = new FileReader("estudantes.txt");
             BufferedReader lerFicheiro = new BufferedReader(file)) {

            estudantes.clear();
            String linha;
            while ((linha = lerFicheiro.readLine()) != null) {
                String[] dados = linha.split(";");
                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double teste1 = Double.parseDouble(dados[2]);
                double teste2 = Double.parseDouble(dados[3]);
                estudantes.add(new Estudante(codigo, nome, teste1, teste2));
            }

            JOptionPane.showMessageDialog(null, "Estudantes carregados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler estudantes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void listarEstudantes() {
        
        StringBuilder texto = new StringBuilder();

        if (estudantes.isEmpty()) {
            texto.append("Nao existem estudantes cadastrados.");
        } else {
            for (int i = 0; i < estudantes.size(); i++) {
                texto.append(estudantes.get(i).toString());
                texto.append("\n");
            }
        }
        
        JTextArea areaDeTexto = new JTextArea(texto.toString());
        areaDeTexto.setEditable(false); 
        areaDeTexto.setRows(15);
        areaDeTexto.setColumns(45);

        JScrollPane painelComRolagem = new JScrollPane(areaDeTexto);

        JFrame janela = new JFrame("Lista de Estudantes");
        janela.add(painelComRolagem);
        janela.pack();         
        janela.setLocationRelativeTo(null); 
        janela.setVisible(true);
    }

    public static void removerUltimoEstudante() {
        if (estudantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nao existem estudantes para remover.");
        } else {
            int ultimaPosicao = estudantes.size() - 1;
            Estudante removido = estudantes.remove(ultimaPosicao);
            JOptionPane.showMessageDialog(null, "Estudante removido com sucesso: " + removido.getNome());
            guardarEstudantes();
        }
    }
}
