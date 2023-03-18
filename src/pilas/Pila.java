package pilas;

/**
 * @author Luid
 * @param <T>
 */
public class Pila<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int size;

    public Pila() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void apilar(T dato) {
        try {
            Nodo<T> n = new Nodo<>(dato);
            if (isEmpty()) {
                inicio = fin = n;
                size++;
            } else {
                fin.setNext(n);
                fin = fin.getNext();
                size++;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public T desapilar() {
        if (!isEmpty()) {
            if (inicio == fin && size - 1 == 0) {
                Nodo<T> e = new Nodo<>(inicio.getDato());
                inicio = fin = null;
                size--;
                return e.getDato();
            } else {
                Nodo<T> a, b;
                a = inicio;
                b = inicio.getNext();
                int i = 1;
                while (b != null && i < size - 1) {
                    a = a.getNext();
                    b = b.getNext();
                    i++;
                }
                a.setNext(b.getNext());
                fin = a;
                size--;
                return b.getDato();
            }
        }
        return null;
    }

    public void clear() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public String toList() {
        Nodo<T> pointer = inicio;
        String texto = "Pila vacia";
        if (!isEmpty()) {
            texto = "[";
            if (pointer.getNext() == null) {
                texto += pointer.getDato() + "]";
            } else {
                while (pointer.getNext() != fin) {
                    texto += pointer.getDato() + ", ";
                    pointer = pointer.getNext();
                }
                if (pointer.getNext() == fin) {
                    texto += pointer.getDato() + ", " + pointer.getNext().getDato() + "]";
                }
            }
            return texto;
        }
        return texto;
    }

    private Nodo get(int pos) {
        if (!isEmpty()) {
            if (pos >= 0 || pos < size) {
                Nodo<T> apuntador = null;
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        apuntador = inicio;
                    } else {
                        apuntador = apuntador.getNext();
                    }
                    if (pos == i) {
                        return apuntador;
                    }
                }
            }
        }
        return null;
    }
}
