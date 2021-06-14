package com.david.mydog.models;

public class Pets {

    String name; //nombre de la mascota
    String species; //especie
    String race; //raza
    String hairColor; //Color del pelo de la mascota
    String dateBirth; //fecha de nacimiento de la mascota
    int weight; //peso de la mascota
    String ownerName; //nombre del propietario de la mascota
    int ownersID; //cedula del propietario de la mascota

    public Pets(String name, String species, String race, String hairColor, String dateBirth, int weight, String ownerName, int ownersID) {
        this.name = name;
        this.species = species;
        this.race = race;
        this.hairColor = hairColor;
        this.dateBirth = dateBirth;
        this.weight = weight;
        this.ownerName = ownerName;
        this.ownersID = ownersID;
    }

    public Pets(String name, String species, String race, String hairColor, String dateBirth, int weight, String ownerName) {
        this.name = name;
        this.species = species;
        this.race = race;
        this.hairColor = hairColor;
        this.dateBirth = dateBirth;
        this.weight = weight;
        this.ownerName = ownerName;
    }

    public Pets() {
        this.name = "-";
        this.species = "-";
        this.race = "-";
        this.hairColor = "-";
        this.dateBirth = "-";
        this.weight = 0;
        this.ownerName = "-";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnersID() {
        return ownersID;
    }

    public void setOwnersID(int ownersID) {
        this.ownersID = ownersID;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", weight=" + weight +
                ", ownerName='" + ownerName + '\'' +
                ", ownersID=" + ownersID +
                '}';
    }
}
