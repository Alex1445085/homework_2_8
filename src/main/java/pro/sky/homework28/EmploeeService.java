package pro.sky.homework28;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

public interface EmploeeService {

     Emploee maxSalary(Integer salary);
     Emploee minSalary(Integer salary);
     Set findEmploees(Integer depId);
     Set eploeesInDepartment(int departament);
     Set allEmploees();
}