package thamen.om.moodle;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import thamen.om.database.Student;

/**
 * Created by sasmob on 12/5/2018.
 */

public class MyRecyclerAdapterAllStudent extends RecyclerView.Adapter {
    public MyRecyclerAdapterAllStudent(ArrayList<Student> studentArrayList, FragmentActivity activity) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
