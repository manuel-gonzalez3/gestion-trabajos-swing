package TrabajoFinal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaAdmin extends JFrame implements ActionListener{
	JButton usuarios = new JButton("Usuarios");
	JButton trabajos = new JButton("Trabajos");
	JButton salir = new JButton("Salir");
	public VentanaAdmin() {
		setSize(250, 400);// ancho,alto

		setLocationRelativeTo(null);// centrado

		setDefaultCloseOperation(EXIT_ON_CLOSE);// DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
		setTitle("Fotocopias");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		colocarPaneles();
	}

	private void colocarPaneles() {
		Container grilla = getContentPane();
		grilla.setLayout(null);
		usuarios.setBounds(50, 50, 150, 50);
		trabajos.setBounds(50, 150, 150, 50);
		salir.setBounds(50, 250, 150, 50);
		grilla.add(usuarios);
		grilla.add(trabajos);
		grilla.add(salir);
		usuarios.addActionListener(this);
		trabajos.addActionListener(this);
		salir.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == usuarios) {
			VentanaUsuarios v1 = new VentanaUsuarios();
			v1.setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == trabajos) {
			VentanaTrabajos v1 = new VentanaTrabajos();
			v1.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == salir)
		{
			VentanaLogin v1 = new VentanaLogin();
			v1.setVisible(true);
			this.setVisible(false);
		}
	}
}
