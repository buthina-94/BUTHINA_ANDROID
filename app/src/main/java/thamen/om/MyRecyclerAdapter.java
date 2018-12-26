package thamen.om;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import thamen.om.thamen.R;
import thamen.om.utils.SupportItimes1;

/**
 * Created by sasmob on 12/2/2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

        private ArrayList<SupportItimes> dataset;
    private ArrayList<SupportItimes1> itmes;
        private Context context;
//i miss dataset here
    public MyRecyclerAdapter(ArrayList<SupportItimes1> itmes, FragmentActivity activity) {
        this.itmes = itmes;
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
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.MyViewHolder holder, int position) {
    SupportItimes itimes=dataset.get(position);holder.textView.setText(itimes.getName());
    holder.circleImageView.setImageResource(itimes.getImageView());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CircleImageView circleImageView;
        @SuppressLint("WrongViewCast")
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.photo2);
            circleImageView=itemView.findViewById(R.id.text3);
        }
    }
}
