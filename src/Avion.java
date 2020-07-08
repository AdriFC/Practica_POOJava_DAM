import java.util.Arrays;
import java.util.Random;

public class Avion {

    //Atributos de la clase
    private boolean[] listaAsientos; // True si ocupado; false si desocupado
    private Pasajero[] pasajerosEmbarcados;

    //Constructor de la clase
    public Avion(int numAsientos){
        listaAsientos = new boolean[numAsientos]; // Defino array de tamaño numAsientos
        Arrays.fill(listaAsientos, false);   // Inicializo con valor por defecto a false: https://www.baeldung.com/java-initialize-array

        pasajerosEmbarcados = new Pasajero[numAsientos];
    }

    //Funciones
    public void embarque(Pasajeros listaPasajeros) {
        int numPasajeros = listaPasajeros.tamañoLista();
        int numAsientos = listaAsientos.length;
        if (numPasajeros > numAsientos) {                                                      //Compruebo si la lista de pasajeros es mayor que el tamaño del avión
            System.out.println("El nº de pasajeros es mayor al tamaño del avión");
        }
        else if (numPasajeros == 0){
            System.out.println("La lista de pasajeros está vacía: no hay que hacer embarque");
        }
        else {
            Pasajero pasajeroAux = null;
            int asiento = 0;
            while (listaPasajeros.tieneMasPasajeros()) {                                        // si hay pasajero en la lista
                pasajeroAux = listaPasajeros.siguientePasajero();                               // lo almaceno
                if (pasajeroAux.getTarjeta()) {                                                 // si tiene tarjeta
                    if (listaAsientos[pasajeroAux.getNumeroAsiento() - 1] == false) {           // si el sitio está libre
                        asiento = pasajeroAux.getNumeroAsiento() - 1;
                        listaAsientos[asiento] = true;                                          // ocupo el sitio
                        pasajerosEmbarcados[asiento] = pasajeroAux;                             // siento al pasajero en su sitio
                    }
                    else {                                                                      // si el sitio no esta libre
                        asiento = buscarSitioAleatorio();                                       // busco sitio aleatorio
                        listaAsientos[asiento] = true;                                          // y lo ocupo
                        pasajerosEmbarcados[asiento] = pasajeroAux;                             // y siento al pasajero en su sitio
                    }
                }
                else {                                                                          // si no tiene tarjeta
                    asiento = buscarSitioAleatorio();                                           // busco sitio aleatorio
                    listaAsientos[asiento] = true;                                              // y lo ocupo
                    pasajerosEmbarcados[asiento] = pasajeroAux;                                 // y siento al pasajero en su sito
                }
            }
            System.out.printf("\n\nEl ultimo pasajero en embarcar es " + pasajeroAux.getNombre() + // Al terminar de embarcar, mostramos el ultimo pasajero, su asiento asignado y su asiento efectivo
                    ", su asiento asignado era el " + pasajeroAux.getNumeroAsiento() +
                    " y finalmente se ha sentado en el asiento número %d\n\n", asiento+1);
        }
    }

    // Este metodo privado busca un sitio de forma aleatoria. Devuelve el numero del sitio que encuentra libre.
    private int buscarSitioAleatorio(){

        boolean estaLleno = true;                           // Variable para comprobar si el avion esta lleno

        for (int i = 0; i < listaAsientos.length; i++){     // Para cada asiento
            if(listaAsientos[i] == false){                  // si esta vacío
                estaLleno = false;                          // El avion NO esta lleno
                break;                                      // y dejo de comprobar
            }
        }

        if(estaLleno) return -1;                            // Si finalmente esta lleno, devuelvo un -1; sino, sigo

        Random ran = new Random();
        int aleatorio = ran.nextInt(listaAsientos.length);  //busco un asiento aleatorio entre 0 y el num de asientos
        while(listaAsientos[aleatorio] == true){            //mientras el asiento este ocupado
            aleatorio = ran.nextInt(listaAsientos.length);  //busco otro asiento
        }

        return aleatorio;                                   //devuelvo el asiento libre
    }

    // getter pasajerosEmbarcados
    public Pasajero[] getPasajerosEmbarcados() {
        return pasajerosEmbarcados;
    }
}
