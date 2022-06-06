package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class PanelVisualizacion extends JPanel 
{
	private Interfaz ventana;
	private JLabel dia1;
	private JLabel dia2;
	private JLabel dia3;
	private JLabel dia4;
	private JLabel dia5;
	private JLabel dia6;
	private JLabel dia7;
	private JLabel dia8;
	private JLabel dia9;
	private JLabel dia10;
	private JLabel dia11;
	private JLabel dia12;
	private JLabel dia13;
	private JLabel dia14;
	private JLabel dia15;
	private JLabel dia16;
	private JLabel dia17;
	private JLabel dia18;
	private JLabel dia19;
	private JLabel dia20;
	private JLabel dia21;
	private JLabel dia22;
	private JLabel dia23;
	private JLabel dia24;
	private JLabel dia25;
	private JLabel dia26;
	private JLabel dia27;
	private JLabel dia28;
	private JLabel dia29;
	private JLabel dia30;
	private JLabel dia31;
	
	private JTextField diaa1;
	private JTextField diaa2;
	private JTextField diaa3;
	private JTextField diaa4;
	private JTextField diaa5;
	private JTextField diaa6;
	private JTextField diaa7;
	private JTextField diaa8;
	private JTextField diaa9;
	private JTextField diaa10;
	private JTextField diaa11;
	private JTextField diaa12;
	private JTextField diaa13;
	private JTextField diaa14;
	private JTextField diaa15;
	private JTextField diaa16;
	private JTextField diaa17;
	private JTextField diaa18;
	private JTextField diaa19;
	private JTextField diaa20;
	private JTextField diaa21;
	private JTextField diaa22;
	private JTextField diaa23;
	private JTextField diaa24;
	private JTextField diaa25;
	private JTextField diaa26;
	private JTextField diaa27;
	private JTextField diaa28;
	private JTextField diaa29;
	private JTextField diaa30;
	private JTextField diaa31;
	private HashMap<LocalDate, String> fechas;
	private JComboBox anio;
	private JComboBox mes;
	private JLabel lanio;
	private JLabel lmes;
	private JLabel lnada;
	private JButton mostrar;
	private int aniomin;
	private int aniomax;
	private boolean centinela = false;

	

	public PanelVisualizacion(Interfaz interfaz, HashMap<LocalDate, String> lasfechas) throws Exception {
		this.ventana = interfaz;
		this.fechas = lasfechas;
    	setLayout( new GridLayout(30,2) );
		int contador = 0;
		aniomax = 0;
		aniomin = 99999;
		
        setPreferredSize( new Dimension( 400, 1800 ) );
        setBackground(new Color(214, 255, 222));
        
        if(fechas.size()<1)
        {
        	throw new Exception("NO HAY FECHAS PA MOSTRAR");
        }
        else
        {

            for (Map.Entry<LocalDate, String> pareja : fechas.entrySet())
            {
            	LocalDate lafecha = pareja.getKey();
            	if(lafecha.getYear()<aniomin)
            	{
            		aniomin = lafecha.getYear();
            	}
            	else if(lafecha.getYear()>aniomax)
            	{
            		aniomax = lafecha.getYear();
            	}
            }
            
            String[] anios = new String[aniomax-aniomin+1];  //OJO CON ESTE ERROR: DEBERIA IR aniomax-aniomin+1
            for (int i = aniomin; i<aniomax+1;i++)
            {
            	anios[i-aniomin] = String.valueOf(i);
            	
            }
            String[] meses = new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"
            		, "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            
            anio = new JComboBox(anios);
    		add(anio);
    		anio.setSelectedIndex(0);
    		
    		mes = new JComboBox(meses);
    		add(mes);
    		mes.setSelectedIndex(0);
    		lnada = new JLabel();
    		lnada.setText(" ");
    		add(lnada);
        }
        
		
		mostrar = new JButton("Mostrar");
		
		mostrar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		String s = e.getActionCommand();
                if (s.equals("Mostrar")) {
                	if (centinela) {
                		remove(dia1);
                		remove(dia2);
                		remove(dia3);
                		remove(dia4);
                		remove(dia5);
                		remove(dia6);
                		remove(dia7);
                		remove(dia8);
                		remove(dia9);
                		remove(dia10);
                		remove(dia11);
                		remove(dia12);
                		remove(dia13);
                		remove(dia14);
                		remove(dia15);
                		remove(dia16);
                		remove(dia17);
                		remove(dia18);
                		remove(dia19);
                		remove(dia20);
                		remove(dia21);
                		remove(dia22);
                		remove(dia23);
                		remove(dia24);
                		remove(dia25);
                		remove(dia26);
                		remove(dia27);
                		remove(dia28);
                		remove(diaa1);
                		remove(diaa2);
                		remove(diaa3);
                		remove(diaa4);
                		remove(diaa5);
                		remove(diaa6);
                		remove(diaa7);
                		remove(diaa8);
                		remove(diaa9);
                		remove(diaa10);
                		remove(diaa11);
                		remove(diaa12);
                		remove(diaa13);
                		remove(diaa14);
                		remove(diaa15);
                		remove(diaa16);
                		remove(diaa17);
                		remove(diaa18);
                		remove(diaa19);
                		remove(diaa20);
                		remove(diaa21);
                		remove(diaa22);
                		remove(diaa23);
                		remove(diaa24);
                		remove(diaa25);
                		remove(diaa26);
                		remove(diaa27);
                		remove(diaa28);
                		int elanio = anio.getSelectedIndex();
                    	int elmes = mes.getSelectedIndex();
                    	dia1 = new JLabel();
                        dia1.setText("Dia 1");
                        add(dia1);
                        LocalDate fecha1 = LocalDate.of(elanio+aniomin, elmes+1, 1);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa1 = new JTextField(fechas.get(fecha1), 10);
                            add(diaa1);
                            diaa1.setEditable(false);
                        }
                        else
                        {
                        	diaa1 = new JTextField( 10);
                            add(diaa1);
                            diaa1.setEditable(false);
                        }
                        dia2 = new JLabel();
                        dia2.setText("Dia 2");
                        add(dia2);
                        LocalDate fecha2 = LocalDate.of(elanio+aniomin, elmes+1, 2);
                        if(fechas.containsKey(fecha2))
                        {
                        	diaa2 = new JTextField(fechas.get(fecha2), 10);
                            add(diaa2);
                            diaa2.setEditable(false);
                        }
                        else
                        {
                        	diaa2 = new JTextField( 10);
                            add(diaa2);
                            diaa2.setEditable(false);
                        }
                        dia3 = new JLabel();
                        dia3.setText("Dia 3");
                        add(dia3);
                        LocalDate fecha3 = LocalDate.of(elanio+aniomin, elmes+1, 3);
                        if(fechas.containsKey(fecha3))
                        {
                        	diaa3 = new JTextField(fechas.get(fecha3), 10);
                            add(diaa3);
                            diaa3.setEditable(false);
                        }
                        else
                        {
                        	diaa3 = new JTextField( 10);
                            add(diaa3);
                            diaa3.setEditable(false);
                        }
                        dia4 = new JLabel();
                        dia4.setText("Dia 4");
                        add(dia4);
                        LocalDate fecha4 = LocalDate.of(elanio+aniomin, elmes+1, 4);
                        if(fechas.containsKey(fecha4))
                        {
                        	diaa4 = new JTextField(fechas.get(fecha4), 10);
                            add(diaa4);
                            diaa4.setEditable(false);
                        }
                        else
                        {
                        	diaa4 = new JTextField( 10);
                            add(diaa4);
                            diaa4.setEditable(false);
                        }
                        dia5 = new JLabel();
                        dia5.setText("Dia 5");
                        add(dia5);
                        LocalDate fecha5 = LocalDate.of(elanio+aniomin, elmes+1, 5);
                        if(fechas.containsKey(fecha5))
                        {
                        	diaa5 = new JTextField(fechas.get(fecha5), 10);
                            add(diaa5);
                            diaa5.setEditable(false);
                        }
                        else
                        {
                        	diaa5 = new JTextField( 10);
                            add(diaa5);
                            diaa5.setEditable(false);
                        }
                        dia6 = new JLabel();
                        dia6.setText("Dia 6");
                        add(dia6);
                        LocalDate fecha6 = LocalDate.of(elanio+aniomin, elmes+1, 6);
                        if(fechas.containsKey(fecha6))
                        {
                        	diaa6 = new JTextField(fechas.get(fecha6), 10);
                            add(diaa6);
                            diaa6.setEditable(false);
                        }
                        else
                        {
                        	diaa6 = new JTextField( 10);
                            add(diaa6);
                            diaa6.setEditable(false);
                        }
                        dia7 = new JLabel();
                        dia7.setText("Dia 7");
                        add(dia7);
                        LocalDate fecha7 = LocalDate.of(elanio+aniomin, elmes+1, 7);
                        if(fechas.containsKey(fecha7))
                        {
                        	diaa7 = new JTextField(fechas.get(fecha7), 10);
                            add(diaa7);
                            diaa7.setEditable(false);
                        }
                        else
                        {
                        	diaa7 = new JTextField( 10);
                            add(diaa7);
                            diaa7.setEditable(false);
                        }
                        dia8 = new JLabel();
                        dia8.setText("Dia 8");
                        add(dia8);
                        LocalDate fecha8 = LocalDate.of(elanio+aniomin, elmes+1, 8);
                        if(fechas.containsKey(fecha8))
                        {
                        	diaa8 = new JTextField(fechas.get(fecha8), 10);
                            add(diaa8);
                            diaa8.setEditable(false);
                        }
                        else
                        {
                        	diaa8 = new JTextField( 10);
                            add(diaa8);
                            diaa8.setEditable(false);
                        }
                        dia9 = new JLabel();
                        dia9.setText("Dia 9");
                        add(dia9);
                        LocalDate fecha9 = LocalDate.of(elanio+aniomin, elmes+1, 9);
                        if(fechas.containsKey(fecha9))
                        {
                        	diaa9 = new JTextField(fechas.get(fecha9), 10);
                            add(diaa9);
                            diaa9.setEditable(false);
                        }
                        else
                        {
                        	diaa9 = new JTextField( 10);
                            add(diaa9);
                            diaa9.setEditable(false);
                        }
                        dia10 = new JLabel();
                        dia10.setText("Dia 10");
                        add(dia10);
                        LocalDate fecha10 = LocalDate.of(elanio+aniomin, elmes+1, 10);
                        if(fechas.containsKey(fecha10))
                        {
                        	diaa10 = new JTextField(fechas.get(fecha10), 10);
                            add(diaa10);
                            diaa10.setEditable(false);
                        }
                        else
                        {
                        	diaa10 = new JTextField( 10);
                            add(diaa10);
                            diaa10.setEditable(false);
                        }
                        dia11 = new JLabel();
                        dia11.setText("Dia 11");
                        add(dia11);
                        LocalDate fecha11 = LocalDate.of(elanio+aniomin, elmes+1, 11);
                        if(fechas.containsKey(fecha11))
                        {
                        	diaa11 = new JTextField(fechas.get(fecha11), 10);
                            add(diaa11);
                            diaa11.setEditable(false);
                        }
                        else
                        {
                        	diaa11 = new JTextField( 10);
                            add(diaa11);
                            diaa11.setEditable(false);
                        }
                        dia12 = new JLabel();
                        dia12.setText("Dia 12");
                        add(dia12);
                        LocalDate fecha12 = LocalDate.of(elanio+aniomin, elmes+1, 12);
                        if(fechas.containsKey(fecha12))
                        {
                        	diaa12 = new JTextField(fechas.get(fecha12), 10);
                            add(diaa12);
                            diaa12.setEditable(false);
                        }
                        else
                        {
                        	diaa12 = new JTextField( 10);
                            add(diaa12);
                            diaa12.setEditable(false);
                        }
                        dia13 = new JLabel();
                        dia13.setText("Dia 13");
                        add(dia13);
                        LocalDate fecha13 = LocalDate.of(elanio+aniomin, elmes+1, 13);
                        if(fechas.containsKey(fecha13))
                        {
                        	diaa13 = new JTextField(fechas.get(fecha13), 10);
                            add(diaa13);
                            diaa13.setEditable(false);
                        }
                        else
                        {
                        	diaa13 = new JTextField( 10);
                            add(diaa13);
                            diaa13.setEditable(false);
                        }
                        dia14 = new JLabel();
                        dia14.setText("Dia 14");
                        add(dia14);
                        LocalDate fecha14 = LocalDate.of(elanio+aniomin, elmes+1, 14);
                        if(fechas.containsKey(fecha14))
                        {
                        	diaa14 = new JTextField(fechas.get(fecha14), 10);
                            add(diaa14);
                            diaa14.setEditable(false);
                        }
                        else
                        {
                        	diaa14 = new JTextField( 10);
                            add(diaa14);
                            diaa14.setEditable(false);
                        }
                        dia15 = new JLabel();
                        dia15.setText("Dia 15");
                        add(dia15);
                        LocalDate fecha15 = LocalDate.of(elanio+aniomin, elmes+1, 15);
                        if(fechas.containsKey(fecha15))
                        {
                        	diaa15 = new JTextField(fechas.get(fecha15), 10);
                            add(diaa15);
                            diaa15.setEditable(false);
                        }
                        else
                        {
                        	diaa15 = new JTextField( 10);
                            add(diaa15);
                            diaa15.setEditable(false);
                        }
                        dia16 = new JLabel();
                        dia16.setText("Dia 16");
                        add(dia16);
                        //dia16.1(10, 150, 250, 50);
                        LocalDate fecha16 = LocalDate.of(elanio+aniomin, elmes+1, 16);
                        if(fechas.containsKey(fecha16))
                        {
                        	diaa16 = new JTextField(fechas.get(fecha16), 10);
                            add(diaa16);
                            diaa16.setEditable(false);
                        }
                        else
                        {
                        	diaa16 = new JTextField( 10);
                            add(diaa16);
                            diaa16.setEditable(false);
                        }
                        dia17 = new JLabel();
                        dia17.setText("Dia 17");
                        add(dia17);
                        LocalDate fecha17 = LocalDate.of(elanio+aniomin, elmes+1, 17);
                        if(fechas.containsKey(fecha17))
                        {
                        	diaa17 = new JTextField(fechas.get(fecha17), 10);
                            add(diaa17);
                            diaa17.setEditable(false);
                        }
                        else
                        {
                        	diaa17 = new JTextField( 10);
                            add(diaa17);
                            diaa17.setEditable(false);
                        }
                        dia18 = new JLabel();
                        dia18.setText("Dia 18");
                        add(dia18);
                        LocalDate fecha18 = LocalDate.of(elanio+aniomin, elmes+1, 18);
                        if(fechas.containsKey(fecha18))
                        {
                        	diaa18 = new JTextField(fechas.get(fecha18), 10);
                            add(diaa18);
                            diaa18.setEditable(false);
                        }
                        else
                        {
                        	diaa18 = new JTextField( 10);
                            add(diaa18);
                            diaa18.setEditable(false);
                        }
                        dia19 = new JLabel();
                        dia19.setText("Dia 19");
                        add(dia19);
                        LocalDate fecha19 = LocalDate.of(elanio+aniomin, elmes+1, 19);
                        if(fechas.containsKey(fecha19))
                        {
                        	diaa19 = new JTextField(fechas.get(fecha1), 10);
                            add(diaa19);
                            diaa19.setEditable(false);
                        }
                        else
                        {
                        	diaa19 = new JTextField( 10);
                            add(diaa19);
                            diaa19.setEditable(false);
                        }
                        
                        dia20 = new JLabel();
                        dia20.setText("Dia 20");
                        add(dia20);
                        LocalDate fecha20 = LocalDate.of(elanio+aniomin, elmes+1, 20);
                        if(fechas.containsKey(fecha20))
                        {
                        	diaa20 = new JTextField(fechas.get(fecha20), 10);
                            add(diaa20);
                            diaa20.setEditable(false);
                        }
                        else
                        {
                        	diaa20 = new JTextField( 10);
                            add(diaa20);
                            diaa20.setEditable(false);
                        }
                        dia21 = new JLabel();
                        dia21.setText("Dia 21");
                        add(dia21);
                        LocalDate fecha21 = LocalDate.of(elanio+aniomin, elmes+1, 21);
                        if(fechas.containsKey(fecha21))
                        {
                        	diaa21 = new JTextField(fechas.get(fecha1), 10);
                            add(diaa21);
                            diaa21.setEditable(false);
                        }
                        else
                        {
                        	diaa21 = new JTextField( 10);
                            add(diaa21);
                            diaa21.setEditable(false);
                        }
                        dia22 = new JLabel();
                        dia22.setText("Dia 22");
                        add(dia22);
                        LocalDate fecha22 = LocalDate.of(elanio+aniomin, elmes+1, 22);
                        if(fechas.containsKey(fecha22))
                        {
                        	diaa22 = new JTextField(fechas.get(fecha1), 22);
                            add(diaa22);
                            diaa22.setEditable(false);
                        }
                        else
                        {
                        	diaa22 = new JTextField( 10);
                            add(diaa22);
                            diaa22.setEditable(false);
                        }
                        dia23 = new JLabel();
                        dia23.setText("Dia 23");
                        add(dia23);
                        LocalDate fecha23 = LocalDate.of(elanio+aniomin, elmes+1, 23);
                        if(fechas.containsKey(fecha23))
                        {
                        	diaa23 = new JTextField(fechas.get(fecha23), 10);
                            add(diaa23);
                            diaa23.setEditable(false);
                        }
                        else
                        {
                        	diaa23 = new JTextField( 10);
                            add(diaa23);
                            diaa23.setEditable(false);
                        }
                        dia24 = new JLabel();
                        dia24.setText("Dia 24");
                        add(dia24);
                        LocalDate fecha24 = LocalDate.of(elanio+aniomin, elmes+1, 24);
                        if(fechas.containsKey(fecha24))
                        {
                        	diaa24 = new JTextField(fechas.get(fecha24), 10);
                            add(diaa24);
                            diaa24.setEditable(false);
                        }
                        else
                        {
                        	diaa24 = new JTextField( 10);
                            add(diaa24);
                            diaa24.setEditable(false);
                        }
                        dia25 = new JLabel();
                        dia25.setText("Dia 25");
                        add(dia25);
                        LocalDate fecha25 = LocalDate.of(elanio+aniomin, elmes+1, 25);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa25 = new JTextField(fechas.get(fecha25), 10);
                            add(diaa25);
                            diaa25.setEditable(false);
                        }
                        else
                        {
                        	diaa25 = new JTextField( 10);
                            add(diaa25);
                            diaa25.setEditable(false);
                        }
                        dia26 = new JLabel();
                        dia26.setText("Dia 26");
                        add(dia26);
                        LocalDate fecha26 = LocalDate.of(elanio+aniomin, elmes+1, 26);
                        if(fechas.containsKey(fecha26))
                        {
                        	diaa26 = new JTextField(fechas.get(fecha26), 10);
                            add(diaa26);
                            diaa26.setEditable(false);
                        }
                        else
                        {
                        	diaa26 = new JTextField( 10);
                            add(diaa26);
                            diaa26.setEditable(false);
                        }
                        
                        dia27 = new JLabel();
                        dia27.setText("Dia 27");
                        add(dia27);

                        LocalDate fecha27 = LocalDate.of(elanio+aniomin, elmes+1, 27);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa27 = new JTextField(fechas.get(fecha27), 10);
                            add(diaa27);
                            diaa27.setEditable(false);
                        }
                        else
                        {
                        	diaa27 = new JTextField( 10);
                            add(diaa27);
                            diaa27.setEditable(false);
                        }
                        dia28 = new JLabel();
                        dia28.setText("Dia 28");
                        add(dia28);
                        LocalDate fecha28 = LocalDate.of(elanio+aniomin, elmes+1, 27);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa28 = new JTextField(fechas.get(fecha28), 10);
                            add(diaa28);
                            diaa28.setEditable(false);
                        }
                        else
                        {
                        	diaa28 = new JTextField( 10);
                            add(diaa28);
                            diaa28.setEditable(false);
                        }
                		
                		
                	}
                	else {
                		int elanio = anio.getSelectedIndex();
                    	int elmes = mes.getSelectedIndex();
                    	dia1 = new JLabel();
                        dia1.setText("Dia 1");
                        add(dia1);
                        LocalDate fecha1 = LocalDate.of(elanio+aniomin, elmes+1, 1);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa1 = new JTextField(fechas.get(fecha1), 10);
                            add(diaa1);
                            diaa1.setEditable(false);
                        }
                        else
                        {
                        	diaa1 = new JTextField( 10);
                            add(diaa1);
                            diaa1.setEditable(false);
                        }
                        dia2 = new JLabel();
                        dia2.setText("Dia 2");
                        add(dia2);
                        LocalDate fecha2 = LocalDate.of(elanio+aniomin, elmes+1, 2);
                        if(fechas.containsKey(fecha2))
                        {
                        	diaa2 = new JTextField(fechas.get(fecha2), 10);
                            add(diaa2);
                            diaa2.setEditable(false);
                        }
                        else
                        {
                        	diaa2 = new JTextField( 10);
                            add(diaa2);
                            diaa2.setEditable(false);
                        }
                        dia3 = new JLabel();
                        dia3.setText("Dia 3");
                        add(dia3);
                        LocalDate fecha3 = LocalDate.of(elanio+aniomin, elmes+1, 3);
                        if(fechas.containsKey(fecha3))
                        {
                        	diaa3 = new JTextField(fechas.get(fecha3), 10);
                            add(diaa3);
                            diaa3.setEditable(false);
                        }
                        else
                        {
                        	diaa3 = new JTextField( 10);
                            add(diaa3);
                            diaa3.setEditable(false);
                        }
                        dia4 = new JLabel();
                        dia4.setText("Dia 4");
                        add(dia4);
                        LocalDate fecha4 = LocalDate.of(elanio+aniomin, elmes+1, 4);
                        if(fechas.containsKey(fecha4))
                        {
                        	diaa4 = new JTextField(fechas.get(fecha4), 10);
                            add(diaa4);
                            diaa4.setEditable(false);
                        }
                        else
                        {
                        	diaa4 = new JTextField( 10);
                            add(diaa4);
                            diaa4.setEditable(false);
                        }
                        dia5 = new JLabel();
                        dia5.setText("Dia 5");
                        add(dia5);
                        LocalDate fecha5 = LocalDate.of(elanio+aniomin, elmes+1, 5);
                        if(fechas.containsKey(fecha5))
                        {
                        	diaa5 = new JTextField(fechas.get(fecha5), 10);
                            add(diaa5);
                            diaa5.setEditable(false);
                        }
                        else
                        {
                        	diaa5 = new JTextField( 10);
                            add(diaa5);
                            diaa5.setEditable(false);
                        }
                        dia6 = new JLabel();
                        dia6.setText("Dia 6");
                        add(dia6);
                        LocalDate fecha6 = LocalDate.of(elanio+aniomin, elmes+1, 6);
                        if(fechas.containsKey(fecha6))
                        {
                        	diaa6 = new JTextField(fechas.get(fecha6), 10);
                            add(diaa6);
                            diaa6.setEditable(false);
                        }
                        else
                        {
                        	diaa6 = new JTextField( 10);
                            add(diaa6);
                            diaa6.setEditable(false);
                        }
                        dia7 = new JLabel();
                        dia7.setText("Dia 7");
                        add(dia7);
                        LocalDate fecha7 = LocalDate.of(elanio+aniomin, elmes+1, 7);
                        if(fechas.containsKey(fecha7))
                        {
                        	diaa7 = new JTextField(fechas.get(fecha7), 10);
                            add(diaa7);
                            diaa7.setEditable(false);
                        }
                        else
                        {
                        	diaa7 = new JTextField( 10);
                            add(diaa7);
                            diaa7.setEditable(false);
                        }
                        dia8 = new JLabel();
                        dia8.setText("Dia 8");
                        add(dia8);
                        LocalDate fecha8 = LocalDate.of(elanio+aniomin, elmes+1, 8);
                        if(fechas.containsKey(fecha8))
                        {
                        	diaa8 = new JTextField(fechas.get(fecha8), 10);
                            add(diaa8);
                            diaa8.setEditable(false);
                        }
                        else
                        {
                        	diaa8 = new JTextField( 10);
                            add(diaa8);
                            diaa8.setEditable(false);
                        }
                        dia9 = new JLabel();
                        dia9.setText("Dia 9");
                        add(dia9);
                        LocalDate fecha9 = LocalDate.of(elanio+aniomin, elmes+1, 9);
                        if(fechas.containsKey(fecha9))
                        {
                        	diaa9 = new JTextField(fechas.get(fecha9), 10);
                            add(diaa9);
                            diaa9.setEditable(false);
                        }
                        else
                        {
                        	diaa9 = new JTextField( 10);
                            add(diaa9);
                            diaa9.setEditable(false);
                        }
                        dia10 = new JLabel();
                        dia10.setText("Dia 10");
                        add(dia10);
                        LocalDate fecha10 = LocalDate.of(elanio+aniomin, elmes+1, 10);
                        if(fechas.containsKey(fecha10))
                        {
                        	diaa10 = new JTextField(fechas.get(fecha10), 10);
                            add(diaa10);
                            diaa10.setEditable(false);
                        }
                        else
                        {
                        	diaa10 = new JTextField( 10);
                            add(diaa10);
                            diaa10.setEditable(false);
                        }
                        dia11 = new JLabel();
                        dia11.setText("Dia 11");
                        add(dia11);
                        LocalDate fecha11 = LocalDate.of(elanio+aniomin, elmes+1, 11);
                        if(fechas.containsKey(fecha11))
                        {
                        	diaa11 = new JTextField(fechas.get(fecha11), 10);
                            add(diaa11);
                            diaa11.setEditable(false);
                        }
                        else
                        {
                        	diaa11 = new JTextField( 10);
                            add(diaa11);
                            diaa11.setEditable(false);
                        }
                        dia12 = new JLabel();
                        dia12.setText("Dia 12");
                        add(dia12);
                        LocalDate fecha12 = LocalDate.of(elanio+aniomin, elmes+1, 12);
                        if(fechas.containsKey(fecha12))
                        {
                        	diaa12 = new JTextField(fechas.get(fecha12), 10);
                            add(diaa12);
                            diaa12.setEditable(false);
                        }
                        else
                        {
                        	diaa12 = new JTextField( 10);
                            add(diaa12);
                            diaa12.setEditable(false);
                        }
                        dia13 = new JLabel();
                        dia13.setText("Dia 13");
                        add(dia13);
                        LocalDate fecha13 = LocalDate.of(elanio+aniomin, elmes+1, 13);
                        if(fechas.containsKey(fecha13))
                        {
                        	diaa13 = new JTextField(fechas.get(fecha13), 10);
                            add(diaa13);
                            diaa13.setEditable(false);
                        }
                        else
                        {
                        	diaa13 = new JTextField( 10);
                            add(diaa13);
                            diaa13.setEditable(false);
                        }
                        dia14 = new JLabel();
                        dia14.setText("Dia 14");
                        add(dia14);
                        LocalDate fecha14 = LocalDate.of(elanio+aniomin, elmes+1, 14);
                        if(fechas.containsKey(fecha14))
                        {
                        	diaa14 = new JTextField(fechas.get(fecha14), 10);
                            add(diaa14);
                            diaa14.setEditable(false);
                        }
                        else
                        {
                        	diaa14 = new JTextField( 10);
                            add(diaa14);
                            diaa14.setEditable(false);
                        }
                        dia15 = new JLabel();
                        dia15.setText("Dia 15");
                        add(dia15);
                        LocalDate fecha15 = LocalDate.of(elanio+aniomin, elmes+1, 15);
                        if(fechas.containsKey(fecha15))
                        {
                        	diaa15 = new JTextField(fechas.get(fecha15), 10);
                            add(diaa15);
                            diaa15.setEditable(false);
                        }
                        else
                        {
                        	diaa15 = new JTextField( 10);
                            add(diaa15);
                            diaa15.setEditable(false);
                        }
                        dia16 = new JLabel();
                        dia16.setText("Dia 16");
                        add(dia16);
                        //dia16.1(10, 150, 250, 50);
                        LocalDate fecha16 = LocalDate.of(elanio+aniomin, elmes+1, 16);
                        if(fechas.containsKey(fecha16))
                        {
                        	diaa16 = new JTextField(fechas.get(fecha16), 10);
                            add(diaa16);
                            diaa16.setEditable(false);
                        }
                        else
                        {
                        	diaa16 = new JTextField( 10);
                            add(diaa16);
                            diaa16.setEditable(false);
                        }
                        dia17 = new JLabel();
                        dia17.setText("Dia 17");
                        add(dia17);
                        LocalDate fecha17 = LocalDate.of(elanio+aniomin, elmes+1, 17);
                        if(fechas.containsKey(fecha17))
                        {
                        	diaa17 = new JTextField(fechas.get(fecha17), 10);
                            add(diaa17);
                            diaa17.setEditable(false);
                        }
                        else
                        {
                        	diaa17 = new JTextField( 10);
                            add(diaa17);
                            diaa17.setEditable(false);
                        }
                        dia18 = new JLabel();
                        dia18.setText("Dia 18");
                        add(dia18);
                        LocalDate fecha18 = LocalDate.of(elanio+aniomin, elmes+1, 18);
                        if(fechas.containsKey(fecha18))
                        {
                        	diaa18 = new JTextField(fechas.get(fecha18), 10);
                            add(diaa18);
                            diaa18.setEditable(false);
                        }
                        else
                        {
                        	diaa18 = new JTextField( 10);
                            add(diaa18);
                            diaa18.setEditable(false);
                        }
                        dia19 = new JLabel();
                        dia19.setText("Dia 19");
                        add(dia19);
                        LocalDate fecha19 = LocalDate.of(elanio+aniomin, elmes+1, 19);
                        if(fechas.containsKey(fecha19))
                        {
                        	diaa19 = new JTextField(fechas.get(fecha1), 10);
                            add(diaa19);
                            diaa19.setEditable(false);
                        }
                        else
                        {
                        	diaa19 = new JTextField( 10);
                            add(diaa19);
                            diaa19.setEditable(false);
                        }
                        
                        dia20 = new JLabel();
                        dia20.setText("Dia 20");
                        add(dia20);
                        LocalDate fecha20 = LocalDate.of(elanio+aniomin, elmes+1, 20);
                        if(fechas.containsKey(fecha20))
                        {
                        	diaa20 = new JTextField(fechas.get(fecha20), 10);
                            add(diaa20);
                            diaa20.setEditable(false);
                        }
                        else
                        {
                        	diaa20 = new JTextField( 10);
                            add(diaa20);
                            diaa20.setEditable(false);
                        }
                        dia21 = new JLabel();
                        dia21.setText("Dia 21");
                        add(dia21);
                        LocalDate fecha21 = LocalDate.of(elanio+aniomin, elmes+1, 21);
                        if(fechas.containsKey(fecha21))
                        {
                        	diaa21 = new JTextField(fechas.get(fecha1), 10);
                            add(diaa21);
                            diaa21.setEditable(false);
                        }
                        else
                        {
                        	diaa21 = new JTextField( 10);
                            add(diaa21);
                            diaa21.setEditable(false);
                        }
                        dia22 = new JLabel();
                        dia22.setText("Dia 22");
                        add(dia22);
                        LocalDate fecha22 = LocalDate.of(elanio+aniomin, elmes+1, 22);
                        if(fechas.containsKey(fecha22))
                        {
                        	diaa22 = new JTextField(fechas.get(fecha1), 22);
                            add(diaa22);
                            diaa22.setEditable(false);
                        }
                        else
                        {
                        	diaa22 = new JTextField( 10);
                            add(diaa22);
                            diaa22.setEditable(false);
                        }
                        dia23 = new JLabel();
                        dia23.setText("Dia 23");
                        add(dia23);
                        LocalDate fecha23 = LocalDate.of(elanio+aniomin, elmes+1, 23);
                        if(fechas.containsKey(fecha23))
                        {
                        	diaa23 = new JTextField(fechas.get(fecha23), 10);
                            add(diaa23);
                            diaa23.setEditable(false);
                        }
                        else
                        {
                        	diaa23 = new JTextField( 10);
                            add(diaa23);
                            diaa23.setEditable(false);
                        }
                        dia24 = new JLabel();
                        dia24.setText("Dia 24");
                        add(dia24);
                        LocalDate fecha24 = LocalDate.of(elanio+aniomin, elmes+1, 24);
                        if(fechas.containsKey(fecha24))
                        {
                        	diaa24 = new JTextField(fechas.get(fecha24), 10);
                            add(diaa24);
                            diaa24.setEditable(false);
                        }
                        else
                        {
                        	diaa24 = new JTextField( 10);
                            add(diaa24);
                            diaa24.setEditable(false);
                        }
                        dia25 = new JLabel();
                        dia25.setText("Dia 25");
                        add(dia25);
                        LocalDate fecha25 = LocalDate.of(elanio+aniomin, elmes+1, 25);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa25 = new JTextField(fechas.get(fecha25), 10);
                            add(diaa25);
                            diaa25.setEditable(false);
                        }
                        else
                        {
                        	diaa25 = new JTextField( 10);
                            add(diaa25);
                            diaa25.setEditable(false);
                        }
                        dia26 = new JLabel();
                        dia26.setText("Dia 26");
                        add(dia26);
                        LocalDate fecha26 = LocalDate.of(elanio+aniomin, elmes+1, 26);
                        if(fechas.containsKey(fecha26))
                        {
                        	diaa26 = new JTextField(fechas.get(fecha26), 10);
                            add(diaa26);
                            diaa26.setEditable(false);
                        }
                        else
                        {
                        	diaa26 = new JTextField( 10);
                            add(diaa26);
                            diaa26.setEditable(false);
                        }
                        
                        dia27 = new JLabel();
                        dia27.setText("Dia 27");
                        add(dia27);

                        LocalDate fecha27 = LocalDate.of(elanio+aniomin, elmes+1, 27);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa27 = new JTextField(fechas.get(fecha27), 10);
                            add(diaa27);
                            diaa27.setEditable(false);
                        }
                        else
                        {
                        	diaa27 = new JTextField( 10);
                            add(diaa27);
                            diaa27.setEditable(false);
                        }
                        dia28 = new JLabel();
                        dia28.setText("Dia 28");
                        add(dia28);
                        LocalDate fecha28 = LocalDate.of(elanio+aniomin, elmes+1, 27);
                        if(fechas.containsKey(fecha1))
                        {
                        	diaa28 = new JTextField(fechas.get(fecha28), 10);
                            add(diaa28);
                            diaa28.setEditable(false);
                        }
                        else
                        {
                        	diaa28 = new JTextField( 10);
                            add(diaa28);
                            diaa28.setEditable(false);
                        }
                        centinela = true;
                		
                	}
                	
                   
                    
                    
                    
                	
                }
            }  
        });
    	add(mostrar);
        //mostrar.1(10, 120, 100, 50);
		
        

        
	}

}
