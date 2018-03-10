/*
 * This is the main class for the project Blood Donor Management System
 */
package blooddonormanagementsystem;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Panickar
 */
public class BloodDonorManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Setting the look and feel for the application
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
        
        // Making the LoginForm visible on running the application
        new LoginForm().setVisible(true);
    }
    
}
