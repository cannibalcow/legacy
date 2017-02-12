package se.knowit.legacy.rules;

public abstract class Rule<T> {
    public abstract String getRuleName();
    public abstract boolean execute(T value);
}

