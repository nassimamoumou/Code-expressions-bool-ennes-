public class Noeud {

	 /**
     * objet encapsul?dans la cellule
     */
    protected String contenu;
    /**
     * pointeur sur la cellule suivante
     */
    protected Noeud noeudGauche;
    protected Noeud noeudDroit;

    /**
     * constructeur cr?nt une cellule sans contenu ni suivant
     */
    public Noeud() {
        contenu = "";
        noeudGauche = null;
        noeudDroit = null;
    }

    /**
     * constructeur cr?nt une cellule encapsulant l'objet _contenu
     * @param _contenu l'objet ?encapsuler
     */
    public Noeud(String _contenu) {
        contenu = _contenu;
        noeudGauche = null;
        noeudDroit = null;
    }

    /**
     * acceseur de la cellule suivante
     * @return suivant
     */
    public Noeud getNoeudGauche() {
        return noeudGauche;
    }

    public Noeud getNoeudDroit() {
        return noeudDroit;
    }

    /**
     * modificateur du suivant
     * @param _c la nouvelle cellule suivante
     */
    public void setNoeudGauche(Noeud noeud) {
    	noeudGauche = noeud;
    }

    public void setNoeudDroit(Noeud noeud) {
    	noeudDroit = noeud;
    }

    /**
     * modificateur du suivant
     * @param _o un objet ?encapsuler dans la future nouvelle cellule suivante
     */
    public void setNoeudGauche(String objet) {
    	noeudGauche = new Noeud(objet);
    }

    public void setNoeudDroit(String objet) {
    	noeudDroit = new Noeud(objet);
    }

    /**
     * accesseur du contenu
     * @return contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * modificateur du contenu
     * @param _c le nouveau contenu
     */
    public void setContenu(String _c) {
        contenu = _c;
    }

    /**
     * rep?entation de la cellule en cha?e de caract?es
     */
    public String toString() {

            return contenu.toString();
        }
}
