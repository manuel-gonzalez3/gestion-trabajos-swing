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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame implements ActionListener{
	//declaracion de varibales de JFrame
	private JLabel usuario = new JLabel("Usuario");
	private JLabel pass = new JLabel("Contraseña");
	private JButton aceptar = new JButton("Aceptar"), borrar = new JButton("Borrar"),salir = new JButton("Salir") ;
	private JTextField ingresoUsuario = new JTextField(10);
	private JPasswordField ingresoPass = new JPasswordField(10);
	Container grilla;
	
	//traigo los usuarios a una variable local
	private Usuario[] usuarios = Variables.usuarios;
	
	
	
	public VentanaLogin()
	{
		setSize(250,250);//ancho,alto
		setResizable(false); // no se puede cambiar el tamaño
		setLocationRelativeTo(null);//centrado
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Inicio de sesion");
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
		
		//agrego los action listener
		aceptar.addActionListener(this);
		borrar.addActionListener(this);
		salir.addActionListener(this);
	}
	private void agregarPanel(JLabel etiqueta, JTextField ingreso) 
	{
		JPanel panel = new JPanel();
		panel.add(etiqueta);
		panel.add(ingreso);
		grilla.add(panel);
	}
	public void actionPerformed(ActionEvent evento)
    {
    
        if (evento.getSource()==aceptar)
        {
            
            verificar();
            mostrar();
    
        }
        if (evento.getSource()==borrar)
        {
            ingresoUsuario.setText("");
            ingresoPass.setText("");
        }
        if (evento.getSource()==salir)
        {
            
            salida();
    
        }
        
    }
	
	public void verificar() {		
		int flag = 0;
		for (int i = 0; i < Variables.contadorUsuarios; i++) 
		{
			if (ingresoUsuario.getText().equals(usuarios[i].nombre) && ingresoPass.getText().equals(usuarios[i].password)) 
			{
				if(usuarios[i].estado.equals("activo"))
				{
					flag = 1;
					Variables.usuarioActual = usuarios[i]; //guardo el usuario actual si pudo hacer el log in
					break;	
				}
				else
				{
					flag = 2; //si no esta activo
					break;
				}
			}
		}
		if (flag == 0)  //no encontró el usuario
		{
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		}
		if (flag == 2) //usario inactivo
		{
            JOptionPane.showMessageDialog(null, "Usuario inactivo");
		}
		
	}
	public void mostrar() 
	{
		if (Variables.usuarioActual.tipo.equals("admin")) 
		{
            VentanaAdmin v1 = new VentanaAdmin();
            v1.setVisible(true);
            setVisible(false);
        }
		else 
        {
            VentanaUser v1 = new VentanaUser();
            v1.setVisible(true);
            setVisible(false);
        }
	}

	public void salida() 
	{
		System.exit(0);
	}
	
}
