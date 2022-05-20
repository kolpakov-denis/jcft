package Javacore_1_Sport;

import java.util.Arrays;

public class Team {
    private String teamname;
    private Athlete athleteArr [];

    public Team (String teamname, Athlete[] athleteArr){

        this.teamname = teamname;
        this.athleteArr = athleteArr;

    }

    public String League() {
       return "Team name is: " + getTeamname() + "\n" + "Team members are: " + Arrays.toString(athleteArr);
    }

    public Athlete[] getAthleteArr() {
        return athleteArr;
    }

    public void setAthleteArr(Athlete[] athleteArr) {
        this.athleteArr = athleteArr;
    }

    public String getTeamname() {
        return teamname;


    }
}
