package pro.sky.homework28;

import java.util.Collection;
import java.util.Set;

public interface EmploeeService {

     Emploee maxSalary(Integer salary);
     Emploee minSalary(Integer salary);
     Set findEmploees(Integer depId);
     Set eploeesInDepartment(Integer departament);
     Set allEmploees();
}