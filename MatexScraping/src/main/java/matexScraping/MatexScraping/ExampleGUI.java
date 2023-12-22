package matexScraping.MatexScraping;


import java.awt.AWTException;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.JXDatePicker;


public class ExampleGUI extends JFrame  {
	private  String[] jack = new String[100];
	private String StringtoPassAccenture = "";
	private String StringtoPassCape = "";
	private String StringtoPassWipro = "";
	private String StringtoPassCognizant = "";
	private String StringtoPassTech_mahindra = "";
	private String StringtoPassRBL = "";
	private String StringtoPassNiva = "";
	private String StringtoPassIndusind = "";
	private String StringtoPassgen = "";
	private String StringtoPass = "";
	private String StringtoPassEXP_ID = "";
	private String StringtoPassSpecfic_ID = "";
	
	private String StringtoPassHcl = "";
	private String StringtoPass1 = "";
	private String StringtoPass2 = "";
	private String StringFromdate ="";
	private String Stringtodate ="";
	private String StringFromdateSpec ="";
	private String StringtodateSpec ="";
	private String Stringtodatecampus ="";
	private String StringFromdatecampus ="";
	private String StringtodateDirect ="";
	private String StringFromdateDirect ="";
	private String StringFromdateCape ="";
	private String StringTodateCape ="";
	private String StringAccFromdate ="";
	private String StringAcctodate ="";
	
	private String Tech_mahindra_username ="";
	private String Tech_mahindra_Password ="";
	
	private static final long serialVersionUID = 1L;
	 //JPanel mainPanel;
	JLabel lblFromDate, lblToDate,lblFromDate1,lblToDate1,CtlblFromDate,CtlblToDate,DtlblFromDate,DtlblToDate;
	JLabel lblMain,Tcs_related_scraping,Experiencelable,Experience_id_lable,Experience_Date_lable,HCLlable,
	Specfic_Relation_Panel,Specfic_Relation_id_Panel,HCLCandidatelable,HCLCandidate_id_lable,Genlable,GENCandidatelable,GENCandidate_id_lable,
	Specfic_Relation_Date_Panel,Campus_trainee_Panel,Campus_trainee_id_Panel,Campus_Trainee_Date_Panel,Direct_trainee_Panel,Direct_trainee_id_Panel,
	Direct_Trainee_Date_Panel,CapeCandidatelable,CapeCandidate_id_lable,CapelblFromDate,CapelblToDate,Capegemeni_Date_lable,
	Nivalable,NivaCandidatelable,NivaCandidate_id_lable,Induslable,IndusCandidatelable,IndusCandidate_id_lable,RBLlable,RBLCandidatelable,RBLCandidate_id_lable,
	Tech_mahindralable,Tech_mahindraCandidatelable,Tech_mahindraCandidate_id_lable,Cognizantlable,CognizantCandidatelable,CognizantCandidate_id_lable,AcclblFromDate;
	JLabel AcclblToDate,Wiprolable,WiproCandidatelable,WiproCandidate_id_lable,Accenturelable,AccentureCandidatelable,AccentureCandidate_id_lable,AccentureCandidateCandidate_id_lable;
	JXDatePicker pickerFromDate, pickerToDate,pickerFromDate1, pickerToDate1,AccpickerFromDate,AccpickerToDate,
	CTpickerFromDate,CTpickerToDate,DTpickerFromDate,DTpickerToDate,capepickerFromDate,capepickerToDate;
	SimpleDateFormat dateFormat, dateFormat1;

	   
	JPanel loginPanel,Scrap,
	capePanel,CapeByIDPanel,capefileUploadPanel,CapeByDatePanel,
	HCLPanel,HCLByIDPanel,HCLfileUploadPanel,
	GenPanel,GENByIDPanel,GENfileUploadPanel,
	NivaPanel,NivaByIDPanel,NivafileUploadPanel,
	IndusPanel,IndusByIDPanel,IndusfileUploadPanel,
	RBLPanel,RBLByIDPanel,RBLfileUploadPanel,
	Tech_mahindraPanel,Tech_mahindraByIDPanel,Tech_mahindrafileUploadPanel,
	CognizantPanel,CognizantByIDPanel,CognizantfileUploadPanel,
	WiproPanel,WiproByIDPanel,WiprofileUploadPanel,
	AccenturePanel,AccentureByIDPanel,AccenturefileUploadPanel,AccentureCandidatefileUploadPanel,AccentureCAndidatefileUploadPanel,AccentureCandidateCandidatefileUploadPanel,
	tcsPanel,fileUploadPanel,ByIDPanel,ByexpDatepanel,
	tcspanel1,TcsfileUploadPanel,ByIDSpecPanel,BySpecDatePanel,
	CTfileUploadPanel,CTByIdPanel,CTByDatePanel,
	DtfileUploadPanel,DtByIdPanel,DtByDatePanel;
	
	JButton loginButton,
	tcsButton,tcsButton1,
	Capebutton,CapeButton1,capeback0Button,CapeByID,CapeByDate,capebackButton,CapeSubmitDateDirect,
	capeuploadButton,capeback1Button,
	tcsbgcButton,tcsCTButton,tcsDTButton,
	HCLbutton,HCLButton1,HCLback0Button,HCLByID,HCLuploadButton,HCLsubmitButton,HCLback1Button,HCLbackButton,
	Genbutton,GenButton1,Genback0Button,GENByID,GENbackButton,GENuploadButton,GENsubmitButton,GENback1Button,
	Nivabutton,NivaButton1,Nivaback0Button,NivaByID,NivabackButton,NivauploadButton,NivasubmitButton,Nivaback1Button,
	Indusbutton,IndusButton1,Indusback0Button,IndusByID,IndusbackButton,IndusuploadButton,IndussubmitButton,Indusback1Button,
	RBLbutton,RBLButton1,RBLback0Button,RBLByID,RBLbackButton,RBLuploadButton,RBLsubmitButton,RBLback1Button,
	Mahindrabutton,Tech_mahindraButton1,Tech_mahindraback0Button,Tech_mahindraByID,Tech_mahindrabackButton,Tech_mahindrauploadButton,Tech_mahindrasubmitButton,
	Tech_mahindraback1Button,
	Cognizantbutton,CognizantButton1,Cognizantback0Button,CognizantByID,CognizantbackButton,CognizantuploadButton,CognizantsubmitButton,
	Cognizantback1Button,
	Wiprobutton,WiproButton1,Wiproback0Button,WiproByID,WiprobackButton,WiprouploadButton,WiprosubmitButton,
	Wiproback1Button,
	Accenturebutton,AccentureButton1,Accentureback0Button,AccentureByID,AccenturebackButton,AccentureuploadButton,AccenturesubmitButton,
	AccentureCandidatebackButton,AccentureCandidateuploadButton,AccentureCandidatesubmitButton,AccentureCandidateback1Button,
	Accentureback1Button,AccentureByID1,
	
	uploadButton,uploadButton1,TcsUploadButton,ByDate,ByDateSpec,
	back5Button,back6Button,backButton,back0Button,back1Button,
	back2Button,back3Button,back4Button,camBackbutton,DirectBackbutton,
	
	CTsubmitButton,CTuploadButton,CTbackButton,CTbackButton1,CTByID,CTByDate,
	DTsubmitButton,DTuploadButton,DTbackButton1,DTbackButton,DTByID,DTByDate,CapesubmitButton,
	submitButton,submitButton1,ByID,ByIDSpec,SubmitDateExp,SubmitDateSpec,SubmitDatecampus,SubmitDateDirect;

	
	JTextField usernameField,usertype, passwordField, uploadedfile,uploadedfile1,uploadedfile2,uploadedfile3,
	capeuploadedfile,TCSuploadedfile,CTuploadedfile,DTuploadedfile,HCLuploadedfile,GENuploadedfile,Nivauploadedfile,Indusuploadedfile,
	RBLuploadedfile,Tech_mahindrauploadedfile,usernameFieldTech,passwordFieldTech,Tech_mahindrausername,Tech_mahindrapassword,
	Cognizantuploadedfile,Cognizantusername,Cognizantpassword,Wiprouploadedfile,Accentureuploadedfile,AccentureCandidateuploadedfile;
	
	JLabel usernameLabel, passwordLabel,usernameLabeltech, passwordLabeltech,usernameLabelCognizant,passwordLabelCognizant;
	
