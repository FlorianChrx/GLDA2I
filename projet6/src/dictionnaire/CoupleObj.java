package dictionnaire;

import java.util.Objects;

/**
 * Cette classe représente un couple comportant deux objets
 * quelconques.
 */
public class CoupleObj<K, V> implements Couple<K, V> {
    private K clef;
    private V valeur;

    public CoupleObj(K k, V v) {
        clef = k;
        valeur = v;
    }

    public K premier() {
        return clef;
    }

    public V second() {
        return valeur;
    }

    public void defPremier(K k) {
        clef = k;
    }

    public void defSecond(V v) {
        valeur = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoupleObj)) return false;
        CoupleObj<?, ?> coupleObj = (CoupleObj<?, ?>) o;
        return Objects.equals(clef, coupleObj.clef) &&
                Objects.equals(valeur, coupleObj.valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clef, valeur);
    }

    public String toString() {
        return clef + " -> " + valeur;
    }
}
