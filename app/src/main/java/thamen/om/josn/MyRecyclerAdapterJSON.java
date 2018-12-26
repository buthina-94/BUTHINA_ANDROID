package thamen.om.josn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import thamen.om.SupportItimes;
import thamen.om.thamen.R;

/**
 * Created by sasmob on 12/2/2018.
 */

public class MyRecyclerAdapterJSON extends RecyclerView.Adapter<MyRecyclerAdapterJSON.MyViewHolder> {

        private ArrayList<SupportItimes> dataset,itimes;
        private Context context;
    private Context mContext;

    //i miss dataset here
    public MyRecyclerAdapterJSON(ArrayList<Movie> itimes, FragmentActivity activity) {
        this.itimes = itimes;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.bb,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
    Movie itimes=dataset.get(position);
    holder.textView1.setText(itimes.getTitle());
    holder.textView2.setText("Rating:"+itimes.getTitle());
    holder.textView3.setText("Release Year:"+itimes.getReleaseYear());
    Picasso.with(mContext).load(itimes.getImageUrl()).into(holder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        CircleImageView circleImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.title);
            textView2=itemView.findViewById(R.id.rating);
            textView3=itemView.findViewById(R.id.year);
            circleImageView=itemView.findViewById(R.id.item_info);
        }
    }
}
