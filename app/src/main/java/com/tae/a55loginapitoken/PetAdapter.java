package com.tae.a55loginapitoken;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

        private List<Pet> pets = null;
        private OnItemClickListener mItemClickListener;

        public PetAdapter(List<Pet> pets) {
            this.pets = pets;
        }

        @NonNull
        @Override
        public PetAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

            return new PetViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PetAdapter.PetViewHolder holder, final int position) {
            final Pet pet = pets.get(position);

            holder.id.setText("id: " + String.valueOf(pet.getId()));
            holder.name.setText("name: " + pet.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(position);
                    Intent intent = new Intent(v.getContext(), PetActivity.class);
                    intent.putExtra("pet", pet);
                    v.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return pets.size();
        }



        public class PetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView id;
            TextView name;

            public PetViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                id = itemView.findViewById(R.id.id);
                name = itemView.findViewById(R.id.name);
            }

            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, getAdapterPosition());
                }
            }
        }

        public interface OnItemClickListener {
            public void onItemClick(View view , int position);
        }

        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }
    }
