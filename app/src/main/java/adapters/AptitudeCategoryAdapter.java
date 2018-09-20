/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */
package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.morningstar.aptitude.R;

import java.util.ArrayList;

import activities.MultipleChoiceQuestionsActivity;

public class AptitudeCategoryAdapter extends RecyclerView.Adapter<AptitudeCategoryAdapter.SubCategoryViewHolder> {

    private ArrayList<String> title;
    private ArrayList<Integer> icon;
    private Context context;

    public AptitudeCategoryAdapter(ArrayList<String> title, ArrayList<Integer> icon, Context context) {
        this.title = title;
        this.icon = icon;
        this.context = context;
    }

    @NonNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_category_item_layout, parent, false);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryViewHolder holder, final int position) {
        holder.textView.setText(title.get(position));
        holder.icon_image.setImageResource(icon.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartQuestionsActivity(position);
            }
        });
    }

    private void StartQuestionsActivity(int pos) {
        switch (pos){
            case 0:
                Intent questionsIntent = new Intent(context, MultipleChoiceQuestionsActivity.class);
                context.startActivity(questionsIntent);
                break;
            default:
                Toast.makeText(context, "Clicked on "+pos, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class SubCategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon_image;
        private TextView textView;
        private LinearLayout linearLayout;
        public SubCategoryViewHolder(View itemView) {
            super(itemView);
            icon_image = itemView.findViewById(R.id.sub_category_icon);
            textView = itemView.findViewById(R.id.sub_category_title);
            linearLayout = itemView.findViewById(R.id.sub_cat_item_parent);
        }
    }
}
