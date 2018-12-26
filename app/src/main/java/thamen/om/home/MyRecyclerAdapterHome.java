package thamen.om.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import thamen.om.SupportItimes;
import thamen.om.utils.SupportItimes1;

/**
 * Created by sasmob on 12/2/2018.
 */

public class MyRecyclerAdapterHome extends RecyclerView.Adapter <MyRecyclerAdapterHome.MyViewHolder> {
    private ArrayList<SupportItimes1> items; //container that will hold the data
    private Context context;
    private CardView cardView;
    private onAdapterItemClick onClick; //step3 :declare variable of interface type

    public interface onAdapterItemClick{   //step1 : define interface with int argument
        void onItemClick(int position);
    }
    public void newMethod(onAdapterItemClick onClick) {
        this.onClick = onClick;
    }

    public MyRecyclerAdapterHome(ArrayList<SupportItimes> items, Context context) {
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE); //attach layouts
        View view = layoutInflater.inflate(R.layout.home_adapter,parent,false); //using obj inflate that layout
        cardView=view.findViewById(R.id.card_view); //step5
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) { //attach data and update
        SupportItems item= items.get(position);
        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(item.getImageView());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size(); //container name declared previous up (items)
    }

    public class MyViewHolder extends RecyclerView.ViewHolder { //find all the views
        TextView textView;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.item_info);
        }
    }
}

