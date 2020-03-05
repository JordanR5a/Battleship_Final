package model;

public enum Ship {
    CARRIER(5), BATTLESHIP(4), DESTROYER(3), SUBMARINE(3), PATROL_BOAT(2);

    private final int size;

    private Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String start = this.name().substring(0, 1);
        String rest = this.name().substring(1).toLowerCase();
        return String.format("%s%s", start, rest);
    }

}
