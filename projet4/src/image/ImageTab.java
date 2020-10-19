package image;

public class ImageTab implements ImageGrise {

    private final NiveauGris[][] image;

    public ImageTab(int largeur, int hauteur) {
        image = new NiveauGris[hauteur][largeur];
    }

    @Override
    public int largeur() {
        return image[0].length;
    }

    @Override
    public int hauteur() {
        return image.length;
    }

    @Override
    public NiveauGris pointEn(int x, int y) {
        return image[x][y];
    }

    @Override
    public void definirPoint(int x, int y, NiveauGris gris) {
        image[x][y] = gris;
    }

    @Override
    public void allumer(int x, int y) {
        definirPoint(x, y, NiveauGris.NOIR);
    }

    @Override
    public void eteindre(int x, int y) {
        definirPoint(x, y, NiveauGris.BLANC);
    }

    @Override
    public void randomize() {
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                definirPoint(i, j, NiveauGris.values()[(int) (Math.random() * NiveauGris.values().length)]);
            }
        }
    }

    @Override
    public int compterPoints(NiveauGris gris) {
        int cpt = 0;
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                if (gris.equals(image[i][j])) cpt++;
            }
        }
        return cpt;
    }

    @Override
    public ImageGrise inverser() {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j].inverser());
            }
        }
        return res;
    }

    @Override
    public ImageGrise eclaircir() {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j].eclaircir());
            }
        }
        return res;
    }

    @Override
    public ImageGrise assombrir() {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j].assombrir());
            }
        }
        return res;
    }

    @Override
    public ImageGrise dupliquer() {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j]);
            }
        }
        return res;
    }

    @Override
    public ImageGrise ajouter(ImageGrise img) {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j].ajouter(img.pointEn(i, j)));
            }
        }
        return res;
    }

    @Override
    public ImageGrise soustraire(ImageGrise img) {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j].soustraire(img.pointEn(i, j)));
            }
        }
        return res;
    }

    @Override
    public ImageGrise XOR(ImageGrise img) {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                res.definirPoint(i, j, image[i][j].XOR(img.pointEn(i, j)));
            }
        }
        return res;
    }

    @Override
    public ImageGrise intersection(ImageGrise img) {
        ImageGrise res = new ImageTab(largeur(), hauteur());
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                if (image[i][j].compareTo(img.pointEn(i, j)) == 0) {
                    res.definirPoint(i, j, image[i][j]);
                } else {
                    res.definirPoint(i, j, NiveauGris.BLANC);
                }
            }
        }
        return res;
    }

    @Override
    public NiveauGris niveauMoyen() {
        int total = 0;
        int nbPixels = 0;
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                total += image[i][j].ordinal();
                total++;
            }
        }
        return NiveauGris.values()[total / nbPixels];
    }

    @Override
    public ImageGrise augmenterContraste() {
        ImageGrise res = dupliquer();
        NiveauGris niv = niveauMoyen();
        for (int i = 0; i < hauteur(); i++) {
            for (int j = 0; i < largeur(); j++) {
                if (res.pointEn(i, j).compareTo(niv) > 0) {
                    res.pointEn(i, j).eclaircir();
                } else if (res.pointEn(i, j).compareTo(niv) < 0) {
                    res.pointEn(i, j).assombrir();
                }
            }
        }
        return res;
    }
}
