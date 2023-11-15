import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
 
public class LeerArchivoObjeto {
    public static void main(String[] args) {
        String nombreArchivo = "objeto.dat";
        try {
            FileInputStream fileInput = new FileInputStream(nombreArchivo);
            ObjectInputStream entrada = new ObjectInputStream(fileInput);
 
            // Leer el ArrayList de mascotas desde el archivo
            ArrayList<Mascota> listaMascotas = (ArrayList<Mascota>) entrada.readObject();
 
            // Cerrar el flujo
            entrada.close();
 
            // Recorrer y mostrar las mascotas
            for (Mascota mascota : listaMascotas) {
                System.out.println("Nombre: " + mascota.getNombre());
                System.out.println("Edad: " + mascota.getEdad());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}