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

public class VentanaUser extends JFrame implements ActionListener 
{
	JLabel titulo = new JLabel("FOTOCOPIADORA", SwingConstants.CENTER);
    JButton nuevo = new JButton("Nuevo Trabajo");
    JButton agregarTrabajo = new JButton("Agregar trabajo");
    JButton trabajos = new JButton("Historial de trabajos");
    JButton eliminar = new JButton("Eliminar trabajo");
    JButton salir = new JButton("Salir");
    JPanel panelBotones = new JPanel(); //panel que va a contener los botones a la izquierda de la ventana
    JPanel panelContenido = new JPanel();

    public VentanaUser() 
    {
        setSize(1200, 750); // ancho, alto
        setResizable(false); // no se puede cambiar el tamaño
        setLocationRelativeTo(null); // centrado
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fotocopias");
        colocarPaneles();
    }

    private void colocarPaneles() 
    {
        // Panel principal con BorderLayout para mandar titulo arriba,  botones a la izquierda y  contenido en el centro
        setLayout(new BorderLayout());
		
        titulo.setFont(new Font("comics sans",Font.PLAIN,40));
       
		// Panel para los botones en el costado izquierdo
        panelBotones.setLayout(new GridLayout(5, 1, 10, 10)); // 3 filas, 1 columna, con espacio entre botones
        panelBotones.setPreferredSize(new Dimension(200, 750));

        // Agregar margen al panel de botones para que quede mejor colocado
        panelBotones.setBorder(new EmptyBorder(0, 10, 100, 10));

        // Ajustar el tamaño de cada botón
        Dimension buttonSize = new Dimension(220, 40); // Ancho y alto deseados
        nuevo.setPreferredSize(buttonSize);
        agregarTrabajo.setPreferredSize(buttonSize);
        trabajos.setPreferredSize(buttonSize);
        eliminar.setPreferredSize(buttonSize);
        salir.setPreferredSize(buttonSize);

        // Añadir botones al panel de botones
        panelBotones.add(nuevo);
        panelBotones.add(agregarTrabajo);
        panelBotones.add(trabajos);
        panelBotones.add(eliminar);
        panelBotones.add(salir);
        
        //deshabilitar botones de gestion de trabajos
        agregarTrabajo.setEnabled(false);
        eliminar.setEnabled(false);
        
        // Añadir paneles a la ventana
        add(titulo, BorderLayout.NORTH); // Título en la parte superior
        add(panelBotones, BorderLayout.WEST); // Botones en el costado izquierdo
        add(panelContenido, BorderLayout.CENTER); // Espacio en blanco para listar diferentes cosas
        
        // Eventos de botones
        nuevo.addActionListener(this);
        trabajos.addActionListener(this);
        agregarTrabajo.addActionListener(this);
        eliminar.addActionListener(this);
        salir.addActionListener(this);
    }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == nuevo) 
		{
			mostrarPanelNuevoTrabajo();	
		}
		if (e.getSource() == agregarTrabajo) 
		{
			PanelNuevoTrabajo.verificar();
		}
		if (e.getSource() == trabajos) 
		{
			mostrarPanelTrabajos();
		}
		if (e.getSource() == eliminar) 
		{
			PanelListaTrabajos.eliminar();
			mostrarPanelTrabajos();
		}
		if (e.getSource() == salir) 
		{
			this.setVisible(false);
			VentanaLogin v1 = new VentanaLogin();
			v1.setVisible(true);
			
		}
	}

	private void mostrarPanelNuevoTrabajo() {
		agregarTrabajo.setEnabled(true); //activar boton de agregar trabajo
		eliminar.setEnabled(false); 	    //desactivar boton de eliminar trabajo por si estaba viendo trabajos
		
		PanelNuevoTrabajo panel = new PanelNuevoTrabajo(); //obtener el panel en un objeto local
		
		//remover el panel actual y agregar el nuevo panel
		panelContenido.removeAll();
		panelContenido.add(panel.panelNuevoTrabajo, BorderLayout.CENTER);
		panelContenido.updateUI();
	}

	private void mostrarPanelTrabajos() { //misma logica que mostrarPanelNuevoTrabajo()
		agregarTrabajo.setEnabled(false);
		
		PanelListaTrabajos panel = new PanelListaTrabajos(Variables.usuarioActual);
		
		if(PanelListaTrabajos.tieneTrabajos==1) //activar el boton de eliminar solo si se listaron trabajos
		{
			eliminar.setEnabled(true);
		}
		else
		{
			eliminar.setEnabled(false);
		}
		
		panelContenido.removeAll();
		panelContenido.add(panel.listaTrabajos, BorderLayout.CENTER);
		panelContenido.updateUI();
		
	}
}
