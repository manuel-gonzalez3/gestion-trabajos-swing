package TrabajoFinal;
////1.b Ver lista de trabajos en cada etapa  (usuario, encargado de trabajo, cantidad de copias, calidad de copia (color, byn), estado, fecha de entrada, fecha de terminado, fecha de entrega.
public class Trabajo {
	String estado;
	String fechaEntrada;
	String fechaTerminado;
	String fechaEntrega;
	String usuario;
	String encargado;
	int cantidadCopias;
	String calidadCopia;

	public Trabajo(String usuario,
			String encargado, int cantidadCopias, String calidadCopia,String estado,String fechaEntrada) {
		this.usuario = usuario;
		this.encargado = encargado;
		this.cantidadCopias = cantidadCopias;
		this.calidadCopia = calidadCopia;
		this.estado = estado;
		this.fechaEntrada = fechaEntrada;
	}

	public void cargarFechaTerminado(String fechaTerminado){
        this.fechaTerminado = fechaTerminado;
    }

	public void cargarFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaTerminado() {
		return fechaTerminado;
	}
	public void setFechaTerminado(String fechaTerminado) {
		this.fechaTerminado = fechaTerminado;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public int getCantidadCopias() {
		return cantidadCopias;
	}
	public void setCantidadCopias(int cantidadCopias) {
		this.cantidadCopias = cantidadCopias;
	}
	public String getCalidadCopia() {
		return calidadCopia;
	}
	public void setCalidadCopia(String calidadCopia) {
		this.calidadCopia = calidadCopia;
	}
	
}
