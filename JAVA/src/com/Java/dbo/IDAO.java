package com.Java.dbo;

import java.util.List;

public interface IDAO<T> {
        T addNew(T t);
        List<T> getAll();
    }