package windowbuilder.seblovett;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;

public class HotKeyApp extends JFrame implements MouseListener,MouseMotionListener,ActionListener  {

	private final String AHKProcess = "AutoHotkey.exe";
	private JPanel contentPane;
	private JLabel lblTest;
	private JButton btnExit;
	String HotkeyFile;
	HotKeyParser hkp;
	private Image backgroundImage;
	JComboBox<String> comboBox;
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
					else
						fname =  Integer.toString(args.length);
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
	 * @throws IOException 
	 */
	public HotKeyApp(String fname) throws IOException {
		
		boolean FileFound = true;
		try {
			hkp = new HotKeyParser(fname);//"C:\\Users\\seblovett\\workspace\\windowbuilder\\Test.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			//JOptionPane.showMessageDialog(null, "File not found");
			FileFound = false;
		}
		
		
		setOpacity(1.0f);
		Point p = MouseInfo.getPointerInfo().getLocation();
		
		setUndecorated(true);
		this.HotkeyFile = fname;
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 129, 74);
		/*backgroundImage = ImageIO.read(new File("C:\\Users\\seblovett\\workspace\\windowbuilder\\src\\windowbuilder\\seblovett\\app.png"));*/
		contentPane = new JPanel()
		{
			/*@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(backgroundImage, 0, 0, null);
			}*/
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			/*btnExit = new JButton("X");
			btnExit.setEnabled(false);
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose(); 
				}
			});
			//btnExit.setBounds(102, 0, 49, 23);
			//contentPane.add(btnExit);
			*/
			JButton btn6 = new JButton("6");
			
			
			JButton btn9 = new JButton("9");
			
			
			JButton btn8 = new JButton("8");
			
			
			JButton btn7 = new JButton("7");
			
		
			JButton btn5 = new JButton("5");
			
			
			JButton btn4 = new JButton("4");
			btn4.setFont(new Font("Dialog", Font.PLAIN, 12));

			btn4.setBounds(0, 29, 41, 15);
			contentPane.add(btn4);
			btn5.setBounds(40, 14, 45, 15);
			contentPane.add(btn5);
			
			btn7.setBounds(0, 44, 41, 15);
			contentPane.add(btn7);
			btn8.setBounds(40, 59, 45, 15);
			contentPane.add(btn8);
			btn9.setBounds(84, 44, 45, 15);
			contentPane.add(btn9);
			btn6.setBounds(84, 29, 45, 15);
			contentPane.add(btn6);
			JButton buttonMinus = new JButton("-");
			buttonMinus.setBounds(40, 44, 45, 15);
			contentPane.add(buttonMinus);
			
			JButton buttonPlus = new JButton("+");
			buttonPlus.setBounds(40, 29, 45, 15);
			contentPane.add(buttonPlus);
			lblTest = new JLabel(String.format("File: %s not found", this.HotkeyFile));
			lblTest.setFont(new Font("Dialog", Font.PLAIN, 10));
			if (FileFound)
			{
				btn4.addMouseListener(this);
				btn5.addMouseListener(this);
				btn6.addMouseListener(this);
				btn7.addMouseListener(this);
				btn8.addMouseListener(this);
				btn9.addMouseListener(this);
				buttonMinus.addMouseListener(this);
				buttonPlus.addMouseListener(this);
				lblTest.setText(String.format("%s",this.HotkeyFile.substring(this.HotkeyFile.lastIndexOf("/") + 1).substring(this.HotkeyFile.lastIndexOf("\\") + 1)));
			}
			else
			{
				//lblTest = new JLabel(String.format("File: %s not found", this.HotkeyFile));
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
				buttonMinus.setEnabled(false);
				buttonPlus.setEnabled(false);
			}
			lblTest.setBounds(0, 0, 129, 14);
			contentPane.add(lblTest);
			Path path = Paths.get(this.HotkeyFile);
			System.out.println(path.toString());
			System.out.println(path.getParent());
			File folder = new File(path.getParent().toString());
			File[] listOfFiles = folder.listFiles();
			comboBox = new JComboBox();
			
			for (int i = 0; i < listOfFiles.length; i++) 
			{
			  if (listOfFiles[i].isFile()) 
			  {
				  //System.out.println("File " + listOfFiles[i].getName());
				  if(listOfFiles[i].getName().toLowerCase().contains(".ahk"))
				  {
					  //System.out.println("AHK File Found");
					  comboBox.addItem(listOfFiles[i].getName());
				  }
			  } 
		    }
			System.out.println(path.getFileName());
			comboBox.setSelectedItem(path.getFileName().toString());
			comboBox.setFont(new Font("Dialog", Font.PLAIN, 10));
			comboBox.setBounds(0, 0, 128, 15);
			contentPane.add(comboBox);
			comboBox.setEnabled(false);
			comboBox.setVisible(false);
			comboBox.addActionListener(this);
			
			/*btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});*/
			
		
		Rectangle r;
		r = this.getBounds();
		
		//this.addMouseListener(this);
		
	    addMouseListener(this);
	    addMouseMotionListener(this);
		
		this.setLocation(p.x - (r.width / 2), p.y - (r.height / 2));
		
	}
	public JLabel getLblTest() {
		return lblTest;
	}
	
