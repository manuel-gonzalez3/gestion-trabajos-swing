package TrabajoFinal;

public class Usuario 
{
	String nombre;
	String password;
	String tipo;
	String estado;
	
	public Usuario (String nombre, String password, String tipo, String estado)
	{
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
    }
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getTipo() 
	{
		return tipo;
	}
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	public String getEstado() 
	{
		return estado;
	}
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}
}
