package com.example.listview.service;

import com.example.listview.beans.Produit;
import com.example.listview.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private List <Produit> produits;
    private static ProduitService instance;
    private ProduitService(){
        this.produits = new ArrayList<>();
    }
    public static ProduitService getInstance() {
        if(instance == null)
            instance =  new ProduitService();
        return instance;
    }
    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        Produit produit = findById(o.getId());
        produit.setNom(o.getNom());
        produit.setNbrIngredients(o.getNbrIngredients());
        produit.setPhoto(o.getPhoto());
        produit.setDuree(o.getDuree());
        produit.setDetaisIngred(o.getDetaisIngred());
        produit.setDescription(o.getDescription());
        produit.setPreparation(o.getPreparation());
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public Produit findById(int id) {
        for(Produit p : produits){
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        if (produits == null) {
            produits = new ArrayList<>();
        }
        return produits;
    }

}
