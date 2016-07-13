import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AppFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public AppFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		textField = new JTextField();
		textField.setBounds(53, 50, 327, 20);
		contentPane.add(textField);
		textField.setColumns(10);
				
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 21));
		lblNewLabel.setBounds(53, 129, 327, 53);
		contentPane.add(lblNewLabel);
		
		textField.addActionListener(e -> {
			lblNewLabel.setText(App.createMathShell().evaluate(textField.getText()).toString());
		});
		
	}
}
