package hongkhanh.on_thi3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {
    private static String DB_NAME = "DEMO3";
    private static String TABLE_NAME = "girl";
    private static String ID = "id";
    private static String NAME = "name";
    private static String AGE = "age";
    private static String SEX = "sex";
    private static String IMAGE = "image";
    private static int VERSION = 1;

    public DBManager(Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.d("DBManager", "");
    }

    String QueryCreate = "CREATE TABLE " + TABLE_NAME + "(" +
            ID + " INTEGER PRIMARY KEY, " +
            NAME + " TEXT, " +
            AGE + " TEXT, " +
            SEX + " TEXT, " +
            IMAGE + " TEXT)";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QueryCreate);
        Log.d("DBManager", "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Model> gettAllGirl()

    {
        ArrayList<Model> listGirl = new ArrayList<>();
        String QuerySelectAll = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(QuerySelectAll, null);
        try {
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                String sex = cursor.getString(3);
                String image = cursor.getString(4);
                listGirl.add(new Model(id,name, age, image, sex));
            } while (cursor.moveToNext());

            database.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listGirl;
    }

    public void AddGirl(String name, String age, String sex, String image) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(SEX, sex);
        contentValues.put(IMAGE, image);
        database.insert(TABLE_NAME, null, contentValues);
        Log.d("DBManager", "Add Girl");
    }

    public int UpdateGirl(String id, String name, String age, String sex, String image) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(SEX, sex);
        contentValues.put(IMAGE, image);
        Log.d("DBManager", "Update Girl");
        return database.update(TABLE_NAME, contentValues, ID + "=?", new String[]{id});
    }

    public void DeleteGirl() {
        Log.d("DBManager", "Delte Girl");
    }
}
