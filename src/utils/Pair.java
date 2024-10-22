package utils;

public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public Pair(Pair<T, U> other) {
        this.first = other.first;
        this.second = other.second;
    }

    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }
}
