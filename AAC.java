import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AAC extends JPanel
                        implements ActionListener {
    protected JButton lowButton, midButton, highButton, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    protected JLabel title, want;
    // midhigh=1 -> midlevel, midhigh=2 -> highlevel
    private static int midhigh;
    // desire=1 -> want, desire=2 -> need
    private static int desire;
    private static boolean donot = false;
    private static int imageNum = 1;

    public AAC() {
        
        title = new JLabel("GenAAC");
        title.setFont(new Font("Verdana", Font.BOLD, 72));

        lowButton = new JButton("LOW");
        lowButton.setFont(new Font("Verdana", Font.BOLD, 30));
        lowButton.setVerticalTextPosition(AbstractButton.CENTER);
        lowButton.setHorizontalTextPosition(AbstractButton.CENTER); //aka LEFT, for left-to-right locales
        lowButton.setMnemonic(KeyEvent.VK_L);
        lowButton.setActionCommand("low");

        midButton = new JButton("MID");
        midButton.setFont(new Font("Verdana", Font.BOLD, 30));
        midButton.setVerticalTextPosition(AbstractButton.CENTER);
        midButton.setHorizontalTextPosition(AbstractButton.CENTER);
        midButton.setMnemonic(KeyEvent.VK_M);
        midButton.setActionCommand("mid");

        highButton = new JButton("HIGH");
        highButton.setFont(new Font("Verdana", Font.BOLD, 30));
        highButton.setVerticalTextPosition(AbstractButton.CENTER);
        highButton.setHorizontalTextPosition(AbstractButton.CENTER);
        highButton.setMnemonic(KeyEvent.VK_H);
        highButton.setActionCommand("high");
        

        //Listen for actions on buttons.
        lowButton.addActionListener(this);
        midButton.addActionListener(this);
        highButton.addActionListener(this);

        lowButton.setToolTipText("Click this button for low-level students.");
        midButton.setToolTipText("Click this button for mid-level students.");
        highButton.setToolTipText("Click this button for high-level students.");

        JPanel titlePane = new JPanel();
        titlePane.add(title, BorderLayout.CENTER);

        JPanel buttonPane = new JPanel();
        
        lowButton.setPreferredSize(new Dimension(300, 200));
        buttonPane.add(lowButton, BorderLayout.CENTER);
        buttonPane.add(Box.createRigidArea(new Dimension(50, 0)));

        midButton.setPreferredSize(new Dimension(300, 200));
        buttonPane.add(midButton, BorderLayout.CENTER);
        buttonPane.add(Box.createRigidArea(new Dimension(50, 0)));

        highButton.setPreferredSize(new Dimension(300, 200));
        buttonPane.add(highButton, BorderLayout.CENTER);

        //Put everything together
        //Container contentPane = getContentPane();
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(titlePane);
        add(buttonPane);
       
    }

    public void LowLevel(Container pane) {

        String imageno = Integer.toString(imageNum);
        
        ImageIcon noIcon = createImageIcon("images/x.jpg");
        b1 = new JButton("no", noIcon);
        b1.setFont(new Font("Verdana", Font.BOLD, 30));
        b1.setVerticalTextPosition(AbstractButton.TOP);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("low");

        ImageIcon yesIcon = createImageIcon("images/yes.jpg");
        b2 = new JButton("yes", yesIcon);
        b2.setFont(new Font("Verdana", Font.BOLD, 30));
        b2.setVerticalTextPosition(AbstractButton.TOP);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("mid");

        b3 = new JButton("toy");
        b3.setFont(new Font("Verdana", Font.BOLD, 30));
        b3.setVerticalTextPosition(AbstractButton.TOP);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        //b3.setActionCommand("high");

        ImageIcon snackIcon = createImageIcon("images/snack/snack" + imageno + ".jpg");
        b4 = new JButton("snack", snackIcon);
        b4.setFont(new Font("Verdana", Font.BOLD, 30));
        b4.setVerticalTextPosition(AbstractButton.TOP);
        b4.setHorizontalTextPosition(AbstractButton.CENTER);
        //b4.setActionCommand("high");

        b5 = new JButton("drink");
        b5.setFont(new Font("Verdana", Font.BOLD, 30));
        b5.setVerticalTextPosition(AbstractButton.TOP);
        b5.setHorizontalTextPosition(AbstractButton.CENTER);
        //b5.setActionCommand("high");

        b6 = new JButton("bathroom");
        b6.setFont(new Font("Verdana", Font.BOLD, 30));
        b6.setVerticalTextPosition(AbstractButton.TOP);
        b6.setHorizontalTextPosition(AbstractButton.CENTER);
        //b6.setActionCommand("high");
        
        final Container tempPane = pane;
        //Listen for actions on buttons.
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogLow("", "no");
                }
            });     
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogLow("", "yes");
                }
            });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogLow("I want", "toy");
                }
            });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewImage();

                MakeDialogLow("I want", "snack");

                }
            });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogLow("I want", "drink");
                }
            });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogLow("I need", "bathroom");
                }
            });

        JPanel buttonPaneTop = new JPanel();
        
        b1.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b1, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b2.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b2, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b3.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b3, BorderLayout.CENTER);

        JPanel buttonPaneBottom = new JPanel();
        
        b4.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b4, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b5.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b5, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b6.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b6, BorderLayout.CENTER);

        //Put everything together
        //Container contentPane = getContentPane();
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(buttonPaneTop);
        pane.add(buttonPaneBottom);
    }

    public void MidHighLevel(Container pane) {

        String imageno = Integer.toString(imageNum);
        
        ImageIcon childIcon = createImageIcon("images/child.jpg");
        b1 = new JButton("I", childIcon);
        b1.setFont(new Font("Verdana", Font.BOLD, 30));
        b1.setVerticalTextPosition(AbstractButton.TOP);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        b1.setActionCommand("I");

        ImageIcon donotIcon = createImageIcon("images/x.jpg");
        b2 = new JButton("do not", donotIcon);
        b2.setFont(new Font("Verdana", Font.BOLD, 30));
        b2.setVerticalTextPosition(AbstractButton.TOP);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setActionCommand("do not");
        b2.setEnabled(false);

        ImageIcon wantIcon = createImageIcon("images/want.jpg");
        b3 = new JButton("want", wantIcon);
        b3.setFont(new Font("Verdana", Font.BOLD, 30));
        b3.setVerticalTextPosition(AbstractButton.TOP);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        b3.setActionCommand("want");
        b3.setEnabled(false);

        b4 = new JButton("need");
        b4.setFont(new Font("Verdana", Font.BOLD, 30));
        b4.setVerticalTextPosition(AbstractButton.TOP);
        b4.setHorizontalTextPosition(AbstractButton.CENTER);
        b4.setActionCommand("need");
        b4.setEnabled(false);

        ImageIcon snackIcon = createImageIcon("images/snack/snack" + imageno + ".jpg");
        b5 = new JButton("snack", snackIcon);
        b5.setFont(new Font("Verdana", Font.BOLD, 30));
        b5.setVerticalTextPosition(AbstractButton.TOP);
        b5.setHorizontalTextPosition(AbstractButton.CENTER);
        b5.setActionCommand("snack");
        b5.setEnabled(false);

        b6 = new JButton("drink");
        b6.setFont(new Font("Verdana", Font.BOLD, 30));
        b6.setVerticalTextPosition(AbstractButton.TOP);
        b6.setHorizontalTextPosition(AbstractButton.CENTER);
        b6.setActionCommand("drink");
        b6.setEnabled(false);

        b7 = new JButton("toy");
        b7.setFont(new Font("Verdana", Font.BOLD, 30));
        b7.setVerticalTextPosition(AbstractButton.TOP);
        b7.setHorizontalTextPosition(AbstractButton.CENTER);
        b7.setActionCommand("toy");
        b7.setEnabled(false);

        b8 = new JButton("break");
        b8.setFont(new Font("Verdana", Font.BOLD, 30));
        b8.setVerticalTextPosition(AbstractButton.TOP);
        b8.setHorizontalTextPosition(AbstractButton.CENTER);
        b8.setActionCommand("break");
        b8.setEnabled(false);

        b9 = new JButton("help");
        b9.setFont(new Font("Verdana", Font.BOLD, 30));
        b9.setVerticalTextPosition(AbstractButton.TOP);
        b9.setHorizontalTextPosition(AbstractButton.CENTER);
        b9.setActionCommand("help");
        b9.setEnabled(false);

        b10 = new JButton("bathroom");
        b10.setFont(new Font("Verdana", Font.BOLD, 30));
        b10.setVerticalTextPosition(AbstractButton.TOP);
        b10.setHorizontalTextPosition(AbstractButton.CENTER);
        b10.setActionCommand("bathroom");
        b10.setEnabled(false);

        //Listen for actions on buttons.
        b1.addActionListener(new MidHighListener());
        b2.addActionListener(new MidHighListener());
        b3.addActionListener(new MidHighListener());
        b4.addActionListener(new MidHighListener());
        if (midhigh == 1) {
            b5.addActionListener(new MidListener());
            b6.addActionListener(new MidListener());
            b7.addActionListener(new MidListener());
            b8.addActionListener(new MidListener());
            b9.addActionListener(new MidListener());
            b10.addActionListener(new MidListener());
        } else {
            b5.addActionListener(new HighListener());
            b6.addActionListener(new HighListener());
            b7.addActionListener(new HighListener());
            b8.addActionListener(new HighListener());
            b9.addActionListener(new HighListener());
            b10.addActionListener(new HighListener());
        }
                
        JPanel buttonPaneTop = new JPanel();
        
        b1.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b1, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b2.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b2, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b3.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b3, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b4.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b4, BorderLayout.CENTER);

        JPanel buttonPaneMid = new JPanel();
        
        b5.setPreferredSize(new Dimension(300, 200));
        buttonPaneMid.add(b5, BorderLayout.CENTER);
        buttonPaneMid.add(Box.createRigidArea(new Dimension(50, 0)));

        b6.setPreferredSize(new Dimension(300, 200));
        buttonPaneMid.add(b6, BorderLayout.CENTER);
        buttonPaneMid.add(Box.createRigidArea(new Dimension(50, 0)));

        b7.setPreferredSize(new Dimension(300, 200));
        buttonPaneMid.add(b7, BorderLayout.CENTER);

        JPanel buttonPaneBottom = new JPanel();
        
        b8.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b8, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b9.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b9, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b10.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b10, BorderLayout.CENTER);

        //Put everything together
        //Container contentPane = getContentPane();
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(buttonPaneTop);
        pane.add(buttonPaneMid);
        pane.add(buttonPaneBottom);
        
    }

    public void Snack(Container pane, JFrame frame ) {

        imageNum = 1;
        String imageno = Integer.toString(imageNum);
        
        b1 = new JButton("cookie");
        b1.setFont(new Font("Verdana", Font.BOLD, 30));
        b1.setVerticalTextPosition(AbstractButton.TOP);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("cookie");

        ImageIcon chipsIcon = createImageIcon("images/chips/chips" + imageno + ".jpg");
        b2 = new JButton("chips", chipsIcon);
        b2.setFont(new Font("Verdana", Font.BOLD, 30));
        b2.setVerticalTextPosition(AbstractButton.TOP);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("chips");

        b3 = new JButton("fruit");
        b3.setFont(new Font("Verdana", Font.BOLD, 30));
        b3.setVerticalTextPosition(AbstractButton.TOP);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        //b3.setActionCommand("fruit");

        b4 = new JButton("pretzel");
        b4.setFont(new Font("Verdana", Font.BOLD, 30));
        b4.setVerticalTextPosition(AbstractButton.TOP);
        b4.setHorizontalTextPosition(AbstractButton.CENTER);
        //b4.setActionCommand("pretzel");

        b5 = new JButton("cracker");
        b5.setFont(new Font("Verdana", Font.BOLD, 30));
        b5.setVerticalTextPosition(AbstractButton.TOP);
        b5.setHorizontalTextPosition(AbstractButton.CENTER);
        //b5.setActionCommand("cracker");

        b6 = new JButton("yogurt");
        b6.setFont(new Font("Verdana", Font.BOLD, 30));
        b6.setVerticalTextPosition(AbstractButton.TOP);
        b6.setHorizontalTextPosition(AbstractButton.CENTER);
        //b6.setActionCommand("yogurt");

        //Listen for actions on buttons.
        final JFrame tempFrame = frame;
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("cookie", tempFrame);
                }
            });     
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("chips", tempFrame);
                }
            });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("fruit", tempFrame);
                }
            });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("pretzel", tempFrame);
                }
            });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("cracker", tempFrame);
                }
            });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("yogurt", tempFrame);
                }
            });
  
        JPanel buttonPaneTop = new JPanel();
        
        b1.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b1, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b2.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b2, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b3.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b3, BorderLayout.CENTER);

        JPanel buttonPaneBottom = new JPanel();
        
        b4.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b4, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b5.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b5, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b6.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b6, BorderLayout.CENTER);

        //Put everything together
        //Container contentPane = getContentPane();
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(buttonPaneTop);
        pane.add(buttonPaneBottom);
        
    }

    public void Drink(Container pane, JFrame frame ) {
        
        b1 = new JButton("apple juice");
        b1.setFont(new Font("Verdana", Font.BOLD, 30));
        b1.setVerticalTextPosition(AbstractButton.TOP);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("apple juice");

        b2 = new JButton("orange juice");
        b2.setFont(new Font("Verdana", Font.BOLD, 30));
        b2.setVerticalTextPosition(AbstractButton.TOP);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("orange juice");

        b3 = new JButton("water");
        b3.setFont(new Font("Verdana", Font.BOLD, 30));
        b3.setVerticalTextPosition(AbstractButton.TOP);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        //b3.setActionCommand("water");

        b4 = new JButton("soda");
        b4.setFont(new Font("Verdana", Font.BOLD, 30));
        b4.setVerticalTextPosition(AbstractButton.TOP);
        b4.setHorizontalTextPosition(AbstractButton.CENTER);
        //b4.setActionCommand("soda");

        b5 = new JButton("milk");
        b5.setFont(new Font("Verdana", Font.BOLD, 30));
        b5.setVerticalTextPosition(AbstractButton.TOP);
        b5.setHorizontalTextPosition(AbstractButton.CENTER);
        //b5.setActionCommand("milk");

        b6 = new JButton("chocolate milk");
        b6.setFont(new Font("Verdana", Font.BOLD, 30));
        b6.setVerticalTextPosition(AbstractButton.TOP);
        b6.setHorizontalTextPosition(AbstractButton.CENTER);
        //b6.setActionCommand("yogurt");
        
        //Listen for actions on buttons.
        final JFrame tempFrame = frame;
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("apple juice", tempFrame);
                }
            });     
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("orange juice", tempFrame);
                }
            });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("water", tempFrame);
                }
            });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("soda", tempFrame);
                }
            });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("milk", tempFrame);
                }
            });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("chocolate milk", tempFrame);
                }
            });
  
        JPanel buttonPaneTop = new JPanel();
        
        b1.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b1, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b2.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b2, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b3.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b3, BorderLayout.CENTER);

        JPanel buttonPaneBottom = new JPanel();
        
        b4.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b4, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b5.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b5, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b6.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b6, BorderLayout.CENTER);

        //Put everything together
        //Container contentPane = getContentPane();
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(buttonPaneTop);
        pane.add(buttonPaneBottom);
        
    }

    public void Toy(Container pane, JFrame frame ) {
        
        b1 = new JButton("bubbles");
        b1.setFont(new Font("Verdana", Font.BOLD, 30));
        b1.setVerticalTextPosition(AbstractButton.TOP);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("bubbles");

        b2 = new JButton("ball");
        b2.setFont(new Font("Verdana", Font.BOLD, 30));
        b2.setVerticalTextPosition(AbstractButton.TOP);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        //b1.setActionCommand("ball");

        b3 = new JButton("putty");
        b3.setFont(new Font("Verdana", Font.BOLD, 30));
        b3.setVerticalTextPosition(AbstractButton.TOP);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        //b3.setActionCommand("putty");

        b4 = new JButton("blocks");
        b4.setFont(new Font("Verdana", Font.BOLD, 30));
        b4.setVerticalTextPosition(AbstractButton.TOP);
        b4.setHorizontalTextPosition(AbstractButton.CENTER);
        //b4.setActionCommand("blocks");

        b5 = new JButton("doll");
        b5.setFont(new Font("Verdana", Font.BOLD, 30));
        b5.setVerticalTextPosition(AbstractButton.TOP);
        b5.setHorizontalTextPosition(AbstractButton.CENTER);
        //b5.setActionCommand("doll");

        b6 = new JButton("slinky");
        b6.setFont(new Font("Verdana", Font.BOLD, 30));
        b6.setVerticalTextPosition(AbstractButton.TOP);
        b6.setHorizontalTextPosition(AbstractButton.CENTER);
        //b6.setActionCommand("slinky");
        
        //Listen for actions on buttons.
        final JFrame tempFrame = frame;
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("bubbles", tempFrame);
                }
            });     
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("ball", tempFrame);
                }
            });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("putty", tempFrame);
                }
            });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("blocks", tempFrame);
                }
            });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("doll", tempFrame);
                }
            });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakeDialogMidHigh("slinky", tempFrame);
                }
            });
  
        JPanel buttonPaneTop = new JPanel();
        
        b1.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b1, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b2.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b2, BorderLayout.CENTER);
        buttonPaneTop.add(Box.createRigidArea(new Dimension(50, 0)));

        b3.setPreferredSize(new Dimension(300, 200));
        buttonPaneTop.add(b3, BorderLayout.CENTER);

        JPanel buttonPaneBottom = new JPanel();
        
        b4.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b4, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b5.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b5, BorderLayout.CENTER);
        buttonPaneBottom.add(Box.createRigidArea(new Dimension(50, 0)));

        b6.setPreferredSize(new Dimension(300, 200));
        buttonPaneBottom.add(b6, BorderLayout.CENTER);

        //Put everything together
        //Container contentPane = getContentPane();
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(buttonPaneTop);
        pane.add(buttonPaneBottom);
        
    }

    class MidHighListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("I".equals(e.getActionCommand())) {
                b1.setEnabled(false);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
            } else if ("want".equals(e.getActionCommand())) {
                desire = 1;
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(false);
                b9.setEnabled(false);
                b10.setEnabled(false);
            } else if ("need".equals(e.getActionCommand())) {
                desire = 2;
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                b7.setEnabled(false);
                b8.setEnabled(true);
                b9.setEnabled(true);
                b10.setEnabled(true);
            } else if ("do not".equals(e.getActionCommand())) {
                donot = true;
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(false);
                b6.setEnabled(false);
                b7.setEnabled(false);
                b8.setEnabled(false);
                b8.setEnabled(false);
                b9.setEnabled(false);
                b10.setEnabled(false);
            } 
        }
    }

    class MidListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("snack".equals(e.getActionCommand())) {
                MakeDialogMidHigh("snack", null);
            } else if ("drink".equals(e.getActionCommand())) {
                MakeDialogMidHigh("drink", null);
            } else if ("toy".equals(e.getActionCommand())) {
                MakeDialogMidHigh("toy", null);
            } else if ("break".equals(e.getActionCommand())) {
                MakeDialogMidHigh("break", null);
            } else if ("help".equals(e.getActionCommand())) {
                MakeDialogMidHigh("help", null);
            } else if ("bathroom".equals(e.getActionCommand())) {
                MakeDialogMidHigh("bathroom", null);
            }
            NewImage();
        }
    }

    class HighListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("snack".equals(e.getActionCommand())) {
                ResetButtons();
                //Create and set up the window.
                JFrame frame = new JFrame("Snack");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(5000, 1800);

                //Create and set up the content pane.
                Snack(frame.getContentPane(), frame);
            
                frame.pack();
                frame.setVisible(true);
            } else if ("drink".equals(e.getActionCommand())) {
                ResetButtons();
                //Create and set up the window.
                JFrame frame = new JFrame("Drink");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(5000, 1800);

                //Create and set up the content pane.
                Drink(frame.getContentPane(), frame);
            
                frame.pack();
                frame.setVisible(true);
            } else if ("toy".equals(e.getActionCommand())) {
                ResetButtons();
                //Create and set up the window.
                JFrame frame = new JFrame("Toy");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(5000, 1800);

                //Create and set up the content pane.
                Toy(frame.getContentPane(), frame);
            
                frame.pack();
                frame.setVisible(true);
            } else if ("break".equals(e.getActionCommand())) {
                MakeDialogMidHigh("break", null);
            } else if ("help".equals(e.getActionCommand())) {
                MakeDialogMidHigh("help", null);
            } else if ("bathroom".equals(e.getActionCommand())) {
                MakeDialogMidHigh("bathroom", null);
            }
        }
    }



    public void actionPerformed(ActionEvent e) {
        if ("low".equals(e.getActionCommand())) {
            //Create and set up the window.
            JFrame frame = new JFrame("Low-Level");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(5000, 1800);

            //Create and set up the content pane.
            LowLevel(frame.getContentPane());
            
            frame.pack();
            frame.setVisible(true);
        } else if ("mid".equals(e.getActionCommand())) {
            midhigh = 1;
            //Create and set up the window.
            JFrame frame = new JFrame("Mid-Level");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(5000, 1800);

            //Create and set up the content pane.
            MidHighLevel(frame.getContentPane());
            
            frame.pack();
            frame.setVisible(true);
        } else{
            midhigh = 2;
            //Create and set up the window.
            JFrame frame = new JFrame("High-Level");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(5000, 1800);

            //Create and set up the content pane.
            MidHighLevel(frame.getContentPane());
            
            frame.pack();
            frame.setVisible(true);
        }
    }

    public void ResetButtons(){
        //reset buttons

        b1.setEnabled(true);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
    }
    public void NewImage(){
        if (imageNum == 2){
            imageNum = 1;
        } else {
            imageNum++;
        }
        revalidate();
        validate();
        repaint();
    }

    public void MakeDialogLow(String wantString, String buttonString){
        want = new JLabel(wantString);
        want.setFont(new Font("Verdana", Font.BOLD, 30));

        JButton button = new JButton(buttonString);
        button.setFont(new Font("Verdana", Font.BOLD, 30));
        button.setVerticalTextPosition(AbstractButton.TOP);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setPreferredSize(new Dimension(300, 200));

        JPanel topPane = new JPanel();
        topPane.add(want, BorderLayout.CENTER);

        JPanel bottomPane = new JPanel();      
        bottomPane.add(button, BorderLayout.CENTER);

        //Put everything together
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(topPane);
        pane.add(bottomPane);

        final JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setContentPane(pane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        //create timer to dispose of dialog after 5 seconds
        Timer timer = new Timer(10000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            dialog.dispose();
            }
        });
        timer.setRepeats(false);//the timer should only go off once

        //start timer to close JDialog as dialog modal we must start the timer before its visible
        timer.start();

        dialog.setVisible(true);
    }

    public void MakeDialogMidHigh(String object, JFrame frame ){

        JButton ibutton = new JButton("I");
        ibutton.setFont(new Font("Verdana", Font.BOLD, 30));
        ibutton.setVerticalTextPosition(AbstractButton.TOP);
        ibutton.setHorizontalTextPosition(AbstractButton.CENTER);
        ibutton.setPreferredSize(new Dimension(300, 200));

        JButton donotButton = new JButton("do not");
        donotButton.setFont(new Font("Verdana", Font.BOLD, 30));
        donotButton.setVerticalTextPosition(AbstractButton.TOP);
        donotButton.setHorizontalTextPosition(AbstractButton.CENTER);
        donotButton.setPreferredSize(new Dimension(300, 200));

        JButton wantButton = new JButton("want");
        wantButton.setFont(new Font("Verdana", Font.BOLD, 30));
        wantButton.setVerticalTextPosition(AbstractButton.TOP);
        wantButton.setHorizontalTextPosition(AbstractButton.CENTER);
        wantButton.setPreferredSize(new Dimension(300, 200));

        JButton needButton = new JButton("need");
        needButton.setFont(new Font("Verdana", Font.BOLD, 30));
        needButton.setVerticalTextPosition(AbstractButton.TOP);
        needButton.setHorizontalTextPosition(AbstractButton.CENTER);
        needButton.setPreferredSize(new Dimension(300, 200));

        JButton button = new JButton(object);
        donotButton.setFont(new Font("Verdana", Font.BOLD, 30));
        button.setVerticalTextPosition(AbstractButton.TOP);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setPreferredSize(new Dimension(300, 200));

        JPanel topPane = new JPanel();

        topPane.add(ibutton, BorderLayout.CENTER);
        if (donot == true){
            topPane.add(donotButton, BorderLayout.CENTER);
        }
        if (desire == 1){
            topPane.add(wantButton, BorderLayout.CENTER);
        } else {
            topPane.add(needButton, BorderLayout.CENTER);
        } 
        topPane.add(button, BorderLayout.CENTER);

        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(topPane);

        //Put everything together

        final JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setContentPane(pane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        final JFrame tempFrame = frame;

        //create timer to dispose of dialog after 5 seconds
        Timer timer = new Timer(10000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            if (tempFrame != null){
                tempFrame.dispose();
            }
            dialog.dispose();
            ResetButtons();
            donot = false;
            }
        });
        timer.setRepeats(false);//the timer should only go off once

        //start timer to close JDialog as dialog modal we must start the timer before its visible
        timer.start();

        dialog.setVisible(true);
        
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = AAC.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("AAC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(5000, 1800);

        //Create and set up the content pane.
        AAC newContentPane = new AAC();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximize window

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}
