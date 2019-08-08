import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;


public class TextEditor  {
	public static void  main (String [] args ){
		
		MyFrame f= new MyFrame(); 
	}
}
class MyFrame extends JFrame implements ActionListener
{
	
	public JMenuBar meniu ;
	
	public JMenu file;
	public JMenu font;
	public JMenu fontSize;
    public JMenu fontDecor; 
	public JMenu help;
	public JMenu about;
	
	
	public JMenuItem fileNew;
	public JMenuItem fileOpen;
	public JMenuItem fileSave;
	public JMenuItem fileSaveAs;
	public JMenuItem fileExit;
	
	
	public JMenuItem fontArial;
	public JMenuItem fontComicSansMS;
	public JMenuItem fontTimesNewRoman;
	
	public JMenuItem fontDecorBold;
	public JMenuItem fontDecorItalic;
	public JMenuItem fontDecorPlain;
	
	public JMenuItem fontSizeSmall;
	public JMenuItem fontSizeHuge;
	public JMenuItem fontSizeNormal;
	public JMenuItem fontSizeBig;
	
	public JMenuItem helpHelp;
	public JMenuItem helpAbout;
	
	public JTextArea field;
	
	public JLabel status;
	
	public MyFrame(){ 
		super(" My Editor ") ;
		
		meniu = new JMenuBar();
		file = new  JMenu( "File");
		//edit = new  JMenu ("Edit");
		font = new JMenu("Font");
		fontSize = new JMenu ("Font Size ");
		fontDecor = new JMenu("Font Decor ");
		help = new JMenu ("Help");
		
		fileNew = new JMenuItem (" New");
		fileNew.addActionListener(this);
		fileOpen = new JMenuItem ("Open");
		fileOpen.addActionListener(this);
		fileSaveAs =   new JMenuItem (" Save As..");
		fileSaveAs.addActionListener(this);
		fileExit =  new JMenuItem ("Exit");
		
		file.add(fileNew);
		file.add(fileOpen);
		file.add(fileSaveAs);
		file.add(fileExit);
		fileExit.addActionListener(this);
		
		
		
	   
		fontArial = new JMenuItem("Arial");
	    fontArial.addActionListener(this);
		fontTimesNewRoman = new JMenuItem("Times New Roman");
		fontTimesNewRoman.addActionListener(this);
		fontComicSansMS = new JMenuItem ("ComicSansMS");
		fontComicSansMS.addActionListener(this);
		font.add(fontArial);
		font.add(fontComicSansMS);
		font.add(fontTimesNewRoman);
		
		fontDecorBold = new JMenuItem("Bold");
		fontDecorBold.addActionListener(this);
		fontDecorItalic = new JMenuItem (" Italic");
		fontDecorItalic.addActionListener(this);
		
		fontDecor.add(fontDecorBold);
		fontDecor.add(fontDecorItalic);
		
		fontSizeSmall = new JMenuItem ("Small");
	    fontSizeSmall.addActionListener(this);
		fontSizeBig = new JMenuItem ("Big");
		fontSizeBig.addActionListener(this);
		fontSizeNormal = new JMenuItem("Normal");
		fontSizeNormal.addActionListener(this);
		fontSizeHuge = new JMenuItem("Huge");
		fontSizeHuge.addActionListener(this);
		
		fontSize.add(fontSizeSmall);
		fontSize.add(fontSizeBig);
		fontSize.add(fontSizeNormal);
		fontSize.add(fontSizeHuge);
		
		helpHelp = new JMenuItem ("Help");
		helpAbout = new JMenuItem("About");
		
		help.add(helpAbout);
	    help.add(helpHelp);
		helpHelp.addActionListener(this);
		helpAbout.addActionListener(this);
		
		
		meniu.add(file);
		meniu.add(font);
		meniu.add(fontDecor);
		meniu.add(fontSize);
		meniu.add(help);
		 
		setJMenuBar(meniu);
		
		field = new JTextArea();
		JScrollPane scroll = new JScrollPane(field);
		field.setLineWrap(true);
		field.setWrapStyleWord(true);
		add(scroll, BorderLayout.CENTER);
		
		setSize(700,500); 
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
		public void actionPerformed(ActionEvent event){
		
		if (event.getSource() == fileNew)
		{
			field.setText("");
		}
		else if(event.getSource() == fileOpen) {
           JFileChooser open = new JFileChooser();
           open.showOpenDialog(null);
           File file = open.getSelectedFile();  
		  try {
            FileReader reader = new FileReader(file);
            field.read(reader, null);
        } catch (IOException err) {
            
        }
    
        } else if(event.getSource() == fileSave) {
            
        } else if(event.getSource() == fileSaveAs) {
          JFileChooser saveAs = new JFileChooser();
          saveAs.showSaveDialog(null);
          File filename = saveAs.getSelectedFile();
		 try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(field.getText());
            writer.close();
			
        } catch (IOException err) {
            err.printStackTrace();
        }
            }
		 
			else if (event.getSource()== fontDecorBold)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String fontStyle = "";
               
                if( (style & Font.BOLD) == Font.BOLD)
                        fontStyle = "Bold";
               
                if( (style & Font.ITALIC) == Font.ITALIC)
                        fontStyle = "Italic";
               
                if( (style & Font.PLAIN) == Font.PLAIN)
                        fontStyle = "Plain";
		        
			
			
			
			Font font = new Font(fontName, Font.BOLD, size);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontDecorItalic)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String fontStyle = "";
               
                if( (style & Font.BOLD) == Font.BOLD)
                        fontStyle = "Bold";
               
                if( (style & Font.ITALIC) == Font.ITALIC)
                        fontStyle = "Italic";
               
                if( (style & Font.PLAIN) == Font.PLAIN)
                        fontStyle = "Plain";
			
			Font font = new Font(fontName, Font.ITALIC, size);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontArial)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String fontStyle = "";
               
			Font font = new Font( "Arial",stil, size);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontComicSansMS)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String fontStyle = "";
               
			
			Font font = new Font("ComicSansMS",stil, size);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontTimesNewRoman)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String fontStyle = "";
               
			
			Font font = new Font("Times New Roman",stil, size);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontSizeNormal)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String  fontStyle = "";
               
			
			Font font = new Font(getName(),stil, 12);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontSizeBig)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String  fontStyle = "";
               
			
			Font font = new Font(getName(),stil, 20);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontSizeHuge)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String  fontStyle = "";
               
			
			Font font = new Font(getName(),stil, 30);
			
			
			field.setFont(font);
			}
			if (event.getSource()== fontSizeSmall)
			{
				
				Font currentFont = field.getFont(); 

                String fontName = currentFont.getName(); 
				int stil = currentFont.getStyle();
                int size = currentFont.getSize();   
                int style = currentFont.getStyle(); 
                String  fontStyle = "";
               
			
			Font font = new Font(getName(),stil, 8);
			
			
			field.setFont(font);
			}
			 if (event.getSource() == fileExit) {
				 System.exit(0);
				 
			 }
			 if (event.getSource()== helpHelp) {
				 JOptionPane.showMessageDialog(null, " Welcome to Paula's text editor  !\n  Is simple to use so you better don't have problem  ", " HELP",
                 JOptionPane.INFORMATION_MESSAGE);
				 
			 }
			 if (event.getSource()== helpAbout) {
				 JOptionPane.showMessageDialog(null, " Made by: Paula \n With : a lot of effort :)  ", " ABOUT",
                 JOptionPane.INFORMATION_MESSAGE);
				 
			 }
		}
			
}
