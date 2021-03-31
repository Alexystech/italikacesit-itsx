package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.TypeOfWork;

import java.util.List;

public interface TypeOfWorkService {
    boolean createTypeOfWork(TypeOfWork typeOfWork);
    boolean removeTypeOfWorkByFolio(int folio);
    boolean updateTypeOfWorkByFolio(int folio);
    List<TypeOfWork> getAllTypeOfWorks();
}
