package id.ac.polinema.maskoki.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.ac.polinema.maskoki.R;
import id.ac.polinema.maskoki.adapters.RecipeAdapter;
import id.ac.polinema.maskoki.databinding.FragmentHomeBinding;
import id.ac.polinema.maskoki.models.RecipeModel;
import id.ac.polinema.maskoki.viewlModels.MaskokiViewModel;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private MaskokiViewModel maskokiViewModel;
    private RecipeAdapter adapter;

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
        maskokiViewModel.retrofitInitiation();
        maskokiViewModel.callRecipe();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRvRecipe();
    }

    public void setUpRvRecipe(){
        RecyclerView recyclerView = binding.rcRecipe;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        maskokiViewModel.getRecipeModelListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<RecipeModel>>() {
            @Override
            public void onChanged(List<RecipeModel> recipeModels) {
                adapter = new RecipeAdapter(recipeModels);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}