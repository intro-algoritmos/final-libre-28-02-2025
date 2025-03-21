import java.util.ArrayList;

/**
 * La clase NewsFeed almacena posts de noticias de una red social.
 * 
 * El estado del newsfeed consta de una lista de todos los posts de mensajes 
 * (objetos de tipo MessagePost). La lista está ordenada por timestamp. 
 * 
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class NewsFeed
{
    
    // posts del newsfeed
    private ArrayList<MessagePost> messages;

    /**
     * Construye un newsfeed vacío
     */
    public NewsFeed()
    {
        messages = new ArrayList<>();
    }

    /**
     * Añade un mensaje de texto al newsfeed. El mensaje a agregar
     * se ubica en la lista de mensajes de manera ordenada por timestamp. El 
     * mensaje no puede ser nulo, debe satisfacer su respectivo invariante,
     * y no debe existir en la lista otro mensaje con el mismo timestamp.
     * 
     * @param text es el mensaje de texto a agregar.
     */
    public void addMessagePost(MessagePost message)
    {
        //TODO implementar este método, incluyendo chequeo de precondición.
        if(message==null){
            throw new IllegalArgumentException("el mensaje no debe ser nulo");
        }
        if(!message.repOK()){
            throw new IllegalArgumentException("el mensaje debe sastifacer su invariante");
        }
        for(MessagePost mensaje:messages){
            if(mensaje.getTimeStamp() == message.getTimeStamp()){
                throw new IllegalArgumentException("ya hay un mensaje con ese timestamp");
            }
        }
        messages.add(message); // error. No mantiene orden respecto al timestamp.
        System.out.println("nuevo mensaje: "+messages); // innecesario
    }


    /**
     * Elimina de la lista de mensajes todos los posts de un username determinado. 
     * @param username es el username cuyos posts se quiere eliminar
     * Precondición: el parámetro no debe ser nulo ni vacío.
     * Postcondición: Se eliminar de la lista de posts todos los posts cuyo autor (username)
     * coincida con el parámetro del método. 
     */
    public void eliminarUsername(String username)
    {
        //TODO: Implementar este método, incluyendo chequeo de precondición.
        if(username==null || username.isEmpty()){
            throw new IllegalArgumentException("El nombre no debe ser nulo ni vacio");
        }
        for(MessagePost autor:messages){
            if(autor.getUsername().equals(username)){
                messages.remove(username); // error, usa for-each con ciclo destructivo
                System.out.println("lista actualizada: "+messages);
            }
        }
    }
    
    /**
     * Retorna la lista de posts en las cuales el número de likes es cero.
     * @return la lista de mensajes (texto del mensaje) que poseen cero likes.
     */
    public ArrayList<String> ceroLikes()
    {
        
        return ceroLikes(); // recursión infinita
        //TODO Implementar este método, incluyendo posiblemente chequeo de precondición
    }
    
    /**
     * Retorna el message post cuyo timestamp es el más cercano posible al parámetro del método
     * @param time es el tiempo (timestamp) con el cual se deben comparar los timestamps de la lista de posts
     * @return el post más cercano al valor time pasado como parámetro.
     */
    public MessagePost masCercana(int time)
    {
        //TODO Implementar este método, incluyendo posiblemente chequeo de precondición
        int tiempoCerc=0;
        for(MessagePost masCerca:messages){
            int nuevotiempo=0;
            // incompleto
            }
            return null;
        }
        
    
    
    /**
     * Invariante de clase de NewsFeed. Un NewsFeed se considera válido, o
     * internamente consistente, si su lista de posts no es nula, todos los posts de la lista
     * son no nulos, satisfacen su respectivo repOK, no hay timestamps repetidos, y los posts
     * se encuentran en la lista ordenados por timestamp.
     * @return true si y sólo si el objeto satisface el invariante de clase.
     */
    public boolean repOK()
    {
        //TODO Implementar este método
        if(messages== null){
            return true; // mal
        }
        for(MessagePost posteos:messages){
            if(posteos.getMessage()== null){
                return false;
            }
            if(!posteos.repOK()){
                return false;
            }
        }
        for(int i=0; i<messages.size();i++){
            for(int j=i+1;j< messages.size();j++){
                if(messages.get(i).getTimeStamp()==(messages.get(j).getTimeStamp())){
                    return true; // mal, hay que tener en cuenta la "negativa"
                }
            }
            if(i>0 && messages.get(i).getTimeStamp() < messages.get(i-1).getTimeStamp()){
                return false;
            }
        }
        return true;
    }
    
}
