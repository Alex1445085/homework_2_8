package pro.sky.homework28;

import java.util.*;
import java.util.stream.Collectors;

public class EmploeeServiceImpl extends EmploeeService {
    private static Set<Emploee> emploees = new HashSet<>();

    @Override
    public Emploee maxSalary(Integer depId) {
        Emploee emploeeInDepartament = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .max(Comparator.comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartament;//"Наибольшая з/п в отделе #" + depId + " у сотрудника " +
    }

    @Override
    public Emploee minSalary(Integer depId) {
//        Optional<Emploee> emploeeInDepartment = Optional.ofNullable(Optional.of(emploees.stream()
//                        .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
//                        .min(Comparator.comparing(Emploee::getSalary)).get())
//                        .orElseThrow(() -> new DepartmentNotFoundException("Department not found")));
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
    public Set eploeesInDepartment(Integer depId) {
        Set<Emploee> temp = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .collect(Collectors.toSet());
        return temp;          //"Cписок сотрудников в отделе #" + depId + " : " +
    }

    @Override
    public Set allEmploees() {
        return emploees;      //"Cписок всех сотрудников : " + emploees.toString();
    }

    public static void emploeesAbOvo() {
        Emploee temp = new Emploee("Ivanov", "Ivan", 1, 86811);
        emploees.add(temp);
        temp = new Emploee("Petrov", "Petr", 2, 80000);
        emploees.add(temp);
        temp = new Emploee("Ivanov", "Petr", 3, 99100);
        emploees.add(temp);
        temp = new Emploee("Kumov", "Ivan", 4, 97600);
        emploees.add(temp);
        temp = new Emploee("Gamov", "Egor", 5, 84667);
        emploees.add(temp);
        temp = new Emploee("Sizov", "Oleg", 5, 73000);
        emploees.add(temp);
        temp = new Emploee("Slikoff", "Mike", 4, 125400);
        emploees.add(temp);
        temp = new Emploee("Krotov", "Andr", 3, 95410);
        emploees.add(temp);
        temp = new Emploee("Vasin", "Nikolay", 1, 142000);
        emploees.add(temp);
        temp = new Emploee("Gorin", "Nikk", 1, 82000);
        emploees.add(temp);
    }
}
