package com.example.mydrugs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dataMedicament  extends SQLiteOpenHelper {

    Medicamento m;
    ArrayList<Medicamento> list;
    SQLiteDatabase sql;

    private Context context;
    private static final String DB_name ="Medicamento.db";
    private static final int DB_version = 1;

    private static final String TABLE_NAME ="medicina";
    private static final String COLUMN_ID ="_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MATRICULA ="matricula";
    private static final String COLUMN_PRECIO ="precio";



    dataMedicament(@Nullable Context context) {
        super(context, DB_name, null, DB_version);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_MATRICULA + " INTEGER, " +
                        COLUMN_PRECIO + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }

    void addM(String name, int m, int p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MATRICULA, m);
        cv.put(COLUMN_PRECIO, p);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Fallo", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Agregado Correctamente!", Toast.LENGTH_SHORT).show();
        }
    }


    Cursor readM(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateM(String row_id, String name, String cedula, String precio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MATRICULA, cedula);
        cv.put(COLUMN_PRECIO, precio);
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Algo fallo!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Avtualizado correctamente!", Toast.LENGTH_SHORT).show();
        }
    }

    void eliminar(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Fallo la eliminacion", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Se elimino", Toast.LENGTH_SHORT).show();
        }
    }
    void borrarTodo(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    public int buscarM(String m){
        int x=0;
        list =selectUser();
        for (Medicamento medicamento:list) {
            if (medicamento.getMedicamento().equals(m)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Medicamento> selectUser(){
        ArrayList<Medicamento> list=new ArrayList<Medicamento>();
        list.clear();
        Cursor cursor= sql.rawQuery("select * from usuario", null);
        if (cursor!=null && cursor.moveToFirst()){
            do {
                Medicamento u= new Medicamento();
                u.setId(cursor.getInt(0));
                u.setMedicamento(cursor.getString(1));
                u.setMatricula(cursor.getString(2));
                u.setPrecio(cursor.getString(3));
                list.add(u);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
