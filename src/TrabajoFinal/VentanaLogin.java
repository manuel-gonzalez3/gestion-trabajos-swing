package TrabajoFinal;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame implements ActionListener{
	private JLabel usuario = new JLabel("Usuario");
	private JLabel pass = new JLabel("Contraseña");
	private JButton aceptar = new JButton("Aceptar"), borrar = new JButton("Borrar"),salir = new JButton("Salir") ;
	private JTextField ingresoUsuario = new JTextField(10);
	private JTextField ingresoPass = new JTextField(10);
	private Usuario[] usuarios = Variables.usuarios;
	private Usuario usuarioActual;
	Container grilla;
	public VentanaLogin()
	{
		setSize(250,250);//ancho,alto
		
		setLocationRelativeTo(null);//centrado
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);//DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
		setTitle("Fotocopias");
		iniciarComponentes();
	}
	private void iniciarComponentes()
	{
		colocarPaneles();
	}
	private void colocarPaneles()
	{
		grilla = getContentPane();
		grilla.setLayout(new GridLayout(3,1));
		agregarPanel(usuario,ingresoUsuario);
		agregarPanel(pass,ingresoPass);
		JPanel panel = new JPanel();
		panel.add(aceptar);
		panel.add(borrar);
		panel.add(salir);
		grilla.add(panel);
		aceptar.addActionListener(this);
		borrar.addActionListener(this);
		salir.addActionListener(this);
	}
	private void agregarPanel(JLabel etiqueta, JTextField ingreso) {
		JPanel panel = new JPanel();
		panel.add(etiqueta);
		panel.add(ingreso);
		grilla.add(panel);
	}
	public void actionPerformed(ActionEvent evento)
    {
    
        if (evento.getSource()==aceptar){
            
            verificar();
    
        }
        if (evento.getSource()==borrar){
            ingresoUsuario.setText("");
            ingresoPass.setText("");
        }
        if (evento.getSource()==salir)
        {
            
            salida();
    
        }
        
    }
	public void verificar() {		
		boolean flag = false;
		for (int i = 0; i < usuarios.length; i++) {
			if (ingresoUsuario.getText().equals(usuarios[i].nombre)
					&& ingresoPass.getText().equals(usuarios[i].password)) {
				flag = true;
				usuarioActual = usuarios[i];
				mostrar();
				break;
			}
		}
		if (!flag) {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		}
	}
	public void mostrar() {
		if (usuarioActual.tipo.equals("admin")) {
            VentanaAdmin v1 = new VentanaAdmin();
            v1.setVisible(true);
            setVisible(false);
        } else {
            VentanaUser v1 = new VentanaUser();
            v1.setVisible(true);
            setVisible(false);
        }
	}

	public void salida() {
		System.exit(0);
	}
	
}
