import service.ManagerFile;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String ruta = "D:\\DOCENCIA\\ICEI\\JAVA PROGRAMADOR\\Módulo IV\\Archivos\\";
        File archivo = new File(ruta + "test_jko.txt");
        try {
            //ejemplo.createNewFile(); // Crear un archivo en una ruta espécifica
            // System.out.println("Archivo creado :)");
            System.out.println("¿El archivo existe? --> " + archivo.exists());
            if(archivo.exists()){
                System.out.println("====== DATOS DEL ARCHIVO ======");
                System.out.println("Nombre de archivo: " + archivo.getName());
                System.out.println("Tamaño del archivo: " + archivo.length());
                System.out.println("¿Es directorio? --> " + archivo.isDirectory());
                System.out.println("¿Es archivo? --> " + archivo.isFile());
                Date fechaModificacion = new Date(archivo.lastModified());
                System.out.println("Fecha última modificación: " + fechaModificacion);
                System.out.println("Directorio padre: " + archivo.getParent());
                System.out.println("¿Puede leer? --> " + archivo.canRead());
                System.out.println("¿Puede escribir? --> " + archivo.canRead());
                System.out.println("¿Puede ejecutar? --> " + archivo.canRead());
                System.out.println("Ruta absoluta --> " + archivo.getAbsolutePath());
                //System.out.println("¿Eliminar archivo? --> " + archivo.delete());

                System.out.println("Contenido del archivo ... ");
                ManagerFile.leerArchivo("", archivo.getName());
            }
        } catch (Exception e) {
            System.out.println("Error al acceder al archivo :(");
        }

    }
}
