import java.util.ArrayList;

/**
 * Esta clase captura información sobre un post en una red social. 
 * El post es un mensaje en formato texto, que consta del username 
 * (quien postea el mensaje), el mensaje en sí mismo, un timestamp y 
 * una cantidad de likes. 
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class MessagePost 
{
    // usuario que postea el message post
    private String username;  
    
    // contenido del mensaje
    private String message;   
    
    // número que indica el timestamp o momento de tiempo de creación del mensaje
    private long timestamp;
    
    // cantidad de likes
    private int likes;
    
    private static long artificialtime = 0;
    /**
     * Constructor de objetos de la clase MessagePost. La creación setea tanto el username como el 
     * contenido del mensaje con los parámetros respectivos del método.
     * El timestamp se setea con la hora actual en milisegundos.
     * La cantidad de likes es cero.
     * El autor no puede ser nulo ni vacío.
     * El mensaje no puede ser nulo ni vacío.
     * 
     * @param author    el usuario autor del mensaje
     * @param text      el texto del mensaje
     */
    public MessagePost(String author, String text)
    {
        //TODO implementar este método incluyendo chequeo de precondición
        if(author == null || author.isEmpty()){
            throw new IllegalStateException("Author no puede ser nulo, ni vacio");
        }
        if(text == null || text.isEmpty()){
            throw new IllegalStateException("el mensaje no puede ser nulo, ni vacio");
        }
        this.username = author;
        this.message = text;
        this.likes = 0;
        this.timestamp = System.currentTimeMillis();
        //artificialtime; artificialtime++;
    }

    /**
     * Agrega un "like" al mensaje actual
     */
    public void like()
    {
        likes++;
    }

    /**
     * Retira un "like" del mensaje actual
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }


    /**
     * Retorna el texto del post
     * 
     * @return el texto del post
     */
    public String getText()
    {
        return message;
    }

    /**
     * Retorna el tiempo de creación de este post
     * 
     * @return el tiempo de creación del post.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }
    
    public String getUsername(){
        return username;
    }
    
    public int getLikes(){
        return likes;
    }
    
    /**
     * Invariante de la clase MessagePost.
     * Un messagepost es internamente consistente si su username es no nulo y no vacío, 
     * su mensaje es no nulo y no vacío, el timestamp es un valor positivo, y la cantidad
     * de likes es mayor o igual a cero.
     * @return true ssi el objeto es internamente consistente (satisface el invariante de clase).
     */
    public boolean repOK1() 
    {
        //TODO Implementar este método
        if( username == null || username.isEmpty()){
            return false;
        }
        if(message == null || message.isEmpty()){
            return false;
        }
        if(timestamp < 0){
            return false;
        }
        if(likes < 0){
            return false;
        }
        return true;
    }
    
    
    /**
     * Retorna los detalles del message post, como
     * cadena de caracteres.
     * @return detalles del messagepost en una cadena de caracteres,
     * usando el formato "<username>: <message> (posteado en <timestamp>). A <likes> personas le gustó este mensaje.".
     */
    public String toString()
    {
        //TODO Implementar este método
        return username + ": " + message + " (posteado en " + timestamp + "). A " + likes + " personas le gustó este mensaje.";
    }
}
