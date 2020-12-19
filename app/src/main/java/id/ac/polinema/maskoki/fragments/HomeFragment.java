package id.ac.polinema.maskoki.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.polinema.maskoki.R;
import id.ac.polinema.maskoki.databinding.FragmentHomeBinding;
import id.ac.polinema.maskoki.viewlModels.MaskokiViewModel;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private MaskokiViewModel maskokiViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        maskokiViewModel = new ViewModelProvider(requireActivity()).get(MaskokiViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setFragment(this);
        binding.setViewModel(maskokiViewModel);
        return binding.getRoot();
    }
}