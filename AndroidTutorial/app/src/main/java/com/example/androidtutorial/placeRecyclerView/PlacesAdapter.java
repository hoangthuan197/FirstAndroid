package com.example.androidtutorial.placeRecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtutorial.R;
import com.example.androidtutorial.placeRecyclerView.Places;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {

    public Context context;
    public ArrayList<Places> data;

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.places_item_layout, viewGroup, false);
        PlacesViewHolder placesViewHolder = new PlacesViewHolder(view);

        return placesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {
        Places places = data.get(i);
        placesViewHolder.tvPlaceName.setText(places.getPlaceName());
        placesViewHolder.tvIsPromotion.setText("프로모션");
        placesViewHolder.tvIsMoreDetail.setText("상세보기");
        if (places.isPromotion == 1) {
            placesViewHolder.tvIsPromotion.setVisibility(View.VISIBLE);
        } else {
            placesViewHolder.tvIsPromotion.setVisibility(View.INVISIBLE);
        }
        if (places.isMoreDetail == 1) {
            placesViewHolder.tvIsMoreDetail.setVisibility(View.VISIBLE);
        } else {
            placesViewHolder.tvIsMoreDetail.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PlacesViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlaceName, tvIsMoreDetail, tvIsPromotion;

        public PlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaceName = itemView.findViewById(R.id.tv_placeName);
            tvIsMoreDetail = itemView.findViewById(R.id.tv_isMoreDetail);
            tvIsPromotion = itemView.findViewById(R.id.tv_isPromotion);
        }
    }


}
