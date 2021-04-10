package collections;


import java.io.Serializable;

public class ToList<T> implements Serializable
{

    private Node<T> inicio;

    private int tamanio;
    /**
     * Constructor
     */
    public void ToList()
    {
        inicio = null;
        tamanio = 0;
    }
    /**
     * Consulta si la lista esta vacia.
     */
    public boolean esVacia()
    {
        return inicio == null;
    }
    /**
     * Consulta cuantos elementos (nodos) tiene la lista.
     */
    public int getTamanio()
    {
        return tamanio;
    }
    /**
     * Agrega un nuevo nodo al final de la lista.
     */
    public void agregarAlFinal(T dato)
    {
        Node<T> nuevo = new Node<T>();
        nuevo.setValor(dato);
        if (esVacia())
        {
            inicio = nuevo;
        }
        else
        {
            // Crea ua copia de la lista.
            Node<T> aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null)
            {
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }
    /**
     * Agrega un nuevo nodo al inicio de la lista.
     */
    public void agregarAlInicio(T dato)
    {
        Node<T> nuevo = new Node<T>();
        nuevo.setValor(dato);
        if (esVacia())
        {
            inicio = nuevo;
        }
        else
            {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }

        tamanio++;
    }

    public T getValor(int posicion)
    {
        if (posicion == 0)
        {
            return inicio.getValor();
        }
        else
        {
            Node<T> aux = inicio;
            for (int i = 0; i < posicion; i++)
            {
                aux = aux.getSiguiente();
            }
            return aux.getValor();
        }
    }
}
