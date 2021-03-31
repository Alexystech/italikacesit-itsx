package com.itsx.italikacesit.service;

import com.itsx.italikacesit.model.Client;

import java.util.List;

public interface ClientService {
    boolean createClient(Client client);
    boolean removeClientByFolio(int folio);
    boolean updateClientByFolio(Client client);
    Client getClientByFolio(int folio);
    List<Client> getAllClients();
}
