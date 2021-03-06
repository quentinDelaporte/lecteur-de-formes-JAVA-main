package fr.pgah.java.unbrco.ui.outils;

import fr.pgah.java.unbrco.model.Forme;
import fr.pgah.java.unbrco.ui.EditeurDeFormes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class OutilDeplacer extends Outil {

  private Forme formeADeplacer;
  private Point debut;

  public OutilDeplacer(EditeurDeFormes editeur, JComponent parent) {
    super(editeur, parent, "Déplacer");
    formeADeplacer = null;
    debut = null;
  }

  @Override
  protected void creerBouton(JComponent parent, String s) {
    bouton = new JButton(s);
    ajouterAuParent(parent);
  }

  @Override
  protected void ajouterListener() {
    bouton.addActionListener(new OutilDeplacerClicHandler());
  }
 
  @Override
  public void pressDansZoneDessin(MouseEvent e) {
    if(editeur.getFormeEn(e.getPoint()) !=null){
      formeADeplacer = editeur.getFormeEn(e.getPoint());
      formeADeplacer.selectionnerEtJouer();
      this.debut=e.getPoint();
    }
      System.out.println(editeur.getFormeEn(e.getPoint()));

    // À COMPLÉTER
    // Sélectionner et jouer la forme qui se trouve au point cliqué.
    // Doit également gérer l'initiation d'un "drag" éventuel.
    // Ne fait rien si pas de forme à cet endroit.

  }

  @Override
  public void releaseDansZoneDessin(MouseEvent e) {
    if (formeADeplacer != null) {
      formeADeplacer.deselectionnerEtStopper();
      formeADeplacer = null;
    }
  }

  @Override
  public void dragDansZoneDessin(MouseEvent e) {
    if (formeADeplacer != null) {
      int dx = (int) (e.getPoint().getX() - debut.getX());
      int dy = (int) (e.getPoint().getY() - debut.getY());
      debut = e.getPoint();
      formeADeplacer.deplacer(dx, dy);
    }
  }

  private class OutilDeplacerClicHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      editeur.setOutilActif(OutilDeplacer.this);
    }
  }
}
