
import java.net.URL;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import library.Book;
import library.Library;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class client {
    public static void main(String[] args) throws Exception
   {
      URL url = new URL("http://localhost:9901/Library?wsdl");
      QName qname = new QName("http://library/",
                              "LibraryImplService");
      Service service = Service.create(url, qname);
      qname = new QName("http://library/", "LibraryImplPort");
      Library lib = service.getPort(qname, Library.class);
      
      // Test getBooks() function
      ArrayList<Book> listBooks;
      listBooks = lib.getBooks();
      System.out.println(listBooks.size());
      
      for (int i = 0; i < listBooks.size(); i++) {
          Book ob = listBooks.get(i);
          System.out.println("Id : " + Integer.toString(ob.getId()) + ". Title: " + ob.getTitle());
      }
      
//      // Test addBook(Book book); function
//      Book book = new Book();
//      book.setId(5);
//      book.setTitle("Xu ly anh");
//      book.setDesc("Chuyen nganh khoa hoc may tinh");
//      book.img = "NULL";
//      book.setTotal(15);
//      book.setNumOrderedBook(4);
//      
//      boolean t = lib.addBook(book);
//      if(t) {
//          System.out.println("Insert table success");
//      }
//      else{
//          System.out.println("Fail");
//      }

    // Test removeBook(int); function
//    boolean t = lib.removeBook(1);
//    if(t) {
//        System.out.println("Remove from table success");
//      }
//    else{
//        System.out.println("Fail");
//    }

      Book book = new Book();
      book.setId(2);
      book.setTitle("Giai tich 2");
      book.setDesc("Mon co so");
      book.img = "NULL";
      book.setTotal(15);
      book.setNumOrderedBook(4);
      
      boolean t = lib.changeInforBook(2, book);
      if(t) {
          System.out.println("Change infor of table success");
      }
      else{
          System.out.println("Fail");
      }

   }
}
