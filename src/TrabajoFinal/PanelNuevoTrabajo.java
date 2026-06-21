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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelNuevoTrabajo extends JFrame
{
	Trabajo[] trabajos = Variables.trabajos;
	JLabel cantCopias = new JLabel("Cantidad de copias");
	JLabel calidad = new JLabel("Calidad");
	static JTextField ingresoCantidad = new JTextField(10);
    static JRadioButton byn = new JRadioButton("Blanco y Negro",false);
    static JRadioButton color = new JRadioButton("Color",false);
    ButtonGroup calidadOpciones= new ButtonGroup();
	static String cantidadExpresion= "\\d+";
	static Usuario[] usuarios = Variables.usuarios;
	public JPanel panelNuevoTrabajo;
	
	public PanelNuevoTrabajo()
	{
		panelNuevoTrabajo = new JPanel(new GridLayout(4, 1, 50, 50));
		JLabel titulo = new JLabel("NUEVO TRABAJO", SwingConstants.CENTER);
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
		panelNuevoTrabajo.add(titulo);
		panelNuevoTrabajo.add(panel1);
		panelNuevoTrabajo.add(panel2);
		panelNuevoTrabajo.add(panel3);
	}
	
	public static void verificar() 
	{
		if (Variables.contadorTrabajos == 20)
		{
			JOptionPane.showMessageDialog(null, "No se pueden agregar mas trabajos");
		}
		else
		{
			if(!ingresoCantidad.getText().matches(cantidadExpresion))
			{
	            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico positivo en la cantidad de copias");
			}
			else if(byn.isSelected() || color.isSelected()) {
				crearTrabajo();
				JOptionPane.showMessageDialog(null, "Trabajo creado con exito");
			}
	        else
	        {
	        	JOptionPane.showMessageDialog(null, "Seleccione una calidad");
	        }
		}
	}

	public static void crearTrabajo() 
	{
        int cantidad = Integer.parseInt(ingresoCantidad.getText());
        String calidad = "";
        if(byn.isSelected())
        {
            calidad = "Byn";
        }
        else
        {
            calidad = "Color";
        }
        Variables.trabajos[Variables.contadorTrabajos] = new Trabajo(Variables.trabajos[Variables.contadorTrabajos-1].id+1,Variables.usuarioActual, cantidad, calidad); //id,usuario, cantidad, calidad
        Variables.contadorTrabajos++;
	}
	public JPanel getPanelNuevoTrabajo() 
	{
		return panelNuevoTrabajo;
	}

	public void setPanelNuevoTrabajo(JPanel panelNuevoTrabajo) 
	{
		this.panelNuevoTrabajo = panelNuevoTrabajo;
	}
}
