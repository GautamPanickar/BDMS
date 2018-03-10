/*
 * The class for handling out all the DB related operations
 */

package BDMS.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Panickar
 */

// This class maintain all tha database activities
public class DataBaseManager {
    
    private String DBDriver          = null;
    private String DBDomainAddress   = null;    // Hold domain address for connection
    private String DBUserName        = null;
    private String DBDomainPassword  = null;    // Hold database password
    
    // connection and query execution variables.
    private Connection          con  = null;
    private PreparedStatement   ps   = null;
    private ResultSet           rs   = null;

    // constructor which initialize 
    // database driver
    // domain address
    // user name of database
    // password
    public DataBaseManager() throws ClassNotFoundException, SQLException 
    {
        DBDriver          = "com.mysql.jdbc.Driver";
        DBDomainAddress   = "jdbc:mysql://localhost:3306/BloodDonationDB";
        DBUserName        = "BDMSManager";
        DBDomainPassword  = "BDMSManagerBot";
        
        // function to init connection settings
        SetConection();
        
    }
    
    // Connection management
    /***************************************************************************************************/
    // function create a my sql connection
    private void  SetConection()
    {
        try
        {
            // creating a database connection.
            Class.forName( DBDriver );
            con=DriverManager.getConnection( DBDomainAddress, DBUserName, DBDomainPassword );
        }
        // database connection error
        catch( SQLException ex )
        {
            JOptionPane.showMessageDialog(null, " Please check the database connection ");
        }
        // driver error
        catch( ClassNotFoundException ex )
        {
            JOptionPane.showMessageDialog(null, " Database driver problem  ");
        }
        
    }
    
    // function to close the connection
    public void closeConection() throws SQLException
    {
        con.close();
    }
    
    
    // public functions to manage database operations
    /*******************************************************************************************************/
    
