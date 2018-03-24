/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author root
 */
import java.util.List;
import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(endpointInterface="library.Library")
public class LibraryImpl implements Library{
    @Override
    public ArrayList<Book> getBooks(){
        
        ArrayList<Book> listBook = new ArrayList<Book>();
        
        try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost/library?user=root&password=9871")) {
            
            try(Statement st = conn.createStatement()){
                try(ResultSet rs = st.executeQuery("Select * from book;")) {
                    
                    ResultSetMetaData rsmd = rs.getMetaData();
                    
                    int columnsNumber = rsmd.getColumnCount();
                    while (rs.next()) {
                        Book book = new Book();
                        for (int i = 1; i <= columnsNumber; i++) {
                            
                            String columnValue = rs.getString(i);
                            String columnName = rsmd.getColumnName(i);
                            switch(columnName){
                                case "id": book.setId(Integer.parseInt(columnValue)); break;
                                case "title": book.setTitle(columnValue); break;
                                case "img": book.img = columnValue; break;
                                case "descBook": book.setDesc(columnValue); break;
                                case "totalNumberBooks": book.setTotal(Integer.parseInt(columnValue)); break;
                                case "numOrderedBook": book.setNumOrderedBook(Integer.parseInt(columnValue)); break;
                            }
                        }
                        listBook.add(book);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listBook;
    }
    
    @Override
    public boolean addBook(Book book){
        
        try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost/library?user=root&password=9871")) {
            
            try(Statement st = conn.createStatement()){
                
                String query = "Insert into book value(" + Integer.toString(book.getId()) + ",\" " + 
                            book.getTitle() + "\", " + book.img + ", \"" + book.getDesc() + "\", " +
                        Integer.toString(book.getTotal()) + ", " + Integer.toString(book.getNumOrderedBook()) + ");";
                try(ResultSet rs = st.executeQuery(query)) {
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean removeBook(int id) {
        
        try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost/library?user=root&password=9871")) {
            
            try(Statement st = conn.createStatement()){
                
                String query = "Delete From book Where id = " + Integer.toString(id) +" ;";
                try(ResultSet rs = st.executeQuery(query)) {
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean changeInforBook(int id, Book book){
        assert(id != book.getId());
        
        try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost/library?user=root&password=9871")) {
            
            try(Statement st = conn.createStatement()){
                
                String query = "Update book Set title = \"" + 
                            book.getTitle() + "\", img = " + book.img + ", descBook = \"" + book.getDesc() + "\", totalNumberBooks=" +
                        Integer.toString(book.getTotal()) + ", numOrderedBook = " + Integer.toString(book.getNumOrderedBook()) + 
                        " Where id = " + Integer.toString(id);
                try(ResultSet rs = st.executeQuery(query)) {
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    @Override 
    public boolean orderBook(int id) {
        return true;
    }
}
