/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 *
 * @author Quyeens
 */
public class Book {
    private int id ;
    private String name;
    private String author;
    private String nxb;

    public Book(int id, String name, String author, String nxb) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.nxb = nxb;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }
    
}
