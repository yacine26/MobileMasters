/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Entities.*;
import Service.*;
import com.codename1.components.ImageViewer;
import com.codename1.io.MultipartRequest;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yacine
 */
public class MesReclamationsUserForm {
    Form form;
    MultipartRequest request = new MultipartRequest();
    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = f;
    }
    
    
    public MesReclamationsUserForm() throws IOException{
      //enc=EncodedImage.create("/giphy.gif").scaledEncoded(100, 100);
        
        ServiceReclamation serviceReclamation = new ServiceReclamation();
        Reclamation rec = new Reclamation(0,6,2);
        ArrayList<Reclamation> liste= serviceReclamation.getReclamations(rec);
        form =new Form("Mes Reclamations", BoxLayout.y());
        for(Reclamation t:liste){
            Container c4 = new Container(BoxLayout.y());
            Container c = new Container(BoxLayout.x());
            Container c2 = new Container(BoxLayout.y());
            Container c3 = new Container(BoxLayout.x());
            
            
            Label textereclamation = new Label (t.getTextereclamation());
            textereclamation.setAlignment(CENTER);
            c3.addAll(textereclamation);
            c2.addAll(c3);
            
            
           // c.addAll(c2);
            
            c4.addAll(c2);
            form.add(ComponentGroup.enclose(c4));
            
        }
     
    }
}
