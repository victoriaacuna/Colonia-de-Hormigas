
package Algoritmo;


public class Probabilidad {
    private double valorProb;
    private Ciudad ciudad;
    public Probabilidad(Ciudad ciudad){
        this.ciudad=ciudad;
        this.valorProb=0;
    }

    public double getValorProb() {
        return valorProb;
    }

    public void setValorProb(double valorProb) {
        this.valorProb = valorProb;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
}
