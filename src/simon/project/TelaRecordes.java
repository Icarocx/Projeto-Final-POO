package simon.project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaRecordes extends JFrame {

	private JPanel contentPane;

	public TelaRecordes() {
		setTitle("Recordes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRecordes = new JLabel("PONTUA\u00C7\u00D5ES");
		lblRecordes.setFont(new Font("Swis721 Lt BT", Font.BOLD, 18));
		lblRecordes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRecordes, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		FileReader fr=null;
		try {
			fr = new FileReader("Player.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buffRecordes = new BufferedReader(fr);
		String recordes="";
		try {
			while (buffRecordes.ready()) {
				recordes = recordes+buffRecordes.readLine()+"\n";
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.setText(recordes);
		textArea.setEditable(false);
	}

}
