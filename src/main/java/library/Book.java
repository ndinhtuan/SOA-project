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
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Book")
public class Book {
    @XmlElement(name="id")
    private int id;
    @XmlElement(name="title")
    private String title;
    @XmlElement(name="img")
    public String img;
    @XmlElement(name="description")
    private String description;
    @XmlElement(name="total")
    private int total;
    @XmlElement(name="numOrderedBook")
    private int numOrderedBook;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    
    public void setDesc(String des){
        this.description = des;
    }
    
    public String getDesc(){
        return this.description;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getTotal(){
        return this.total;
    }
    
    public void setNumOrderedBook(int num){
        this.numOrderedBook = num;
    }
    
    public int getNumOrderedBook(){
        return this.numOrderedBook;
    }
}
