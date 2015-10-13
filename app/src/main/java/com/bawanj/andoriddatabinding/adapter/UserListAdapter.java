package com.bawanj.andoriddatabinding.adapter;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawanj.andoriddatabinding.R;
import com.bawanj.andoriddatabinding.databinding.RecyclerItemBinding;
import com.bawanj.andoriddatabinding.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter< UserListAdapter.UserHolder > {

    private List<User> users;
    private List<Integer> heights;

    public UserListAdapter(List<User> users){
        this.users= users;
        getRandomHeight( this.users );
    }

    private void getRandomHeight(List<User> users ){
        heights= new ArrayList<>();
        for(int i=0;i<users.size();++i ){
            heights.add( (int)(200+ Math.random()*400) );
        }
    }

    public final class UserHolder extends RecyclerView.ViewHolder{

        private RecyclerItemBinding itemBinding;

        public UserHolder(View itemView) {
            super(itemView);
        }

        public RecyclerItemBinding getItemBinding(){
            return itemBinding;
        }

        public void setItemBinding( RecyclerItemBinding binding ){
            itemBinding= binding;
        }

    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int viewType ) {

        RecyclerItemBinding itemBinding
                = DataBindingUtil.inflate(LayoutInflater.from( viewGroup.getContext() )
                , R.layout.recycler_item, viewGroup, false);

        UserHolder userHolder = new UserHolder( itemBinding.getRoot() );
        userHolder.setItemBinding(itemBinding);

        return userHolder;
    }

    @Override
    public void onBindViewHolder( UserHolder holder, int position ) {
        // setup view  ( viewHolder height )
        ViewGroup.LayoutParams params= holder.itemView.getLayoutParams();
        params.height= heights.get(position);
        holder.itemView.setLayoutParams(params);

        // binding data
        User user= users.get(position);
        //holder.getItemBinding().setVariable( BR.user, user); way 1
        holder.getItemBinding().setUser(user); // way 2
        holder.getItemBinding().executePendingBindings();// update UI immediately
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

}
