package hotel_mg.frames;

import java.beans.PropertyVetoException;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Accueil extends javax.swing.JFrame {
    
    Date actuelle=new Date();
    DateFormat dateformate=new SimpleDateFormat("EEEEE, dd MMM yyyy") ;
  String date=dateformate.format(actuelle);

    
   home_internal_frame hif=new home_internal_frame();
    public Accueil() {
       
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("hotel.png")).getImage());
        dateAndtime();
        


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        date_lab = new javax.swing.JLabel();
        desk = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        orders = new javax.swing.JButton();
        rooms = new javax.swing.JButton();
        booking = new javax.swing.JButton();
        time_label = new javax.swing.JLabel();
        disconnect = new javax.swing.JLabel();
        home_bt = new javax.swing.JButton();
        guests_bt = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOTEL_NAME");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1366, 720));
        setMinimumSize(new java.awt.Dimension(1300, 650));
        setPreferredSize(new java.awt.Dimension(1366, 720));
        setSize(new java.awt.Dimension(1366, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 255, 102));
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/title.png"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1330, 70));

        date_lab.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 3, 24)); // NOI18N
        date_lab.setForeground(new java.awt.Color(51, 51, 51));
        date_lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(date_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, 300, 30));

        desk.setBackground(new java.awt.Color(204, 204, 255));
        desk.setOpaque(false);

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        getContentPane().add(desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 1050, 520));
        desk.getAccessibleContext().setAccessibleName("");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        orders.setBackground(new java.awt.Color(182, 223, 251));
        orders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/ORDERS.jpg"))); // NOI18N
        orders.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        orders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orders.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });

        rooms.setBackground(new java.awt.Color(182, 223, 251));
        rooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/ROOMS.jpg"))); // NOI18N
        rooms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rooms.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rooms.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsActionPerformed(evt);
            }
        });

        booking.setBackground(new java.awt.Color(182, 223, 251));
        booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/BOOKING.jpg"))); // NOI18N
        booking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        booking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        booking.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        booking.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingActionPerformed(evt);
            }
        });

        time_label.setFont(new java.awt.Font("Microsoft PhagsPa", 3, 16)); // NOI18N
        time_label.setForeground(new java.awt.Color(102, 102, 102));
        time_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        disconnect.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        disconnect.setForeground(new java.awt.Color(0, 51, 255));
        disconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/log_out_1.png"))); // NOI18N
        disconnect.setText("Disconnect");
        disconnect.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        disconnect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disconnect.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        disconnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disconnectMouseClicked(evt);
            }
        });

        home_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/HOME_BT.jpg"))); // NOI18N
        home_bt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        home_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_btActionPerformed(evt);
            }
        });

        guests_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/guest.jpg"))); // NOI18N
        guests_bt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        guests_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guests_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guests_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(disconnect)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(home_bt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(booking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rooms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(guests_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(time_label, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(time_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(home_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(booking, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guests_bt)
                .addGap(26, 26, 26)
                .addComponent(disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {guests_bt, orders});

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 520));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_mg/imgs/bg1.1.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 730));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 80, 130, -1));

        setSize(new java.awt.Dimension(1382, 684));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingActionPerformed

         this.desk.removeAll();
         this.desk.setVisible(true);
         this.desk.repaint();
          Reservation1 rev=new Reservation1();
              this.desk.add(rev);
        try {
           rev.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
             rev.show();
    }//GEN-LAST:event_bookingActionPerformed
    
    private void roomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsActionPerformed
         this.desk.removeAll();
         this.desk.repaint();
          this.desk.setVisible(true);
        Rooms_list room_list=new Rooms_list();
        this.desk.add(room_list);
        try {
            room_list.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        room_list.show();
     
    }//GEN-LAST:event_roomsActionPerformed

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        Send_orders order=new Send_orders();
        this.desk.removeAll();
        this.desk.repaint();
         this.desk.setVisible(true);
        this.desk.add(order);
        try{
            order.setMaximum(true);
           }catch(Exception e){
               Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, e);
           }
        order.show();
    }//GEN-LAST:event_ordersActionPerformed

    private void disconnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disconnectMouseClicked
           if(JOptionPane.showConfirmDialog(null,"you realy want to disconect ? ", "yes",JOptionPane.YES_NO_OPTION)==0){
            this.dispose();
            new login_usr().setVisible(true);
        }
    }//GEN-LAST:event_disconnectMouseClicked

    private void home_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btActionPerformed
        this.desk.removeAll();
        this.desk.repaint();
        this.desk.setVisible(false);

    }//GEN-LAST:event_home_btActionPerformed

    private void guests_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guests_btActionPerformed
        Guest_info guest=new Guest_info();
        this.desk.removeAll();
        this.desk.repaint();
        this.desk.setVisible(true);
        this.desk.add(guest);
        try{
            guest.setMaximum(true);
        }catch(Exception e){
               Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, e);
           }
        guest.show();
    }//GEN-LAST:event_guests_btActionPerformed

        public void dateAndtime(){
            date_lab.setText(date);
        Thread clock=new Thread(){
            public void run(){
                for(;;){

                    Date date_now = new Date();
                    DateFormat dateformate = new SimpleDateFormat("HH:mm:ss");
                    String now = dateformate.format(date_now);
                    time_label.setText(now);
                    

                    try{
                        sleep(1000);
                    }catch(InterruptedException e){
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();
        }
    
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton booking;
    private javax.swing.JLabel date_lab;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JLabel disconnect;
    private javax.swing.JButton guests_bt;
    private javax.swing.JButton home_bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton orders;
    private javax.swing.JButton rooms;
    private javax.swing.JLabel time_label;
    // End of variables declaration//GEN-END:variables
}