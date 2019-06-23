
package Algoritmo;


public class Ciudad {
    private boolean disponible; //Permite saber si puede ser visitada o no, si fue visitada previamente.
    private String nombre; //Nombre de la ciudad que agregó el usuario.
    private int numCiudad; //Numero que permite trabajar con las ciudades en el vector de String de ciudades que creó el usuario.
    
    public Ciudad(String nombre, int numCiudad){
        this.nombre=nombre;
        this.numCiudad=numCiudad;
        this.disponible=true; // Al iniciar, siempre puede ser visitada porque no lo ha sido previamente.
    }
    public Ciudad(){
        
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCiudad() {
        return numCiudad;
    }

    public void setNumCiudad(int numCiudad) {
        this.numCiudad = numCiudad;
    }
    
    
}
