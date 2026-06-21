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
public class PanelNuevoUsuario extends JFrame
{
	static Usuario[] usuarios = Variables.usuarios;
	Usuario usuario;
	static JTextField nombreUsuario = new JTextField(10);
	static JTextField passUsuario = new JTextField(10);
	JPanel panelNuevoUsuario = new JPanel(new GridLayout(5,1, 0, 50));
	JLabel nombreLabel = new JLabel("Nombre: ");
	JLabel passLabel = new JLabel("Contraseña: ");
	JLabel tipoLabel = new JLabel("Tipo: ");
	JLabel estadoLabel = new JLabel("Estado: ");
	ButtonGroup grupoTipo = new ButtonGroup();
	ButtonGroup grupoEstado = new ButtonGroup();
	static JRadioButton admin = new JRadioButton("Admin");
	static JRadioButton user = new JRadioButton("User");
	static JRadioButton activo = new JRadioButton("Activo");
	static JRadioButton inactivo = new JRadioButton("Inactivo");
	public PanelNuevoUsuario() {
		JLabel titulo = new JLabel("NUEVO USUARIO", JLabel.CENTER);
		panelNuevoUsuario.add(titulo);
	    nombreUsuario.setText("");
        passUsuario.setText("");
        admin.setSelected(false);
        user.setSelected(false);
        activo.setSelected(false);
        inactivo.setSelected(false);
		JPanel panelNombre = new JPanel();
		panelNombre.add(nombreLabel);
		panelNombre.add(nombreUsuario);
		JPanel panelPass = new JPanel();
		panelPass.add(passLabel);
		panelPass.add(passUsuario);
		JPanel tipo = new JPanel();
		tipo.add(tipoLabel);
		tipo.add(admin);
		tipo.add(user);
		grupoTipo.add(admin);
		grupoTipo.add(user);
		JPanel estado = new JPanel();
		estado.add(estadoLabel);
		estado.add(activo);
		estado.add(inactivo);
		grupoEstado.add(activo);
		grupoEstado.add(inactivo);
		panelNuevoUsuario.add(panelNombre);
		panelNuevoUsuario.add(panelPass);
		panelNuevoUsuario.add(tipo);
		panelNuevoUsuario.add(estado);
	}
	

	
	



	public static void verificarUsuario() 
	{
				if (nombreUsuario.getText().equals("") || passUsuario.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Complete todos los campos");
				}
				else if(!admin.isSelected() && !user.isSelected()) 
				{
                    JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario");
                }
                else if(!activo.isSelected() && !inactivo.isSelected()) 
                {
                    JOptionPane.showMessageDialog(null, "Seleccione un estado de usuario");
				}
                else 
                {
					for (int i = 0; i < Variables.contadorUsuarios; i++) 
					{
						if (nombreUsuario.getText().equals(usuarios[i].nombre)) 
						{
							JOptionPane.showMessageDialog(null, "El usuario ya existe");
							return;
						}
					}
					agregarUsuario();
				}
			}
	public static void agregarUsuario() 
	{
			String tipo = "";
			String estado = "";
			int encontrado = 0;
			if (admin.isSelected()) 
			{
				tipo = "admin";
			} else 
			{
				tipo = "user";
			}
			if (activo.isSelected()) 
			{
				estado = "activo";
			} else 
			{
				estado = "inactivo";
			}
				
			for (int i = 0; i < usuarios.length; i++) 
			{
				if (usuarios[i] == null) 
				{
					usuarios[i] = new Usuario(nombreUsuario.getText(), passUsuario.getText(), tipo, estado);
					JOptionPane.showMessageDialog(null, "Usuario agregado");
					Variables.contadorUsuarios++;
					encontrado = 1;
					break;
				}
			}
			if (encontrado == 0) 
			{
				JOptionPane.showMessageDialog(null, "No se pueden agregar mas usuarios");
			}
		}
		
	public JPanel getPanelNuevoUsuario() 
	{
		return panelNuevoUsuario;
	}



	public void setPanelNuevoUsuario(JPanel panelNuevoUsuario) 
	{
		this.panelNuevoUsuario = panelNuevoUsuario;
	}
}
