/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import java.io.IOException;


/**
 *
 * @author sana
 */
public class HomeForm {

    Form f,f1,f2;
    TextField tnom;
    TextField tetat;
    Toolbar tb,tb2;
    Button btnaff,btn,mesabonnements,nosprods,ajoutprods,ajoutreclam,mesreclamsuser;

    public HomeForm() {
        f = new Form("home");
        
        

        mesabonnements = new Button("Mes Abonnements");

        f.add(mesabonnements);
        mesabonnements.addActionListener((e) -> {
            try {
                MesAbonnementsForm a= new MesAbonnementsForm();
                a.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(e);
            }

        });
        mesreclamsuser = new Button("Mes Reclamations User");

        f.add(mesreclamsuser);
        mesreclamsuser.addActionListener((e) -> {
            try {
                MesReclamationsUserForm a= new MesReclamationsUserForm();
                a.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(e);
            }

        });
        
        
        ajoutreclam = new Button("Reclamer");

        f.add(ajoutreclam);
        ajoutreclam.addActionListener((e) -> {
            
                ReclamationForm a= new ReclamationForm();
                a.getF().show();
            

        });
     
        
        nosprods = new Button("Nos Bons Plans");

        f.add(nosprods);
        nosprods.addActionListener((e) -> {
            ProduitsForm a;
            try {
                a = new ProduitsForm();
                a.getF().show();
            } catch (IOException ex) {
                //Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        });
        ajoutprods = new Button("Ajout Produit");

        f.add(ajoutprods);
        ajoutprods.addActionListener((e) -> {
            AjoutProduitForm a = new AjoutProduitForm(); 
            a.getF().show();
        

        });
        
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
