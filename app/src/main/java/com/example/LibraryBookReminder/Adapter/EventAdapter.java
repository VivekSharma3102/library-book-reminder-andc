package com.example.LibraryBookReminder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.LibraryBookReminder.Database.DatabaseClass;
import com.example.LibraryBookReminder.Database.EntityClass;
import com.example.LibraryBookReminder.Database.EventDao;
import com.example.LibraryBookReminder.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    Context context;
    List<EntityClass> entityClasses;

    public EventAdapter(Context context, List<EntityClass> entityClasses) {
        this.context = context;
        this.entityClasses = entityClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listings_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.Vid.setText(String.valueOf(entityClasses.get(position).getVid()));
        holder.eventText.setText(entityClasses.get(position).getEventname());
        holder.timeAndDateText.setText(entityClasses.get(position).getEventdate() + " " + entityClasses.get(position).getEventtime());
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseClass INSTANCE =
                        Room.databaseBuilder(holder.Vid.getContext(),
                                DatabaseClass.class,"Book_database").allowMainThreadQueries().build();

                EventDao eventDao = INSTANCE.EventDao();
//                to delete the record from database
                eventDao.deleteById(entityClasses.get(position).getVid());
                entityClasses.remove(position);
                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return entityClasses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView eventText, timeAndDateText , Vid;
        private LinearLayout toplayout;
        Button cancel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Vid = itemView.findViewById(R.id.Vid);
            eventText =itemView.findViewById(R.id.event);
            timeAndDateText = itemView.findViewById(R.id.time_and_date);
            toplayout =  itemView.findViewById(R.id.toplayout);
            cancel = itemView.findViewById(R.id.cancel);
        }
    }
}