	CardLayout cardLayout;
    public  ExampleGUI() {
    	 super("Login Page");
    	 setSize(650,450);
    	    setTitle("SCRAPING APPLICATION");
    	    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	    dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
       	 
     // Create the login panel with username, password, and login button
         loginPanel = new JPanel() {
        	  private static final long serialVersionUID = 1L;
        	  @Override
              protected void paintComponent(Graphics g) {
                  super.paintComponent(g);
                      ImageIcon image = new ImageIcon("/home/admin/Documents/bclogin.jpg");
                  
                  g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
              } 
         };
         loginPanel.setLayout(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(8, 8, 8, 8);
         	
    
    //loginPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
         usernameLabel = new JLabel("Username:");
         gbc.gridx = 0;
         gbc.gridy = 0;
         loginPanel.add(usernameLabel, gbc);
       
         usernameField = new JTextField(20);
           gbc.gridx = 1;
           gbc.gridy = 0;
           loginPanel.add(usernameField,gbc);
          

           usertype = new JTextField(20);
             gbc.gridx = 1;
             gbc.gridy = 0;
             loginPanel.add(usertype,gbc);
         
           
           passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel,gbc);
        
         passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(passwordField,gbc);
         loginButton = new JButton("Login");
        
        loginButton.setBounds(534, 390, 75, 38);
        //loginButton.addActionListener((ActionListener) this); 
        loginButton.addActionListener(new LoginListener());
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(loginButton,gbc);
       //################################
        
      
      //################################
        
        //TCS first panel
        tcspanel1 = new JPanel();
        tcspanel1.setLayout(null);
        tcsButton1 = new JButton("TCS");
        tcsButton1.setBounds(50, 110, 150, 25);
        tcsButton1.addActionListener(new Tcs1Listener());
        tcsButton1.setToolTipText(" Tcs company.");
        
        Capebutton = new JButton("Capegemini");
        Capebutton.setBounds(50, 150, 150, 25);
        Capebutton.addActionListener(new capeListener());
        Capebutton.setToolTipText(" cape company.");
        
        HCLbutton = new JButton("HCL");
        HCLbutton.setBounds(50, 190, 150, 25);
        HCLbutton.addActionListener(new HCL_Listener());
        HCLbutton.setToolTipText(" HCL company.");
    
        Genbutton = new JButton("GenPact");
        Genbutton.setBounds(50, 230, 150, 25);
        Genbutton.addActionListener(new GEN_Listener());
        Genbutton.setToolTipText(" Genpact company.");
    
        Nivabutton = new JButton("Niva Bupa");
        Nivabutton.setBounds(50, 270, 150, 25);
        Nivabutton.addActionListener(new Niva_Listener());
        Nivabutton.setToolTipText(" Niva_bupa company.");
    
        Indusbutton = new JButton("Indusind");
        Indusbutton.setBounds(50, 310, 150, 25);
        Indusbutton.addActionListener(new Indusind_Listener());
        Indusbutton.setToolTipText(" Indusind bank company.");
        
        RBLbutton = new JButton("RBL_Bank");
        RBLbutton.setBounds(250, 270, 150, 25);
        RBLbutton.addActionListener(new RBL_Listener());
        RBLbutton.setToolTipText(" RBL_Bank bank company.");
    
        Mahindrabutton = new JButton("Tech_Mahindra");
        Mahindrabutton.setBounds(250, 110, 150, 25);
        Mahindrabutton.addActionListener(new Mahindra_Listener());
        Mahindrabutton.setToolTipText(" Tech_Mahindra company.");
     
        Cognizantbutton = new JButton("Cognizant");
        Cognizantbutton.setBounds(250, 150, 150, 25);
        Cognizantbutton.addActionListener(new Cognizant_Listener());
        Cognizantbutton.setToolTipText(" Cognizant company.");
    
        Wiprobutton = new JButton("Wipro");
        Wiprobutton.setBounds(250, 190, 150, 25);
        Wiprobutton.addActionListener(new Wipro_Listener());
        Wiprobutton.setToolTipText(" Wipro company.");
        
        Accenturebutton = new JButton("Accenture");
        Accenturebutton.setBounds(250, 230, 150, 25);
        Accenturebutton.addActionListener(new Accenture_Listener());
        Accenturebutton.setToolTipText(" Accenture company.");
    
        tcspanel1.add(tcsButton1);
        tcspanel1.add(Capebutton);
        tcspanel1.add(HCLbutton);
        tcspanel1.add(Genbutton);
        tcspanel1.add(Nivabutton);
        tcspanel1.add(Indusbutton);
        tcspanel1.add(RBLbutton);
        tcspanel1.add(Mahindrabutton);
        tcspanel1.add(Cognizantbutton);
        tcspanel1.add(Wiprobutton);
        tcspanel1.add(Accenturebutton);
        
        tcspanel1.setVisible(false); // Hide pictures panel until login succeeds
     
        // Add back button to tcsPanel
        ImageIcon icon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
         back0Button = new JButton(icon);
         back0Button.setPreferredSize(new Dimension(60,60));
         back0Button.setBounds(10,10, 30, 25);
         
        back0Button.addActionListener(new BackLoginListener());
        back0Button.setToolTipText("This is a tooltip for the button.");
        tcspanel1.add(back0Button);
   
        lblMain = new JLabel("Main Scraping Panel");
        lblMain.setBounds(235, -20, 160, 65);
        tcspanel1.add(lblMain);
    

        // Create the tcs panel with tcs button
        tcsPanel = new JPanel();
        tcsPanel.setPreferredSize(new Dimension(300, 300));
        tcsPanel.setBackground(Color.CYAN);
        tcsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        tcsPanel.setLayout(null);
        tcsButton = new JButton("TCS Experience");
        tcsButton.setToolTipText("Tcs experience scraping");
        tcsButton.setBounds(50, 110, 150, 25);
        tcsButton.addActionListener(new TcsListener());
        tcsPanel.add(tcsButton);
      
        tcsbgcButton = new JButton("TCS Specfic BGC");
        tcsbgcButton.setToolTipText("Tcs specfic relation scraping");
        tcsbgcButton.setBounds(50, 150, 150, 25);
        tcsbgcButton.addActionListener(new TcsSpecficListener());
        tcsPanel.add(tcsbgcButton);
       
        tcsCTButton = new JButton("TCS Campus Trainee");
        tcsCTButton.setToolTipText("Tcs Campus Trainee Scrapping");
        tcsCTButton.setBounds(50, 190, 150, 25);
        tcsCTButton.addActionListener(new TcsCampusTraineeListener());
        tcsPanel.add(tcsCTButton);
    
        tcsDTButton = new JButton("TCS Direct Trainee");
        tcsDTButton.setToolTipText("Tcs Direct Trainee Scrapping");
        tcsDTButton.setBounds(50, 230, 150, 25);
        tcsDTButton.addActionListener(new TcsDirectTraineeListener());
        tcsPanel.add(tcsDTButton);
        Tcs_related_scraping = new JLabel("Tcs_related_scraping Panel");
        Tcs_related_scraping.setBounds(210, -20, 260, 90);
        tcsPanel.add(Tcs_related_scraping);
          // Hide pictures panel until login succeeds
        tcsPanel.setVisible(false); // Hide pictures panel until login succeeds
    
        // Create the Capegemini panel with Capegemini button
        capePanel = new JPanel();
        capePanel.setPreferredSize(new Dimension(300, 300));
        capePanel.setBackground(Color.white);
        capePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        capePanel.setLayout(null);

        CapeButton1 = new JButton("Capegemini Id");
        CapeButton1.setToolTipText("Capegemini candidate scraping");
        CapeButton1.setBounds(50, 110, 150, 25);
        CapeButton1.addActionListener(new capegeminiIDListener());
        capePanel.add(CapeButton1);
        
      
        //back button for capegemini to main panel
        
        ImageIcon capeicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
         capeback0Button = new JButton(capeicon);
         capeback0Button.setPreferredSize(new Dimension(60,60));
         capeback0Button.setBounds(10,10, 30, 25);
         
        capeback0Button.addActionListener(new capeBackListener());
        capeback0Button.setToolTipText("This is a tooltip for the button of capegemini.");
        capePanel.add(capeback0Button);
   
        
        
        // Create the HCL panel with Hcl button
        HCLPanel = new JPanel();
        HCLPanel.setPreferredSize(new Dimension(300, 300));
        HCLPanel.setBackground(Color.red);
        HCLPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        HCLPanel.setLayout(null);

        HCLButton1 = new JButton("HCL Id");
        HCLButton1.setToolTipText("HCL candidate scraping");
        HCLButton1.setBounds(50, 110, 150, 25);
        HCLButton1.addActionListener(new HCLIDListener());
        HCLPanel.add(HCLButton1);
        HCLlable = new JLabel("HCL Scrapping Panel");
        HCLlable.setBounds(210, -20, 260, 90);
        HCLPanel.add(HCLlable);
       
      
        //back button for capegemini to main panel
        
        ImageIcon HCLicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        HCLback0Button = new JButton(HCLicon);
        HCLback0Button.setPreferredSize(new Dimension(60,60));
        HCLback0Button.setBounds(10,10, 30, 25);
         
        HCLback0Button.addActionListener(new HCLBackListener());
        HCLback0Button.setToolTipText("This is a tooltip for the button of hcl.");
        HCLPanel.add(HCLback0Button);
   
    
        // Create the Genpact panel with genpactbutton
        GenPanel = new JPanel();
        GenPanel.setPreferredSize(new Dimension(300, 300));
        GenPanel.setBackground(Color.blue);
        GenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GenPanel.setLayout(null);

        GenButton1 = new JButton("GenPact Id");
        GenButton1.setToolTipText("Genpact candidate scraping");
        GenButton1.setBounds(50, 110, 150, 25);
        GenButton1.addActionListener(new GENIDListener());
        GenPanel.add(GenButton1);
        Genlable = new JLabel("GenPact Scrapping Panel");
        Genlable.setBounds(210, -20, 260, 90);
        GenPanel.add(Genlable);
       
      
        //back button for capegemini to main panel
        
        ImageIcon Genicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Genback0Button = new JButton(Genicon);
        Genback0Button.setPreferredSize(new Dimension(60,60));
        Genback0Button.setBounds(10,10, 30, 25);
         
        Genback0Button.addActionListener(new GENBackListener());
        Genback0Button.setToolTipText("This is a tooltip for the button of Genpact.");
        GenPanel.add(Genback0Button);
   
        
        
        // Create the MAXBUPA panel with MAXbutton
        NivaPanel = new JPanel();
        NivaPanel.setPreferredSize(new Dimension(300, 300));
        NivaPanel.setBackground(Color.green);
        NivaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        NivaPanel.setLayout(null);

        NivaButton1 = new JButton("NivaBupa Id");
        NivaButton1.setToolTipText("NivaBupa candidate scraping");
        NivaButton1.setBounds(50, 110, 150, 25);
        NivaButton1.addActionListener(new NivaIDListener());
        NivaPanel.add(NivaButton1);
        Nivalable = new JLabel("MaxBupa Scrapping Panel");
        Nivalable.setBounds(210, -20, 260, 90);
        NivaPanel.add(Nivalable);
       
      
        //back button for niva bupa bank to main panel
        
        ImageIcon Indusicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Nivaback0Button = new JButton(Indusicon);
        Nivaback0Button.setPreferredSize(new Dimension(60,60));
        Nivaback0Button.setBounds(10,10, 30, 25);
         
        Nivaback0Button.addActionListener(new NivaBackListener());
        Nivaback0Button.setToolTipText("This is a tooltip for the button of NivaBupa.");
        NivaPanel.add(Nivaback0Button);
   
        // Create the NivaBupa panel with Indusbuttonbutton
        IndusPanel = new JPanel();
        IndusPanel.setPreferredSize(new Dimension(300, 300));
        IndusPanel.setBackground(Color.gray);
        IndusPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        IndusPanel.setLayout(null);

        IndusButton1 = new JButton("Indusind Id");
        IndusButton1.setToolTipText("Indusind candidate scraping");
        IndusButton1.setBounds(50, 110, 150, 25);
        IndusButton1.addActionListener(new IndusindIDListener());
        IndusPanel.add(IndusButton1);
        Induslable = new JLabel("Indusind Scrapping Panel");
        Induslable.setBounds(210, -20, 260, 90);
        IndusPanel.add(Induslable);
        //back button for Indusind bank to main panel
        
        ImageIcon Indusindicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Indusback0Button = new JButton(Indusindicon);
        Indusback0Button.setPreferredSize(new Dimension(60,60));
        Indusback0Button.setBounds(10,10, 30, 25);
         
        Indusback0Button.addActionListener(new IndusBackListener());
        Indusback0Button.setToolTipText("This is a tooltip for the button of Indusind bank.");
        IndusPanel.add(Indusback0Button);
   
      
        // Create the RBL panel with RBLbuttonbutton
        RBLPanel = new JPanel();
        RBLPanel.setPreferredSize(new Dimension(300, 300));
        RBLPanel.setBackground(Color.cyan);
        RBLPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        RBLPanel.setLayout(null);

        RBLButton1 = new JButton("RBL Id");
        RBLButton1.setToolTipText("RBL candidate scraping");
        RBLButton1.setBounds(50, 110, 150, 25);
        RBLButton1.addActionListener(new RBLIDListener());
        RBLPanel.add(RBLButton1);
        RBLlable = new JLabel("RBL Scrapping Panel");
        RBLlable.setBounds(210, -20, 260, 90);
        RBLPanel.add(RBLlable);
       
        //back button for Indusind bank to main panel
        ImageIcon RBL_Bankicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        RBLback0Button = new JButton(RBL_Bankicon);
        RBLback0Button.setPreferredSize(new Dimension(60,60));
        RBLback0Button.setBounds(10,10, 30, 25);
         
        RBLback0Button.addActionListener(new RBLBackListener());
        RBLback0Button.setToolTipText("This is a tooltip for the button of RBL bank.");
        RBLPanel.add(RBLback0Button);
 
   //*******************************************
        
        // Create the TECH_mahindra panel with TECH_MAHINDRAbutton
        Tech_mahindraPanel = new JPanel();
        Tech_mahindraPanel.setPreferredSize(new Dimension(300, 300));
        Tech_mahindraPanel.setBackground(Color.yellow);
        Tech_mahindraPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Tech_mahindraPanel.setLayout(null);

        Tech_mahindraButton1 = new JButton("Mahindra Id");
        Tech_mahindraButton1.setToolTipText("Tech_mahindra candidate scraping");
        Tech_mahindraButton1.setBounds(50, 110, 150, 25);
        Tech_mahindraButton1.addActionListener(new Tech_mahindraIDListener());
        Tech_mahindraPanel.add(Tech_mahindraButton1);
        Tech_mahindralable = new JLabel("Tech_mahindra Scrapping Panel");
        Tech_mahindralable.setBounds(210, -20, 260, 90);
        Tech_mahindraPanel.add(Tech_mahindralable);
       
        //back button for Indusind bank to main panel
        ImageIcon Mahindra_icon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Tech_mahindraback0Button = new JButton(Mahindra_icon);
        Tech_mahindraback0Button.setPreferredSize(new Dimension(60,60));
        Tech_mahindraback0Button.setBounds(10,10, 30, 25);
         
        Tech_mahindraback0Button.addActionListener(new Tech_mahindraBackListener());
        Tech_mahindraback0Button.setToolTipText("This is a tooltip for the button of Tech Mahindra.");
        Tech_mahindraPanel.add(Tech_mahindraback0Button);
   
 //*******************************************
        
        // Create the Cognizant panel with Cognizantbutton
        CognizantPanel = new JPanel();
        CognizantPanel.setPreferredSize(new Dimension(300, 300));
        CognizantPanel.setBackground(Color.red);
        CognizantPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        CognizantPanel.setLayout(null);

        CognizantButton1 = new JButton("Cognizant Id");
        CognizantButton1.setToolTipText("cognizant candidate scraping");
        CognizantButton1.setBounds(50, 110, 150, 25);
        CognizantButton1.addActionListener(new CognizantIDListener());
        CognizantPanel.add(CognizantButton1);
        Cognizantlable = new JLabel("Cognizant Scrapping Panel");
        Cognizantlable.setBounds(210, -20, 260, 90);
        CognizantPanel.add(Cognizantlable);
       
        //back button for Indusind bank to main panel
        ImageIcon cognizanticon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Cognizantback0Button = new JButton(cognizanticon);
        Cognizantback0Button.setPreferredSize(new Dimension(60,60));
        Cognizantback0Button.setBounds(10,10, 30, 25);
         
        Cognizantback0Button.addActionListener(new CognizantBackListener());
        Cognizantback0Button.setToolTipText("This is a tooltip for the button of Cognizant company.");
        CognizantPanel.add(Cognizantback0Button);
   
  
 //*******************************************
        
        // Create the Wipro panel with Wiprobutton
        WiproPanel = new JPanel();
        WiproPanel.setPreferredSize(new Dimension(300, 300));
        WiproPanel.setBackground(Color.magenta);
        WiproPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        WiproPanel.setLayout(null);

        WiproButton1 = new JButton("Wipro Id");
        WiproButton1.setToolTipText("Wipro candidate scraping");
        WiproButton1.setBounds(50, 110, 150, 25);
        WiproButton1.addActionListener(new WiproIDListener());
        WiproPanel.add(WiproButton1);
        Wiprolable = new JLabel("Wipro Scrapping Panel");
        Wiprolable.setBounds(210, -20, 260, 90);
        WiproPanel.add(Wiprolable);
       
        //back button for wipro to main panel
        ImageIcon Wiproicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Wiproback0Button = new JButton(Wiproicon);
        Wiproback0Button.setPreferredSize(new Dimension(60,60));
        Wiproback0Button.setBounds(10,10, 30, 25);
         
        Wiproback0Button.addActionListener(new WiproBackListener());
        Wiproback0Button.setToolTipText("This is a tooltip for the button of Wipro company.");
        WiproPanel.add(Wiproback0Button);
 
//############################################# 
 
        //*******************************************
        
        // Create the Accenture panel with Accenturebutton
        AccenturePanel = new JPanel();
        AccenturePanel.setPreferredSize(new Dimension(300, 300));
        AccenturePanel.setBackground(Color.green);
        AccenturePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        AccenturePanel.setLayout(null);

        AccentureButton1 = new JButton("Accenture HRC");
        AccentureButton1.setToolTipText("Accenture candidate scraping");
        AccentureButton1.setBounds(50, 110, 150, 25);
       
        AccentureButton1.addActionListener(new AccentureIDHRCListener());
        AccenturePanel.add(AccentureButton1);
        Accenturelable = new JLabel("Accenture Scrapping Panel for HRC");
        Accenturelable.setBounds(210, -20, 260, 90);
        AccenturePanel.add(Accenturelable);
      
        //back button for wipro to main panel
        ImageIcon Accentureicon = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
        Accentureback0Button = new JButton(Accentureicon);
        Accentureback0Button.setPreferredSize(new Dimension(60,60));
        Accentureback0Button.setBounds(10,10, 30, 25);
         
        Accentureback0Button.addActionListener(new AccentureBackListener());
        Accentureback0Button.setToolTipText("This is a tooltip for the button of Accenture company.");
        AccenturePanel.add(Accentureback0Button);
 
//############################################# 
        
        
        // BYID panel for scrapping by ID
        ByIDPanel = new JPanel();
       	ByIDPanel.setPreferredSize(new Dimension(300, 300));
       	ByIDPanel.setBackground(Color.pink);
       	ByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       	ByIDPanel.setLayout(null);
       	ByID = new JButton("ExpBy_id");
       	ByID.setToolTipText("Tcs scraping By_Id");
       	ByDate =new JButton("ExpBy_Date");
       	ByDate.setToolTipText("Tcs scraping By_Date");
      	ByID.setBounds(50, 110, 150, 25);
       	ByID.addActionListener(new ExpidListener());
       	ByIDPanel.add(ByID);
       	ByDate.setBounds(50, 160, 150, 25);
       	ByDate.addActionListener(new ExpdateListener());
       	ByIDPanel.add(ByDate);
       	Experiencelable = new JLabel("Experience By_ID and Date Panel ");
        Experiencelable.setBounds(210, -20, 260, 90);
    	ByIDPanel.add(Experiencelable);
      
    	 
    	//CapeByIDPanel for scrapping
    	CapeByIDPanel = new JPanel();
    	CapeByIDPanel.setPreferredSize(new Dimension(300, 300));
    	CapeByIDPanel.setBackground(Color.white);
    	CapeByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	CapeByIDPanel.setLayout(null);
    	CapeByID = new JButton("CapeCandidate_id");
    	CapeByID.setToolTipText("capegemini scraping By_Id");
    	//CapeByDate =new JButton("CapeCandidate_Date");
    	//CapeByDate.setToolTipText("capegemini scraping By_Date");
         	CapeByID.setBounds(50, 110, 180, 25);
         	CapeByID.addActionListener(new CapeCandidateidListener());
         	CapeByIDPanel.add(CapeByID);
         	//CapeByDate.setBounds(50, 160, 180, 25);
         	//CapeByDate.addActionListener(new CapeCandidateDateListener());
         	//CapeByIDPanel.add(CapeByDate);
         	//CapeCandidatelable = new JLabel("Capegemini Candidate By_ID and Date Panel ");
         	//CapeCandidatelable.setBounds(210, -20, 260, 90);
         	//CapeByIDPanel.add(CapeCandidatelable);
        
//////////////////////////////////////////////////////////////////////////////////////////////////////
          
          // Add back button to capegemini panel
          ImageIcon iconcape0 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
          // //backButton.setPreferredSize(new Dimension(100,0));
          capebackButton = new JButton(iconcape0);
          capebackButton.setPreferredSize(new Dimension(60,60));
          capebackButton.setBounds(10,10, 30, 25);
          capebackButton.setToolTipText("back for capegemini panel");

          capebackButton.addActionListener(new capeBack1Listener());
          CapeByIDPanel.add(capebackButton);
////////////////////////////////////////////####################################### 
 
      	//HCLByIDPanel for scrapping
          HCLByIDPanel = new JPanel();
          HCLByIDPanel.setPreferredSize(new Dimension(300, 300));
          HCLByIDPanel.setBackground(Color.red);
          HCLByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          HCLByIDPanel.setLayout(null);
          HCLByID = new JButton("HCLCandidate_id");
          HCLByID.setToolTipText("HCL scraping By_Id");
          HCLByID.setBounds(50, 110, 180, 25);
      		HCLByID.addActionListener(new HCLCandidateidListener());
           	HCLByIDPanel.add(HCLByID);
           	HCLCandidatelable = new JLabel("HCL Candidate By_ID  Panel ");
           	HCLCandidatelable.setBounds(210, -20, 260, 90);
           	HCLByIDPanel.add(HCLCandidatelable);
          
  //////////////////////////////////////////////////////////////////////////////////////////////////////
            
            // Add back button to capegemini panel
            ImageIcon iconHCL0 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
            // //backButton.setPreferredSize(new Dimension(100,0));
            HCLbackButton = new JButton(iconHCL0);
            HCLbackButton.setPreferredSize(new Dimension(60,60));
            HCLbackButton.setBounds(10,10, 30, 25);
            HCLbackButton.setToolTipText("back for HCL panel");

            HCLbackButton.addActionListener(new HCLBack1Listener());
            HCLByIDPanel.add(HCLbackButton);
  ////////////////////////////////////////////####################################### 
   
////////////////////////////////////////////####################################### 
            
            //GENByIDPanel for scrapping
            GENByIDPanel = new JPanel();
            GENByIDPanel.setPreferredSize(new Dimension(300, 300));
            GENByIDPanel.setBackground(Color.blue);
            GENByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            GENByIDPanel.setLayout(null);
            GENByID = new JButton("GENCandidate_id");
            GENByID.setToolTipText("GENPACT scraping By_Id");
            GENByID.setBounds(50, 110, 180, 25);
            GENByID.addActionListener(new GENCandidateidListener());
            GENByIDPanel.add(GENByID);
            GENCandidatelable = new JLabel("GENPACT Candidate By_ID  Panel ");
            GENCandidatelable.setBounds(210, -20, 260, 90);
            GENByIDPanel.add(GENCandidatelable);

            	//////////////////////////////////////////////////////////////////////////////////////////////////////

            // Add back button to capegemini panel
            ImageIcon iconGEN0 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
            // //backButton.setPreferredSize(new Dimension(100,0));
            GENbackButton = new JButton(iconGEN0);
            GENbackButton.setPreferredSize(new Dimension(60,60));
            GENbackButton.setBounds(10,10, 30, 25);
            GENbackButton.setToolTipText("back for GENPACT panel");

            GENbackButton.addActionListener(new GENBack1Listener());
            GENByIDPanel.add(GENbackButton);
////////////////////////////////////////////####################################### 

       
            //NivabupaByIDPanel for scrapping
            NivaByIDPanel = new JPanel();
            NivaByIDPanel.setPreferredSize(new Dimension(300, 300));
            NivaByIDPanel.setBackground(Color.green);
            NivaByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            NivaByIDPanel.setLayout(null);
            NivaByID = new JButton("NivaCandidate_id");
            NivaByID.setToolTipText("NivaBupa scraping By_Id");
            NivaByID.setBounds(50, 110, 180, 25);
            NivaByID.addActionListener(new NivaCandidateidListener());
            NivaByIDPanel.add(NivaByID);
            NivaCandidatelable = new JLabel("NivaBupa Candidate By_ID  Panel ");
            NivaCandidatelable.setBounds(210, -20, 260, 90);
            NivaByIDPanel.add(NivaCandidatelable);

            	//////////////////////////////////////////////////////////////////////////////////////////////////////

            // Add back button to capegemini panel
            ImageIcon iconNiva0 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
            // //backButton.setPreferredSize(new Dimension(100,0));
            NivabackButton = new JButton(iconNiva0);
            NivabackButton.setPreferredSize(new Dimension(60,60));
            NivabackButton.setBounds(10,10, 30, 25);
            NivabackButton.setToolTipText("back for Niva bupa panel");

            NivabackButton.addActionListener(new NivaBack1Listener());
            NivaByIDPanel.add(NivabackButton);
////////////////////////////////////////////####################################### 

              
////////////////////////////////////////////####################################### 
//IndusindByIDPanel for scrapping
            IndusByIDPanel = new JPanel();
            IndusByIDPanel.setPreferredSize(new Dimension(300, 300));
            IndusByIDPanel.setBackground(Color.gray);
            IndusByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            IndusByIDPanel.setLayout(null);
            IndusByID = new JButton("IndusindCandidate_id");
            IndusByID.setToolTipText("Indusind scraping By_Id");
            IndusByID.setBounds(50, 110, 180, 25);
            IndusByID.addActionListener(new IndusCandidateidListener());
            IndusByIDPanel.add(IndusByID);
            IndusCandidatelable = new JLabel("Indusind Candidate By_ID  Panel ");
            IndusCandidatelable.setBounds(210, -20, 260, 90);
            IndusByIDPanel.add(IndusCandidatelable);

//////////////////////////////////////////////////////////////////////////////////////////////////////

            // Add back button to Indusind panel
            ImageIcon iconIndus = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
            // //backButton.setPreferredSize(new Dimension(100,0));
            IndusbackButton = new JButton(iconIndus);
            IndusbackButton.setPreferredSize(new Dimension(60,60));
            IndusbackButton.setBounds(10,10, 30, 25);
            IndusbackButton.setToolTipText("back for indusind panel");
            	
            IndusbackButton.addActionListener(new IndusBack1Listener());
            IndusByIDPanel.add(IndusbackButton);
////////////////////////////////////////////####################################### 
   
          
////////////////////////////////////////////####################################### 
//RBLByIDPanel for scrapping
            RBLByIDPanel = new JPanel();
            RBLByIDPanel.setPreferredSize(new Dimension(300, 300));
            RBLByIDPanel.setBackground(Color.cyan);
            RBLByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            RBLByIDPanel.setLayout(null);
            RBLByID = new JButton("RBLCandidate_id");
            RBLByID.setToolTipText("RBL scraping By_Id");
            RBLByID.setBounds(50, 110, 180, 25);
            RBLByID.addActionListener(new RBLCandidateidListener());
            RBLByIDPanel.add(RBLByID);
            RBLCandidatelable = new JLabel("RBL Candidate By_ID  Panel ");
            RBLCandidatelable.setBounds(210, -20, 260, 90);
            RBLByIDPanel.add(RBLCandidatelable);

//////////////////////////////////////////////////////////////////////////////////////////////////////

            // Add back button to RBL panel
            ImageIcon iconRBL = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
            // //backButton.setPreferredSize(new Dimension(100,0));
            RBLbackButton = new JButton(iconRBL);
            RBLbackButton.setPreferredSize(new Dimension(60,60));
            RBLbackButton.setBounds(10,10, 30, 25);
            RBLbackButton.setToolTipText("back for RBL panel");

            RBLbackButton.addActionListener(new RBLBack1Listener());
            RBLByIDPanel.add(RBLbackButton);
////////////////////////////////////////////####################################### 
           
////////////////////////////////////////////####################################### 
//TechmahindraByIDPanel for scrapping
            Tech_mahindraByIDPanel = new JPanel();
            Tech_mahindraByIDPanel.setPreferredSize(new Dimension(300, 300));
            Tech_mahindraByIDPanel.setBackground(Color.yellow);
            Tech_mahindraByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            Tech_mahindraByIDPanel.setLayout(null);
            Tech_mahindraByID = new JButton("MahindraCandidate_id");
            Tech_mahindraByID.setToolTipText("Mahindra_scraping By_Id");
            Tech_mahindraByID.setBounds(50, 110, 180, 25);
            Tech_mahindraByID.addActionListener(new Tech_mahindraCandidateidListener());
            Tech_mahindraByIDPanel.add(Tech_mahindraByID);
            Tech_mahindraCandidatelable = new JLabel("Tech_mahindra Candidate By_ID  Panel ");
            Tech_mahindraCandidatelable.setBounds(210, -20, 260, 90);
            Tech_mahindraByIDPanel.add(Tech_mahindraCandidatelable);

//////////////////////////////////////////////////////////////////////////////////////////////////////

// Add back button to RBL panel
ImageIcon icontechmahindra = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
// //backButton.setPreferredSize(new Dimension(100,0));
Tech_mahindrabackButton = new JButton(icontechmahindra);
Tech_mahindrabackButton.setPreferredSize(new Dimension(60,60));
Tech_mahindrabackButton.setBounds(10,10, 30, 25);
Tech_mahindrabackButton.setToolTipText("back for Tech_mahindra panel");

Tech_mahindrabackButton.addActionListener(new Tech_mahindraBack1Listener());
Tech_mahindraByIDPanel.add(Tech_mahindrabackButton);
////////////////////////////////////////////####################################### 

////////////////////////////////////////////####################################### 
//CognizantByIDPanel for scrapping
CognizantByIDPanel = new JPanel();
CognizantByIDPanel.setPreferredSize(new Dimension(300, 300));
CognizantByIDPanel.setBackground(Color.red);
CognizantByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
CognizantByIDPanel.setLayout(null);
CognizantByID = new JButton("CognizantCandidate_id");
CognizantByID.setToolTipText("Cognizant_scraping By_Id");
CognizantByID.setBounds(50, 110, 180, 25);
CognizantByID.addActionListener(new CognizantCandidateidListener());
CognizantByIDPanel.add(CognizantByID);
CognizantCandidatelable = new JLabel("cognizant Candidate By_ID  Panel ");
CognizantCandidatelable.setBounds(210, -20, 260, 90);
CognizantByIDPanel.add(CognizantCandidatelable);

//////////////////////////////////////////////////////////////////////////////////////////////////////

//Add back button to cognizant panel
ImageIcon iconcognizant= new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
CognizantbackButton = new JButton(iconcognizant);
CognizantbackButton.setPreferredSize(new Dimension(60,60));
CognizantbackButton.setBounds(10,10, 30, 25);
CognizantbackButton.setToolTipText("back for cognizant panel");

CognizantbackButton.addActionListener(new CognizantBack1Listener());
CognizantByIDPanel.add(CognizantbackButton);
////////////////////////////////////////////####################################### 
         
////////////////////////////////////////////####################################### 
//CognizantByIDPanel for scrapping
WiproByIDPanel = new JPanel();
WiproByIDPanel.setPreferredSize(new Dimension(300, 300));
WiproByIDPanel.setBackground(Color.magenta);
WiproByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
WiproByIDPanel.setLayout(null);
WiproByID = new JButton("WiproCandidate_id");
WiproByID.setToolTipText("Wipro_scraping By_Id");
WiproByID.setBounds(50, 110, 180, 25);
WiproByID.addActionListener(new WiproCandidateidListener());
WiproByIDPanel.add(WiproByID);
WiproCandidatelable = new JLabel("Wipro Candidate By_ID  Panel ");
WiproCandidatelable.setBounds(210, -20, 260, 90);
WiproByIDPanel.add(WiproCandidatelable);

//////////////////////////////////////////////////////////////////////////////////////////////////////

//Add back button to Wipro panel
ImageIcon iconWipro= new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
WiprobackButton = new JButton(iconWipro);
WiprobackButton.setPreferredSize(new Dimension(60,60));
WiprobackButton.setBounds(10,10, 30, 25);
WiprobackButton.setToolTipText("back for cognizant panel");

WiprobackButton.addActionListener(new WiproBack1Listener());
WiproByIDPanel.add(WiprobackButton);
////////////////////////////////////////////####################################### 


////////////////////////////////////////////####################################### 
//Accenture for scrapping
AccentureByIDPanel = new JPanel();
AccentureByIDPanel.setPreferredSize(new Dimension(300, 300));
AccentureByIDPanel.setBackground(Color.green);
AccentureByIDPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
AccentureByIDPanel.setLayout(null);
AccentureByID = new JButton("Accenture HRC");
AccentureByID.setToolTipText("Accenture_scrapping By_HRC");
AccentureByID.setBounds(50, 110, 180, 25);
AccentureByID.addActionListener(new AccentureHRCidListener());
AccentureByIDPanel.add(AccentureByID);
AccentureByID1 = new JButton("Accenture Candidate");
AccentureByID1.setToolTipText("Accenture_scrapping By_Candidate");
AccentureByID1.setBounds(50, 150, 180, 25);
AccentureByID1.addActionListener(new AccentureCandidateidListener());
AccentureByIDPanel.add(AccentureByID1);
AccentureCandidatelable = new JLabel("Accenture HRC  By_ID  Panel ");
AccentureCandidatelable.setBounds(210, -20, 260, 90);
AccentureByIDPanel.add(AccentureCandidatelable);

//////////////////////////////////////////////////////////////////////////////////////////////////////

//Add back button to Wipro panel
ImageIcon iconAccenture= new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
AccenturebackButton = new JButton(iconAccenture);
AccenturebackButton.setPreferredSize(new Dimension(60,60));
AccenturebackButton.setBounds(10,10, 30, 25);
AccenturebackButton.setToolTipText("back for Accenture panel");

AccenturebackButton.addActionListener(new AccentureBack1Listener());
AccentureByIDPanel.add(AccenturebackButton);
////////////////////////////////////////////####################################### 


// CTBYID panel for scrapping by ID
       	CTByIdPanel = new JPanel();
       	CTByIdPanel.setPreferredSize(new Dimension(300, 300));
       	CTByIdPanel.setBackground(Color.yellow);
       	CTByIdPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
       	CTByIdPanel.setLayout(null);
       	CTByID = new JButton("Cam_Tr_id");
       	CTByID.setToolTipText("Campus trainee scraping By_Id");
       	CTByDate =new JButton("Cam_Tr_Date");
       	CTByDate.setToolTipText("Campus trainee scraping By_Date");
       	CTByID.setBounds(50, 110, 150, 25);
      	CTByID.addActionListener(new Cam_Tr_idTcsListener());
       	CTByIdPanel.add(CTByID);
       	CTByDate.setBounds(50, 160, 150, 25);
       	CTByDate.addActionListener(new Cam_Tr_DateTcsListener());
    	CTByIdPanel.add(CTByDate);
          Campus_trainee_Panel = new JLabel("Campus Trainee By_ID and Date Panel ");
          Campus_trainee_Panel .setBounds(210, -20, 300, 90);
     	CTByIdPanel.add(Campus_trainee_Panel);
        
        // DTBYID panel for scrapping by ID
       	DtByIdPanel = new JPanel();
       	DtByIdPanel.setPreferredSize(new Dimension(300, 300));
       	DtByIdPanel.setBackground(Color.magenta);
       	DtByIdPanel.setBorder(BorderFactory.createLineBorder(Color.black));
       	DtByIdPanel.setLayout(null);
       	DTByID = new JButton("Direct_Tr_id");
       	DTByID.setToolTipText("Direct trainee scraping By_Id");
       	DTByDate =new JButton("Direct_Tr_Date");
       	DTByDate.setToolTipText("Direct trainee scraping By_Date");
       	DTByID.setBounds(50, 110, 150, 25);
       	DTByID.addActionListener(new Direct_Tr_idTcsListener());
      	DtByIdPanel.add(DTByID);
      	DTByDate.setBounds(50, 160, 150, 25);
      	DTByDate.addActionListener(new Direct_Tr_DateTcsListener());
       	DtByIdPanel.add(DTByDate);
        Direct_trainee_Panel = new JLabel("Direct Trainee By_ID and Date Panel ");
        Direct_trainee_Panel .setBounds(210, -20, 300, 90);
    	DtByIdPanel.add(Direct_trainee_Panel);
      
       	
       	
       	
       	// ByexpDatepanel panel for scrapping by Date
       	ByexpDatepanel  = new JPanel();
       	ByexpDatepanel.setPreferredSize(new Dimension(300, 300));
       	ByexpDatepanel.setLayout(null);	 
       	ByexpDatepanel.setBackground(Color.pink);
       	lblFromDate = new JLabel("From Date:");
       	//                     x   y
       	lblFromDate.setBounds(170, 80, 120, 25);
        //Date Picker  	
       	pickerFromDate = new JXDatePicker();
       	//pickerFromDate.setDate(new Date());
       	pickerFromDate.setBounds(260, 80, 150, 25);
       	pickerFromDate.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    System.out.println("From Date: " + dateFormat.format(evt.getNewValue()));
                    StringFromdate =   String.valueOf(dateFormat.format(evt.getNewValue()));
                    StringFromdate = StringFromdate.replace("/", "-");
                }
                }
        });
       
       	System.out.println((StringFromdate));
       	pickerFromDate.setFormats(dateFormat);
        ByexpDatepanel.add(lblFromDate);
        ByexpDatepanel.add(pickerFromDate);

        lblToDate = new JLabel("To Date:");
        lblToDate.setBounds(185, 110, 80, 25);
        
        pickerToDate = new JXDatePicker();
        pickerToDate.setBounds(260, 110, 150, 25);
        pickerToDate.addPropertyChangeListener(new PropertyChangeListener() {
        	
        	@Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    System.out.println("To Date: " + dateFormat.format(evt.getNewValue()));
                    Stringtodate = String.valueOf(dateFormat.format(evt.getNewValue()));
                    Stringtodate = Stringtodate.replace("/", "-");
                }
              
        	}
        });
        
        
        //pickerToDate.setDate(new Date());
        pickerToDate.setFormats(dateFormat);
        ByexpDatepanel.add(lblToDate);
        ByexpDatepanel.add(pickerToDate);
       	SubmitDateExp =new JButton(" ExpDate Submit "); 
       	SubmitDateExp.setBounds(250, 150, 160, 25);
       	SubmitDateExp.addActionListener(new ExpDateSubmitListener());
       	SubmitDateExp.setToolTipText("Tcs experience date Submit");
        
        Experience_Date_lable = new JLabel("Experience By_Date   Scraping Panel ");
        Experience_Date_lable.setBounds(210, -20, 350, 90);
    	ByexpDatepanel.add(Experience_Date_lable);

    	ByexpDatepanel.add(SubmitDateExp);

         
       	// ByIdSpec panel for scraping by id 
            ByIDSpecPanel = new JPanel();
           	ByIDSpecPanel.setPreferredSize(new Dimension(300, 300));
           	ByIDSpecPanel.setBackground(Color.gray);
           	ByIDSpecPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
           	ByIDSpecPanel.setLayout(null);
        	ByIDSpec = new JButton("TCS By_ID");
        	ByIDSpec.setToolTipText("Tcs scraping specfic relation By_Id");
            ByIDSpec.setBounds(50, 110, 150, 25);
           	ByIDSpec.addActionListener(new Tcs4Listener());
           	ByIDSpecPanel.add(ByIDSpec);
        	ByDateSpec = new JButton("TCS By_Date");
        	ByDateSpec.setToolTipText("Tcs scraping specfic relation By_Date");
            ByDateSpec.setBounds(50, 160, 150, 25);
           	ByDateSpec.addActionListener(new Tcs6Listener());
        	ByIDSpecPanel.add(ByDateSpec);
             Specfic_Relation_Panel = new JLabel("Specfic_Relation By_ID and Date Panel ");
             Specfic_Relation_Panel.setBounds(210, -20, 350, 90);
        	ByIDSpecPanel.add(Specfic_Relation_Panel);
            
            // BySpecDatepanel panel for scrapping by Date
           	BySpecDatePanel  = new JPanel();
           	BySpecDatePanel.setPreferredSize(new Dimension(300, 300));
           	BySpecDatePanel.setLayout(null);	 
           	BySpecDatePanel.setBackground(Color.gray);
         	lblFromDate1 = new JLabel("From Date:");
           	//                     x   y
           	lblFromDate1.setBounds(170, 80, 120, 25);
               
           	pickerFromDate1 = new JXDatePicker();
           //	pickerFromDate1.setDate(new Date());
           	pickerFromDate1.setBounds(260, 80, 150, 25);
        	pickerFromDate1.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("date".equals(evt.getPropertyName())) {
                        System.out.println("From Date: " + dateFormat.format(evt.getNewValue()));
                        StringFromdateSpec = String.valueOf(dateFormat.format(evt.getNewValue()));
                        StringFromdateSpec = StringFromdateSpec.replace("/", "-");
                  
                    
                    }
                }
            });
            pickerFromDate1.setFormats(dateFormat);
            BySpecDatePanel.add(lblFromDate1);
            BySpecDatePanel.add(pickerFromDate1);

            lblToDate1 = new JLabel("To Date:");
            lblToDate1.setBounds(185, 110, 80, 25);
            
            pickerToDate1 = new JXDatePicker();
            pickerToDate1.setBounds(260, 110, 150, 25);
        	pickerToDate1.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public  void propertyChange(PropertyChangeEvent evt) {
                    if ("date".equals(evt.getPropertyName())) {
                    	 System.out.println("To Date: " + dateFormat.format(evt.getNewValue()));
                    	 StringtodateSpec = String.valueOf(dateFormat.format(evt.getNewValue()));
                         StringtodateSpec = StringtodateSpec.replace("/", "-");
                     
                    }
                }
            });
          	
        	//pickerToDate1.setDate(new Date());
            pickerToDate1.setFormats(dateFormat);
            BySpecDatePanel.add(lblToDate1);
              BySpecDatePanel.add(pickerToDate1);
            SubmitDateSpec =new JButton(" SpecDate Submit "); 
            SubmitDateSpec.setBounds(250, 150, 160, 25);
           	SubmitDateSpec.addActionListener(new SpecDateSubmitListener());
        	BySpecDatePanel.add(SubmitDateSpec);

           	Specfic_Relation_Date_Panel = new JLabel("Specfic_Relation  only By_Date  Scraping Panel ");
           	Specfic_Relation_Date_Panel.setBounds(210, -20, 350, 90);
           BySpecDatePanel.add(Specfic_Relation_Date_Panel);

           	
           	
           	//////////////////////////////////////////////////////////////////////////////////////////////////////
            
