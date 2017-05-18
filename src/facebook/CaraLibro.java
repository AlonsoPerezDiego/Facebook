/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Diego
 */
public class CaraLibro {
    static Facebook facebook ;
    /**
     * Account verification.
     */
    public void auntentificar(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthAppId("286026411838540")
        .setOAuthAppSecret("a399ca244cfd374831812d64d6568fad")
        .setOAuthAccessToken("EAAEEI7asjEwBAAoi6ZCdUJ7ibRHcdvwbCKzaZAeWT2qmmc7bY8OIdARrZAflbgjZC9JuEnb5C2Rty4riEBtdb8fwwALAgK62ZAJZCdGyrOiEjRtmrbcDJUMVarAxCvrEXx8E14ERSAc2kFI7hhvJLh2ElhACNdpEWYACMW6faZCiUZCQI8PFrG2egPxZBfRVRZA0MZD")
        .setOAuthPermissions("email,publish_stream,...");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
    
    /**
     * Posting.
     * @param coment 
     */
    public void publicar(String coment){
        try {
            facebook.postStatusMessage(coment);
        } catch (FacebookException ex) {
            System.out.println("Fodeuse."+ ex);
        }
    }
    
    /**
     * Posting an image.
     * @param imagen
     * @param nombre
     * @param titulo
     * @param descripcion 
     */
    public void postImagen(String imagen, String nombre, String titulo, String descripcion){
        try {
            PostUpdate post = new PostUpdate(new URL(imagen))
                    .picture(new URL(imagen))
                    .name(nombre)
                    .caption(titulo)
                    .description(descripcion);
            facebook.postFeed(post);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FacebookException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Coment a post.
     * @param post
     * @param comentario 
     */
    public void comentarPost(String post, String comentario){
        try {
            facebook.commentPost(post, comentario);
        } catch (FacebookException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Search for a post.
     * @param palabra 
     */
    public void buscarPosts(String palabra){
        try {
            ResponseList<Post> results = facebook.searchPosts(palabra);
        } catch (FacebookException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Coment a picture.
     * @param ruta
     * @param mensaje 
     */
    public void comentarFoto(String ruta, String mensaje){
        try {
            facebook.commentPhoto(ruta, mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Like a post.
     */
    public void darLike() {//doesn't work.
        try {
  
            facebook.likePost(facebook.getId());
        } catch (FacebookException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(CaraLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
