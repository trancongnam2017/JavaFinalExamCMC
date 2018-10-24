package com.Java.business;

import java.util.List;

public interface BusinessInterface<T> {

        T addNew(T t);

        List<T> getAll();
    }
