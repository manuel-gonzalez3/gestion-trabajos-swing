package TrabajoFinal;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelListaUsuarios extends JFrame
{
	Usuario usuario;
	static Usuario[] usuarios = Variables.usuarios; //arregñp local para tomar el arreglo de usuarios
	static Usuario[] users;  //arreglo que solo tiene los usuarios del tipo user
	static ButtonGroup grupo = new ButtonGroup();
	
	//creo un panel para mostrar los usuarios, con un grid del tamaño de la cantidad de usuarios, con espacio entre botones
	public JPanel listaUsuarios = new JPanel(new GridLayout(Variables.contadorUsuarios+1,1, 0, 7));
	
	public PanelListaUsuarios() 
	{
		
		grupo = new ButtonGroup();
		users = new Usuario[Variables.contadorUsuarios]; //inicializo el arreglo de usuarios tipo user
		JLabel titulo = new JLabel("USUARIOS", SwingConstants.CENTER);
		listaUsuarios.add(titulo);
		if(Variables.contadorUsuarios>0)
		{
			int i = 0;
			int cont = 0;
			while (cont < Variables.contadorUsuarios) 
			{
				if(usuarios[cont].tipo.equals("user")) //agrego solo los usuarios tipo user al arreglo y al panel
				{
						agregarUsuario(usuarios[cont], i);
						users[i] = usuarios[cont];
						i++;
				}
				cont++;
			}
		}
		else 
		{
			JPanel panel = new JPanel();
			panel.add(new JLabel("No hay usuarios cargados"));
			listaUsuarios.add(panel);
		}
	}
	
	
	//agrega un usuario al panel, con un radio button y lo agrega al grupo.
	private void agregarUsuario(Usuario usuario, int indiceUsuario) 
	{
        JRadioButton boton = new JRadioButton(indiceUsuario+1 + " - Nombre: " + usuario.nombre + " - Tipo: " + usuario.tipo + " - Estado: " + usuario.estado);
        grupo.add(boton);
        listaUsuarios.add(boton);
	}
	
	
	//activa o inactiva el usuario seleccionado
	public static void cambiarEstadoUsuario() 
	{
			int indice = PanelListaTrabajos.encontrarIndice(grupo); //usa el metodo de la clase trabajos, ya que es la misma logica
			if(indice != -1)
			{
				if (users[indice].estado.equals("activo")) 
				{
					users[indice].estado = "inactivo";
					JOptionPane.showMessageDialog(null, "Usuario desactivado");
				}
				else 
				{
					users[indice].estado = "activo";
					JOptionPane.showMessageDialog(null, "Usuario activado");
				}
				cambiarUsuario(users[indice]);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Seleccione un usuario");
			}
				
		}
	
	
	//sobreescribe el usuario en el arreglo de usuarios
	public static void cambiarUsuario(Usuario usuario) 
	{
		for (int i = 0; i < Variables.contadorUsuarios; i++) 
		{
			if (usuarios[i].nombre.equals(usuario.nombre)) 
			{
				usuarios[i] = usuario;
				break;
			}
		}
	}
	
	
	//devuelve el usuario seleccionado
	public static Usuario obtenerUsuario() 
	{
		int indice = PanelListaTrabajos.encontrarIndice(grupo);
		if (indice != -1) 
		{
			return users[indice];
		} 
		else 
		{
			JOptionPane.showMessageDialog(null, "Seleccione un usuario");
		}
		return null;
	}
	
	
	public JPanel getPanelListaUsuarios() 
	{
		return listaUsuarios;
	}
	public void setPanelListaUsuarios(JPanel panelListaUsuarios) 
	{
		this.listaUsuarios = panelListaUsuarios;
	}
}
