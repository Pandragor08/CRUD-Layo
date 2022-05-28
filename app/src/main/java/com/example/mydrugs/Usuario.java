package com.example.mydrugs;

import android.widget.Toast;

public class Usuario {
    int id;
    String Name,Email,Passwords;

    public Usuario(){
    }

    public Usuario(String name,String email,String passwords){
    Name = name;
    Email =email;
    Passwords =passwords;
    }

    public boolean isNull(){
        if (Name.equals("") && Email.equals("") && Passwords.equals("")){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Passwords='" + Passwords + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasswords() {
        return Passwords;
    }

    public void setPasswords(String passwords) {
        Passwords = passwords;
    }
}
