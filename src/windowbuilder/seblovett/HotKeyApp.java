package windowbuilder.seblovett;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotKeyApp extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JLabel lblTest;
	private JButton btnExit;
	String HotkeyFile;
	HotKeyParser hkp;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String fname = null;
					if (args.length == 1)
						fname = args[0];
					
					HotKeyApp frame = new HotKeyApp(fname);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HotKeyApp(String fname) {
		setOpacity(1.0f);
		//setUndecorated(true);
		this.HotkeyFile = fname;
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		hkp = new HotKeyParser("Test");
		
		
		lblTest = new JLabel(String.format("Test: %s", this.HotkeyFile));
		lblTest.setBounds(10, 11, 175, 14);
		contentPane.add(lblTest);
		
		btnExit = new JButton("X");
		/*btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});*/
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
			}
		});
		btnExit.setBounds(220, 11, 49, 23);
		contentPane.add(btnExit);
		
		
		
		JButton btn4 = new JButton("4");
		btn4.addMouseListener(this);
		btn4.setBounds(10, 53, 89, 23);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addMouseListener(this);
		btn5.setBounds(96, 28, 89, 23);
		contentPane.add(btn5);
		
		
		JButton btn6 = new JButton("6");
		btn6.addMouseListener(this);
		btn6.setBounds(180, 53, 89, 23);
		contentPane.add(btn6);
		
		
		JButton btn7 = new JButton("7");
		btn7.addMouseListener(this);
		btn7.setBounds(10, 87, 89, 23);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addMouseListener(this);
		btn8.setBounds(96, 114, 89, 23);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addMouseListener(this);
		btn9.setBounds(180, 87, 89, 23);
		contentPane.add(btn9);
		
		
	}
	public JLabel getLblTest() {
		return lblTest;
	}
	
	@Override
    public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		JButton b = null;
		String buttonText = "";

		if(o instanceof JButton)
			b = (JButton)o;

		if(b != null)
		{
			buttonText = b.getText();
			//lblTest.setText(buttonText);
			lblTest.setText(this.hkp.GetKey());
		}
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
