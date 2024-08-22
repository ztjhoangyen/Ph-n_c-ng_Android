package com.example.trinhphatnhac;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trinhphatnhac.databinding.ItemUserBinding;

import java.util.List;
//Chú ý: dữ liệu nó có log ra thì là do layout
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding = ItemUserBinding.inflate(LayoutInflater.from(
                parent.getContext()), parent, false);
        return new UserViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        if(user == null){
            return;
        }
        holder.itemUserBinding.titleNameUser.setText(user.getName());

    }

    @Override
    public int getItemCount() {
        if(userList != null){
            //         kiểm tra số lượng item mà Adapter sẽ hiển thị
            Log.d("UserAdapter", "Item count: " + userList.size());
            return userList.size();

        }

        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        private ItemUserBinding itemUserBinding;

        public  UserViewHolder(@NonNull ItemUserBinding itemUserBinding){
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }
    }
}
