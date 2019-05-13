public enum Type {
    AIRBUS_A333(450),
    AIRBUS_A340(650),
    AIRBUS_A350(850),
    BOEING_666(5),
    BOEING_777(700),
    BOEING_888(900);

    private final int capacity;

    Type(int capacity){
        this.capacity = capacity;
    }

    public int getPlaneCapacity(){
        return capacity;
    }
}
