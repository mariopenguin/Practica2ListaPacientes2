public class Aplicacion {

    public static void verAltas(ListaOrdinal listaOrdinal){

        System.out.println("---Pacientes de alta---");
        Iterador iterador = listaOrdinal.obtenerIterador();
        while(iterador.hasNext()){
            Paciente aux = iterador.next();
            if (aux.estaAlta()){
                aux.verPaciente();
            }
        }
    }
    public static void verLista(ListaOrdinal listaOrdinal){
        Iterador iterador = listaOrdinal.obtenerIterador();
        while (iterador.hasNext()){
            Paciente paciente = iterador.next();
            paciente.verPaciente();
        }
    }
    public static ListaOrdinal pacientesSintoma(ListaOrdinal listaOrdinal,String sintoma){
        ListaOrdinal listasintomas = new ListaOrdinal();
        Iterador iterador = listaOrdinal.obtenerIterador();
        while (iterador.hasNext()){
            Paciente aux = iterador.next();
                if(aux.getSintomas().indexOf(sintoma)!= -1){
                    listasintomas.insertar(aux);
                }

        }

        return listasintomas;
    }
    public static void main(String[] args) {
    Paciente alberto = new Paciente("Alberto","Frecuentes mareos");
        Paciente ana = new Paciente("Ana","Infeccion resistente");
        Paciente eva = new Paciente("Eva","Problemas digestivos");
        Paciente ernesto = new Paciente("Ernesto","Problemas cardiovasculares");

        ListaOrdinal listaOrdinal = new ListaOrdinal();
        listaOrdinal.insertar(alberto);listaOrdinal.insertar(ana);listaOrdinal.insertar(eva);listaOrdinal.insertar(ernesto);
        ana.darAlta(); eva.darAlta();
        verLista(listaOrdinal);
        listaOrdinal.borrarAltas();
        verLista(listaOrdinal);
        listaOrdinal.insertar(ana);listaOrdinal.insertar(eva);
        verAltas(listaOrdinal);

        ListaOrdinal listaSintomas = pacientesSintoma(listaOrdinal,"Infeccion");

        System.out.println("---Buscar por enfermedad---");
        verLista(listaSintomas);
    }
}

