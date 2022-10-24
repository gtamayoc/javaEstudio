/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaces;

import interfaces.modelos.PeliculaTO;
import interfaces.modelos.peliculas;
import java.util.List;

/**
 *
 * @author WPOSS
 */
public class Interfaces implements peliculas {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       //interfacePrueba();
    }

    private static void interfacePrueba() {
       Interfaces interfacess = new Interfaces();
       PeliculaTO peliculas = new PeliculaTO();
       peliculas.setId(0);
       peliculas.setNombre ("FastFood");
       peliculas.setCalificacion("5.5");
       peliculas.setDescripcion("The Best Pelicula");
       interfacess.addPelicula(peliculas);
    }

    
    
    @Override
    public void addPelicula(PeliculaTO p) {
        System.out.println("Pelicula : "+ p.getNombre());
    }

    @Override
    public void delPelicula(int idPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PeliculaTO> getAllPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
