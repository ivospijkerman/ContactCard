package nl.spijkerman.ivo.contactcard.controller;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Arrays;

import nl.spijkerman.ivo.contactcard.model.Contact;
import nl.spijkerman.ivo.contactcard.model.Location;
import nl.spijkerman.ivo.contactcard.model.Name;
import nl.spijkerman.ivo.contactcard.model.Picture;

// TODO create super Repo class
public class ContactRepository extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "contactCardApp";
    private static final String TABLE_NAME = "contact";


    public ContactRepository(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO normalize this
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY," +
                "firstName TEXT," +
                "lastName TEXT," +
                "email TEXT," +
                "street TEXT," +
                "postCode INTEGER," +
                "city TEXT," +
                "phone TEXT," +
                "cell TEXT," +
                "picture TEXT," +
                "thumbnail TEXT" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES" +
                "(1, 'connor', 'castro', 'connor.castro@example.com', '9270 church lane', 9405, 'durham', '023 3983 9387', '0709-807-276', 'https://randomuser.me/api/portraits/men/52.jpg', 'https://randomuser.me/api/portraits/thumb/men/52.jpg');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES" +
                    "(2, 'bonnor', 'bastro', 'connor.castro@example.com', '9270 church lane', 9405, 'durham', '023 3983 9387', '0709-807-276', 'https://randomuser.me/api/portraits/men/53.jpg', 'https://randomuser.me/api/portraits/thumb/men/53.jpg');");
    }

    // TODO make this better
    public Contact[] getAll() {
        return new Contact[]{getById(1), getById(2)};
    }

    public Contact getById(int id) throws IllegalArgumentException {
        SQLiteDatabase db = this.getReadableDatabase();
        // TODO use normal query
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id, null)) {
            if (cursor == null || cursor.getCount() == 0)
                throw new IllegalArgumentException();

            cursor.moveToFirst();

            Contact contact = new Contact();
            // TODO use this
            // contact.id = cursor.getInt(0);

            Name name = new Name();
            name.title = "";
            name.first = cursor.getString(1);
            name.last = cursor.getString(2);
            contact.name = name;

            contact.email = cursor.getString(3);

            Location location = new Location();
            location.street = cursor.getString(4);
            location.postcode = cursor.getInt(5);
            location.city = cursor.getString(6);
            contact.location = location;

            contact.phone = cursor.getString(7);
            contact.cell = cursor.getString(8);

            Picture picture = new Picture();
            picture.large = cursor.getString(9);
            picture.thumbnail = cursor.getString(10);
            contact.picture = picture;

            return contact;
        }
    }
}
