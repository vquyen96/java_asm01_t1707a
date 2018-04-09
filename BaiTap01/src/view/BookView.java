/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entity.Book;
import controller.BookController;
import java.sql.SQLException;
import java.util.Scanner;
import model.BookModel;

/**
 *
 * @author Quyeens
 */
public class BookView {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        Book book = new Book();
        BookController controller = new BookController();
        BookModel model = new BookModel();
        while (true) {   
            int choice = controller.menuMain();
            switch(choice){
                case 1:
                    book = controller.addControl();
                    model.addBook(book);
                    break;
                case 2:
                    int id = model.listBook();
                    int a = model.detailBook(id);
                    switch(a){
                        case 1:
                            book = controller.editInfoBook();
                            model.EditBook(book, id);
                            break;
                        case 2:
                            model.DeleteBook(id);
                            break;
                        default:
                            System.out.println("Bạn nhập sai rồi -.-");
                            break;
                    }
                    if(a == 3){
                        break;
                    }
                    break;
                case 3:
                    String strSearch = controller.infoSearch();
                    model.search(strSearch);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Bạn chọn sai rồi");
                    break;
            }
            if(choice == 4){
                break;
            }
        }
        
    }
}
