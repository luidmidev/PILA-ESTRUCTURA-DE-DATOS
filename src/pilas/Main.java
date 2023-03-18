package pilas;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaContrastIJTheme;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author LUID
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDraculaContrastIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
        
        /**
         * VERIFICA LA VALIDACIÓN DE LOS PÁRENTESIS
         */
        String completo = "(pepe(juan))(mario)";
        String incompleto = "(pepe(juan))(mario)(";
        System.out.println("Completo: " + validaciónParéntesis(completo));
        System.out.println("Incompleto: " + validaciónParéntesis(incompleto));
            
        /**
         *VERIIFICADOR DE VOCALES: 1 PAR, -1 IMPAR 
         */
        System.out.println(VerificadorVocales.verificar("la casa de mi mam", 'a'));
        
        
        /**
         * cOMPROBAR TODA LA PARIEDAD DE LAS VOCALES DE UN STRING
         */
        String salir = "";
        while (!salir.equalsIgnoreCase("si")) {            
            String cadena = JOptionPane.showInputDialog(null, "Ingrese una cadena de texto: ");
            if (1 == VerificadorVocales.verificar(cadena, 'a')) {
                System.out.println("a: par");
            } else {
                System.out.println("a: impar");
            }
            if (1 == VerificadorVocales.verificar(cadena, 'e')) {
                System.out.println("e: par");
            } else {
                System.out.println("e: impar");
            }
            if (1 == VerificadorVocales.verificar(cadena, 'i')) {
                System.out.println("i: par");
            } else {
                System.out.println("i: impar");
            }
            if (1 == VerificadorVocales.verificar(cadena, 'o')) {
                System.out.println("o: par");
            } else {
                System.out.println("o: impar");
            }
            if (1 == VerificadorVocales.verificar(cadena, 'u')) {
                System.out.println("u: par");
            } else {
                System.out.println("u: impar");
            }
            salir = JOptionPane.showInputDialog(null, "Quiere salir del programa?");
        }
    }
    
    public static Integer validaciónParéntesis(String texto) {
        Pila<Character> pila = new Pila<>();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '(') {
                pila.apilar(texto.charAt(i));
            } else if (texto.charAt(i) == ')') {
                pila.desapilar();
            }
        }
        return pila.size();

    }

}
