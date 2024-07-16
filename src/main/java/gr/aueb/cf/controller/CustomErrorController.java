package gr.aueb.cf.controller;



import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Μπορείτε να προσθέσετε και άλλες λογικές εδώ, π.χ. logging
        return "error"; // Επιστρέφει το όνομα του view που θα εμφανιστεί σε περίπτωση σφάλματος
    }

}
