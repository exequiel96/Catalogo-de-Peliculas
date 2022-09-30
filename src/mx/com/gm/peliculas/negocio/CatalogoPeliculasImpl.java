
package mx.com.gm.peliculas.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosExcepciones;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos= new AccesoDatosImpl();
        
    }
    

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula= new Pelicula(nombrePelicula);
        boolean anexar= false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosExcepciones ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
            
        }
       
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas= this.datos.listar(NOMBRE_ARCHIVO);
            for(var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosExcepciones ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado= null;
        try {
            resultado= this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (AccesoDatosExcepciones ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarArchivo() {
        try {
            if(this.datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }
            else{
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosExcepciones ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }
    
}
