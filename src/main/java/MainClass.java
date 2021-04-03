import com.itsx.italikacesit.model.Client;
import com.itsx.italikacesit.model.Mechanic;
import com.itsx.italikacesit.model.TypeOfWork;
import com.itsx.italikacesit.model.Vehicle;
import com.itsx.italikacesit.model.Work;
import com.itsx.italikacesit.service.ClientService;
import com.itsx.italikacesit.service.MechanicService;
import com.itsx.italikacesit.service.TypeOfWorkService;
import com.itsx.italikacesit.service.VehicleService;
import com.itsx.italikacesit.service.WorkService;
import com.itsx.italikacesit.service.impl.ClientServiceImpl;
import com.itsx.italikacesit.service.impl.MechanicServiceImpl;
import com.itsx.italikacesit.service.impl.TypeOfWorkServiceImpl;
import com.itsx.italikacesit.service.impl.VehicleServiceImpl;
import com.itsx.italikacesit.service.impl.WorkServiceImpl;

import java.util.Date;

public class MainClass {

    public static void main(String[] args) {

        WorkService workService = new WorkServiceImpl();
        TypeOfWorkService typeOfWorkService = new TypeOfWorkServiceImpl();
        ClientService clientService = new ClientServiceImpl();
        VehicleService vehicleService = new VehicleServiceImpl();
        MechanicService mechanicService = new MechanicServiceImpl();

        typeOfWorkService.createTypeOfWork(new TypeOfWork(0,"repair"));
        clientService.createClient(new Client(0,"Alexis","Vazquez","Morales","2851156452"));
        vehicleService.createVehicle(new Vehicle("GXZ85A0","Italika","A8",2007));
        mechanicService.createMechanic(new Mechanic(0,"Perfect","Vazquez","Morales","General","2851164474"));

        workService.createWork(new Work(
                0
                ,new TypeOfWork(1,"repair")
                ,new Mechanic(1,"Perfect","Vazquez","Morales","General","2851156452")
                ,new Vehicle("GXZ85A0","Italika","A9",2019)
                ,250D
                ,new Date(2000,8,14)
                ,new Date(2021,8,14)
                ,new Client(1,"Alexis","Vazquez","Morales","2851164412")
                ,"fuga de aceite y purgacion en frenos"
        ));

    }
}