//////////////////////////////////////////////////////////////////////////////////////////////////////
       //Campus trainee scraping by date
           	
            // CTByDatePanel panel for scrapping by Date
           	CTByDatePanel  = new JPanel();
           	CTByDatePanel.setPreferredSize(new Dimension(300, 300));
           	CTByDatePanel.setLayout(null);	 
           	CTByDatePanel.setBackground(Color.orange);
           	CtlblFromDate = new JLabel("From Date:");
           	//                     x   y
           	CtlblFromDate.setBounds(170, 80, 120, 25);
               
           	CTpickerFromDate = new JXDatePicker();
        	//CTpickerFromDate.setDate(new Date());
           	CTpickerFromDate.setBounds(260, 80, 150, 25);
           	CTpickerFromDate.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("date".equals(evt.getPropertyName())) {
                        System.out.println("From Date: " + dateFormat.format(evt.getNewValue()));
                        StringFromdatecampus = String.valueOf(dateFormat.format(evt.getNewValue()));
                        StringFromdatecampus = StringFromdatecampus.replace("/", "-");
                  
                    
                    }
                }
            });
           	CTpickerFromDate.setFormats(dateFormat);
            CTByDatePanel.add(CtlblFromDate);
            CTByDatePanel.add(CTpickerFromDate);

            CtlblToDate = new JLabel("To Date:");
            CtlblToDate.setBounds(185, 110, 80, 25);
            
            CTpickerToDate = new JXDatePicker();
            CTpickerToDate.setBounds(260, 110, 150, 25);
            CTpickerToDate.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public  void propertyChange(PropertyChangeEvent evt) {
                    if ("date".equals(evt.getPropertyName())) {
                    	 System.out.println("To Date: " + dateFormat.format(evt.getNewValue()));
                    	 Stringtodatecampus = String.valueOf(dateFormat.format(evt.getNewValue()));
                    	 Stringtodatecampus = Stringtodatecampus.replace("/", "-");
                     
                    }
                }
            });
          	
            //CTpickerToDate.setDate(new Date());
            CTpickerToDate.setFormats(dateFormat);
            CTByDatePanel.add(CtlblToDate);
            CTByDatePanel.add(CTpickerToDate);
            SubmitDatecampus =new JButton(" CampusDate Submit "); 
            SubmitDatecampus.setBounds(250, 150, 160, 25);
            SubmitDatecampus.addActionListener(new CampusDateSubmitListener());
            CTByDatePanel.add(SubmitDatecampus);   	
             Campus_Trainee_Date_Panel = new JLabel("Campus Trainee  only By_Date Scraping Panel ");
             Campus_Trainee_Date_Panel.setBounds(200, -20, 380, 90);
         	CTByDatePanel.add(Campus_Trainee_Date_Panel);   	
            
         
           	
           	
           	
//////////////////////////////////////////////////////////////////////////////////////////////////////
          	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Direct trainee scraping by date

// DtByDatePanel panel for scrapping by Date
           	DtByDatePanel  = new JPanel();
           	DtByDatePanel.setPreferredSize(new Dimension(300, 300));
           	DtByDatePanel.setLayout(null);	 
           	DtByDatePanel.setBackground(Color.magenta);
           	DtlblFromDate = new JLabel("From Date:");
           		//                     x   y
           	DtlblFromDate.setBounds(170, 80, 120, 25);

           	DTpickerFromDate = new JXDatePicker();
           //	DTpickerFromDate.setDate(new Date());
           	DTpickerFromDate.setBounds(260, 80, 150, 25);
           	DTpickerFromDate.addPropertyChangeListener(new PropertyChangeListener() {
           		@Override
           		public void propertyChange(PropertyChangeEvent evt) {
           			if ("date".equals(evt.getPropertyName())) {
           				System.out.println("From Date: " + dateFormat.format(evt.getNewValue()));
           				StringFromdateDirect = String.valueOf(dateFormat.format(evt.getNewValue()));
           				StringFromdateDirect = StringFromdateDirect.replace("/", "-");


           			}
           		}
           	});
           	DTpickerFromDate.setFormats(dateFormat);
           	DtByDatePanel.add(DtlblFromDate);
           	DtByDatePanel.add(DTpickerFromDate);

           	DtlblToDate = new JLabel("To Date:");
           	DtlblToDate.setBounds(185, 110, 80, 25);

           	DTpickerToDate = new JXDatePicker();
           	DTpickerToDate.setBounds(260, 110, 150, 25);
           	DTpickerToDate.addPropertyChangeListener(new PropertyChangeListener() {
           		@Override
           		public  void propertyChange(PropertyChangeEvent evt) {
           			if ("date".equals(evt.getPropertyName())) {
           				System.out.println("To Date: " + dateFormat.format(evt.getNewValue()));
           				StringtodateDirect = String.valueOf(dateFormat.format(evt.getNewValue()));
           				StringtodateDirect = StringtodateDirect.replace("/", "-");

           			}
           		}
           	});

           //	DTpickerToDate.setDate(new Date());
           	DTpickerToDate.setFormats(dateFormat);
           	DtByDatePanel.add(DtlblToDate);
           	DtByDatePanel.add(DTpickerToDate);
           	SubmitDateDirect =new JButton(" DirectDate Submit "); 
           	SubmitDateDirect.setBounds(250, 150, 160, 25);
           	SubmitDateDirect.addActionListener(new DirectDateSubmitListener());
        	DtByDatePanel.add(SubmitDateDirect);   	
            Direct_Trainee_Date_Panel = new JLabel("Direct Trainee  only By_Date  Scraping Panel ");
            Direct_Trainee_Date_Panel.setBounds(200, -20, 380, 90);
          	DtByDatePanel.add(Direct_Trainee_Date_Panel);   	



//////////////////////////////////////////////////////////////////////////////////////////////////////
 
     
         // CapeByDatePanel panel for scrapping by Date
          	CapeByDatePanel  = new JPanel();
          	CapeByDatePanel.setPreferredSize(new Dimension(300, 300));
          	CapeByDatePanel.setLayout(null);	 
          	CapeByDatePanel.setBackground(Color.white);
          	CapelblFromDate = new JLabel("From Date:");
           		//                     x   y
          	CapelblFromDate.setBounds(170, 80, 120, 25);

          	capepickerFromDate = new JXDatePicker();
           //	DTpickerFromDate.setDate(new Date());
          	capepickerFromDate.setBounds(260, 80, 150, 25);
          	capepickerFromDate.addPropertyChangeListener(new PropertyChangeListener() {
           		@Override
           		public void propertyChange(PropertyChangeEvent evt) {
           			if ("date".equals(evt.getPropertyName())) {
           				System.out.println("From Date: " + dateFormat.format(evt.getNewValue()));
           				StringFromdateCape = String.valueOf(dateFormat.format(evt.getNewValue()));
           				StringFromdateCape = StringFromdateCape.replace("/", "-");


           			}
           		}
           	});
          	capepickerFromDate.setFormats(dateFormat);
           	CapeByDatePanel.add(CapelblFromDate);
           	CapeByDatePanel.add(capepickerFromDate);

           	CapelblToDate = new JLabel("To Date:");
           	CapelblToDate.setBounds(185, 110, 80, 25);

           	capepickerToDate = new JXDatePicker();
           	capepickerToDate.setBounds(260, 110, 150, 25);
           	capepickerToDate.addPropertyChangeListener(new PropertyChangeListener() {
           		@Override
           		public  void propertyChange(PropertyChangeEvent evt) {
           			if ("date".equals(evt.getPropertyName())) {
           				System.out.println("To Date: " + dateFormat.format(evt.getNewValue()));
           				StringTodateCape = String.valueOf(dateFormat.format(evt.getNewValue()));
           				StringTodateCape = StringTodateCape.replace("/", "-");

           			}
           		}
           	});

           //	DTpickerToDate.setDate(new Date());
           	capepickerToDate.setFormats(dateFormat);
           	CapeByDatePanel.add(CapelblToDate);
           	CapeByDatePanel.add(capepickerToDate);
           	CapeSubmitDateDirect =new JButton(" CapegeminiDate Submit "); 
           	CapeSubmitDateDirect.setBounds(250, 150, 190, 25);
           	CapeSubmitDateDirect.addActionListener(new CapegeminiDateSubmitListener());
           	CapeByDatePanel.add(CapeSubmitDateDirect);   	
           	Capegemeni_Date_lable = new JLabel("Capegemini Candidate  only By_Date  Scraping Panel ");
           	Capegemeni_Date_lable.setBounds(200, -20, 380, 90);
            CapeByDatePanel.add(Capegemeni_Date_lable);   	



//////////////////////////////////////////////////////////////////////////////////////////////////////
     	
          	
          	
          	
          	// Add back button to tcsPanel
        ImageIcon icon0 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
      // //backButton.setPreferredSize(new Dimension(100,0));
         backButton = new JButton(icon0);
         backButton.setPreferredSize(new Dimension(60,60));
         backButton.setBounds(10,10, 30, 25);
         backButton.setToolTipText("back for main tcs panel");
         
     	backButton.addActionListener(new BackListener());
        tcsPanel.add(backButton);
////////////////////////////////////////////####################################### 
////////////////////////////////////////////####################################### 
        //Experience candidate Fileupload panel
        // Create the file upload panel with upload button
        fileUploadPanel = new JPanel();
        fileUploadPanel.setLayout(null);
        uploadButton = new JButton("Upload File");
       uploadButton.setBounds(150, 60, 140, 25);
        	fileUploadPanel.add(uploadButton);
         fileUploadPanel.setBackground(Color.pink);
         fileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       
         uploadButton.addActionListener(new UploadListener());
        uploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
        uploadedfile =new JTextField();
        uploadedfile.setColumns(20);
        uploadedfile.setEditable(false);
        uploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
        uploadedfile.setBounds(300, 60, 300, 25);
        fileUploadPanel.add(uploadedfile);
        Experience_id_lable = new JLabel("Experience By_ID Upload and Scraping Panel ");
         Experience_id_lable.setBounds(210, -20, 350, 90);
         fileUploadPanel.add(Experience_id_lable);
         
        
        // Create the submit panel with submit button
        //submitPanel = new JPanel(new FlowLayout());
         submitButton = new JButton("Submit");
         submitButton.setBounds(200, 100, 100, 25);
         fileUploadPanel.add(submitButton);
         submitButton.addActionListener(new submitListener());
         submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
         fileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked
        
          // Add back button to tcsPanel
         ImageIcon icon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
       // //backButton.setPreferredSize(new Dimension(100,0));
          back1Button = new JButton(icon1);
          back1Button.setPreferredSize(new Dimension(60,60));
          back1Button.setToolTipText("back to tcs ID scraping");
          
          back1Button.setBounds(10,10, 30, 25);
           back1Button.addActionListener(new BackIDListener());
         fileUploadPanel.add(back1Button);
    
  
         
////////////////////////////////////////////####################################### 

////////////////////////////////////////////####################################### 
//Capegemini candidate Fileupload panel
// Create the file upload panel with upload button
         capefileUploadPanel = new JPanel();
         capefileUploadPanel.setLayout(null);
         capeuploadButton = new JButton("Upload File");
         capeuploadButton.setBounds(150, 60, 140, 25);
         capefileUploadPanel.add(capeuploadButton);
         capefileUploadPanel.setBackground(Color.white);
         capefileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         capeuploadButton.addActionListener(new capeUploadListener());
         capeuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
         capeuploadedfile =new JTextField();
         capeuploadedfile.setColumns(20);
         capeuploadedfile.setEditable(false);
         capeuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
         capeuploadedfile.setBounds(300, 60, 300, 25);
         capefileUploadPanel.add(capeuploadedfile);
         CapeCandidate_id_lable = new JLabel("Capegemini candidate By_ID Upload and Scraping Panel ");
         CapeCandidate_id_lable.setBounds(210, -20, 350, 90);
         capefileUploadPanel.add(CapeCandidate_id_lable);


         // Create the submit panel with submit button
         //submitPanel = new JPanel(new FlowLayout());
         CapesubmitButton = new JButton("Submit");
         CapesubmitButton.setBounds(200, 100, 100, 25);
         capefileUploadPanel.add(CapesubmitButton);
         CapesubmitButton.addActionListener(new capefileuploadsubmitListener());
         CapesubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
         capefileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

         // Add back button to tcsPanel
         ImageIcon capeicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
         // //backButton.setPreferredSize(new Dimension(100,0));
         capeback1Button = new JButton(capeicon1);
         capeback1Button.setPreferredSize(new Dimension(60,60));	
         capeback1Button.setToolTipText("back to Capegemini ID Scraping");

         capeback1Button.setBounds(10,10, 30, 25);
         capeback1Button.addActionListener(new CapeBackIDListener());
         capefileUploadPanel.add(capeback1Button);



////////////////////////////////////////////#######################################         
         
         
////////////////////////////////////////////####################################### 
//Capegemini candidate Fileupload panel
//Create the file upload panel with upload button
         HCLfileUploadPanel = new JPanel();
         HCLfileUploadPanel.setLayout(null);
         HCLuploadButton = new JButton("Upload File");
         HCLuploadButton.setBounds(150, 60, 140, 25);
         HCLfileUploadPanel.add(HCLuploadButton);
         HCLfileUploadPanel.setBackground(Color.red);
         HCLfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         HCLuploadButton.addActionListener(new HCLUploadListener());
         HCLuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
         HCLuploadedfile =new JTextField();
         HCLuploadedfile.setColumns(20);
         HCLuploadedfile.setEditable(false);
         HCLuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
         HCLuploadedfile.setBounds(300, 60, 300, 25);
         HCLfileUploadPanel.add(HCLuploadedfile);
         HCLCandidate_id_lable = new JLabel("HCL candidate By_ID Upload and Scraping Panel ");
         HCLCandidate_id_lable.setBounds(210, -20, 350, 90);
         HCLfileUploadPanel.add(HCLCandidate_id_lable);


         // Create the submit panel with submit button
         //submitPanel = new JPanel(new FlowLayout());
         HCLsubmitButton = new JButton("HCL Submit");
         HCLsubmitButton.setBounds(200, 100, 100, 25);
         HCLfileUploadPanel.add(HCLsubmitButton);
         HCLsubmitButton.addActionListener(new HCLfileuploadsubmitListener());
         HCLsubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
         HCLfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

         // Add back button to tcsPanel
         ImageIcon HCLicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
         // //backButton.setPreferredSize(new Dimension(100,0));
         HCLback1Button = new JButton(HCLicon1);
         HCLback1Button.setPreferredSize(new Dimension(60,60));	
         HCLback1Button.setToolTipText("back to HCL ID Scraping");

         HCLback1Button.setBounds(10,10, 30, 25);
         HCLback1Button.addActionListener(new HCLBackIDListener());
         HCLfileUploadPanel.add(HCLback1Button);

////////////////////////////////////////////#######################################         

        
////////////////////////////////////////////####################################### 
//GENPACT candidate Fileupload panel
//Create the file upload panel with upload button
GENfileUploadPanel = new JPanel();
GENfileUploadPanel.setLayout(null);
GENuploadButton = new JButton("Upload File");
GENuploadButton.setBounds(150, 60, 140, 25);
GENfileUploadPanel.add(GENuploadButton);
GENfileUploadPanel.setBackground(Color.blue);
GENfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

GENuploadButton.addActionListener(new GENUploadListener());
GENuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
GENuploadedfile =new JTextField();
GENuploadedfile.setColumns(20);
GENuploadedfile.setEditable(false);
GENuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
GENuploadedfile.setBounds(300, 60, 300, 25);
GENfileUploadPanel.add(GENuploadedfile);
GENCandidate_id_lable = new JLabel("GENPACT candidate By_ID Upload and Scraping Panel ");
GENCandidate_id_lable.setBounds(210, -20, 350, 90);
GENfileUploadPanel.add(GENCandidate_id_lable);


// Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
GENsubmitButton = new JButton("GEN Submit");
GENsubmitButton.setBounds(200, 100, 100, 25);
GENfileUploadPanel.add(GENsubmitButton);
GENsubmitButton.addActionListener(new GENfileuploadsubmitListener());
GENsubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
GENfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

// Add back button to tcsPanel
ImageIcon GENicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
// //backButton.setPreferredSize(new Dimension(100,0));
GENback1Button = new JButton(GENicon1);
GENback1Button.setPreferredSize(new Dimension(60,60));	
GENback1Button.setToolTipText("back to GENPACT ID Scraping");

GENback1Button.setBounds(10,10, 30, 25);
GENback1Button.addActionListener(new GENBackIDListener());
GENfileUploadPanel.add(GENback1Button);

////////////////////////////////////////////#######################################         

////////////////////////////////////////////####################################### 
//NIVABUPA candidate Fileupload panel
//Create the file upload panel with upload button
NivafileUploadPanel = new JPanel();
NivafileUploadPanel.setLayout(null);
NivauploadButton = new JButton("Upload File");
NivauploadButton.setBounds(150, 60, 140, 25);
NivafileUploadPanel.add(NivauploadButton);
NivafileUploadPanel.setBackground(Color.green);
NivafileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

