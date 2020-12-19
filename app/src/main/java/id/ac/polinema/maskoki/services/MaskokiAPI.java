package id.ac.polinema.maskoki.services;

import id.ac.polinema.maskoki.models.AccountModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MaskokiAPI {

    @POST("users/token")
    Call<AccountModel> login(@Body AccountModel accountModel);

    @POST("users/register")
    Call<AccountModel> register(@Body AccountModel accountModel);

}
