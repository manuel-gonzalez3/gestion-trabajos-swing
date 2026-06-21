package TrabajoFinal;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaUsuarios extends JFrame implements ActionListener{
	Usuario[] usuarios = Variables.usuarios;
	Container grilla;
	JPanel panel;
	JButton nuevo = new JButton("Nuevo Usuario");
	JButton salir = new JButton("Salir");
	public VentanaUsuarios() {
		setSize(500, 150);// ancho,alto

		setLocationRelativeTo(null);// centrado

		setDefaultCloseOperation(EXIT_ON_CLOSE);// DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
		setTitle("Usuarios");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		colocarPaneles();
	}

	private void colocarPaneles() {
		grilla = getContentPane();
		grilla.setLayout(new GridLayout(2,1));
		panel = new JPanel();
		for (int i = 0; i < usuarios.length; i++) {
			if(usuarios[i].tipo.equals("user"))
			{
				agregarUsuario(usuarios[i]);
			}
		}
		grilla.add(panel);
		JPanel panel2 = new JPanel();
		panel2.add(nuevo);
		panel2.add(salir);
		grilla.add(panel2);
		salir.addActionListener(this);
	}

	private void agregarUsuario(Usuario usuario) {
		JButton boton = new JButton(usuario.nombre);
		boton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	VentanaModificarUsuario v1 = new VentanaModificarUsuario(usuario);
          			v1.setVisible(true);
          			setVisible(false);
	            }
	        });
		panel.add(boton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == salir) {
			VentanaAdmin v1 = new VentanaAdmin();
			v1.setVisible(true);
			this.setVisible(false);
		}
	}
	
}
