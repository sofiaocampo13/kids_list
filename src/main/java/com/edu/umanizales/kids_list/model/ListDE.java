package com.edu.umanizales.kids_list.model;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ListDE {
    private NodeDE head;
    private int size;

    public void add(Kid kid) {
        NodeDE newNode = new NodeDE(kid);
        if (head == null) {
            head = newNode;
        } else {
            NodeDE temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            temp.getNext().setPrevious(temp);
        }
        size++;
    } //Fin del metodo adicionar

    public void addToStart(Kid kid) {
        if (head == null) {
            head = new NodeDE(kid);
        } else {
            NodeDE newNodeDE = new NodeDE(kid);
            newNodeDE.setNext(head);
            head.setPrevious(newNodeDE);
            head = newNodeDE;
        }
        size++;
    } //Fin del metodo adicionar al inicio

    public void addInPosition(Kid kidp, int position) {
        if (head == null || position == 1) {
            addToStart(kidp);
        } else if (position > size) {
            add(kidp);
        } else {
            int pos = 1;
            NodeDE temp = head;
            while (pos < position - 1) {
                temp = temp.getNext();
                pos++;
            }
            NodeDE newNodeDE = new NodeDE(kidp);
            newNodeDE.setNext(temp.getNext());

            if (temp.getNext() != null) {
                temp.getNext().setPrevious(newNodeDE);
            }
            temp.setNext(newNodeDE);
            newNodeDE.setPrevious(temp);
            size++;
        }
    } //Fin del metodo adicionar en posición

    public void invert() {
        NodeDE current = head;
        NodeDE previous = null;
        NodeDE next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            current.setPrevious(next);
            previous = current;
            current = next;
        }
        head = previous;
    } //Fin del metodo invertir lista

    public void deleteById(Kid kidid, String id_delete) {
        if (head == null) {
            System.out.println("No se encontró el niño, la lista está vacía");
            return;
        }
        NodeDE current = head;
        //Si el nodo a eliminar es la cabeza
        if (head.getData().getId().equals(id_delete)) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            size--;
            return;
        }
        //Recorrer la lista buscando el nodo a eliminar
        while (current != null && !current.getData().getId().equals(id_delete)) {
            current = current.getNext();
        } if (current == null) {
            System.out.println("No se encontró el niño, la lista está vacía");
            return;
        }
        //Si se encuentra el nodo
        NodeDE previous = current.getPrevious();
        NodeDE next = current.getNext();
        if (previous != null) {
            previous.setNext(next);
        } if (next != null) {
            next.setPrevious(previous);
        }
        size--;
    } //Fin del método borrar por id

    public void deleteByPosition(Kid kidpst, int position) {
        position--;
        if (head == null) {
            System.out.println("No se encontró el niño, la lista está vacía");
            return;
        }
        if (position < 0 || position >= size) {
            System.out.println("Posición no válida");
            return;
        }
        NodeDE current = head;
        //Si el nodo a eliminar es la cabeza
        if (position == 0) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            size--;
            return;
        }
        //Recorrer la lista hasta la posición deseada
        int currentPosition = 0;
        while (currentPosition < position) {
            current = current.getNext();
            currentPosition++;
        }
        NodeDE previous = current.getPrevious();
        NodeDE next = current.getNext();
        if (previous != null) {
            previous.setNext(next);
        }
        if (next != null) {
            next.setPrevious(previous);
        }
        size--;
    }

    public void switchByGender() {
        if (size > 2) {
            int posB = 1;  //Posición para los niños
            int posG = 2;  //Posición para las niñas
            ListDE listCp = new ListDE();
            NodeDE temp = head;
            while (temp != null) {
                switch (temp.getData().getGender()){
                    case 'F':
                    case 'f':
                        listCp.addInPosition(temp.getData(), posG);
                        posG += 2;
                        break;
                    default:
                        listCp.addInPosition(temp.getData(), posB);
                        posB += 2;
                }
                temp = temp.getNext(); //Se pasa al siguiente
            }
            this.head = listCp.getHead();
        }
    } //Fin del método intercalar por genero

    public void switchEnds() {
        if (head == null || head.getNext() == null) { //Si la cabeza esta vacia o tiene un solo niño
            System.out.println("La lista esta vacía o solo hay un elemento");
            return;
        }
        if (head.getNext().getNext() == null) { //Si la lista tiene dos nodos
            invert();
            return;
        }

        //Si hay más de dos nodos
        NodeDE previous = null;
        NodeDE current = head;
        NodeDE first = head;
        // Recorremos hasta llegar al último nodo
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        // Intercambiamos los nodos
        current.setNext(head.getNext());
        current.setPrevious(null);
        previous.setNext(first);
        first.setNext(null);
        first.setPrevious(previous);
        head = current;
    } //Fin del método intercambiar extremos


    public List show() {
        ArrayList list = new ArrayList();
        if(this.getHead() != null) {
            NodeDE temp = head;
            while(temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return list;
    }
} //Fin de la clase
