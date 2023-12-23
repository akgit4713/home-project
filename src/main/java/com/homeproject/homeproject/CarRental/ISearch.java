package com.homeproject.homeproject.CarRental;

import java.util.List;
import java.util.Map;

public interface ISearch<T> {
    List<T> search(Map<String, String> searchParams);
}
