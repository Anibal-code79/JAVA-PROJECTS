package newmain;
import javax.swing.JOptionPane;
public class NewMain {

   
    public static void main(String[] args) {
        String numero= JOptionPane.showInputDialog("Digite um numero para ver a sua multiplicacao");
        int number= Integer.parseInt(numero);
        
        for(int i=1; i<11;i++){
            
            System.out.println(number*1);
        }
    }
    
}