NivauploadButton.addActionListener(new NivaUploadListener());
NivauploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
Nivauploadedfile =new JTextField();
Nivauploadedfile.setColumns(20);
Nivauploadedfile.setEditable(false);
Nivauploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
Nivauploadedfile.setBounds(300, 60, 300, 25);
NivafileUploadPanel.add(Nivauploadedfile);
NivaCandidate_id_lable = new JLabel("NivaBupa candidate By_ID Upload and Scraping Panel ");
NivaCandidate_id_lable.setBounds(210, -20, 350, 90);
NivafileUploadPanel.add(NivaCandidate_id_lable);


// Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
NivasubmitButton = new JButton("Niva Submit");
NivasubmitButton.setBounds(200, 100, 100, 25);
NivafileUploadPanel.add(NivasubmitButton);
NivasubmitButton.addActionListener(new NivafileuploadsubmitListener());
NivasubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
NivafileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

// Add back button to tcsPanel
ImageIcon Nivaicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
// //backButton.setPreferredSize(new Dimension(100,0));
Nivaback1Button = new JButton(Nivaicon1);
Nivaback1Button.setPreferredSize(new Dimension(60,60));	
Nivaback1Button.setToolTipText("back to NivaBupa ID Scraping");

Nivaback1Button.setBounds(10,10, 30, 25);
Nivaback1Button.addActionListener(new NivaBackIDListener());
NivafileUploadPanel.add(Nivaback1Button);



////////////////////////////////////////////####################################### 

////////////////////////////////////////////####################################### 
//IndusInd candidate Fileupload panel
//Create the file upload panel with upload button
IndusfileUploadPanel = new JPanel();
IndusfileUploadPanel.setLayout(null);
IndusuploadButton = new JButton("Upload File");
IndusuploadButton.setBounds(150, 60, 140, 25);
IndusfileUploadPanel.add(IndusuploadButton);
IndusfileUploadPanel.setBackground(Color.gray);
IndusfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

IndusuploadButton.addActionListener(new IndusindUploadListener());
IndusuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
Indusuploadedfile =new JTextField();
Indusuploadedfile.setColumns(20);
Indusuploadedfile.setEditable(false);
Indusuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
Indusuploadedfile.setBounds(300, 60, 300, 25);
IndusfileUploadPanel.add(Indusuploadedfile);
IndusCandidate_id_lable = new JLabel("Indusind candidate By_ID Upload and Scraping Panel ");
IndusCandidate_id_lable.setBounds(210, -20, 350, 90);
IndusfileUploadPanel.add(IndusCandidate_id_lable);


//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
IndussubmitButton = new JButton("Indusind Submit");
IndussubmitButton.setBounds(200, 100, 100, 25);
IndusfileUploadPanel.add(IndussubmitButton);
IndussubmitButton.addActionListener(new IndusfileuploadsubmitListener());
IndussubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
IndusfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to tcsPanel
ImageIcon Indusicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
Indusback1Button = new JButton(Indusicon1);
Indusback1Button.setPreferredSize(new Dimension(60,60));	
Indusback1Button.setToolTipText("back to Indusind ID Scraping");

Indusback1Button.setBounds(10,10, 30, 25);
Indusback1Button.addActionListener(new IndusBackIDListener());
IndusfileUploadPanel.add(Indusback1Button);



////////////////////////////////////////////####################################### 


////////////////////////////////////////////####################################### 
//RBL candidate Fileupload panel
//Create the file upload panel with upload button
RBLfileUploadPanel = new JPanel();
RBLfileUploadPanel.setLayout(null);
RBLuploadButton = new JButton("Upload File");
RBLuploadButton.setBounds(150, 120, 130, 25);
RBLfileUploadPanel.add(RBLuploadButton);
RBLfileUploadPanel.setBackground(Color.cyan);
RBLfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

RBLuploadButton.addActionListener(new RBLUploadListener());
RBLuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
RBLuploadedfile =new JTextField();
RBLuploadedfile.setColumns(20);
RBLuploadedfile.setEditable(false);
RBLuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
RBLuploadedfile.setBounds(300, 120, 300, 25);
RBLfileUploadPanel.add(RBLuploadedfile);
//RBLuploadedfile1 =new JTextField();
//RBLuploadedfile1.setColumns(20);
//RBLuploadedfile1.setFont(new Font("Arial", Font.PLAIN, 14));
//RBLuploadedfile1.setBounds(300, 120, 300, 25);

//RBLfileUploadPanel1.add(RBLuploadedfile1);
RBLCandidate_id_lable = new JLabel("RBL candidate By_ID Upload and Scraping Panel ");
RBLCandidate_id_lable.setBounds(210, -20, 350, 90);
RBLfileUploadPanel.add(RBLCandidate_id_lable);


//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
RBLsubmitButton = new JButton("RBL Submit");
RBLsubmitButton.setBounds(200, 160, 100, 25);
RBLfileUploadPanel.add(RBLsubmitButton);
RBLsubmitButton.addActionListener(new RBLfileuploadsubmitListener());
RBLsubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
RBLfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to RBL
ImageIcon RBLicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
RBLback1Button = new JButton(RBLicon1);
RBLback1Button.setPreferredSize(new Dimension(60,60));	
RBLback1Button.setToolTipText("back to RBL ID Scraping");

RBLback1Button.setBounds(10,10, 30, 25);
RBLback1Button.addActionListener(new RBLBackIDListener());
RBLfileUploadPanel.add(RBLback1Button);

////////////////////////////////////////////####################################### 

////////////////////////////////////////////####################################### 
//Tech_mahindra candidate Fileupload panel
//Create the file upload panel with upload button
Tech_mahindrafileUploadPanel = new JPanel();
Tech_mahindrafileUploadPanel.setLayout(null);
Tech_mahindrauploadButton = new JButton("Upload File");
Tech_mahindrauploadButton.setBounds(150, 120, 130, 25);
usernameLabeltech = new JLabel("UserName");
usernameLabeltech.setBounds(45,80,120,25);
Tech_mahindrafileUploadPanel.add(usernameLabeltech);
passwordLabeltech = new JLabel("Password");
passwordLabeltech.setBounds(325,80,120,25);
Tech_mahindrafileUploadPanel.add(passwordLabeltech);
Tech_mahindrausername =new JTextField();
Tech_mahindrausername.setColumns(20);
Tech_mahindrausername.setEditable(true);
Tech_mahindrausername.setFont(new Font("Arial", Font.PLAIN, 14));
Tech_mahindrausername.setBounds(125, 80, 200, 25);
Tech_mahindrafileUploadPanel.add(Tech_mahindrausername);

Tech_mahindrapassword =new JPasswordField();
Tech_mahindrapassword.setColumns(20);
Tech_mahindrapassword.setEditable(true);
Tech_mahindrapassword.setFont(new Font("Arial", Font.PLAIN, 14));
Tech_mahindrapassword.setBounds(402, 80, 200, 25);
Tech_mahindrafileUploadPanel.add(Tech_mahindrapassword);


Tech_mahindrafileUploadPanel.add(Tech_mahindrauploadButton);
Tech_mahindrafileUploadPanel.setBackground(Color.yellow);
Tech_mahindrafileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

Tech_mahindrauploadButton.addActionListener(new Tech_mahindraUploadListener());
Tech_mahindrauploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
Tech_mahindrauploadedfile =new JTextField();
Tech_mahindrauploadedfile.setColumns(20);
Tech_mahindrauploadedfile.setEditable(false);
Tech_mahindrauploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
Tech_mahindrauploadedfile.setBounds(300, 120, 300, 25);
Tech_mahindrafileUploadPanel.add(Tech_mahindrauploadedfile);
Tech_mahindraCandidate_id_lable = new JLabel("Tech_mahindra candidate By_ID Upload and Scraping Panel ");
Tech_mahindraCandidate_id_lable.setBounds(210, -20, 350, 90);
Tech_mahindrafileUploadPanel.add(Tech_mahindraCandidate_id_lable);


//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
Tech_mahindrasubmitButton = new JButton("Tech_Submit");
Tech_mahindrasubmitButton.setBounds(200, 160, 100, 25);
Tech_mahindrafileUploadPanel.add(Tech_mahindrasubmitButton);
Tech_mahindrasubmitButton.addActionListener(new Tech_mahindrafileuploadsubmitListener());
Tech_mahindrasubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
Tech_mahindrafileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to RBL
ImageIcon Tech_mahindraicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
Tech_mahindraback1Button = new JButton(Tech_mahindraicon1);
Tech_mahindraback1Button.setPreferredSize(new Dimension(60,60));	
Tech_mahindraback1Button.setToolTipText("back to Tech_mahindra ID Scraping");

Tech_mahindraback1Button.setBounds(10,10, 30, 25);
Tech_mahindraback1Button.addActionListener(new Tech_mahindraBackIDListener());
Tech_mahindrafileUploadPanel.add(Tech_mahindraback1Button);

////////////////////////////////////////////####################################### 


////////////////////////////////////////////####################################### 
//Cognizant candidate Fileupload panel
//Create the file upload panel with upload button
CognizantfileUploadPanel = new JPanel();
CognizantfileUploadPanel.setLayout(null);
CognizantuploadButton = new JButton("Upload File");
CognizantuploadButton.setBounds(150, 150, 130, 25);
usernameLabelCognizant= new JLabel("UserName");
usernameLabelCognizant.setBounds(45,80,120,25);
CognizantfileUploadPanel.add(usernameLabelCognizant);
//passwordLabelCognizant = new JLabel("Password");
//passwordLabelCognizant.setBounds(325,80,120,25);
//CognizantfileUploadPanel.add(passwordLabelCognizant);
Cognizantusername =new JTextField();
Cognizantusername.setColumns(20);
Cognizantusername.setEditable(true);
Cognizantusername.setFont(new Font("Arial", Font.PLAIN, 14));
Cognizantusername.setBounds(125, 80, 200, 25);
CognizantfileUploadPanel.add(Cognizantusername);

//Cognizantpassword =new JPasswordField();Cognizantpassword.setColumns(20);
//Cognizantpassword.setEditable(true);
//Cognizantpassword.setFont(new Font("Arial", Font.PLAIN, 14));
//Cognizantpassword.setBounds(402, 80, 200, 25);
//CognizantfileUploadPanel.add(Cognizantpassword);


CognizantfileUploadPanel.add(CognizantuploadButton);
CognizantfileUploadPanel.setBackground(Color.red);
CognizantfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

CognizantuploadButton.addActionListener(new CognizantUploadListener());
CognizantuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
Cognizantuploadedfile =new JTextField();
Cognizantuploadedfile.setColumns(20);
Cognizantuploadedfile.setEditable(false);
Cognizantuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
Cognizantuploadedfile.setBounds(300, 150, 300, 25);
CognizantfileUploadPanel.add(Cognizantuploadedfile);
CognizantCandidate_id_lable = new JLabel("Cognizant candidate By_ID Upload and Scraping Panel ");
CognizantCandidate_id_lable.setBounds(210, -20, 350, 90);
CognizantfileUploadPanel.add(CognizantCandidate_id_lable);

AcclblFromDate = new JLabel("From Date:");
	//                     x   y
AcclblFromDate.setBounds(70, 115, 130, 25);
//Date Picker  	
AccpickerFromDate = new JXDatePicker();
	//pickerFromDate.setDate(new Date());
AccpickerFromDate.setBounds(150, 115, 130, 25);
AccpickerFromDate.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            System.out.println("From Date: " + dateFormat1.format(evt.getNewValue()));
            StringAccFromdate =   String.valueOf(dateFormat1.format(evt.getNewValue()));
            StringAccFromdate = StringAccFromdate.replace("/", "-");
        }
        }
});

	System.out.println((StringAccFromdate));
	AccpickerFromDate.setFormats(dateFormat1);
	CognizantfileUploadPanel.add(AcclblFromDate);
CognizantfileUploadPanel.add(AccpickerFromDate);

AcclblToDate = new JLabel("To Date:");
AcclblToDate.setBounds(330, 115, 130, 25);

AccpickerToDate = new JXDatePicker();
AccpickerToDate.setBounds(410, 115, 130, 25);
AccpickerToDate.addPropertyChangeListener(new PropertyChangeListener() {
	
	@Override
    public void propertyChange(PropertyChangeEvent evt1) {
        if ("date".equals(evt1.getPropertyName())) {
            System.out.println("To Date: " + dateFormat1.format(evt1.getNewValue()));
            StringAcctodate = String.valueOf(dateFormat1.format(evt1.getNewValue()));
            StringAcctodate = StringAcctodate.replace("/", "-");
        }
      
	}
});


//pickerToDate.setDate(new Date());
AccpickerToDate.setFormats(dateFormat1);
CognizantfileUploadPanel.add(AcclblToDate);
CognizantfileUploadPanel.add(AccpickerToDate);
	
	
//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
CognizantsubmitButton = new JButton("Cognizant_Submit");
CognizantsubmitButton.setBounds(200, 190, 100, 25);
CognizantfileUploadPanel.add(CognizantsubmitButton);
CognizantsubmitButton.addActionListener(new CognizantfileuploadsubmitListener());
CognizantsubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
CognizantfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to RBL
ImageIcon Cognizanticon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
Cognizantback1Button = new JButton(Cognizanticon1);
Cognizantback1Button.setPreferredSize(new Dimension(60,60));	
Cognizantback1Button.setToolTipText("back to Tech_mahindra ID Scraping");

Cognizantback1Button.setBounds(10,10, 30, 25);
Cognizantback1Button.addActionListener(new CognizantBackIDListener());
CognizantfileUploadPanel.add(Cognizantback1Button);

////////////////////////////////////////////####################################### 

////////////////////////////////////////////####################################### 
//Wipro candidate Fileupload panel
//Create the file upload panel with upload button
WiprofileUploadPanel = new JPanel();
WiprofileUploadPanel.setLayout(null);
WiprouploadButton = new JButton("Upload File");
WiprouploadButton.setBounds(150, 120, 130, 25);
WiprofileUploadPanel.add(WiprouploadButton);
WiprofileUploadPanel.setBackground(Color.magenta);
WiprofileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

WiprouploadButton.addActionListener(new WiproUploadListener());
WiprouploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
Wiprouploadedfile =new JTextField();
Wiprouploadedfile.setColumns(20);
Wiprouploadedfile.setEditable(false);
Wiprouploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
Wiprouploadedfile.setBounds(300, 120, 300, 25);
WiprofileUploadPanel.add(Wiprouploadedfile);

//WiprofileUploadPanel1.adcyand(RBLuploadedfile1);
WiproCandidate_id_lable = new JLabel("Wipro candidate By_ID Upload and Scraping Panel ");
WiproCandidate_id_lable.setBounds(210, -20, 350, 90);
WiprofileUploadPanel.add(WiproCandidate_id_lable);


//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
WiprosubmitButton = new JButton("Wipro Submit");
WiprosubmitButton.setBounds(200, 160, 100, 25);
WiprofileUploadPanel.add(WiprosubmitButton);
WiprosubmitButton.addActionListener(new WiprofileuploadsubmitListener());
WiprosubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
WiprofileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to RBL
ImageIcon Wiproicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
Wiproback1Button = new JButton(Wiproicon1);
Wiproback1Button.setPreferredSize(new Dimension(60,60));	
Wiproback1Button.setToolTipText("back to WiproID Scraping");

Wiproback1Button.setBounds(10,10, 30, 25);
Wiproback1Button.addActionListener(new WiproBackIDListener());
WiprofileUploadPanel.add(Wiproback1Button);

////////////////////////////////////////////####################################### 


////////////////////////////////////////////####################################### 
//Acc HRC Fileupload panel
//Create the file upload panel with upload button
AccenturefileUploadPanel = new JPanel();
AccenturefileUploadPanel.setLayout(null);
AccentureuploadButton = new JButton("Upload File");
AccentureuploadButton.setBounds(150, 120, 130, 25);
AccenturefileUploadPanel.add(AccentureuploadButton);
AccenturefileUploadPanel.setBackground(Color.green);
AccenturefileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

AccentureuploadButton.addActionListener(new AccentureUploadListener());
AccentureuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
Accentureuploadedfile =new JTextField();
Accentureuploadedfile.setColumns(20);
Accentureuploadedfile.setEditable(false);
Accentureuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
Accentureuploadedfile.setBounds(300, 120, 300, 25);
AccenturefileUploadPanel.add(Accentureuploadedfile);

//WiprofileUploadPanel1.adcyand(RBLuploadedfile1);
AccentureCandidate_id_lable = new JLabel("Accenture HRC By_ID Upload and Scraping Panel ");
AccentureCandidate_id_lable.setBounds(210, -20, 350, 90);
AccenturefileUploadPanel.add(AccentureCandidate_id_lable);


//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
AccenturesubmitButton = new JButton("Accenture Submit");
AccenturesubmitButton.setBounds(200, 160, 100, 25);
AccenturefileUploadPanel.add(AccenturesubmitButton);
AccenturesubmitButton.addActionListener(new AccenturefileuploadsubmitListener());
AccenturesubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
AccenturefileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to RBL
ImageIcon Accentureicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
Accentureback1Button = new JButton(Accentureicon1);
Accentureback1Button.setPreferredSize(new Dimension(60,60));	
Accentureback1Button.setToolTipText("back to WiproID Scraping");

Accentureback1Button.setBounds(10,10, 30, 25);
Accentureback1Button.addActionListener(new AccentureBackIDListener());
AccenturefileUploadPanel.add(Accentureback1Button);

////////////////////////////////////////////#######################################    


////////////////////////////////////////////####################################### 
//Acc candidate Fileupload panel
//Create the file upload panel with upload button
AccentureCandidatefileUploadPanel = new JPanel();
AccentureCandidatefileUploadPanel.setLayout(null);
AccentureCandidateuploadButton = new JButton("Upload File");
AccentureCandidateuploadButton.setBounds(150, 120, 130, 25);
AccentureCandidatefileUploadPanel.add(AccentureCandidateuploadButton);
AccentureCandidatefileUploadPanel.setBackground(Color.green);
AccentureCandidatefileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

AccentureCandidateuploadButton.addActionListener(new AccentureCandidateUploadListener());
AccentureCandidateuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
AccentureCandidateuploadedfile =new JTextField();
AccentureCandidateuploadedfile.setColumns(20);
AccentureCandidateuploadedfile.setEditable(false);
AccentureCandidateuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
AccentureCandidateuploadedfile.setBounds(300, 120, 300, 25);
AccentureCandidatefileUploadPanel.add(AccentureCandidateuploadedfile);

//WiprofileUploadPanel1.adcyand(RBLuploadedfile1);
AccentureCandidateCandidate_id_lable = new JLabel("Accenture candidate By_ID Upload and Scraping Panel ");
AccentureCandidateCandidate_id_lable.setBounds(210, -20, 350, 90);
AccentureCandidatefileUploadPanel.add(AccentureCandidateCandidate_id_lable);


//Create the submit panel with submit button
//submitPanel = new JPanel(new FlowLayout());
AccentureCandidatesubmitButton = new JButton("Accenture Submit");
AccentureCandidatesubmitButton.setBounds(200, 160, 100, 25);
AccentureCandidatefileUploadPanel.add(AccentureCandidatesubmitButton);
AccentureCandidatesubmitButton.addActionListener(new AccentureCandidatefileuploadsubmitListener());
AccentureCandidatesubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));
AccentureCandidatefileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

//Add back button to RBL
ImageIcon Accenturecandidateicon1 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
////backButton.setPreferredSize(new Dimension(100,0));
AccentureCandidateback1Button = new JButton(Accenturecandidateicon1);
AccentureCandidateback1Button.setPreferredSize(new Dimension(60,60));	
AccentureCandidateback1Button.setToolTipText("back to AccentureCandidate Scraping");

AccentureCandidateback1Button.setBounds(10,10, 30, 25);
AccentureCandidateback1Button.addActionListener(new AccentureCandidateBackIDListener());
AccentureCandidatefileUploadPanel.add(AccentureCandidateback1Button);

////////////////////////////////////////////#######################################    





