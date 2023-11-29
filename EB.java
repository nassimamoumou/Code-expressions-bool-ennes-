public class EB {

	private Noeud racine; // racine de l'EB
	private int nbVariables; // nombre de variables dans l'EB

	// Constructeur par défaut qui initialise la racine de l'EB et le nombre de variables à 0
	public EB() {
		racine = new Noeud();  
		nbVariables = 0; 
	}

	// Constructeur avec paramètres qui initialise la racine de l'EB et le nombre de variables
	public EB (Noeud racine, int nb_Variables) {
		// Créer une nouvelle racine avec le même contenu que le noeud passé en paramètre
		this.racine = new Noeud (racine.getContenu()); 
		this.nbVariables = nb_Variables; 
	}

	// Constructeur de copie qui copie l'EB passé en paramètre
	public EB (EB e) {
		this.racine = e.racine;
		this.nbVariables = e.nbVariables;
	}

	// Getter pour récupérer le nombre de variables dans l'EB
	public int getNbVariables() {
		return nbVariables;
	}

	// Setter pour modifier le nombre de variables dans l'EB
	public void setNbVariables(int nbVariables) {
		this.nbVariables = nbVariables;
	}

	// Getter pour récupérer la racine de l'EB
	public Noeud getRacine() {
		return racine;
	}

	// Setter pour modifier la racine de l'EB
	public void setRacine(Noeud racine) {
		this.racine = racine;
	}

	// Méthode statique qui vérifie si l'EB passé en paramètre est vide
	public static boolean estVide(EB e) {
		return (e.racine == null) ;
	}

	// Méthode statique qui crée un EB singleton contenant un unique noeud avec le contenu passé en paramètre
	public static EB singleton (String contenu) {
		EB e = new EB();
		e.racine.setContenu(contenu);
		return e;
	}

	public static EB disjonction(EB noeudGauche, EB noeudDroit) {
		// Création d'un nouvel objet EB pour stocker le résultat
		EB resultat = new EB(new Noeud("+"), noeudGauche.nbVariables + noeudDroit.nbVariables);
		// Définition du fils gauche du noeud racine du résultat
		resultat.racine.setNoeudGauche(noeudGauche.racine);
		// Définition du fils droit du noeud racine du résultat
		resultat.racine.setNoeudDroit(noeudDroit.racine);
		// Renvoie le résultat
		return resultat;
	}

	public static EB conjonction(EB noeudGauche, EB noeudDroit) {
		// Création d'un nouvel objet EB pour stocker le résultat
		EB resultat = new EB(new Noeud("*"), noeudGauche.nbVariables + noeudDroit.nbVariables);
		// Définition du fils gauche du noeud racine du résultat
		resultat.racine.setNoeudGauche(noeudGauche.racine);
		// Définition du fils droit du noeud racine du résultat
		resultat.racine.setNoeudDroit(noeudDroit.racine);
		// Renvoie le résultat
		return resultat;
	}

	public static EB negation(EB e) {
		// Création d'un nouvel objet EB pour stocker le résultat
		EB resultat = new EB(new Noeud("!"), e.nbVariables);
		// Définition du fils droit du noeud racine du résultat
		resultat.racine.setNoeudDroit(e.racine);
		// Renvoie le résultat
		return resultat;
	}

	public static boolean evaluer(EB e, boolean [] Bvect) {
		if(estVide(e)) {
			// Affichage d'un message d'erreur si l'expression booléenne est vide
			System.out.println("EB est vide");
		} else {
			// Appel de la méthode récursive pour évaluer l'expression booléenne
			return evaluerRec(e.racine,Bvect);
		}
		// Renvoie false si l'expression booléenne est vide
		return false;
	}

	private static boolean evaluerRec(Noeud r,boolean [] Bvect) {

		boolean resultat=false;
	
		// Vérifie si le contenu du noeud est une opération "OU"
		if(r.getContenu()=="+") {
			// Appelle récursivement la méthode sur le noeud gauche et droit, et retourne le résultat de l'opération "OU"
			resultat = evaluerRec(r.noeudGauche,Bvect) || evaluerRec(r.noeudDroit,Bvect);
		}
	
		// Vérifie si le contenu du noeud est une opération "ET"
		else if(r.getContenu()=="*") {
			// Appelle récursivement la méthode sur le noeud gauche et droit, et retourne le résultat de l'opération "ET"
			resultat = evaluerRec(r.noeudGauche,Bvect) && evaluerRec(r.noeudDroit,Bvect);
		}
	
		// Vérifie si le contenu du noeud est une opération "NON"
		else if(r.getContenu()=="!") {
			// Appelle récursivement la méthode sur le noeud droit, et retourne l'opposé de son résultat
			resultat = !evaluerRec(r.noeudDroit,Bvect);
		}
	
		// Si le contenu du noeud est une variable, retourne sa valeur dans le vecteur Bvect
		else {
			char lettre = r.getContenu().charAt(0);
			if (lettre >= 'a' && lettre <= 'd') {
				return Bvect[lettre - 'a'];
			} else {
				// Si le contenu du noeud n'est pas une variable, retourne false
				return false;
			}
		}
		return resultat;
	}

    public static String afficher(EB resultat) {

	// Si l'expression booléenne est vide, on retourne un message d'erreur
	if (estVide(resultat)) {
		return "Expression boolean vide ";
	} else {
		// Sinon, on appelle la méthode de parcours récursif pour afficher l'expression booléenne
		return afficherRec(resultat.racine);
	}
}

    private static String afficherRec(Noeud EB) {

	// Si le noeud courant est null, on retourne une chaîne de caractères vide
	if (EB == null) {
		return "";
	}
	
	// Initialisation de la chaîne de caractères qui contiendra l'affichage de l'expression booléenne
	String affichage = "";
	
	// Si le noeud gauche existe, on ajoute son affichage à la chaîne de caractères d'affichage
	if (EB.getNoeudGauche() != null) {
		
		String gauche = afficherRec(EB.getNoeudGauche());
		
		// Si le noeud gauche est une opération "+" ou "*", on ajoute des parenthèses pour respecter la priorité des opérations
		if (gauche.contains("+") || gauche.contains("*")) {
			gauche = "(" + gauche + ")";
		}
		
		affichage += gauche;
	}

	 // On ajoute l'affichage du noeud courant à la chaîne de caractères d'affichage
	 affichage += EB.toString();
  
	// Si le noeud droit existe, on ajoute son affichage à la chaîne de caractères d'affichage
	if (EB.getNoeudDroit() != null) {
		String droit = afficherRec(EB.getNoeudDroit());
		// Si le noeud droit est une opération "*" ou si le noeud courant est une opération "!" et que le noeud droit est une opération "+",
		// on ajoute des parenthèses pour respecter la priorité des opérations
		if (droit.contains("*") || (EB.toString().equals("!") && droit.contains("+"))) {
			droit = "(" + droit + ")";
		}
		affichage += droit;
	}
  
	return affichage;
}
}