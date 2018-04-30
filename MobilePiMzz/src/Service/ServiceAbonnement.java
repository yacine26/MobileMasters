/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Abonnement;
import Entities.Produit;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amir
 */
public class ServiceAbonnement {
    public void ajoutAbonnement(Abonnement abonnement,MultipartRequest con) {
        String Url = "http://127.0.0.1/MobileMzz/crudAbonnement.php?type=ajout&idProduit="+abonnement.getId_produit()+"&idUser="+abonnement.getId_user();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
        String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    public ArrayList<String> getList(Abonnement abonnement) {
            ArrayList<String> listAbonnements = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        String Url = "http://127.0.0.1/MobileMzz/crudAbonnement.php?type=affichage&idProduit="+abonnement.getId_produit()+"&idUser="+abonnement.getId_user();
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                String  a;
                                try {
                    Map<String, Object> Abonnements = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(Abonnements);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Abonnements.get("result");
                    for (Map<String, Object> obj : list) {
                        Abonnement Abonnement = new Abonnement();
                       
                        
                        a=(obj.get("mawjoud").toString());
                        System.out.println("----------------------mawjoud");
                        System.out.println(a);
                        
                        listAbonnements.add(a);

                        //System.out.println(listAbonnements);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAbonnements;
    }
    
    public void SupprimerAbonnement(Abonnement abn , MultipartRequest con){  
        String Url = "http://127.0.0.1/MobileMzz/crudAbonnement.php?type=supprimer&idProduit="+abn.getId_produit()+"&idUser="+abn.getId_user();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
        String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    
    }
    
    public ArrayList<Produit> getAbonnements(Abonnement abn) {
        ArrayList<Produit> listprod = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/MobileMzz/crudAbonnement.php?type=affichageprodbyabon&idUser="+abn.getId_user();
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
    
}
