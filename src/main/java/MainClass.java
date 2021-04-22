import com.itsx.italikacesit.controller.LoginController;
import com.itsx.italikacesit.service.AdministratorService;
import com.itsx.italikacesit.service.impl.AdministratorServiceImpl;
import com.itsx.italikacesit.view.LoginLayout;

public class MainClass {

    public static void main(String[] args) {
        LoginLayout loginLayout = new LoginLayout();
        AdministratorService administratorService = new AdministratorServiceImpl();

        LoginController loginController = new LoginController(loginLayout, administratorService);
        loginController.start();
        loginController.runValidations();
    }
}
