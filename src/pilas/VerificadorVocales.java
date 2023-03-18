package pilas;

/**
 *
 * @author LUID
 */
public class VerificadorVocales {

    public static Integer verificar(String cadena, Character vocal) {
        Pila<Character> pila = new Pila<>();
        if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == vocal) {
                    pila.apilar(vocal);
                }
            }
            if (!pila.isEmpty() && pila.size() != 1) {
                if (pila.size() % 2 == 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            System.out.println("Ingrese una vocal, por favor no sea pndejo");
        }
        return 0;
    }

}
