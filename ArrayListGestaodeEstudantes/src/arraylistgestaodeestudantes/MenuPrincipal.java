
package arraylistgestaodeestudantes;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        super("Sistema de Gestao de Alunos");
        
        JPanel painel = new JPanel(new GridLayout(6, 1, 5, 5));

        JButton botaoAdicionar = new JButton("1 - Adicionar estudante");
        JButton botaoGuardar = new JButton("2 - Guardar estudantes");
        JButton botaoLer = new JButton("3 - Ler estudantes");
        JButton botaoListar = new JButton("4 - Listar estudantes");
        JButton botaoRemover = new JButton("5 - Remover ultimo estudante");
        JButton botaoSair = new JButton("0 - Sair");

        botaoAdicionar.addActionListener(e -> MetodosDoEstudante.adicionarEstudante());
        botaoGuardar.addActionListener(e -> MetodosDoEstudante.guardarEstudantes());
        botaoLer.addActionListener(e -> MetodosDoEstudante.lerEstudantes());
        botaoListar.addActionListener(e -> MetodosDoEstudante.listarEstudantes());
        botaoRemover.addActionListener(e -> MetodosDoEstudante.removerUltimoEstudante());
        botaoSair.addActionListener(e -> System.exit(0)); 
        
        painel.add(botaoAdicionar);
        painel.add(botaoGuardar);
        painel.add(botaoLer);
        painel.add(botaoListar);
        painel.add(botaoRemover);
        painel.add(botaoSair);

        this.add(painel);
        this.setSize(350, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

