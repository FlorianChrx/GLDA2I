package boogle.mots;

import java.io.*;
import java.util.List;
import java.util.Optional;

/**
 * La classe ArbreLexical permet de stocker de façon compacte et
 * d'accéder rapidement à un ensemble de mots.
 */
public class ArbreLexical {
    public static final int TAILLE_ALPHABET = 26;
    private boolean estMot; // vrai si le noeud courant est la fin d'un mot valide
    private ArbreLexical[] fils = new ArbreLexical[TAILLE_ALPHABET]; // les sous-arbres

    /**
     * Crée un arbre vide (sans aucun mot)
     */
    public ArbreLexical() {
    }

    /**
     * Crée un arbre lexical qui contient tous les mots du fichier
     * spécifié.
     */
    public static ArbreLexical lireMots(String fichier) {
        ArbreLexical arbre = new ArbreLexical();
        try {
            BufferedReader stream = new BufferedReader(new FileReader(new File(fichier)));
            stream.lines().forEach(arbre::ajouter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arbre;
    }

    /**
     * Indique si le noeud courant est situé à l'extrémité d'un mot
     * valide
     */
    public boolean estMot() {
        return estMot;
    }

    /**
     * Place le mot spécifié dans l'arbre
     *
     * @return <code>true</code> si le mot a été ajouté,
     * <code>false</code> sinon
     */
    public boolean ajouter(String word) {
        if(word == null || contient(word)) return false;
        if (word.equals("")) {
            estMot = true;
            return true;
        }
        if (fils[word.toCharArray()[0]] == null) fils[word.toCharArray()[0]] = new ArbreLexical();
        return fils[word.toCharArray()[0]].ajouter(word.substring(1));
    }

    /**
     * Test si l'arbre lexical contient le mot spécifié.
     *
     * @return <code>true</code> si <code>o</code> est un mot
     * (String) contenu dans l'arbre, <code>false</code> si
     * <code>o</code> n'est pas une instance de String ou si le mot
     * n'est pas dans l'arbre lexical.
     */
    public boolean contient(String word) {
        return getWord(word).isPresent();
    }

    /**
     * Ajoute à la liste <code>resultat<code> tous les mots de
     * l'arbre commençant par le préfixe spécifié.
     *
     * @return <code>true</code> si <code>resultat</code> a été
     * modifié, <code>false</code> sinon.
     */
    public boolean motsCommencantPar(String prefixe, List<String> resultat) {
        Optional<ArbreLexical> apresPrefixe = getWord(prefixe);
        if(!apresPrefixe.isPresent()) return false;
        int length = resultat.size();
        for(int i = 0; i < TAILLE_ALPHABET; i++) {
            if(fils[i] != null) fils[i].motsCommencantPar(prefixe + Character.toString(i), resultat);
        }
        return length != resultat.size();
    }

    /**
     * Obtient le potentiel sous arbre correspondant à un enchainement de lettres
     * @param word le "mot" formé par les lettres donnés
     * @return un <code>ArbreLexical</code> si <code>word</code> est un enchaînement connu dans l'arbre;
     */
    public Optional<ArbreLexical> getWord(String word) {
        if (word == null || fils[word.toCharArray()[0]] == null) return Optional.empty();
        if (word.equals("")) return Optional.of(this);
        return fils[word.toCharArray()[0]].getWord(word.substring(1));
    }
}
