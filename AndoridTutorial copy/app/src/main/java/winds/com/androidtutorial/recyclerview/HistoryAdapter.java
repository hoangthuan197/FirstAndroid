package winds.com.androidtutorial.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {


    Context context;
    ArrayList<History> data;

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout,
                viewGroup, false);
        HistoryViewHolder historyViewHolder = new HistoryViewHolder(view);
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyViewHolder, int i) {
        History history = data.get(i);
        historyViewHolder.tvTitle.setText(history.getTitle());
        historyViewHolder.tvPoint.setText(history.getPoint() + "");
//        if (history.point > 10){
//            historyViewHolder.tvPoint.setVisibility(View.INVISIBLE);
//        }else{
//            historyViewHolder.tvPoint.setVisibility(View.VISIBLE);
//        }


        Picasso.get().load(history.getIcon()).into(historyViewHolder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPoint;
        CircleImageView imgIcon;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPoint = itemView.findViewById(R.id.tv_point);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgIcon = itemView.findViewById(R.id.img_icon);
        }
    }

}
