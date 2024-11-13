/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.utsguiv2;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author excee
 */
public class Calc extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    String namaPelanggan, 
            nomorPelanggan, 
            alamatPelanggan, 
            processor, 
            storage0, 
            storage1, 
            pilihProcessor, 
            pilihMotherboard, 
            pilihRam, 
            pilihGraphiccard, 
            pilihPsu, 
            pilihStorage0, 
            pilihStorage1,
            pilihCase,
            channel,
            kibot,
            mouse,
            kursi,
            mic,
            speaker,
            monitor;
       // Map untuk harga item
    private Map<String, Long> processorPrices = new HashMap<>();
    private Map<String, Long> motherboardPrices = new HashMap<>();
    private Map<String, Long> ramPrices = new HashMap<>();
    private Map<String, Long> graphicCardPrices = new HashMap<>();
    private Map<String, Long> psuPrices = new HashMap<>();
    private Map<String, Long> storagePrices = new HashMap<>();
    private Map<String, Long> casePrices = new HashMap<>();

    
            
    

    public Calc() {
        initComponents();
         // Mengisi harga untuk tiap item
        processorPrices.put("Intel Core i3 1315U", 2800000L);
        processorPrices.put("Intel Core i3 1305U", 2600000L);
        processorPrices.put("Intel Core i5 13600HX", 5900000L);
        processorPrices.put("Intel Core i7 13850HX", 8500000L);
        processorPrices.put("AMD Ryzen 9 7950X3D", 14000000L);
        processorPrices.put("AMD Ryzen 7 7800X3D", 12000000L);
        processorPrices.put("AMD Ryzen 5 7600X", 7000000L);
        processorPrices.put("AMD Ryzen 5 7500X", 6500000L);

        motherboardPrices.put("MSI MAG B760 TOMAHAWK WIFI Intel", 3500000L);
        motherboardPrices.put("Asus ROG MAXIMUS Z790 HERO Intel", 7500000L);
        motherboardPrices.put("Gigabyte Z790 AORUS ELITE AX Intel", 6000000L);
        motherboardPrices.put("MSI MEG Z790 GODLIKE MAX WIFI 7 Intel", 12000000L);
        motherboardPrices.put("MSI MEG X670E ACE AMD", 11500000L);
        motherboardPrices.put("MSI MAG X670 TOMAHAWK WIFI AMD", 8500000L);
        motherboardPrices.put("ASUS ROG Strix X670E-E Gaming WiFi AMD", 10500000L);
        motherboardPrices.put("Gigabyte X670E AORUS MASTER AMD", 11000000L);

        // RAM prices
        ramPrices.put("Corsair Dominator Platinum RGB DDR5 16gb", 810000L);
        ramPrices.put("G.Skill Trident Z5 RGB DDR5 32gb", 980000L);
        ramPrices.put("Kingston FURY Beast DDR5 8gb", 750000L);
        ramPrices.put("MSI Spatium DDR5 16gb", 780000L);

        // Graphic Card prices
        graphicCardPrices.put("MSI RTX 3090 Ti Suprim X", 6000000L);
        graphicCardPrices.put("MSI RTX 3070 Gaming X Trio", 5600000L);
        graphicCardPrices.put("MSI RTX 3060 Ventus 2X OC", 4500000L);
        graphicCardPrices.put("MSI RTX 4090 SUPRIM X", 35000000L);

        // PSU prices
        psuPrices.put("Cooler Master V Gold 1000W 80+ Gold", 600000L);
        psuPrices.put("Corsair RMx Series 1200W 80+ Gold", 900000L);

        // Storage prices (SSD / HDD)
        storagePrices.put("128GB", 150000L);
        storagePrices.put("256GB", 212000L);
        storagePrices.put("512GB", 512000L);
        storagePrices.put("1TB", 1200000L);
        storagePrices.put("2TB", 1500000L);
        
        // Case Prices
        casePrices.put("NZXT H510 Elite", 450000L);
        casePrices.put("NZXT H510 Flow", 367000L);
        
        JOptionPane.showMessageDialog(this, "Selamat datang di Kalkulator!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
        private long calculateTotal() {
            
//            pop up
        JOptionPane.showMessageDialog(this, "Selamat datang di Kalkulator!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            
       // Mengambil nilai pilihan dari ComboBox
        String pilihProcessor = cmbProci.getSelectedItem().toString();
        String pilihMotherboard = cmbMobo.getSelectedItem().toString();
        String pilihRam = cmbRam.getSelectedItem().toString();
        String pilihGraphiccard = cmbvga.getSelectedItem().toString();
        String pilihPsu = cmbpsu.getSelectedItem().toString();
        String pilihStorage0 = cmbstor0.getSelectedItem().toString();
        String pilihStorage1 = cmbstor1.getSelectedItem().toString();
        String pilihCase = cmbCase.getSelectedItem().toString();
        
        // Mengambil pilihan apakah RAM Dual Channel
        boolean isDualChannel = chckDual.isSelected();
        

        // Menentukan harga dari pilihan yang dipilih
        long hargaProcessor = processorPrices.getOrDefault(pilihProcessor, 0L);
        long hargaMotherboard = motherboardPrices.getOrDefault(pilihMotherboard, 0L);
        long hargaRam = ramPrices.getOrDefault(pilihRam, 0L);
        long hargaVga = graphicCardPrices.getOrDefault(pilihGraphiccard, 0L);
        long hargaPsu = psuPrices.getOrDefault(pilihPsu, 0L);
        long hargaStorage0 = storagePrices.getOrDefault(pilihStorage0, 0L);
        long hargaStorage1 = storagePrices.getOrDefault(pilihStorage1, 0L);
        long hargaCase = casePrices.getOrDefault(pilihCase, 0L);
        
         // Jika RAM Dual Channel dipilih, kalikan harga RAM dengan 2
        if (isDualChannel) {
            hargaRam *= 2; // Double harga RAM untuk Dual Channel
        }

        // Hitung total harga semua part
        return hargaProcessor + hargaMotherboard + hargaRam + hargaVga + hargaPsu + hargaStorage0 + hargaStorage1 + hargaCase;
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupProcessor = new javax.swing.ButtonGroup();
        groupStorage0 = new javax.swing.ButtonGroup();
        groupStorage1 = new javax.swing.ButtonGroup();
        txtTools = new javax.swing.JLabel();
        txtProci = new javax.swing.JLabel();
        cmbProci = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmbMobo = new javax.swing.JComboBox<>();
        txtram = new javax.swing.JLabel();
        cmbRam = new javax.swing.JComboBox<>();
        txtvga = new javax.swing.JLabel();
        cmbvga = new javax.swing.JComboBox<>();
        txtpsu = new javax.swing.JLabel();
        cmbpsu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbhdd0 = new javax.swing.JRadioButton();
        rbssd0 = new javax.swing.JRadioButton();
        rbhdd1 = new javax.swing.JRadioButton();
        rbssd1 = new javax.swing.JRadioButton();
        cmbstor0 = new javax.swing.JComboBox<>();
        cmbstor1 = new javax.swing.JComboBox<>();
        txtcase = new javax.swing.JLabel();
        cmbCase = new javax.swing.JComboBox<>();
        txtbundle = new javax.swing.JLabel();
        chckkibot = new javax.swing.JCheckBox();
        chckmouse = new javax.swing.JCheckBox();
        chckspeaker = new javax.swing.JCheckBox();
        chckmonitor = new javax.swing.JCheckBox();
        chckkursi = new javax.swing.JCheckBox();
        chckmic = new javax.swing.JCheckBox();
        btnSetuju = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        chckDual = new javax.swing.JCheckBox();
        btnPesan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHasil = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTools.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        txtTools.setText("PC Build Tools");

        txtProci.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtProci.setText("Processor's");

        cmbProci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Intel Core i3 1315U", "Intel core i3 1305U", "Intel Core i5 13600HX", "Intel Core i7 13850HX", "AMD Ryzen 9 7950X3D", "AMD Ryzen 7 7800X3D", "AMD Ryzen 5 7600X", "AMD Ryzen 5 7500X" }));
        cmbProci.setToolTipText("");
        cmbProci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProciActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Motherboard");

        cmbMobo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "MSI MAG B760 TOMAHAWK WIFI intel", "Asus ROG MAXIMUS Z790 HERO intel", "Gigabyte Z790 AORUS ELITE AX intel", "MSI MEG Z790 GODLIKE MAX WIFI 7 intel", "MSI MEG X670E ACE AMD", "MSI MAG X670 TOMAHAWK WIFI AMD", "ASUS ROG Strix X670E-E Gaming WiFi AMD", "Gigabyte X670E AORUS MASTER AMD" }));

        txtram.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtram.setText("RAM");

        cmbRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Corsair Dominator Platinum RGB DDR5 16gb", "G.Skill Trident Z5 RGB DDR5 32gb", "Kingston FURY Beast DDR5 8gb", "MSI Spatium DDR5 16gb", " ", " " }));

        txtvga.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtvga.setText("Graphic Card");

        cmbvga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "MSI RTX 3090 Ti Suprim X", "MSI RTX 3070 Gaming X Trio", "MSI RTX 3060 Ventus 2X OC", "MSI RTX 4090 SUPRIM X" }));

        txtpsu.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtpsu.setText("PSU");

        cmbpsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Corsair RMx Series 1200W 80+ Gold", "Cooler Master V Gold 1000W 80+ Gold", " " }));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Storage 0");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Storage 1");

        groupStorage0.add(rbhdd0);
        rbhdd0.setText("HDD");

        groupStorage0.add(rbssd0);
        rbssd0.setText("SSD");

        groupStorage1.add(rbhdd1);
        rbhdd1.setText("HDD");

        groupStorage1.add(rbssd1);
        rbssd1.setText("SSD");

        cmbstor0.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "128gb", "256gb", "512gb", "1tb", "2tb" }));

        cmbstor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "128gb", "256gb", "512gb", "1tb", "2tb" }));

        txtcase.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtcase.setText("Case");

        cmbCase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "NZXT H510 Elite", "NZXT H510 Flow" }));

        txtbundle.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtbundle.setText("Bundle");

        chckkibot.setText("Keyboard");
        chckkibot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckkibotActionPerformed(evt);
            }
        });

        chckmouse.setText("Mouse + pad");

        chckspeaker.setText("Speaker");

        chckmonitor.setText("Monitor");

        chckkursi.setText("Gaming Chair");
        chckkursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckkursiActionPerformed(evt);
            }
        });

        chckmic.setText("Mic + Arm");
        chckmic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckmicActionPerformed(evt);
            }
        });

        btnSetuju.setText("Cek");
        btnSetuju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetujuActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");

        btnKeluar.setText("Keluar");

        chckDual.setText("Dual Channel");

        btnPesan.setText("Pesan");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        txtHasil.setColumns(20);
        txtHasil.setRows(5);
        jScrollPane2.setViewportView(txtHasil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtram)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chckDual))
                            .addComponent(txtvga))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbvga, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtpsu)
                                .addGap(126, 126, 126)
                                .addComponent(cmbpsu, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(57, 57, 57)
                                    .addComponent(cmbMobo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtProci)
                                    .addGap(70, 70, 70)
                                    .addComponent(cmbProci, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSetuju)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbhdd0)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbssd0))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbhdd1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbssd1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbstor1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbstor0, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcase)
                                .addGap(47, 47, 47)
                                .addComponent(cmbCase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtbundle)
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chckkibot)
                                            .addComponent(chckspeaker))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chckmouse)
                                            .addComponent(chckmonitor)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chckmic)
                                    .addComponent(chckkursi))))
                        .addContainerGap(93, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(txtTools)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTools)
                .addGap(228, 228, 228)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProci)
                        .addComponent(jLabel2)
                        .addComponent(rbhdd0)
                        .addComponent(rbssd0)
                        .addComponent(cmbstor0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbProci, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMobo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(rbhdd1)
                        .addComponent(rbssd1)
                        .addComponent(cmbstor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcase)
                    .addComponent(chckDual)
                    .addComponent(txtram)
                    .addComponent(cmbCase, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbundle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvga)
                            .addComponent(cmbvga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpsu)
                            .addComponent(cmbpsu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckkibot)
                            .addComponent(chckmouse)
                            .addComponent(chckkursi))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckspeaker)
                            .addComponent(chckmonitor)
                            .addComponent(chckmic))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSetuju, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chckkibotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckkibotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckkibotActionPerformed

    private void cmbProciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProciActionPerformed

    private void btnSetujuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetujuActionPerformed
        // TODO add your handling code here:
        //        processor
        pilihProcessor = cmbProci.getSelectedItem().toString();

        //        motherboard
        pilihMotherboard = cmbMobo.getSelectedItem().toString();

        //        Ram
        if (chckDual.isSelected()) {
            channel = "Dual Channel";
        } else {
            channel = "";
        }

        pilihRam = cmbRam.getSelectedItem().toString();

        //        graphiccard
        pilihGraphiccard = cmbvga.getSelectedItem().toString();

        //        psu
        pilihPsu = cmbpsu.getSelectedItem().toString();

        //        Storage0
        if (rbhdd0.isSelected()) {
            storage0 = "HDD";
        } else {
            storage0 = "SSD";
        }

        pilihStorage0 = cmbstor0.getSelectedItem().toString();

        //        Storage1
        if (rbhdd1.isSelected()) {
            storage1 = "HDD";
        } else {
            storage1 = "SSD";
        }

        pilihStorage1 = cmbstor1.getSelectedItem().toString();

