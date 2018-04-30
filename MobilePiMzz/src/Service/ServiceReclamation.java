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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yacine
 */
public class ServiceReclamation {
    
    public void ajoutReclam(Reclamation rec,MultipartRequest con) {
        String Url = "http://127.0.0.1/MobileMzz/crudReclamation.php?type=ajout&sujet="+rec.getSujet()+"&textereclamation="+rec.getTextereclamation()
                +"&idUser="+rec.getId_user()+"&idemetteur="+rec.getIdemetteur()+"&etat="+rec.getEtat();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
        String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    public ArrayList<Sujets>   getListSujets() {
            ArrayList<Sujets> listsujets = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        String Url = "http://127.0.0.1/MobileMzz/crudReclamation.php?type=affichersujet";
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                Sujets  a=new Sujets();
                                try {
                    Map<String, Object> Sujets = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(Abonnements);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Sujets.get("result");
                    for (Map<String, Object> obj : list) {
                        Sujets c = new Sujets();
                       
                        c.setId(Integer.parseInt(obj.get("id").toString()));
                        c.setSujet(obj.get("sujet").toString());
                        
                       // System.out.println(c);
                        listsujets.add(c);

                        //System.out.println(listAbonnements);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listsujets;
        
        
    }
    
    public ArrayList<Integer> getidbySujet(String sujet)
  {
      
       ConnectionRequest con = new ConnectionRequest();
       String Url = "http://127.0.0.1/MobileMzz/crudReclamation.php?type=getidbysujet&sujet="+sujet ;
       con.setUrl(Url);
       ArrayList<Integer> listid=new ArrayList<>();
       con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                                try {
                    Map<String, Object> sujets = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(produits);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) sujets.get("result");
                       

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
    public ArrayList<Reclamation> getReclamations(Reclamation rec) {
        ArrayList<Reclamation> listreclam = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/MobileMzz/crudReclamation.php?type=afficherreclamation";
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                                try {
                    Map<String, Object> reclamations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) reclamations.get("result");
                    for (Map<String, Object> obj : list) {
                        Reclamation reclam = new Reclamation();
                       
                       int id = Integer.parseInt(obj.get("id").toString());
                       rec.setId(id);
                       int sujet = Integer.parseInt(obj.get("sujet").toString());
                       rec.setSujet(sujet);
                       
                       
                        rec.setTextereclamation(obj.get("textereclamation").toString());
                       // rec.setDate(obj.get("date").toString());
                       
                        listreclam.add(rec);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listreclam;
    }   
    
    
}
