package TrabajoFinal;

public class Variables 
{
    public static Usuario[] usuarios = new Usuario[20];
    static 
    {
        usuarios[0] = new Usuario("admin", "1234", "admin", "activo");
        usuarios[1] = new Usuario("user0", "0000", "user", "activo");
        usuarios[2] = new Usuario("user1", "1111", "user", "inactivo");
        usuarios[3] = new Usuario("user2", "2222", "user", "activo");
    }
    public static Usuario usuarioActual;
    public static int contadorUsuarios = 4;
    
    public static int contadorTrabajos = 0;
    public static Trabajo[] trabajos = new Trabajo[20];
    
}
