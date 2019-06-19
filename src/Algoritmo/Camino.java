
package Algoritmo;


public class Camino {
    
    public int distancia;
    public double cantFero; // cantidad de feromonas;
    public Ciudad[] ciudadesEnlazadas ; // Guarda las ciudades (vértices) que están enlazadas para cada camino.
    public int cantHormigas ; // cantidad de hormigas que han pasado por ese camino (será necesaria más adelante 
                              //para ciertos cálculos);
    public Camino(int distancia, double cantFero, Ciudad[] ciudadesEnlazadas, int cantHormigas){
        this.distancia=distancia;
        this.cantFero=cantFero;
        this.ciudadesEnlazadas=ciudadesEnlazadas;
        this.cantHormigas=cantHormigas;
    }
    
    
}
