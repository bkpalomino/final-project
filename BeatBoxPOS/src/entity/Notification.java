
package entity;

import javax.swing.JPanel;
import util.StateManager;


public class Notification extends JPanel {
    
    private String title;
    private String message;
    
    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
        
        initComponents();
    }

    public Notification() {
        this.title = "";
        this.message = "";
        
        initComponents();
    }
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContent = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        scrollMessage = new javax.swing.JScrollPane();
        textAreaMessage = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(350, 200));
        setPreferredSize(new java.awt.Dimension(225, 315));
        setLayout(new java.awt.BorderLayout());

        panelContent.setBorder(new javax.swing.border.LineBorder(StateManager.COLOR_ORANGE, 3, true));
        panelContent.setMinimumSize(new java.awt.Dimension(307, 116));
        panelContent.setPreferredSize(new java.awt.Dimension(380, 175));
        panelContent.setLayout(new java.awt.GridBagLayout());

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitle.setText(title);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(labelTitle, gridBagConstraints);

        scrollMessage.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textAreaMessage.setColumns(20);
        textAreaMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textAreaMessage.setLineWrap(true);
        textAreaMessage.setRows(5);
        textAreaMessage.setText(message);
        textAreaMessage.setWrapStyleWord(true);
        textAreaMessage.setMinimumSize(new java.awt.Dimension(307, 116));
        textAreaMessage.setEditable(false);
        scrollMessage.setViewportView(textAreaMessage);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(scrollMessage, gridBagConstraints);

        add(panelContent, java.awt.BorderLayout.CENTER);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        labelTitle.setText(title);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        textAreaMessage.setText(message);
    }
    
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelContent;
    private javax.swing.JScrollPane scrollMessage;
    private javax.swing.JTextArea textAreaMessage;
    
}
