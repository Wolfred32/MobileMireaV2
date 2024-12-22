package ru.mirea.filevsa.retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Todo> todos;

    public TodoAdapter(Context context, List<Todo> todoList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textViewTitle.setText(todo.getTitle());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());

        holder.checkBoxCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setCompleted(isChecked);
            updateTodoCompletion(todo.getId(), isChecked);
        });

        String[] imageSources = new String[] {
                "https://i.pinimg.com/736x/4f/7f/d7/4f7fd71d34e0e7a7fb7f8022fab00a8e.jpg",
                "https://i.pinimg.com/736x/7c/3e/68/7c3e68f8e3620457f2232068b6ddad8e.jpg",
                "https://i.pinimg.com/736x/49/67/4c/49674ccc074f5b28829c058d293cad60.jpg"
        };

        Picasso.get()
                .load(imageSources[new Random().nextInt(imageSources.length)])
                .error(R.drawable.error)
                .placeholder(R.drawable.placeholder)
                .resize(600, 900)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    private void updateTodoCompletion(int todoId, boolean completed) {
        ApiService apiService = RetrofitController.getRetrofitInstance().create(ApiService.class);
        Todo todo = todos.get(todoId);
        todo.setCompleted(completed);

        Call<Todo> call = apiService.changeTodo(todoId, todo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e("DEBUG", "status: " + response.code());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e("DEBUG", "error:	" + t.getMessage());
            }
        });
    }

}