/**
 * Created by Alan on 2018/5/3.
 */
public class Manager extends Employee {

    private Integer bonus;

    public Manager(String name, Integer age, Double salary) {
        super(name, age, salary);
        bonus=0;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
