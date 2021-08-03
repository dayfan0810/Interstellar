// BookManager.aidl
package cn.intersteller.darkintersteller;
import cn.intersteller.darkintersteller.Book;

// Declare any non-default types here with import statements

interface BookManager {
       Book addBookIn(in Book book);
       Book addBookOut(out Book book);
       Book addBookInout(inout Book book);
       List<Book> getBooks();
}