//        case
        pilihCase = cmbCase.getSelectedItem().toString();

//        Bundle
        if (chckkibot.isSelected()) {
            kibot = "Keyboard";
        } else {
            kibot = "";
        }
        if (chckmouse.isSelected()) {
            mouse = "Mouse + Pad";
        } else {
            mouse = "";
        }
        if (chckkursi.isSelected()) {
            kursi = "Gaming Chair";
        } else {
            kursi = "";
        }
        if (chckspeaker.isSelected()) {
            speaker = "Speaker";
        } else {
            speaker = "";
        }
        if (chckmonitor.isSelected()) {
            monitor = "Monitor";
        } else {
            monitor = "";
        }
        if (chckmic.isSelected()) {
            mic = "Mic + ARM";
        } else {
            mic = "";
        }
        
        txtHasil.setText("Processor\t: " + pilihProcessor
                + "\nMotherboard\t: " + pilihMotherboard
                + "\nRam\t: " + channel + pilihRam
                + "\nGPU\t: " + pilihGraphiccard
                + "\nPSU\t: " + pilihPsu
                + "\nStorage0\t: " + storage0 + pilihStorage0
                + "\nStorage\t: " + storage1 + pilihStorage1
                + "\nCase\t: " + pilihCase
                + "\nBundle\t: " + "\n" + kibot + "\n" + mouse + "\n" + kursi + "\n" + speaker + "\n" + monitor + "\n" + mic);
    }//GEN-LAST:event_btnSetujuActionPerformed

    private void chckkursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckkursiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckkursiActionPerformed

    private void chckmicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckmicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckmicActionPerformed

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        // Mengambil input dari pengguna untuk data pelanggan
        String namaPelanggan = JOptionPane.showInputDialog(this, "Masukkan nama kamu ");
        String nomorPelanggan = JOptionPane.showInputDialog(this, "Masukkan nomor telepon ");
        String alamatPelanggan = JOptionPane.showInputDialog(this, "Masukkan alamat kamu ");

        // Mengambil dan menghitung total harga
        long totalHarga = calculateTotal();

        // Menampilkan pesan konfirmasi dengan nama pelanggan dan total harga
        JOptionPane.showMessageDialog(this, "Nama       : " + namaPelanggan
                + "\nNo   : " + nomorPelanggan
                + "\nAlamat       : " + alamatPelanggan
                + "\nTotal Harga yang harus dibayar: Rp " + totalHarga);
    }//GEN-LAST:event_btnPesanActionPerformed

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
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPesan;
    private javax.swing.JButton btnSetuju;
    private javax.swing.JCheckBox chckDual;
    private javax.swing.JCheckBox chckkibot;
    private javax.swing.JCheckBox chckkursi;
    private javax.swing.JCheckBox chckmic;
    private javax.swing.JCheckBox chckmonitor;
    private javax.swing.JCheckBox chckmouse;
    private javax.swing.JCheckBox chckspeaker;
    private javax.swing.JComboBox<String> cmbCase;
    private javax.swing.JComboBox<String> cmbMobo;
    private javax.swing.JComboBox<String> cmbProci;
    private javax.swing.JComboBox<String> cmbRam;
    private javax.swing.JComboBox<String> cmbpsu;
    private javax.swing.JComboBox<String> cmbstor0;
    private javax.swing.JComboBox<String> cmbstor1;
    private javax.swing.JComboBox<String> cmbvga;
    private javax.swing.ButtonGroup groupProcessor;
    private javax.swing.ButtonGroup groupStorage0;
    private javax.swing.ButtonGroup groupStorage1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbhdd0;
    private javax.swing.JRadioButton rbhdd1;
    private javax.swing.JRadioButton rbssd0;
    private javax.swing.JRadioButton rbssd1;
    private javax.swing.JTextArea txtHasil;
    private javax.swing.JLabel txtProci;
    private javax.swing.JLabel txtTools;
    private javax.swing.JLabel txtbundle;
    private javax.swing.JLabel txtcase;
    private javax.swing.JLabel txtpsu;
    private javax.swing.JLabel txtram;
    private javax.swing.JLabel txtvga;
    // End of variables declaration//GEN-END:variables
}
