package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.beans.Produit;
import com.example.listview.service.ProduitService;

public class DetailsProduit extends AppCompatActivity {

    private Produit p;
    private ImageView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_produit);
        share = findViewById(R.id.share);
        ImageView imageProduit=findViewById(R.id.photo);
        TextView nom=findViewById(R.id.nom);
        TextView description=findViewById(R.id.description);
        TextView ingredient=findViewById(R.id.ingredient);
        TextView preparation=findViewById(R.id.preparation);

        imageProduit.setImageResource(getIntent().getIntExtra("photo",0));
        nom.setText(getIntent().getStringExtra("nom"));
        description.setText(getIntent().getStringExtra("description"));
        ingredient.setText(getIntent().getStringExtra("ingredient"));
        preparation.setText(getIntent().getStringExtra("preparation"));
        share.setOnClickListener(
                view ->

                {
                    String shareText = "Nom: " + nom.getText().toString() + "\n\n" +
                            "Ingredients: " + ingredient.getText().toString() + "\n\n" +
                            "Description: " + description.getText().toString() + "\n\n" +
                            "Preparation: " + preparation.getText().toString();

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

                    shareIntent.setPackage("com.whatsapp");

                    startActivity(shareIntent);

                });
    }

    public void shareOnWhatsApp(View view) {
        String message = "Try this pizza recipe! 🍕\n" + p.getNom() + "\n" + p.getNbrIngredients();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }


}