import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

class Main extends JFrame {

  private final String ALL_NUMBERS = "^[0-9]+$";
  private final int[] NUMS = { 1, 3, 5, 7, 10, 15, 30, 50 };

      public Main() {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        JFrame frame = new JFrame("Demo");
        frame.setSize(550, 600);
        //Calculate the frame location
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        //Set the new frame location
        frame.setLocation(x, y);
        setLocation(x, y);
        super.setTitle("Калькулятор процентов на Java");
      }


      @SuppressWarnings("unchecked")
      private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jButton1.setText("Посчитать");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);


        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jLabel1.setText("Поле ввода суммы:");

        Action action = new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              String input = jTextField1.getText();
              String input2 = jTextField2.getText();
              if (jTextField1.getText().matches(ALL_NUMBERS) && jTextField2.getText().matches(ALL_NUMBERS)) {
                int percent = Integer.parseInt(input2);
                if (percent > 99)
                {
                  jTextArea1.setText("");
                  jTextField2.setText("");
                  jTextField1.setText("");
                  jTextArea1.setText("А ты я вижу смешной. Зачем больше 100% ?");
                }
              }
              else if (jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
                jTextArea1.setText("");
                jTextField2.setText("");
                jTextField1.setText("");
                jTextArea1.setText("И какой смысл?");
              }
              else if (jTextField1.getText().equals("") && jTextField2.getText().matches(ALL_NUMBERS)) {
                jTextArea1.setText("");
                jTextField2.setText("");
                jTextField1.setText("");
                jTextArea1.setText("Неизвестно из какой суммы высчитывать %");
              }
              if (!jTextField1.getText().equals("") && jTextField2.getText().equals("") && jTextField1.getText().matches(ALL_NUMBERS)) {
                jTextArea1.setText("");
                jTextField2.setText("");
                // jTextField1.setText("");
                double result = 0.0;
                int sum = 0;
                int str = Integer.parseInt(input);
                for (int j = 0; j < NUMS.length; j++) {
                  sum = NUMS[j];
                  result = str * sum / 100;
                  DecimalFormat formatter = new DecimalFormat("0");
                  jTextArea1.append(sum + "%" + GetPercentAddition(sum) + " от " + jTextField1.getText() + " = " + formatter.format(result) + " руб." + "\n");

                }
                jTextField1.setText("");
              }
              else if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && jTextField1.getText().matches(ALL_NUMBERS) && jTextField2.getText().matches(ALL_NUMBERS)) {
                jTextArea1.setText("");
                int str2 = Integer.parseInt(input);
                int str3 = Integer.parseInt(input2);
                int result2 = str2 * str3 / 100;
                DecimalFormat formatter2 = new DecimalFormat("0");
                jTextArea1.append(str3 + "%" + GetPercentAddition(result2) + " от " + jTextField1.getText() + " = " + formatter2.format(result2) + " руб." + "\n");
              }
            }  catch (Exception ee) {
              jTextArea1.append(ee.getMessage() + "\n");
              ee.printStackTrace();
            }
          }
        };
        jTextField1.addActionListener(action);
        jTextField2.addActionListener(action);


        jButton1.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
              String input = jTextField1.getText();
              String input2 = jTextField2.getText();
              if (jTextField1.getText().matches(ALL_NUMBERS) && jTextField2.getText().matches(ALL_NUMBERS)) {
                int percent = Integer.parseInt(input2);
                if (percent > 99)
                {
                  jTextArea1.setText("");
                  jTextField2.setText("");
                  jTextField1.setText("");
                  jTextArea1.setText("А ты я вижу смешной. Зачем больше 100% ?");
                }
              }

            else if (jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
              jTextArea1.setText("");
              jTextField2.setText("");
              jTextField1.setText("");
              jTextArea1.setText("И какой смысл?");
            }
            else if (jTextField1.getText().equals("") && jTextField2.getText().matches(ALL_NUMBERS)) {
              jTextArea1.setText("");
              jTextField2.setText("");
              jTextField1.setText("");
              jTextArea1.setText("Неизвестно из какой суммы высчитывать %");
            }
             if (!jTextField1.getText().equals("") && jTextField2.getText().equals("") && jTextField1.getText().matches(ALL_NUMBERS)) {
              jTextArea1.setText("");
              jTextField2.setText("");
             // jTextField1.setText("");
                double result = 0.0;
                int sum = 0;
                int str = Integer.parseInt(input);
                for (int j = 0; j < NUMS.length; j++) {
                  sum = NUMS[j];
                  result = str * sum / 100;
                  DecimalFormat formatter = new DecimalFormat("0");
                  jTextArea1.append(sum + "%" + GetPercentAddition(sum) + " от " + jTextField1.getText() + " = " + formatter.format(result) + " руб." + "\n");

                }
               jTextField1.setText("");
              }
              else if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && jTextField1.getText().matches(ALL_NUMBERS) && jTextField2.getText().matches(ALL_NUMBERS)) {
                jTextArea1.setText("");
                int str2 = Integer.parseInt(input);
                int str3 = Integer.parseInt(input2);
                int result2 = str2 * str3 / 100;
                DecimalFormat formatter2 = new DecimalFormat("0");
                jTextArea1.append(str3 + "%" + GetPercentAddition(result2) + " от " + jTextField1.getText() + " = " + formatter2.format(result2) + " руб." + "\n");
                 }
              }  catch (Exception e) {
              jTextArea1.append(e.getMessage() + "\n");
              e.printStackTrace();
            }
          }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jLabel2.setText("Поле вывода:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField2ActionPerformed(evt);
          }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jLabel3.setText("Свой %");

        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jButton2.setText("Очистка");
        jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            jTextArea1.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
          }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(113, 113, 113))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton1)))))
                            .addGap(0, 14, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
      }// </editor-fold>

  private String GetPercentAddition(int num) {
    int preLastDigit = num % 100 / 10;
    if (preLastDigit == 1) {
      return " процентов";
    }

    switch (num % 10) {
      case 1:
        return " процент";
      case 2:
      case 3:
        return " процента";
      case 10:
        return " процентов";
      case 50:
        return " процентов";
      default:
        return " процентов";
    }
  }

  private void jButton1ActionPerformed(ActionEvent evt) {

  }

  private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
      }

      /**
       * @param args the command line arguments
       */
      public static void main(String[] args) {
        try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
              javax.swing.UIManager.setLookAndFeel(info.getClassName());
              break;
            }
          }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
            new Main().setVisible(true);
          }
        });
      }

      // Variables declaration - do not modify
      private javax.swing.JButton jButton1;
      private javax.swing.JButton jButton2;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JTextArea jTextArea1;
      private javax.swing.JTextField jTextField1;
      private javax.swing.JTextField jTextField2;
      // End of variables declaration
    }
