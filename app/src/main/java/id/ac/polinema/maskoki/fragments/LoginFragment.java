package id.ac.polinema.maskoki.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.polinema.maskoki.R;
import id.ac.polinema.maskoki.databinding.FragmentLoginBinding;
import id.ac.polinema.maskoki.models.AccountModel;
import id.ac.polinema.maskoki.viewlModels.MaskokiViewModel;

public class LoginFragment extends Fragment {
    public static final String TAG = "TESTING";

    private FragmentLoginBinding binding;
    private AccountModel accountModel;
    private MaskokiViewModel maskokiViewModel;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountModel = new AccountModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        maskokiViewModel = new ViewModelProvider(requireActivity()).get(MaskokiViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.setFragment(this);
        binding.setAccountModel(accountModel);
        binding.setViewModel(maskokiViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        maskokiViewModel.retrofitInitiation();
    }

    public void onLoginClicked(View v){
        maskokiViewModel.setAccountModelMutableLiveData(accountModel);
        maskokiViewModel.callLoginAPI(v);
    }
}