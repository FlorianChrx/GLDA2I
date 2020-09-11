class ObjetNumerote {
    public static int incrementor = 1;
    private int num;

    public ObjetNumerote() {
        this.num = incrementor;
        incrementor++;
    }
    
    public int getNum() {
        return num;
    }
}