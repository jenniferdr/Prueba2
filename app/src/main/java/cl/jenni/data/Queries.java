package cl.jenni.prueba2.data;

import java.util.ArrayList;
import java.util.List;

import cl.jenni.prueba2.models.Book;

public class Queries{
    // GitHub ctrl+k y ctrl+shift+k


    public static List<Book> getBooks(){

        List<Book> bookList = new ArrayList<Book>();
        List<Book> bookListIterator = Book.listAll(Book.class);

        //List<Book> bookListIterator = Book.findWithQuery(Book.class, "SELECT * FROM Book ORDER BY id DESC", null);

        if(bookListIterator != null && bookListIterator.size()!=0){
            bookList.addAll(bookListIterator);
        }

        //Book newBook = new Book("Hola","Prueba");
        //bookList.add(newBook);

        return bookListIterator;
    }
}
