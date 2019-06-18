
package Algoritmo;


public class Grafo {
    
    public String[] ciudades;
    public int[] datosSimulacion;
    public double[] valoresCalculo;
    public int[][] matrizAdyacencia;
    public int[][] matrizDistancias;
    
    public Grafo(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo){
        this.ciudades=ciudades;
        this.matrizDistancias=matrizDistancias;
        this.datosSimulacion=datosSimulacion;
        this.valoresCalculo=valoresCalculo;
        
        int[][] matrizAdyacencia = new int[ciudades.length][ciudades.length];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[0].length; j++) {
                if(i==j){
                    matrizAdyacencia[i][j]=0;
                } else {
                    matrizAdyacencia[i][j]=1;
                }
            }
        }
        this.matrizAdyacencia=matrizAdyacencia;
        
    }
}
