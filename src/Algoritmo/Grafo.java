
package Algoritmo;


public class Grafo {
    
    public String[] ciudades;
    public int[] datosSimulacion;
    public double[] valoresCalculo;
    public int[][] matrizAdyacencia;
    public int[][] matrizDistancias;
    public boolean[][] matrizVisitado;
    public double[][] matrizFeromonas;
    
    
    public Grafo(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo){
        this.ciudades=ciudades;
        this.matrizDistancias=matrizDistancias;
        this.datosSimulacion=datosSimulacion;
        this.valoresCalculo=valoresCalculo;
        this.matrizAdyacencia=inicializarMatrizAdyacencia();
        this.matrizVisitado=inicializarMatrizVisitados();
        this.matrizFeromonas=inicializarMatrizFeromonas();
        
    }
    
    public int[][] inicializarMatrizAdyacencia(){
        int[][] matrizAdyacencia = new int[this.ciudades.length][this.ciudades.length];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[0].length; j++) {
                if(i==j){
                    matrizAdyacencia[i][j]=0;
                } else {
                    matrizAdyacencia[i][j]=1;
                }
            }
        }  
        return matrizAdyacencia;
    }
    
    public boolean[][] inicializarMatrizVisitados(){
        boolean[][] matrizVisitado = new boolean[this.ciudades.length][this.ciudades.length];
        for (int i = 0; i < matrizVisitado.length; i++) {
            for (int j = 0; j < matrizVisitado[0].length; j++) {
                if(i==j){
                    matrizVisitado[i][j]=true;
                } else {
                    matrizVisitado[i][j]=false;
                }
            }
        }
        return matrizVisitado;
    }
    
    public double[][] inicializarMatrizFeromonas(){
        double[][] matrizFeromonas = new double[this.ciudades.length][this.ciudades.length];
        for (int i = 0; i < matrizFeromonas.length; i++) {
            for (int j = 0; j < matrizFeromonas[0].length; j++) {
                if(i==j){
                    matrizFeromonas[i][j]=0.0;
                } else {
                    matrizFeromonas[i][j]=0.0;
                }
            }
        }
        return matrizFeromonas;
    }
}


