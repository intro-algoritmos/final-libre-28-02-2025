Network: Representación de un administrador de información
de news feeds de una red social, en base a dos clases principales:
- NewsFeed: Representa información de una fuente de noticias (o mensajes). Consta esencialmente
de una lista de objetos MessagePost, sin timestamps repetidos y ordenada por timestamp. 
- MessagePost: clase que representa posts de texto particulares, a través de un autor (username), 
el contenido concreto del mensaje (el mensaje en sí), el timestamp (tiempo de creación del mensaje), 
y cantidad de likes. 

Tareas a implementar en clase MessagePost:
- Implementar el constructor de la clase, incluyendo el chequeo de precondición 
    (se describe funcionalidad esperada en el comentario de los métodos)
- Implementar funcionalidad de:
    public String toString()
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public boolean repOK()
    (se describe funcionalidad esperada en el comentario del método)
   
Tareas a implementar en clase NewsFeed:
- Implementar funcionalidad de: 
    public void addMessagePost(MessagePost message)
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de: 
    public void eliminarUsername(String username)
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de: 
    public ArrayList<String> ceroLikes()
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de: 
    public MessagePost masCercana(int time)
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public boolean repOK()
    (se describe funcionalidad esperada en el comentario del método)

IMPORTANTE: Puede agregar todos los métodos adicionales que considere necesarios para 
las implementaciones de estas funcionalidades.  