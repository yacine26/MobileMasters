/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Abonnement;
import Entities.Produit;
import Service.*;
import com.codename1.components.ImageViewer;
import com.codename1.io.MultipartRequest;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yacine
 */
public class ProduitsForm {
    Form form;
    MultipartRequest request = new MultipartRequest();
        Image img;
        Image img1;
        Image img2;
    ImageViewer imgv;
    ImageViewer abonner;
    ImageViewer desabonner;
    EncodedImage enc;
       private void changeString(ArrayList<String> l,String s){
    l.set(0,"1");}
    
    public ProduitsForm() throws IOException{
      enc=EncodedImage.create("/giphy.gif").scaledEncoded(100, 100);
        
        ServiceProduit serviceProduit =new ServiceProduit();
        Produit produit=new  Produit();
        ArrayList<Produit> liste= serviceProduit.getProduits(produit);
        form =new Form("Nos Bons Plans", BoxLayout.y());
        for(Produit t:liste){
            Container c4 = new Container(BoxLayout.y());
            Container c = new Container(BoxLayout.x());
            Container c2 = new Container(BoxLayout.y());
            Container c3 = new Container(BoxLayout.x());
            
            String url="http://localhost/Images/"+t.getImg();
            img=URLImage.createToStorage(enc, url,url, URLImage.RESIZE_SCALE);
            
            imgv=new ImageViewer(img);
            
            String url1="http://localhost/Images/coeur.png" ;
            img1=URLImage.createToStorage(enc, url1,url1, URLImage.RESIZE_SCALE);
            
            abonner=new ImageViewer(img1);
            
            String url2="http://localhost/Images/coeur2.png" ;
            img2=URLImage.createToStorage(enc, url2,url2, URLImage.RESIZE_SCALE);
            
            desabonner=new ImageViewer(img2);
            
            Label nom = new Label(t.getNom());
            Label adresse = new Label (t.getAdresse());
            Label ville=new Label (t.getVille());
            //Label description=new Label (t.getDescription());
            nom.setAlignment(CENTER);
            c3.addAll(nom,adresse,ville);
            c2.addAll(imgv , c3);
            
            
           // c.addAll(c2);
            
            c4.addAll(c2);
            form.add(ComponentGroup.enclose(c4));
            //******************************************
        
         

    
    
            //Form 
            

    /********************/

    ServiceAbonnement serviceAbonnement = new ServiceAbonnement();
        ArrayList<String> l=new ArrayList<>();
        Abonnement abonnement=new  Abonnement(6, t.getId());
        l=serviceAbonnement.getList(abonnement);
        Button abonner = new Button();
        //abonner.setVisible(false);
        //abonner.setIcon(img2);
            System.out.println(l);
            System.out.println("----------------------------------");
            //System.out.println(l.get(0).equals("0"));

    if ( l.get(0).equals("0"))
    {
//    TableLayout.Constraint cn = tableLayout.createConstraint();
//    cn.setHorizontalSpan(spanButton);
//    cn.setHorizontalAlign(Component.RIGHT);TableLayout

    //abonner.setText("Abonner");
    abonner.setIcon(img2);

      abonner.addActionListener((e) -> {

                serviceAbonnement.ajoutAbonnement(abonnement,request);
               // abonner.setText("Desabonner");
               abonner.setIcon(img1);
                ProduitsForm a;
        try {
            a = new ProduitsForm();
            a.getF().show();
        } catch (IOException ex) {
            //Logger.getLogger(ProduitsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                




      });
      final String value="1";
    l.set(0, value);
      //  System.out.println(l);
      form.add(abonner);

        }
    else if (l.get(0).equals("1"))
    {


//    TableLayout.Constraint cn = tableLayout.createConstraint();
//    cn.setHorizontalSpan(spanButton);
//    cn.setHorizontalAlign(Component.RIGHT);

        System.out.println("d5al 1");
        //abonner.setText("Desabonner");
        abonner.setIcon(img1);
          abonner.addActionListener((e) -> {

                serviceAbonnement.SupprimerAbonnement(abonnement,request);
            //abonner.setText("Abonner");
            abonner.setIcon(img2);
            ProduitsForm a;
        try {
            a = new ProduitsForm();
            a.getF().show();
        } catch (IOException ex) {
            //Logger.getLogger(ProduitsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            
          });
          final String value="0";
    l.set(0, value);

          form.add(abonner);

    

    }
            System.out.println("----------------------------");
            System.out.println(l);
        }
    
            
        }
     

    
    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = f;
    }
    
}   
    

