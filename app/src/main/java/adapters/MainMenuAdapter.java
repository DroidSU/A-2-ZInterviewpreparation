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
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.morningstar.aptitude.R;

import java.util.ArrayList;

import activities.AptitudeCategoryActivity;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MyViewHolder> {

    private ArrayList<String> item_names;
    private ArrayList<Integer> item_icons;
    private Context context;

    public MainMenuAdapter(ArrayList<String> item_names, ArrayList<Integer> item_icons, Context context) {
        this.item_names = item_names;
        this.item_icons = item_icons;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_grid_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView.setText(item_names.get(position));
        holder.imageView.setImageResource(item_icons.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartNewActivity(position);
            }
        });
    }

    private void StartNewActivity(int pos) {
        switch (pos) {
            case 0:
                Intent intent = new Intent(context, AptitudeCategoryActivity.class);
                context.startActivity(intent);
                break;
            case 6:
                Toast.makeText(context, "Rate Us!", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(context, "About Us!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, "Not defined yet!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public int getItemCount() {
        return item_names.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.main_grid_text);
            imageView = view.findViewById(R.id.main_grid_image);
            cardView = view.findViewById(R.id.cardview);
        }
    }
}
