package com.david.mydog.utils;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.david.mydog.models.Pets;

import java.util.ArrayList;
import java.util.List;


public class DBM extends SQLiteOpenHelper {

    Context context;

    //Tipos de datos a utilizar en las tablas
    String STRING_TYPE = "text";
    String INT_TYPE = "integer";
    String BOOLEAN_TYPE = "boolean";


    //nombres de las tablas de la base de datos
    String TABLE_NAME_PETS = "Pets";

    /*
        SECCION DISPUESTA PARA LA ESTRUCTURA DE LAS TABLAS
     */

    //Atributos de la tabla pets
    String PTS_NAME = "name";
    String PTS_SPECIES = "species";
    String PTS_RACE = "race";
    String PTS_HAIRCOLOR = "hairColor";
    String PTS_DATEBIRTH = "dateBirth";
    String PTS_WEIGHT = "weight";
    String PTS_OWNERNAME = "ownerName";
    String PTS_OWNERID = "ownersID";

    //Script para la tabla pets
    String CREATE_PETS_TBL_SCRIPT =
            "CREATE TABLE " + TABLE_NAME_PETS +
                    " (" +
                    PTS_NAME + " " + STRING_TYPE + ", " +
                    PTS_SPECIES + " " + STRING_TYPE + ", " +
                    PTS_RACE + " " + STRING_TYPE + ", " +
                    PTS_HAIRCOLOR + " " + STRING_TYPE + ", " +
                    PTS_DATEBIRTH + " " + STRING_TYPE + ", " +
                    PTS_WEIGHT + " " + INT_TYPE + ", " +
                    PTS_OWNERNAME + " " + STRING_TYPE + ", " +
                    PTS_OWNERID + " " + INT_TYPE + "); ";


    public DBM(Context context) {
        super(context, "Pets", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PETS_TBL_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Eliminar las tablas
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PETS);

        //Crear las tablas con la nueva estructura
        db.execSQL(CREATE_PETS_TBL_SCRIPT);
    }

    //Insertar el registro de un mascota en la tabla
    //mascotas
    public boolean insertPetTuple(Pets s) {

        boolean ret = false;
        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            try {
                String q =
                        "INSERT INTO " + TABLE_NAME_PETS + " ("
                                + PTS_NAME + ", "
                                + PTS_SPECIES + ", "
                                + PTS_RACE + ", "
                                + PTS_HAIRCOLOR + ", "
                                + PTS_DATEBIRTH + ", "
                                + PTS_WEIGHT + ", "
                                + PTS_OWNERNAME + ", "
                                + PTS_OWNERID + ") "
                                + " VALUES ("
                                + s.getName() + ", "
                                + " '" + s.getSpecies() + "', "
                                + " '" + s.getRace() + "', "
                                + s.getHairColor() + ", "
                                + " '" + s.getDateBirth() + "', "
                                + " '" + s.getWeight() + "', "
                                + " '" + s.getOwnerName() + "', "
                                + s.getOwnersID() + "); ";

                db.execSQL(q);
                ret = true;
                db.close();
            } catch (Exception e) {
                db.close();
                e.getStackTrace();
                ret = false;
            }
        }

        return ret;
    }

    public List<Pets> listPets() {

        List<Pets> l = new ArrayList<Pets>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_PETS, null);

        while (c.moveToNext()) {
            Pets s = new Pets(

                    c.getString(1), // PTS_NAME
                    c.getString(2), //PTS_SPECIES
                    c.getString(3), //PTS_RACE
                    c.getString(4), //PTS_HAIRCOLOR
                    c.getString(5), // PTS_DATEBIRTH
                    c.getInt(6), //PTS_WEIGHT
                    c.getString(7), //PTS_OWNERNAME
                    c.getInt(8)//PTS_OWNERID

            );
            l.add(s);
        }

        c.close();
        db.close();

        return l;
    }

    public boolean updateAll(String val) {
        boolean ret = false;

        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            try {
                String q = "UPDATE " + TABLE_NAME_PETS +
                        " SET "
                        + PTS_OWNERID + " = '" + val + "' ";

                db.execSQL(q);
                ret = true;
            } catch (Exception e) {
                db.close();
                e.getStackTrace();
                ret = false;
            }
        }

        return ret;
    }

    public boolean deleteAll() {
        boolean ret = false;

        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            try {
                String q = "DELETE FROM " + TABLE_NAME_PETS;
                db.execSQL(q);
                ret = true;
            } catch (Exception e) {
                db.close();
                ret = false;
                e.getStackTrace();
            }
        }

        db.close();

        return ret;
    }

    public boolean updatePets(Pets s) {
        boolean ret = false;

        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            try {

                String q = "UPDATE " + TABLE_NAME_PETS +
                        " SET "
                        + PTS_NAME + " = '" + s.getName() + "', "
                        + PTS_SPECIES + " = '" + s.getSpecies() + "', "
                        + PTS_RACE + " = '" + s.getRace() + "', "
                        + PTS_HAIRCOLOR + " = '" + s.getHairColor() + "', "
                        + PTS_DATEBIRTH + " = '" + s.getDateBirth() + "', "
                        + PTS_WEIGHT + " = '" + s.getWeight() + "', "
                        + PTS_OWNERNAME + " = '" + s.getOwnerName() + "', "
                        + PTS_OWNERID + " = '" + s.getOwnersID() + "', "
                        + " WHERE " + PTS_OWNERID + " = '" + s.getOwnersID() + "'";

                db.execSQL(q);
                ret = true;
            } catch (Exception e) {
                db.close();
                e.getStackTrace();
                ret = false;
            }
        }

        return ret;
    }

    public boolean deletePetsById(Pets s) {

        boolean ret = false;

        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            try {
                String q = "DELETE FROM " + TABLE_NAME_PETS +
                        " WHERE " + PTS_OWNERID + " = " + s.getOwnersID();
                db.execSQL(q);
                ret = true;
            } catch (Exception e) {
                db.close();
                ret = false;
                e.getStackTrace();
            }
        }

        db.close();

        return ret;
    }

}
