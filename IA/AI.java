package IA;

/**
 * Cette classe est l'interface pour les IA dans le jeu. 
 * Cela consiste en une seule méthode publique, getAIMove (), dont chaque IA a sa propre version. 
 * C'est cette méthode qui définit la personnalité des fantômes 
 * car suite à getAIMove (), une "Direction" est renvoyée.  
 */
public interface AI {

	
	/**
	* @return La direction dans laquelle le fantôme ira
	* L'IA est une interface car une IA distincte devra être
	* fait pour chaque fantôme puisque chacun a sa propre personnalité.
	*/
	
	public Direction getMove();
	
}