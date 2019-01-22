/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harlit
 */
public class buyMedicine extends javax.swing.JFrame {
    
     private int balance;
     
     public buyMedicine(int xBalance)
     {
      this.balance= xBalance;
     }
    
     public int getBal()
        {
            return balance;
        }
    
    double med[] = new double[10];
    double i[] = new double[10]; 
    
    double cTotal=0;
    
    String iTotal="";
    /**
     * Creates new form patient1
     */
    public buyMedicine() {
        initComponents();
        getConnection();
       getConnection1();
    }
    
    
    public Connection getConnection()
    {
        Connection con = null;
        Connection con1 = null;
        try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","");
            //JOptionPane.showMessageDialog(null, "Connected");
            return con;
                    
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(buyMedicine.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Not Connected");
            return null;
        }   
    }
    
     public Connection getConnection1()
    {
        
        Connection con1 = null;
        try 
        {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
            //JOptionPane.showMessageDialog(null, "Connected");
            return con1;
                    
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(buyMedicine.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Not Connected");
            return null;
        }   
    }
    
    public boolean checkInputs()
    {
       if(
                  jTextField6.getText() == null 
                || jTextField2.getText() == null
                || jTextField3.getText() == null
                || jTextField4.getText() == null
                || jTextField5.getText() == null
          )
        {
            return false;
        }  
        else
       {    
           return true;
       }
    }
    
    public ArrayList<buyMedicine> getBalance()
    {
        ArrayList<buyMedicine> List = new ArrayList<buyMedicine>();
        Connection con1 = getConnection1();
        
        String query = "SELECT balance FROM bankAcount where accountNo=901";
        
        
        Statement st;
        ResultSet rs;
        
        try
        {
            st = con1.createStatement();
            rs =  st.executeQuery(query);
           buyMedicine bal;
            
            while (rs.next())
            {
                bal =  new buyMedicine(rs.getInt("balance"));
               List.add(bal);
            }
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, " Not working");
                    Logger.getLogger(pharmaPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
        return List;
    }
    
    public void showBalance()
   {
       ArrayList<buyMedicine> list1 = getBalance();
       
       Object[] row = new Object[1];
       for (int i=0; i<list1.size();i++)
        {   
            row[0] = list1.get(i).getBal();
        }    
       
       
       
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("0");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField2.setText("0");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("0");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setText("0");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setText("0");

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pay Now");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Alvin");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Vicks");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("iodex");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("MinPain");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("Dcold");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Crosin");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 40)); // NOI18N
        jLabel7.setText("Pharmacy System");

        jLabel1.setText("Customer Name");

        jLabel2.setText("Account No");

        jLabel3.setText("Phone Number");

        jButton5.setText("Calculate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Sub Total");

        jLabel5.setText("Tax");

        jLabel6.setText("Total Amount");

        jLabel8.setText("0");
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setText("0");
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setText("0");
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox6)
                                    .addComponent(jCheckBox5))
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))
                        .addGap(86, 86, 86)
                        .addComponent(jButton5)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(45, 45, 45)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox1))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(jTextField11)
                                    .addComponent(jTextField10)))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(13, 13, 13))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel7)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jCheckBox4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox6))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addContainerGap(25, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox5)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton5)
                                    .addComponent(jButton1))
                                .addGap(35, 35, 35))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        login2 field = new login2();
                field.setVisible(true);
                setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        jTextField1.setText("0");
        jTextField2.setText("0");
        jTextField3.setText("0");
        jTextField4.setText("0");
        jTextField5.setText("0");
        jTextField6.setText("0");
        jTextField10.setText("0");
        jTextField11.setText("0");
        jTextField12.setText("0");  
        
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox5.setSelected(false);
        
        
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        Connection con = getConnection();
        double cAlvin = Double.parseDouble(jLabel8.getText());
        double Alvin = Double.parseDouble(jTextField1.getText());
        double iAlvin = 8;//Double.parseDouble("SELECT price from medicine where medicineID=701");
        
        
        if(jCheckBox1.isSelected())
            
        {
            i[0] = (Alvin*iAlvin)+cAlvin;
            String pAlvin = String.format("%.2f",i[0]);
            jLabel8.setText(pAlvin);
            //jTextField1.setText(pAlvin);
            
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            
        med[0] = Double.parseDouble(jLabel8.getText());
        
        double subTotal = med[0];
        String iSubTotal = String.format("%.2f",subTotal); 
        jLabel8.setText(iSubTotal);
        
        double tex = (med[0]*10)/100;
        String iTex = String.format("%.2f",tex); 
        jLabel9.setText(iTex);
        
        cTotal = (med[0] + tex);
         iTotal = String.format("%.2f",cTotal); 
        jLabel10.setText(iTotal);
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        
        Connection con = getConnection();
        double cAlvin = Double.parseDouble(jLabel8.getText());
        double Alvin = Double.parseDouble(jTextField2.getText());
        double iAlvin = 5;//Double.parseDouble("SELECT price from medicine where medicineID=701");
        
        
        if(jCheckBox2.isSelected())
            
        {
            i[1] = (Alvin*iAlvin)+cAlvin;
            String pAlvin = String.format("%.2f",i[1]);
            jLabel8.setText(pAlvin);
            //jTextField2.setText(pAlvin);
            
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
       
        Connection con = getConnection();
        double cAlvin = Double.parseDouble(jLabel8.getText());
        double Alvin = Double.parseDouble(jTextField3.getText());
        double iAlvin = 10;//Double.parseDouble("SELECT price from medicine where medicineID=701");
        
        
        if(jCheckBox3.isSelected())
            
        {
            i[2] = (Alvin*iAlvin)+cAlvin;
            String pAlvin = String.format("%.2f",i[2]);
            jLabel8.setText(pAlvin);
            //jTextField2.setText(pAlvin);
            
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        
        
        Connection con = getConnection();
        double cAlvin = Double.parseDouble(jLabel8.getText());
        double Alvin = Double.parseDouble(jTextField4.getText());
        double iAlvin = 14;//Double.parseDouble("SELECT price from medicine where medicineID=701");
        
        
        if(jCheckBox4.isSelected())
            
        {
            i[3] = (Alvin*iAlvin)+cAlvin;
            String pAlvin = String.format("%.2f",i[3]);
            jLabel8.setText(pAlvin);
            //jTextField2.setText(pAlvin);
            
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
       
        
        Connection con = getConnection();
        double cAlvin = Double.parseDouble(jLabel8.getText());
        double Alvin = Double.parseDouble(jTextField5.getText());
        double iAlvin = 1;//Double.parseDouble("SELECT price from medicine where medicineID=701");
        
        
        if(jCheckBox5.isSelected())
            
        {
            i[4] = (Alvin*iAlvin)+cAlvin;
            String pAlvin = String.format("%.2f",i[4]);
            jLabel8.setText(pAlvin);
            //jTextField2.setText(pAlvin);
            
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
     
        
        Connection con = getConnection();
        double cAlvin = Double.parseDouble(jLabel8.getText());
        double Alvin = Double.parseDouble(jTextField6.getText());
        double iAlvin = 50;//Double.parseDouble("SELECT price from medicine where medicineID=701");
        
        
        if(jCheckBox6.isSelected())
            
        {
            i[5] = (Alvin*iAlvin)+cAlvin;
            String pAlvin = String.format("%.2f",i[5]);
            jLabel8.setText(pAlvin);
            //jTextField2.setText(pAlvin);
            
        }
        
        
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
     if(jTextField11.getText() != null)   
     { 
        
        String cName = jTextField10.getText();
        String accNO = jTextField11.getText();
        String phNO = jTextField12.getText();
        
        
        
        
        
      try{
          
          Connection con1 = getConnection1();
          
          ArrayList<buyMedicine> list1 = getBalance();
       
       Object[] row2 = new Object[1];
       for (int i=0; i<list1.size();i++)
        {   
            row2[0] = list1.get(i).getBal();
        }    
       
       double bal = getBalance().get(0).getBal();  
                  
                 String updateQuery = "UPDATE bankAcount SET balance = ? WHERE accountNo= ?";
               PreparedStatement ps = con1.prepareStatement(updateQuery);
        
        if(bal>=300)
        {
          
            int fbal = (int) (bal - cTotal);
             ps.setInt(1,fbal );
            ps.setInt(2,Integer.parseInt(jTextField11.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updation Sucessful!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Insuffiecient Balance!!!");
        }
        
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "Updation Unsucessful!!!");
          
          jTextField10.setText("");
          jTextField11.setText("");
          jTextField12.setText("");
          
      };
     }
     else
     {
         JOptionPane.showMessageDialog(null, "One or more fields are Empty...!");
     }
     
     
     
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(buyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buyMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}