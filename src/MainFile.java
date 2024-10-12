import service.ManagerFile;

import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String rutaAD = "";
        boolean seguir = true;
        do {
            System.out.println("=====  MENU ARCHIVO  =====");
            System.out.println("1. Crear archivo");
            System.out.println("2. Crear directorio");
            System.out.println("3. Verificar si el archivo existe");
            System.out.println("4. Obtener directorio actual");
            System.out.println("5. Listar archivos");
            System.out.println("6. Ir a directorio");
            System.out.println("7. Escribir contenido (FileWriter)");
            System.out.println("8. Escribir contenido (FileOutputStream)");
            System.out.println("9. Escribir contenido (BufferedWriter)");
            System.out.println("10. Leer contenido (Scanner)");
            System.out.println("11. Leer contenido (FileReader)");
            System.out.println("12. Leer contenido (FileInputStream)");
            System.out.println("13. Leer contenido (BufferedReader)");
            System.out.println("14. Salir");

            System.out.print("Opción: ");
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de archivo (con extensión): ");
                    String nombreArchivo = teclado.nextLine();
                    System.out.println("Respuesta --> " + ManagerFile.crearArchivo(nombreArchivo, rutaAD));
                    break;
                case 2:
                    System.out.print("Nombre de carpeta o directorio: ");
                    String directorio = teclado.nextLine();
                    System.out.println("Respuesta --> " + ManagerFile.crearCarpeta(directorio, rutaAD));
                    break;
                case 3:
                    System.out.print("Nombre de archivo/directorio: ");
                    String nombreArchivoDirectorio = teclado.nextLine();
                    System.out.println("Respuesta --> " + ManagerFile.existeArchivo(nombreArchivoDirectorio));
                    break;
                case 4:
                    System.out.print("Nombre de archivo/directorio: ");
                    String nombre = teclado.nextLine();
                    rutaAD = ManagerFile.retornarDirectorio(rutaAD, nombre);
                    System.out.println("Directorio actual --> " + rutaAD);
                    break;
                case 5:
                    System.out.print("Nombre de archivo/directorio: ");
                    String nombreRuta = teclado.nextLine();
                    rutaAD = ManagerFile.retornarDirectorio(rutaAD, nombreRuta);
                    ManagerFile.listarArchivos(rutaAD);
                    System.out.println("-> " + rutaAD);
                    break;
                case 6:
                    System.out.print("Nombre de directorio: ");
                    String nombreDir = teclado.nextLine();
                    rutaAD = ManagerFile.retornarDirectorio(rutaAD, nombreDir);
                    System.out.println("-> " + rutaAD);
                    break;
                case 7:
                    System.out.print("Nombre de archivo a escribir: ");
                    String nombreArchivoWriter = teclado.nextLine();
                    System.out.print("Contenido: ");
                    String contenidoFW = teclado.nextLine();
                    System.out.println("Respuesta --> " + ManagerFile.escribrirFW(rutaAD, nombreArchivoWriter, contenidoFW));
                    break;
                case 8:
                    System.out.print("Nombre de archivo a escribir: ");
                    String nombreArchivoFOS = teclado.nextLine();
                    System.out.print("Contenido: ");
                    String contenidoFOS = teclado.nextLine();
                    System.out.println("Respuesta --> " + ManagerFile.escribrirFOS(nombreArchivoFOS, contenidoFOS));
                    break;
                case 9:
                    System.out.print("Nombre de archivo a escribir: ");
                    String nombreArchivoBW = teclado.nextLine();
                    System.out.print("Contenido: ");
                    String contenidoBW = teclado.nextLine();
                    System.out.println("Respuesta --> " + ManagerFile.escribrirBW(nombreArchivoBW, contenidoBW));
                    break;
                case 10:
                    System.out.print("Nombre de archivo a leer: ");
                    String nombreArchivoScanner = teclado.nextLine();
                    ManagerFile.leerArchivo(rutaAD, nombreArchivoScanner);
                    break;
                case 11:
                    System.out.print("Nombre de archivo a leer: ");
                    String nombreArchivoFR = teclado.nextLine();
                    ManagerFile.leerArchivoFR(nombreArchivoFR);
                    break;
                case 12:
                    System.out.print("Nombre de archivo a leer: ");
                    String nombreArchivoFIS = teclado.nextLine();
                    ManagerFile.leerArchivoFIS(nombreArchivoFIS);
                    break;
                case 13:
                    System.out.print("Nombre de archivo a leer: ");
                    String nombreArchivoBR = teclado.nextLine();
                    ManagerFile.leerArchivoBR(nombreArchivoBR);
                    break;
            }
            System.out.println("Dir. Actual --> " + rutaAD);
            seguir = opcion != 14;
        } while (seguir);
    }
}
