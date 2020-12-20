package id.ac.polinema.maskoki.models;

import com.google.gson.annotations.SerializedName;

public class RecipeModel {
    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("instructions")
    private String instructions;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
}
