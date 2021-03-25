package fr.pgah.java.unbrco.ui.outils;

import fr.pgah.java.unbrco.model.Forme;
import fr.pgah.java.unbrco.model.FormeOvale;
import fr.pgah.java.unbrco.ui.EditeurDeFormes;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class OutilFormeOvale extends OutilForme {

  public OutilFormeOvale(EditeurDeFormes editeur, JComponent parent, String string, int type, int inst) {
    super(editeur, parent, string, type, inst);
  }

  @Override
  public void pressDansZoneDessin(MouseEvent e) {
    forme = new FormeOvale(e.getPoint(), editeur.getMidiSynth(), 1, 2);
    forme.selectionnerEtJouer();
    forme.setLimites(e.getPoint());
    editeur.ajouterAuDessin(forme);
  }


}
