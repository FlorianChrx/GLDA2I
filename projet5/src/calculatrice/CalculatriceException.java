package calculatrice;

/**
 * Classe représentant un exception qui se lève lors d'une erreur de calcul
 */
public class CalculatriceException extends Exception{
    @Override
    public String getMessage() {
        return "Il y a une erreur dans votre calcul !";
    }
}
