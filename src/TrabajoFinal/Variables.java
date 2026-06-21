package TrabajoFinal;

public class Variables {
    public static Usuario[] usuarios = new Usuario[4];

    static {
        usuarios[0] = new Usuario("admin", "1234", "admin");
        usuarios[1] = new Usuario("user0", "0000", "user");
        usuarios[2] = new Usuario("user1", "1111", "user");
        usuarios[3] = new Usuario("user2", "2222", "user");
    }
    public static Trabajo[] trabajos = new Trabajo[20];
    static {
    	
    }
}
