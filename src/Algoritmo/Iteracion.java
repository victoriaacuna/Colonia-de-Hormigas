
package Algoritmo;


public class Iteracion {
    private Hormiga[] hormigas;
    private Hormiga HMasCorta; //Guarda la hormiga que recorrió la menor distancia en cada iteración.
    
    public Iteracion(Hormiga[] hormigas){
        this.hormigas=hormigas;
    }
    
    public Hormiga HormigaConDistanciaMasCorta(Hormiga[] hormigas){
        Hormiga HMasCorta = new Hormiga(0);
        int minDist=Integer.MAX_VALUE;
        for (int i = 0; i < hormigas.length; i++) {
            if(hormigas[i].getDistRecorrida()<minDist){
                HMasCorta=hormigas[i];
                minDist=hormigas[i].getDistRecorrida();
            }
        }
        return HMasCorta;
    }
    
    

    public Hormiga[] getHormigas() {
        return hormigas;
    }

    public void setHormigas(Hormiga[] hormigas) {
        this.hormigas = hormigas;
    }

    public Hormiga getHMasCorta() {
        return HMasCorta;
    }

    public void setHMasCorta(Hormiga HMasCorta) {
        this.HMasCorta = HMasCorta;
    }


}
