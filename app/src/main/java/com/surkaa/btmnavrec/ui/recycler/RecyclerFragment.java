package com.surkaa.btmnavrec.ui.recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.surkaa.btmnavrec.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerFragment extends Fragment {

    private final List<ItemData> mData = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler);
        mData.addAll(Arrays.asList(DataBase.dataBase));
        recyclerView.setAdapter(new TestAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public class TestAdapter extends RecyclerView.Adapter<TestHolder> {

        @NonNull
        @Override
        public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new TestHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TestHolder holder, int position) {
            ItemData data = mData.get(position);
            holder.image.setImageResource(data.getIdContact());
            holder.name.setText(data.getName());
            holder.description.setText(data.getDescription());
            holder.time.setText(data.getTime());
            holder.notificationImage.setImageResource(data.getIdNotification());
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    public static class TestHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;
        public TextView description;
        public TextView time;
        public ImageView notificationImage;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_head_img);
            name = itemView.findViewById(R.id.item_contact_name);
            description = itemView.findViewById(R.id.item_description);
            time = itemView.findViewById(R.id.item_message_time);
            notificationImage = itemView.findViewById(R.id.item_notification_status_img);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}