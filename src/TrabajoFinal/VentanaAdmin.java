package TrabajoFinal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

public class VentanaAdmin extends JFrame implements ActionListener 
{
	//misma logica que ventanaUser
	JLabel titulo = new JLabel("FOTOCOPIADORA", SwingConstants.CENTER);
    JButton usuarios = new JButton("Ver Usuarios");
    JButton nuevoUsuario = new JButton("Nuevo Usuario");
    JButton agregarUsuario = new JButton("Agregar Usuario");
    JButton activar = new JButton("Activar/Desactivar");
    JButton trabajosUsuario = new JButton("Ver Trabajos de Usuario");
    JButton trabajos = new JButton("Ver Trabajos");
    JButton eliminar = new JButton("Eliminar trabajo");
    JButton cambiarEstado = new JButton("Cambiar estado");
    JButton salir = new JButton("Salir");
    JPanel panelBotones = new JPanel();
    JPanel panelContenido = new JPanel();
    
    Usuario usuarioElegido; //Usuario que selecciona de la lista de users
    public VentanaAdmin() 
    {
        setSize(1200, 750); // ancho, alto
        setLocationRelativeTo(null); // centrado
        setResizable(false); // no se puede cambiar el tamaño
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fotocopias");
        colocarPaneles();
    }

    private void colocarPaneles() 
    {
        // Panel principal con BorderLayout para dividir en dos partes
        setLayout(new BorderLayout());
		titulo.setFont(new Font("comics sans",Font.PLAIN,40));
        // Panel para los botones en el costado izquierdo
        panelBotones.setLayout(new GridLayout(9, 1, 10, 10)); // 3 filas, 1 columna, con espacio entre botones
        panelBotones.setPreferredSize(new Dimension(200, 750));

        // Agregar margen al panel de botones para centrarlo más
        panelBotones.setBorder(new EmptyBorder(0, 10, 100, 10)); // top, left, bottom, right
    
        // Ajustar el tamaño de cada botón
        Dimension buttonSize = new Dimension(220, 40); // Ancho y alto deseados
        usuarios.setPreferredSize(buttonSize);
        nuevoUsuario.setPreferredSize(buttonSize);
        agregarUsuario.setPreferredSize(buttonSize);
        activar.setPreferredSize(buttonSize);
        trabajosUsuario.setPreferredSize(buttonSize);
        trabajos.setPreferredSize(buttonSize);
        eliminar.setPreferredSize(buttonSize);
        cambiarEstado.setPreferredSize(buttonSize);
        salir.setPreferredSize(buttonSize);

        // Añadir botones al panel de botones
        panelBotones.add(nuevoUsuario);
        panelBotones.add(agregarUsuario);
        panelBotones.add(usuarios);
        panelBotones.add(activar);
        panelBotones.add(trabajosUsuario);
        panelBotones.add(trabajos);
        panelBotones.add(eliminar);
        panelBotones.add(cambiarEstado);
        panelBotones.add(salir);
        
        //deshabilitar botones que no se puden usar al inicio
        agregarUsuario.setEnabled(false);
        activar.setEnabled(false);
        trabajosUsuario.setEnabled(false);
        eliminar.setEnabled(false);
        cambiarEstado.setEnabled(false);
        // Añadir paneles al marco principal
        add(titulo, BorderLayout.NORTH); // Título en la parte superior
        add(panelBotones, BorderLayout.WEST); // Botones en el costado izquierdo
        add(panelContenido, BorderLayout.CENTER); // Espacio en blanco para listar trabajos
        
        // Eventos de botones
        usuarios.addActionListener(this);
        nuevoUsuario.addActionListener(this);
        agregarUsuario.addActionListener(this);
        activar.addActionListener(this);
        trabajosUsuario.addActionListener(this);
        trabajos.addActionListener(this);
        eliminar.addActionListener(this);
        cambiarEstado.addActionListener(this);
        salir.addActionListener(this);
    }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == usuarios) 
		{
			mostrarPanelUsuarios();
			
		}
		if (e.getSource() == nuevoUsuario) 
		{
			
			mostrarPanelNuevoUsuario();
		}
		if (e.getSource() == agregarUsuario) 
		{
			PanelNuevoUsuario.verificarUsuario(); //verificar si los datos ingresados son correctos, y actualizar la lista de usuarios
			mostrarPanelNuevoUsuario();
		}
		if (e.getSource() == activar) 
		{
			PanelListaUsuarios.cambiarEstadoUsuario(); //cambiar el estado de un usuario y actualizar la lista de usuarios
            mostrarPanelUsuarios();
		}
		if (e.getSource() == trabajosUsuario) 
		{
			usuarioElegido = PanelListaUsuarios.obtenerUsuario(); //obtener el usuario seleccionado de la lista y mostrar solo sus trabajos
			if(usuarioElegido != null)
			{
				mostrarPanelTrabajos();
			}
		}
		if (e.getSource() == trabajos) 
		{
			usuarioElegido = null; //limpio cualquier usuario que haya seleccionado para poder mostrar todos
			mostrarPanelTrabajos();
			
		}
		if (e.getSource() == eliminar) 
		{
			PanelListaTrabajos.eliminar(); //eliminar el trabajo seleccionado y actualizar la lista de trabajos
			mostrarPanelTrabajos();
		}
		if (e.getSource() == cambiarEstado) 
		{
			PanelListaTrabajos.cambiarEstado(); //cambiar el estado del trabajo seleccionado y actualizar la lista de trabajos
			mostrarPanelTrabajos();
		}
		if (e.getSource() == salir) 
		{
			this.setVisible(false);
			VentanaLogin v1 = new VentanaLogin();
			v1.setVisible(true);
			
		}
	}
	
	//metodos para mostrar los paneles, activan sus botones y actualizan el panel de contenido con el panel correspondiente
	private void mostrarPanelNuevoUsuario() 
	{ 
		activar.setEnabled(false);
		trabajosUsuario.setEnabled(false);
		eliminar.setEnabled(false);
		cambiarEstado.setEnabled(false);
		agregarUsuario.setEnabled(true);
		PanelNuevoUsuario panel = new PanelNuevoUsuario();
		panelContenido.removeAll();
		panelContenido.add(panel.panelNuevoUsuario, BorderLayout.CENTER);
		panelContenido.updateUI();
	}
	
	private void mostrarPanelUsuarios() 
	{ 
		activar.setEnabled(true);
		trabajosUsuario.setEnabled(true);
		eliminar.setEnabled(false);
		cambiarEstado.setEnabled(false);
		agregarUsuario.setEnabled(false);
		
		PanelListaUsuarios panel = new PanelListaUsuarios();
		panelContenido.removeAll();
		panelContenido.add(panel.listaUsuarios, BorderLayout.CENTER);
		panelContenido.updateUI();
	}
	
	private void mostrarPanelTrabajos() 
	{
		PanelListaTrabajos panel = new PanelListaTrabajos(usuarioElegido);
		activar.setEnabled(false);
		trabajosUsuario.setEnabled(false);
		agregarUsuario.setEnabled(false);
		panelContenido.removeAll();
		panelContenido.add(panel.listaTrabajos, BorderLayout.CENTER);
		panelContenido.updateUI();
		if(PanelListaTrabajos.tieneTrabajos == 1)
		{
			eliminar.setEnabled(true);
			cambiarEstado.setEnabled(true);
		}
		else
		{
			eliminar.setEnabled(false);
			cambiarEstado.setEnabled(false);
		}
	}
}
