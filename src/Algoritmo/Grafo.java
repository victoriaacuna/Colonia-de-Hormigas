
package Algoritmo;


public class Grafo {
    
    public String[] ciudades;
    public int[] datosSimulacion;
    public static double[] valoresCalculo;
    public int[][] matrizAdyacencia;
    public int[][] matrizDistancias;
    public boolean[] visitado;
    public double[][] matrizFeromonas;
    
    
    public Grafo(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo){
        this.ciudades=ciudades;
        this.matrizDistancias=matrizDistancias;
        this.datosSimulacion=datosSimulacion;
        this.valoresCalculo=valoresCalculo;
        this.matrizAdyacencia=inicializarMatrizAdyacencia();
        this.visitado=inicializarVisitados();
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
    
    public boolean[] inicializarVisitados(){
        boolean[]visitado = new boolean[this.ciudades.length];
        for (int i = 0; i < visitado.length; i++) {
            visitado[i]=false;
        }
        return visitado;
    }
    
    public double[][] inicializarMatrizFeromonas(){
        // Se inicializa el valor de la cantidad de feromonas en cada camino de acuerdo a 1/cantidad de ciudades;
        double[][] matrizFeromonas = new double[this.ciudades.length][this.ciudades.length];
        for (int i = 0; i < matrizFeromonas.length; i++) {
            for (int j = 0; j < matrizFeromonas[0].length; j++) {
                if(i==j){
                    matrizFeromonas[i][j]=0.0;
                } else {
                    matrizFeromonas[i][j]=(1/ciudades.length);
                }
            }
        }
        return matrizFeromonas;
    }
}


