import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoGameMenuGUI extends JFrame {
    /**
	 * 
	 */
	private CardPanel mainPanel;
    private JButton btnPlay;
    private JButton btnLoadGame;
    private JButton btnExit;

    public VideoGameMenuGUI() {
        setTitle("Trivia Trek");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel with CardLayout to switch between views
        mainPanel = new CardPanel();
        mainPanel.setLayout(new CardLayout());

        // Menu Panel with background
        JPanel menuPanel = new BackgroundPanel("/images/menu.png"); //pulls image from folder in SRC
        
        menuPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for more control over positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // End row after this component
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make the button expand horizontally
        gbc.insets = new Insets(10, 0, 10, 0);

        btnPlay = new JButton("Play");
        btnLoadGame = new JButton("Load Game");
        btnExit = new JButton("Exit");

        // Example of setting a button size
        btnPlay.setPreferredSize(new Dimension(200, 75)); // Set the preferred size (width, height)
        btnLoadGame.setPreferredSize(new Dimension(200, 75));
        btnExit.setPreferredSize(new Dimension(200, 75));

        btnPlay.addActionListener(e -> showDifficultyOptions());
        btnLoadGame.addActionListener(e -> System.out.println("Loading Game..."));
        btnExit.addActionListener(e -> System.exit(0));

        menuPanel.add(btnPlay, gbc); // Use the GridBagConstraints
        menuPanel.add(btnLoadGame, gbc);
        menuPanel.add(btnExit, gbc);

        mainPanel.add(menuPanel, "Menu");

        add(mainPanel, BorderLayout.CENTER);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Fullscreen 
     
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    private void showDifficultyOptions() {
        // Difficulty Panel with background
        JPanel difficultyPanel = new BackgroundPanel("/images/menu1.png"); //pulls image from SRC images folder 
        difficultyPanel.setLayout(new FlowLayout());
        difficultyPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for more control over positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // End row after this component
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make the button expand horizontally
        gbc.insets = new Insets(10, 0, 10, 0);
        
        JButton btnIntro = new JButton("Intro");
        JButton btnEasy = new JButton("Easy");
        JButton btnMedium = new JButton("Medium");
        JButton btnHard = new JButton("Hard");
        
        btnIntro.setPreferredSize(new Dimension(200, 75)); // Set the preferred size (width, height)
        btnEasy.setPreferredSize(new Dimension(200, 75));
        btnMedium.setPreferredSize(new Dimension(200, 75));
        btnHard.setPreferredSize(new Dimension(200, 75));

        // Simplified demo, ADD LOGIC HERE
        btnIntro.addActionListener(e -> System.out.println("Playing Intro..."));
        btnEasy.addActionListener(e -> System.out.println("Playing on Easy..."));
        btnMedium.addActionListener(e -> System.out.println("Playing on Medium..."));
        btnHard.addActionListener(e -> System.out.println("Playing on Hard..."));

        difficultyPanel.add(btnIntro);
        difficultyPanel.add(btnEasy);
        difficultyPanel.add(btnMedium);
        difficultyPanel.add(btnHard);

        mainPanel.add(difficultyPanel, "Difficulty");
        ((CardLayout) mainPanel.getLayout()).show(mainPanel, "Difficulty");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
  
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VideoGameMenuGUI());
    }

    // Custom JPanel class to handle background images
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage(); //Gives program access to pull images from folders within class 
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image, scaling it to fill the panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Wrapper class to easily add panels with CardLayout
    private class CardPanel extends JPanel {
        /**
		 * 
		 */

		public CardPanel() {
            super(new CardLayout());
        }
    }
}
