package winds.com.androidtutorial.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.Place;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    ArrayList<Place> data = new ArrayList<>();
    Context context;

    public PlaceAdapter(ArrayList<Place> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.place_item_layout, viewGroup, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder placeViewHolder, int i) {
        Place place = data.get(i);
        placeViewHolder.tvPlaceName.setText(place.getPlaceName());
        if (place.getIsMoreDetail() == 1){
            placeViewHolder.tvIsMoreDetail.setVisibility(View.VISIBLE);
            placeViewHolder.vRoot.setBackgroundColor(context.getResources().getColor(R.color.hightlight));
        }else{
            placeViewHolder.tvIsMoreDetail.setVisibility(View.GONE);
            placeViewHolder.vRoot.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        View vRoot;
        TextView tvPlaceName, tvIsMoreDetail, tvIsProtion;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            vRoot = itemView.findViewById(R.id.v_root);
            tvPlaceName = itemView.findViewById(R.id.tv_place_name);
            tvIsProtion = itemView.findViewById(R.id.tv_is_promotion);
            tvIsMoreDetail = itemView.findViewById(R.id.tv_is_more_detail);
        }
    }
}
