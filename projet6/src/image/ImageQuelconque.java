package image;

public abstract class ImageQuelconque implements ImageGrise {
    protected int largeur, hauteur;

    protected boolean correct(int x, int y) {
        return ((x >= 0) && (x < largeur) && (y >= 0) && (y < hauteur));
    }

    protected boolean incompatible(ImageGrise img) {
        return (largeur != img.largeur()) || (hauteur != img.hauteur());
    }

    public int largeur() {
        return largeur;
    }

    public int hauteur() {
        return hauteur;
    }

    public void randomize() {
        for (int y = 0; y < hauteur(); y++)
            for (int x = 0; x < largeur(); x++)
                this.definirPoint(x, y, this.pointEn(x, y).randomizeNB());
    }

    public void allumer(int x, int y) {
        if (this.correct(x, y))
            this.definirPoint(x, y, NiveauGris.NOIR);
    }

    public void eteindre(int x, int y) {
        if (this.correct(x, y))
            this.definirPoint(x, y, NiveauGris.BLANC);
    }

    public int compterPoints(NiveauGris gris) {
        int nombre = 0;
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                if (this.pointEn(x, y).equals(gris))
                    nombre++;
        return nombre;
    }

    public ImageGrise inverser() {
        ImageGrise result = new ImageDict(largeur, hauteur);
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y, this.pointEn(x, y).inverser());
        return result;
    }

    public ImageGrise eclaircir() {
        ImageGrise result = new ImageDict(largeur, hauteur);
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y, this.pointEn(x, y).eclaircir());
        return result;
    }

    public ImageGrise assombrir() {
        ImageGrise result = new ImageDict(largeur, hauteur);
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y, this.pointEn(x, y).assombrir());
        return result;
    }

    public ImageGrise dupliquer() {
        ImageGrise result = new ImageDict(largeur, hauteur);
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y, this.pointEn(x, y));
        return result;
    }

    public ImageGrise ajouter(ImageGrise img) throws ImagesIncompatiblesException {
        ImageGrise result = new ImageDict(largeur, hauteur);
        if (this.incompatible(img))
            throw new ImagesIncompatiblesException();
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y,
                        this.pointEn(x, y).ajouter(img.pointEn(x, y)));
        return result;
    }

    public ImageGrise soustraire(ImageGrise img) throws ImagesIncompatiblesException {
        ImageGrise result = new ImageDict(largeur, hauteur);
        if (this.incompatible(img))
            throw new ImagesIncompatiblesException();
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y,
                        this.pointEn(x, y).soustraire(img.pointEn(x, y)));
        return result;
    }

    public ImageGrise XOR(ImageGrise img) throws ImagesIncompatiblesException {
        ImageGrise result = new ImageDict(largeur, hauteur);
        if (this.incompatible(img))
            throw new ImagesIncompatiblesException();
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                result.definirPoint(x, y,
                        this.pointEn(x, y).XOR(img.pointEn(x, y)));
        return result;
    }

    public ImageGrise intersection(ImageGrise img) throws ImagesIncompatiblesException {
        ImageGrise result = new ImageDict(largeur, hauteur);
        if (this.incompatible(img))
            throw new ImagesIncompatiblesException();
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                if (this.pointEn(x, y).equals(img.pointEn(x, y)))
                    result.definirPoint(x, y, this.pointEn(x, y));
        return result;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(largeur + "x" + hauteur);
        for (int y = 0; y < hauteur; y++) {
            s.append("\n");
            for (int x = 0; x < largeur; x++)
                s.append(this.pointEn(x, y));
        }
        return s.toString();
    }

    public NiveauGris niveauMoyen() {
        int s = 0;
        //for (int n=NiveauGris.BLANC; n<=NiveauGris.NOIR; n++)
        for (int n = 0; n <= NiveauGris.values().length; n++)
            s += n * this.compterPoints(NiveauGris.deNiveau(n));
        return NiveauGris.deNiveau((int) (((double) s) / (largeur * hauteur)));
    }

    public ImageGrise augmenterContraste() {
        NiveauGris courant, moyen;
        ImageGrise result = new ImageDict(largeur, hauteur);
        moyen = this.niveauMoyen();
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++) {
                courant = this.pointEn(x, y);
                if (courant.compareTo(moyen) > 0)
                    result.definirPoint(x, y, courant.assombrir());
                else
                    result.definirPoint(x, y, courant.eclaircir());
            }
        return result;
    }
}
