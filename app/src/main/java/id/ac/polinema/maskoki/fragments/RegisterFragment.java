package id.ac.polinema.maskoki.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.ac.polinema.maskoki.R;
import id.ac.polinema.maskoki.databinding.FragmentRegisterBinding;
import id.ac.polinema.maskoki.models.AccountModel;
import id.ac.polinema.maskoki.viewlModels.MaskokiViewModel;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private AccountModel accountModel;
    private MaskokiViewModel viewModel;

    public RegisterFragment() {
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
        viewModel = new ViewModelProvider(requireActivity()).get(MaskokiViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        binding.setFragment(this);
        binding.setAccountModel(accountModel);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    public void onRegisterClicked(View v){
        if(binding.editTextPassword.getText().toString().equals(binding.editTextRepeatPassword.getText().toString())){
            viewModel.setAccountModelMutableLiveData(accountModel);
            viewModel.callRegister(v);
        }else{
            Toast.makeText(getContext(),"your password is invalid", Toast.LENGTH_SHORT).show();
        }
    }
}