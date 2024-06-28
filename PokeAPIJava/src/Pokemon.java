/*
        Full Name
        Number
        Generation
        Evolutions
        Average Weight
        Abilities
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pokemon {
    @SerializedName("name") private String name;
    @SerializedName("id") private int id;
    @SerializedName("generation") private String generation;


    public Pokemon(String name, int id, String generation) {
        this.name = name;
        this.id = id;
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public String toString() {
        return "\n\nName: " + name + "\n#id " + id +"\nGeneration: " + generation + "\n";
    }

}
