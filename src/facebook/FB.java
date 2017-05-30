/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class FB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CaraLibro obj = new CaraLibro();
        int select;
        do{
            select = Integer.parseInt(JOptionPane.showInputDialog("1: Postear.\n2: Postear imagen.\n3:Comentar. \n4:Buscar\n5:Comentar foto\n6:Like"));
            switch(select){
                case 1: obj.publicar(JOptionPane.showInputDialog("Tú post"));
                        break;
                case 2: obj.postImagen(JOptionPane.showInputDialog("Ruta"), JOptionPane.showInputDialog("Nombre"), JOptionPane.showInputDialog("Título"), JOptionPane.showInputDialog("Descripción"));
                        break;
                case 3: obj.comentarPost(JOptionPane.showInputDialog("Post"), JOptionPane.showInputDialog("Comentario"));
                        break;
                case 4: obj.buscarPosts(JOptionPane.showInputDialog("Palabra clave"));
                        break;
                case 5: obj.comentarFoto(JOptionPane.showInputDialog("Ruta"), JOptionPane.showInputDialog("Comentario"));
                        break;
                case 6: obj.darLike();
                        break;
            }
        }while(select!=0);
    }
    
}
