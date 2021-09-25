package com.androidstudio.goshadudar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidstudio.goshadudar.MainActivity;
import com.androidstudio.goshadudar.R;
import com.androidstudio.goshadudar.model.Category;
import com.androidstudio.goshadudar.model.Course;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategotyViweHolder> {
    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategotyViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categotiesItem = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategotyViweHolder(categotiesItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CategotyViweHolder holder, int position) {
        holder.categoryTitle.setText(categories.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showCoursesByCategory(categories.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategotyViweHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;

        public CategotyViweHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
        }
    }


}
