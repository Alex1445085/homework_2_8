package pro.sky.homework28;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmploeeServiceImpl implements EmploeeService {

//    private final EmploeeService serv;
//    public EmploeeServiceImpl(EmploeeService serv) { this.serv = serv; }

    private Set<Emploee> emploees = new HashSet<>();
    {
        emploees.add(new Emploee("Ivanov", "Ivan", 1, 86811));
        emploees.add(new Emploee("Petrov", "Petr", 2, 80000));
        emploees.add(new Emploee("Ivanov", "Petr", 3, 99100));
        emploees.add(new Emploee("Kumov", "Ivan", 4, 97600));
        emploees.add(new Emploee("Gamov", "Egor", 5, 84667));
        emploees.add(new Emploee("Sizov", "Oleg", 5, 73000));
        emploees.add(new Emploee("Slikoff", "Mike", 4, 125400));
        emploees.add(new Emploee("Krotov", "Andr", 3, 95410));
        emploees.add(new Emploee("Vasin", "Nikolay", 1, 142000));
        emploees.add(new Emploee("Gorin", "Nikk", 1, 82000));
    }

    @Override
    public Emploee maxSalary(Integer depId) {
        Emploee emploeeInDepartament = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .max(Comparator.comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartament;
    }

    @Override
    public Emploee minSalary(Integer depId) {
        Emploee emploeeInDepartment = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .min(Comparator.comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return  emploeeInDepartment;
    }

    @Override
    public Set findEmploees(Integer depId) {
        if (depId == null) { return allEmploees(); }
        else { return eploeesInDepartment(depId); }
    }

    @Override
    public Set eploeesInDepartment(int depId) {  //"Cписок сотрудников в отделе # depId
        Set<Emploee> temp = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .collect(Collectors.toSet());
        return Collections.unmodifiableSet(temp);
    }

    @Override
    public Set allEmploees() {    //"Cписок всех сотрудников
        return Collections.unmodifiableSet(emploees);
    }
}