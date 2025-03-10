package Login;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class LoginFrame extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel messageLabel;
	private boolean isPasswordVisible = false;

	public LoginFrame() {
		setTitle("Admin Login");
		setSize(450,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(5, 1, 5, 5));
		jpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//create button
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		JButton login = new JButton("Login");
		messageLabel = new JLabel("",SwingConstants.CENTER);
		messageLabel.setForeground(Color.RED);
		
		// Nút con mắt bật/tắt mật khẩu
		JButton togglePasswordButton = new JButton("👁️");
		togglePasswordButton.setPreferredSize(new Dimension(45, 25));
		togglePasswordButton.setFocusPainted(false);
		
		// Khi nhấn nút, thay đổi trạng thái hiển thị mật khẩu
		togglePasswordButton.addActionListener(e -> {
			isPasswordVisible = !isPasswordVisible;
			if (isPasswordVisible) {
				passwordField.setEchoChar((char) 0); // Hiển thị mật khẩu
			} else {
				passwordField.setEchoChar('*'); // Ẩn mật khẩu
			}
		});

		// Panel chứa passwordField + nút con mắt
		JPanel passwordPanel = new JPanel(new BorderLayout());
		passwordPanel.add(passwordField, BorderLayout.CENTER);
		passwordPanel.add(togglePasswordButton, BorderLayout.EAST);

		//Custom Button
		JPanel buttonLogin = new JPanel(new BorderLayout());
		buttonLogin.add(login, BorderLayout.CENTER);
		buttonLogin.add(messageLabel, BorderLayout.SOUTH);
		
		//add button
		jpanel.add(new JLabel("user name"));
		jpanel.add(usernameField);
		jpanel.add(new JLabel("password"));
		jpanel.add(passwordPanel);
		jpanel.add(buttonLogin);
		
		//xử lý sự kiện khi nhấn đăng nhập
		login.addActionListener(new LoginAction());
		
		add(jpanel);
		setVisible(true);
		}
	private class LoginAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = usernameField.getText();
			String password = new String (passwordField.getPassword());
			
			if(username.equals("Minh") && password.equals("696969")) {
				JOptionPane.showMessageDialog(LoginFrame.this, "Login Success!", "Notify!", JOptionPane.INFORMATION_MESSAGE);
				dispose(); //close window login
			}
			else {
				messageLabel.setText("Fail Login!");
			}
		}
	}
}


public class Login {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoginFrame login = new LoginFrame();
			login.setVisible(true);
		});
	}
}
