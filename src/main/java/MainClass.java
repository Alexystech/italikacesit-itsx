import com.itsx.italikacesit.model.Client;
import com.itsx.italikacesit.service.impl.ClientServiceImpl;

public class MainClass {

    public static void main(String[] args) {
        ClientServiceImpl clientService = new ClientServiceImpl();

        clientService.createClient(new Client(1,"Alexis"
                ,"Vazquez"
                ,"Morales"
                ,"2851156452")
        );

        clientService.createClient(new Client(2,"Alexis"
                ,"Vazquez"
                ,"Morales"
                ,"2851156452")
        );

        clientService.getAllClients().stream().forEach(x -> System.out.println(x.getName()));

//        clientService.removeClientByFolio(1);

        clientService.updateClientByFolio(new Client(2,"Jose"
                ,"Vazquez"
                ,"Morales"
                ,"2851164521")
        );

        clientService.createClient(new Client(1,"Alexis"
                ,"Vazquez"
                ,"Morales"
                ,"2851156452")
        );

        clientService.getAllClients().stream().forEach(x -> System.out.println(x.getName()));
    }
}
