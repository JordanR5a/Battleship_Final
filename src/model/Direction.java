package model;

public enum Direction{
    N,
    E,
    S,
    W;

    public static Direction valueOfSpecial(String str){
        try{
            return Direction.valueOf(str);
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("You input does not match an acceptable direction. Please, try again.");
        }
    }
}
