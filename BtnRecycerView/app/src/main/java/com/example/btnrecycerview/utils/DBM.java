package com.example.btnrecycerview.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.btnrecycerview.models.Student;

import java.util.ArrayList;
import java.util.List;

public class DBM extends SQLiteOpenHelper {
    Context context;

    // Data types to use in the tables
    String STRING_TYPE = "text";
    String INT_TYPE = "integer";
    String BOOLEAN_TYPE = "boolean";

    // names of the database tables
    String TABLE_NAME_STUDENTS = "Students";

    /*
        ARRANGED SECTION FOR THE STRUCTURE OF THE TABLES
     */

    // Attributes of the student table
    String STD_ID = "id";
    String STD_NAME = "name";
    String STD_GENDER = "gender";
    String STD_AGE = "age";
    String STD_CODE = "code";
    String STD_SEMESTER = "semester";
    //Script para la tabla estudiante
    String CREATE_STUDENT_TBL_SCRIPT =
            "CREATE TABLE " + TABLE_NAME_STUDENTS +
                    " (" +
                    STD_ID + " " + INT_TYPE + ", " +
                    STD_NAME + " " + STRING_TYPE + ", " +
                    STD_GENDER + " " + BOOLEAN_TYPE + ", " +
                    STD_AGE + " " + INT_TYPE + ", " +
                    STD_CODE + " " + STRING_TYPE + ", " +
                    STD_SEMESTER + " " + INT_TYPE + "); ";


    public DBM(Context context) {
        super(context, "Academic", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT_TBL_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop the tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_STUDENTS);

        // Create the tables with the new structure
        sqLiteDatabase.execSQL(CREATE_STUDENT_TBL_SCRIPT);
    }

    // Insert a student's record into the table
    //students
    public boolean insertStudentTuple(Student s) {

        boolean ret = false;
        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            try {
                String q =
                        "INSERT INTO " + TABLE_NAME_STUDENTS + " ("
                                + STD_ID + ", "
                                + STD_NAME + ", "
                                + STD_GENDER + ", "
                                + STD_AGE + ", "
                                + STD_CODE + ", "
                                + STD_SEMESTER + ") "
                                + " VALUES ("
                                + s.getId() + ", "
                                + " '" + s.getName() + "', "
                                + " '" + s.isGender() + "', "
                                + s.getAge() + ", "
                                + " '" + s.getCode() + "', "
                                + s.getSemester() + "); ";

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

    public List<Student> listStudents() {

        List<Student> l = new ArrayList<Student>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_STUDENTS, null);

        while (c.moveToNext()) {
            Student s = new Student(
                    c.getInt(0),//STD_ID
                    c.getString(1), //STD_NAME
                    Boolean.parseBoolean(c.getString(2)),//STD_GENDER
                    c.getShort(3),//STD_AGE
                    c.getString(4),//STD_CODE
                    c.getInt(5)//STD_SEMESTER
            );
            l.add(s);
        }

        c.close();
        db.close();

        return l;
    }
}
