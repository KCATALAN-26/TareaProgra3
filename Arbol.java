package menu;

import java.util.ArrayList;
import java.util.Collections;

class Arbol {
    
    private Nodo raiz;
    
    public Arbol() {
        this.raiz = null;
    }
    
    public void insertar(int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
        } else {
            insertarRecursivo(raiz, valor);
        }
    }
    
    private void insertarRecursivo(Nodo actual, int valor) {
        if (valor < actual.getValor()) {
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(new Nodo(valor));
            } else {
                insertarRecursivo(actual.getIzquierda(), valor);
            }
        } else {
            if (actual.getDerecha() == null) {
                actual.setDerecha(new Nodo(valor));
            } else {
                insertarRecursivo(actual.getDerecha(), valor);
            }
        }
    }
    
    public void buscar(int valor) {
        Nodo resultado = buscarRecursivo(raiz, valor);
        if (resultado != null) {
            System.out.println("\u001B[32m\nValor \u001B[0m " + valor + " \u001B[32mencontrado\u001B[0m.");
        } else {
            System.out.println("\u001B[31m\nValor \u001B[0m " + valor + " \u001B[31mno encontrado\u001B[0m.");
        }
    }
    
    private Nodo buscarRecursivo(Nodo actual, int valor) {
        if (actual == null || actual.getValor() == valor) {
            return actual;
        } else if (valor < actual.getValor()) {
            return buscarRecursivo(actual.getIzquierda(), valor);
        } else {
            return buscarRecursivo(actual.getDerecha(), valor);
        }
    }
    
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }
    
    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return null;
        }
        
        if (valor == actual.getValor()) {
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                return null;
            } else if (actual.getIzquierda() == null) {
                return actual.getDerecha();
            } else if (actual.getDerecha() == null) {
                return actual.getIzquierda();
            } else {
                int minValor = encontrarMinValor(actual.getDerecha());
                actual.setValor(minValor);
                actual.setDerecha(eliminarRecursivo(actual.getDerecha(), minValor));
                
            return actual;
        }
        } else if (valor < actual.getValor()) {actual.setIzquierda(eliminarRecursivo(actual.getIzquierda(), valor));
        
        return actual;
        } else {actual.setDerecha(eliminarRecursivo(actual.getDerecha(), valor));
        
        return actual;
        }
    
}

    private int encontrarMinValor(Nodo nodo) {
    while (nodo.getIzquierda() != null) {
        nodo = nodo.getIzquierda();
    }
    return nodo.getValor();
}

public void listar() {
    ArrayList<Integer> valores = new ArrayList<>();
    listarRecursivo(raiz, valores);
    Collections.sort(valores, Collections.reverseOrder());
    valores.forEach(valor -> {
        System.out.println(valor);
        });
}

private void listarRecursivo(Nodo actual, ArrayList<Integer> valores) {
    if (actual == null) {
        return;
    }
    valores.add(actual.getValor());
    listarRecursivo(actual.getIzquierda(), valores);
    listarRecursivo(actual.getDerecha(), valores);
}
    
}
