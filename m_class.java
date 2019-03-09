import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.*;
import java.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class t {
	
	public static int time;
	public static int objs;
	public static int count = 1;
}

public class m_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		InputStream in = null;
		
		 JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new FlowLayout());
	        frame.setVisible(true);
		
		try {
			in = new FileInputStream(args[0]);
			p.load(in);
			t.time = Integer.parseInt(p.getProperty("flashTime"));
			t.objs = Integer.parseInt(p.getProperty("noOfItems"));
			System.out.println(t.time);
			System.out.println(t.objs);
			
			for (int i = 0; i< t.objs; i++) {
				m_class.addBtn(frame);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (t.time < 0 && t.objs > 0) {
				System.out.println("Error: Time must be a positive value");
				System.out.println("Objects value OK");
			}
			if (t.objs < 0 && t.time > 0) {
				System.out.println("Error: Objects must be a positive value");
				System.out.println("Time value OK");
			}
			if (t.objs < 0 && t.time < 0) {
				System.out.println("Error: Time must be a positive value");
				System.out.println("Error: Objects must be a positive value");
			}
			
		}
       
	}

	 static void addBtn (JFrame f) {
		 JButton button = new JButton("Button" + t.count);
		 btn_th btn = new btn_th(button);
		 btn.start();
		 f.getContentPane().add(button);
		 t.count++;
 		
 	}

	
}
class btn_th extends Thread {
	
	JButton btn_ref; 
	
	btn_th(JButton b){
		
		this.btn_ref = b;
	}
	
	public void run() {
		while(true) {
		btn_ref.setBackground(new Color(getRand(0,255),getRand(0,255),getRand(0,255)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
	private static int getRand(int min, int max) {

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}
