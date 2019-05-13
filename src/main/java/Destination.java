public enum Destination {
    GLA(5),
    LDN(300),
    PRS(450),
    TKO(700);

    private final int minimumBooking;

    Destination(int minimumBooking) {
        this.minimumBooking = minimumBooking;
    }

    public int getMinimumBooking(){
        return minimumBooking;
    }
}

