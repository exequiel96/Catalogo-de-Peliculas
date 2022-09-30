package mx.com.gm.peliculas.datos;
//definie la forma en que se interacta con el archivo donde se almacenara la informacion

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosExcepciones;

    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosExcepciones;

    void borrar(String nombreArchivo) throws AccesoDatosExcepciones;

}
