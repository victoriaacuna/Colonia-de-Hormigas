
package Algoritmo;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Archivo {
    
    static FileInputStream entrada;
    static FileOutputStream salida;
    static File archivo;
    
    public Archivo(){
        
    }
    
    public static void GuardarTexto(File archivo, String contenido){
        
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            JOptionPane.showMessageDialog(null, "Se guardó el archivo con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public String AbrirTexto(File archivo){
        String contenido="";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!= -1){
                char carcater = (char)ascci;
                contenido += carcater;
            }
        } catch (Exception e) {
        }
        return contenido;
    }
    
    public static boolean archivoValido(File archivo){
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            if(br.readLine().contains("Nombre de las ciudades:")){
                return true;
            } 
        } catch (Exception e) {
        }
        return false;
    }
    
    public static int numCiudades(File archivo){
    int cont =0;
        boolean encontrado=false, terminado=false;
        String linea="";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            while (!encontrado&&(linea= br.readLine())!=null) {
                if(linea.contains("Nombre de las ciudades:")&&(linea= br.readLine())!=null) {
                    encontrado=true;
                    while(!terminado&&(linea= br.readLine())!=null){
                        if(linea.contains("Distancia entre las ciudades:")&&(linea= br.readLine())!=null){
                            terminado=true;
                        } else {
                            cont++;
                        }
                    }
                }
            }
            return cont;
        } catch(Exception e){
            return 0;
        }    
}
    
    public static String[] ciudadesDelArchivo(File archivo, String[] ciudades){
        int cont =0;
        boolean encontrado=false, terminado=false;
        String linea="";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            int i=0;
            
            while (!encontrado&&(linea= br.readLine())!=null) {
                    if(linea.contains("Nombre de las ciudades:")&&(linea= br.readLine())!=null) {
                        encontrado=true;
                        ciudades[i]=linea;
                        i++;
                        while(!terminado&&(linea= br.readLine())!=null&&i<ciudades.length){
                            if(linea.contains("Distancia entre las ciudades:")&&(linea= br.readLine())!=null){
                                terminado=true;
                            } else {
                                ciudades[i]=linea;
                                i++;
                            }
                        }
                    }
                }
            return ciudades;
            
            
        } catch (Exception e) {
            return null;
        }
         
    }
    
    public static int[][] distanciasCiudades(int cantCiudades, File archivo){
        
        int[][] matrizDistancias = new int[cantCiudades][cantCiudades];
       
        boolean encontrado=false, terminado=false;
        String linea="";
        int i=0, j=0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            linea=br.readLine();
            while (!encontrado&&linea!=null) {
                if(linea.contains("Distancia entre las ciudades:")){
                    encontrado=true;
                    linea=br.readLine();
                    while(i<matrizDistancias.length&&linea!=null&&!terminado){
                        if(linea.contains("Datos de la simulacion:")){
                            terminado=true;
                        } else {
                            if(linea.contains("(km)")){
                                if(i==j){
                                    matrizDistancias[i][j]=0;
                                    
                                    if(j==(matrizDistancias[0].length-1)){
                                        j=0;
                                        i++;
                                    } else {
                                        j++;
                                    }
                                    linea=br.readLine();
                                    matrizDistancias[i][j]=Integer.parseInt(linea);
                                    if(j==(matrizDistancias[0].length-1)){
                                        j=0;
                                        i++;
                                    } else {
                                        j++;
                                    }
                                    
                                } else {
                                linea=br.readLine();
                                matrizDistancias[i][j]=Integer.parseInt(linea);
                                if(j==(matrizDistancias[0].length-1)){
                                    j=0;
                                    i++;
                                } else {
                                    j++;
                                }
                                }
                                
                            }
                        }
                        linea=br.readLine();
                    }
                }
                linea=br.readLine();
            }
            return matrizDistancias;
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static double[] valoresCalculos(File archivo, double[] valoresCalculos){
        
        
        boolean encontrado=false;
        String linea="";
        int i=0;
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            linea=br.readLine();
            while (!encontrado&&linea!=null) {
                if(linea.contains("Grado de importancia de la feromona:")){
                    encontrado=true;
                    while(i<valoresCalculos.length&&linea!=null){
                            if(linea.contains(":")){
                                linea=br.readLine();
                                valoresCalculos[i]=Double.parseDouble(linea);
                                i++;
                            }
                        linea=br.readLine();
                    }
                }
                linea=br.readLine();
            }
            
        } catch (Exception e) {
            
        }
        return valoresCalculos;
    }
    
    public static int[] datosSimulacion(File archivo, int[] datosSimulacion){
        boolean encontrado=false;
        String linea="";
        int i=0;
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
            linea=br.readLine();
            while (!encontrado&&linea!=null) {
                if(linea.contains("Datos de la simulacion:")){
                    encontrado=true;
                    linea=br.readLine();
                    while(i<datosSimulacion.length&&linea!=null){
                            if(linea.contains(":")){
                                linea=br.readLine();
                                datosSimulacion[i]=Integer.parseInt(linea);
                                i++;
                            }
                        linea=br.readLine();
                    }
                }
                linea=br.readLine();
            }
            
        } catch (Exception e) {
            
        }
        return datosSimulacion;
    }
    
    }
        
    

