package fr.pgah.java.unbrco.ui.outils;

import fr.pgah.java.unbrco.model.Forme;
import fr.pgah.java.unbrco.model.FormeCarre;
import fr.pgah.java.unbrco.ui.EditeurDeFormes;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class OutilForme extends Outil {

    protected Forme forme;
    protected int type;
    protected int inst;
    public OutilForme(EditeurDeFormes editeur, JComponent parent, String string , int type, int inst) {
        super(editeur, parent, string);
        forme = null;
        this.inst = inst;
        this.type=type;
    }

    @Override
    protected void creerBouton(JComponent parent, String s) {
      bouton = new JButton(s);
      bouton = customiserButton(bouton);
    }

    @Override
    protected void ajouterListener() {
      bouton.addActionListener(new OutilFormeClicHandler());
    }

    @Override
    public void pressDansZoneDessin(MouseEvent e) {
      forme = new FormeCarre(e.getPoint(), editeur.getMidiSynth(), 1, 2);
      forme.selectionnerEtJouer();
      forme.setLimites(e.getPoint());
      editeur.ajouterAuDessin(forme);
    }
  
    @Override
    public void releaseDansZoneDessin(MouseEvent e) {
      forme.deselectionnerEtStopper();
      forme = null;
    }
  
    @Override
    public void dragDansZoneDessin(MouseEvent e) {
      forme.setLimites(e.getPoint());
    }

    public class OutilFormeClicHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          editeur.setOutilActif(OutilForme.this);
        }
      }
}
