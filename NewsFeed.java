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
        if(message == null || message.equals("") || !message.repOK()){
            throw new IllegalArgumentException ("Mensaje no valido");
        }
        
        long timestampMessage = message.getTimeStamp();
        for(MessagePost mensaje : messages){
            if(mensaje.getTimeStamp() == timestampMessage){
                throw new IllegalArgumentException ("Ya existe en la lista un mensaje con este timestamp");
            }
        }
       
        int index = 0;
        
        while(index < messages.size() && message.getTimeStamp() > messages.get(index).getTimeStamp()){
            index ++;
        }
        
        messages.add(message); // mal. No inserta el mensaje en la posición adecuada
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
        if(username == null || username.isEmpty()){
            throw new IllegalArgumentException("El username no debe ser nulo ni vacio");
        }
        
        ArrayList <MessagePost> eliminarMensaje = new ArrayList <>();
        
        for(MessagePost mensaje : messages){
            if(mensaje.getUsername() == username){
                eliminarMensaje.add(mensaje);
            }
        }
        messages.removeAll(eliminarMensaje);
    }
    
    /**
     * Retorna la lista de posts en las cuales el número de likes es cero.
     * @return la lista de mensajes (texto del mensaje) que poseen cero likes.
     */
    public ArrayList<String> ceroLikes()
    {
        //TODO Implementar este método, incluyendo posiblemente chequeo de precondición
        ArrayList<String> ceroLikes = new ArrayList <>();
        
        for(MessagePost mensaje : messages){
           if(mensaje.getLikes() == 0){
            String mensajeNoLikes = mensaje.getText();
            ceroLikes.add(mensajeNoLikes);
           }
        }
        
        return ceroLikes;
    }
    
    /**
     * Retorna el message post cuyo timestamp es el más cercano posible al parámetro del método
     * @param time es el tiempo (timestamp) con el cual se deben comparar los timestamps de la lista de posts
     * @return el post más cercano al valor time pasado como parámetro.
     */
    public MessagePost masCercana(int time)
    {
        //TODO Implementar este método, incluyendo posiblemente chequeo de precondición
        // Solo contempla el caso en el que el parametro time es igual al time stamp de algun elemento de la lista messages.
        // No pude realizar correctamente la comparacion entre time stamp distintos y devolver el mas cercano
        MessagePost masCercano = null;
        
        for(MessagePost mensaje : messages){
            if(mensaje.getTimeStamp() == time){
                masCercano = mensaje; //mal. No resuelve el problema. Retorna el que coincide con el time, no el más cercano
            }
        }
        return masCercano;
        
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
        if(messages == null){
            return false;
        }
        
        for(MessagePost mensaje : messages){
            if(mensaje == null || !mensaje.repOK()){
                return false;
            }
        }
        
        for(MessagePost mensaje : messages){
            int index = 0;
        
            while(index < messages.size() && mensaje.getTimeStamp() > messages.get(index).getTimeStamp()){
                index ++;
            }
            return true; // mal. Retorna abruptamente. No usa el índice.
        }
        
        for(MessagePost mensaje : messages){
            long timeStamp = mensaje.getTimeStamp();
            if(timeStamp == mensaje.getTimeStamp()){
                return false; // mal. 
            }
        }
        return true;
    }
    
}
