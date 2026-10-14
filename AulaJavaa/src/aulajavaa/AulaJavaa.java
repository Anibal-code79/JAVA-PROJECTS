
package aulajavaa;
import javax.swing.JOptionPane;
public class AulaJavaa {

    public static void main(String[] args) {
         String ageStr= JOptionPane.showInputDialog("Digite um numero para ver a sua tabuada ");
        
        int age= Integer.parseInt(ageStr);
        for (int i=1; i<10; i++){
        System.out.println("Atabuada do numero que digitou e:");
        System.out.println( age + " x " + i + " = " + (age*i));
    }
        
    }
    
}
