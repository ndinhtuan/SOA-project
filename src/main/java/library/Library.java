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
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Library {
    /*
    - Return List of book
    */
    @WebMethod ArrayList<Book> getBooks();
    @WebMethod boolean addBook(Book book);
    /*
    @parameter id is id of book
    return True if remove successful
    return False if remove Fail;
    */
    @WebMethod boolean removeBook(int id);
    /*
    @parameter id is book's id
    @parameter book is new information for book, which has id is id
    return True if change successful, return False if fail
    */
    @WebMethod boolean changeInforBook(int id, Book book);
    /*
    this function for student order book, which has id 
    return True if order success, False if fail.
    */
    @WebMethod boolean orderBook(int id);
}
