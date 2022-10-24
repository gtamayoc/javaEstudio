/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.modelos;

import java.util.List;

/**
 *
 * @author WPOSS
 */
public interface peliculas {
    void addPelicula(PeliculaTO p);
    void delPelicula(int idPelicula);
    List<PeliculaTO> getAllPeliculas();

}
