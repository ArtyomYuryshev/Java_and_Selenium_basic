package course1.bank;

public enum ClientType {
    ENTITY(15), //true (юр. лицо)
    INDIVIDUAL(25); //false (физ.лицо)

    private final int creditScore;


    ClientType(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

}