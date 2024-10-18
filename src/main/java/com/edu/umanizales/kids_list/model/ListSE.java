package com.edu.umanizales.kids_list.model;
import lombok.Data;

@Data
public class ListSE {
    private Node head;
    private int size;

    public void add(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(kid));
        }
        size++;
    } //Fin del metodo adicionar


    public void addToStart(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    } //Fin del metodo adicionar al inicio


    public void addInPosition(Kid kidp, int position) {
        //MI CODIGO
//        position--;
//
//        if (position < 0 || position > size) { //Verificamos si la posicion es válida
//            System.out.println("Posicion no valida");
//            return;
//        }
//
//        if (head == null) { //Si la cabeza esta vacia
//            head = new Node(kidp); //La cabeza es el nuevo niño
//        } else if (position == 0) { //Si la posicion es la primera (head)
//            addToStart(kidp); //Llamamos el metodo correspondiente para agregar al inicio
//        } else { //Si la lista no esta vacia y la posicion no es 0
//            Node temp = head; //Llamamos un ayudante
//            int contador = 0; //Creamos un contador
//
//            while (temp.getNext() != null && contador < position - 1) {
//                //Mientras encuentre niños y el contador sea menor que la posicion menos 1,
//                //el contador avanza y se incrementa
//                temp = temp.getNext();
//                contador++;
//            }
//
//            Node newNode = new Node(kidp); //Creamos un nuevo nodo con el niño
//            newNode.setNext(temp.getNext()); //El nuevo nodo apunta al siguiente nodo
//            temp.setNext(newNode); //Ubicamos el nuevo nodo en la posicion
//
//        }
//        size++; //Aumentamos el tamañan de la lista (+1)

        if (head == null || position == 1) { //Si esta vacio o la posicion es igual a 1
            addToStart(kidp); //Lo añado al principio
        }
        else {
            if (position > size) {
                add(kidp);
            }
            else {
                int pos = 1;
                Node temp = head;
                while(pos <= position - 1) {
                    temp = temp.getNext();
                    pos ++;
                }
                //Posicion antes
                Node newNode = new Node(kidp);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                size++;
            }
        }
    } //Fin del metodo adicionar en posicion


    public void invert() {
        Node previous = null; //Vacio porque no hay nodo anterior al inicio
        Node current = head; //Empezamos con la cabeza de la lista
        Node next = null; //Nodo siguiente, inicialmente vacio

        while (current != null) { //Si hay datos
            next = current.getNext(); //Niño despues del actual
            current.setNext(previous); //Nodo actual apunta al nodo anterior

            previous = current; //Establecemos el nodo anterior como el actual
            current = next; //Establecemos el nodo actual como el siguiente
        }
        head = previous;
    } //Fin del metodo invertir lista


    public void deleteById(Kid kidid, String id_delete) {
        if (head == null) { //Si la cabeza esta vacia
            System.out.println("No se encontró el niño, la lista está vacía"); //Se imprime mensaje de error
            return;
        }

        if (head.getData().getId().equals(id_delete)) { //Si el nodo a eliminar es la cabeza
            head = head.getNext(); //Mover la cabeza al siguiente nodo
            size--; //Reducir el tamaño de la lista
            return;
        }

        //Si el nodo no es la cabeza
        Node previous = null; //Nodo anterior
        Node current = head;  //Nodo actual para recorrer la lista

        while (current != null && !current.getData().getId().equals(id_delete)) { //Sigue recorriendo la lista mientras el id
            // del nodo actual no sea el id que estoy buscando
            previous = current;  //Anterior se mueve al nodo actual
            current = current.getNext();  //Actual se mueve al siguiente nodo en la lista
        }

        //Si no se encuentra el nodo con el id
        if (current == null) {
            System.out.println("No se pudo encontrar el niño con el ID dado");
            return;
        }

        //Si se encuentra el nodo con el id
        previous.setNext(current.getNext()); //Saltar el nodo que queremos eliminar
        size--; //Reducir el tamaño de la lista (-1)
    } //Fin del metodo borrar por id


    public void deleteByPosition(Kid kidpst, int position) {
        position--;

        if (head == null) { //Si la cabeza esta vacia
            System.out.println("No se pudo encontrar el niño, la lista esta vacia"); //Se imprime mensaje de error
            return;
        }

        if (position < 0 || position > size) { //Si la posición es invalida
            System.out.println("Posicion no valida");
            return;
        }

        if (position == 0) { //Si el nodo a eliminar es la cabeza
            head = head.getNext(); //Mover la cabeza al siguiente nodo
            size--; //Reducir el tamaño de la lista
            return;
        }

        //Si el nodo no es la cabeza
        Node previous = null; // Nodo anterior
        Node current = head;  // Nodo actual
        int currentPosition = 0; //Para llevar un control de la posición

        while (current != null && currentPosition < position) { //Sigue recorriendo la lista mientras la
            //posicion del nodo actual no sea la posicion deseada
            previous = current;  //El nodo anterior pasa a ser el actual
            current = current.getNext();  //El nodo actual avanza al siguiente
            currentPosition++;  //Se incrementa la posición actual
        }

        //Si no se encuentra el nodo con la posicion
        if (current == null) {
            System.out.println("No se pudo encontrar el niño en la posiicion dada");
            return;
        }

        //Si se encuentra el nodo con la posicion
        previous.setNext(current.getNext()); //Saltar el nodo que queremos eliminar
        size--; //Reducir el tamaño de la lista (-1)
    } //Fin del metodo para borrar por posicion


    public void switchByGender () {
        //MI CODIGO
//        if (head == null || head.getNext() == null) { //Si la cabeza esta vacia o tiene un solo niño
//            System.out.println("La lista ya está intercalada");
//            return;
//        }
//
//        List<Kid> listaF = new ArrayList<>(); //Lista para niñas
//        List<Kid> listaM = new ArrayList<>(); //Lista para niños
//
//        Node current = head; //Nodo actual
//
//        while (current != null) { //Si hay datos en la lista original
//            if (current.getData().getGender().equals("F")) { //Si es niña
//                listaF.add(current.getData()); //Agregarla a la lista de niñas
//            } else { //Si es niño
//                listaM.add(current.getData()); //Agregarlo a la lista de niños
//            }
//            current = current.getNext(); //Mover al siguiente nodo
//        }
//
//        //Despues de separar generos
//        current = head;
//        int contF = 0; //Contador para niñas
//        int contM = 0; //Contador para niños
//
//        while (contF < listaF.size() && contM < listaM.size()) { //Si hay datos en ambas listas de genero
//            if (contF <= contM) { //Si las cantidad de niñas procesadas es menor o igual a la cantidad
//                //de niños procesados
//                current.setData(listaF.get(contF)); //Entonces asignar niña
//                contF++; //Se incrementa el contador de niñas
//            } else { //De lo contrario
//                current.setData(listaM.get(contM)); //Asignar niño
//                contM++; //Se incrementa el contador de niños
//            }
//            current = current.getNext(); //Mover al siguiente nodo
//        }
//
//        while (contF < listaF.size()) { //Si hay más niñas en la listaF
//            current.setData(listaF.get(contF)); //Asignar niñas restantes
//            contF++; //Aumenta el contador
//            current = current.getNext(); //Avanza
//        }
//
//        while (contM < listaM.size()) { //Si hay más niños en la listaM
//            current.setData(listaM.get(contM)); //Asginar niños restantes
//            contM++; //Aumenta el contador
//            current = current.getNext(); //Avanza
//        }

        if(size > 2) {
            int posB = 1;
            int posG = 2;
            ListSE listCp = new ListSE();
            Node temp = head;
            while(temp != null) {
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
    } //Fin del metodo para intercalar por genero


    public void switchEnds () {
        if (head == null || head.getNext() == null) { //Si la cabeza esta vacia o tiene un solo niño
            System.out.println("La lista esta vacía o solo hay un elemento");
            return;
        }
        if (head.getNext().getNext() == null) { //Si la lista tiene dos nodos
            invert();
            return;
        }

        //Si hay más de dos nodos
        Node previous = null; //Nodo previo al último (penultimo nodo de la lista)
        Node current = head; //Nodo actual (para recorrer la lista)
        Node first = head; //Primer nodo (comienza como la cabeza)

        while (current.getNext() != null) { //Mientras hayan datos despues de la cabeza
            previous = current; //Anterior será el nodo actual
            current = current.getNext(); //Actual será el nodo siguiente al nodo actual original
        }

        current.setNext(head.getNext()); //Ultimo nodo apunta al segundo nodo de la lista
        previous.setNext(null); //Penultimo nodo ahora apunta a null, convirtiwndose en el ultimo nodo
        head = current; //Ultimo nodo se convierte en la nueva cabeza
        first.setNext(null); //Primer nodo original se mueve al final de la lista
        previous.setNext(first); //Conectamos el penultimo nodo con el primer nodo original
    } //Fin de

} //Fin de la clase
