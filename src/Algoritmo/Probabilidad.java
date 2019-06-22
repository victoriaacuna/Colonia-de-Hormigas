
package Algoritmo;


public class Probabilidad {
    public double valorProb;
    public Ciudad ciudad;
    public double valorProbFeromonas;
    public double valorProbVisibilidad;
    public Probabilidad(Ciudad ciudad){
        this.ciudad=ciudad;
        this.valorProb=0;
        this.valorProbFeromonas=0;
        this.valorProbVisibilidad=0;
    }
}
