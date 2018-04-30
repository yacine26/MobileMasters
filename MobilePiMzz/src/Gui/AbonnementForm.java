/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Abonnement;
import Service.ServiceAbonnement;
import com.codename1.io.MultipartRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.TableLayout;
import java.util.ArrayList;

/**
 *
 * @author Yacine
 */
public class AbonnementForm {
     Form form;
    MultipartRequest request = new MultipartRequest();
    
    
    private void changeString(ArrayList<String> l,String s){
    l.set(0,"1");
}
    
    public AbonnementForm() {
            //Form 
            form = new Form("Tout Les Bons Plans", new BoxLayout(BoxLayout.Y_AXIS));
            form.setScrollVisible(true);
            form.setSmoothScrolling(true);
                /*****************/
                
            TableLayout tableLayout;
            int spanButton = 2;
            if(Display.getInstance().isTablet()) {
            tableLayout = new TableLayout(7, 2);
    } else {
        tableLayout = new TableLayout(14, 1);
        spanButton = 1;
    }
    tableLayout.setGrowHorizontally(true);
    form.setLayout(tableLayout);

    /********************/

    ServiceAbonnement serviceAbonnement = new ServiceAbonnement();
        ArrayList<String> l=new ArrayList<>();
        Abonnement abonnement=new  Abonnement(6, 10);
        l=serviceAbonnement.getList(abonnement);
    Button abonner = new Button();
            System.out.println(l);
            System.out.println("----------------------------------");
            //System.out.println(l.get(0).equals("0"));

    if ( l.get(0).equals("0"))
    {
    TableLayout.Constraint cn = tableLayout.createConstraint();
    cn.setHorizontalSpan(spanButton);
    cn.setHorizontalAlign(Component.RIGHT);

    abonner.setText("Abonner");  

      abonner.addActionListener((e) -> {

                serviceAbonnement.ajoutAbonnement(abonnement,request);
               // abonner.setText("Desabonner");
                AbonnementForm a = new AbonnementForm();
                a.getF().show();




      });
      final String value="1";
    l.set(0, value);
      //  System.out.println(l);
      form.add(abonner);

        }
    else if (l.get(0).equals("1"))
    {


    TableLayout.Constraint cn = tableLayout.createConstraint();
    cn.setHorizontalSpan(spanButton);
    cn.setHorizontalAlign(Component.RIGHT);

        System.out.println("d5al 1");
        abonner.setText("Desabonner");
          abonner.addActionListener((e) -> {

                serviceAbonnement.SupprimerAbonnement(abonnement,request);
            //abonner.setText("Abonner");
            AbonnementForm a = new AbonnementForm();
                a.getF().show();
            
          });
          final String value="0";
    l.set(0, value);

          form.add(abonner);

    }


            System.out.println("----------------------------");
            System.out.println(l);
        }
    
    
    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = f;
    }
}
