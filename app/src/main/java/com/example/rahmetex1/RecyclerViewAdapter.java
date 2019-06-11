package com.example.rahmetex1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private List<Book> books;

    public RecyclerViewAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_book_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder called");

        Glide.with(viewHolder.itemView.getContext()).asBitmap().load("http://www.pngmart.com/files/1/Book-PNG-HD.png").into(viewHolder.bookImage);

        viewHolder.bookName.setText(books.get(position).getName() + " " + books.get(position).getPrice());

        viewHolder.bookItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + books.get(position).getName());

                Toast.makeText(v.getContext(), "Pages: " + books.get(position).getPagesCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView bookImage;
        TextView bookName;
        RelativeLayout bookItemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = (CircleImageView) itemView.findViewById(R.id.bookImage);
            bookName = (TextView) itemView.findViewById(R.id.bookName);
            bookItemLayout = (RelativeLayout) itemView.findViewById(R.id.bookItemLayout);
        }
    }
}
