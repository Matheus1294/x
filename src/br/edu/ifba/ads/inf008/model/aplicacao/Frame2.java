 
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
import br.edu.ifba.ads.inf008.model.sessao.PigmentoSession;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Frame2(Pigmento pigmento, int quantidade) {
		setTitle("Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 223, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 30, 14, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(56, 30, 89, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(pigmento.getId());
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 55, 36, 14);
		contentPane.add(lblNome);

		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(56, 55, 89, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(pigmento.getNome());
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 79, 36, 14);
		contentPane.add(lblPreo);
 		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(56, 80, 46, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText("" + (pigmento.getPreco()*quantidade));

		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setBounds(66, 113, 89, 23);
		contentPane.add(btnAceitar);
		
		btnAceitar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PigmentoSession sessao = new PigmentoSession();
					sessao.atualizarEstoque(pigmento.getQuantidade() - quantidade, pigmento.getId());
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		});
		
		
	}

}
