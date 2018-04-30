/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Categorie;
import Entities.Produit;
import Service.*;
import com.codename1.io.MultipartRequest;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author Yacine
 */
public class AjoutProduitForm {
    Form f ;
    Produit produit = new Produit(2);

    
    ServiceProduit s=new ServiceProduit();
        MultipartRequest request = new MultipartRequest();

    Button ajouter= new Button("Ajouter");
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    public AjoutProduitForm(){
    
    f =new Form("Ajout Produit", BoxLayout.y());
    TextField nom = new TextField("Nom", 20) ;
    TextField description = new TextField("Description",50) ;
    TextField adresse = new TextField("Adresse",20) ;
    ComboBox <String> combo = new ComboBox<> ("Tunis","Manouba","Ariana"); 
    ArrayList<Categorie> a = new ArrayList<>();
    a=s.getListCat();
        System.out.println("------------------------------");    
    //System.out.println(a.get(0));
    ComboBox <String> combo1 = new ComboBox<String>();
    for(int i=0 ; i<a.size() ; i++)
    {
       combo1.addItem(a.get(i).getNom()); 
    }
    
    Container c = new Container(BoxLayout.y());
c.addAll(nom,description,adresse,combo,combo1);
    f.add(c);
    
//    produit.setNom(nom.getText());
//    produit.setAdresse(adresse.getText());
//    produit.setDescription(description.getText());
//    produit.setVille(combo.getSelectedItem());
//    produit.setId_cat(combo1.getCurrentSelected());

// ajouter.addActionListener((e) -> {
//
//                s.ajoutProduit(produit, request);
//                });
 
 Button EnregistrerButton = new Button("Enregistrer");
 
        EnregistrerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ArrayList<Integer> listid=new ArrayList<>();
             produit.setNom(nom.getText());
             produit.setId(50);
    produit.setAdresse(adresse.getText());
    produit.setDescription(description.getText());
    produit.setVille(combo.getSelectedItem());
    produit.setId_cat(combo1.getCurrentSelected());
         
        String nom = combo1.getSelectedItem();
         listid = s.getidbyname(nom);
         produit.setId_cat(listid.get(0));
         
            System.out.println(produit);
         s.ajoutProduit(produit, request);
         System.out.println(combo1.getSelectedItem());
        
        
        }
    });
            f.add(EnregistrerButton);

    
}
}
