package image;

public class ImagesIncompatiblesException extends Exception {
    @Override
    public String getMessage() {
        return "Une opération conçernant des images incompatibles à été tentée !";
    }
}
