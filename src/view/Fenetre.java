/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import automate.EcrivainScreenShot;
import automate.MethodMatcher;
import modele.ListModelFDEF;
import modele.ListModelLangEnt;
import modele.ListModelLangExt;
import modele.ListModelMethExt;

/**
 *
 * @author nik
 */
public class Fenetre extends FrameGenerik {

    EcrivainScreenShot ecr = new EcrivainScreenShot();
    MethodMatcher mm = new MethodMatcher();

    /**
     * Creates new form Fenetre
     */
    public Fenetre()
        {
       
        
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

        butFin = new javax.swing.JButton();
        butCancel = new javax.swing.JButton();
        titreSaisi = new javax.swing.JLabel();
        titreSaisi1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JScrollPane listLangEnSP = new javax.swing.JScrollPane();
        listLangEntJL = new javax.swing.JList<>();
        listLangExSP = new javax.swing.JScrollPane();
        listLangExtJL = new javax.swing.JList<>();
        butEnvoi = new javax.swing.JButton();
        butRetrait = new javax.swing.JButton();
        listMethEn = new javax.swing.JScrollPane();
        listModelFDEF = new javax.swing.JList<>();
        listMethEx = new javax.swing.JScrollPane();
        listMethExt = new javax.swing.JList<>();
        butEnvoiMethod = new javax.swing.JButton();
        butRetraitMethod = new javax.swing.JButton();
        butScript = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scripteur pour ScreenShots\n");
        setBackground(new java.awt.Color(255, 102, 102));
        setForeground(new java.awt.Color(51, 255, 255));

        butFin.setText("Ajuster");
        butFin.setToolTipText("permet de faire le mapping entre les FormDef et les formulaires");
        butFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFinActionPerformed(evt);
            }
        });

        butCancel.setText("cancel");
        butCancel.setEnabled(false);
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });

        titreSaisi.setText("Saisie des langues");
        titreSaisi.setToolTipText("(sous forme FR_FR)");

        titreSaisi1.setText("Saisie des methodes");
        titreSaisi1.setToolTipText("sous forme (FDEF.3_EQ5D5L)");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Template: eProScreenBuilder.exe -output \"Screenshots\\AR_IL\" -mode2 -workflow \"FDEF.3_EQ5D5L:PRO\" \"FDEF.3_EQ5D5L:AR_IL(1.0.0)\"");
        jLabel1.setToolTipText("sous forme (FDEF.3_EQ5D5L)");

        listLangEnSP.setBackground(params.ColorChart.colorFront);
        listLangEnSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Codes in Study"));
        listLangEnSP.setAutoscrolls(true);
        listLangEnSP.setDoubleBuffered(true);
        listLangEnSP.setHorizontalScrollBar(null);

        listLangEntJL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listLangEntJL.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listLangEntJL.setModel(new modele.ListModelLangEnt());
        listLangEntJL.setAutoscrolls(false);
        listLangEntJL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listLangEntJL.setDoubleBuffered(true);
        listLangEnSP.setViewportView(listLangEntJL);

        listLangExSP.setBackground(params.ColorChart.colorFront);
        listLangExSP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codes to ScreenShot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 9))); // NOI18N

        listLangExtJL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listLangExtJL.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listLangExtJL.setModel(new modele.ListModelLangExt());
        listLangExSP.setViewportView(listLangExtJL);

        butEnvoi.setText(">");
        butEnvoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEnvoiActionPerformed(evt);
            }
        });

        butRetrait.setText("<");
        butRetrait.setToolTipText("");
        butRetrait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRetraitActionPerformed(evt);
            }
        });

        listMethEn.setBackground(params.ColorChart.colorFront);
        listMethEn.setBorder(javax.swing.BorderFactory.createTitledBorder("Method in Study"));

        listModelFDEF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listModelFDEF.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listModelFDEF.setModel(new modele.ListModelFDEF());
        listMethEn.setViewportView(listModelFDEF);

        listMethEx.setBackground(params.ColorChart.colorFront);
        listMethEx.setBorder(javax.swing.BorderFactory.createTitledBorder("Method to screenshot"));

        listMethExt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listMethExt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listMethExt.setModel(new modele.ListModelMethExt());
        listMethEx.setViewportView(listMethExt);

        butEnvoiMethod.setText(">");
        butEnvoiMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEnvoiMethodActionPerformed(evt);
            }
        });

        butRetraitMethod.setText("<");
        butRetraitMethod.setToolTipText("");
        butRetraitMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRetraitMethodActionPerformed(evt);
            }
        });

        butScript.setText("Lancer le script");
        butScript.setToolTipText("Synchroniser d'abord les methodes pour activer ce bouton");
        butScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butScriptActionPerformed(evt);
            }
        });

        jLabel2.setText("Exemple de script généré:");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(titreSaisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titreSaisi1)
                .addGap(144, 144, 144))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(butCancel)
                .addGap(241, 241, 241)
                .addComponent(butFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butScript, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(listLangEnSP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butRetrait)
                    .addComponent(butEnvoi))
                .addGap(18, 18, 18)
                .addComponent(listLangExSP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listMethEn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(butEnvoiMethod)
                    .addComponent(butRetraitMethod))
                .addGap(18, 18, 18)
                .addComponent(listMethEx, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titreSaisi1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(titreSaisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(butEnvoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butRetrait))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(butEnvoiMethod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(butRetraitMethod)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listMethEn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(listMethEx, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(listLangExSP, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(listLangEnSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCancel)
                    .addComponent(butFin)
                    .addComponent(butScript))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butCancelActionPerformed
    {//GEN-HEADEREND:event_butCancelActionPerformed
        
    }//GEN-LAST:event_butCancelActionPerformed

    private void butFinActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butFinActionPerformed
    {//GEN-HEADEREND:event_butFinActionPerformed
     
        
        mm.mapMethodMatcher();
      /*
        FenManualSelect fms = new FenManualSelect();
        fms.setLocation(500,200);
       fms.setSize(1000, 400);
       fms.setVisible(true);
        */
       //butScript.setEnabled(true);
       

    }//GEN-LAST:event_butFinActionPerformed

    private void butEnvoiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butEnvoiActionPerformed
    {//GEN-HEADEREND:event_butEnvoiActionPerformed
        if (listLangEntJL.getSelectedValuesList().size() > 0) {
            for (String pa : listLangEntJL.getSelectedValuesList()) {
                
                ((ListModelLangExt) listLangExtJL.getModel()).add(pa);
                //((ListModelLangEnt) listLangEnt.getModel()).remove(pa);
            }
        }
    }//GEN-LAST:event_butEnvoiActionPerformed

    private void butRetraitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butRetraitActionPerformed
    {//GEN-HEADEREND:event_butRetraitActionPerformed
        if (listLangExtJL.getSelectedValuesList().size() > 0) {
            for (String pa : listLangExtJL.getSelectedValuesList()) {
                ((ListModelLangEnt) listLangEntJL.getModel()).add(pa);
                ((ListModelLangExt) listLangExtJL.getModel()).remove(pa);
            }
        }
    }//GEN-LAST:event_butRetraitActionPerformed

    private void butEnvoiMethodActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butEnvoiMethodActionPerformed
    {//GEN-HEADEREND:event_butEnvoiMethodActionPerformed
       if (listModelFDEF.getSelectedValuesList().size() > 0) {
            for (String pa : listModelFDEF.getSelectedValuesList()) {
                ((ListModelMethExt) listMethExt.getModel()).add(pa);
               // ((ListModelMethEnt) listMethEnt.getModel()).remove(pa);
            }
        }
    }//GEN-LAST:event_butEnvoiMethodActionPerformed

    private void butRetraitMethodActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butRetraitMethodActionPerformed
    {//GEN-HEADEREND:event_butRetraitMethodActionPerformed
        if (listMethExt.getSelectedValuesList().size() > 0) {
            for (String pa : listMethExt.getSelectedValuesList()) {
                ((ListModelFDEF) listModelFDEF.getModel()).add(pa);
                ((ListModelMethExt) listMethExt.getModel()).remove(pa);
            }
        }
    }//GEN-LAST:event_butRetraitMethodActionPerformed

    private void butScriptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_butScriptActionPerformed
    {//GEN-HEADEREND:event_butScriptActionPerformed
       PanelACopier pan = new PanelACopier(ecr.getScript());
       pan.setLocation(500,200);
       pan.setSize(1000, 400);
       pan.setVisible(true);
    }//GEN-LAST:event_butScriptActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butEnvoi;
    private javax.swing.JButton butEnvoiMethod;
    private javax.swing.JButton butFin;
    private javax.swing.JButton butRetrait;
    private javax.swing.JButton butRetraitMethod;
    private javax.swing.JButton butScript;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> listLangEntJL;
    private javax.swing.JScrollPane listLangExSP;
    private javax.swing.JList<String> listLangExtJL;
    private javax.swing.JScrollPane listMethEn;
    private javax.swing.JScrollPane listMethEx;
    private javax.swing.JList<String> listMethExt;
    private javax.swing.JList<String> listModelFDEF;
    private javax.swing.JLabel titreSaisi;
    private javax.swing.JLabel titreSaisi1;
    // End of variables declaration//GEN-END:variables
}
