package id.ac.polinema.maskoki.services;

import java.util.List;

import id.ac.polinema.maskoki.models.AccountModel;
import id.ac.polinema.maskoki.models.RecipeModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MaskokiAPI {

    @POST("users/token")
    Call<AccountModel> login(@Body AccountModel accountModel);

    @POST("users/register")
    Call<AccountModel> register(@Body AccountModel accountModel);

    @GET("recipes")
    Call<List<RecipeModel>> listRecipes();
}
