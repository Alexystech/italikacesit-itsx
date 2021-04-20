import com.itsx.italikacesit.model.Client;
import com.itsx.italikacesit.model.Mechanic;
import com.itsx.italikacesit.view.ClientLayout;
import com.itsx.italikacesit.view.DashboardLayout;
import com.itsx.italikacesit.view.LoginLayout;
import com.itsx.italikacesit.view.MechanicLayout;
import com.itsx.italikacesit.view.ServiceManagerLayout;
import com.itsx.italikacesit.view.TypeOfWorkLayout;
import com.itsx.italikacesit.view.VehicleLayout;

import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {
        LoginLayout typeOfWorkLayout = new LoginLayout();

        typeOfWorkLayout.setVisible(true);
        typeOfWorkLayout.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
