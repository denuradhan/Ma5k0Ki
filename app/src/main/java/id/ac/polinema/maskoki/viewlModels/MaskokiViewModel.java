package id.ac.polinema.maskoki.viewlModels;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.maskoki.R;
import id.ac.polinema.maskoki.models.AccountModel;
import id.ac.polinema.maskoki.models.RecipeModel;
import id.ac.polinema.maskoki.services.MaskokiAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MaskokiViewModel extends ViewModel {
    public static final String TAG = "TESTING";
    private MutableLiveData<AccountModel> accountModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<RecipeModel>> recipeModelListMutableLiveData =
            new MutableLiveData<>(new ArrayList<>());
    private Retrofit retrofit;
    private MaskokiAPI service;

    public MutableLiveData<List<RecipeModel>> getRecipeModelListMutableLiveData() {
        return recipeModelListMutableLiveData;
    }

    public void setAccountModelMutableLiveData(MutableLiveData<AccountModel> accountModelMutableLiveData) {
        this.accountModelMutableLiveData = accountModelMutableLiveData;
    }

    public void setAccountModelMutableLiveData(AccountModel accountModel){
        this.accountModelMutableLiveData.setValue(accountModel);
    }

    public MutableLiveData<AccountModel> getAccountModelMutableLiveData() {
        return accountModelMutableLiveData;
    }

    public void retrofitInitiation(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://maskoki.dhanifudin.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MaskokiAPI.class);
    }

    public void callLoginAPI(View v){
        Call<AccountModel> call = service.login(accountModelMutableLiveData.getValue());
        call.enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(Call<AccountModel> call, Response<AccountModel> response) {
                if(response.isSuccessful()){
                    accountModelMutableLiveData.setValue(response.body());
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_homeFragment);
                    Log.i(TAG, "onResponse: login berhasil");
                }else{
                    Log.i(TAG, "onResponse: login gagal");
                }
            }

            @Override
            public void onFailure(Call<AccountModel> call, Throwable t) {
                Log.i(TAG, "onFailure: API Tidak konek");
            }
        });
    }

    public void onRegisterClicker(View v){
        Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment);
    }

    public void callRegister(View v){
        Call<AccountModel> call = service.register(accountModelMutableLiveData.getValue());
        call.enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(Call<AccountModel> call, Response<AccountModel> response) {
                if(response.isSuccessful()){
                    accountModelMutableLiveData.setValue(response.body());
                    Log.i(TAG, "onResponse: Register Berhasil");
                    Navigation.findNavController(v).navigateUp();
                }else{
                    Log.i(TAG, "onResponse: Register Gagal");
                }
            }

            @Override
            public void onFailure(Call<AccountModel> call, Throwable t) {
                Log.i(TAG, "onFailure: Gagal connect ke API");
            }
        });
    }

    public void callRecipe(){
        Call<List<RecipeModel>> call = service.listRecipes();
        call.enqueue(new Callback<List<RecipeModel>>() {
            @Override
            public void onResponse(Call<List<RecipeModel>> call, Response<List<RecipeModel>> response) {
                if(response.isSuccessful()){
                    recipeModelListMutableLiveData.setValue(response.body());
                    Log.i(TAG, "onResponse: berhasil");
                }else{
                    Log.i(TAG, "onResponse: gagal");
                }
            }

            @Override
            public void onFailure(Call<List<RecipeModel>> call, Throwable t) {
                Log.i(TAG, "onFailure: Gagal connect ke API");
            }
        });
    }
}
