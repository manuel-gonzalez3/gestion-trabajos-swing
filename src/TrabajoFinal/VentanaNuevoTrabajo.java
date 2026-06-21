package TrabajoFinal;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaNuevoTrabajo extends JFrame implements ActionListener{
	Trabajo[] trabajos = Variables.trabajos;
	private JLabel cantCopias = new JLabel("Cantidad de copias");
	private JLabel calidad = new JLabel("Calidad");
	private JButton aceptar = new JButton("Aceptar"),salir = new JButton("Salir") ;
	private JTextField ingresoCantidad = new JTextField(10);
    private JRadioButton byn = new JRadioButton("Blanco y Negro",false);
    private JRadioButton color = new JRadioButton("Color",false);
    private ButtonGroup calidadOpciones= new ButtonGroup();
	private String cantidadExpresion= "\\d+";
	Container grilla;
	public VentanaNuevoTrabajo()
	{
		setSize(500,500);//ancho,alto
		
		setLocationRelativeTo(null);//centrado
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);//DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
		setTitle("Aplicacion UCEL");
		iniciarComponentes();
	}
	private void iniciarComponentes()
	{
		colocarPaneles();
	}
	private void colocarPaneles()
	{
		grilla = getContentPane();
		grilla.setLayout(new GridLayout(5,2));
		JPanel panel1 = new JPanel();
		panel1.add(cantCopias);
		panel1.add(ingresoCantidad);
		JPanel panel2 = new JPanel();
		panel2.add(calidad);
		calidadOpciones.add(byn);
		calidadOpciones.add(color);
		panel2.add(byn);
		panel2.add(color);
		JPanel panel3 = new JPanel();     
		panel3.add(aceptar);
		panel3.add(salir);
		grilla.add(panel1);
		grilla.add(panel2);
		grilla.add(panel3);
		aceptar.addActionListener(this);
		salir.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evento)
    {
    
        if (evento.getSource()==aceptar){
            
            verificar();
    
        }
        if (evento.getSource()==salir)
        {
            
            salida();
    
        }
        
    }
	public void verificar() {
		if(!ingresoCantidad.getText().matches(cantidadExpresion))
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico positivo en la cantidad de copias");
		else if(byn.isSelected())
        	JOptionPane.showMessageDialog(null, "Trabajo creado con "+ ingresoCantidad.getText()+" copias en Blanco");
		else if (color.isSelected())
			JOptionPane.showMessageDialog(null, "Trabajo creado con " + ingresoCantidad.getText() + " copias a Color");
        else
        	JOptionPane.showMessageDialog(null, "Seleccione una calidad");
	}
	public void salida() {
		System.exit(0);
	}
	
}
