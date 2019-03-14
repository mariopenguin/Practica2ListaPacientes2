class ListaOrdinal {

    private Nodo inicio, fin;
    private int numElementos;

    public ListaOrdinal() {
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    /** Inserta el dato en la última posición de la lista
     */
    public void insertar(Paciente paciente) {
        Nodo nuevo = new Nodo(paciente, null);
        if (this.estaVacia()){
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        numElementos++;
    }

    /** Inserta el dato en la posición indicada de la lista,
     *  si es posible.
     */
    public void insertar(Paciente paciente, int posicion) {
        Nodo nuevo, anterior;
        if ((posicion > numElementos) || (posicion < 0)) {
            System.out.println("No es posible la inserción del " + paciente);
        } else {
            if (posicion == numElementos) {
                this.insertar(paciente);
            } else {
                if (posicion == 0) {   // Insertar al principio
                    nuevo = new Nodo(paciente, inicio);
                    inicio = nuevo;
                } else {  // Buscar posición de inserción.
                    anterior = inicio;
                    for (int i = 0; i < posicion - 1; i++) {
                        anterior = anterior.getSiguiente();
                    }
                    nuevo = new Nodo(paciente, anterior.getSiguiente());
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
            }
        }
    }

    /** Busca el dato que ocupa la posición recibida como parámetro,
     * en caso de existir.
     */
    public Paciente get(int posicion) {
        Nodo aux = inicio;
        if ((posicion > numElementos - 1) || (posicion < 0)) {
            System.out.println("No existe la posición " + posicion);
            return null;
        } else {
            for (int i = 0; i < posicion; i++) {
                aux = aux.getSiguiente();
            }
        }
        return aux.getPaciente();
    }
    public void borrarAltas(){
        Iterador iterador = obtenerIterador();
        while (iterador.hasNext()){
            Paciente paciente = iterador.next();
            if (paciente.estaAlta()){
                borrar(paciente);
                numElementos--;
            }
        }

    }
    /** Borra el primer elemento de la lista cuyo dato coincide con el
     * parámetro recibido.
     */


    public void borrar(Paciente paciente) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null ){
            if (actual.getPaciente() ==  paciente) {  // Borrar actual
                if (actual != inicio) {
                    anterior.setSiguiente(actual.getSiguiente());
                } else {
                    inicio = actual.getSiguiente();
                }
                if (actual == fin) {  // se borra el último
                    fin = anterior;
                }
                numElementos--;
            } else {
                anterior = actual;
            }
            actual = actual.getSiguiente();
        }
    }

    /** Devuelve la primera posición en la que se encuentra el dato,
     * en caso de existir. En caso contrario, devuelve -1
     */
/*
    public int posicion(int dato) {
        Nodo actual = inicio;
        int pos = 0;
        while (actual != null && actual.getDato() != dato) {
            actual = actual.getSiguiente();
            pos++;
        }
        if (actual != null){
            return pos;
        } else {
            return -1;
        }
    }
*/
    /** Determina si el dato recibido como parámetro existe en la lista.
     */
   /* public boolean contiene(int dato) {
        return this.posicion(dato) >= 0;
    }
*/
    public int tamaño() {
         return numElementos;
    }

    public Iterador obtenerIterador() {
        return new Iterador(inicio);
    }


}