////////////////////////////////////////////####################################### 
//specfic relation bgc check panel
///creating file upload and submit for TCS Specfic background check
         // Create the file upload panel with upload button
         TcsfileUploadPanel = new JPanel();
         TcsfileUploadPanel.setLayout(null);
         uploadButton1 = new JButton("Upload File1");
        uploadButton1.setBounds(150, 60, 140, 25);
        TcsfileUploadPanel.add(uploadButton1);
        TcsfileUploadPanel.setBackground(Color.gray);
        TcsfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        uploadButton1.addActionListener(new UploadListener1());
         uploadButton1.setFont(new Font("Arial", Font.PLAIN, 14));
         uploadedfile1 =new JTextField();
         uploadedfile1.setColumns(20);
         uploadedfile1.setEditable(false);
         uploadedfile1.setFont(new Font("Arial", Font.PLAIN, 14));
         uploadedfile1.setBounds(300, 60, 300, 25);
         TcsfileUploadPanel.add(uploadedfile1);
         
         Specfic_Relation_id_Panel = new JLabel("Specfic_Relation  By_ID upload and Scraping Panel ");
         Specfic_Relation_id_Panel.setBounds(210, -20, 350, 90);
           TcsfileUploadPanel.add(Specfic_Relation_id_Panel);
           
         // Create the submit panel with submit button
         //submitPanel = new JPanel(new FlowLayout());
          submitButton1 = new JButton("Submit1");
          submitButton1.setBounds(200, 100, 100, 25);
          TcsfileUploadPanel.add(submitButton1);
            submitButton1.addActionListener(new TcssubmitListener1());
          submitButton1.setFont(new Font("Arial", Font.PLAIN, 14));
          TcsfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked
         
      
          ////////////////////////////////////////////####################################### 
          ///////////////////////////////////////////####################################### 
          //campus trainee candidate Fileupload panel
          // Create the file upload panel with upload button
          CTfileUploadPanel = new JPanel();
          CTfileUploadPanel.setLayout(null);
          CTuploadButton = new JButton("CT Upload File");
          CTuploadButton.setBounds(150, 60, 140, 25);
          CTfileUploadPanel.add(CTuploadButton);
          CTfileUploadPanel.setBackground(Color.yellow);
          CTfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          
          CTuploadButton.addActionListener(new UploadListenercampus());
          CTuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
          CTuploadedfile =new JTextField();
          CTuploadedfile.setColumns(20);
          CTuploadedfile.setEditable(false);
          CTuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
          CTuploadedfile.setBounds(300, 60, 300, 25);
          CTfileUploadPanel.add(CTuploadedfile);
           Campus_trainee_id_Panel = new JLabel("Campus Trainee  By_ID upload and Scraping Panel ");
           Campus_trainee_id_Panel.setBounds(210, -20, 350, 90);
           CTfileUploadPanel.add(Campus_trainee_id_Panel);
           

          // Create the submit panel with submit button
          //submitPanel = new JPanel(new FlowLayout());	
          CTsubmitButton = new JButton("Submit");	
          CTsubmitButton.setBounds(200, 100, 100, 25);
          CTfileUploadPanel.add(CTsubmitButton);
          CTsubmitButton.addActionListener(new CampusTraineesubmitListener());
          CTsubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));	
          CTfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

          // Add back button to tcsPanel
          ImageIcon icon8 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
          // //backButton.setPreferredSize(new Dimension(100,0));
          CTbackButton = new JButton(icon8);
          CTbackButton.setPreferredSize(new Dimension(60,60));
          CTbackButton.setToolTipText("back to campus ID scraping");

          CTbackButton.setBounds(10,10, 30, 25);	
          CTbackButton.addActionListener(new campusBackListener());
          CTfileUploadPanel.add(CTbackButton);	
          ////////////////////////////////////////////####################################### 
          ////////////////////////////////////////////####################################### 

          ///////////////////////////////////////////####################################### 
          //Direct trainee candidate Fileupload panel
          // Create the file upload panel with upload button for Direct trainee
          DtfileUploadPanel = new JPanel();
          DtfileUploadPanel.setLayout(null); 
          DTuploadButton = new JButton("DT Upload File");
          DTuploadButton.setBounds(150, 60, 140, 25);
          DtfileUploadPanel.add(DTuploadButton);
          DtfileUploadPanel.setBackground(Color.magenta);
          DtfileUploadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          
          DTuploadButton.addActionListener(new UploadListenerDirect());
          DTuploadButton.setFont(new Font("Arial", Font.PLAIN, 14));
          DTuploadedfile =new JTextField();
          DTuploadedfile.setColumns(20);
          DTuploadedfile.setEditable(false);
          DTuploadedfile.setFont(new Font("Arial", Font.PLAIN, 14));
          DTuploadedfile.setBounds(300, 60, 300, 25);
          DtfileUploadPanel.add(DTuploadedfile);


          // Create the submit panel with submit button
          //submitPanel = new JPanel(new FlowLayout());	
          DTsubmitButton = new JButton("Submit");	
          DTsubmitButton.setBounds(200, 100, 100, 25);
          DtfileUploadPanel.add(DTsubmitButton);
          DTsubmitButton.addActionListener(new DirectTraineesubmitListener());
          DTsubmitButton.setFont(new Font("Arial", Font.PLAIN, 14));	
          DtfileUploadPanel.setVisible(false); // Hide file upload panel until pictures button is clicked

          // Add back button to tcsPanel
          ImageIcon icon9 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
          // //backButton.setPreferredSize(new Dimension(100,0));
          DTbackButton = new JButton(icon9);
          DTbackButton.setPreferredSize(new Dimension(60,60));
          DTbackButton.setToolTipText("back to Direct ID scraping");

          DTbackButton.setBounds(10,10, 30, 25);	
          DTbackButton.addActionListener(new DirectBackListener());
          DtfileUploadPanel.add(DTbackButton);	
          Direct_trainee_id_Panel = new JLabel("Direct Trainee  By_ID upload  Scraping Panel ");
          Direct_trainee_id_Panel.setBounds(210, -20, 350, 90);
          DtfileUploadPanel.add(Direct_trainee_id_Panel);	
          


	////////////////////////////////////////////####################################### 
	////////////////////////////////////////////####################################### 
     
          
          // Add back button to tcsPanel
          ImageIcon icon2 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
           back2Button = new JButton(icon2);
           back2Button.setPreferredSize(new Dimension(60,60));
           back2Button.setBounds(10,10, 30, 25);
           back2Button.addActionListener(new Back2Listener());
           back2Button.setToolTipText("back to tcs specfic ID.");
           TcsfileUploadPanel.add(back2Button);
     
      
           
           // Add back button to tcsPanel
           ImageIcon icon3 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
            back3Button = new JButton(icon3);
            back3Button.setPreferredSize(new Dimension(60,60));
            back3Button.setBounds(10,10, 30, 25);
            back3Button.addActionListener(new Back3Listener());
            back3Button.setToolTipText("back to tcs all type scraping1.");
            ByIDPanel.add(back3Button);
      
            
              // Add back button to ByIDSpecPanel
              ImageIcon icon4 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
               back4Button = new JButton(icon4);
               back4Button.setPreferredSize(new Dimension(60,60));
               back4Button.setBounds(10,10, 30, 25);
               back4Button.setToolTipText("back to tcs all type scraping2.");
                back4Button.addActionListener(new Back4Listener());
               ByIDSpecPanel.add(back4Button);
         
               // Add back button to ByIDSpecPanel
               ImageIcon icon5 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
                back5Button = new JButton(icon5);
                back5Button.setPreferredSize(new Dimension(60,60));
                back5Button.setBounds(10,10, 30, 25);
                back5Button.setToolTipText("back to tcs all type scraping id exp.");
                 back5Button.addActionListener(new BackExpDateListener());
                 ByexpDatepanel.add(back5Button);
          
                 // Add back button to ByIDSpecPanel
                 ImageIcon icon6 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
                  back6Button = new JButton(icon6);
                  back6Button.setPreferredSize(new Dimension(60,60));
                  back6Button.setBounds(10,10, 30, 25);
                  back6Button.setToolTipText("back to tcs all type scraping spec.");
                   back6Button.addActionListener(new BackSpecDateListener());
                   BySpecDatePanel.add(back6Button);
            
                   // Add back button to CTByIDPanel
                   ImageIcon icon7 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
                   CTbackButton1 = new JButton(icon7);
                   CTbackButton1.setPreferredSize(new Dimension(60,60));
                   CTbackButton1.setBounds(10,10, 30, 25);
                   CTbackButton1.setToolTipText("back to tcs all type scraping CT.");
                   CTbackButton1.addActionListener(new BackCTListener());
                   CTByIdPanel.add(CTbackButton1);

                   // Add back button to DTByIDPanel
                   ImageIcon icon10 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
                   DTbackButton1 = new JButton(icon10);
                   DTbackButton1.setPreferredSize(new Dimension(60,60));
                   DTbackButton1.setBounds(10,10, 30, 25);
                   DTbackButton1.setToolTipText("back to tcs all type scraping DT.");
                   DTbackButton1.addActionListener(new BackDTListener());
                   DtByIdPanel.add(DTbackButton1);
              
              

                   // Add back button to DTByIDPanel
                   ImageIcon icon11 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
                   camBackbutton = new JButton(icon11);
                   camBackbutton.setPreferredSize(new Dimension(60,60));
                   camBackbutton.setBounds(10,10, 30, 25);
                   camBackbutton.setToolTipText("back to tcs all type scraping CT.");
                   camBackbutton.addActionListener(new CamBackListener());
                   CTByDatePanel.add(camBackbutton);
              
              
               //  
                   // Add back button to DTByIDPanel
                   ImageIcon icon12 = new ImageIcon("/home/admin/Documents/images/2leftarrow.png");
                   DirectBackbutton = new JButton(icon12);
                   DirectBackbutton.setPreferredSize(new Dimension(60,60));
                   DirectBackbutton.setBounds(10,10, 30, 25);
                   DirectBackbutton.setToolTipText("back to tcs all type scraping CT.");
                   DirectBackbutton.addActionListener(new DirBackListener());
                   DtByDatePanel.add(DirectBackbutton);
              
              
          
            
            //***********************************************************************************************//
        //***********************************************************************************************//
              
         // Add panels to the main frame
          getContentPane().setLayout(new CardLayout());
          getContentPane().add(loginPanel);
          getContentPane().add(tcsPanel);
          // getContentPane().add(Scrap);
          getContentPane().add(tcspanel1);
          getContentPane().add(fileUploadPanel);
          getContentPane().add(TcsfileUploadPanel);
          getContentPane().add(ByIDPanel);
          getContentPane().add(ByIDSpecPanel);
          getContentPane().add(ByexpDatepanel);
          getContentPane().add(BySpecDatePanel);
          getContentPane().add(CTfileUploadPanel);
          getContentPane().add(CTByIdPanel);
          getContentPane().add(DtByIdPanel);
          getContentPane().add(DtfileUploadPanel);
          getContentPane().add(CTByDatePanel);
          getContentPane().add(DtByDatePanel);
          getContentPane().add(capePanel);
          getContentPane().add(CapeByIDPanel);
          getContentPane().add(capefileUploadPanel);
          getContentPane().add(CapeByDatePanel);
          getContentPane().add(HCLPanel);
          getContentPane().add(HCLfileUploadPanel);
          getContentPane().add(HCLByIDPanel);
          getContentPane().add(GenPanel);
          getContentPane().add(GENByIDPanel);
          getContentPane().add(GENfileUploadPanel);
          getContentPane().add(NivaPanel);
          getContentPane().add(NivaByIDPanel);
          getContentPane().add(NivafileUploadPanel);
          getContentPane().add(IndusPanel);
          getContentPane().add(IndusByIDPanel);
          getContentPane().add(IndusfileUploadPanel);
          getContentPane().add(RBLPanel);
          getContentPane().add(RBLByIDPanel);
          getContentPane().add(RBLfileUploadPanel);
          getContentPane().add(Tech_mahindraPanel);
          getContentPane().add(Tech_mahindraByIDPanel);
          getContentPane().add(Tech_mahindrafileUploadPanel);
          getContentPane().add(CognizantPanel);
          getContentPane().add(CognizantByIDPanel);
          getContentPane().add(CognizantfileUploadPanel);
          getContentPane().add(WiproPanel);
          getContentPane().add(WiproByIDPanel);
          getContentPane().add(WiprofileUploadPanel);
          getContentPane().add(AccenturePanel);
          getContentPane().add(AccentureByIDPanel);
          getContentPane().add(AccenturefileUploadPanel);
          getContentPane().add(AccentureCandidatefileUploadPanel);
          
          setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
           setVisible(true);   
     }
     
   
     
     
     private class LoginListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
         	
        	 	String username = usernameField.getText();
        	 	String userType = "E";
        	 	String password = new String(((JPasswordField) passwordField).getPassword());

//              String username = usernameField.getText();                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
              
              
              try {
                 //URL url = new URL("https://matexservices.likemindtech.com/matex2-user-service/auth/login");
//            	  URL url = new URL("http://192.168.0.205:8080/matex2-user-service/auth/login");
            	  //URL url = new URL("http://192.168.0.206:8080/matex2-user-service/auth/login");
//              	  URL url = new URL("http://15.235.206.192:8080/matex2-user-service/auth/login");
              	 URL url = new URL("http://192.168.0.101:8080/matex2-user-service/auth/login");
//              	URL url = new URL("http://192.168.0.206:8080/matex2-user-service/auth/login");
              	
            	  HttpURLConnection con = (HttpURLConnection) url.openConnection();
                  con.setRequestMethod("POST");
                  con.setRequestProperty("Content-Type", "application/json");
                  con.setDoOutput(true);

                  String jsonInputString = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\",\"userType\": \"" + userType + "\"}";

                  try (OutputStream os = con.getOutputStream()) {
                      byte[] input = jsonInputString.getBytes("utf-8");
                      os.write(input, 0, input.length);
                  }

                  int responseCode = con.getResponseCode();
                  System.out.println(responseCode);
                  	
                  if (responseCode == HttpURLConnection.HTTP_OK) {
                 	 loginPanel.setVisible(false);
                     tcspanel1.setVisible(true); 
                 	 //tcsPanel.setVisible(true);
                 	 JOptionPane.showMessageDialog(ExampleGUI.this, "Login successful!");
                  }else if (responseCode == 401){
                      JOptionPane.showMessageDialog(ExampleGUI.this, " username or password incorrect.");
                    }else if (responseCode == 400){
                    	  JOptionPane.showMessageDialog(ExampleGUI.this, "Enter username and password.");
                           
                    } else if (responseCode == 503){
                  	  JOptionPane.showMessageDialog(ExampleGUI.this, "Service unavailable.");
                  } else if (responseCode == 502){
                	  JOptionPane.showMessageDialog(ExampleGUI.this, "Service unavailable.");
                }    
                 
                
                  else {
                      JOptionPane.showMessageDialog(ExampleGUI.this, "Login failed.");
                  }

                  con.disconnect();
              } catch (IOException ex) {
                  JOptionPane.showMessageDialog(ExampleGUI.this, "Error: " + ex.getMessage());
              
              }
          }
      }    
      
     
     public class TcsListener implements ActionListener {
      	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(true);
		        	tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	   	 ByIDSpecPanel.setVisible(false);
	           
	        }
	        
}
     
     public class capegeminiIDListener implements ActionListener {
      	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(true);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	           
	    	
	        }
	        
}

     public class HCLIDListener implements ActionListener {
    	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	 HCLByIDPanel.setVisible(true);
	        }
  }	     
	        
     public class GENIDListener implements ActionListener {
   	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(true);
	    	GenPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusPanel.setVisible(false);
	    	RBLPanel.setVisible(false);
		       
	        }
}	     

     public class NivaIDListener implements ActionListener {
      	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(true);
	    	NivaPanel.setVisible(false);
	       
	        }
}	     

     public class IndusindIDListener implements ActionListener {
     	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusByIDPanel.setVisible(true);
	    	IndusPanel.setVisible(false);
	       
	        }
}	     
  
     
     public class RBLIDListener implements ActionListener {
     	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TCS button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusByIDPanel.setVisible(false);
	    	IndusPanel.setVisible(false);
	    	RBLByIDPanel.setVisible(true);
	    	RBLPanel.setVisible(false);
	       
	        }
}   
     
     public class Tech_mahindraIDListener implements ActionListener {
    	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TechMahindra button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusByIDPanel.setVisible(false);
	    	IndusPanel.setVisible(false);
	    	RBLByIDPanel.setVisible(false);
	    	RBLPanel.setVisible(false);
	    	Tech_mahindraByIDPanel.setVisible(true);
	    	Tech_mahindraPanel.setVisible(false);
	    	Tech_mahindrafileUploadPanel.setVisible(false);
	        }
}   

     public class CognizantIDListener implements ActionListener {
   	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TechMahindra button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusByIDPanel.setVisible(false);
	    	IndusPanel.setVisible(false);
	    	RBLByIDPanel.setVisible(false);
	    	RBLPanel.setVisible(false);
	    	Tech_mahindraByIDPanel.setVisible(false);
	    	Tech_mahindraPanel.setVisible(false);
	    	Tech_mahindrafileUploadPanel.setVisible(false);
	    	CognizantByIDPanel.setVisible(true);
	    	CognizantPanel.setVisible(false);
	    	CognizantfileUploadPanel.setVisible(false);
	       
	        }
}   


     public class WiproIDListener implements ActionListener {
      	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TechMahindra button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusByIDPanel.setVisible(false);
	    	IndusPanel.setVisible(false);
	    	RBLByIDPanel.setVisible(false);
	    	RBLPanel.setVisible(false);
	    	Tech_mahindraByIDPanel.setVisible(false);
	    	Tech_mahindraPanel.setVisible(false);
	    	Tech_mahindrafileUploadPanel.setVisible(false);
	    	CognizantByIDPanel.setVisible(false);
	    	CognizantPanel.setVisible(false);
	    	CognizantfileUploadPanel.setVisible(false);
	    	WiproByIDPanel.setVisible(true);
	    	WiproPanel.setVisible(false);
	    	WiprofileUploadPanel.setVisible(false);
	       
	        }
}   

     public class AccentureIDHRCListener implements ActionListener {
     	  
	        public void actionPerformed(ActionEvent e) {
	            // Show file upload panel when TechMahindra button is clicked
	       	 ByIDPanel.setVisible(false);
	       	CapeByIDPanel.setVisible(false);
	       	 capePanel.setVisible(false);
		    tcsPanel.setVisible(false);
	       	 tcspanel1.setVisible(false);
	     	fileUploadPanel.setVisible(false);
	    	TcsfileUploadPanel.setVisible(false);
	    	ByIDSpecPanel.setVisible(false);
	    	HCLPanel.setVisible(false); 
	    	HCLByIDPanel.setVisible(false);
	    	GENByIDPanel.setVisible(false);
	    	GenPanel.setVisible(false);
	    	NivaByIDPanel.setVisible(false);
	    	NivaPanel.setVisible(false);
	    	IndusByIDPanel.setVisible(false);
	    	IndusPanel.setVisible(false);
	    	RBLByIDPanel.setVisible(false);
	    	RBLPanel.setVisible(false);
	    	Tech_mahindraByIDPanel.setVisible(false);
	    	Tech_mahindraPanel.setVisible(false);
	    	Tech_mahindrafileUploadPanel.setVisible(false);
	    	CognizantByIDPanel.setVisible(false);
	    	CognizantPanel.setVisible(false);
	    	CognizantfileUploadPanel.setVisible(false);
	    	WiproByIDPanel.setVisible(false);
	    	WiproPanel.setVisible(false);
	    	WiprofileUploadPanel.setVisible(false);
	    	AccentureByIDPanel.setVisible(true);
	    	AccenturePanel.setVisible(false);
	    	AccenturefileUploadPanel.setVisible(false);
	       
	        }
}   

     
     public class Tcs1Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related 
      	 tcsPanel.setVisible(true);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
       }
   }
     
   public class capeListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related 
      	 capePanel.setVisible(true);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
       }
   }
     
    
   public class HCL_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related 
    	   HCLPanel.setVisible(true);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
       }
   }
  
   
   public class GEN_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related 
    	   GenPanel.setVisible(true);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
       }
   }
 
   
   public class Niva_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related 
    	   NivaPanel.setVisible(true);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GenPanel.setVisible(false);
      	IndusPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
      	GENfileUploadPanel.setVisible(false);
    
       }
   }
 
   public class Indusind_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related
    	   IndusPanel.setVisible(true);
    	   NivaPanel.setVisible(false);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
       	GENfileUploadPanel.setVisible(false);
      	NivaByIDPanel.setVisible(false);
      	NivafileUploadPanel.setVisible(false);
       
       }
   }
   public class RBL_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related
    	   RBLPanel.setVisible(true);
     	   IndusPanel.setVisible(false);
     	   NivaPanel.setVisible(false);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
       	GENfileUploadPanel.setVisible(false);
      	NivaByIDPanel.setVisible(false);
      	NivafileUploadPanel.setVisible(false);
      	IndusByIDPanel.setVisible(false);
      	IndusfileUploadPanel.setVisible(false);
        
       }
   }
   
   public class Mahindra_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related
    	   Tech_mahindraPanel.setVisible(true);
    	   RBLPanel.setVisible(false);
     	   IndusPanel.setVisible(false);
     	   NivaPanel.setVisible(false);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
       	GENfileUploadPanel.setVisible(false);
      	NivaByIDPanel.setVisible(false);
      	NivafileUploadPanel.setVisible(false);
      	IndusByIDPanel.setVisible(false);
      	IndusfileUploadPanel.setVisible(false);
      	WiproByIDPanel.setVisible(false);
      	WiprofileUploadPanel.setVisible(false);
      	WiproPanel.setVisible(false);
      	Tech_mahindraByIDPanel.setVisible(false);
      	Tech_mahindrafileUploadPanel.setVisible(false);
      		CognizantByIDPanel.setVisible(false);
      	CognizantfileUploadPanel.setVisible(false);
     CognizantPanel.setVisible(false);
     RBLByIDPanel.setVisible(false);
  RBLfileUploadPanel.setVisible(false);
  RBLPanel.setVisible(false);
    
       }
   }
   
   public class Cognizant_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related
    	   CognizantPanel.setVisible(true);
    	   Tech_mahindraPanel.setVisible(false);
    	   RBLPanel.setVisible(false);
     	   IndusPanel.setVisible(false);
     	   NivaPanel.setVisible(false);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
       	GENfileUploadPanel.setVisible(false);
      	NivaByIDPanel.setVisible(false);
      	NivafileUploadPanel.setVisible(false);
      	IndusByIDPanel.setVisible(false);
      	IndusfileUploadPanel.setVisible(false);
      	WiproByIDPanel.setVisible(false);
      	WiprofileUploadPanel.setVisible(false);
      	WiproPanel.setVisible(false);
      	Tech_mahindraByIDPanel.setVisible(false);
      	Tech_mahindrafileUploadPanel.setVisible(false);
      	Tech_mahindraPanel.setVisible(false);
        RBLByIDPanel.setVisible(false);
        RBLfileUploadPanel.setVisible(false);
        RBLPanel.setVisible(false);
          
       }
   }
   
   public class Wipro_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related
    	 WiproPanel.setVisible(true);
     	   CognizantPanel.setVisible(false);
    	   Tech_mahindraPanel.setVisible(false);
    	   RBLPanel.setVisible(false);
     	   IndusPanel.setVisible(false);
     	   NivaPanel.setVisible(false);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
       	GENfileUploadPanel.setVisible(false);
      	NivaByIDPanel.setVisible(false);
      	NivafileUploadPanel.setVisible(false);
      	IndusByIDPanel.setVisible(false);
      	IndusfileUploadPanel.setVisible(false);
      	WiproByIDPanel.setVisible(false);
      	WiprofileUploadPanel.setVisible(false);
      	Tech_mahindraByIDPanel.setVisible(false);
      	Tech_mahindrafileUploadPanel.setVisible(false);
      	Tech_mahindraPanel.setVisible(false);
      	CognizantByIDPanel.setVisible(false);
      	CognizantfileUploadPanel.setVisible(false);
     CognizantPanel.setVisible(false);
     RBLByIDPanel.setVisible(false);
     RBLfileUploadPanel.setVisible(false);
     RBLPanel.setVisible(false);
      
       }
   }
   
   public class Accenture_Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           // Show file TCS panel with all TCS Related
    	 WiproPanel.setVisible(false);
    	 AccenturePanel.setVisible(true);
      	 CognizantPanel.setVisible(false);
    	   Tech_mahindraPanel.setVisible(false);
    	   RBLPanel.setVisible(false);
     	   IndusPanel.setVisible(false);
     	   NivaPanel.setVisible(false);
    	   GenPanel.setVisible(false);
    	   HCLPanel.setVisible(false);
    	   capePanel.setVisible(false);
      	 tcspanel1.setVisible(false);
      	 fileUploadPanel.setVisible(false);
      	GENByIDPanel.setVisible(false);
       	GENfileUploadPanel.setVisible(false);
      	NivaByIDPanel.setVisible(false);
      	NivafileUploadPanel.setVisible(false);
      	IndusByIDPanel.setVisible(false);
      	IndusfileUploadPanel.setVisible(false);
      	WiproByIDPanel.setVisible(false);
      	WiprofileUploadPanel.setVisible(false);
      	Tech_mahindraByIDPanel.setVisible(false);
      	Tech_mahindrafileUploadPanel.setVisible(false);
      	Tech_mahindraPanel.setVisible(false);
      	CognizantByIDPanel.setVisible(false);
      	CognizantfileUploadPanel.setVisible(false);
     CognizantPanel.setVisible(false);
     RBLByIDPanel.setVisible(false);
     RBLfileUploadPanel.setVisible(false);
     RBLPanel.setVisible(false);
      
       }
   }
   
   public class TcsSpecficListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file upload panel when TCS button is clicked
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(true);
             
         }
     }
    
     public class ExpidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 fileUploadPanel.setVisible(true);
         ByIDPanel.setVisible(false);
         }
     }
  
     
     public class CapeCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(true);
         CapeByIDPanel.setVisible(false);
         }
     }
  
     public class HCLCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(true);
         HCLByIDPanel.setVisible(false);
         CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         }
     }
  
     
     public class GENCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(true);
         GENByIDPanel.setVisible(false);
        
         }
     }
  
     public class NivaCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(true);
         NivaByIDPanel.setVisible(false);
        
         }
     }
  
     public class IndusCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(true);
         IndusByIDPanel.setVisible(false);
        
         }
     }
  
     public class RBLCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(false);
         IndusByIDPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(true);
         RBLByIDPanel.setVisible(false);
        
         }
     }
  
    
     
     public class Tech_mahindraCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(false);
         IndusByIDPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
         Tech_mahindrafileUploadPanel.setVisible(true);
         Tech_mahindraByIDPanel.setVisible(false);
         Tech_mahindraPanel.setVisible(false);
         RBLPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
        
         }
     }
  
     public class CognizantCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(false);
         IndusByIDPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
         Tech_mahindrafileUploadPanel.setVisible(false);
         Tech_mahindraByIDPanel.setVisible(false);
         Tech_mahindraPanel.setVisible(false);
         CognizantfileUploadPanel.setVisible(true);
         CognizantByIDPanel.setVisible(false);
        CognizantPanel.setVisible(false);
        RBLPanel.setVisible(false);
        RBLfileUploadPanel.setVisible(false);
        RBLByIDPanel.setVisible(false);
       
         }
     }
     
     public class WiproCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(false);
         IndusByIDPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         Tech_mahindrafileUploadPanel.setVisible(false);
         Tech_mahindraByIDPanel.setVisible(false);
         Tech_mahindraPanel.setVisible(false);
         CognizantfileUploadPanel.setVisible(false);
          CognizantByIDPanel.setVisible(false);
        CognizantPanel.setVisible(false);
        WiprofileUploadPanel.setVisible(true);
        WiproByIDPanel.setVisible(false);
        WiproPanel.setVisible(false);
        RBLPanel.setVisible(false);
        RBLfileUploadPanel.setVisible(false);
        RBLByIDPanel.setVisible(false);
       
         }
     }
     
     public class AccentureHRCidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(false);
         IndusByIDPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
         Tech_mahindrafileUploadPanel.setVisible(false);
         Tech_mahindraByIDPanel.setVisible(false);
         Tech_mahindraPanel.setVisible(false);
         CognizantfileUploadPanel.setVisible(false);
         CognizantByIDPanel.setVisible(false);
         CognizantPanel.setVisible(false);
         WiprofileUploadPanel.setVisible(false);
         WiproByIDPanel.setVisible(false);
         WiproPanel.setVisible(false);
         RBLPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
         AccenturefileUploadPanel.setVisible(true);
         AccentureByIDPanel.setVisible(false);
         AccenturePanel.setVisible(false);
      
         }
     }
     
     public class AccentureCandidateidListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
         ByIDPanel.setVisible(false);
         capefileUploadPanel.setVisible(false);
         HCLfileUploadPanel.setVisible(false);
           CapeByIDPanel.setVisible(false);
         HCLByIDPanel.setVisible(false);
         GENfileUploadPanel.setVisible(false);
         GENByIDPanel.setVisible(false);
         NivafileUploadPanel.setVisible(false);
         NivaByIDPanel.setVisible(false);
         IndusfileUploadPanel.setVisible(false);
         IndusByIDPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
         Tech_mahindrafileUploadPanel.setVisible(false);
         Tech_mahindraByIDPanel.setVisible(false);
         Tech_mahindraPanel.setVisible(false);
         CognizantfileUploadPanel.setVisible(false);
         CognizantByIDPanel.setVisible(false);
         CognizantPanel.setVisible(false);
         WiprofileUploadPanel.setVisible(false);
         WiproByIDPanel.setVisible(false);
         WiproPanel.setVisible(false);
         RBLPanel.setVisible(false);
         RBLfileUploadPanel.setVisible(false);
         RBLByIDPanel.setVisible(false);
         AccentureCandidatefileUploadPanel.setVisible(true);
         AccentureByIDPanel.setVisible(false);
         AccenturePanel.setVisible(false);
      
         }
     } 
     
     public class Tcs4Listener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(true);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
             
         }
     }
  
     public class Cam_Tr_idTcsListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
        	 CTfileUploadPanel.setVisible(true);
        	 CTByIdPanel.setVisible(false);	
        	 DtfileUploadPanel.setVisible(false);
         }
     }
  
     public class Direct_Tr_idTcsListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
        	 CTfileUploadPanel.setVisible(false);
        	 CTByIdPanel.setVisible(false);	
        	 DtByIdPanel.setVisible(false);	
        	 DtfileUploadPanel.setVisible(true);
         }
     }
 
     public class Cam_Tr_DateTcsListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
        	 CTByDatePanel.setVisible(true);
        	 CTByIdPanel.setVisible(false);
        	 
         }
     }
  
     public class Direct_Tr_DateTcsListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
        	 CTByDatePanel.setVisible(false);
        	 DtByDatePanel.setVisible(true);
        	 DtByIdPanel.setVisible(false);
         }
     }
    
     public class ExpdateListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 ByexpDatepanel.setVisible(true);
         	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
             
         }
     }
  
    
     public class CapeCandidateDateListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 ByexpDatepanel.setVisible(true);
         	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
             
         }
     }
  
     
     public class Tcs6Listener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 BySpecDatePanel.setVisible(true);
         	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
             
         }
     }
    
     
     public class TcsCampusTraineeListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 CTByIdPanel.setVisible(true);
        	 BySpecDatePanel.setVisible(false);
         	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
         }
     }
   
     
     public class TcsDirectTraineeListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             // Show file TCS panel with all TCS Related 
        	 BySpecDatePanel.setVisible(false);
         	 tcsPanel.setVisible(false);
        	 tcsPanel.setVisible(false);
        	 fileUploadPanel.setVisible(false);
        	 TcsfileUploadPanel.setVisible(false);
        	 ByIDPanel.setVisible(false);
        	 ByIDSpecPanel.setVisible(false);
        	 DtByIdPanel.setVisible(true);
         
         }
     }
     
     public class ExpDateSubmitListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
        	 // Submitting date wise for Experienced candidates
