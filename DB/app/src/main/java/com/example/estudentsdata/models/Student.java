package com.example.estudentsdata.models;

public class Student {

    int id;//id
    String name;//nombre
    boolean gender;//genero
    short age;//edad
    String code;//codigo
    int semester;//semestre

    public Student(int id, String name, boolean gender, short age, String code, int semester) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.code = code;
        this.semester = semester;
    }

    public Student(String name, boolean gender, short age, String code, int semester) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.code = code;
        this.semester = semester;
    }

    public Student() {
        this.name ="-";
        this.gender =false;
        this.age = 0;
        this.code ="-";
        this.semester =0;
    }

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                "\nname= '" + name + '\'' +
                "\ngender= " + (gender?" male":" female") +
                "\nage= " + age +
                "\ncode= '" + code + '\'' +
                "\nsemester= " + semester +
                '\n';
    }
}
