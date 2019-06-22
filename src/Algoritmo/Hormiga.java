
package Algoritmo;

import java.util.Random;


public class Hormiga {
    
    public Ciudad ciudadActual; //Ciudad en la que se encuentra la hormiga.
    public Ciudad[] ciudadesDisponibles; //Ciudades que puede o no visitar la hormiga.
    public Camino[][] caminos; //Matriz de todos los caminos posibles.
    public double recorridoHPrev; //Distancia que recorrió la hormiga anterior.
    public int distRecorrida; //Distancia total recorrida por la hormiga.
    public Ciudad[] Recorrido; //Guarda la seucencia en la que se recorrieron las distancias;
    public int ciudadesRecorridas; //Contador que sirve para algunos métodos.
    public double cantFeroRecorridas; // Guarda el total de la cantidad de feromonas recorridas;
    public double[] valoresCalculo; // Valores de alfa, beta, ro.
    public int Q;
    public Ciudad primera;
    public Ciudad ultima;
    String nombre;
    
    public Hormiga(int num){
        this.Q=1;
        this.valoresCalculo=Grafo.valoresCalculo;
        this.ciudadesRecorridas=0;
        this.nombre="Hormiga "+num;
    }
    
    
    public void moverse(Hormiga H, int cantH, Grafo g, int contIt){
        

        if(H.ciudadesRecorridas>H.ciudadesDisponibles.length){

//            for (int i = 0; i < g.matrizFeromonas.length; i++) {
//                for (int j = 0; j < g.matrizFeromonas.length; j++) {
//                    System.out.print(g.matrizFeromonas[i][j]+" ");
//                }
//                System.out.println("");
//            }
//            System.out.println("RECORRI EN TOTAL: " + H.distRecorrida);
//            System.out.println("");
            

            //Código EXTRA agregado para que el algoritmo sea más preciso.
            
            if(g.minDistancia<H.distRecorrida){
                //Si sabe que este no es el camino más corto, disminuye las feromonas en él y aumenta las del camino corto previo.
                disminuirFeromonas(H, g);
                aumentarFeromonas(g.HMasCorta,g,(double)1.3);
            }
            if(g.minDistancia>H.distRecorrida){
                //Si encuentra un camino más corto, lo marca aumentando las feromonas en él.
                g.HMasCorta=H;
                g.recorridoMin=H.Recorrido;
                resetearFeromonas(H, g);
                g.minDistancia=H.distRecorrida;
                g.repeticionesDist=1;
                g.itMasCorta=contIt;
            }
            if(g.minDistancia==H.distRecorrida){
                g.repeticionesDist++;
            }
        } else {
            if(H.ciudadesRecorridas==0){
            
            Random r = new Random();
                int random= r.nextInt(H.ciudadesDisponibles.length);
                H.primera=H.ciudadesDisponibles[random];
                H.ciudadActual=H.ciudadesDisponibles[random];
                H.ciudadesDisponibles[random].disponible=false;
                H.Recorrido= new Ciudad[H.ciudadesDisponibles.length+1];
                for (int i = 0; i < H.Recorrido.length; i++) {
                    H.Recorrido[i]= new Ciudad();
                }
                H.Recorrido[H.ciudadesRecorridas]=H.ciudadActual;
                H.ciudadesRecorridas++;
                
                
                // RECURSIVIDAD
                moverse(H,cantH,g,contIt);
            } else if(H.ciudadesRecorridas<H.ciudadesDisponibles.length && H.ciudadesRecorridas>0){
                // Se elige una ciudad de acuerdo a las probabilidades.
                Ciudad elegida = elegirCiudadProbable(H,cantH,g);
                
                // Este código inicializaría las feromonas de acuerdo a la distancia entre los caminos, no dependiendo del número
                // de ciudades.
//                Ciudad elegida = elegirCiudad(H,cantH,g);

                // Actualiza la distancia recorrida.
                H.distRecorrida=H.distRecorrida + H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].distancia;
                // Actualiza el recorrdio.
                H.Recorrido[H.ciudadesRecorridas]=elegida; // El atributo ciudadesRecorridas es un contador;
                // Actualiza la cantidad de feromonas recorridas;
                H.cantFeroRecorridas= (double)H.cantFeroRecorridas+H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
                // Actualiza el contador de las ciudades recorrdias;
                H.ciudadesRecorridas++;
                // Marca la ciudad a la que se movió como no disponible (ya visitada).
                H.ciudadesDisponibles[elegida.numCiudad].disponible=false;
                // Actualiza la ciudad actual en la que se encuentra la hormiga.
                H.ciudadActual=elegida;
                
                
                
                if(H.ciudadesRecorridas==H.ciudadesDisponibles.length-1){
                    H.ultima=elegida;
                }
                
                //RECURSIVIDAD.
                moverse(H,cantH,g,contIt);
            } else {
                Ciudad elegida = H.primera;
                //Actualizo el valor de las feromonas.
                actualizarFeromonas(H, cantH, elegida, g);
                H.distRecorrida=H.distRecorrida + H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].distancia;
                // Actualiza el recorrdio.
                H.Recorrido[H.ciudadesRecorridas]=elegida; // El atributo ciudadesRecorridas es un contador;
                // Actualiza la cantidad de feromonas recorridas;
                H.cantFeroRecorridas= (double)H.cantFeroRecorridas+H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
                // Actualiza el contador de las ciudades recorrdias;
                H.ciudadesRecorridas++;
                // Marca la ciudad a la que se movió como no disponible (ya visitada).
                H.ciudadesDisponibles[elegida.numCiudad].disponible=false;
                // Actualiza la ciudad actual en la que se encuentra la hormiga.
                H.ciudadActual=elegida;
                
                //RECURSIVIDAD.
                moverse(H,cantH,g,contIt);
            }
            }
        
    }
    
    public Ciudad elegirCiudad(Hormiga H, int cantH, Grafo g){
        double sumaProb=0;
        Ciudad[] ciudadesDisponibles = ciudadesDisponibles(H);
        Probabilidad[] prob = new Probabilidad[ciudadesDisponibles.length];
        
        // A cada probabilidad, se le asigna una ciudad disponible.
        for (int i = 0; i < prob.length; i++) {
            prob[i]= new Probabilidad(ciudadesDisponibles[i]);
        }
        // Se le asigna el valor de la probabilidad a cada probabilidad y se actualiza la sumaProb
        for (int i = 0; i < prob.length; i++) {
            double base1 = (double)H.caminos[H.ciudadActual.numCiudad][prob[i].ciudad.numCiudad].cantFero;
            double exp1=  (double)H.valoresCalculo[0]; // Valor de alfa;
            double base2 = (double)Q/H.caminos[H.ciudadActual.numCiudad][prob[i].ciudad.numCiudad].distancia;
            double exp2=  (double)H.valoresCalculo[1]; // Valor de beta.
            prob[i].valorProb=(double)Math.pow(base1, exp1)*Math.pow(base2, exp2);
            sumaProb=(double)sumaProb+prob[i].valorProb;
        }
        double maxProb=0;
        Ciudad elegida = prob[0].ciudad; // Solo para inicializarlo.
        for (int i = 0; i < prob.length; i++) {
            //PEEEEEN
            if((prob[i].valorProb/sumaProb)>=maxProb){
                maxProb=(double)prob[i].valorProb/sumaProb;
                elegida=prob[i].ciudad;
            }
        }
        
        actualizarFeromonas(H,cantH, elegida, g);
        return elegida;
    }
    
    public Ciudad[] ciudadesDisponibles(Hormiga H){
        int tamano=0;
        for (int i = 0; i < H.ciudadesDisponibles.length; i++) {
            if(H.ciudadesDisponibles[i].disponible){
                tamano++;
            }
        }
        Ciudad[] ciudadesDisponibles = new Ciudad[tamano];
        int cont = 0;
        for (int i = 0; i < H.ciudadesDisponibles.length; i++) {
            if(H.ciudadesDisponibles[i].disponible){
                ciudadesDisponibles[cont]=H.ciudadesDisponibles[i];
                cont++;
            }
        }
        
        return ciudadesDisponibles;
    }
    
    public void actualizarFeromonas(Hormiga H, int cantH, Ciudad elegida, Grafo g){
        double act=0;
        for (int i = 0; i < g.iteracionesSimulacion[0].hormigas.length; i++) {
            act= (double)act + (double)Q/H.recorridoHPrev;
            
        }
        
        //Se actualizan las feromonas de los caminos desde la ciudad actual, hasta la elegida y de la elegida a la ciudad actual.
        H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero=
                (double)H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero + (double)act;
        H.caminos[elegida.numCiudad][H.ciudadActual.numCiudad].cantFero=
                (double)H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
        // Se actualiza la matriz de feromonas del grafo.
        g.matrizFeromonas[H.ciudadActual.numCiudad][elegida.numCiudad]=
                (double)H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
        g.matrizFeromonas[elegida.numCiudad][H.ciudadActual.numCiudad]=
                (double)H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
        
        // Se actualiza la cantidad de hormigas que han pasado por ese camino.
        H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantHormigas++;
        H.caminos[elegida.numCiudad][H.ciudadActual.numCiudad].cantHormigas++;
        
    }
    

    
    public Grafo EvaporacionFeromonas(Grafo g){
        double ro=(double)g.valoresCalculo[2];
        // Actualiza las feromonas de todos los caminos para empezar la nueva iteración.
        for (int i = 0; i < g.matrizFeromonas.length; i++) {
            for (int j = 0; j < g.matrizFeromonas[0].length; j++) {
                g.matrizFeromonas[i][j]=(double)(1-ro)*(double)g.matrizFeromonas[i][j];
                
            }
        }
        // Aumenta las feromonas de la hormiga que realizó el camino más corto de la iteración.
        aumentarFeromonas(g.HMasCorta, g, (double)1.50);
        return g;
    }
    
    public Ciudad[] vectorCiudadesDisponibles(String[] ciudades){
        Ciudad[] c = new Ciudad[ciudades.length];
        for (int i = 0; i < c.length; i++) {
            c[i]= new Ciudad(ciudades[i],i);
        }
        return c;
    }
    
    public void inicializarCaminos(int[][] matrizDistancias, double[][] matrizFeromonas){
        this.caminos= new Camino[this.ciudadesDisponibles.length][this.ciudadesDisponibles.length];
        for (int i = 0; i < this.caminos.length; i++) {
            for (int j = 0; j < this.caminos[0].length; j++) {
                
                if(i!=j){
                    
                    Ciudad[] ciudadesEnlazadas = new Ciudad[2];
                    ciudadesEnlazadas[0]=this.ciudadesDisponibles[i];
                    ciudadesEnlazadas[1]=this.ciudadesDisponibles[j];
                    this.caminos[i][j]=new Camino(matrizDistancias[i][j],matrizFeromonas[i][j],ciudadesEnlazadas,0);
                    this.caminos[i][j].ciudadesEnlazadas= ciudadesEnlazadas;
                } else {
                    this.caminos[i][j]=null;
                }
                
            }
        }
    }
    
    public Ciudad elegirCiudadProbable(Hormiga H, int cantH, Grafo g){
        double sumaProb=0;
        Ciudad[] ciudadesDisponibles = ciudadesDisponibles(H);
        Probabilidad[] prob = new Probabilidad[ciudadesDisponibles.length];
        
        // A cada probabilidad, se le asigna una ciudad disponible.
        for (int i = 0; i < prob.length; i++) {
            prob[i]= new Probabilidad(ciudadesDisponibles[i]);
        }
        // Se le asigna el valor de la probabilidad a cada probabilidad y se actualiza la sumaProb
        for (int i = 0; i < prob.length; i++) {
            double base1 = (double)H.caminos[H.ciudadActual.numCiudad][prob[i].ciudad.numCiudad].cantFero;
            double exp1=  (double)H.valoresCalculo[0]; // Valor de alfa;
            double base2 = (double)Q/H.caminos[H.ciudadActual.numCiudad][prob[i].ciudad.numCiudad].distancia;
            double exp2=  (double)H.valoresCalculo[1]; // Valor de beta.
            prob[i].valorProb=(double)Math.pow(base1, exp1)*Math.pow(base2, exp2);
            sumaProb=(double)sumaProb+prob[i].valorProb;
        }
        
        double eleccion = Math.random();
        double Prob=0;
        double ProbAnt=0;
        Ciudad elegida = prob[0].ciudad; // Solo para inicializarlo.
        // Evalúa en qué rango de las probabilidades está el número aleatorio generado (eleccion).
        for (int i = 0; i < prob.length; i++) {
            ProbAnt=Prob;
            Prob=Prob+(prob[i].valorProb/sumaProb);
            if(ProbAnt<eleccion && eleccion<=Prob){
                elegida=prob[i].ciudad;
            }
        }
        actualizarFeromonas(H,cantH, elegida, g);
        return elegida;
    }
    
 
    public void disminuirFeromonas(Hormiga H, Grafo g){
        // Como ya sabe que esa distancia NO es la más corta, disminuye las feromonas de ese recorrido en un 60%.
        for (int i = 0; i < H.Recorrido.length-1; i++) {
                H.caminos[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad].cantFero=
                     (double)H.caminos[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad].cantFero*(double)0.4;
                H.caminos[H.Recorrido[i+1].numCiudad][H.Recorrido[i].numCiudad].cantFero=
                        H.caminos[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad].cantFero;
                g.matrizFeromonas[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad]=
                        H.caminos[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad].cantFero;
                g.matrizFeromonas[H.Recorrido[i+1].numCiudad][H.Recorrido[i].numCiudad]=
                        H.caminos[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad].cantFero;
            
        }
        
    }
    
    public void resetearFeromonas(Hormiga H, Grafo g){
        double max=0;
        for (int i = 0; i < g.matrizFeromonas.length; i++) {
            for (int j = 0; j < g.matrizFeromonas[0].length; j++) {
                if(g.matrizFeromonas[i][j]>max){
                    max=g.matrizFeromonas[i][j];
                }
            }
        }
        
        for (int i = 0; i < H.Recorrido.length-1; i++) {
            g.matrizFeromonas[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad]=(double)max*1.30;
            g.matrizFeromonas[H.Recorrido[i+1].numCiudad][H.Recorrido[i].numCiudad]=(double)max*1.30;
            H.caminos[H.Recorrido[i].numCiudad][H.Recorrido[i+1].numCiudad].cantFero=(double)max*1.30;
            H.caminos[H.Recorrido[i+1].numCiudad][H.Recorrido[i].numCiudad].cantFero=(double)max*1.30;
        }
        
    }
    
    public void aumentarFeromonas(Hormiga H, Grafo g, double porcentajeAumento){

        for (int i = 0; i < g.matrizFeromonas.length; i++) {
            for (int j = 0; j < g.matrizFeromonas[0].length; j++) {
                if(i!=j){
                    for (int k = 0; k < H.Recorrido.length-1; k++) {
                        if(i==H.Recorrido[k].numCiudad && j==H.Recorrido[k+1].numCiudad){
                            g.matrizFeromonas[i][j]=(double)g.matrizFeromonas[i][j]*porcentajeAumento;
                            g.matrizFeromonas[j][i]=(double)g.matrizFeromonas[j][i]*porcentajeAumento;
                        }
                    }
                    H.caminos[i][j].cantFero=g.matrizFeromonas[i][j];
                }
            }
        
    }
    
}
}
