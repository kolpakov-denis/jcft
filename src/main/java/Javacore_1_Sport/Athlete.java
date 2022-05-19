package Javacore_1_Sport;

public class Athlete {
    private String name;
    private String surname;
    private int power;
    private int agility;
    private int technique;

    public Athlete(String name, String surname, int power, int agility, int technique) {
        this.name = name;
        this.surname = surname;
        this.power = power;
        this.agility = agility;
        this.technique = technique;
    }

    @Override
    public String toString() {
        return "\n" + "Athlete { " + "\n" +
                "name='" + name + '\'' + "\n" +
                "surname='" + surname + '\'' + "\n" +
                "power=" + power + "\n" +
                "agility=" + agility + "\n" +
                "technique=" + technique + "\n" +
                '}' + "\n";
    }

    public double getPower() {
        return power;
    }

    public double getAgility() {
        return agility;
    }

    public double getTechnique() {
        return technique;
    }

}
