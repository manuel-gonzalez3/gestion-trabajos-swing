package TrabajoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaModificarUsuario extends JFrame implements ActionListener {
	public VentanaModificarUsuario(Usuario usuario) {
		setSize(250, 250);// ancho,alto

		setLocationRelativeTo(null);// centrado

		setDefaultCloseOperation(EXIT_ON_CLOSE);// DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
		setTitle(usuario.nombre);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		colocarPaneles();
	}

	private void colocarPaneles() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
