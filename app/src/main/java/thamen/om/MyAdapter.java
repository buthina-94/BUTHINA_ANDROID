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

/**
 * Created by sasmob on 11/27/2018.
 */

public class MyAdapter extends ArrayAdapter<SupportItimes>{
    private ArrayList<SupportItimes> itimes;
    private Context context;

    public MyAdapter(@NonNull Context context, ArrayList<SupportItimes> objects) {
        super(context, R.layout.bb,objects);

        this.itimes=objects;
        this.context=context;

    }
    private static class ViewHolder{
        TextView txtName;
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
          convertView = inflater.inflate(R.layout.bb, parent, false);
          viewHolder.txtName = (TextView) convertView.findViewById(R.id.textView24);

          viewHolder.info = (ImageView) convertView.findViewById(R.id.imageView4);
          viewHolder.txtName.setText(dataModle.getName());
          viewHolder.info.setImageResource(dataModle.getImageView());


      }
      return convertView;
    }
}
