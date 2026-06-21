package TrabajoFinal;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaUser extends JFrame implements ActionListener{
	JButton nuevo = new JButton("Nuevo Trabajo");
	JButton trabajosActivos = new JButton("Trabajos Activos");
	JButton trabajosFinalizados = new JButton("Trabajos Finalizados");
	JButton salir = new JButton("Salir");
	public VentanaUser() {
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
		grilla.setLayout(new GridLayout(4,1));
		nuevo.setBounds(50, 50, 150, 50);
		trabajosActivos.setBounds(50, 150, 150, 50);
		trabajosFinalizados.setBounds(50, 200, 150, 50);
		salir.setBounds(50, 250, 150, 50);
		JPanel panel = new JPanel();
		panel.add(nuevo);
		grilla.add(panel);
		JPanel panel2 = new JPanel();
		panel2.add(trabajosActivos);
		grilla.add(panel2);
		JPanel panel3 = new JPanel();
		panel3.add(trabajosFinalizados);
		grilla.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.add(salir);
		grilla.add(panel4);
		nuevo.addActionListener(this);
		trabajosActivos.addActionListener(this);
		trabajosFinalizados.addActionListener(this);
		salir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nuevo) {
			VentanaNuevoTrabajo v1 = new VentanaNuevoTrabajo();
			v1.setVisible(true);
			this.setVisible(false);
		}

	}
}
