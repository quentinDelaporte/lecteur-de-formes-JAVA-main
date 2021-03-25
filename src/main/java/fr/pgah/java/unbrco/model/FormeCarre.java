package fr.pgah.java.unbrco.model;

import fr.pgah.java.son.MidiSynth;
import java.awt.*;

public class FormeCarre extends Forme {

  public FormeCarre(Point hautGauche, MidiSynth midiSynth, int type, int inst) {
    super(hautGauche, midiSynth, type, inst);
    
  }

  @Override
  public void dessiner(Graphics g) {
    Color saveCouleur = g.getColor();
    if (estSelectionnee) {
      g.setColor(COULEUR_LIGNE_JOUEE);
    } else {
      g.setColor(Color.white);
    }
    g.fillRect(x, y, longueur, hauteur);
    g.setColor(saveCouleur);
    g.drawRect(x, y, longueur, hauteur);
    if (colonneJouee > 0 && colonneJouee < longueur) {
      g.setColor(Color.red);
      g.drawLine(x + colonneJouee, y, x + colonneJouee, y + hauteur);
      g.setColor(saveCouleur);
    }
  }
}
