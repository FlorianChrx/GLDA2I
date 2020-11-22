package image;

import dictionnaire.Dictionnaire;

public abstract class ImageDictQuelconque extends ImageQuelconque {
    protected Dictionnaire points;

    public ImageDictQuelconque(int w, int h) {
        largeur = w;
        hauteur = h;
        initialiserPoints();
    }

    protected abstract void initialiserPoints();
}
