import java.net.URL;

import javax.xml.namespace.QName;

import javax.xml.ws.Service;

import uc.UC;

public class UCClient
{
   public static void main(String[] args) throws Exception
   {
      URL url = new URL("http://localhost:9901/UC?wsdl");
      QName qname = new QName("http://uc/",
                              "UCImplService");
      Service service = Service.create(url, qname);
      qname = new QName("http://uc/", "UCImplPort");
      UC uc = service.getPort(qname, UC.class);
//      UC uc = service.getPort(UC.class);
      System.out.printf("DC to DF: 37 DC = %f DF%n", uc.c2f(37.0));
      System.out.printf("CM to IN: 10 CM = %f IN%n", uc.cm2in(10));
      System.out.printf("DF to DC: 212 DF = %f DC%n", uc.f2c(212.0));
      System.out.printf("IN to CM: 10 IN = %f CM%n", uc.in2cm(10));
   }
}