package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes = new ArrayList<>();

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public HeroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtname;
        private TextView txtdescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtname = view.findViewById(R.id.txt_name);
            txtdescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero) {
            txtname.setText(hero.getName());
            txtdescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}