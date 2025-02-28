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
        if(message == null){
            throw new IllegalArgumentException("El mensaje no puede ser nulo");
        } // chequeo incompleto de precondición
        int index = 0;
        if(index >= 0 && index < messages.size()){ // mal
            messages.add(message); // mal
        }
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
        if(username.isEmpty() || username == null ){
            throw new IllegalArgumentException("el parametro no puede ser vacio y nulo");
        }
        for(MessagePost p : messages){
            if(p.equals(username)){
                messages.remove(username); // usa for-each con un ciclo destructivo. Mal
            }
        }
    }
    
    /**
     * Retorna la lista de posts en las cuales el número de likes es cero.
     * @return la lista de mensajes (texto del mensaje) que poseen cero likes.
     */
    public ArrayList<String> ceroLikes()

    {
        for(MessagePost x : messages){
            if(x.getLikes() > 0){
                System.out.println(x);
            }
        }
        return ceroLikes(); // mal. Termina en ciclo infinito. No genera la salida requerida
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
        time = 0;
        int a = messages.size() - 1; // mal. No resuelve el problema planteado en este método
        while(time < a){
            int mid = (time + a) / 2;
            if(time == a){
              System.out.println(a);
            }
            if(time>a){
                mid = a - time;
            }
            else{
                mid = a + time;
            }
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
        //TODO Implementar este método // incompleto
        return messages != null;
    }
    
}
