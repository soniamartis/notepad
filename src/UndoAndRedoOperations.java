import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.event.*;

public class UndoAndRedoOperations extends JFrame {
	JButton b1, b2, b3;
	JTextArea area;
	JScrollPane pane;
	JPanel p;
	UndoManager manager = new UndoManager();

	public UndoAndRedoOperations() {
		p = new JPanel();
		area = new JTextArea(5, 30);
		pane = new JScrollPane(area);
		manager = new UndoManager();
		b1 = new JButton("Undo");
		b2 = new JButton("Redo");
		b3 = new JButton("Exit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					manager.undo();
				} catch (Exception ex) {
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					manager.redo();
				} catch (Exception ex) {
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		area.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				manager.addEdit(e.getEdit());
			}
		});
		p.add(pane);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		UndoAndRedoOperations op = new UndoAndRedoOperations();
	}
}
