import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfata extends JFrame implements ActionListener, KeyListener {

  JButton button1;
  JButton button2;
  JButton button3;
  JLabel[][] label = new JLabel[9][9];
  JLabel[][] label1 = new JLabel[9][9];
  JLabel label2 = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label4 = new JLabel();
  JPanel pan = new JPanel();
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JTextField[][] field = new JTextField[9][9];
  String[] string = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
  String field1;
  String field2;
  boolean Terminat;
  int n = 0;
  int verificare = 0;

  public void creare() {
    Constructie constructie = new Constructie();
    constructie.Matrice();
    int[][] matrice = constructie.getMatrice();

    pan.setBounds(50, 70, 350, 350);
    pan.setLayout(new GridLayout(9, 9, 1, 1));

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        label[i][j] = new JLabel();
        label[i][j].setHorizontalAlignment(JLabel.CENTER);
        label[i][j].setVerticalAlignment(JLabel.CENTER);
        label[i][j].setBorder(BorderFactory.createEmptyBorder());
        label[i][j].setSize(10, 10);
        label[i][j].setOpaque(true);
        label[i][j].setText(String.valueOf(matrice[i][j]));
        pan.add(label[i][j]);
        label[i][j].setBackground(Color.WHITE);
        if ((j + 1) % 3 == 0 && (j + 1) != 9) {
          label[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK));

        }
        if ((i + 1) % 3 == 0 && (i + 1) != 9) {
          label[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));

        }

        if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0 && (j + 1) != 9 && (i + 1) != 9) {
          label[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, Color.BLACK));

        }

      }
    }
    pan.setVisible(false);

  }

  private void gaseste0(JLabel[][] NewLabel, JPanel NewPanel) {

    panel.setBounds(125, 70, 350, 350);
    panel.setLayout(new GridLayout(9, 9, 3, 3));
    panel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.BLACK));
    panel.setBackground(Color.BLACK);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (NewLabel[i][j].getText().equals("0")) {
          field[i][j] = new JTextField();
          field[i][j].setHorizontalAlignment(JLabel.CENTER);
          field[i][j].setBorder(BorderFactory.createEmptyBorder());
          field[i][j].setSize(10, 10);
          field[i][j].setBackground(Color.WHITE);
          panel.add(field[i][j]);
          field[i][j].addKeyListener(this);

          if ((j + 1) % 3 == 0 && (j + 1) != 9) {
            field[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK));

          }
          if ((i + 1) % 3 == 0 && (i + 1) != 9) {
            field[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));

          }

          if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0 && (j + 1) != 9 && (i + 1) != 9) {
            field[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, Color.BLACK));

          }
        } else {
          panel.add(NewLabel[i][j]);

        }

      }
    }

    this.add(panel);
    panel.setVisible(true);
  }

  private void reset(JPanel NewPanel) {

    NewPanel.removeAll();
    NewPanel.revalidate();
    NewPanel.repaint();
    NewPanel.setVisible(false);

  }

  public void JocTerminat() {

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (field[i][j] != null) {
          if (!field[i][j].getText().isEmpty()) {
            Terminat = true;
          } else {
            Terminat = false;
            break;
          }
        }
      }
    }

  }

  public Interfata() {

    ImageIcon icon = new ImageIcon("sudoku.png");

    label2.setIcon(icon);
    panel1.add(label2);
    panel1.setBounds(85, 180, 450, 250);
    panel1.setBackground(new Color(255, 204, 0));
    this.add(panel1);

    panel2.setLayout(new BorderLayout());
    panel2.setBounds(85, 125, 450, 250);
    panel2.setVisible(false);

    DefaultListModel<String> model = new DefaultListModel<>();

    model.addElement("1.Fiecare rândnu trebuie să conțină decât o dată cifrele de la 1 la 9.");
    model.addElement("2.Fiecare coloana nu trebuie să conțină decât o dată cifrele de la 1 la 9.");
    model.addElement("3.Fiecare regiune de 3X3 nu trebuie să conțină decât o dată cifrele de la 1 la 9. ");

    JList<String> lista = new JList<>(model);

    label3.setText("Regurile jocului");
    label3.setHorizontalAlignment(JLabel.CENTER);
    panel2.add(label3, BorderLayout.NORTH);
    panel2.add(lista, BorderLayout.CENTER);

    this.add(panel2);

    this.setTitle("Sudoku");
    this.setLayout(null);
    this.setResizable(false);
    this.setLocation(100, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    button1 = new JButton("Joc nou");
    button1.setBounds(350, 500, 100, 50);
    button1.addActionListener(this);
    button1.setVisible(true);
    button1.setFocusable(false);
    this.add(button1);

    button2 = new JButton("Reguli");
    button2.setBounds(470, 500, 100, 50);
    button2.addActionListener(this);
    button2.setFocusable(false);
    this.add(button2);

    button3 = new JButton("Inapoi");
    button3.setBounds(350, 500, 100, 50);
    button3.addActionListener(this);
    button3.setFocusable(false);
    this.add(button3);

    this.setSize(650, 650);
    this.setVisible(true);
    this.getContentPane().setBackground(new Color(255, 204, 0));
    this.add(pan);
    this.addKeyListener(this);

  }

  @Override

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == button1) {
      button1.setVisible(false);
      button2.setVisible(false);
      button3.setVisible(true);
      creare();
      gaseste0(label, pan);
      panel1.setVisible(false);
      panel2.setVisible(false);

    }
    if (e.getSource() == button2) {

      button1.setVisible(false);
      button2.setVisible(false);
      button3.setVisible(true);
      panel1.setVisible(false);
      panel2.setVisible(true);
    }

    if (e.getSource() == button3) {

      button1.setVisible(true);
      button2.setVisible(true);
      button3.setVisible(false);
      panel1.setVisible(true);
      panel2.setVisible(false);
      reset(panel);
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int x = 0;
    int y = 0;
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          boolean Valid = false;
          if (e.getSource() == field[i][j] && field[i][j] != null) {

            for (String str : string) {

              if (field[i][j].getText().equals(str)) {
                Valid = true;
                break;
              }

            }
            if (Valid == false && verificare == 0) {

              verificare = 1;

              JOptionPane.showMessageDialog(this, "Numar invalid", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            x = i;
            y = j;

            break;

          }
        }
      }

      for (int i = 0; i < 9; i++) {
        String textIntrodus = field[x][y].getText();
        String textLabel1 = label[x][i].getText();
        String textLabel2 = label[i][y].getText();

        if ((x != i || y != i) && (textIntrodus.equals(textLabel1) || textIntrodus.equals(textLabel2))
            && verificare == 0) {

          verificare = 1;

          JOptionPane.showMessageDialog(this, "Miscare Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
          break;

        }

      }

      for (int i = 0; i < 9; i++) {
        String textIntrodus = field[x][y].getText();
        if (i != y && field[x][i] != null) {
          field1 = field[x][i].getText();
          if (textIntrodus.equals(field1) && !textIntrodus.equals("") && verificare == 0) {

            verificare = 1;

            JOptionPane.showMessageDialog(this, "Miscare Invalida", "ERROR", 0);
            break;

          }

        }

      }

      for (int i = 0; i < 9; i++) {
        String textIntrodus = field[x][y].getText();
        if (i != y && field[i][x] != null) {
          field1 = field[i][x].getText();
          if (textIntrodus.equals(field1) && !textIntrodus.equals("") && verificare == 0) {

            verificare = 1;

            JOptionPane.showMessageDialog(this, "Miscare Invalida", "ERROR", 0);
            break;

          }

        }

      }

      for (int i = 0; i < 3; i++) {
        String textIntrodus = field[x][y].getText();
        if (i != x && field[i][y] != null) {
          field2 = field[i][y].getText();
          if (textIntrodus.equals(field2) && !textIntrodus.equals("") && verificare == 0) {

            verificare = 1;

            JOptionPane.showMessageDialog(this, "Miscare Invalida", "ERROR", 0);
            break;

          }

        }

      }

      int subRand = x - x % 3;
      int subColoana = y - y % 3;

        String textIntrodus = field[x][y].getText();

        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            if (x != i && j != y) {
              String textLabel = label[subRand + i][subColoana + j].getText();
              if (textIntrodus.equals(textLabel) && verificare == 0) {

                verificare = 1;

                JOptionPane.showMessageDialog(this, "Miscare Invalida", "ERROR", 0);
                break;
              }

            }
          }
        }

        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            if (x != i + subRand && y != j + subColoana && field[i + subRand][j + subColoana] != null) {

              String textfield = field[i + subRand][j + subColoana].getText();
              if (textIntrodus.equals(textfield) && !textIntrodus.equals("") && verificare == 0) {

                verificare = 1;

                JOptionPane.showMessageDialog(this, "Miscare Invalida", "ERROR", 0);

              }

            }
          }
        }

      

      verificare = 0;

      JocTerminat();
      if (Terminat) {

        JOptionPane.showMessageDialog(this, "Finish  ", "ERROR", JOptionPane.PLAIN_MESSAGE);

      }

    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

}
