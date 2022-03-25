
package actividad04apg;

import java.io.*;


public class pregunta {
        
       
        
        String sepAPG = File.separator;
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + sepAPG + "CarpetaAPG";
        File carpetaAPG = new File(rutaCarpeta);
    
    public static int pideEntero(String preguntaenteroAPG) throws IOException { // Esta funcion es la que utilizaremos para pedir los valores enteros.
       
      int pideentero = 0;
      
      do{ 
          System.out.println(preguntaenteroAPG);
       try{   
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );  
       pideentero = Integer.parseInt(br.readLine());
       
       break;
       
       }catch (Exception e){
            System.out.println("Solo caracteres numericos");
       }
      
      } while(true);
      return pideentero; 
    }
    
    public static int pidevalor(int valorminimo, int valormaximo)  {
     int valorAPG = 0;
     
      do{
          try{
          valorAPG = pideEntero("\nIntroduce un valor entre " + valorminimo + " y " + valormaximo);
           }catch (IOException e){
                   System.out.println("\nSolo caracteres numericos\n"); } 
         
          
            if((valorAPG < valorminimo  || valorAPG > valormaximo )){
              System.out.println("\nEl valor introducido es: "+ valorAPG +"\nLa opcion de menu no es correcta!!!\n");               
          }
      
      }while  ((valorAPG < valorminimo  || valorAPG > valormaximo ));
      
    
    
    return valorAPG;
    }
    
    
    public static void creararchivo(File carpetaAPG,String rutaCarpeta,String sepAPG) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ); 
        
        String nombreAPG;
        String textoAPG;
        
        
        if (!carpetaAPG.exists()){
           if(carpetaAPG.mkdir()){
               System.out.println("Directorio creado");
           }
         }
        
        FileWriter fw;
        
        System.out.println("\nIntroduce el nombre del archivo: ");
        
        nombreAPG = br.readLine();
        
        System.out.println("\nIntroduce el texto: ");
        
        textoAPG = br.readLine();
        
        fw = new FileWriter(rutaCarpeta + sepAPG + nombreAPG);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(textoAPG);
        bw.flush();
        bw.close();
        
        
        
        
        
        
        
    }
    
    public static String[] listarArchivos(File carpetaAPG,String rutaCarpeta,String sepAPG){
       
        
            int u =0;
        
            String [] controlAPG = carpetaAPG.list();
            
            for (int l = 0 ;l < controlAPG.length ; l++){
            
            File documentosAPG = new File(carpetaAPG + sepAPG + controlAPG[l]);
            if (documentosAPG.isFile()){
            System.out.println("\n"+ u++ + " " + controlAPG[l]);}
            
        }
         
        return controlAPG;  
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void muestraContenido(File carpetaAPG,String rutaCarpeta,String sepAPG) throws FileNotFoundException, IOException { 
       
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );  
        String textoAPG;
        String [] validar = listarArchivos(carpetaAPG,rutaCarpeta,sepAPG);
                    
     
        if (!carpetaAPG.exists()){
           carpetaAPG.mkdir();
               System.out.println("Directorio creado\n"); 
         }
     
        String [] mostraAPG = carpetaAPG.list();
       
	FileReader fr; 
      
        int numZ = pregunta.pidevalor(0,validar.length -1);
          
        fr = new FileReader(rutaCarpeta + sepAPG + mostraAPG[numZ]);
        
        BufferedReader bt = new BufferedReader(fr);
        
        
        File gerona = new File(rutaCarpeta + sepAPG + mostraAPG[numZ]);
        
        if(archivoVacio(gerona) == true){
            System.out.println("\nEl archivo esta vacio");
        }else{
         while((textoAPG = bt.readLine())!=null){
                System.out.println(textoAPG);}
        }
        
           
        bt.close();
        }
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public static boolean archivoVacio(File c) throws IOException {
        
      BufferedReader br = new BufferedReader(new FileReader(c));
      
      return br.readLine() == null;
      
        }
    
    public static void borrar(File carpetaAPG,String rutaCarpeta,String sepAPG) throws IOException {
        
        String nombreAPG;
        
        
        if (!carpetaAPG.exists()){
           carpetaAPG.mkdir();
               System.out.println("Directorio creado\n");
           
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );   
            
        System.out.println("Introduce el nombre del archivo que quieres borrar:\n\n");
       
        nombreAPG = br.readLine();
        
        File gerona = new File(rutaCarpeta + sepAPG + nombreAPG);
        
        gerona.delete();
        
    }
    
    public static void renombrar(File carpetaAPG,String rutaCarpeta,String sepAPG) throws IOException{
        String [] validar = listarArchivos(carpetaAPG,rutaCarpeta,sepAPG);
        String nuevoN;
        int z = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );   
        
      
         if (!carpetaAPG.exists()){
           carpetaAPG.mkdir();
               System.out.println("Directorio creado\n");
           
         }  
        
        FileReader fr;
        
        System.out.println("Elige el archivo que quieres renombrar:\n");
        
        String [] mostrarAPG = carpetaAPG.list();
        
        int numZ = pregunta.pidevalor(0,validar.length -1);
          
          
        System.out.println("\nIntroduce el nuevo nombre:\n");
        
        nuevoN = br.readLine();
           
        
        fr = new FileReader(rutaCarpeta +sepAPG + mostrarAPG[numZ]);
        
        File apgantiguo = new File (rutaCarpeta +sepAPG + mostrarAPG[numZ]);
        File apgnuevo = new File (rutaCarpeta +sepAPG + nuevoN);
        
        fr.close();
        
        if(apgantiguo.renameTo(apgnuevo)){
            
            System.out.println("\nArchivo copidado correctamente");
        }else {
            System.out.println("\nOperacion fallida");
        }
          
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void modificarValor(File carpetaAPG,String rutaCarpeta,String sepAPG) throws IOException{
        
        String archivoAPG[] = listarArchivos(carpetaAPG,rutaCarpeta,sepAPG);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
      
        System.out.println("Elige la posicion del archivo que quieres cambiar:\n");
        
        int numZ = pregunta.pidevalor(0,archivoAPG.length -1);
          
        File directorioAPG = new File (carpetaAPG+sepAPG+archivoAPG[numZ]);
           
        String remplazar,buscar; 
        
        do{
            
            System.out.println("Indica el caracter a remplazar:\n");
            
            buscar = br.readLine();
               
        }while (buscar.length()!=1);
        
        do {
            
            System.out.println("Indica el nuevo valor del caracter:\n");
            
            remplazar = br.readLine();
            
            
        }while (remplazar.length() !=1);
        
        RandomAccessFile raf = new RandomAccessFile(directorioAPG,"rw");
        
        while(raf.getFilePointer() < raf.length()){
            Character chr = (char)raf.readByte();
            if(chr.toString().compareTo(buscar) == -1){
                
                raf.seek(raf.getFilePointer()-1);
                raf.writeBytes(remplazar);
            }
            
         raf.close();
        }
        
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void validacion(String[]mostraAPG,int z){
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );  
     
         do{    
        System.out.println("\nIntroduce el numero de su posicion:\n");  
        
        try{
        z = Integer.parseInt( br.readLine());
        }catch(Exception e){
            System.out.println("\nSolo Numeros");
            z = -1;
        }
           if((z < 0) || (z > mostraAPG.length -1)){
               System.out.println("\n          ¡¡¡WARNING!!!"
                       + "\nSolo acepta el numero de la posicion\n");
           }
        }while((z < 0)||(z > mostraAPG.length -1));
         
        
         }
         
    
    }


      