//        	 String[] argument = new String[] {"ishwarya.s@matrixbsindia.com","Aug@2023", ""};
//     		
//        		try {
//        			TCSExp_Datewise.captcha1(argument);
//     		} catch (InterruptedException e1) {
//     			
//     			e1.printStackTrace();
//     		} catch (IOException e1) {
//     			e1.printStackTrace();
//     		}
        				 String[] argument1 = {StringFromdate,Stringtodate}; 
        	
        		 try {
                 	//TcsExperience_candidate.main(argument);
        			 TCS_Experience_DateWise_1.Open_Browser(argument1);
					} catch (InterruptedException | IOException e1) {
					
						e1.printStackTrace();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		
         }
     }
  
     public class SpecDateSubmitListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
        	 // Submitting date wise for Relation specfic  candidates
         	
              	 String[] argument = new String[] {"ishwarya.s@matrixbsindia.com","Aug@2023", ""};
         		
            		try {
            			try {
							TCSspecfic_RBCDateWise.captchaRBCDateWise(argument);
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
         		} catch (InterruptedException e1) {
         			
         			e1.printStackTrace();
         		} catch (IOException e1) {
         			e1.printStackTrace();
         		}
            				 String[] argument1 = {StringFromdateSpec,StringtodateSpec}; 
            	
            		 try {
                     	//TcsExperience_candidate.main(argument);
            			 TCSspecfic_RBCDateWise.RelationRBCDateWise(argument1);
    					} catch (InterruptedException | IOException e1) {
    					
    						e1.printStackTrace();
    					}
            		   
         }
     }
  
     public class CampusDateSubmitListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
        	 // Submitting date wise for Relation specfic  candidates
         	
              	 String[] argument = new String[] {"ishwarya.s@matrixbsindia.com","Lord@2023", ""};
         		
            		try {
            			TCScampusTrianee_id.TcsCTcaptcha1(argument);
         		} catch (InterruptedException e1) {
         			
         			e1.printStackTrace();
         		} catch (IOException e1) {
         			e1.printStackTrace();
         		}
            				 String[] argument1 = {StringFromdatecampus,Stringtodatecampus}; 
            	
            		 try {
                     	//TcsExperience_candidate.main(argument);
            			 TCScampusTrianee_id.TcsCTsample(argument1);
    					} catch (InterruptedException | IOException e1) {
    					
    						e1.printStackTrace();
    					}
            		   
         }
     }
  
     public class DirectDateSubmitListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
        	 // Submitting date wise for Relation specfic  candidates
         	
              	 String[] argument = new String[] {"ishwarya.s@matrixbsindia.com","Lord@2023", ""};
         		
            		try {
            			Direct_Trainee_Datewise.DirectTcsDatewise(argument);
         		} catch (InterruptedException e1) {
         			
         			e1.printStackTrace();
         		} catch (IOException e1) {
         			e1.printStackTrace();
         		}
            				 String[] argument1 = {StringFromdateDirect,StringtodateDirect}; 
            	
            		 try {
                     	//TcsExperience_candidate.main(argument);
            			 Direct_Trainee_Datewise.DirectTcsDatewisemtd(argument1);
    					} catch (InterruptedException | IOException e1) {
    					
    						e1.printStackTrace();
    					}
            		   
         }
     }
  
     public class CapegeminiDateSubmitListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
        	 // Submitting date wise for Relation specfic  candidates
         	
              	 String[] argument = new String[] {"ishwarya.s@matrixbsindia.com","Lord@2023", ""};
         		
            		try {
            			Direct_Trainee_Datewise.DirectTcsDatewise(argument);
         		} catch (InterruptedException e1) {
         			
         			e1.printStackTrace();
         		} catch (IOException e1) {
         			e1.printStackTrace();
         		}
            				 String[] argument1 = {StringFromdateDirect,StringtodateDirect}; 
            	
            		 try {
                     	//TcsExperience_candidate.main(argument);
            			 Direct_Trainee_Datewise.DirectTcsDatewisemtd(argument1);
    					} catch (InterruptedException | IOException e1) {
    					
    						e1.printStackTrace();
    					}
            		   
         }
     }
  
     
     private class BackLoginListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 loginPanel.setVisible(false);
    		 tcspanel1.setVisible(false);
        	 tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	 }
    	 }
  
     private class capeBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
  
     private class HCLBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
  
     private class GENBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	 
    	 }
    	 }
    
     private class NivaBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
  
     private class IndusBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
  

     private class RBLBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
    
     
     private class Tech_mahindraBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
   
     private class CognizantBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
     private class WiproBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
   
     private class AccentureBackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
    	     HCLPanel.setVisible(false);
    	     RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
   
     private class capeBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(true);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }

     private class HCLBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(true);
             HCLByIDPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }


     private class GENBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(true);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
  
     private class NivaBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(true);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
  
     
     private class IndusBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(true);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	 
    	 }
    	 }

     private class RBLBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(false);
             RBLPanel.setVisible(true);
            RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	 
    	 }
    	 }
     

     private class Tech_mahindraBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(false);
             RBLPanel.setVisible(false);
             Tech_mahindraPanel.setVisible(true);
             Tech_mahindraByIDPanel.setVisible(false);
             Tech_mahindrafileUploadPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
 
     
     private class CognizantBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(false);
             RBLPanel.setVisible(false);
             Tech_mahindraPanel.setVisible(false);
             Tech_mahindraByIDPanel.setVisible(false);
             Tech_mahindrafileUploadPanel.setVisible(false);
             CognizantPanel.setVisible(true);
             CognizantByIDPanel.setVisible(false);
             CognizantfileUploadPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
     
     private class WiproBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(false);
             RBLPanel.setVisible(false);
             Tech_mahindraPanel.setVisible(false);
             Tech_mahindraByIDPanel.setVisible(false);
             Tech_mahindrafileUploadPanel.setVisible(false);
             CognizantPanel.setVisible(false);
             CognizantByIDPanel.setVisible(false);
             CognizantfileUploadPanel.setVisible(false);
             WiproPanel.setVisible(true);
             WiproByIDPanel.setVisible(false);
             WiprofileUploadPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	
    	 }
    	 }
     private class AccentureBack1Listener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 tcspanel1.setVisible(false);
    		 loginPanel.setVisible(false);
    		tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
             ByIDPanel.setVisible(false);
             CapeByIDPanel.setVisible(false);
             HCLPanel.setVisible(false);
             HCLByIDPanel.setVisible(false);
             GenPanel.setVisible(false);
             NivaPanel.setVisible(false);
             IndusPanel.setVisible(false);
             RBLPanel.setVisible(false);
             Tech_mahindraPanel.setVisible(false);
             Tech_mahindraByIDPanel.setVisible(false);
             Tech_mahindrafileUploadPanel.setVisible(false);
             CognizantPanel.setVisible(false);
             CognizantByIDPanel.setVisible(false);
             CognizantfileUploadPanel.setVisible(false);
             WiproPanel.setVisible(false);
             WiproByIDPanel.setVisible(false);
             WiprofileUploadPanel.setVisible(false);
             AccenturePanel.setVisible(true);
             AccentureByIDPanel.setVisible(false);
             AccenturefileUploadPanel.setVisible(false);
             AccentureCandidatefileUploadPanel.setVisible(false);
             RBLPanel.setVisible(false);
             RBLfileUploadPanel.setVisible(false);
             RBLByIDPanel.setVisible(false);
         	 
    	 }
    	 }
     
     private class BackListener implements ActionListener {
    	 @Override
    	 public void actionPerformed(ActionEvent e) {
    		 loginPanel.setVisible(false);
    		 tcspanel1.setVisible(true);
        	 tcsPanel.setVisible(false);
             fileUploadPanel.setVisible(false);
    		}
    	 }

   private class BackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(true);
	  		
	  	 }
	  	 }
  
   private class CapeBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(true);
	  	 }
	  	 }

   private class HCLBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(true);
	           HCLfileUploadPanel.setVisible(false);
	  	 }
	  	 }

 
   private class GENBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(true);
	           GENfileUploadPanel.setVisible(false);
	  	 }
	  	 }

   private class NivaBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(true);
	           NivafileUploadPanel.setVisible(false);
	 
	  	 }
	  	 }

   private class IndusBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(true);
	           IndusfileUploadPanel.setVisible(false);
	 
	  	 }
	  	 }

 
   private class RBLBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(false);
	           IndusfileUploadPanel.setVisible(false);
	           RBLByIDPanel.setVisible(true);
	           RBLfileUploadPanel.setVisible(false);
	 
	  	 }
	  	 }

   

   private class Tech_mahindraBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(false);
	           IndusfileUploadPanel.setVisible(false);
	           RBLByIDPanel.setVisible(false);
	           RBLfileUploadPanel.setVisible(false);
	           Tech_mahindraByIDPanel.setVisible(true);
	           Tech_mahindraPanel.setVisible(false);
	           Tech_mahindrafileUploadPanel.setVisible(false);
		          
	  	 }
	  	 }
 
   private class CognizantBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(false);
	           IndusfileUploadPanel.setVisible(false);
	           RBLByIDPanel.setVisible(false);
	           RBLfileUploadPanel.setVisible(false);
	           Tech_mahindraByIDPanel.setVisible(false);
	           Tech_mahindraPanel.setVisible(false);
	           Tech_mahindrafileUploadPanel.setVisible(false);
	           CognizantByIDPanel.setVisible(true);
	           CognizantPanel.setVisible(false);
	           CognizantfileUploadPanel.setVisible(false);
		         
	  	 }
	  	 }

   private class WiproBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(false);
	           IndusfileUploadPanel.setVisible(false);
	           RBLByIDPanel.setVisible(false);
	           RBLfileUploadPanel.setVisible(false);
	           Tech_mahindraByIDPanel.setVisible(false);
	           Tech_mahindraPanel.setVisible(false);
	           Tech_mahindrafileUploadPanel.setVisible(false);
	           CognizantByIDPanel.setVisible(false);
	           CognizantPanel.setVisible(false);
	           CognizantfileUploadPanel.setVisible(false);
		       WiproByIDPanel.setVisible(true);
	           WiproPanel.setVisible(false);
	           WiprofileUploadPanel.setVisible(false);
		      
	  	 }
	  	 }

   private class AccentureBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(false);
	           IndusfileUploadPanel.setVisible(false);
	           RBLByIDPanel.setVisible(false);
	           RBLfileUploadPanel.setVisible(false);
	           Tech_mahindraByIDPanel.setVisible(false);
	           Tech_mahindraPanel.setVisible(false);
	           Tech_mahindrafileUploadPanel.setVisible(false);
	           CognizantByIDPanel.setVisible(false);
	           CognizantPanel.setVisible(false);
	           CognizantfileUploadPanel.setVisible(false);
		       WiproByIDPanel.setVisible(false);
	           WiproPanel.setVisible(false);
	           WiprofileUploadPanel.setVisible(false);
	           AccentureByIDPanel.setVisible(true);
	           AccenturePanel.setVisible(false);
	          AccenturefileUploadPanel.setVisible(false);
		      
	  	 }
	  	 }
 
   private class AccentureCandidateBackIDListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	           fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           capefileUploadPanel.setVisible(false);
	           CapeByIDPanel.setVisible(false);
	           HCLByIDPanel.setVisible(false);
	           HCLfileUploadPanel.setVisible(false);
	           GENByIDPanel.setVisible(false);
	           GENfileUploadPanel.setVisible(false);
	           NivaByIDPanel.setVisible(false);
	           NivafileUploadPanel.setVisible(false);
	           IndusByIDPanel.setVisible(false);
	           IndusfileUploadPanel.setVisible(false);
	           RBLByIDPanel.setVisible(false);
	           RBLfileUploadPanel.setVisible(false);
	           Tech_mahindraByIDPanel.setVisible(false);
	           Tech_mahindraPanel.setVisible(false);
	           Tech_mahindrafileUploadPanel.setVisible(false);
	           CognizantByIDPanel.setVisible(false);
	           CognizantPanel.setVisible(false);
	           CognizantfileUploadPanel.setVisible(false);
		       WiproByIDPanel.setVisible(false);
	           WiproPanel.setVisible(false);
	           WiprofileUploadPanel.setVisible(false);
	           AccentureByIDPanel.setVisible(true);
	           AccenturePanel.setVisible(false);
	          AccenturefileUploadPanel.setVisible(false);
		      
	  	 }
	  	 }
 
   
   private class campusBackListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	  fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           CTByIdPanel.setVisible(true);
	           CTfileUploadPanel.setVisible(false);
	  	 }
	  	 }
 
   private class DirectBackListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	  fileUploadPanel.setVisible(false);
	           ByIDPanel.setVisible(false);
	           CTByIdPanel.setVisible(false);
	           CTfileUploadPanel.setVisible(false);
	           DtByIdPanel.setVisible(true);
	           DtfileUploadPanel.setVisible(false);
	  	 }
	  	 }
   
   
  private class Back2Listener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(true);
	  		
	  	 }
	  	 }

     
   private class Back3Listener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(true);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(false);
	        ByIDPanel.setVisible(false);
		       
	  	 }
	  	 }

   private class Back4Listener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(true);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(false);
	  		
	  	 }
	  	 }

   private class BackExpDateListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	      	ByIDPanel.setVisible(true);
	      	ByIDSpecPanel.setVisible(false);
	        ByexpDatepanel.setVisible(false);
	        BySpecDatePanel.setVisible(false);
		  	 	
	  	 }
	  	 }

   private class BackSpecDateListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(true);
	        ByexpDatepanel.setVisible(false);
	        BySpecDatePanel.setVisible(false);
		  	
	  	 }
	  	 }

   

   private class BackCTListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(true);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(false);
	        ByexpDatepanel.setVisible(false);
	        BySpecDatePanel.setVisible(false);
	        CTfileUploadPanel.setVisible(false);
	        CTByIdPanel.setVisible(false);
	  	 }
	  	 }

   private class BackDTListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(true);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(false);
	        ByexpDatepanel.setVisible(false);
	        BySpecDatePanel.setVisible(false);
	        CTfileUploadPanel.setVisible(false);
	        CTByIdPanel.setVisible(false);
	        DtByIdPanel.setVisible(false);
	  	 }
	  	 }

   private class CamBackListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(false);
	        ByexpDatepanel.setVisible(false);
	        BySpecDatePanel.setVisible(false);
	        CTfileUploadPanel.setVisible(false);
	        CTByIdPanel.setVisible(true);
	        DtByIdPanel.setVisible(false);
	        CTByDatePanel.setVisible(false);
	  	 }
	  	 }
   private class DirBackListener implements ActionListener {
	  	 @Override
	  	 public void actionPerformed(ActionEvent e) {
	  		 loginPanel.setVisible(false);
	  		 tcspanel1.setVisible(false);
	      	 tcsPanel.setVisible(false);
	      	fileUploadPanel.setVisible(false);
	      	TcsfileUploadPanel.setVisible(false);
	        ByIDSpecPanel.setVisible(false);
	        ByexpDatepanel.setVisible(false);
	        BySpecDatePanel.setVisible(false);
	        CTfileUploadPanel.setVisible(false);
	        CTByIdPanel.setVisible(false);
	        DtByIdPanel.setVisible(true);
	        CTByDatePanel.setVisible(false);
	        DtByDatePanel.setVisible(false);
		  	
	  	 }
	  	 }

   public class UploadListener implements ActionListener {
     	
     	public void actionPerformed(ActionEvent e) {
             // Show submit panel when file upload is successful
             JFileChooser fileChooser = new JFileChooser();
             int returnValue = fileChooser.showOpenDialog(null);
             if (returnValue == JFileChooser.APPROVE_OPTION) {
             	 
                 // user selected a file
             	System.out.println("Selected file: " + fileChooser.getSelectedFile());
             	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
             String j = fileChooser.getSelectedFile().toString();
             	
             	File file = fileChooser.getSelectedFile();
                 uploadedfile.setText(file.getAbsolutePath());
       
                 //submitButton.addActionListener(j); 	
                	fileUploadPanel.setVisible(true);
                 //submitPanel.setVisible(true);
                	StringtoPassEXP_ID = fileChooser.getSelectedFile().toString();
                	try {
                		UpdatePropertiesTCS_Experience_id_1.Tcs_Experience_UPDATE(fileChooser.getSelectedFile().toString());
                  	}catch(Exception e1) {
                  		
                  	}
             }
         }
    }
 
   public class capeUploadListener implements ActionListener {
   	
   	public void actionPerformed(ActionEvent e) {
           // Show submit panel when file upload is successful
           JFileChooser fileChooser = new JFileChooser();
           int returnValue = fileChooser.showOpenDialog(null);
           if (returnValue == JFileChooser.APPROVE_OPTION) {
           	 
               // user selected a file
           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
           String j = fileChooser.getSelectedFile().toString();
           	
           	File file = fileChooser.getSelectedFile();
           	capeuploadedfile.setText(file.getAbsolutePath());
     
               //submitButton.addActionListener(j); 	
              	capefileUploadPanel.setVisible(true);
               //submitPanel.setVisible(true);
              	StringtoPassCape = fileChooser.getSelectedFile().toString();
              	try {
             		UpdatePropertiesCapegemini.Capgemini_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              		
              	}
          
           }
       }
  }
   
   public class HCLUploadListener implements ActionListener {
   	
   	public void actionPerformed(ActionEvent e) {
           // Show submit panel when file upload is successful
           JFileChooser fileChooser = new JFileChooser();
           int returnValue = fileChooser.showOpenDialog(null);
           if (returnValue == JFileChooser.APPROVE_OPTION) {
           	 
               // user selected a file
           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
           String j = fileChooser.getSelectedFile().toString();
           	
           	File file = fileChooser.getSelectedFile();
           	HCLuploadedfile.setText(file.getAbsolutePath());
     
               //submitButton.addActionListener(j); 	
              	HCLfileUploadPanel.setVisible(true);
               //submitPanel.setVisible(true);
              	StringtoPassHcl = fileChooser.getSelectedFile().toString();
              	try {
              		UpdatePropertiesHCL.HCL_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              		
              	}
              
          
           }
       }
  }
   
   
   public class GENUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
