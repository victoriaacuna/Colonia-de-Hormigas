
package Algoritmo;


public class Iteracion {
    public Hormiga[] hormigas;
    public Hormiga HMasCorta; //Guarda la hormiga que recorrió la menor distancia en cada iteración.
    public Hormiga HMasFeromonas; //Guarda la hormiga que recorrió el camino total con más feromonas.
    
    public Iteracion(Hormiga[] hormigas){
        this.hormigas=hormigas;
    }
    
    public Hormiga HormigaConDistanciaMasCorta(Hormiga[] hormigas){
        Hormiga HMasCorta = new Hormiga(0);
        int minDist=Integer.MAX_VALUE;
        for (int i = 0; i < hormigas.length; i++) {
            if(hormigas[i].distRecorrida<minDist){
                HMasCorta=hormigas[i];
                minDist=hormigas[i].distRecorrida;
            }
        }
        return HMasCorta;
    }
    
    public Hormiga HormigaConMasFeromonas(Hormiga[] hormigas){
        Hormiga HMasFeromonas = new Hormiga(0);
        double maxFero=0;
        for (int i = 0; i < hormigas.length; i++) {
            if(hormigas[i].cantFeroRecorridas>maxFero){
                HMasFeromonas=hormigas[i];
                maxFero=hormigas[i].cantFeroRecorridas;
            }
        }
        return HMasFeromonas;
    }
    
    
}
