
package Algoritmo;


public class Ciudad {
    public boolean disponible; //Permite saber si puede ser visitada o no, si fue visitada previamente.
    public String nombre; //Nombre de la ciudad que agregó el usuario.
    public int numCiudad; //Numero que permite trabajar con las ciudades en el vector de String de ciudades que creó el usuario.
    
    public Ciudad(String nombre, int numCiudad){
        this.nombre=nombre;
        this.numCiudad=numCiudad;
        this.disponible=true; // Al iniciar, siempre puede ser visitada porque no lo ha sido previamente.
    }
    public Ciudad(){
        
    }
}
