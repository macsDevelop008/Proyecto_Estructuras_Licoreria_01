package collections;

import java.io.Serializable;

public class Node<T> implements Serializable
{
    private T dato;
    private Node<T> siguiente;



    public void Node(T dato, Node<T> siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    //get y set atributos.

    public T getValor() {
        return dato;
    }

    public void setValor(T dato) {
        this.dato = dato;
    }

    public Node getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }
}
