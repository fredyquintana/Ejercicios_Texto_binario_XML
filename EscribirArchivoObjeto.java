import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
 
// Definición de la clase Mascota
class Mascota implements Serializable {
    private String nombre;
    private int edad;
 
    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
 
public class EscribirArchivoObjeto {
    public static void main(String[] args) {
        String nombreArchivo = "objeto.dat";
        try {
            FileOutputStream fileOutput = new FileOutputStream(nombreArchivo);
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
 
            // Crear un ArrayList para guardar las mascotas
            ArrayList<Mascota> listaMascotas = new ArrayList<>();
 
            // Agregar 10 mascotas al ArrayList
            listaMascotas.add(new Mascota("Hercules", 2));
            listaMascotas.add(new Mascota("Fer", 3));
            listaMascotas.add(new Mascota("Zor", 4));
            listaMascotas.add(new Mascota("Perry", 5));
            listaMascotas.add(new Mascota("Shira", 6));
            listaMascotas.add(new Mascota("Shelby", 7));
            listaMascotas.add(new Mascota("Dinan", 8));
            listaMascotas.add(new Mascota("Pelusa", 9));
            listaMascotas.add(new Mascota("Roki", 10));
            listaMascotas.add(new Mascota("Lycha", 11));
 
            // Escribir el ArrayList de mascotas en el archivo
            salida.writeObject(listaMascotas);
 
            // Cerrar el flujo
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}