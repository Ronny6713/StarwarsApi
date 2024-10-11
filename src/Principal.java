import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println(consulta);
        System.out.println("ingrese numero pelicula");
        try {
            var numeroDePelicula = Integer.valueOf(teclado.nextLine());
            Peliculas peliculas = consulta.buscarPelicula(numeroDePelicula);
            System.out.println(peliculas);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(peliculas);
        }catch (NumberFormatException e){
            System.out.println("Número no encontrado"+e.getMessage());
        } catch (RuntimeException | IOException e){
            System.out.println("Finalizando la aplicacion");
        }
    }
}
