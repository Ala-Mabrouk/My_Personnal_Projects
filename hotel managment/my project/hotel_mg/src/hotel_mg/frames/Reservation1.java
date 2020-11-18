
package hotel_mg.frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
       
    
    public class Reservation1 extends javax.swing.JInternalFrame {

        Connection conn=null;
        ResultSet res=null;
        PreparedStatement st=null;

    public Reservation1() {
        conn=Connexion_BD.connect_BD();
        initComponents();
        showReservation_list();
        
        
    }
    private void showReservation_list(){
        try{
        st=conn.prepareStatement("Select r.id_rev as reservation_id,r.id_room as room_id,g.f_name,g.last_name"
                + ",DATE_FORMAT(r.d_begin, \"%D %b %Y\") as reserved_from,DATE_FORMAT(r.d_end, \"%D %b %Y\") as reserved_to"
                + " from reservation r,guest g where r.cin_guest=g.cin and g_check_out IS NULL ");
        res=st.executeQuery();
        reservation_list_table.setModel(DbUtils.resultSetToTableModel(res));

            res.close();
            st.close();
        }
        catch(Exception e){
            System.out.println("-->>"+e);
        }
        
    }
    private void find(){
        
            String req="Select r.id_rev as reservation_id,r.id_room as room_id,g.f_name,g.last_name"
                + ",DATE_FORMAT(r.d_begin, \"%D %b %Y\") as reserved_from,DATE_FORMAT(r.d_end, \"%D %b %Y\") as reserved_to from reservation r,guest g where r.cin_guest=g.cin "
                    + "and g.f_name LIKE ? and r.g_check_out IS NULL  ";
             
            try {
                st=conn.prepareStatement(req);
                st.setString(1,f_name_jTextField1.getText()+"%");
           
            res=st.executeQuery();
            reservation_list_table.setModel(DbUtils.resultSetToTableModel(res));
 
            res.close();
            st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Reservation1.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        reservation_list_table = new javax.swing.JTable();
        cancel_resv_bt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        f_name_jTextField1 = new javax.swing.JTextField();
        check_in_bt = new javax.swing.JButton();
        check_out_bt = new javax.swing.JButton();
        refrech_bt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        clientname_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        roomtypelabel = new javax.swing.JLabel();
        nbnightslabel = new javax.swing.JLabel();
        rommviewlabel = new javax.swing.JLabel();
        roombedslabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        setTitle("Reservation");
        setMinimumSize(new java.awt.Dimension(1130, 490));
        setPreferredSize(new java.awt.Dimension(1130, 490));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        reservation_list_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        reservation_list_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                reservation_list_tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(reservation_list_table);

        cancel_resv_bt.setText("cancel");
        cancel_resv_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_resv_btActionPerformed(evt);
            }
        });

        jLabel2.setText("guest name");

        f_name_jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_name_jTextField1KeyReleased(evt);
            }
        });

        check_in_bt.setText("check in");
        check_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_in_btActionPerformed(evt);
            }
        });

        check_out_bt.setText("check out");
        check_out_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_out_btActionPerformed(evt);
            }
        });

        refrech_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/green_refrech.png"))); // NOI18N
        refrech_bt.setFocusable(false);
        refrech_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrech_btActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setText(" Mr ");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel4.setText("Staying for");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel6.setText(" Room view :");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/guest-1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setText("Room type :");

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel9.setText("Beds :");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel5.setText("Nights");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clientname_label, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roombedslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nbnightslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 83, Short.MAX_VALUE)
                                .addComponent(roomtypelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rommviewlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(jLabel8)))
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clientname_label, rommviewlabel, roombedslabel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(clientname_label)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nbnightslabel)
                                .addComponent(jLabel4))
                            .addGap(12, 12, 12))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)))
                    .addComponent(roomtypelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(rommviewlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roombedslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clientname_label, jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, jLabel9, nbnightslabel, rommviewlabel, roombedslabel, roomtypelabel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_name_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(cancel_resv_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(check_in_bt)
                                .addGap(52, 52, 52)
                                .addComponent(check_out_bt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(refrech_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel_resv_bt, check_in_bt, check_out_bt});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refrech_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(f_name_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_resv_bt)
                    .addComponent(check_in_bt)
                    .addComponent(check_out_bt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancel_resv_bt, check_in_bt, check_out_bt});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {f_name_jTextField1, jLabel2});

        pack();
    }// </editor-fold>//GEN-END:initComponents
