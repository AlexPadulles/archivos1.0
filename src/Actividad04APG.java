
package actividad04apg;

import static actividad04apg.pregunta.*;
import java.io.*;


public class Actividad04APG {

     

    public static void main(String[] args) throws IOException {
        
        String sepAPG = File.separator;
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + sepAPG + "CarpetaAPG";
        File carpetaAPG = new File(rutaCarpeta);
        
       
        int optionAPG = 0;
        
        
        do {
            
            System.out.println("\n Elige la opcion que quieras");
            System.out.println("\n 1. Nuevo archivo");
            System.out.println("\n 2. Listar archivos");
            System.out.println("\n 3. Muestra un archivo");
            System.out.println("\n 4. Borrar un archivo");
            System.out.println("\n 5. Renombrar un archivo");
            System.out.println("\n 6. Modificar un archivo");
            System.out.println("\n 7. Salir\n");
           
            
            optionAPG = pidevalor(1,7);
            
            
            switch (optionAPG){
                
                
                case 1:
                    
                  creararchivo(carpetaAPG,rutaCarpeta,sepAPG);
                    
                break;
                
                case 2:
                  
                  listarArchivos(carpetaAPG,rutaCarpeta,sepAPG);
                    
                break;
                 
                case 3:
                    
                  muestraContenido(carpetaAPG,rutaCarpeta,sepAPG);
                    
                break;
                
                case 4:
                    
                  borrar(carpetaAPG,rutaCarpeta,sepAPG);
                    
                break;
                 
                case 5:
                    
                  renombrar(carpetaAPG,rutaCarpeta,sepAPG);
                    
                break;
                
                case 6:
                    
                   modificarValor(carpetaAPG,rutaCarpeta,sepAPG);
                    
                break;
                
                case 7:
                    
                    System.out.println("\nFin del programa\n");
                    
                    
                break;   
                
                
                
                
            }                
                 
                  
        }while( optionAPG != 7);
        
        
         
        
    }
    
}

