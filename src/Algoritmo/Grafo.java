
package Algoritmo;

import Interfaz.Conclusion;
import Interfaz.Simulacion;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Grafo {
    
    private String[] ciudades;
    private int[] datosSimulacion;
    
    private int[][] matrizAdyacencia;
    private int[][] matrizDistancias;
    private Circulo[] circulos;
    private int minDistancia; // Va a guardar la distancia mínima de todas las iteraciones.
    private Ciudad[] recorridoMin;
    private Hormiga HMasCorta;
    private int repeticionesDist;
    private int itMasCorta;
    public Iteracion[] iteracionesSimulacion;
    public static double[] valoresCalculo;
    public double[][] matrizFeromonas;
    
    
    public Grafo(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo){
        this.ciudades=ciudades;
        this.matrizDistancias=matrizDistancias;
        this.datosSimulacion=datosSimulacion;
        this.valoresCalculo=valoresCalculo;
        this.matrizAdyacencia=inicializarMatrizAdyacencia();
//        this.visitado=inicializarVisitados();
//        this.matrizFeromonas=matrizFeromonasInicial();
        this.matrizFeromonas=inicializarMatrizFeromonas();
        this.circulos=generarVectorCirculos();
        this.minDistancia=Integer.MAX_VALUE;
        this.recorridoMin=new Ciudad[this.ciudades.length];
        this.HMasCorta=new Hormiga(0);
        this.repeticionesDist=0;
        this.itMasCorta=0;
        
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
    
    
    public double[][] matrizFeromonasInicial(){
        // Se inicializa el valor de la cantidad de feromonas en cada camino de acuerdo a 1/cantidad de ciudades;
        double[][] matrizFeromonas = new double[this.ciudades.length][this.ciudades.length];
        
        for (int i = 0; i < matrizFeromonas.length; i++) {
            for (int j = 0; j < matrizFeromonas[0].length; j++) {
                if(i==j){
                    matrizFeromonas[i][j]=0.0;
                } else {
                    matrizFeromonas[i][j]=(double)1/(this.matrizDistancias[i][j]);
                }
            }
        }
        
        return matrizFeromonas;
    }
    
    public double[][] inicializarMatrizFeromonas(){
        // Se inicializa el valor de la cantidad de feromonas en cada camino de acuerdo a 1/cantidad de ciudades;
        double[][] matrizFeromonas = new double[this.ciudades.length][this.ciudades.length];
        
        for (int i = 0; i < matrizFeromonas.length; i++) {
            for (int j = 0; j < matrizFeromonas[0].length; j++) {
                if(i==j){
                    matrizFeromonas[i][j]=0.0;
                } else {

                    matrizFeromonas[i][j]=(double)1/ciudades.length;
                }
            }
        }
        
//        for (int i = 0; i < matrizFeromonas.length; i++) {
//                for (int j = 0; j < matrizFeromonas.length; j++) {
//                    System.out.print(matrizFeromonas[i][j]+" ");
//                }
//                System.out.println("");
//        }
        
        return matrizFeromonas;
    }
    
    public void generarTextoIteracion(int contIteracion){
        Hormiga HMasCorta = new Hormiga(0);
        HMasCorta=this.iteracionesSimulacion[contIteracion].HormigaConDistanciaMasCorta(this.iteracionesSimulacion[contIteracion].getHormigas());
        String conclusion="El menor recorrido conseguido por las  " + this.iteracionesSimulacion[0].getHormigas().length+
                " hormigas \nfue de "+HMasCorta.getDistRecorrida() +" Km y fue el siguiente:\n";
        for (int i = 0; i < HMasCorta.getRecorrido().length; i++) {
                conclusion+=HMasCorta.getRecorrido()[i].getNombre()+"\n";
            
        }
        Simulacion.txtTexto.setText(conclusion);
    }
    
    public void generarTextoHormiga(int contIteracion, int contHormiga){
        
        String conclusion="La hormiga recorrió " + this.iteracionesSimulacion[contIteracion].getHormigas()[contHormiga].getDistRecorrida()+
                " km. Pasando por las\nsiguientes ciudades:\n";
        for (int i = 0; i < this.iteracionesSimulacion[contIteracion].getHormigas()[contHormiga].getRecorrido().length; i++) {
            conclusion+=this.iteracionesSimulacion[contIteracion].getHormigas()[contHormiga].getRecorrido()[i].getNombre() + "\n";
            
        }
        Simulacion.txtTexto.setText(conclusion);
    }
    
    public void dibujarLineasIteracion(int contIteracion) {
        
        int num1=0, num2=0;
        Graphics g = Simulacion.Panel.getGraphics();
        
        
        for (int i = 0; i < this.iteracionesSimulacion[0].getHormigas().length; i++) {
            g.setColor(this.elegirColor());
            for (int j = 0; j < this.iteracionesSimulacion[contIteracion].getHormigas()[0].getRecorrido().length-1; j++) {
            
                num1=this.iteracionesSimulacion[contIteracion].getHormigas()[i].getRecorrido()[j].getNumCiudad();
                num2=this.iteracionesSimulacion[contIteracion].getHormigas()[i].getRecorrido()[j+1].getNumCiudad();
                g.drawLine(this.circulos[num1].getX(), this.circulos[num1].getY(), this.circulos[num2].getX(),
                    this.circulos[num2].getY());
            }
            num1=this.iteracionesSimulacion[contIteracion].getHormigas()[i].getRecorrido()[0].getNumCiudad();
            g.drawLine(this.circulos[num2].getX(), this.circulos[num2].getY(), this.circulos[num1].getX(),
                    this.circulos[num1].getY());
        }
        
        
    }
    
    public void dibujarLineasHormigas(int contIteracion, int contHormigas){
        int num1=0, num2=0;
        Graphics g = Simulacion.Panel.getGraphics();
        g.setColor(this.elegirColor());
        
        for (int i = 0; i < this.iteracionesSimulacion[contIteracion].getHormigas()[0].getRecorrido().length-1; i++) {
            
            num1=this.iteracionesSimulacion[contIteracion].getHormigas()[contHormigas].getRecorrido()[i].getNumCiudad();
            num2=this.iteracionesSimulacion[contIteracion].getHormigas()[contHormigas].getRecorrido()[i+1].getNumCiudad();
            g.drawLine(this.circulos[num1].getX(), this.circulos[num1].getY(), this.circulos[num2].getX(),
                this.circulos[num2].getY());
        }
        num1=this.iteracionesSimulacion[contIteracion].getHormigas()[contHormigas].getRecorrido()[0].getNumCiudad();
        g.drawLine(this.circulos[num2].getX(), this.circulos[num2].getY(), this.circulos[num1].getX(),
                this.circulos[num1].getY());
    }
    
    public void dibujarLineasConclusion(Hormiga H){
        int num1=0, num2=0;
        Graphics g = Conclusion.Panel.getGraphics();
        g.setColor(this.elegirColor());
        
        for (int i = 0; i < H.getRecorrido().length-1; i++) {
            
            num1=H.getRecorrido()[i].getNumCiudad();
            num2=H.getRecorrido()[i+1].getNumCiudad();
            g.drawLine(this.circulos[num1].getX(), this.circulos[num1].getY(), this.circulos[num2].getX(),
                this.circulos[num2].getY());
        }
        num1=H.getRecorrido()[0].getNumCiudad();
        g.drawLine(this.circulos[num2].getX(), this.circulos[num2].getY(), this.circulos[num1].getX(),
                this.circulos[num1].getY());
    }
    
    public Color elegirColor(){
        Random r = new Random();
        Color c;
        switch(r.nextInt(11)){
            case 1:
                c=Color.BLACK;
                break;
            case 2:
                c=Color.BLUE;
                break;
            case 3:
                c=Color.CYAN;
                break;
            case 4:
                c=Color.GREEN;
                break;
            case 5:
                c=Color.WHITE;
                break;
            case 6:
                c=Color.YELLOW;
                break;
            case 7:
                c=Color.MAGENTA;
                break;
            case 8:
                c=Color.RED;
                break;
            case 9:
                c=Color.ORANGE;
                break;
            default:
                c=Color.PINK;
        }
        return c;
    }
    
    public Circulo[] generarVectorCirculos(){
        Circulo[] circulos = new Circulo[this.ciudades.length];
        //Mínimo va a tener cuatro ciudades, por lo tanto:
        circulos[0]= new Circulo(50,50,this.ciudades[0]); 
        circulos[1] = new Circulo(100,150,this.ciudades[1]); 
        circulos[2] = new Circulo(350,80,this.ciudades[2]); 
        circulos[3] = new Circulo(400,150,this.ciudades[3]); 
        
        if(this.ciudades.length>4){
            switch(this.ciudades.length){
                case 5:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]); 
                    break;
                case 6: 
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    break;
                case 7:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    break;
                case 8:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]);
                    break;
                case 9:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    break;
                case 10:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]);
                    break;
                case 11:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    break;
                case 12: 
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]);
                    break;
                case 13:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    break;
                case 14:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]);
                    break;
                case 15:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    break;
                case 16:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    break;
                case 17:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    break;
                case 18:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    circulos[17] = new Circulo(190,230,this.ciudades[17]);  
                    break;
                case 19:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    circulos[17] = new Circulo(190,230,this.ciudades[17]); 
                    circulos[18] = new Circulo(480,200,this.ciudades[18]); 
                    break;
                default:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    circulos[17] = new Circulo(190,230,this.ciudades[17]); 
                    circulos[18] = new Circulo(480,200,this.ciudades[18]); 
                    circulos[19] = new Circulo(550,50,this.ciudades[19]); 
                    break;
            }
        }
        return circulos;
    }

    public String[] getCiudades() {
        return ciudades;
    }

    public void setCiudades(String[] ciudades) {
        this.ciudades = ciudades;
    }

    public int[] getDatosSimulacion() {
        return datosSimulacion;
    }

    public void setDatosSimulacion(int[] datosSimulacion) {
        this.datosSimulacion = datosSimulacion;
    }

    public static double[] getValoresCalculo() {
        return valoresCalculo;
    }

    public static void setValoresCalculo(double[] valoresCalculo) {
        Grafo.valoresCalculo = valoresCalculo;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
    }

    public int[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(int[][] matrizDistancias) {
        this.matrizDistancias = matrizDistancias;
    }

    public double[][] getMatrizFeromonas() {
        return matrizFeromonas;
    }

    public void setMatrizFeromonas(double[][] matrizFeromonas) {
        this.matrizFeromonas = matrizFeromonas;
    }

    public Iteracion[] getIteracionesSimulacion() {
        return iteracionesSimulacion;
    }

    public void setIteracionesSimulacion(Iteracion[] iteracionesSimulacion) {
        this.iteracionesSimulacion = iteracionesSimulacion;
    }

    public Circulo[] getCirculos() {
        return circulos;
    }

    public void setCirculos(Circulo[] circulos) {
        this.circulos = circulos;
    }

    public int getMinDistancia() {
        return minDistancia;
    }

    public void setMinDistancia(int minDistancia) {
        this.minDistancia = minDistancia;
    }

    public Ciudad[] getRecorridoMin() {
        return recorridoMin;
    }

    public void setRecorridoMin(Ciudad[] recorridoMin) {
        this.recorridoMin = recorridoMin;
    }

    public Hormiga getHMasCorta() {
        return HMasCorta;
    }

    public void setHMasCorta(Hormiga HMasCorta) {
        this.HMasCorta = HMasCorta;
    }

    public int getRepeticionesDist() {
        return repeticionesDist;
    }

    public void setRepeticionesDist(int repeticionesDist) {
        this.repeticionesDist = repeticionesDist;
    }

    public int getItMasCorta() {
        return itMasCorta;
    }

    public void setItMasCorta(int itMasCorta) {
        this.itMasCorta = itMasCorta;
    }

    
    
}


