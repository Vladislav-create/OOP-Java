package org.example.chars;

public class PositionUnit {
    int x;
    int y;

    public PositionUnit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(PositionUnit opposit){
        if (opposit.y == y && opposit.x == x) return true;
        return false;
    }
}
