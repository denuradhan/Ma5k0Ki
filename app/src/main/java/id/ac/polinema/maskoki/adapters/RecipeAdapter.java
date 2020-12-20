package id.ac.polinema.maskoki.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.ac.polinema.maskoki.databinding.RcRecipeBinding;
import id.ac.polinema.maskoki.models.RecipeModel;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private List<RecipeModel> recipeModelList;

    public RecipeAdapter(List<RecipeModel> recipeModelList) {
        this.recipeModelList = recipeModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RcRecipeBinding rcRecipeBinding = RcRecipeBinding.inflate(layoutInflater, parent, false);
        return new RecipeViewHolder(rcRecipeBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder holder, int position) {
        RecipeModel recipeModel = recipeModelList.get(position);
        holder.bind(recipeModel);
    }

    @Override
    public int getItemCount() {
        if (recipeModelList!=null){
            return recipeModelList.size();
        }else{
            return 0;
        }
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        private RcRecipeBinding binding;

        public RecipeViewHolder(RcRecipeBinding rcRecipeBinding) {
            super(rcRecipeBinding.getRoot());
            this.binding = rcRecipeBinding;
        }

        public void bind(RecipeModel recipeModel){
            binding.setRecipeModel(recipeModel);
            Glide.with(itemView.getContext())
                    .load(recipeModel.getImage())
                    .into(binding.imageView);
            binding.executePendingBindings();
        }
    }
}
