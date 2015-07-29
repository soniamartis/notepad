/*
author:sonia martis
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import java.util.regex.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.util.*;

public class MyNotepad extends javax.swing.JFrame implements Serializable  {
  //instance variable declarations
    String programName="Notepad";
    String filename="";
    String holdText;
    String fn;
    String dir;
    boolean textChanged=false;
    String fileName;
    Clipboard clip=getToolkit().getSystemClipboard();
    UndoManager manager = new UndoManager();
    String fonts[];
    DefaultListModel d;//holds the various fonts available in the system
    DefaultListModel t;//holds the style strings
    DefaultListModel sizenum;//holds the size numbers
    int font_number=Font.PLAIN;//default font style
    String font=Font.MONOSPACED;//default font
    int selected_size=12;//dedfault text size
    Font f=new Font(font,font_number,selected_size);
    HashMap m=new HashMap();
   
    
    public MyNotepad() {
        initComponents();
        setIcon();
         fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
         d=new DefaultListModel();
         for(String s:fonts){
             d.addElement(s);
         }
        list_of_fonts.setModel(d);
        String styles[]={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
        t=new DefaultListModel();
        for(String s:styles){
            t.addElement(s);
            
                    
        }list_of_styles.setModel(t);
        sizenum=new DefaultListModel();
        int nums[]={8,9,10,11,12,14,16,20,22,24,26,28,36,48,72};
        for(int num:nums){
            sizenum.addElement(num);
        }list_of_sizes.setModel(sizenum);
        font_dialog.setSize(400,400);
    }
    
    public void checkFile(){
        BufferedReader read;
        
        StringBuffer sb=new StringBuffer();
        try{
            read=new BufferedReader(new FileReader(fileName));
            String line;
            while((line=read.readLine())!=null){
                sb.append(line+ "\n");
            }
            textArea.setText(sb.toString());
            read.close();
            textChanged=false;
            Set entries=m.entrySet();
            Iterator itr=entries.iterator();
            while(itr.hasNext()){
                Map.Entry e=(Map.Entry)itr.next();
                System.out.println(e.getKey());
                if(e.getKey().equals(fileName)){
                    textArea.setFont((Font)e.getValue());
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }catch(IOException e){
            
        }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        font_dialog = new javax.swing.JDialog();
        font_label = new javax.swing.JLabel();
        fontstyle_label = new javax.swing.JLabel();
        size_label = new javax.swing.JLabel();
        scoundrel = new javax.swing.JScrollPane();
        list_of_fonts = new javax.swing.JList();
        font_name = new javax.swing.JTextField();
        style_name = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_of_styles = new javax.swing.JList();
        size = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_of_sizes = new javax.swing.JList();
        okbtn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        FileTab = new javax.swing.JMenu();
        newFrame = new javax.swing.JMenuItem();
        openFrame = new javax.swing.JMenuItem();
        saveFrame = new javax.swing.JMenuItem();
        saveasFrame = new javax.swing.JMenuItem();
        exitFrame = new javax.swing.JMenuItem();
        EditTab = new javax.swing.JMenu();
        textColor = new javax.swing.JMenuItem();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();
        SearchTab = new javax.swing.JMenu();
        findPattern = new javax.swing.JMenuItem();
        replacePattern = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        font_dialog.setMaximumSize(new java.awt.Dimension(350, 400));
        font_dialog.setMinimumSize(new java.awt.Dimension(350, 400));

        font_label.setText("Font");

        fontstyle_label.setText("Font_style");

        size_label.setText("Size:");

        list_of_fonts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list_of_fonts.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                list_of_fontsAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        scoundrel.setViewportView(list_of_fonts);

        style_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                style_nameActionPerformed(evt);
            }
        });

        list_of_styles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(list_of_styles);

        size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        list_of_sizes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane4.setViewportView(list_of_sizes);

        okbtn.setText("OK");
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtnActionPerformed(evt);
            }
        });

        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout font_dialogLayout = new javax.swing.GroupLayout(font_dialog.getContentPane());
        font_dialog.getContentPane().setLayout(font_dialogLayout);
        font_dialogLayout.setHorizontalGroup(
            font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, font_dialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(font_dialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okbtn)
                        .addGap(38, 38, 38)
                        .addComponent(cancel_btn))
                    .addGroup(font_dialogLayout.createSequentialGroup()
                        .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(font_dialogLayout.createSequentialGroup()
                                .addComponent(font_name, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(font_dialogLayout.createSequentialGroup()
                                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scoundrel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(font_dialogLayout.createSequentialGroup()
                                        .addComponent(font_label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)))
                        .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(style_name, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fontstyle_label, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(size_label, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(458, 458, 458))
        );
        font_dialogLayout.setVerticalGroup(
            font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(font_dialogLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(font_label)
                    .addComponent(fontstyle_label)
                    .addComponent(size_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(font_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(style_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoundrel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(font_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okbtn)
                    .addComponent(cancel_btn))
                .addGap(20, 20, 20))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAreaCaretUpdate(evt);
            }
        });
        textArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textAreaPropertyChange(evt);
            }
        });
        textArea.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textAreaVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        FileTab.setText("File");

        newFrame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFrame.setText("New      ");
        newFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFrameActionPerformed(evt);
            }
        });
        FileTab.add(newFrame);

        openFrame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFrame.setText("Open");
        openFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFrameActionPerformed(evt);
            }
        });
        FileTab.add(openFrame);

        saveFrame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFrame.setText("Save");
        saveFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFrameActionPerformed(evt);
            }
        });
        FileTab.add(saveFrame);

        saveasFrame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveasFrame.setText("Save As");
        saveasFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveasFrameActionPerformed(evt);
            }
        });
        FileTab.add(saveasFrame);

        exitFrame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        exitFrame.setText("Exit");
        exitFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFrameActionPerformed(evt);
            }
        });
        FileTab.add(exitFrame);

        menuBar.add(FileTab);

        EditTab.setText("Edit");

        textColor.setText("TextColor");
        EditTab.add(textColor);

        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cut.setText("Cut");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        EditTab.add(cut);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        EditTab.add(copy);

        paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        paste.setText("Paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        EditTab.add(paste);

        undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undo.setText("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        EditTab.add(undo);

        redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redo.setText("Redo");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });
        EditTab.add(redo);

        menuBar.add(EditTab);

        SearchTab.setText("Search");

        findPattern.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        findPattern.setText("Find");
        findPattern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPatternActionPerformed(evt);
            }
        });
        SearchTab.add(findPattern);

        replacePattern.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        replacePattern.setText("Replace");
        SearchTab.add(replacePattern);

        menuBar.add(SearchTab);

        jMenu1.setText("Format");

        jMenuItem1.setText("Font...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFrameActionPerformed
           newFile();        // TODO add your handling code here:
    }//GEN-LAST:event_newFrameActionPerformed

    private void saveFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFrameActionPerformed
        if(filename.equals("")){
            saveAs();
        }else{
            save(filename);
        }
    }//GEN-LAST:event_saveFrameActionPerformed

    private void saveasFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveasFrameActionPerformed
        saveAs();
    }//GEN-LAST:event_saveasFrameActionPerformed

    private void exitFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFrameActionPerformed
        if(textChanged){
            openConfirmDialog();//opens a confirmdialog for confirming
        }
        System.exit(0);
    }//GEN-LAST:event_exitFrameActionPerformed

    private void textAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textAreaPropertyChange
        
    }//GEN-LAST:event_textAreaPropertyChange

    private void textAreaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textAreaVetoableChange
        
    }//GEN-LAST:event_textAreaVetoableChange
//this listener fires whenever there is a change in the text area.
    private void textAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textAreaCaretUpdate
        if(TextEvent.TEXT_VALUE_CHANGED!=0){
            if(!textChanged){
                setTitle("*"+getTitle());
                textChanged=true;
                saveFrame.setEnabled(true);
            }
        }
    }//GEN-LAST:event_textAreaCaretUpdate

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        copyToClipboard();
    }//GEN-LAST:event_copyActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
       pasteData();
    }//GEN-LAST:event_pasteActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        cutData();
    }//GEN-LAST:event_cutActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        undoAction();
    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        redoAction();
    }//GEN-LAST:event_redoActionPerformed

    private void findPatternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPatternActionPerformed
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                find();
            }
        });
    }//GEN-LAST:event_findPatternActionPerformed

    private void openFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFrameActionPerformed
       if(textArea.getText().length()<1||!textChanged){
          open_frame();
       }
       else {
           int confirm=JOptionPane.showConfirmDialog(null, "Do you want to save before opening another file?");
           if(confirm==JOptionPane.YES_OPTION){
               if("".equals(filename)){
                   saveAs();
                   
               }else{
                   save(filename);
               }open_frame();
           }
       }
    }//GEN-LAST:event_openFrameActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         
        
        
        list_of_fonts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_of_fonts.setVisibleRowCount(8);
        list_of_fonts.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                font_name.setText(list_of_fonts.getSelectedValue().toString());
                font=font_name.getText();
            }
        });
        list_of_styles.addMouseListener(new MouseAdapter(){
          public void mousePressed(MouseEvent me){
              style_name.setText(list_of_styles.getSelectedValue().toString());
              if(style_name.getText()=="PLAIN"){
                  font_number=Font.PLAIN;
              }
              else if(style_name.getText()=="BOLD"){
                  font_number=Font.BOLD;
              }
              else if(style_name.getText()=="ITALIC"){
                  font_number=Font.ITALIC;
              }else font_number=Font.BOLD|Font.ITALIC;
          }
        });
        list_of_sizes.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                size.setText(list_of_sizes.getSelectedValue().toString());
                selected_size=Integer.parseInt(size.getText());
                
            }
        });
        font_dialog.setVisible(true); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void okbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtnActionPerformed
        font_dialog.dispose();
        Font myFont=new Font(font,font_number,selected_size);
        textArea.setFont(myFont);// TODO add your handling code here:
        f=myFont;
    }//GEN-LAST:event_okbtnActionPerformed

    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeActionPerformed

    private void style_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_style_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_style_nameActionPerformed

    private void list_of_fontsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_list_of_fontsAncestorAdded
        
    }//GEN-LAST:event_list_of_fontsAncestorAdded
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyNotepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyNotepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyNotepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyNotepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyNotepad().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditTab;
    private javax.swing.JMenu FileTab;
    private javax.swing.JMenu SearchTab;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem exitFrame;
    private javax.swing.JMenuItem findPattern;
    private javax.swing.JDialog font_dialog;
    private javax.swing.JLabel font_label;
    private javax.swing.JTextField font_name;
    private javax.swing.JLabel fontstyle_label;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList list_of_fonts;
    private javax.swing.JList list_of_sizes;
    private javax.swing.JList list_of_styles;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFrame;
    private javax.swing.JButton okbtn;
    private javax.swing.JMenuItem openFrame;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem redo;
    private javax.swing.JMenuItem replacePattern;
    private javax.swing.JMenuItem saveFrame;
    private javax.swing.JMenuItem saveasFrame;
    private javax.swing.JScrollPane scoundrel;
    private javax.swing.JTextField size;
    private javax.swing.JLabel size_label;
    private javax.swing.JTextField style_name;
    private javax.swing.JTextArea textArea;
    private javax.swing.JMenuItem textColor;
    private javax.swing.JMenuItem undo;
    // End of variables declaration//GEN-END:variables

    private void saveAs() {
      FileDialog fd=new FileDialog(MyNotepad.this,"Save",FileDialog.SAVE);
      fd.show();
      if(fd.getFile()!=null){
          fn=fd.getFile();
          dir=fd.getDirectory();
          filename=dir + fn +".txt";
          
          setTitle(filename);
          try{
              ObjectOutputStream d=new ObjectOutputStream(new FileOutputStream(filename));
              holdText=textArea.getText();
              BufferedReader br=new BufferedReader(new StringReader(holdText));
              while((holdText=br.readLine())!=null){
                  d.writeObject(holdText+"\r\n");
                  d.close();
              }
                      
          }catch(Exception e){
            System.out.println("file not saved");
          }
          textArea.requestFocus();
          save(filename);
      }
    }
    
    private void open_frame(){
         FileDialog fd=new FileDialog(this,"Choose file",FileDialog.LOAD);
           fd.show();
           if(fd.getFile()!=null){
               fileName=fd.getDirectory()+fd.getFile();
               setTitle(fileName);
               checkFile();
           }
           textArea.requestFocus();
    }
    private void save(String filename) {
        setTitle(programName+" "+filename);
        try{
            FileWriter out=null;
            out=new FileWriter(filename);
            out.write(textArea.getText());
            out.close();
            m.put(fileName,f);
            System.out.println(m);
            
        }catch(Exception e){
            System.out.println("error: "+e);
        }
        textChanged=false;
        saveFrame.setEnabled(false);
    }

    private void newFile() {
        if(textArea.getText().length()<1){
            setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged=false;
        }else if(!textChanged){
            setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged=false; 
        }else{
            int confirm=JOptionPane.showConfirmDialog(null,"fucker");
            if(confirm==JOptionPane.YES_OPTION){
                if("".equals(filename)){
                    saveAs();
                }else save(filename);
            }
            
        }
    }

    private void copyToClipboard() {
        String str = textArea.getSelectedText();

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		clip = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(str);
		clip.setContents(strSel, null);
    }

    private void openConfirmDialog() {
        int confirm=JOptionPane.showConfirmDialog(null,"Do you want to save before exiting?");
            if(confirm==JOptionPane.YES_OPTION){
                if("".equals(filename)){
                    saveAs();
                
    }
}
    }

    private void pasteData() {
         clip = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable t = clip.getContents(this);
    if (t == null)
        return;
    try {
        textArea.setText(textArea.getText()+(String) t.getTransferData(DataFlavor.stringFlavor));
    } catch (Exception e){
        e.printStackTrace();
    } 
    }

    private void cutData() {
        copyToClipboard();
        String text=textArea.getText();
        int start_index=textArea.getSelectionStart();
        int end_index=textArea.getSelectionEnd();
        String second="";
        String first="";
        if(text.length()-1>end_index)
        {
             second=text.substring(end_index+1);
        }
        if(start_index!=0)
        {
            first=text.substring(0,start_index-1);
        }
        textArea.setText(first+second);
        
        
        
    }

    private void undoAction() {
      try{
          manager.undo();
      }catch(Exception e){
         System.out.println("cannot undo");
      }

    }

    private void redoAction() {
       try{
           manager.redo();
       }catch(Exception e){
           
       }
    }

    private void find() {
       
 class Find_pattern extends javax.swing.JFrame {

   
    public Find_pattern() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        find_label = new javax.swing.JLabel();
        enter_pattern = new javax.swing.JTextField();
        find_button = new javax.swing.JButton();
        count_label = new javax.swing.JLabel();
        set_count = new javax.swing.JTextField();
        this.setVisible(true);
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        find_label.setText("Find_what:");

        find_button.setText("Find");
         find_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    find_buttonActionPerformed(evt);
                } catch (BadLocationException ex) {
                    Logger.getLogger(MyNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        count_label.setText("Count:");

        set_count.setText(" ");
        
       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(find_label)
                    .addComponent(count_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enter_pattern, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(find_button))
                    .addComponent(set_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(find_label)
                    .addComponent(enter_pattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(find_button))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(count_label)
                    .addComponent(set_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

     private void find_buttonActionPerformed(java.awt.event.ActionEvent evt) throws BadLocationException { 
       
       Integer count=0;
       
        Highlighter highlighter=textArea.getHighlighter();
        HighlightPainter painter=new DefaultHighlightPainter(Color.yellow);
       Pattern p=Pattern.compile(enter_pattern.getText());
       Matcher m=p.matcher(textArea.getText());
       while(m.find()){
           count++;
           int start=m.start();
           int end=m.end();
           highlighter.addHighlight(start, end, painter);
          
       }set_count.setText(count.toString());
       textArea.addMouseListener(new MouseAdapter(){
           public void mousePressed(MouseEvent e){
               remove_highlight();
               }});
       enter_pattern.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               set_count.setText(" ");
               remove_highlight();
           }
           
       });
     
     }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel count_label;
    private javax.swing.JTextField enter_pattern;
    private javax.swing.JButton find_button;
    private javax.swing.JLabel find_label;
    private javax.swing.JTextField set_count;
    // End of variables declaration                   
 }
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Find_pattern();
            }
        });
    }

    private void remove_highlight(){
        Highlighter hilite=textArea.getHighlighter();
            Highlighter.Highlight[] hilites=hilite.getHighlights();
            for(int i=0;i<hilites.length;i++){
                if(hilites[i].getPainter() instanceof DefaultHighlightPainter) {
                   hilite.removeHighlight(hilites[i]); 
           }
            }
        
    }

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
               }
    
}