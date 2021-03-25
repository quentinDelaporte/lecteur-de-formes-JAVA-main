package fr.pgah.java.unbrco.ui.outils;

import fr.pgah.java.unbrco.model.Forme;
import fr.pgah.java.unbrco.model.FormeCarre;
import fr.pgah.java.unbrco.ui.EditeurDeFormes;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class OutilFormeCarre extends OutilForme {

  public OutilFormeCarre(EditeurDeFormes editeur, JComponent parent, String string, int type, int inst) {
    super(editeur, parent, string, type, inst);
    //TODO Auto-generated constructor stub
  }

  @Override
  public void pressDansZoneDessin(MouseEvent e) {
    forme = new FormeCarre(e.getPoint(), editeur.getMidiSynth(), 1, 118);
    forme.selectionnerEtJouer();
    forme.setLimites(e.getPoint());
    editeur.ajouterAuDessin(forme);
  }

}
