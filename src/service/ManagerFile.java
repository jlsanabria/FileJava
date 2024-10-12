package service;

import java.io.*;
import java.util.Scanner;

public final class ManagerFile {
    private static final String RUTA = "D:\\DOCENCIA\\ICEI\\JAVA PROGRAMADOR\\Módulo IV\\Archivos\\";

    /**
     * Method para crear nuevos archivos (files)
     */
    public static String crearArchivo(String nombre, String ruta) {
        ruta = ruta.isEmpty() ? RUTA : ruta + File.separator;
        String respuesta = "";
        File nuevoArchivo = new File(ruta + nombre);
        try {
            nuevoArchivo.createNewFile();
            respuesta = "Archivo creado :)";
        } catch (IOException e) {
            respuesta = "Error al crear el archivo :(";
        }
        return respuesta;
    }

    /**
     * Method para crear nuevos directorios (carpetas)
     */
    public static String crearCarpeta(String nombre, String ruta) {
        ruta = ruta.isEmpty() ? RUTA : ruta + File.separator;
        String respuesta = "";
        File nuevoDirectorio = new File(ruta + nombre);
        try {
            nuevoDirectorio.mkdir();
            respuesta = "Carpeta o directorio creado :)";
        } catch (Exception e) {
            respuesta = "Error al crear el directorio :(";
        }
        return respuesta;
    }

    public static String existeArchivo(String nombre) {
        String respuesta = "";
        File archivo = new File(RUTA + nombre);
        respuesta = archivo.exists() ? "Archivo existente :)" : "Archivo no existe :(";
        return respuesta;
    }

    public static String retornarDirectorio(String ruta, String nombre) {
        ruta = ruta.isEmpty() ? RUTA : ruta + File.separator;
        File archivo = new File(ruta + nombre);
        return archivo.exists() ? archivo.getAbsolutePath() : "Directorio no existe :(";
    }

    public static void listarArchivos(String ruta) {
        ruta = ruta.isEmpty() ? RUTA : ruta;
        File archivo = new File(ruta);
        File[] archivos = archivo.listFiles();
        for (int i = 0; i < archivos.length; i++) {
            String tipo = archivos[i].isDirectory() ? "d" : "a";
            System.out.println(tipo + "  " + archivos[i].getName());
        }
        System.out.println("-> "+ archivos.length + " archivo(s)");
    }

    /**
     * Escribir contenido con FileWriter
     *
     * @param nombre
     * @param contenido
     * @return
     */
    public static String escribrirFW(String ruta, String nombre, String contenido) {
        ruta = ruta.isEmpty() ? RUTA : ruta + File.separator;
        String respuesta = "";
        File archivo = new File(ruta + nombre);
        try {
            FileWriter writer = new FileWriter(archivo, true);
            writer.write(contenido + "\n");
            writer.flush();
            respuesta = "FileWriter --> contenido guardado con éxito :)";
        } catch (IOException e) {
            respuesta = "FileWriter --> no se pudo guardar el contenido :(";
        }
        return respuesta;
    }

    /**
     * Escribir contenido con FileOutputStream
     *
     * @param nombre
     * @param contenido
     * @return
     */
    public static String escribrirFOS(String nombre, String contenido) {
        String respuesta = "";
        File archivo = new File(RUTA + nombre);
        try {
            FileOutputStream fos = new FileOutputStream(archivo, true);
            fos.write((contenido + "\n").getBytes());
            fos.flush();
            respuesta = "FileOutputStream --> contenido guardado con éxito :)";
        } catch (IOException e) {
            respuesta = "FileOutputStream --> no se pudo guardar el contenido :(";
        }
        return respuesta;
    }

    /**
     * Escribir contenido con BufferedWriter
     *
     * @param nombre
     * @param contenido
     * @return
     */
    public static String escribrirBW(String nombre, String contenido) {
        String respuesta = "";
        File archivo = new File(RUTA + nombre);
        try {
            FileWriter fileWriter = new FileWriter(archivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(contenido + "\n");
            bufferedWriter.flush();
            respuesta = "BufferedWriter --> contenido guardado con éxito :)";
        } catch (IOException e) {
            respuesta = "BufferedWriter --> no se pudo guardar el contenido :(";
        }
        return respuesta;
    }

    /**
     * Método que permite leer el contenido de un archivo
     *
     * @param nombre
     */
    public static void leerArchivo(String ruta, String nombre) {
        ruta = ruta.isEmpty() ? RUTA : ruta + File.separator;
        String respuesta = "";
        File archivo = new File(ruta + nombre);
        try {
            System.out.println("-------- LEYENDO CONTENIDO CON SCANNER -----------");
            Scanner lineasArchivo = new Scanner(archivo);
            while (lineasArchivo.hasNextLine()) {
                System.out.println(lineasArchivo.nextLine());
            }
            System.out.println("---------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Leer con FileReader
     *
     * @param nombre
     */
    public static void leerArchivoFR(String nombre) {
        String respuesta = "";
        File archivo = new File(RUTA + nombre);
        try {
            System.out.println("-------- LEYENDO CONTENIDO CON FILE READER -----------");
            FileReader fileReader = new FileReader(archivo);
            int caracter;
            while((caracter = fileReader.read()) != -1) {
                System.out.print((char) caracter);
            }
            System.out.println("---------------------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Leer con FileInputStream
     *
     * @param nombre
     */
    public static void leerArchivoFIS(String nombre) {
        String respuesta = "";
        File archivo = new File(RUTA + nombre);
        try {
            System.out.println("-------- LEYENDO CONTENIDO CON FILE INPUT STREAM -----------");
            FileInputStream fis = new FileInputStream(archivo);
            String data = new String(fis.readAllBytes());
            System.out.println(data);
            System.out.println("---------------------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Leer con BufferedReader
     *
     * @param nombre
     */
    public static void leerArchivoBR(String nombre) {
        String respuesta = "";
        File archivo = new File(RUTA + nombre);
        try {
            System.out.println("-------- LEYENDO CONTENIDO CON BUFFERED READER -----------");
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("---------------------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
