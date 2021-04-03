package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Work;

import java.util.List;

public interface WorkService {
    boolean createWork(Work work);
    boolean removeWorkByFolio(int folio);
    boolean updateWorkByObject(Work work);
    Work getWorkByFolio(int folio);
    List<Work> getAllWorks();
}
