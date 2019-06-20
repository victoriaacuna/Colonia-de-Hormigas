
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
    
    
    public void moverse(Hormiga H, int cantH, Grafo g){
        
        if(H.ciudadesRecorridas>H.ciudadesDisponibles.length){
            // IMPRIMIR Y PINTAR
            
            
        } else {
            if(H.ciudadesRecorridas==0){
            Random r = new Random();
                int random= r.nextInt(H.ciudadesDisponibles.length+1);
                H.primera=H.ciudadesDisponibles[random];
                H.ciudadActual=H.ciudadesDisponibles[random];
                H.ciudadesDisponibles[random].disponible=false;
                H.Recorrido= new Ciudad[H.ciudadesDisponibles.length+1];
                for (int i = 0; i < H.Recorrido.length; i++) {
                    H.Recorrido[i]= new Ciudad();
                }
                H.Recorrido[H.ciudadesRecorridas]=H.ciudadActual;
                H.ciudadesRecorridas++;
                
                System.out.println("Primera vez. Ciudad elegida: "+ H.ciudadActual.nombre);
                
                // RECURSIVIDAD
                moverse(H,cantH,g);
            } else if(H.ciudadesRecorridas<H.ciudadesDisponibles.length && H.ciudadesRecorridas>0){
                // Elige la ciudad;
                Ciudad elegida = elegirCiudad(H,cantH,g);
                // Actualiza la distancia recorrida.
                H.distRecorrida=H.distRecorrida + H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].distancia;
                // Actualiza el recorrdio.
                H.Recorrido[H.ciudadesRecorridas]=elegida; // El atributo ciudadesRecorridas es un contador;
                // Actualiza la cantidad de feromonas recorridas;
                H.cantFeroRecorridas= H.cantFeroRecorridas+H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
                // Actualiza el contador de las ciudades recorrdias;
                H.ciudadesRecorridas++;
                // Marca la ciudad a la que se movió como no disponible (ya visitada).
                H.ciudadesDisponibles[elegida.numCiudad].disponible=false;
                // Actualiza la ciudad actual en la que se encuentra la hormiga.
                H.ciudadActual=elegida;
                
                System.out.println("Ciudad elegida: " + H.ciudadActual.nombre);
                
                if(H.ciudadesRecorridas==H.ciudadesDisponibles.length-1){
                    H.ultima=elegida;
                }
                
                //RECURSIVIDAD.
                moverse(H,cantH,g);
            } else {
                Ciudad elegida = H.primera;
                //Actualizo el valor de las feromonas.
                actualizarFeromonas(H, cantH, elegida, g);
                H.distRecorrida=H.distRecorrida + H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].distancia;
                // Actualiza el recorrdio.
                H.Recorrido[H.ciudadesRecorridas]=elegida; // El atributo ciudadesRecorridas es un contador;
                // Actualiza la cantidad de feromonas recorridas;
                H.cantFeroRecorridas= H.cantFeroRecorridas+H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
                // Actualiza el contador de las ciudades recorrdias;
                H.ciudadesRecorridas++;
                // Marca la ciudad a la que se movió como no disponible (ya visitada).
                H.ciudadesDisponibles[elegida.numCiudad].disponible=false;
                // Actualiza la ciudad actual en la que se encuentra la hormiga.
                H.ciudadActual=elegida;
                
                System.out.println("Última. Ciudad elegida: " + H.ciudadActual.nombre);
                
                //RECURSIVIDAD.
                moverse(H,cantH,g);
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
            double base1 = H.caminos[H.ciudadActual.numCiudad][prob[i].ciudad.numCiudad].cantFero;
            double exp1=  H.valoresCalculo[0]; // Valor de alfa;
            double base2 = (Q/H.caminos[H.ciudadActual.numCiudad][prob[i].ciudad.numCiudad].distancia);
            double exp2=  H.valoresCalculo[1]; // Valor de beta.
            prob[i].valorProb=(Math.pow(base1, exp1)*Math.pow(base2, exp2));
            sumaProb=sumaProb+prob[i].valorProb;
        }
        double maxProb=0;
        Ciudad elegida = prob[0].ciudad; // Solo para inicializarlo.
        for (int i = 0; i < prob.length; i++) {
            if((prob[i].valorProb/sumaProb)>maxProb){
                maxProb=prob[i].valorProb/sumaProb;
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
        for (int i = 0; i < H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantHormigas; i++) {
            act= act + (Q/H.recorridoHPrev);
        }
        //Se actualizan las feromonas de los caminos desde la ciudad actual, hasta la elegida y de la elegida a la ciudad actual.
        H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero=
                H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero + act;
        H.caminos[elegida.numCiudad][H.ciudadActual.numCiudad].cantFero=
                H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
        // Se actualiza la matriz de feromonas del grafo.
        g.matrizFeromonas[H.ciudadActual.numCiudad][elegida.numCiudad]=
                H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
        g.matrizFeromonas[elegida.numCiudad][H.ciudadActual.numCiudad]=
                H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantFero;
        
        // Se actualiza la cantidad de hormigas que han pasado por ese camino.
        H.caminos[H.ciudadActual.numCiudad][elegida.numCiudad].cantHormigas++;
        H.caminos[elegida.numCiudad][H.ciudadActual.numCiudad].cantHormigas++;
        
    }
    
//    public void EvaporacionFeromonas(double ro, Hormiga ultima){
//        // Actualiza las feromonas de todos los caminos para empezar la nueva iteración.
//        for (int i = 0; i < ultima.caminos.length; i++) {
//            for (int j = 0; j < ultima.caminos[0].length; j++) {
//                ultima.caminos[i][j].cantFero=((1-ro)*ultima.caminos[i][j].cantFero);
//            }
//        }
//    }
    
    public void EvaporacionFeromonas(Grafo g){
        int ro=g.datosSimulacion[2];
        // Actualiza las feromonas de todos los caminos para empezar la nueva iteración.
        for (int i = 0; i < g.matrizFeromonas.length; i++) {
            for (int j = 0; j < g.matrizFeromonas[0].length; j++) {
                g.matrizFeromonas[i][j]=((1-ro)*g.matrizFeromonas[i][j]);
            }
        }
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
                    
//                    // Le asigna la distancia entre el camino de la ciudad i a la j.
//                    this.caminos[i][j].distancia=matrizDistancias[i][j];
//                    // La cantidad de hormigas que han pasado por ese camino inicialmente es cero.
//                    this.caminos[i][j].cantHormigas=0;
//                    //Le asigna la cantidad de feromonas en dicho camino.
//                    this.caminos[i][j].cantFero=matrizFeromonas[i][j];
//                    // Crea un vector ciudad que guarda las ciudades que están enlazadas.
                    
                    this.caminos[i][j].ciudadesEnlazadas= ciudadesEnlazadas;
                } else {
                    this.caminos[i][j]=null;
                }
                
            }
        }
    }
    
}
