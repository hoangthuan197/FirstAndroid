package winds.com.androidtutorial.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<Category> data;
    Context context;

    public CategoryAdapter(ArrayList<Category> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cate_item_layout, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        Category category = data.get(i);
        if(category.getCategoryID() < 0 ){
            vBg.setBackground(context.getDrawable(R.drawable.gradient_pink_bg));
        }else if(category.type == 2){
            vBg.setBackground(context.getDrawable(R.drawable.gradient_yellow_dark_bg));
        }else if (i == 0){
            vBg.setBackground(context.getDrawable(R.drawable.gradient_orange_dark_bg));
        }else {
            vBg.setBackground(context.getDrawable(R.drawable.gradient_orange_bg));
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    View vBg;

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            vBg = itemView.findViewById(R.id.v_bg);
        }
    }
}
