package pro.sky.homework28;
import org.springframework.stereotype.Service;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmploeeService {

     Emploee maxSalary(Integer salary);
     Emploee minSalary(Integer salary);
     Set findEmploees(Integer depId);
     Set eploeesInDepartment(int departament);
     Set allEmploees();
}