package meuprimeiroprojeto;
import java.util.Scanner;
        
public class MeuPrimeiroProjeto {

    public static void main(String[] args) {
        Scanner ler= new Scanner(System.in);
        
        System.out.print("Digite seu Nome: ");
        String nome= ler.nextLine();
        
        System.out.print("Digite seu email: ");
        String email= ler.nextLine();
        
        System.out.print("Digite sua idade: ");
        int idade= ler.nextInt();
        ler.nextLine();
        String senha="";
        String confirma= "";
      
        if(idade<18){
        System.out.println("Cadastro nao realizado por contas da idade");
        } else{
        System.out.print("Digite sua senha: ");
        senha= ler.nextLine();
        }
        do{
        System.out.print("Confirme a sua senha: ");
        confirma= ler.nextLine();
        }while(!senha.equals(confirma));
        System.out.println("Seja bem vindo "+ nome +" a nossa pagina!");
        
    }
  }
    

