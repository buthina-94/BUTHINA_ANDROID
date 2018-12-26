package thamen.om;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import thamen.om.thamen.R;

public class Adapter extends ArrayAdapter<SupportItimes> {

        private ArrayList<SupportItimes> itimes;
        private Context context;

        public Adapter(@NonNull Context context, ArrayList<SupportItimes> objects) {
            super(context, R.layout.mov1,objects);

            this.itimes=objects;
            this.context=context;

        }
        private static class ViewHolder{
            TextView title,year,rate;
            ImageView info;

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            SupportItimes dataModle = getItem(position);
            ViewHolder viewHolder;
            final View result;
            if(convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.mov1, parent, false);
                viewHolder.title = (TextView) convertView.findViewById(R.id.text1);
                viewHolder.year = (TextView) convertView.findViewById(R.id.text3);
                viewHolder.rate = (TextView) convertView.findViewById(R.id.text2);
                viewHolder.info=(ImageView) convertView.findViewById(R.id.image);
                viewHolder.title.setText(dataModle.getName());
                viewHolder.rate.setText(dataModle.getRate());
                viewHolder.year.setText(dataModle.getYear());
                viewHolder.info.setImageResource(dataModle.getImageView());


            }
            return convertView;
        }
    }