static String v_id_rev,v_id_room,v_checkout,v_checkin;
static int nb_nights;
int row;
    private void cancel_resv_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_resv_btActionPerformed
       try{
        String client_name="";
         row=reservation_list_table.getSelectedRow();
        v_id_rev=(reservation_list_table.getModel().getValueAt(row, 0).toString());
        v_checkout=(reservation_list_table.getModel().getValueAt(row, 5).toString());
        
        client_name=reservation_list_table.getModel().getValueAt(row, 2).toString()+" "+reservation_list_table.getModel().getValueAt(row, 3).toString();
 
        if(JOptionPane.showConfirmDialog(null,"you realy want to cancel "+client_name+" reservation ?", "confirm",JOptionPane.YES_NO_OPTION)==0){
        st=conn.prepareStatement("delete from reservation where id_rev="+v_id_rev);
       st.execute();
            System.out.println("deleted");
            st=conn.prepareStatement("update table room set reserved=0 where id_room="+v_id_room);
            st.executeUpdate();
              System.out.println("room unreserved done !!!");
                 showReservation_list();
        }
        

            res.close();
            st.close();
              showReservation_list();
         check_in_bt.setEnabled(false);
        check_out_bt.setEnabled(false);
        cancel_resv_bt.setEnabled(false);
        }
        catch(Exception e){
            System.out.println("-->>"+e);
        }
              
    }//GEN-LAST:event_cancel_resv_btActionPerformed

    private void f_name_jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_name_jTextField1KeyReleased
       find();
    }//GEN-LAST:event_f_name_jTextField1KeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cancel_resv_bt.setEnabled(false);
        check_in_bt.setEnabled(false);
        check_out_bt.setEnabled(false);
 
    }//GEN-LAST:event_formInternalFrameOpened

    
    private void reservation_list_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservation_list_tableMouseReleased
                  move_data();
                  cancel_resv_bt.setEnabled(true);
                
                  
            try {
                st=conn.prepareStatement("select g_check_in from reservation where id_rev="+v_id_rev);
                res=st.executeQuery();
                if(res.next()){
                    res.getString("g_check_in");
                if(res.wasNull()){
                     check_in_bt.setEnabled(true);
                        check_out_bt.setEnabled(false);
                        }
                else{
                        check_in_bt.setEnabled(false);
                        check_out_bt.setEnabled(true);
                }
                
            res.close();
            st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Reservation1.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                  
                 

    }//GEN-LAST:event_reservation_list_tableMouseReleased

    private void check_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_in_btActionPerformed
        row=reservation_list_table.getSelectedRow();
       v_id_rev=(reservation_list_table.getModel().getValueAt(row, 0).toString());
        v_checkout=(reservation_list_table.getModel().getValueAt(row, 5).toString());
        v_id_room=(reservation_list_table.getModel().getValueAt(row, 1).toString());

        new Cheking_in_form().setVisible(true);
          showReservation_list();
         check_in_bt.setEnabled(false);
        check_out_bt.setEnabled(false);
        cancel_resv_bt.setEnabled(false);
    }//GEN-LAST:event_check_in_btActionPerformed

    private void refrech_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrech_btActionPerformed
        showReservation_list();
         check_in_bt.setEnabled(false);
        check_out_bt.setEnabled(false);
        cancel_resv_bt.setEnabled(false);
        f_name_jTextField1.setText("");
        setEmty();
        
    }//GEN-LAST:event_refrech_btActionPerformed
 
    
    private void setEmty(){
        clientname_label.setText("");
        roomtypelabel.setText("");
        nbnightslabel.setText("");
        rommviewlabel.setText("");
        roombedslabel.setText("");
    }
    private void check_out_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_out_btActionPerformed
 
        row=reservation_list_table.getSelectedRow();
       v_id_rev=(reservation_list_table.getModel().getValueAt(row, 0).toString());
        v_checkout=(reservation_list_table.getModel().getValueAt(row, 5).toString());
        v_id_room=(reservation_list_table.getModel().getValueAt(row, 1).toString());
        
        new Check_out_form().setVisible(true);
        showReservation_list();
                 check_in_bt.setEnabled(false);
        check_out_bt.setEnabled(false);
        cancel_resv_bt.setEnabled(false);
    }//GEN-LAST:event_check_out_btActionPerformed
  

    
    private void move_data(){

        String client_name="";
        int row=reservation_list_table.getSelectedRow();
        Reservation1.v_id_rev=(reservation_list_table.getModel().getValueAt(row, 0).toString());
        
        client_name=reservation_list_table.getModel().getValueAt(row, 2).toString()+" "+reservation_list_table.getModel().getValueAt(row, 3).toString();
        clientname_label.setText(client_name);
        
        try{
            String req1="select type_r,beds,view from room where id_room="+reservation_list_table.getModel().getValueAt(row, 1).toString();
            st=conn.prepareStatement(req1);
            res=st.executeQuery();
         if(res.next()){
                roomtypelabel.setText(res.getString("type_r"));
                roombedslabel.setText(res.getString("beds"));
                rommviewlabel.setText(res.getString("view"));
           }
           
            String req2="select datediff(d_begin,d_end),g_check_in,g_check_out from reservation where id_rev="+v_id_rev;
                    
            st=conn.prepareStatement(req2);
            res=st.executeQuery();
            
            if(res.next()){
                
            nb_nights=Math.abs(res.getInt(1));
            nbnightslabel.setText(""+nb_nights);
 
            res.close();
            st.close();
            }
            
        }catch(Exception e){
            System.out.println(e);
            
        }
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_resv_bt;
    private javax.swing.JButton check_in_bt;
    private javax.swing.JButton check_out_bt;
    private javax.swing.JLabel clientname_label;
    private javax.swing.JTextField f_name_jTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nbnightslabel;
    private javax.swing.JButton refrech_bt;
    private javax.swing.JTable reservation_list_table;
    private javax.swing.JLabel rommviewlabel;
    private javax.swing.JLabel roombedslabel;
    private javax.swing.JLabel roomtypelabel;
    // End of variables declaration//GEN-END:variables
}
