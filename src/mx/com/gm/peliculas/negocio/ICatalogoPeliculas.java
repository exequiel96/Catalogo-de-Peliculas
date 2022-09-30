package mx.com.gm.peliculas.negocio;
//contiene las operaciones necesarias de la aplicacion CatalogoPeliculas
public interface ICatalogoPeliculas {
    String NOMBRE_ARCHIVO= "peliculas.txt";
    void agregarPelicula (String nombrePelicula);
    void listarPeliculas ();
    void buscarPelicula (String buscar);
    void iniciarArchivo ();
}
