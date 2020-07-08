public class Pasajero {
    //Atributos

    private String nombre;
    private int numeroAsiento;
    private boolean tarjeta;

    //Contructor de la clase

    public Pasajero (String nombre, int numeroAsiento){
        this.nombre=nombre;
        this.numeroAsiento=numeroAsiento;
        this.tarjeta=true;
    }
    //Metodos get y set

    public void setNombre (String nombre){this.nombre=nombre;}
    public String getNombre (){return this.nombre;}
    public void setNumeroAsiento (int numeroAsiento){this.numeroAsiento=numeroAsiento;}
    public int getNumeroAsiento (){return this.numeroAsiento;}
    public void setTarjeta (boolean tarjeta){this.tarjeta=tarjeta;}
    public boolean getTarjeta (){return this.tarjeta;}


    /*Método toString() -- Class pasajero hereda de class object (por defecto) object ya tiene su toString()
    Se sobreescribe con @override*/

    @Override
    public String toString(){
        return "Persona nombre: "+nombre+", número de asiento: "+numeroAsiento+", tiene tarjeta: "+tarjeta;
    }
}
