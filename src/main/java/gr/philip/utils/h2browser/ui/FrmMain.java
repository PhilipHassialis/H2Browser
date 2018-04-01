/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.philip.utils.h2browser.ui;

import gr.philip.utils.h2browser.utils.DBUtils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author admin
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtareaResults = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtextpaneSQL = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jlblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnuFile = new javax.swing.JMenu();
        jmnuFileOpen = new javax.swing.JMenuItem();
        jmnuFileExportText = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnuFileExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmnuHelpAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simple H2 SQL Executor");

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jtxtareaResults.setColumns(20);
        jtxtareaResults.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jtxtareaResults.setRows(5);
        jScrollPane2.setViewportView(jtxtareaResults);

        jSplitPane1.setRightComponent(jScrollPane2);

        jtextpaneSQL.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jtextpaneSQL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextpaneSQLKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtextpaneSQL);

        jSplitPane1.setLeftComponent(jScrollPane3);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblStatus.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jmnuFile.setMnemonic('f');
        jmnuFile.setText("File");

        jmnuFileOpen.setMnemonic('o');
        jmnuFileOpen.setText("Open...");
        jmnuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuFileOpenActionPerformed(evt);
            }
        });
        jmnuFile.add(jmnuFileOpen);

        jmnuFileExportText.setMnemonic('t');
        jmnuFileExportText.setText("Text Export...");
        jmnuFileExportText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuFileExportTextActionPerformed(evt);
            }
        });
        jmnuFile.add(jmnuFileExportText);
        jmnuFile.add(jSeparator1);

        jmnuFileExit.setMnemonic('x');
        jmnuFileExit.setText("Exit");
        jmnuFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuFileExitActionPerformed(evt);
            }
        });
        jmnuFile.add(jmnuFileExit);

        jMenuBar1.add(jmnuFile);

        jMenu2.setText("Help");

        jmnuHelpAbout.setMnemonic('b');
        jmnuHelpAbout.setText("About...");
        jmnuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuHelpAboutActionPerformed(evt);
            }
        });
        jMenu2.add(jmnuHelpAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmnuFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuFileExitActionPerformed
	this.dispose();
    }//GEN-LAST:event_jmnuFileExitActionPerformed

    private void jmnuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuFileOpenActionPerformed
	JFileChooser jfc = new JFileChooser(new File("."));
	if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	    try {
		DBUtils.closeConnection();
		DBUtils.openConnection(jfc.getSelectedFile());
		JOptionPane.showMessageDialog(this, "Opened database", "DB Open", JOptionPane.INFORMATION_MESSAGE);
	    } catch (HeadlessException | IOException | ClassNotFoundException | SQLException e) {
		JOptionPane.showMessageDialog(this, "SQL DB File Open failed:" + e.getMessage(), "File Open", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace(System.err);
	    }
	}
    }//GEN-LAST:event_jmnuFileOpenActionPerformed

    private void jmnuFileExportTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuFileExportTextActionPerformed
	JFileChooser jfcSave = new JFileChooser(new File("."));
	if (jfcSave.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
	    try {
		try (FileWriter fw = new FileWriter(jfcSave.getSelectedFile(), true)) {
		    fw.append(jtxtareaResults.getText());
		    fw.flush();
		}
		JOptionPane.showMessageDialog(this, "Text Export succesful", "Text export", JOptionPane.INFORMATION_MESSAGE);
	    } catch (IOException e) {
		JOptionPane.showMessageDialog(this, "Text Export failed:" + e.getMessage(), "Text export", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }//GEN-LAST:event_jmnuFileExportTextActionPerformed

    private void jmnuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuHelpAboutActionPerformed
	// TODO add your handling code here:
	FrmAbout njf = new FrmAbout();
	njf.setVisible(true);
	
    }//GEN-LAST:event_jmnuHelpAboutActionPerformed

    private void jtextpaneSQLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextpaneSQLKeyPressed
	// TODO add syntax highlighting
	/*
	
	try {
	    SimpleAttributeSet set = new SimpleAttributeSet();
	    StyleConstants.setForeground(set, Color.red);
	    DefaultStyledDocument doc = (DefaultStyledDocument)jtextpaneSQL.getDocument();
	    doc.setCharacterAttributes(0, 5, set, true);
	} catch (Exception e) {
	}
	
	*/
	
	
	if (evt.getKeyCode() == KeyEvent.VK_ENTER && evt.getModifiers() == KeyEvent.CTRL_MASK) {
	    try {
		Statement s = DBUtils.executeQuery(jtextpaneSQL.getText());
		if (s != null) {
		    ResultSet rs = s.getResultSet();
		    jtxtareaResults.setText("");
		    ResultSetMetaData rsmd = rs.getMetaData();
		    StringBuilder sb = new StringBuilder();
		    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			sb.append(rsmd.getColumnLabel(i));
			if (i < rsmd.getColumnCount()) {
			    sb.append(";");
			}
		    }
		    sb.append("\n");
		    while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			    sb.append(rs.getString(i));
			    if (i < rsmd.getColumnCount()) {
				sb.append(";");
			    }
			}
			sb.append("\n");
		    }
		    jtxtareaResults.setText(sb.toString());
		}

	    } catch (SQLException e) {
		JOptionPane.showMessageDialog(this, "SQL Execution failed:" + e.getMessage(), "SQL Exec", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace(System.err);

	    }
	}
    }//GEN-LAST:event_jtextpaneSQLKeyPressed

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
	    java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new FrmMain().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JMenu jmnuFile;
    private javax.swing.JMenuItem jmnuFileExit;
    private javax.swing.JMenuItem jmnuFileExportText;
    private javax.swing.JMenuItem jmnuFileOpen;
    private javax.swing.JMenuItem jmnuHelpAbout;
    private javax.swing.JTextPane jtextpaneSQL;
    private javax.swing.JTextArea jtxtareaResults;
    // End of variables declaration//GEN-END:variables
}
