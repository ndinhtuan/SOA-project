/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javax.xml.ws.Endpoint;

/**
 *
 * @author root
 */
public class LibraryPublisher {
     public static void main(String[] args)
   {
      Endpoint.publish("http://localhost:9901/Library", new LibraryImpl());
   }
}
