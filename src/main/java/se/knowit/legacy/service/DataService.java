package se.knowit.legacy.service;

import java.util.List;

public interface DataService<T> {
    List<T> fetchMinors(Long year);
}