//	           updateExcelPathInProperties(j);
//	           System.out.println( "newly added; "+  getExcelPathFromProperties());
//	          
	           	File file = fileChooser.getSelectedFile();
	           	GENuploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	GENuploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassgen = fileChooser.getSelectedFile().toString();
	           	try {
	           		UpdatePropertiesGenpact.Genpact_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              	
              	}
	          
	           }
	       }
	  }
	//  
 //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44

   
 //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44
   
   //   
   public class NivaUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Nivauploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Nivauploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassNiva = fileChooser.getSelectedFile().toString();
//	        	StringtoPassHcl = fileChooser.getSelectedFile().toString();
              	try {
              		UpdatePropertiesNiva_Bupa.Niva_BupaUPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              	
              	}
	          
	           }
	       }
	  }

   public class IndusindUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Indusuploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Indusuploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassIndusind = fileChooser.getSelectedFile().toString();
	        	try {
	        		UpdatePropertiesIndusind.Indusind_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              	
              	}
	          
	           }
	       }
	  }

   
   public class RBLUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	RBLuploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	RBLuploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassRBL = fileChooser.getSelectedFile().toString();
	         	try {
              		UpdatePropertiesRBL_bank.RBLBank_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              	
              	}
	          
	           }
	       }
	  }

   public class Tech_mahindraUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Tech_mahindrauploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Tech_mahindrauploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassTech_mahindra = fileChooser.getSelectedFile().toString();
	           	try {
	           		UpdatePropertiesTechMhindra.TechMahindra_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              	
              	}
	          
	           }
	       }
	  }
   
   public class CognizantUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Cognizantuploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Cognizantuploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassCognizant = fileChooser.getSelectedFile().toString();
	           	
	          
	           }
	       }
	  }
   
   public class WiproUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Wiprouploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Wiprouploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassWipro = fileChooser.getSelectedFile().toString();
	           	try {
	           		UpdatePropertiesWipro.Wipro_UPDATE(fileChooser.getSelectedFile().toString());
              	}catch(Exception e1) {
              	}
	          
	           }
	       }
	  } 
   
   public class AccentureUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Accentureuploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Accentureuploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassAccenture = fileChooser.getSelectedFile().toString();
	           	
	          
	           }
	       }
	  } 
   
   public class AccentureCandidateUploadListener implements ActionListener {
	   	
	   	public void actionPerformed(ActionEvent e) {
	           // Show submit panel when file upload is successful
	           JFileChooser fileChooser = new JFileChooser();
	           int returnValue = fileChooser.showOpenDialog(null);
	           if (returnValue == JFileChooser.APPROVE_OPTION) {
	           	 
	               // user selected a file
	           	System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
	           String j = fileChooser.getSelectedFile().toString();
	           	
	           	File file = fileChooser.getSelectedFile();
	           	Accentureuploadedfile.setText(file.getAbsolutePath());
	     
	               //submitButton.addActionListener(j); 	
	           	Accentureuploadedfile.setVisible(true);
	               //submitPanel.setVisible(true);
	           	StringtoPassAccenture = fileChooser.getSelectedFile().toString();
	           	
	          
	           }
	       }
	  } 
   
   public class UploadListener1 implements ActionListener {
     	
     	public void actionPerformed(ActionEvent e) {
             // Show submit panel when file upload is successful
             JFileChooser fileChooser1 = new JFileChooser();
             int returnValue = fileChooser1.showOpenDialog(null);
             if (returnValue == JFileChooser.APPROVE_OPTION) {
             	 
                 // user selected a file
             	System.out.println("Selected file: " + fileChooser1.getSelectedFile());
             	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
             String j = fileChooser1.getSelectedFile().toString();
             	
             	File file1 = fileChooser1.getSelectedFile();
                 uploadedfile1.setText(file1.getAbsolutePath());
       
                 //submitButton.addActionListener(j); 	
                	TcsfileUploadPanel.setVisible(true);
                 //submitPanel.setVisible(true);
             	StringtoPassSpecfic_ID = fileChooser1.getSelectedFile().toString();
             	try {
             		UpdatePropertiesTCS_Specficrelation_id_1.Tcs_Specficrelation_UPDATE(fileChooser1.getSelectedFile().toString());
              	}catch(Exception e1) {
              	}
            
             }
         }
    }
    
public class UploadListenercampus implements ActionListener {
     	
     	public void actionPerformed(ActionEvent e) {
             // Show submit panel when file upload is successful
             JFileChooser fileChooser1 = new JFileChooser();
             int returnValue = fileChooser1.showOpenDialog(null);
             if (returnValue == JFileChooser.APPROVE_OPTION) {
             	 
                 // user selected a file
             	System.out.println("Selected file: " + fileChooser1.getSelectedFile());
             	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
             String j = fileChooser1.getSelectedFile().toString();
             	
             	File file1 = fileChooser1.getSelectedFile();
                 CTuploadedfile.setText(file1.getAbsolutePath());
       
                 //submitButton.addActionListener(j); 	
               

             	CTfileUploadPanel.setVisible(true);
                 //submitPanel.setVisible(true);
             	StringtoPass1 = fileChooser1.getSelectedFile().toString();
             	
            
             }
         }
    }
public class UploadListenerDirect implements ActionListener {
 	
 	public void actionPerformed(ActionEvent e) {
         // Show submit panel when file upload is successful
         JFileChooser fileChooser1 = new JFileChooser();
         int returnValue = fileChooser1.showOpenDialog(null);
         if (returnValue == JFileChooser.APPROVE_OPTION) {
         	 
             // user selected a file
         	System.out.println("Selected file: " + fileChooser1.getSelectedFile());
         	//System.out.println("Selected file: " + fileChooser.getSelectedFile());
         String j = fileChooser1.getSelectedFile().toString();
         	
         	File file1 = fileChooser1.getSelectedFile();
             DTuploadedfile.setText(file1.getAbsolutePath());
   
             //submitButton.addActionListener(j); 	
           

         	DtfileUploadPanel.setVisible(true);
             //submitPanel.setVisible(true);
         	StringtoPass2 = fileChooser1.getSelectedFile().toString();
         	
        
         }
     }
} 
    
    
    public class submitListener implements ActionListener {
       	
    	       	public void actionPerformed(ActionEvent e) {
//      		String[] argument = new String[] {"ishwarya.s@matrixbsindia.com","Oct@2023"};
    		
       		try {
       			TCS_Experience_id_1.Open_Browser();
    		} catch (InterruptedException e1) {
    			
    			e1.printStackTrace();
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       			
       		//************************
//       	 try {
//             // Open the Excel file
//             
//       	  File file1 = new File(StringtoPass);
//       	FileInputStream fis = new FileInputStream(file1);
//        Workbook workbook = new XSSFWorkbook(fis);
//        DataFormatter dataFormatter = new DataFormatter();
//
//        // Get the first sheet in the Excel file
//        Sheet sheet = workbook.getSheetAt(0);
//
//        // Initialize strings to store values from the first and second columns
//       
//       
//        StringBuilder column1Data = new StringBuilder();
//        StringBuilder column2Data = new StringBuilder();
////        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
////            Row row = sheet.getRow(rowIndex);
//////
////            for (int rowIndex1 = 1; rowIndex1 <= sheet.getLastRowNum(); rowIndex1++) {
////                Row row1 = sheet.getRow(rowIndex1);
////    
////          for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
////        	
////        	  
////        	  for (int cellIndex1 = 1; cellIndex1 < row1.getLastCellNum(); cellIndex1++) {
//////        	      
////        	  
////        	  //                  Cell cell = row.getCell(cellIndex);
////            Cell cell1 = row.getCell(cellIndex); // First column
////            Cell cell2 = row1.getCell(cellIndex1); // Second column
////            if (cell1 != null) {
////             String cellValue1 = dataFormatter.formatCellValue(cell1);
////             column1Data.append(cellValue1).append("\n");
////         }
////         
////         if (cell2 != null) {
////             String cellValue2 = dataFormatter.formatCellValue(cell2);
////             column2Data.append(cellValue2).append("\n");
////         }
////      
////         String[] argument1 = new String[] {column1Data.toString(),column2Data.toString()}; 
////       try {
////          	//TcsExperience_candidate.main(argument);
////          	TcsExpbackup_candidate.sample(argument1);
////           column1Data.setLength(0); // Clear the content of column1Data
////           column2Data.setLength(0); // Clear the content of column2Data
////
////       } catch (InterruptedException | IOException e1) {
////			
////				e1.printStackTrace();
////			}
////          }
//        // Flag to skip the first row
//        boolean skipFirstRow = true;
//
//        // Iterate through rows and read values from the first and second columns
////        for (Row row1 : sheet) {
//        	 for (Row row : sheet) {
//                 if (skipFirstRow) {
//                     skipFirstRow = false;
//                     continue; // Skip the first row
//                 }
//
//        	
//        	Cell cell1 = row.getCell(1); // First column
//            Cell cell2 = row.getCell(0); // Second column
//               if (cell1 != null) {
//                String cellValue1 = dataFormatter.formatCellValue(cell1);
//                column1Data.append(cellValue1).append("\n");
//            }
//            
//            if (cell2 != null) {
//                String cellValue2 = dataFormatter.formatCellValue(cell2);
//                column2Data.append(cellValue2).append("\n");
//            }
//         
//            String[] argument1 = new String[] {column1Data.toString(),column2Data.toString()}; 
//            try {
//               	//TcsExperience_candidate.main(argument);
//               	TcsExpbackup_candidate.sample(argument1);
//                column1Data.setLength(0); // Clear the content of column1Data
//                column2Data.setLength(0); // Clear the content of column2Data
//	
//            } catch (InterruptedException | IOException e1) {
//				
//					e1.printStackTrace();
//				}
// 
//        }
////        }
////        }
////     }                        
////                         // Create a FileInputStream object to read the file
////                         FileInputStream fis = new FileInputStream(file1);
////
////                         // Create a Workbook object that represents the Excel file
////                         Workbook workbook = WorkbookFactory.create(fis);
////
////                         // Get the first sheet in the Excel file
////                         Sheet sheet = workbook.getSheetAt(0);
////                         
////                         int count = 0;
////                         String countString = "";
////                         // Iterate through each row in the sheet
////                         for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
////                             Row row = sheet.getRow(rowIndex);
////
////                           
////                         for (Row row : sheet) {
////                             // Iterate through each cell in the row
////                             //for (Cell cell : row) 
////                             for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
////                                 Cell cell = row.getCell(cellIndex);
////                                 DataFormatter formatter = new DataFormatter();
////                
////                            	 count = count+1;
////                            	 countString = count+"";
////                            	 // Print the value of each cell
////                                 System.out.print(formatter.formatCellValue(cell) + "\t");
////                                 
////                             	System.out.println("**********************");
////                       		// Handle the scraping button click event
////                           // Add your scraping logic here
////                             	System.out.println("################################"+countString);
////                             	System.out.println(formatter.formatCellValue(cell) +countString);
////                      String jjj = formatter.formatCellValue(cell);
////                             	//implementing id's by argument
////                             	String[] argument1 = new String[] {jjj}; 
////                        
////                        try {
////                        	//TcsExperience_candidate.main(argument);
////                        	TcsExpbackup_candidate.sample(argument1);
////    					} catch (InterruptedException | IOException e1) {
////    					
////    						e1.printStackTrace();
////    					}
////
////                              }
////                             System.out.println();
////                             countString = "";
////                         }     
//
//                         // Close the workbook and the file input stream
//                         workbook.close();
//                         fis.close();
//                        // JFrame scrap = new JFrame 
//                    } catch (IOException e1) {
//                         e1.printStackTrace();
//                     }
//       			
//                	 try {
//                		 TcsExpbackup_candidate.close();
//                		} catch (InterruptedException e1) {
//                		
//                			e1.printStackTrace();
//                		}
       	}
    }
  
 
    public class capefileuploadsubmitListener implements ActionListener {
       	
       	public void actionPerformed(ActionEvent e) {
//		String[] argument = new String[] {"sivaraj.b@matrixbsindia.com","Matex@2022", ""};
	
		try {
			Capgemini_2.beforeTest();
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	} catch (AWTException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			
//	      	try {
//                // JFileChooser fileChooser = null;
//				// Create a File object that represents the Excel file to read
//                 File file1 = new File(StringtoPass);
//                 
//                 // Create a FileInputStream object to read the file
//                 FileInputStream fis = new FileInputStream(file1);
//
//                 // Create a Workbook object that represents the Excel file
//                 Workbook workbook = WorkbookFactory.create(fis);
//
//                 // Get the first sheet in the Excel file
//                 Sheet sheet = workbook.getSheetAt(0);
//                 
//                 int count = 0;
//                 String countString = "";
//                 // Iterate through each row in the sheet
//                 for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//                     Row row = sheet.getRow(rowIndex);
//
//                   
//                 //for (Row row : sheet) {
//                     // Iterate through each cell in the row
//                     //for (Cell cell : row) 
//                     for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//                         Cell cell = row.getCell(cellIndex);
//                         DataFormatter formatter = new DataFormatter();
//        
//                    	 count = count+1;
//                    	 countString = count+"";
//                    	 // Print the value of each cell
//                         //System.out.print(cell.toString() + "\t");
//                    	 System.out.print(formatter.formatCellValue(cell) + "\t");
//                         
//                     	System.out.println("**********************");
//               		// Handle the scraping button click event
//                   // Add your scraping logic here
//                     	System.out.println("################################"+countString);
//                     	System.out.println(formatter.formatCellValue(cell) +countString);
//              //implementing id's by argument
//                     	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
//                
//                try {
//                	//TcsExperience_candidate.main(argument);
//                	Capgemini_scraping.Cape_gemini(argument1);
//				} catch (InterruptedException | IOException e1) {
//				
//					e1.printStackTrace();
//				}
//
//                      }
//                     System.out.println();
//                     countString = "";
//                 }     
//
//                 // Close the workbook and the file input stream
//                 workbook.close();
//                 fis.close();
//                // JFrame scrap = new JFrame 
//            } catch (IOException e1) {
//                 e1.printStackTrace();
//             }
			
//        	 try {
//        		 TcsExpbackup_candidate.close();
//        		} catch (InterruptedException e1) {
//        			// TODO Auto-generated catch block
//        			e1.printStackTrace();
//        		}
	}
}

    
 public class HCLfileuploadsubmitListener implements ActionListener {
       	
       	public void actionPerformed(ActionEvent e) {
//		String[] argument = new String[] {"TPA090","Matrix@123",""};
	
		try {
			HCL_2.openBrowser();
	} catch (IOException e1) {
		e1.printStackTrace();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (AWTException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			
//	      	try {
//                // JFileChooser fileChooser = null;
//				// Create a File object that represents the Excel file to read
//                 File file1 = new File(StringtoPassHcl);
//                 System.out.println(StringtoPass+"The value for HCLLLLLLLLL");
//                 // Create a FileInputStream object to read the file
//                 FileInputStream fis = new FileInputStream(file1);
//
//                 // Create a Workbook object that represents the Excel file
//                 Workbook workbook = WorkbookFactory.create(fis);
//
//                 // Get the first sheet in the Excel file
//                 Sheet sheet = workbook.getSheetAt(0);
//                 
//                 int count = 0;
//                 String countString = "";
//                 // Iterate through each row in the sheet
//                 for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//                     Row row = sheet.getRow(rowIndex);
//
//                   
//                 //for (Row row : sheet) {
//                     // Iterate through each cell in the row
//                     //for (Cell cell : row) 
//                     for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//                         Cell cell = row.getCell(cellIndex);
//                         DataFormatter formatter = new DataFormatter();
//        
//                    	 count = count+1;
//                    	 countString = count+"";
//                    	 // Print the value of each cell
//                         //System.out.print(cell.toString() + "\t");
//                    	 System.out.print(formatter.formatCellValue(cell) + "\t");
//                         
//                     	System.out.println("**********************");
//               		// Handle the scraping button click event
//                   // Add your scraping logic here
//                     	System.out.println("################################"+countString);
//                     	System.out.println(formatter.formatCellValue(cell) +countString);
////              //implementing id's by argument
////                     	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
////                
////                try {
////                	//TcsExperience_candidate.main(argument);
////                	HCL.HCL1(argument1);
////				} catch (InterruptedException | IOException e1) {
////				
////					e1.printStackTrace();
////					
////					}
//
//                      }
//                     System.out.println();
//                     countString = "";
//                 }     
//
//                 // Close the workbook and the file input stream
//                 workbook.close();
//                 fis.close();
//                // JFrame scrap = new JFrame 
//            } catch (IOException e1) {
//                 e1.printStackTrace();
//             }
			
        	
	}
}

    
 public class GENfileuploadsubmitListener implements ActionListener {
 	
 	public void actionPerformed(ActionEvent e) {
//		String[] argument = new String[] {"vadlasreenivasa.c@matrixbsindia.com","Matrix@2023"};
	
		try {
//			GenPact.GenPact_id(argument);
			Genpact_2.GenPact_id();
		} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	} catch (EncryptedDocumentException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvalidFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (AWTException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			
//	      	try {
//          // JFileChooser fileChooser = null;
//				// Create a File object that represents the Excel file to read
//           File file1 = new File(StringtoPassgen);
//           
//           // Create a FileInputStream object to read the file
//           FileInputStream fis = new FileInputStream(file1);
//
//           // Create a Workbook object that represents the Excel file
//           Workbook workbook = WorkbookFactory.create(fis);
//
//           // Get the first sheet in the Excel file
//           Sheet sheet = workbook.getSheetAt(0);
//           
//           int count = 0;
//           String countString = "";
//           // Iterate through each row in the sheet
//           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//               Row row = sheet.getRow(rowIndex);
//       //for (Row row : sheet) {
//               // Iterate through each cell in the row
//               //for (Cell cell : row) 
//               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//                   Cell cell = row.getCell(cellIndex);
//                   DataFormatter formatter = new DataFormatter();
//  
//              	 count = count+1;
//              	 countString = count+"";
//              	 // Print the value of each cell
//                   //System.out.print(cell.toString() + "\t");
//              	 System.out.print(formatter.formatCellValue(cell) + "\t");
//                   
//               	System.out.println("**********************");
//         		// Handle the scraping button click event
//             // Add your scraping logic here
//               	System.out.println("################################"+countString);
//               	System.out.println(formatter.formatCellValue(cell) +countString);
//        //implementing id's by argument
//               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
//          
//          try {
//          	//TcsExperience_candidate.main(argument);
//        	  Genpact_2.genpact1();
//				} catch (InterruptedException | IOException e1) {
//				
//					e1.printStackTrace();
//				} catch (EncryptedDocumentException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (InvalidFormatException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (AWTException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//                }
//               System.out.println();
//               countString = "";
//           }     
//
//           // Close the workbook and the file input stream
//           workbook.close();
//           fis.close();
//          // JFrame scrap = new JFrame 
//      } catch (IOException e1) {
//           e1.printStackTrace();
//       }
//			
//  	 try {
//  		 TcsExpbackup_candidate.close();
//  		} catch (InterruptedException e1) {
//  			// TODO Auto-generated catch block
//  			e1.printStackTrace();
//  		}
	}
}


 public class NivafileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
//			String[] argument = new String[] {"ebgc_maxbupa@matrixbsindia.com","1234567890"};
		
	 //calling  method for the niva_bupa
	 		try {
				Niva_bupa0.openBrowser();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	  	/* try {
	  		// TcsExpbackup_candidate.close();
	  		} catch (InterruptedException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}  */
		}
	}


 public class IndusfileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
			String[] argument = new String[] {"Matrix5","Matrix5@123",""};
//		
			try {
//				String[] argument = null;
				Indusind_2.openBrowser(argument);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
//		      	try {
//	          // JFileChooser fileChooser = null;
//					// Create a File object that represents the Excel file to read
//	           File file1 = new File(StringtoPassIndusind);
//	           
//	           // Create a FileInputStream object to read the file
//	           FileInputStream fis = new FileInputStream(file1);
//
//	           // Create a Workbook object that represents the Excel file
//	           Workbook workbook = WorkbookFactory.create(fis);
//
//	           // Get the first sheet in the Excel file
//	           Sheet sheet = workbook.getSheetAt(0);
//	           
//	           int count = 0;
//	           String countString = "";
//	           // Iterate through each row in the sheet
//	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//	               Row row = sheet.getRow(rowIndex);
//
//	             
//	           //for (Row row : sheet) {
//	               // Iterate through each cell in the row
//	               //for (Cell cell : row) 
//	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//	                   Cell cell = row.getCell(cellIndex);
//	                   DataFormatter formatter = new DataFormatter();
//	   
//	              	 count = count+1;
//	              	 countString = count+"";
//	              	 // Print the value of each cell
//	                   //System.out.print(cell.toString() + "\t");
//	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
//	                   
//	               	System.out.println("**********************");
//	         		// Handle the scraping button click event
//	             // Add your scraping logic here
//	               	System.out.println("################################"+countString);
//	               	System.out.println(formatter.formatCellValue(cell) +countString);
//	        //implementing id's by argument
//	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
//	          
//	          try {
//	          	//TcsExperience_candidate.main(argument);
//	        	  Indusind.Indusind2(argument1);
//					} catch (InterruptedException | IOException e1) {
//					
//						e1.printStackTrace();
//					}
//
//	                }
//	               System.out.println();
//	               countString = "";
//	           }     
//
//	           // Close the workbook and the file input stream
//	           workbook.close();
//	           fis.close();
//	          // JFrame scrap = new JFrame 
//	      } catch (IOException e1) {
//	           e1.printStackTrace();
//	       }
				
	  	
		}
	}
 
 public class RBLfileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
//			String[] argument = new String[] {"BGV_Vendor1","Taleo@1234",""};
		
			try {
				RBL_Bank2.openBrowser();
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
//		      	try {
//	          // JFileChooser fileChooser = null;
//					// Create a File object that represents the Excel file to read
//	           File file1 = new File(StringtoPassRBL);
//	           
//	           // Create a FileInputStream object to read the file
//	           FileInputStream fis = new FileInputStream(file1);
//
//	           // Create a Workbook object that represents the Excel file
//	           Workbook workbook = WorkbookFactory.create(fis);
//
//	           // Get the first sheet in the Excel file
//	           Sheet sheet = workbook.getSheetAt(0);
//	           
//	           int count = 0;
//	           String countString = "";
//	           // Iterate through each row in the sheet
//	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//	               Row row = sheet.getRow(rowIndex);
//
//	             
//	           //for (Row row : sheet) {
//	               // Iterate through each cell in the row
//	               //for (Cell cell : row) 
//	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//	                   Cell cell = row.getCell(cellIndex);
//	                   DataFormatter formatter = new DataFormatter();
//	   
//	              	 count = count+1;
//	              	 countString = count+"";
//	              	 // Print the value of each cell
//	                   //System.out.print(cell.toString() + "\t");
//	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
//	                   
//	               	System.out.println("**********************");
//	         		// Handle the scraping button click event
//	             // Add your scraping logic here
//	               	System.out.println("################################"+countString);
//	               	System.out.println(formatter.formatCellValue(cell) +countString);
//	        //implementing id's by argument
//	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
//	          
//	          try {
//	          	//TcsExperience_candidate.main(argument);
//	        	  RBLBank.RBL2(argument1);
//					
//	          
//	          } catch (InterruptedException | IOException e1) {
//					
//						e1.printStackTrace();
//					}
//
//	                }
//	               System.out.println();
//	               countString = "";
//	           }     
//
//	           // Close the workbook and the file input stream
//	           workbook.close();
//	           fis.close();
//	          // JFrame scrap = new JFrame 
//	      } catch (IOException e1) {
//	           e1.printStackTrace();
//	       }
				
	  	
		}
	}

 
 public class Tech_mahindrafileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
		
//	 		  String Tech_mahindra_username = Tech_mahindrausername.getText();
//	 	        String Tech_mahindra_password = new String(( Tech_mahindrapassword).getText());
//
//	 	        System.out.println("Username: " + Tech_mahindra_username);
//	 	        System.out.println("Password: " + Tech_mahindra_password);
//	 		
//	 		String[] argument = new String[] {Tech_mahindra_username,Tech_mahindra_password,""};
//		System.out.println(Tech_mahindra_username);
	
	 		try {
	 			TechMahindra_2.openBrowser();
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
//		      	try {
//	          // JFileChooser fileChooser = null;
//					// Create a File object that represents the Excel file to read
//	           File file1 = new File(StringtoPassTech_mahindra);
//	           
//	           // Create a FileInputStream object to read the file
//	           FileInputStream fis = new FileInputStream(file1);
//
//	           // Create a Workbook object that represents the Excel file
//	           Workbook workbook = WorkbookFactory.create(fis);
//
//	           // Get the first sheet in the Excel file
//	           Sheet sheet = workbook.getSheetAt(0);
//	           
//	           int count = 0;
//	           String countString = "";
//	           // Iterate through each row in the sheet
//	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//	               Row row = sheet.getRow(rowIndex);
//
//	             
//	           //for (Row row : sheet) {
//	               // Iterate through each cell in the row
//	               //for (Cell cell : row) 
//	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//	                   Cell cell = row.getCell(cellIndex);
//	                   DataFormatter formatter = new DataFormatter();
//	   
//	              	 count = count+1;
//	              	 countString = count+"";
//	              	 // Print the value of each cell
//	                   //System.out.print(cell.toString() + "\t");
//	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
//	                   
//	               	System.out.println("**********************");
//	         		// Handle the scraping button click event
//	             // Add your scraping logic here
//	               	System.out.println("################################"+countString);
//	               	System.out.println(formatter.formatCellValue(cell) +countString);
//	        //implementing id's by argument
//	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
//	          
//	          try {
//	          	//TcsExperience_candidate.main(argument);
//	        	  TechMahindra.TechMahindra2(argument1);
//					
//	          
//	          } catch (InterruptedException | IOException e1) {
//					
//						e1.printStackTrace();
//					}
//
//	                }
//	               System.out.println();
//	               countString = "";
//	           }     
//
//	           // Close the workbook and the file input stream
//	           workbook.close();
//	           fis.close();
//	          // JFrame scrap = new JFrame 
//	      } catch (IOException e1) {
//	           e1.printStackTrace();
//	       }
				
	  	
		}
	}

 public class CognizantfileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
		
	 		  String Cognizant_username = Cognizantusername.getText();
	 	        //String Cognizant_password = new String(( Cognizantpassword).getText());

	 	        //System.out.println("Username: " + Cognizant_username);
	 	        //System.out.println("Password: " + Cognizant_password);
	 		
	 		String[] argument = new String[] {Cognizant_username,""};
		System.out.println(Cognizant_username);
			try {
				Cognizant.Cognizant1(argument);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		      	try {
	          // JFileChooser fileChooser = null;
					// Create a File object that represents the Excel file to read
	           File file1 = new File(StringtoPassCognizant);
	           
	           // Create a FileInputStream object to read the file
	           FileInputStream fis = new FileInputStream(file1);

	           // Create a Workbook object that represents the Excel file
	           Workbook workbook = WorkbookFactory.create(fis);

	           // Get the first sheet in the Excel file
	           Sheet sheet = workbook.getSheetAt(0);
	           
	           int count = 0;
	           String countString = "";
	           // Iterate through each row in the sheet
	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	               Row row = sheet.getRow(rowIndex);

	             
	           //for (Row row : sheet) {
	               // Iterate through each cell in the row
	               //for (Cell cell : row) 
	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
	                   Cell cell = row.getCell(cellIndex);
	                   DataFormatter formatter = new DataFormatter();
	   
	              	 count = count+1;
	              	 countString = count+"";
	              	 // Print the value of each cell
	                   //System.out.print(cell.toString() + "\t");
	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
	                   
	               	System.out.println("**********************");
	         		// Handle the scraping button click event
	             // Add your scraping logic here
	               	System.out.println("################################"+countString);
	               	System.out.println(formatter.formatCellValue(cell) +countString);
	        //implementing id's by argument
	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
	          
	          try {
	          	//TcsExperience_candidate.main(argument);
	        	  Cognizant.Cognizant2(argument1);
					
	          
	          } catch (InterruptedException | IOException e1) {
					
						e1.printStackTrace();
					}

	                }
	               System.out.println();
	               countString = "";
	           }     

	           // Close the workbook and the file input stream
	           workbook.close();
	           fis.close();
	          // JFrame scrap = new JFrame 
	      } catch (IOException e1) {
	           e1.printStackTrace();
	       }
				
	  	
		}
	}
 
 
 public class WiprofileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
