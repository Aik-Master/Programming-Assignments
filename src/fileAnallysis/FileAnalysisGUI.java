/** 
 * <b>Header</b>
 * Praktikum     P2P
 * Semester      SoSe13
 * Team          S1T1
 * Aufgabe       A3
 * Kontrolleur   Behnke
 * Datum         22.05.13
 * Quellen       /
 * @author       Klostermann, Aiko: 2125565
 */

package fileAnallysis;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class FileAnalysisGUI{

    // Constants
    private static final int  FRAME_HEIGHT = 500;
    private static final int  FRAME_WIDTH  = 500;

    // Swing elements
    private JFrame            frame;
    private JFileChooser      fileChooser;
    private JPanel            optionsPanel;
    private JButton           buttonPath;
    private JButton           buttonAnalyse;
    private JLabel            lablePath;
    private JTextField        fieldNOF;
    private JTextField        fieldNOD;
    private JTextArea         textArea;
    private JScrollPane       scrollPane;

    private FileAnalysisLogic logic;
    private String            path         = "C:\\";

    public FileAnalysisGUI(FileAnalysisLogic logic){
        this.logic = logic;

        // ----- buttonPath -----
        buttonPath = new JButton("Choose Path");
        buttonPath.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                path = choosePath();
                getLogic().setPath(path);
                lablePath.setText("The current Path is: " + path);
            }// actionPerformed
        });// anonymous ActionListener

        // ----- fieldNOF -----
        fieldNOF = new JTextField(5);
        fieldNOF.addActionListener(new ActionListener(){
            String text;
            int    nof;

            @Override
            public void actionPerformed(ActionEvent e){
                text = fieldNOF.getText();
                try{
                    nof = Integer.parseInt(text);
                    getLogic().setNOF(nof);
                } catch(NumberFormatException ex){
                    ex.printStackTrace();
                    fieldNOF.setText("Error!");
                }// try parse
            }// actionPerformed
        });// anonymous ActionListener

        // ----- fieldNOD -----
        fieldNOD = new JTextField(5);
        fieldNOD.addActionListener(new ActionListener(){
            String text;
            int    nod;

            @Override
            public void actionPerformed(ActionEvent e){
                text = fieldNOD.getText();
                try{
                    nod = Integer.parseInt(text);
                    getLogic().setNOD(nod);
                } catch(NumberFormatException ex){
                    ex.printStackTrace();
                    fieldNOD.setText("Error!");
                }// try parse
            }// actionPerformed
        });// anonymous ActionListener

        // ----- lablePath -----
        lablePath = new JLabel();
        lablePath.setText("The current Path is: " + path);

        // ----- buttonAnalyse -----
        buttonAnalyse = new JButton("Analyse!");
        buttonAnalyse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                getLogic().analyse();
                setTextArea();
            }// actionPerformed
        });// anonymous ActionListener

        // ----- textArea -----
        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // ----- scrollPane -----
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(495, 410));

        // ----- optionsPanel -----
        optionsPanel = new JPanel();
        optionsPanel.add(new JLabel("Number of Directories(nod):"));
        optionsPanel.add(fieldNOD);
        optionsPanel.add(new JLabel("Number of Files(gdi):"));
        optionsPanel.add(fieldNOF);
        optionsPanel.add(buttonPath);
        optionsPanel.add(lablePath);
        optionsPanel.add(buttonAnalyse);
        optionsPanel.add(scrollPane);

        // ----- JFrame -----
        frame = new JFrame("FileAnalysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(optionsPanel);
        frame.setResizable(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }// Constructor

    private void setTextArea(){
        File f = new File("C:\\Users\\Dieter\\Desktop\\a3_out.txt");
        InputStream in;
        try{
            in = new FileInputStream(f);
            textArea.read(new InputStreamReader(in), null);
        } catch(IOException e){
            e.printStackTrace();
        }// try catch
    } // setTextArea()

    private String choosePath(){
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setApproveButtonText("Choose Directory");
        fileChooser.setCurrentDirectory(new File("C:\\"));
        fileChooser.setFileFilter(new FileFilter(){

            public boolean accept(File f){
                return f.isDirectory();
            }// accept

            public String getDescription(){
                return "Only Directories";
            }// getDescription
        });// anonymous FileFilter class
        String path = null;
        int resu = fileChooser.showOpenDialog(null);
        if(resu == JFileChooser.APPROVE_OPTION){
            try{
                path = fileChooser.getSelectedFile().getCanonicalPath();
            } catch(IOException ex){
                ex.printStackTrace();
            }// try
        }// if
        return path;
    }// choosePath()

    public String getPath(){
        return path;
    }// getPath()

    public FileAnalysisLogic getLogic(){
        return logic;
    }// getLogic()
}// FileAnalysisGUI