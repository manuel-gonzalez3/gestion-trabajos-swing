package TrabajoFinal;

import java.time.format.DateTimeFormatter;

////1.b Ver lista de trabajos en cada etapa  (usuario, encargado de trabajo, cantidad de copias, calidad de copia (color, byn), estado, fecha de entrada, fecha de terminado, fecha de entrega.
public class Trabajo 
{
	int id;
	String estado;
	String fechaEntrada;
	String fechaTerminado = "-";
	String fechaEntrega = "-";
	Usuario usuario;
	int cantidadCopias;
	String calidadCopia;

	public Trabajo(int id, Usuario usuario, int cantidadCopias, String calidadCopia) 
	{
		this.id = id;
		this.usuario = usuario;
		this.cantidadCopias = cantidadCopias;
		this.calidadCopia = calidadCopia;
		this.estado = "pendiente";
		this.fechaEntrada = obtenerFechaActual();
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	private String obtenerFechaActual() 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dtf.format(java.time.LocalDate.now());
	}

	public void obtenerFechaFinalizacion()
	{
        this.fechaTerminado = obtenerFechaActual();
    }
	
	public void obtenerFechaEntrega() {
		
		this.fechaEntrega = obtenerFechaActual();
	}
	
	public void cargarFechaEntrega(String fechaEntrega) 
	{
		this.fechaEntrega = fechaEntrega;
	}
	public String getEstado() 
	{
		return estado;
	}
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) 
	{
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaTerminado() {
		return fechaTerminado;
	}
	public void setFechaTerminado(String fechaTerminado) 
	{
		this.fechaTerminado = fechaTerminado;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) 
	{
		this.fechaEntrega = fechaEntrega;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) 
	{
		this.usuario = usuario;
	}
	
	public int getCantidadCopias() 
	{
		return cantidadCopias;
	}
	public void setCantidadCopias(int cantidadCopias) 
	{
		this.cantidadCopias = cantidadCopias;
	}
	public String getCalidadCopia() {
		return calidadCopia;
	}
	public void setCalidadCopia(String calidadCopia) 
	{
		this.calidadCopia = calidadCopia;
	}
	
}