//			String[] argument = new String[] {"Sivaraj.b@matrixbsindia.com","Wipro@2022",""};
		
			try {
				Wipro_2.open_Browser();
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
//		      	try {
//	          // JFileChooser fileChooser = null;
//					// Create a File object that represents the Excel file to read
//	           File file1 = new File(StringtoPassWipro);
//	           
//	           // Create a FileInputStream object to read the file
//	           FileInputStream fis = new FileInputStream(file1);
//
//	           // Create a Workbook object that represents the Excel file
//	           Workbook workbook = WorkbookFactory.create(fis);
//
//	           // Get the first sheet in the Excel file
//	           Sheet sheet = workbook.getSheetAt(0);
//	           
//	           int count = 0;
//	           String countString = "";
//	           // Iterate through each row in the sheet
//	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//	               Row row = sheet.getRow(rowIndex);
//
//	             
//	           //for (Row row : sheet) {
//	               // Iterate through each cell in the row
//	               //for (Cell cell : row) 
//	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//	                   Cell cell = row.getCell(cellIndex);
//	                   DataFormatter formatter = new DataFormatter();
//	   
//	              	 count = count+1;
//	              	 countString = count+"";
//	              	 // Print the value of each cell
//	                   //System.out.print(cell.toString() + "\t");
//	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
//	                   
//	               	System.out.println("**********************");
//	         		// Handle the scraping button click event
//	             // Add your scraping logic here
//	               	System.out.println("################################"+countString);
//	               	System.out.println(formatter.formatCellValue(cell) +countString);
//	        //implementing id's by argument
//	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
//	          
//	          try {
//	          	//TcsExperience_candidate.main(argument);
//	        	  WiproDop.Wipro2(argument1);
//					
//	          
//	          } catch (InterruptedException | IOException e1) {
//					
//						e1.printStackTrace();
//					}
//
//	                }
//	               System.out.println();
//	               countString = "";
//	           }     
//
//	           // Close the workbook and the file input stream
//	           workbook.close();
//	           fis.close();
//	          // JFrame scrap = new JFrame 
//	      } catch (IOException e1) {
//	           e1.printStackTrace();
//	       }
				
	  	
		}
	}
 
 
 public class AccenturefileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
			String[] argument = new String[] {"ramachandran.rm@accenture.com","Rsubashini@20",""};
		
			try {
				AccentureHRC.Accenture1(argument);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		      	try {
	          // JFileChooser fileChooser = null;
					// Create a File object that represents the Excel file to read
	           File file1 = new File(StringtoPassAccenture);
	           
	           // Create a FileInputStream object to read the file
	           FileInputStream fis = new FileInputStream(file1);

	           // Create a Workbook object that represents the Excel file
	           Workbook workbook = WorkbookFactory.create(fis);

	           // Get the first sheet in the Excel file
	           Sheet sheet = workbook.getSheetAt(0);
	           
	           int count = 0;
	           String countString = "";
	           // Iterate through each row in the sheet
	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	               Row row = sheet.getRow(rowIndex);

	             
	           //for (Row row : sheet) {
	               // Iterate through each cell in the row
	               //for (Cell cell : row) 
	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
	                   Cell cell = row.getCell(cellIndex);
	                   DataFormatter formatter = new DataFormatter();
	   
	              	 count = count+1;
	              	 countString = count+"";
	              	 // Print the value of each cell
	                   //System.out.print(cell.toString() + "\t");
	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
	                   
	               	System.out.println("**********************");
	         		// Handle the scraping button click event
	             // Add your scraping logic here
	               	System.out.println("################################"+countString);
	               	System.out.println(formatter.formatCellValue(cell) +countString);
	        //implementing id's by argument
	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
	          
	          try {
	          	//TcsExperience_candidate.main(argument);
	        	  AccentureHRC.Accenture2(argument1);
					
	          
	          } catch (InterruptedException | IOException e1) {
					
						e1.printStackTrace();
					}

	                }
	               System.out.println();
	               countString = "";
	           }     

	           // Close the workbook and the file input stream
	           workbook.close();
	           fis.close();
	          // JFrame scrap = new JFrame 
	      } catch (IOException e1) {
	           e1.printStackTrace();
	       }
				
	  	
		}
	}

 public class AccentureCandidatefileuploadsubmitListener implements ActionListener {
	 	
	 	public void actionPerformed(ActionEvent e) {
			String[] argument = new String[] {"ramachandran.rm@accenture.com","Rsubashini@20",""};
		
			try {
				Accenturecandidate.Accenture1(argument);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		      	try {
	          // JFileChooser fileChooser = null;
					// Create a File object that represents the Excel file to read
	           File file1 = new File(StringtoPassAccenture);
	           
	           // Create a FileInputStream object to read the file
	           FileInputStream fis = new FileInputStream(file1);

	           // Create a Workbook object that represents the Excel file
	           Workbook workbook = WorkbookFactory.create(fis);

	           // Get the first sheet in the Excel file
	           Sheet sheet = workbook.getSheetAt(0);
	           
	           int count = 0;
	           String countString = "";
	           // Iterate through each row in the sheet
	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	               Row row = sheet.getRow(rowIndex);

	             
	           //for (Row row : sheet) {
	               // Iterate through each cell in the row
	               //for (Cell cell : row) 
	               for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
	                   Cell cell = row.getCell(cellIndex);
	                   DataFormatter formatter = new DataFormatter();
	   
	              	 count = count+1;
	              	 countString = count+"";
	              	 // Print the value of each cell
	                   //System.out.print(cell.toString() + "\t");
	              	 System.out.print(formatter.formatCellValue(cell) + "\t");
	                   
	               	System.out.println("**********************");
	         		// Handle the scraping button click event
	             // Add your scraping logic here
	               	System.out.println("################################"+countString);
	               	System.out.println(formatter.formatCellValue(cell) +countString);
	        //implementing id's by argument
	               	String[] argument1 = new String[] {formatter.formatCellValue(cell)}; 
	          
	          try {
	          	//TcsExperience_candidate.main(argument);
	        	  Accenturecandidate.Accenture2(argument1);
					
	          
	          } catch (InterruptedException | IOException e1) {
					
						e1.printStackTrace();
					}

	                }
	               System.out.println();
	               countString = "";
	           }     

	           // Close the workbook and the file input stream
	           workbook.close();
	           fis.close();
	          // JFrame scrap = new JFrame 
	      } catch (IOException e1) {
	           e1.printStackTrace();
	       }
				
	  	
		}
	}


 
 public class TcssubmitListener1 implements ActionListener {
    	
		public void actionPerformed(ActionEvent e) {
//			 String[] argument1 = new String[] {"V.anandamurugan@matrixbsindia.com","Dec@2023",""};
//        		
       		try {
       			TCS_RelationSpecific_1.Open_Browser( );
    		} catch (InterruptedException e1) {
    			
    			e1.printStackTrace();
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		} catch (AWTException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} 
//          	      	try {
//       		
//
//          	             // Open the Excel file
//          	             
//          	       	  File file1 = new File(StringtoPass);
//          	       	FileInputStream fis = new FileInputStream(file1);
//          	        Workbook workbook = new XSSFWorkbook(fis);
//          	        DataFormatter dataFormatter = new DataFormatter();
//
//          	        // Get the first sheet in the Excel file
//          	        Sheet sheet = workbook.getSheetAt(0);
//
//          	        // Initialize strings to store values from the first and second columns
//          	       
//          	       
//          	        StringBuilder column1Data = new StringBuilder();
//          	        StringBuilder column2Data = new StringBuilder();
////          	 
//          	        // Flag to skip the first row
//          	        boolean skipFirstRow = true;
//
//          	        // Iterate through rows and read values from the first and second columns
////          	        for (Row row1 : sheet) {
//          	        	 for (Row row : sheet) {
//          	                 if (skipFirstRow) {
//          	                     skipFirstRow = false;
//          	                     continue; // Skip the first row
//          	                 }
//
//          	        	
//          	        	Cell cell1 = row.getCell(1); // First column
//          	            Cell cell2 = row.getCell(0); // Second column
//          	               if (cell1 != null) {
//          	                String cellValue1 = dataFormatter.formatCellValue(cell1);
//          	                column1Data.append(cellValue1).append("\n");
//          	            }
//          	            
//          	            if (cell2 != null) {
//          	                String cellValue2 = dataFormatter.formatCellValue(cell2);
//          	                column2Data.append(cellValue2).append("\n");
//          	            }
//          	         
//          	            String[] argument2 = new String[] {column1Data.toString(),column2Data.toString()}; 
//          	            try {
//          	               	//TcsExperience_candidate.main(argument);
//          	         	 TCSspecfic_RBCBackup.RelationBC(argument2);
////                     	
//          	                column1Data.setLength(0); // Clear the content of column1Data
//          	                column2Data.setLength(0); // Clear the content of column2Data
//          		
//          	            } catch (InterruptedException | IOException e1) {
//          					
//          						e1.printStackTrace();
//          					}
//          	 
//          	        }
//
//          	                         workbook.close();
//          	                         fis.close();
//          	                        // JFrame scrap = new JFrame 
//          	                    
//          	      		
////                     // JFileChooser fileChooser = null;
//// 					// Create a File object that represents the Excel file to read
////                      File file2 = new File(StringtoPass);
////                      
////                      // Create a FileInputStream object to read the file
////                      FileInputStream fis = new FileInputStream(file2);
////
////                      // Create a Workbook object that represents the Excel file
////                      Workbook workbook = WorkbookFactory.create(fis);
////
////                      // Get the first sheet in the Excel file
////                      Sheet sheet = workbook.getSheetAt(0);
////                      
////                      int count = 0;
////                      String countString = "";
////                      // Iterate through each row in the sheet
////                      for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
////                          Row row = sheet.getRow(rowIndex);
////
////                        
////                      //for (Row row : sheet) {
////                          // Iterate through each cell in the row
////                          //for (Cell cell : row) 
////                          for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
////                              Cell cell = row.getCell(cellIndex);
////                              DataFormatter formatter = new DataFormatter();
////                             
////                         	 count = count+1;
////                         	 countString = count+"";
////                         	 // Print the value of each cell
////                              //System.out.print(cell.toString() + "\t");
////                         	 System.out.print(formatter.formatCellValue(cell) + "\t");
////                              
////                          	System.out.println("**********************");
////                    		// Handle the scraping button click event
////                        // Add your scraping logic here
////                          	System.out.println("################################"+countString);
////                          	System.out.println(formatter.formatCellValue(cell) +countString);
////                   //implementing id's by argument
////                     	  
////                           	String[] argument2 = new String[] {formatter.formatCellValue(cell)}; 
////                          
////                       
////                     try {
////                     	//TcsExperience_candidate.main(argument);
////                    	 TCSspecfic_RBCBackup.RelationBC(argument2);
////                    	
////                     
////                     } catch (Exception e1) {
//// 					
//// 						e1.printStackTrace();
//// 					}
////
////                           }
////                          System.out.println();
////                          countString = "";
////                      }     
////
////                      // Close the workbook and the file input stream
////                      workbook.close();
////                      fis.close();
////                    
////                      // JFrame scrap = new JFrame 
////                 } 
//          	      	}catch (IOException e1) {
//                      e1.printStackTrace();
//                  }
    			
          	     	
           
    	}

 
 }  
 public class CampusTraineesubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] TcsCTcaptcha1 = new String[] {"ishwarya.s@matrixbsindia.com","Lord@2023", ""};
	 		
    		try {
    			TCScampusTrianee_id.TcsCTcaptcha1(TcsCTcaptcha1);
 		} catch (InterruptedException e1) {
 			
 			e1.printStackTrace();
 		} catch (IOException e1) {
 			e1.printStackTrace();
 		} 
    			
    	      	try {
                     // JFileChooser fileChooser = null;
 					// Create a File object that represents the Excel file to read
                      File file1 = new File(StringtoPass1);
                      
                      // Create a FileInputStream object to read the file
                      FileInputStream fis = new FileInputStream(file1);

                      // Create a Workbook object that represents the Excel file
                      Workbook workbook = WorkbookFactory.create(fis);

                      // Get the first sheet in the Excel file
                      Sheet sheet = workbook.getSheetAt(0);
                      
                      int count = 0;
                      String countString = "";
                      // Iterate through each row in the sheet
                      for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                          Row row = sheet.getRow(rowIndex);

                        
                      //for (Row row : sheet) {
                          // Iterate through each cell in the row
                          //for (Cell cell : row) 
                          for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                              Cell cell = row.getCell(cellIndex);
                              DataFormatter formatter = new DataFormatter();
             
                         	 count = count+1;
                         	 countString = count+"";
                         	 // Print the value of each cell
                              //System.out.print(cell.toString() + "\t");
                         	 System.out.print(formatter.formatCellValue(cell) + "\t");
                              
                          	System.out.println("**********************");
                    		// Handle the scraping button click event
                        // Add your scraping logic here
                          	System.out.println("################################"+countString);
                          	System.out.println(formatter.formatCellValue(cell) +countString);
                   //implementing id's by argument
                          	String[] TcsCTsample = new String[] {formatter.formatCellValue(cell)}; 
                     
                     try {
                     	//TcsExperience_candidate.main(argument);
                    	 TCScampusTrianee_id.TcsCTsample(TcsCTsample);
 					} catch (InterruptedException | IOException e1) {
 					
 						e1.printStackTrace();
 					}
                          }
                          System.out.println();
                          countString = "";
                      }     

                      // Close the workbook and the file input stream
                      workbook.close();
                      fis.close();
                     // JFrame scrap = new JFrame 
                 } catch (IOException e1) {
                      e1.printStackTrace();
                  }
    			
             	 try {
             		 TcsExpbackup_candidate.close();
             		} catch (InterruptedException e1) {
             			// TODO Auto-generated catch block
             			e1.printStackTrace();
             		}	
		}
}
 
 
 public class DirectTraineesubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	String[] TcsCTcaptcha1 = new String[] {"ishwarya.s@matrixbsindia.com","Lord@2023", ""};
	 		
    		try {
    			Direct_Trainee.DirectTcscaptcha(TcsCTcaptcha1);
 		} catch (InterruptedException e1) {
 			
 			e1.printStackTrace();
 		} catch (IOException e1) {
 			e1.printStackTrace();
 		} 
    			
    	      	try {
                     // JFileChooser fileChooser = null;
 					// Create a File object that represents the Excel file to read
                      File file1 = new File(StringtoPass2);
                      
                      // Create a FileInputStream object to read the file
                      FileInputStream fis = new FileInputStream(file1);

                      // Create a Workbook object that represents the Excel file
                      Workbook workbook = WorkbookFactory.create(fis);

                      // Get the first sheet in the Excel file
                      Sheet sheet = workbook.getSheetAt(0);
                      
                      int count = 0;
                      String countString = "";
                      // Iterate through each row in the sheet
                      for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                          Row row = sheet.getRow(rowIndex);

                        
                      //for (Row row : sheet) {
                          // Iterate through each cell in the row
                          //for (Cell cell : row) 
                          for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                              Cell cell = row.getCell(cellIndex);
                              DataFormatter formatter = new DataFormatter();
             
                         	 count = count+1;
                         	 countString = count+"";
                         	 // Print the value of each cell
                              //System.out.print(cell.toString() + "\t");
                         	 System.out.print(formatter.formatCellValue(cell) + "\t");
                              
                          	System.out.println("**********************");
                    		// Handle the scraping button click event
                        // Add your scraping logic here
                          	System.out.println("################################"+countString);
                          	System.out.println(formatter.formatCellValue(cell) +countString);
                   //implementing id's by argument
                          	String[] TcsCTsample = new String[] {formatter.formatCellValue(cell)}; 
                     
                     try {
                     	//TcsExperience_candidate.main(argument);
                    	 Direct_Trainee.Directtcssample(TcsCTsample);
 					} catch (InterruptedException | IOException e1) {
 					
 						e1.printStackTrace();
 					}
                          }
                          System.out.println();
                          countString = "";
                      }     

                      // Close the workbook and the file input stream
                      workbook.close();
                      fis.close();
                     // JFrame scrap = new JFrame 
                 } catch (IOException e1) {
                      e1.printStackTrace();
                  }
    			
             	 try {
             		 TcsExpbackup_candidate.close();
             		} catch (InterruptedException e1) {
             			// TODO Auto-generated catch block
             			e1.printStackTrace();
             		}	
		}
		}

 
 public static void main(String[] args) {
        ExampleGUI gui = new ExampleGUI();
        gui.setVisible(true);
    }


}


