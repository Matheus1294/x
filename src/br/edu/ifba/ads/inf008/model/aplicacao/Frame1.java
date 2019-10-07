package br.edu.ifba.ads.inf008.model.aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifba.ads.inf008.model.negocios.Pigmento;
import br.edu.ifba.ads.inf008.model.negocios.PigmentoRGB;
import br.edu.ifba.ads.inf008.model.sessao.PigmentoSession;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frame1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String rgb;
	private String quant;
	private int quantidade;

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public Frame1() {
		setTitle("Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRrggbb = new JLabel("RRGGBB");
		lblRrggbb.setBounds(4, 24, 61, 14);
		contentPane.add(lblRrggbb);
		
		textField = new JTextField();
		textField.setBounds(75, 21, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(4, 56, 71, 14);
		contentPane.add(lblQuantidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 53, 46, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(52, 97, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				rgb = textField.getText();
				quant = textField_1.getText();
				
				try {
					this.buscar(rgb, Integer.valueOf(quant));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
			
			public void buscar(String hexa, int quantidade) throws Exception {
				
				PigmentoSession sessao = new PigmentoSession();
				PigmentoRGB pigRGB = sessao.getPigmentoRGB(hexa);
				Pigmento pigmento = sessao.menor_distancia(quantidade, pigRGB);

				try {
					
					Frame2 frame2 = new Frame2(pigmento, quantidade);
				    frame2.setVisible(true); 
					
					
				}catch(Exception e) {
				   e.getMessage();
				}
				
			}
			
			
		});
		
		
	}
}
