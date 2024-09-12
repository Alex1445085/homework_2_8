package pro.sky.homework28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/departments")
public class EmploeeController {
    Set<Emploee> emploee = new HashSet<>();
    EmploeeService serv = new EmploeeServiceImpl();

    {
        serv.emploeesAbOvo();
    }

    @GetMapping("/max-salary")
    public String maxSalary(@RequestParam("departmentId") Integer depId) {
        return serv.maxSalary(depId);
    }

    @GetMapping("min-salary")
    public String minSalary(@RequestParam("departmentId") Integer depId) {
        return serv.minSalary(depId);
    }

    @GetMapping("/all")
    public String setOfEmploeesById(@RequestParam(value = "departmentId", required = false) Integer depId) {
        if (depId != null) {
            return serv.setOfEploeesById(depId);
        } else {
            return serv.setOfEmploees();
        }
    }
}
