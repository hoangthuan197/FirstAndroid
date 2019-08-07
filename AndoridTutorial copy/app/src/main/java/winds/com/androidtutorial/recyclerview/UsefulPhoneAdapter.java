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
import winds.com.androidtutorial.recyclerview.model.UsefulPhone;

public class UsefulPhoneAdapter extends RecyclerView.Adapter<UsefulPhoneAdapter.UsefulPhoneViewHolder> {

    ArrayList<UsefulPhone> data = new ArrayList<>();
    Context context;

    public UsefulPhoneAdapter(ArrayList<UsefulPhone> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public UsefulPhoneViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.useful_phone_item_layout  , viewGroup, false);
        return new UsefulPhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsefulPhoneViewHolder placeViewHolder, int i) {
        UsefulPhone usefulPhone = data.get(i);
        placeViewHolder.tvPhone.setText(usefulPhone.name);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class UsefulPhoneViewHolder extends RecyclerView.ViewHolder {
        View vRoot;
        TextView tvPhone;

        public UsefulPhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            vRoot = itemView.findViewById(R.id.v_root);
            tvPhone = itemView.findViewById(R.id.tv_phone_name);
        }
    }
}
