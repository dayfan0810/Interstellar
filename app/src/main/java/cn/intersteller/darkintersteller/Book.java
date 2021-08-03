package cn.intersteller.darkintersteller;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public int id;
    public String name;

//    public Book(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    protected Book(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public Book() {
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    public void readFromParcel(Parcel dest) {
        id = dest.readInt();
        name = dest.readString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
