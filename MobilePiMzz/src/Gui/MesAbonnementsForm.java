/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.*;
import Entities.Abonnement;
import Service.ServiceAbonnement;
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
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yacine
 */
public class MesAbonnementsForm {
    Form form;
    MultipartRequest request = new MultipartRequest();
        Image img;
    ImageViewer imgv;
    EncodedImage enc;
    
    public MesAbonnementsForm() throws IOException{
      enc=EncodedImage.create("/giphy.gif").scaledEncoded(100, 100);
        
        ServiceAbonnement serviceAbonnement =new ServiceAbonnement();
        Abonnement abonnement=new  Abonnement(6, 10);
        ArrayList<Produit> liste= serviceAbonnement.getAbonnements(abonnement);
        form =new Form("Mes Abonnements", BoxLayout.y());
        for(Produit t:liste){
            Container c4 = new Container(BoxLayout.y());
            Container c = new Container(BoxLayout.x());
            Container c2 = new Container(BoxLayout.y());
            Container c3 = new Container(BoxLayout.x());
            
            String url="http://localhost/Images/"+t.getImg();
            img=URLImage.createToStorage(enc, url,url, URLImage.RESIZE_SCALE);
            
            imgv=new ImageViewer(img);
            
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
            
        }
     
    }
    
    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = f;
    }
    
}

