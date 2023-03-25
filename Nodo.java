
package menu;


class Nodo {
    
    private final int valor;
    private Nodo izquierda;
    private Nodo derecha;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
    
    public int getValor() {
        return valor;
    }
    
    public Nodo getIzquierda() {
        return izquierda;
    }
    
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
    
    public Nodo getDerecha() {
        return derecha;
    }
    
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    void setValor(int minValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
