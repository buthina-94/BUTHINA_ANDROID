package thamen.om.book;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Source;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

        private ArrayList<Books> dataSet;
        Source source;
        private ArrayList<Source> arrayList;
        private Context mContext;
        private CardView cardView;

        private OnAdapterItemClick onClick;
        public interface OnAdapterItemClick{
            void onItemClick(int position);
        }
        public void newMethod(OnAdapterItemClick onClick){
            this.onClick=onClick;
        }
        public BookAdapter(ArrayList<Books> dataSet, Context mContext) {
            this.dataSet = dataSet;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view= layoutInflater.inflate(R.layout.book_adpter,parent,false);
            cardView=view.findViewById(R.id.card_view);

            return new MyViewHolder(view);

        }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            Books items=dataSet.get(position);

            holder.textView1.setText(items.getAuthor());
            holder.textView2.setText(items.getTitle());
            holder.textView3.setText(items.getDescription());
            // arrayList=items.getSourceArrayList();
            //  holder.textView4.setText(items.getSource().getId());
            //  holder.textView5.setText(items.getSource().getName());


            // holder.came.setImageResource(items.getImage());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onItemClick(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView1,textView2,textView3,textView4,textView5;
            RecyclerView came;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView1=itemView.findViewById(R.id.author);
                textView2=itemView.findViewById(R.id.title);
                textView3=itemView.findViewById(R.id.description);
                // textView4=itemView.findViewById(R.id.id);
                //   textView5=itemView.findViewById(R.id.name);
                came=itemView.findViewById(R.id.came);


            }
        }

    }


}
