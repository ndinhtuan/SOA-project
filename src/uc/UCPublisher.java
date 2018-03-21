package uc;

import javax.xml.ws.Endpoint;

import uc.UCImpl;

public class UCPublisher
{
   public static void main(String[] args)
   {
      Endpoint.publish("http://localhost:9901/UC", new UCImpl());
   }
}