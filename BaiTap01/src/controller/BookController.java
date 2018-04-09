/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Book;
import java.util.Scanner;

/**
 *
 * @author Quyeens
 */
public class BookController {
    public Book addControl(){
        Scanner sc = new Scanner(System.in);
        Book book = new Book();
        
        System.out.println("=========== Thêm sách ===========");
        System.out.println("Tên Sách : ");
        book.setName(sc.nextLine());
        System.out.println("Tên tác giả :");
        book.setAuthor(sc.nextLine());
        System.out.println("Tên nhà xuất bản : ");
        book.setNxb(sc.nextLine());
        return book;
    }
    public Book editInfoBook(){
        Book book = new Book();
        Scanner sc = new Scanner(System.in);
        System.out.println("=========== Sửa sách ===========");
        System.out.println("Tên sách : ");
        String name = sc.nextLine();
        book.setName(name);
        System.out.println("Tên tác giả: ");
        String author = sc.nextLine();
        book.setAuthor(author);
        System.out.println("Tên Nhà xuất bản: ");
        String nxb = sc.nextLine();
        book.setNxb(nxb);
        return book;
    }
    public int menuMain(){
        System.out.println("=========== Menu chính ===========");
        System.out.println("1. Thêm Sách Mới");
        System.out.println("2. Danh Sách các cuốn sách");
        System.out.println("3. Tìm kiếm sách");
        System.out.println("4. Thoát hệ thống");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public String infoSearch(){
        System.out.println("=========== Tìm kiếm ===========");        
        System.out.println("Nội dung tìm kiếm:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
