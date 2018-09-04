package com.three.game;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import com.four.game.EButton;
import com.four.game.InvalidSlotExceptionV2;
import com.four.game.NGButton;
import com.four.game.XOButton;


public class UserInterFace extends JFrame{
	
	private JPanel panel;
	private JPanel pan;
	public XOButton buttons[];
	private NGButton newGameBtn;
	private EButton exitBtn;
	private JSplitPane sp;
	private TextArea textArea;
	public byte value;
	GameInterface gameInterface;
	
	public void initializeUI() {
		panel = new JPanel();
	    pan = new JPanel();
		buttons = new XOButton[9];
		newGameBtn = new NGButton("New Game");
		exitBtn = new EButton("Exit");
	    sp = new JSplitPane();
	    textArea = newGameBtn.getTextArea();
		value = 0;
	}
	
	public UserInterFace(GameInterface gameInterface) {
		super("UserInterFace");
		System.out.println("about to create user interface");
		initializeUI();
		
		this.gameInterface = gameInterface;
		
		setSize(450,450);
		setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new XOButton();
			buttons[i].addActionListener(new ButtonAction(buttons[i], i));
			panel.add(buttons[i]);
		}
		sp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		sp.setDividerLocation(250);
		sp.setLeftComponent(panel);
		sp.setRightComponent(pan);
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		pan.add(newGameBtn);
		pan.add(newGameBtn.getTextArea());
		pan.add(exitBtn);
		add(sp);
		setVisible(true);
		textArea.setText("");
		
		newGameBtn.addActionListener(new ButtonAction(newGameBtn));
		exitBtn.addActionListener(new ButtonAction(exitBtn));
		
	}
	
	public void setButtonText( int buttonIndex, String signature) {
		buttons[buttonIndex - 1].setText(signature);
	}
	
	private class ButtonAction implements ActionListener{
		private JButton jbutton;
		
		private int action;
		public ButtonAction(JButton jbutton, int action) {
			this.action = action;
			this.jbutton = jbutton;
			
		}
		public ButtonAction(JButton jbutton) {
			this.jbutton = jbutton;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(jbutton.getActionCommand().equalsIgnoreCase("New Game")) {
				
				
			}else if(jbutton.getActionCommand().equalsIgnoreCase("exit")) {
				System.exit(0);
			}else {
				
				System.out.println("action : " + action);
				gameInterface.processPlayerTurn(action + 1);
				

			}
		
			}
		}
	
	public void println(String message) {
			 textArea.append("\n" + message);
	}
	
}

