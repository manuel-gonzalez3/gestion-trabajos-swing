package TrabajoFinal;

import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PanelListaTrabajos extends JFrame
{
	//declario el button group para agrupar los radioButton 
	static ButtonGroup grupo = new ButtonGroup();
	
	static Usuario usuarioElegido;
	
	static Trabajo[] trabajos = Variables.trabajos; //arreglo de trabajos en un arreglo local
	
	static Trabajo[] trabajosUsuario = new Trabajo[Variables.contadorTrabajos]; //creo un arreglo local para guardar los trabajos de un usuario en particular
	
	public JPanel listaTrabajos = new JPanel(); //declaro el panel donde se va a visualizar los trabajos
	
	static int tieneTrabajos; //flag para saber si se listaron trabajos
	
	
	public PanelListaTrabajos(Usuario UsuarioElegido) 
	{
		tieneTrabajos = 1; //inicializo en 1, si no se listan va a cambiar su valor
		grupo = new ButtonGroup(); //limpio el button group cada vez que se ejecuta
		
		usuarioElegido = UsuarioElegido; //guarda el usuario que pasa como parametro
		
		listaTrabajos.setLayout(new GridLayout(Variables.contadorTrabajos+1,1, 50,7)); //una fila por trabajo
		
		if (UsuarioElegido != null) // si se selecciona un usuario, se muestran los trabajos de ese usuario. Si no, se muestran todos los trabajos
		{
			JLabel nombreUsuario = new JLabel("TRABAJOS DEL USUARIO: " + usuarioElegido.nombre,  SwingConstants.CENTER);
			listaTrabajos.add(nombreUsuario);
		}
		else
		{
			JLabel nombreUsuario = new JLabel("TODOS LOS TRABAJOS", SwingConstants.CENTER);
			listaTrabajos.add(nombreUsuario);
		}
		agregarTrabajos();
	}

	
	//agregar los trabajos al panel
	private void agregarTrabajos() 
	{
		if(Variables.contadorTrabajos>0)
		{
			int indiceTrabajo = 0; //indice para imprimir los trabajos
			for (int i = 0; i < Variables.contadorTrabajos; i++) {
				if(usuarioElegido == null) //si no se selecciona un usuario, quiere decir que el admin esta viendo los trabajos de todos los user
				{
					agregarTrabajo(trabajos[i], i+1); //agrego uno por uno todos los trabajos
					
				}
				else
				{
					if (trabajos[i].usuario.nombre == usuarioElegido.nombre) //si el admin quiere ver los trabajos de un usuario, o si un usuario quiere ver los suyos
					{ 
						trabajosUsuario[indiceTrabajo] = trabajos[i]; //guarda los trabajos del usuario en el arreglo de sus trabajos
						indiceTrabajo++; 					//aumento el indice
						agregarTrabajo(trabajos[i], indiceTrabajo); //agrego uno por uno los trabajos del usuario al panel
					}
				}
			}
		if (indiceTrabajo == 0 && usuarioElegido !=null) //si el usuario no tiene trabajos
		{ 
				listaTrabajos.add(new JLabel("No tienes trabajos realizados"));
				tieneTrabajos = 0;
			}
		}
		else //si no hay trabajos cargados
		{ 
			listaTrabajos.add(new JLabel("No hay trabajos"));
			tieneTrabajos = 0;
		}
	}
	
	
	//agrega uno por uno los trabajos, creando un radio boton para cada uno y agregandolo al grupo de radio botones
	private void agregarTrabajo(Trabajo trabajo, int indiceTrabajo) 
	{ 
        JRadioButton boton = new JRadioButton(indiceTrabajo  + " | ID: " + trabajo.id + " | Usuario: " + trabajo.usuario.nombre + " | Fecha de entrada: " + trabajo.fechaEntrada + " | Calidad: " + trabajo.calidadCopia + " | Cantidad: " + trabajo.cantidadCopias + " | Estado: " + trabajo.estado + " | Fecha Finalizacion: " + trabajo.fechaTerminado + " | Fecha Entrega: " + trabajo.fechaEntrega);
        grupo.add(boton);
        listaTrabajos.add(boton);
	}
	

	//elimina el trabajo seleccionado
	public static void eliminar() 
	{ 
		int indice = encontrarIndice(grupo);  //obtener el indice del boton que haya seleccionado, este indice solo coincide con el arreglo de trabajos es un admin viendo todos los trabajo
		if(indice!=-1)
		{
			if(usuarioElegido != null)
			{
				indice = getIndiceTrabajo(indice); //si se quieren ver los trabajos de un user, el indice del boton no coincide con el indice del arreglo de trabajos, por lo que se busca el indice correcto 
			}
			eliminarTrabajo(indice); //elimina el trabajo seleccionado, lo busca directamente con el indice
		}
		else
		{
            JOptionPane.showMessageDialog(null, "Seleccione un trabajo");
		}
	}
			

	//devuelve el indice del trabajo seleccionado de usuario en el arreglo total de trabajos
	private static int getIndiceTrabajo(int indiceTrabajoUsuario) 
	{ 
		for (int i = 0; i < Variables.contadorTrabajos; i++) 
		{
			if (trabajosUsuario[indiceTrabajoUsuario].id == trabajos[i].id)  //si el id es igual, obtengo la posicion en el arreglo
			{
				return i;
			}
		}
		return -1;
	}
	
	//obtener el indice del arreglo de todos los trabajos en base al que haya seleccionado el usuario de los radio botones
	public static int encontrarIndice(ButtonGroup grupoBotones) 
	{ 
		Enumeration<AbstractButton> botones = grupoBotones.getElements(); // Obtiene los elementos del grupo como Enumeration
		int indice = 0;
		// Itera sobre cada botón en el grupo
		while (botones.hasMoreElements()) 
		{
			JRadioButton boton = (JRadioButton) botones.nextElement(); // Obtiene el siguiente botón
			if (boton.isSelected()) 
			{
					return indice; //si es seleccionado devuelve su posicion
			}
			indice++;
		}

		return -1; //devuelve -1 si no se selecciona ningun boton
	}
	
	
	//elimina el trabajo seleccionado, buscando directamente con el indice
	private static void eliminarTrabajo(int indice) 
	{ 
			if (Variables.usuarioActual.tipo == "admin" || Variables.trabajos[indice].estado.equals("pendiente"))
			{
				 desplazarTrabajos(indice);
			} else 
			{
				JOptionPane.showMessageDialog(null, "No se puede eliminar un trabajo que ya fue procesado."); //si es un user y el trabajo no esta pendiente
			}
	}
	
	
	//desplaza los trabajos una posicion a la izquierda, desde el que se quiere eliminar
	private static void desplazarTrabajos(int indice) 
	{ 
		for (int i = indice; i < Variables.contadorTrabajos - 1; i++) 
		{
            Variables.trabajos[i] = Variables.trabajos[i + 1];
        }
        Variables.trabajos[Variables.contadorTrabajos - 1] = null; //elimina el ultimo
        Variables.contadorTrabajos--; //disminuye el contador de trabajos
	}
	
	
	//cambia el estado del trabajo seleccionado, buscando directamente con el indice
	public static void cambiarEstado() 
	{ 
		int indice = encontrarIndice(grupo);  //obtener el indice del boton que haya seleccionado, este indice solo coincide con el arreglo de trabajos es un admin viendo todos los trabajo
		if(indice!=-1)
		{
			if (usuarioElegido != null)
			{
				indice = getIndiceTrabajo(indice); // si se quieren ver los trabajos de un user, el indice del boton no
													// coincide con el indice del arreglo de trabajos, por lo que se
													// busca el indice correcto
			}
			Object nuevoEstado = JOptionPane.showInputDialog(
					 null,
					 "Seleccione un estado.",
					 "Selector de estados",
					 JOptionPane.QUESTION_MESSAGE,
					 null, // null para icono defecto
					 new Object[] { "pendiente", "recibido", "en ejecucion", "finalizado", "entregado" },
					 null);
			if(nuevoEstado!=null)
			{
				Variables.trabajos[indice].estado = nuevoEstado.toString();
				if (nuevoEstado.toString().equals("entregado")) 
				{
					Variables.trabajos[indice].obtenerFechaEntrega();
				}
				else if (nuevoEstado.toString().equals("finalizado")) 
				{
					Variables.trabajos[indice].obtenerFechaFinalizacion();
				}
				else
				{
					Variables.trabajos[indice].fechaEntrega = "-";
					Variables.trabajos[indice].fechaTerminado = "-";
				}
				
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Seleccione un trabajo");
		}
	}
	
	
	public JPanel getListaTrabajos() 
	{
		return listaTrabajos;
	}


	public void setListaTrabajos(JPanel listaTrabajos) 
	{
		this.listaTrabajos = listaTrabajos;
	}
}


