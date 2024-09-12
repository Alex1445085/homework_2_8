package pro.sky.homework28;

import java.util.*;
import java.util.stream.Collectors;

public class EmploeeServiceImpl extends EmploeeService {
    public Set<Emploee> emploees = new HashSet<>();

    @Override
    String maxSalary(Integer depId) {
        Emploee emploeeInDepartament = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .max(Comparator.comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Отдел не найден"));
        return "Наибольшая з/п в отделе #" + depId + " у сотрудника " + emploeeInDepartament.toString();
    }

    @Override
    String minSalary(Integer depId) {
        Emploee emploeeInDepartament = emploees.stream()
                    .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                    .min(Comparator.comparing(Emploee::getSalary))
                    .orElseThrow(() -> new DepartmentNotFoundException("Отдел не найден"));
            return "Наименьшая з/п в отделе #" + depId + " у сотрудника " + emploeeInDepartament.toString();
    }

    @Override
    String setOfEploeesById(Integer depId) {
        Set<Emploee> temp = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .collect(Collectors.toSet());
        return "Cписок сотрудников в отделе #" + depId + " : " + temp.toString();
    }

    @Override
    String setOfEmploees() {
        return "Cписок всех сотрудников : " + emploees.toString();
    }

    @Override
    void emploeesAbOvo() {
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
        temp = new Emploee("Gorin", "Nikk", 1, 162000);
        emploees.add(temp);
    }
}