	@Override
    public void mouseClicked(MouseEvent e) {
		//we have clicked somewhere
		comboBox.setEnabled(true);
		comboBox.setVisible(true);
		lblTest.setVisible(false);
		//choose the correct combobox entry for the file we currently use.
    }
	
	@Override 
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(arg0.getSource().toString());
		//get the selected ahk
		String newSelection =comboBox.getSelectedItem().toString(); 
		System.out.println(newSelection);
		//check if it has actually changed.
		Path path = Paths.get(this.HotkeyFile);
		if (!newSelection.equals(path.getFileName().toString()))
		{
			System.out.println("New file chosen");
		
			//reload new script to ahk program...
			//is ahk running?
			try 
			{
				if(HotKeyApp.isProcessRunning(this.AHKProcess))
				{
					System.out.println("AHK Running");
					HotKeyApp.killProcess(this.AHKProcess);
					
				}
				else
					System.out.println("AHK Not Running");
				
				Desktop dt = Desktop.getDesktop();
			    dt.open(new File(path.getParent().toString(),newSelection));
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";

	public static boolean isProcessRunning(String serviceName) throws Exception {

	 Process p = Runtime.getRuntime().exec(TASKLIST);
	 BufferedReader reader = new BufferedReader(new InputStreamReader(
	   p.getInputStream()));
	 String line;
	 while ((line = reader.readLine()) != null) {

	  System.out.println(line);
	  if (line.contains(serviceName)) {
	   return true;
	  }
	 }

	 return false;

	}

	public static void killProcess(String serviceName) throws Exception {

	  Runtime.getRuntime().exec(KILL + serviceName);

	 }
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
		JButton b = null;
		String buttonText = "";
		String buttonID = "";
		if(o instanceof JButton)
			b = (JButton)o;

		if(b != null)
		{
			buttonText = b.getText();
			switch(buttonText)
			{
				case "4":
					buttonID = this.hkp.FOUR;
					break;
				case "5":
					buttonID = this.hkp.FIVE;
					break;
				case "6":
					buttonID = this.hkp.SIX;
					break;
				case "7":
					buttonID = this.hkp.SEVEN;
					break;
				case "8":
					buttonID = this.hkp.EIGHT;
					break;
				case "9":
					buttonID = this.hkp.NINE;
					break;
				case "-":
					buttonID = this.hkp.DOWN;
					break;
				case "+":
					buttonID = this.hkp.UP;
					break;
			}
			//lblTest.setText(buttonText);
			lblTest.setText(this.hkp.GetKey(buttonID));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//we have exited something - check the mouse location, compare against the window location. 
		
		//Get mouse
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		//System.out.println(String.format("Mouse: x=%d, y=%d",mouse.x, mouse.y));
		Point window_min = this.getLocation(); //this is top left of window
		//System.out.println(String.format("Window min: x=%d, y=%d", window_min.x, window_min.y));
		Point window_max = new Point(window_min.x + this.getWidth(), window_min.y + this.getHeight());
		//System.out.println(String.format("Window max: x=%d, y=%d", window_max.x, window_max.y));
		
		if( (mouse.x >= window_max.x) || 
			(mouse.x <= window_min.x) || 
			(mouse.y >= window_max.y) || 
			(mouse.y <= window_min.y) )
		{
			//System.out.println("Mouse exited window");
			this.dispose();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override 
	public void mouseMoved(MouseEvent e){
		//System.out.println("(" + e.getX() + "," + e.getY() + ")");
//	            + " detected on "
//	            + e.getComponent().getClass().getName());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
