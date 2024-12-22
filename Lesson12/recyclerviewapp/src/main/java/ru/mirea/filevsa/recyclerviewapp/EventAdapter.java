package ru.mirea.filevsa.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private final List<Event> events;
    private Context context;

    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View recyclerViewItem = LayoutInflater.from(context)
                .inflate(R.layout.event_view, parent, false);
        return new EventViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = this.events.get(position);
        String pkgName = context.getPackageName();
        int resID = context.getResources()
                .getIdentifier(event.getEventImage(), "drawable", pkgName);
        holder.getEventImageView().setImageResource(resID);
        holder.getEventTitleView().setText(event.getEventTitle());
        holder.getEventDateView().setText(event.getEventDate());
        holder.getEventDescriptionView().setText(event.getEventDescription());
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }
}