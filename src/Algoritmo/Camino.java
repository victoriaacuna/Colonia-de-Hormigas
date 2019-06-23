
package Algoritmo;


public class Camino {
    
    private int distancia;
    private double cantFero; // cantidad de feromonas;
    private Ciudad[] ciudadesEnlazadas ; // Guarda las ciudades (vértices) que están enlazadas para cada camino.
    private int cantHormigas ; // cantidad de hormigas que han pasado por ese camino (será necesaria más adelante 
                              //para ciertos cálculos);
    public Camino(int distancia, double cantFero, Ciudad[] ciudadesEnlazadas, int cantHormigas){
        this.distancia=distancia;
        this.cantFero=cantFero;
        this.ciudadesEnlazadas=ciudadesEnlazadas;
        this.cantHormigas=cantHormigas;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getCantFero() {
        return cantFero;
    }

    public void setCantFero(double cantFero) {
        this.cantFero = cantFero;
    }

    public Ciudad[] getCiudadesEnlazadas() {
        return ciudadesEnlazadas;
    }

    public void setCiudadesEnlazadas(Ciudad[] ciudadesEnlazadas) {
        this.ciudadesEnlazadas = ciudadesEnlazadas;
    }

    public int getCantHormigas() {
        return cantHormigas;
    }

    public void setCantHormigas(int cantHormigas) {
        this.cantHormigas = cantHormigas;
    }
    
    
    
}
