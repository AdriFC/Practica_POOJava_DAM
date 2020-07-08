import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Pasajeros {
    //Atributos
    private ArrayList<Pasajero> listaPasajeros;
    private Iterator<Pasajero> it;

    //Constructor de la clase
    public Pasajeros (int numPasajeros){
        listaPasajeros = new ArrayList <Pasajero>(numPasajeros);
    }

    // Inicializamos el iterador: esta funcion debe llamarse cuando ya se hayan añadido todos los pasajeros a la lista
    // mediante el método addPasajero
    // Esta linea antes estaba en el constructor de la clase pasajero, pero no se puede inicializar el iterador
    // antes de añadir los pasajeros porque sino el codigo da una excepción:
    // Exception in thread "main" java.util.ConcurrentModificationException
    // La solución encontrada fue inicializar el iterador despues de añadir los pasajeros, cuando el arraylist
    // no se vaya a modificar más.
    public void listaEstaCompleta(){
        it = listaPasajeros.iterator();
    }

    //La cual nos permitirá saber si tenemos más pasajeros en la lista.
    public boolean tieneMasPasajeros(){
        if (it.hasNext())
            return true;
        else
            return false;
    }

    //La cual nos devolverá el siguiente pasajero de la lista.
    public Pasajero siguientePasajero(){
        return it.next();
    }

    //La cual nos permitirá añadir pasajeros a la lista.
    public void addPasajero(Pasajero pasajero){
        listaPasajeros.add(pasajero);
    }

    //La cual nos desordenará la lista de pasajeros.
    public void desordenar(){
        Collections.shuffle(listaPasajeros); //https://www.geeksforgeeks.org/collections-shuffle-java-examples/
    }

    // Metodo para que el primer pasajero pierda su tarjeta
    public void primerPasajeroPierdeTarjeta(){
        Pasajero pasAux = listaPasajeros.get(0);
        pasAux.setTarjeta(false);
        listaPasajeros.set(0,pasAux);
    }

    //Método para obtener el tamaño de la lista de pasajeros
    public int tamañoLista (){
        return listaPasajeros.size();
    }
}
