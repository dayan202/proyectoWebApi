/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebawebwar.controller;

import com.mycompany.pruebawebwar.Dto.EstudianteDto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */

@Stateless
@Path("/estudiantes")
public class EstudianteController {
    
    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public int[] obtener(){
        int[] vector = {1, 2, 3, 4, 5};
        return vector;
    }
    
    @GET                                                                   /////LISTA ESTUDIANTES//////////
    @Path("/obtenerListaPorSemestre/{semestre}/{genero}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> obtenerLista(   @PathParam("semestre") String semestre,
                                        @PathParam("genero") String genero) throws FileNotFoundException, IOException{
        System.out.println(semestre + " " + genero);
        List<String> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add("Johans");
        listaEstudiantes.add("Andrea");
        listaEstudiantes.add("Juan");
       

        return listaEstudiantes;
    }   
    
    @GET                                                          ////////////////OBTENER ESTUDIANTE Y GUARDAR INFORMACION//////
    @Path("/obtenerGson")                                  
    @Produces(MediaType.APPLICATION_JSON)
    public EstudianteDto obtenerGson(){
        List<String> listaMateria = new ArrayList<>();
        listaMateria.add("Programacion I");
        listaMateria.add("Auditoria");
        listaMateria.add("SI");
        int[] vector = {1, 2, 3, 4};
        EstudianteDto ob = new EstudianteDto("1070", "Johans",  "Gonzalez", 25, "johans-123@hotmail.com", listaMateria, vector);
        EstudianteDto ob2 = new EstudianteDto("22222", "Martha",  "Villamizar", 35, "leidy-222@hotmail.com", listaMateria, vector);
       
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\estudiantes.txt"))){
            //Escribimos en un fichero
            oos.writeObject(ob);
            oos.writeObject(ob2);
        }catch(IOException e){
        }      
        
        return ob2;
    }

    
     @POST                                    ///////////////INSERTAR CEDULA////////////////////////////////
    @Path("/insertarCedula")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)    ///se habilita en caso de retornar informacion
    public void insertarCedula(EstudianteDto obj2){
        System.out.println("Registrado correctamente " + obj2.getCedula());
        //return listaEstudiantes;
    }
                                            
                                             ///////////////INSERTAR CEDULA///////////////////////////////
    
    @POST
    @Path("/insertarPrueba")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON) 
    public void insertarPrueba(EstudianteDto estudaiante){
        System.out.println("Registrado correctamente " + estudaiante.getNombre());
        //return listaEstudiantes;
    }
    
    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON) 
    public void insertar(EstudianteDto estudaiante){
        System.out.println("Registrado correctamente"  + estudaiante.getNombre());
        //return listaEstudiantes;
    }  
    
    
    
    
                                  /////////////////////EDITAR CEDULA////////////////////////////////////
    
    
    
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON) 
    public void editar(List<String> listaEstudiantes){
        for (String le : listaEstudiantes) {
            System.out.println(le);
        }
        System.out.println("Registrado editado correctamente");
        //return listaEstudiantes;
    }   
      
    @DELETE
    @Path("/eliminarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void elminarPorId(   @PathParam("id") int id){
        System.out.println(id);
    } 
    
    
    
    
    
    
}