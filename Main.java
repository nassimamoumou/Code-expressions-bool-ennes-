public class Main {

	public static void main(String[] args) {
		// création de l'expression booléenne f
		EB f = new EB();
		// utilisation de différentes méthodes pour construire l'expression f
		f = EB.negation(EB.disjonction(
			EB.conjonction(EB.negation(EB.singleton("a")), 
			EB.disjonction(EB.singleton("c"), EB.singleton("a"))),
			EB.negation(EB.conjonction(EB.singleton("b"), EB.singleton("d")))));
		
		// création de l'expression booléenne e
		EB e = new  EB() ;
		// utilisation de différentes méthodes pour construire l'expression e
		e = EB.conjonction(
			EB.disjonction(EB.negation(EB.singleton("a")),
			EB.conjonction(EB.singleton("b"), EB.singleton("c"))),
			EB.negation(EB.singleton("c")));
		
		// affichage de l'expression booléenne f
		System.out.println("Expression booléenne f :");
		System.out.println(" f = " + EB.afficher(f));
		// création d'un vecteur de booléens pour évaluer l'expression
		boolean [] bVect = new boolean [4];
		bVect[0]=false;
		bVect[1]=true;
		bVect[2]=false;
		bVect[3]=false;
		// évaluation de l'expression f avec le vecteur de booléens bVect
		boolean resultat1 = EB.evaluer(f, bVect);
		System.out.println("Le résultat de test pour l'expression f : " + resultat1);

		System.out.println("      ");

		// affichage de l'expression booléenne e
		System.out.println("Expression booléenne e :");
		System.out.println(" e = " + EB.afficher(e));
		// évaluation de l'expression e avec le vecteur de booléens bVect
		boolean resultat2 = EB.evaluer(e, bVect);
		System.out.println("Le résultat de test pour l'expression e : " + resultat2);
	}
}




























































/*
public class Test {

	public static void main(String[] args) throws Exception {
		Noeud n1 = new Noeud ("+");
		Noeud n2 = new Noeud ("*");
		Noeud n3 = new Noeud ("!");
		Noeud a = new Noeud ("a");
		Noeud b = new Noeud ("b");
		Noeud c = new Noeud ("c");
		Noeud d = new Noeud ("d");


		EB e10 = new EB();
		EB e11 = new EB();
		EB e12 = new EB();

		e10= EB.disjonction(EB.conjonction(EB.singleton("a"),EB.singleton("b") ),EB.conjonction(EB.singleton("b"), EB.negation(EB.singleton("c"))));
		e11= EB.negation(EB.disjonction(EB.singleton("a"), EB.negation( EB.singleton("d"))));

		e12 = EB.conjonction(e10,e11);

 e10.afficher()
}
}
*/






















/*
		 boolean [] Bvect = new boolean [EB.nombreDeVariables(e12)];

			Bvect[0]=false;
			Bvect[1]=true;
			Bvect[2]=false;
			Bvect[3]=false;

			try {

			System.out.println( EB.evaluer(EB.singleton("d"),Bvect));


		} catch(Exception e){
			e.printStackTrace();
		}
*/









/*
		try {

		EB e1 = new EB();
	    EB e2 = new EB();
		EB e3 = new EB();


		e1 = EB.disjonction( EB.negation(EB.singleton("a")) , EB.conjonction(EB.singleton("b"), EB.singleton("c")));
		e2 =EB.negation(EB.singleton("c"));
        e3 =EB.conjonction(e1, e2);

        boolean [] Bvect = new boolean [EB.nombreDeVariables(e3)];

		Bvect[0]=true;
		Bvect[1]=false;
		Bvect[2]=false;



		System.out.println( EB.evaluer(EB.singleton("c"),Bvect));

		}
		catch(Exception e){
			e.printStackTrace();

		}*/
		//System.out.println(EB.nombreDeVariables(e3));


		//System.out.println(EB.estVide(EB.negation(e3)));
