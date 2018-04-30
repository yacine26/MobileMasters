/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.*;
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
public class ReclamationForm {
    Form f ;
    ServiceReclamation s=new ServiceReclamation();
    Reclamation rec = new Reclamation(0,6,2);
    MultipartRequest request = new MultipartRequest();

    Button envoyer= new Button("Envoyer");
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    public ReclamationForm(){
    
    f =new Form("Bienvenue", BoxLayout.y());
    TextField TexteReclamation = new TextField("ekteb lena", 20) ;
     
    ArrayList<Sujets> a = new ArrayList<>();
    a=s.getListSujets();
        System.out.println("------------------------------");    
    //System.out.println(a.get(0));
    ComboBox <String> combo1 = new ComboBox<String>();
    for(int i=0 ; i<a.size() ; i++)
    {
       combo1.addItem(a.get(i).getSujet()); 
    }
    
    Container c = new Container(BoxLayout.y());
c.addAll(TexteReclamation,combo1);
    f.add(c);

 
 Button EnregistrerButton = new Button("Envoyer");
 
        EnregistrerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ArrayList<Integer> listid=new ArrayList<>();
             rec.setTexte_reclamation(TexteReclamation.getText());
        
    //rec.setSujet(combo1.getCurrentSelected());
         
        String sujet = combo1.getSelectedItem();
         listid = s.getidbySujet(sujet);
         rec.setSujet(listid.get(0));
         
            System.out.println(rec);
         s.ajoutReclam(rec, request);
         System.out.println(combo1.getSelectedItem());
        
        
        }
    });
            f.add(EnregistrerButton);

    
}
}
