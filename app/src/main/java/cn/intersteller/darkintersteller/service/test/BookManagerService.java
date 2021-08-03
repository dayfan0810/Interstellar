package cn.intersteller.darkintersteller.service.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.Book;
import cn.intersteller.darkintersteller.BookManager;

public class BookManagerService extends Service {
    private List<Book> mBooks = new ArrayList<>();
    public final String TAG = "dengaidl"+this.getClass().getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBookManagerStub();
    }

    class MyBookManagerStub extends BookManager.Stub {

        @Override
        public Book addBookIn(Book book) throws RemoteException {
            synchronized (this) {
                if (mBooks == null) {
                    mBooks = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in In");
                    book = new Book();
                }
                //尝试修改book的参数，主要是为了观察其到客户端的反馈
                book.setId(1);
                if (!mBooks.contains(book)) {
                    mBooks.add(book);
                }
                //打印mBooks列表，观察客户端传过来的值
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBooks.toString());
                return book;
            }
        }

        @Override
        public Book addBookOut(Book book) throws RemoteException {
            synchronized (this) {
                if (mBooks == null) {
                    mBooks = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in Out");
                    book = new Book();
                }
                book.setId(2);
                if (!mBooks.contains(book)) {
                    mBooks.add(book);
                }
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBooks.toString());
                return book;
            }
        }

        @Override
        public Book addBookInout(Book book) throws RemoteException {
            synchronized (this) {
                if (mBooks == null) {
                    mBooks = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in Inout");
                    book = new Book();
                }
                book.setId(3);
                if (!mBooks.contains(book)) {
                    mBooks.add(book);
                }
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBooks.toString());
                return book;
            }
        }


        @Override
        public List<Book> getBooks() throws RemoteException {
            synchronized (this) {
                if (mBooks == null) {
                    return new ArrayList<>();
                }
                return mBooks;
            }
        }
    }
    @Override
    public void onCreate() {
        Book book = new Book();
        book.setName("Android开发艺术探索");
        book.setId(28);
        mBooks.add(book);
        super.onCreate();
    }
}
