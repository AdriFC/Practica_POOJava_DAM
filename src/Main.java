import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        //inicializamos numero de pasajeros
        int numPasajeros = 10;
        //inicializamos numero de asientos del avion: es igual al numero de pasajeros (segun enunciado)
        int numAsientos = numPasajeros;

        // Creamos los diferentes pasajeros
        Pasajero pasajero1 = new Pasajero("Adrian Fraga", 1);
        Pasajero pasajero2 = new Pasajero("Daniel Martiñán", 2);
        Pasajero pasajero3 = new Pasajero("Jesús Gil", 3);
        Pasajero pasajero4 = new Pasajero("Perico Delgado", 4);
        Pasajero pasajero5 = new Pasajero("Ana Patricia Botín", 5);
        Pasajero pasajero6 = new Pasajero("Angels Barceló", 6);
        Pasajero pasajero7 = new Pasajero("Javier Cámara", 7);
        Pasajero pasajero8 = new Pasajero("Óscar Mulero", 8);
        Pasajero pasajero9 = new Pasajero("Belén Esteban", 9);
        Pasajero pasajero10 = new Pasajero("Fátima Hajji", 10);

        //creamos la lista de pasajeros
        Pasajeros miListaPasajeros = new Pasajeros(numPasajeros);

        //añadimos los pasajeros a la lista de pasajeros
        miListaPasajeros.addPasajero(pasajero1);
        miListaPasajeros.addPasajero(pasajero2);
        miListaPasajeros.addPasajero(pasajero3);
        miListaPasajeros.addPasajero(pasajero4);
        miListaPasajeros.addPasajero(pasajero5);
        miListaPasajeros.addPasajero(pasajero6);
        miListaPasajeros.addPasajero(pasajero7);
        miListaPasajeros.addPasajero(pasajero8);
        miListaPasajeros.addPasajero(pasajero9);
        miListaPasajeros.addPasajero(pasajero10);

        // la lista esta completa
        miListaPasajeros.listaEstaCompleta();

        //desordenamos los pasajeros en la lista
        miListaPasajeros.desordenar();

        //Hacemos que el primer pasajero pierda su tarjeta de embarque
        miListaPasajeros.primerPasajeroPierdeTarjeta();

        // Creamos el avión
        Avion miAvion = new Avion(numAsientos);

        // Hacemos que los pasajeros embarquen
        miAvion.embarque(miListaPasajeros);

        // Revisamos como han quedado los pasajeros embarcados
        Pasajero[] pasajerosEmbarcados = miAvion.getPasajerosEmbarcados();

        System.out.println("Los pasajeros han quedado embarcados de la siguiente manera: \n");
        for(int i = 0; i < pasajerosEmbarcados.length; i++) {
            System.out.printf(pasajerosEmbarcados[i].getNombre() + ": su asiento era el " +
                    pasajerosEmbarcados[i].getNumeroAsiento() +
                    " y esta sentando en el asiento %d \n", i+1);
        }
    }
}
