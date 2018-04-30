/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entities.*;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yacine
 */
public class ServiceProduit {
    
  public ArrayList<Produit> getProduits(Produit prod) {
        ArrayList<Produit> listprod = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/MobileMzz/crudProduit.php?type=afficher";
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                                try {
                    Map<String, Object> produits = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(produits);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("result");
                    for (Map<String, Object> obj : list) {
                        Produit prod = new Produit();
                       
                       int id = Integer.parseInt(obj.get("id").toString());
                       prod.setId(id);
                       
                        prod.setNom(obj.get("nom").toString());
                        //prod.setDescription(obj.get("description").toString());
                        prod.setVille(obj.get("ville").toString());
                        prod.setAdresse(obj.get("adresse").toString());
                        prod.setImg(obj.get("photo").toString());
                        //Bonplan.setNom_image(obj.get("Image").toString());
                        /*float rat = Float.parseFloat(obj.get("Rat").toString());
                        float lng = Float.parseFloat(obj.get("lng").toString());
                        float lat = Float.parseFloat(obj.get("lat").toString());
                        
                        Bonplan.setRat(rat);
                        Bonplan.setLat(lat);
                        Bonplan.setLng(lng);*/
                        listprod.add(prod);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listprod;
    }   
  public ArrayList<Categorie>   getListCat() {
            ArrayList<Categorie> listcategories = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        String Url = "http://127.0.0.1/MobileMzz/crudProduit.php?type=affichercategorie";
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                Categorie  a=new Categorie();
                                try {
                    Map<String, Object> Categories = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(Abonnements);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Categories.get("result");
                    for (Map<String, Object> obj : list) {
                        Categorie c = new Categorie();
                       
                        c.setId(Integer.parseInt(obj.get("id").toString()));
                        c.setNom(obj.get("nom").toString());
                        
                       // System.out.println(c);
                        listcategories.add(c);

                        //System.out.println(listAbonnements);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcategories;
        
        
    }
  
   public void ajoutProduit(Produit produit,MultipartRequest con) {
        String Url = "http://127.0.0.1/MobileMzz/crudProduit.php?type=ajout&idUser="+produit.getId_user()+"&id_categorie="+produit.getId_cat()+
                "&description="+produit.getDescription()+"&adresse="+produit.getAdresse()+"&notemoyenne="+produit.getNotemoyenne()
                +"&ville="+produit.getVille()+"&nom="+produit.getNom();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
        String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
  public ArrayList<Integer> getidbyname(String nom)
  {
      
       ConnectionRequest con = new ConnectionRequest();
       String Url = "http://127.0.0.1/MobileMzz/crudProduit.php?type=getidbyname&nom="+nom ;
       con.setUrl(Url);
       ArrayList<Integer> listid=new ArrayList<>();
       con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                                try {
                    Map<String, Object> produits = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(produits);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("result");
                       

                     for (Map<String, Object> obj : list) {
                       // Produit prod = new Produit();
                       int id;
                        id=Integer.parseInt(obj.get("id").toString());
                         System.out.println(id);
                        listid.add(id);

                    }
                    
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return  listid;
 
  
  
  
  
  
  
  } 
  
  
  
  
}
