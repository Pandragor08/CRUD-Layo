package com.example.mydrugs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.util.ArrayList;

public class dataUser {

    Context c;
    Usuario u;
    ArrayList<Usuario> list;
    SQLiteDatabase sql;
    String db="RegistroUser";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, name text, pass text, email text)";
    String tabla2="create table if not exists vendedor(id integer primary key autoincrement, name text, pass text, email text)";


    public  dataUser(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(db,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        sql.execSQL(tabla2);
        u=new Usuario();
    }

    public boolean insertar(Usuario u){
        if (buscar(u.getName())==0){
            ContentValues contentValues=new ContentValues();
            contentValues.put("name",u.getName());
            contentValues.put("email",u.getEmail());
            contentValues.put("pass",u.getPasswords());
            return(sql.insert("usuario",null,contentValues)>0);
        }else {
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        list =selectUser();
        for (Usuario user:list) {
            if (user.getName().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUser(){
        ArrayList<Usuario> list=new ArrayList<Usuario>();
        list.clear();
        Cursor cursor= sql.rawQuery("select * from usuario", null);
        if (cursor!=null && cursor.moveToFirst()){
            do {
                Usuario u= new Usuario();
                u.setId(cursor.getInt(0));
                u.setName(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setPasswords(cursor.getString(3));
                list.add(u);

            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insertarV(Usuario u){
        if (buscarV(u.getName())==0){
            ContentValues contentValues=new ContentValues();
            contentValues.put("name",u.getName());
            contentValues.put("email",u.getEmail());
            contentValues.put("pass",u.getPasswords());
            return(sql.insert("vendedor",null,contentValues)>0);
        }else {
            return false;
        }
    }
    public int buscarV(String u){
        int x=0;
        list =selectSeller();
        for (Usuario user:list) {
            if (user.getName().equals(u)){
                x++;
            }
        }
        return x;
    }
    public ArrayList<Usuario> selectSeller(){
        ArrayList<Usuario> list=new ArrayList<Usuario>();
        list.clear();
        Cursor cursor= sql.rawQuery("select * from vendedor", null);
        if (cursor!=null && cursor.moveToFirst()){
            do {
                Usuario u= new Usuario();
                u.setId(cursor.getInt(0));
                u.setName(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setPasswords(cursor.getString(3));
                list.add(u);

            }while (cursor.moveToNext());
        }
        return list;
    }



    public int login(String n){
        int a=0;
        Cursor cursor=sql.rawQuery("select * from usuario", null);
        if (cursor!=null && cursor.moveToFirst()){
            do {
                if (cursor.getString(1).equals(n)){
                    a++;
                }
            }while (cursor.moveToNext());
        }
        return a;
    }
    public int loginV(String n){
        int a=0;
        Cursor cursor=sql.rawQuery("select * from vendedor", null);
        if (cursor!=null && cursor.moveToFirst()){
            do {
                if (cursor.getString(1).equals(n)){
                    a++;
                }
            }while (cursor.moveToNext());
        }
        return a;
    }


    public Usuario getName(String tagname, String pass_word){
        list=selectUser();
        for (Usuario u:list) {
            if (u.getName().equals(tagname) && u.getPasswords().equals(pass_word)){
                return u;
            }
        }
        return null;
    }


}