    // Method to check whether the logged in person is an admin
    public boolean AdminCheck(String username, String password)
    {
        // sql query string
        String QueryAdminTable    = null; 
        if (username != null && password != null)
        {
            try
            {
                // Preparing the query and executing it
                QueryAdminTable = "SELECT Username, Password FROM AdminTable";
                ps = con.prepareStatement(QueryAdminTable);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                    if(rs.getString("Username").equals(username) && rs.getString("Password").equals(password))
                    {
                        // The credentials are of an admin
                        return true;
                    }
                    else
                    {
                        // The credentials do not match with an admin
                        return false;
                    }
                }
            }
            catch(SQLException ex)
            {
                Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }   
    
    // Method to check whether the logged in person is a donor
    public int DonorCheck(String username, String password)
    {
        // sql query string
        String QueryAdminTable    = null; 
        if (username != null && password != null)
        {
            try
            {
                // Preparing the query and executing it
                QueryAdminTable = "SELECT DonorID from DonorTable where Username = ? and Password = ?";
                ps = con.prepareStatement(QueryAdminTable);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                    return rs.getInt("DonorID");                    
                }
                else
                {                              
                    return 0;
                }
            }
            catch(SQLException ex)
            {
                Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }   
    
    // Method to register a donor
    public void RegisterDonor(String name, String address, Date regDate, String blood, String district, String city,
                              String phoneno, String age)
    {
        String QueryDonorDetailsTable    = null, QueryDonorTable = null; 
        String autoDonorID = null; // auto generated id return from database after insertion.
        String donorUsername = null, donorPassword = "donor";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(regDate);
        int  status = 0;
        try
        {
            // Preparing the query and executing it
            QueryDonorDetailsTable = "INSERT INTO DonorDetailsTable(Name, Address, City, District, Blood_group, Phone, Reg_Date, Age)"
                                   + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";             
            ps = con.prepareStatement( QueryDonorDetailsTable,Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, city);
            ps.setString(4, district);
            ps.setString(5, blood);
            ps.setString(6, phoneno);
            ps.setString(7, date);
            ps.setString(8, age); 
            status = ps.executeUpdate();
            
            if( 1 == status )
            {
                rs = ps.getGeneratedKeys();
                if( rs.next() )
                {
                    autoDonorID = rs.getString(1);
                }

                // Generating username and inserting to donortable
                donorUsername = "donor"+autoDonorID;
                QueryDonorTable = "INSERT INTO DonorTable VALUES(?, ?, ?)"; 
                ps = con.prepareStatement( QueryDonorTable);
                ps.setString(1, autoDonorID);
                ps.setString(2, donorUsername);
                ps.setString(3, donorPassword);
                status = ps.executeUpdate();
                if( 1 == status )
                {
                    JOptionPane.showMessageDialog( null, "Donor has been registered successfully! \n Username = "+donorUsername+
                                                     " \n Pasword = "+donorPassword);
                }
                else
                {
                    JOptionPane.showMessageDialog( null, "Username and password could not be generated!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog( null, "Registration could not be completed");
            }            
            
        }
        catch( SQLException ex )
        {
            JOptionPane.showMessageDialog( null,ex.getMessage() );
        }                                 
        
    }   
    
    // Method to register a donor
    public void RegisterAcceptor(String name, String address, Date regDate, String district, String city, String phoneno)
    {
        String QueryAcceptorDetailsTable = null, QueryDonorTable = null; 
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(regDate);
        int  status = 0;
        try
        {
            // Preparing the query and executing it
            QueryAcceptorDetailsTable = "INSERT INTO AcceptorDetailsTable(Name, Address, City, District, Phone, Reg_Date)"
                                   + " VALUES(?, ?, ?, ?, ?, ?)";             
            ps = con.prepareStatement(QueryAcceptorDetailsTable);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, city);
            ps.setString(4, district);
            ps.setString(5, phoneno);
            ps.setString(6, date); 
            status = ps.executeUpdate();
            
            if( 1 == status )
            {                
                JOptionPane.showMessageDialog( null, "Acceptor has been registered successfully!!");                
            }
            else
            {
                JOptionPane.showMessageDialog( null, "Registration could not be completed!!");
            }            
            
        }
        catch( SQLException ex )
        {
            JOptionPane.showMessageDialog( null,ex.getMessage() );
        }                                 
        
    }   
    
    // Retrieve details of the donor with  respect to the search criteria
    public ResultSet RetrieveDonorDetails(String searchBy, String searchValue)
    {
        String QueryDonorDetailsTable = null;
        switch (searchBy)
        {
            case "DISTRICT":if (searchValue != null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT * FROM DonorDetailsTable WHERE District LIKE ?";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    ps.setString(1, searchValue);
                                    rs = ps.executeQuery();
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;
                            
            case "CITY"    :if (searchValue != null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT * FROM DonorDetailsTable WHERE City LIKE ?";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    ps.setString(1, searchValue);
                                    rs = ps.executeQuery();
                                    return rs;
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;
                            
            case "BLOOD"   :if (searchValue != null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT * FROM DonorDetailsTable WHERE Blood_group LIKE ?";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    ps.setString(1, searchValue);
                                    rs = ps.executeQuery();
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;
                            
            case "ALL"     :if (searchValue == null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT * FROM DonorDetailsTable";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    rs = ps.executeQuery(QueryDonorDetailsTable);
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;                                   
        }
        
        return rs;
    }
    
    // Retrieve details of the donor with  respect to bloodgroup
    public ResultSet RetrieveDonorDetailsWRTBlood(String searchBy, String searchValue, String blood)
    {
        String QueryDonorDetailsTable = null;
        switch (searchBy)
        {
            case "DISTRICT":if (searchValue != null && blood != null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT DonorID, Name, Phone FROM DonorDetailsTable WHERE District LIKE ? AND Blood_group LIKE ?";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    ps.setString(1, searchValue);
                                    ps.setString(2, blood);
                                    rs = ps.executeQuery();
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;
                            
            case "CITY"    :if (searchValue != null && blood != null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT DonorID, Name, Phone FROM DonorDetailsTable WHERE City LIKE ? AND Blood_group LIKE ?";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    ps.setString(1, searchValue);
                                    ps.setString(2, blood);
                                    rs = ps.executeQuery();
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;
                            
            case "ALL"   :if (searchValue == null && blood != null)
                            {
                                try
                                {
                                    QueryDonorDetailsTable = " SELECT DonorID, Name, Phone FROM DonorDetailsTable WHERE Blood_group LIKE ?";
                                    ps = con.prepareStatement(QueryDonorDetailsTable);
                                    ps.setString(1, blood);
                                    rs = ps.executeQuery();
                                }
                                catch (SQLException ex) 
                                {
                                    Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                                }                                                               
                            }
                            break;                                
        }
        
        return rs;
    }    
    
    // The method retrieves the details of the donor
    public ResultSet RetrieveDonorDetails(String username)
    {
        String id = null;
        String QueryDonorTable = null, QueryDonorDetailsTable = null;
        
        try
        {
            QueryDonorTable = "SELECT * FROM DonorTable WHERE Username LIKE ?";
            ps = con. prepareStatement(QueryDonorTable);
            ps.setString(1, username);
            rs = ps.executeQuery();            
            if (rs.next())
            {
                // Storing the id to a variable
                id = rs.getString("DonorID");
                rs = null;
            }          
            
            //Retrieving the details of the donor
            QueryDonorDetailsTable = " SELECT * FROM DonorDetailsTable WHERE DonorID = ?";
            ps = con. prepareStatement(QueryDonorDetailsTable);
            ps.setString(1, id);
            rs = ps.executeQuery();    
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            rs = null;
        } 
        
        return rs;
    }
    
    // The method retrieves the details of the donor
    public String RetrieveDonorID(String username)
    {
        String id = null;
        String QueryDonorTable = null, QueryDonorDetailsTable = null;
        
        try
        {
            QueryDonorTable = "SELECT * FROM DonorTable WHERE Username LIKE ?";
            ps = con. prepareStatement(QueryDonorTable);
            ps.setString(1, username);
            rs = ps.executeQuery();            
            if (rs.next())
            {
                // Storing the id to a variable
                id = rs.getString("DonorID");
                return id;
            }   
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            rs = null;
        } 
        
        return id;
    }
    
    // The method retrieves the pending requests in the name of the donor
    public ResultSet RetrievePendingRequestsForDonor(String username)
    {
        String id = null;
        String QueryDonorTable = null, QueryDonorRequestsHandler = null;
        
        try
        {
            QueryDonorTable = "SELECT * FROM DonorTable WHERE Username LIKE ?";
            ps = con. prepareStatement(QueryDonorTable);
            ps.setString(1, username);
            rs = ps.executeQuery();            
            if (rs.next())
            {
                // Storing the id to a variable
                id = rs.getString("DonorID");
                rs = null;
            }          
                    
            //Retrieving the requests for the donor
            QueryDonorRequestsHandler = " SELECT Requester_ID, Requester_Name, Requester_Phone, DueDate, Status FROM Donor_Requests_Handler WHERE DonorID = ? AND STATUS = 'OPEN'";
            ps = con. prepareStatement(QueryDonorRequestsHandler);
            ps.setString(1, id);
            rs = ps.executeQuery();    
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showMessageDialog( null,ex.getMessage() );
            rs = null;
        } 
        
        return rs;
    }
    
    // Retrieves the details of the acceptor
    public ResultSet RetrieveDonorOrAcceptorDetails(String searchName, String type) 
    {
        String Query = null;
        switch (type)
        {
            case "ACCEPTOR":Query = "SELECT * FROM AcceptorDetailsTable WHERE Name LIKE ?";       
                            rs = null;
                            try 
                            {
                                ps=con.prepareStatement(Query);
                                ps.setString( 1, searchName + '%' );            
                                rs=ps.executeQuery();

                            } catch (SQLException ex) 
                            {
                                Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                            break;
            case "DONOR"   :Query = "SELECT * FROM DonorDetailsTable WHERE Name LIKE ?";       
                            rs = null;
                            try 
                            {
                                ps=con.prepareStatement(Query);
                                ps.setString( 1, searchName + '%' );            
                                rs=ps.executeQuery();

                            } catch (SQLException ex) 
                            {
                                Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                            break;                
        }
        
        return rs;        
    }
   
    // Retrieves all the acceptors
    public ResultSet RetrieveAcceptorDetails() 
    {
        String QueryAcceptorDetailsTable = null;
        QueryAcceptorDetailsTable = "SELECT * FROM AcceptorDetailsTable";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(QueryAcceptorDetailsTable);         
            rs=ps.executeQuery();
       
        } catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }       
    
        return rs;        
    }
    
    // Retrieves all the donors
    public ResultSet RetrieveDonorDetails() 
    {
        String QueryDonorDetailsTable = null;
        QueryDonorDetailsTable = "SELECT * FROM DonorDetailsTable";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(QueryDonorDetailsTable);         
            rs=ps.executeQuery();
       
        } catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }       
    
        return rs;        
    }
    
    // Removes the acceptor or donor record
    public int DeleteDonorOrAcceptorRecord(String userID, String type) 
    {
        String QueryAcceptorRequestsHandler = null, QueryDonorRequestsHandler = null, QueryDonorDetailsTable = null, QueryDonorTable = null,
               QueryAcceptorDetailsTable = null, CommonQuery = null;
        int status = 0;        
        switch (type)
        {
            case "ACCEPTOR":QueryAcceptorRequestsHandler = "DELETE FROM Acceptor_Requests_handler WHERE AcceptorID = ?";
                            QueryDonorRequestsHandler = "DELETE FROM Donor_Requests_handler WHERE AcceptorID = ?";
                            QueryAcceptorDetailsTable = "DELETE FROM AcceptorDetailsTable WHERE AcceptorID = ?";        
                            try 
                            {
                                CommonQuery = " SELECT COUNT(*) as Count FROM Acceptor_Requests_handler WHERE DonorID = ?";
                                ps = con.prepareStatement(CommonQuery);   
                                ps.setString(1, userID);
                                rs = ps.executeQuery();
                                if (rs.next())
                                {
                                    if (rs.getString("Count").equals("0"))
                                    {
                                        CommonQuery = " SELECT COUNT(*) as Count FROM Donor_Requests_handler WHERE DonorID = ?";
                                        ps = con.prepareStatement(CommonQuery);   
                                        ps.setString(1, userID);
                                        rs = ps.executeQuery();                                        
                                        if(rs.next())
                                        {
                                            if (rs.getString("Count").equals("0"))
                                            {
                                                ps = con.prepareStatement(QueryAcceptorDetailsTable);   
                                                ps.setString(1, userID);
                                                status = ps.executeUpdate();
                                            }
                                            else
                                            {
                                                ps = con.prepareStatement(QueryDonorRequestsHandler);   
                                                ps.setString(1, userID);
                                                status = ps.executeUpdate();
                                                if (1 == status)
                                                {
                                                    ps = con.prepareStatement(QueryAcceptorDetailsTable);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();                                        
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        ps = con.prepareStatement(QueryAcceptorRequestsHandler);   
                                        ps.setString(1, userID);
                                        status = ps.executeUpdate();
                                        if (1 == status)
                                        {
                                            CommonQuery = " SELECT COUNT(*) as Count FROM Donor_Requests_handler WHERE DonorID = ?";
                                            ps = con.prepareStatement(CommonQuery);   
                                            ps.setString(1, userID);
                                            rs = ps.executeQuery();                                        
                                            if(rs.next())
                                            {
                                                if (rs.getString("Count").equals("0"))
                                                {
                                                    ps = con.prepareStatement(QueryAcceptorDetailsTable);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();
                                                }
                                                else
                                                {
                                                    ps = con.prepareStatement(QueryDonorRequestsHandler);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();
                                                    if (1 == status)
                                                    {
                                                        ps = con.prepareStatement(QueryAcceptorDetailsTable);   
                                                        ps.setString(1, userID);
                                                        status = ps.executeUpdate();                                        
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }                                
                            } catch (SQLException ex) 
                            {
                                Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
            case "DONOR"   :QueryAcceptorRequestsHandler = "DELETE FROM Acceptor_Requests_handler WHERE DONORID = ?";
                            QueryDonorRequestsHandler = "DELETE FROM Donor_Requests_handler WHERE DONORID = ?";
                            QueryDonorDetailsTable = "DELETE FROM DonorDetailsTable WHERE DONORID = ?";
                            QueryDonorTable = "DELETE FROM DonorTable WHERE DonorID = ?";           
                            try 
                            {
                                CommonQuery = " SELECT COUNT(*) as Count FROM Acceptor_Requests_handler WHERE DonorID = ?";
                                ps = con.prepareStatement(CommonQuery);   
                                ps.setString(1, userID);
                                rs = ps.executeQuery();
                                if (rs.next())
                                {
                                    if (rs.getString("Count").equals("0"))
                                    {
                                        CommonQuery = " SELECT COUNT(*) as Count FROM Donor_Requests_handler WHERE DonorID = ?";
                                        ps = con.prepareStatement(CommonQuery);   
                                        ps.setString(1, userID);
                                        rs = ps.executeQuery();                                        
                                        if(rs.next())
                                        {
                                            if (rs.getString("Count").equals("0"))
                                            {
                                                ps = con.prepareStatement(QueryDonorDetailsTable);   
                                                ps.setString(1, userID);
                                                status = ps.executeUpdate();
                                                if (1 == status)
                                                {
                                                    ps = con.prepareStatement(QueryDonorTable);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();
                                                }
                                            }
                                            else
                                            {
                                                ps = con.prepareStatement(QueryDonorRequestsHandler);   
                                                ps.setString(1, userID);
                                                status = ps.executeUpdate();
                                                if (1 == status)
                                                {
                                                    ps = con.prepareStatement(QueryDonorDetailsTable);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();
                                                    if (1 == status)
                                                    {
                                                        ps = con.prepareStatement(QueryDonorTable);   
                                                        ps.setString(1, userID);
                                                        status = ps.executeUpdate();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        ps = con.prepareStatement(QueryAcceptorRequestsHandler);   
                                        ps.setString(1, userID);
                                        status = ps.executeUpdate(); 
                                        if (1 == status)
                                        {
                                            CommonQuery = " SELECT COUNT(*) as Count FROM Donor_Requests_handler WHERE DonorID = ?";
                                            ps = con.prepareStatement(CommonQuery);   
                                            ps.setString(1, userID);
                                            rs = ps.executeQuery();                                        
                                            if(rs.next())
                                            {
                                                if (rs.getString("Count").equals("0"))
                                                {
                                                    ps = con.prepareStatement(QueryDonorDetailsTable);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();
                                                    if (1 == status)
                                                    {
                                                        ps = con.prepareStatement(QueryDonorTable);   
                                                        ps.setString(1, userID);
                                                        status = ps.executeUpdate();
                                                    }
                                                }
                                                else
                                                {
                                                    ps = con.prepareStatement(QueryDonorRequestsHandler);   
                                                    ps.setString(1, userID);
                                                    status = ps.executeUpdate();
                                                    if (1 == status)
                                                    {
                                                        ps = con.prepareStatement(QueryDonorDetailsTable);   
                                                        ps.setString(1, userID);
                                                        status = ps.executeUpdate();
                                                        if (1 == status)
                                                        {
                                                            ps = con.prepareStatement(QueryDonorTable);   
                                                            ps.setString(1, userID);
                                                            status = ps.executeUpdate();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }                                                               
                            } catch (SQLException ex) 
                            {
                                Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
        }         
        
        return status;
    }
    
    // Method to make a new blood request
    public int NewBloodRequest(String acceptorID, String donorID, Date dueDate)
    {
        String QueryAcceptorDetailsTable = null, QueryDonorDetailsTable = null,
               QueryDonorRequestHandler = null, QueryAcceptorRequestsHandler = null;
        String requesterName = null, requesterPhone = null, requestedBlood = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
        String date = format.format(dueDate);
        int  status = 0, statusFinal = 0, methodStatus = 0;        
        try
        {
            // Getting the requested blood group
            QueryDonorDetailsTable = " SELECT * FROM DonorDetailsTable WHERE DonorID = ?";
            ps = con.prepareStatement(QueryDonorDetailsTable);
            ps.setString(1, donorID);
            rs = ps.executeQuery();
            if( rs.next() )
            {
                requestedBlood = rs.getString("Blood_group");
            }
            rs = null;
            
            // Getting acceptor details
            QueryAcceptorDetailsTable = " SELECT * FROM AcceptorDetailsTable WHERE AcceptorID = ?";
            ps = con.prepareStatement(QueryAcceptorDetailsTable);
            ps.setString(1, acceptorID);
            rs = ps.executeQuery();
            if( rs.next() )
            {
                requesterName = rs.getString("Name");
                requesterPhone = rs.getString("phone");
            }
            rs = null;
            
            // Keeping track of the request in acceptor record
            QueryAcceptorRequestsHandler = "INSERT INTO Acceptor_Requests_handler(DonorID, AcceptorID, Requested_Blood, DueDate, Status)"
                                     + " VALUES(?, ?, ?, ?, ?)";             
            ps = con.prepareStatement(QueryAcceptorRequestsHandler);
            ps.setString(1, donorID);
            ps.setString(2, acceptorID);
            ps.setString(3, requestedBlood);
            ps.setString(4, date);
            ps.setString(5, "OPEN");
            status = ps.executeUpdate();
            
            if( 1 == status )
            {   
                // Requesting the donor
                QueryDonorRequestHandler = "INSERT INTO Donor_Requests_handler(DonorID, Requester_ID, Requester_Name, Requested_Blood_Group,"
                                     + " Requester_Phone, DueDate, Status)"
                                     + " VALUES(?, ?, ?, ?, ?, ?, ?)";             
                ps = con.prepareStatement(QueryDonorRequestHandler);
                ps.setString(1, donorID);
                ps.setString(2, acceptorID);
                ps.setString(3, requesterName);
                ps.setString(4, requestedBlood);
                ps.setString(5, requesterPhone);
                ps.setString(6, date); 
                ps.setString(7, "OPEN");
                statusFinal = ps.executeUpdate();
                
                if (1 == statusFinal)
                {
                    methodStatus = 1;
                }
                else
                {
                    methodStatus = 0;
                    return methodStatus;
                }
            }
            else
            {
                methodStatus = 0;
                return methodStatus;
            }            
            
        }
        catch( SQLException ex )
        {
            JOptionPane.showMessageDialog( null,ex.getMessage() );
        }                                 
        
        return methodStatus;
    }   
    
    // Donor sending feedback on whether he is willing or not
    public int DonorWillingOrNot(String donorID, String acceptorID, String feedback) 
    {
        String QueryDonorRequestsHandler = null, QueryAcceptorRequestsHandler = null;
        int  status = 0, statusFinal = 0, methodStatus = 0;                  
        try 
        {
            QueryDonorRequestsHandler = "UPDATE Donor_Requests_Handler SET Status = ? WHERE DonorID = ? AND Requester_ID = ?";
            ps = con.prepareStatement(QueryDonorRequestsHandler);   
            ps.setString(1, feedback);
            ps.setString(2, donorID);
            ps.setString(3, acceptorID);
            status = ps.executeUpdate(); 
            if (1 == status)
            {
                QueryAcceptorRequestsHandler = "UPDATE Acceptor_Requests_Handler SET Status = ? WHERE DonorID = ? AND AcceptorID = ?";
                ps = con.prepareStatement(QueryAcceptorRequestsHandler);   
                ps.setString(1, feedback);
                ps.setString(2, donorID);
                ps.setString(3, acceptorID);
                statusFinal = ps.executeUpdate();
                if (1 == statusFinal)
                {
                    methodStatus = 1;
                    return methodStatus;
                }
                else
                {
                    methodStatus = 0;
                    return methodStatus;
                }
            }
            else
            {
                methodStatus = 0;
                return methodStatus;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return methodStatus;
    }
    
    // The method retrieves the pending/willing/not-willing feedbacks in the name of the acceptor
    public void RetrieveFeedbacksForAcceptor(String acceptorID, String status, JTable table)
    {  
        ResultSet rsID = null;
        DefaultTableModel tm = null;
        String QueryAcceptorRequestsHandler = null, Query = null;  
        String id = null, name = null, phone = null, blood = null, date = null;
        try
        {
            tm = (DefaultTableModel)table.getModel();
            tm.setRowCount(0);
            Query = " SELECT * FROM Acceptor_Requests_Handler WHERE AcceptorID = ? AND Status LIKE ?";
            ps = con. prepareStatement(Query);
            ps.setString(1, acceptorID);
            ps.setString(2, status);
            rsID = ps.executeQuery(); 
            while (rsID.next())
            {
                // Storing the id to a variable
                id = rsID.getString("DonorID");
                // rs = null;
                
                QueryAcceptorRequestsHandler = " SELECT (SELECT Name FROM DonorDetailsTable WHERE DonorID = ?) as Name,"
                                             + " (SELECT Phone FROM DonorDetailsTable WHERE DonorID = ?) as Phone, Requested_Blood, DueDate"
                                             + " FROM Acceptor_Requests_Handler WHERE AcceptorID = ? AND Status LIKE ?";
                ps = con. prepareStatement(QueryAcceptorRequestsHandler);
                ps.setString(1, id);
                ps.setString(2, id);
                ps.setString(3, acceptorID);
                ps.setString(4, status);
                rs = ps.executeQuery(); 
                
                if(rs.next())
                {
                    name = rs.getString(1);
                    phone = rs.getString(2);
                    blood = rs.getString(3);
                    date = rs.getString(4);                                       
                }    
                //Populating the rows
                tm.addRow(new Object[]{name, phone, blood, date}); 
            }             
            
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showMessageDialog( null,ex.getMessage() );
            rsID = null; rs = null;
        } 
    }
    
    // The method retrieves the resultset having details of pending requests for the donor that is due date
    public ResultSet RetrievePendingDueDateRequests(String username, Date dueDate) 
    {
        String id = null;
        String QueryDonorTable = null, QueryDonorRequestsHandler = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
        try
        {
            QueryDonorTable = "SELECT * FROM DonorTable WHERE Username LIKE ?";
            ps = con. prepareStatement(QueryDonorTable);
            ps.setString(1, username);
            rs = ps.executeQuery();            
            if (rs.next())
            {
                // Storing the id to a variable
                id = rs.getString("DonorID");
                rs = null;
            }          
               
            //Retrieving the requests for the donor
            QueryDonorRequestsHandler = " SELECT Requester_ID, Requester_Name, Requester_Phone, DueDate, Status FROM Donor_Requests_Handler WHERE"
                                      + " DonorID = ? AND Status LIKE 'OPEN' AND DueDate LIKE ?";
            ps = con. prepareStatement(QueryDonorRequestsHandler);
            ps.setString(1, id);
            String date = format.format(dueDate);
            ps.setString(2, date);
            rs = ps.executeQuery();
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog( null,ex.getMessage() );
            rs = null;
        }                       
        
        return rs;
    }
}
