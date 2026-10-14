
package gestaodeestudantesobjecto;
import java.io.Serializable;

public class Estudante implements Serializable {
    private int codigo;
    private String nome;
    private double teste1;
    private double teste2;
    public Estudante(int codigo, String nome, double teste1, double teste2) {
        this.codigo = codigo;
        this.nome = nome;
        this.teste1 = teste1;
        this.teste2 = teste2;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getTeste1() {
        return teste1;
    }
    public double getTeste2() {
        return teste2;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTeste1(double teste1) {
        this.teste1 = teste1;
    }
    public void setTeste2(double teste2) {
        this.teste2 = teste2;
    }

    public double calcularMedia() {
        return (teste1 + teste2) / 2;
    }
    
    public boolean compararObjecto(Estudante outro) {
        if (outro == null) {
            return false;
        }
        return this.codigo == outro.codigo;
    }
    @Override
    public String toString() {

        return codigo + nome + teste1 + teste2 + calcularMedia();
    }
}
