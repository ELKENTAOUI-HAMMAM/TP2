package com.example.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.R;
import com.example.listview.beans.Produit;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;
    public ProduitAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.produit_activity, null);
        TextView idf = convertView.findViewById(R.id.idf);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView nbrIngredients = convertView.findViewById(R.id.nbrIngredients);
        ImageView photo = convertView.findViewById(R.id.photo);
        TextView duree = convertView.findViewById(R.id.duree);

        idf.setText(String.valueOf(produits.get(position).getId()));
        nom.setText(produits.get(position).getNom());
        nbrIngredients.setText(String.valueOf(produits.get(position).getNbrIngredients()));
        photo.setImageResource(produits.get(position).getPhoto());
        duree.setText(produits.get(position).getDuree());

        return convertView;
    }
}
