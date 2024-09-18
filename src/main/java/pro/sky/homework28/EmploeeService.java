package pro.sky.homework28;
import java.util.List;
import java.util.Map;

public interface EmploeeService {

     Emploee maxSalary(Integer salary);
     Emploee minSalary(Integer salary);
     Map<Integer, List<Emploee>> findEmploees(Integer depId);
     Map<Integer, List<Emploee>> eploeesInDepartment(Integer depId);
     Map<Integer, List<Emploee>> allEmploees();
}