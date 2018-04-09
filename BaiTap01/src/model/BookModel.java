/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Quyeens
 */
public class BookModel {
    public Statement stt() throws SQLException{
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt =  cnn.createStatement();
        return stt;
    }
    public void search(String str) throws SQLException{
        BookModel model = new BookModel();
        Statement stt1 = model.stt();
        ResultSet rs = stt1.executeQuery("SELECT * FROM book WHERE name LIKE '%"+str+"%' OR author LIKE '%"+str+"%' OR nxb LIKE '%"+str+"%'");
        System.out.println("=================================");
        System.out.println("Danh sách tìm kiếm .");
        while (rs.next()) {            
            System.out.println(rs.getInt("id")+". "+rs.getString("name")+"--"+rs.getString("author")+"--"+rs.getString("nxb"));
        }  
    }
    public boolean addBook(Book book) throws SQLException{
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt =  cnn.createStatement();
        try {
           stt.execute("INSERT INTO book(name,author,nxb) VALUE('"+book.getName()+"','"+book.getAuthor()+"','"+book.getNxb()+"')");
           return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean EditBook(Book book, int id) throws SQLException{
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt =  cnn.createStatement();
        try {
            System.out.println("UPDATE book SET name = '"+book.getName()+"',author = '"+book.getAuthor()+"', nxb = '"+book.getNxb()+"' WHERE id = "+id+" ");
            stt.execute("UPDATE book SET name = '"+book.getName()+"',author = '"+book.getAuthor()+"', nxb = '"+book.getNxb()+"' WHERE id = "+id+" ");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean DeleteBook(int choise) throws SQLException{
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt =  cnn.createStatement();
        try {
           stt.execute("DELETE FROM book WHERE id = '"+choise+"'");
           return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public int listBook() throws SQLException{
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt =  cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM book WHERE 1");
            System.out.println("===================================");
            while (rs.next()) {
                System.out.println(rs.getInt("id")+". "+rs.getString("name")+"--"+rs.getString("author")+"--"+rs.getString("nxb"));
            }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public int detailBook(int choise) throws SQLException{
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt =  cnn.createStatement();
        Scanner sc = new Scanner(System.in);
        try {
            ResultSet rs = stt.executeQuery("SELECT * FROM book WHERE id = '"+choise+"'");
            if (rs == null) {
                System.out.println("Lỗi -- Không có sách");
            }
            while (rs.next()) {
                System.out.println("=========================================");
                System.out.println("ID sách : " + rs.getInt("id"));
                System.out.println("Tên sách : " + rs.getString("name"));
                System.out.println("Tác giả sách : " + rs.getString("author"));
                System.out.println("NXB sách : " + rs.getString("nxb"));
                System.out.println("=========================================");
                System.out.println("1. Sửa ");
                System.out.println("2. Xóa ");
                System.out.println("3. Thoát ");
            }
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    
}
