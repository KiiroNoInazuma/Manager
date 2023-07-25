import dao.EssenceDAO;
import dao.EssenceDaoImpl;
import models.City;
import models.Employee;

/**В main каждый тип операции нужно выполнять отдельно друг от друга, кроме выборки по id, которая участвует в редактировании и удалении объектов.
 * Для отдельного выполнения той или иной операции необходимо комментировать методы в пунктах.
 **/
public class App {
    private final static EssenceDAO<City> essenceCity = new EssenceDaoImpl<>();
    private final static EssenceDAO<Employee> essenceEmployee = new EssenceDaoImpl<>();
    private final static EssenceDAO<?> essenceSome = new EssenceDaoImpl<>();
    public static void main(String[] args) {

        /*----------------------------Добавление объекта в таблицу-------------------------------*/
        City cityInsert = new City(6, "New York");
        Employee employeeInsert = new Employee("John", "Wick", "М", 6);
        essenceCity.add(cityInsert);
        essenceEmployee.add(employeeInsert);
        /*----------------------------Получение объекта по id------------------------------------*/
        City city = essenceCity.getId(City.class, 6);                        //Т.к. OneToMany выводит строку c 2-х соединенных таблиц по city_id;
        Employee employee = essenceEmployee.getId(Employee.class, 23);       // Использовать выборку по id для редактирования и удаления объектов;
        System.out.println(city);
        System.out.println(employee);
        /*----------------------------Получение всех объектов таблицы----------------------------*/
        essenceSome.all();
        /*----------------------------Редактирование объекта--------------------------------------------*/
        city.setCityName("Belarus");
        essenceCity.mod(city);
        employee.setName("Ярдані");
        employee.setSecondName("Яванавіч");
        essenceEmployee.mod(employee);
        /*----------------------------Удаление объекта--------------------------------------------*/
        essenceCity.remove(city);
        essenceEmployee.remove(employee);
    }
}
