package Javacore_1_Sport;

public class Course {

    int [] Contest;

    public Course (Track track, Weightlifting weightlifting, PoleVaulting poleVaulting){

        this.Contest = new int[]{track.getLength(), weightlifting.getWeight(), poleVaulting.getHeight()};

    }

    public void doIt(Team team) {
        for (int i = 0; i < team.getAthleteArr().length; i++) {
                if (team.getAthleteArr()[i].getAgility() >= Contest[0] &&
                        team.getAthleteArr()[i].getPower() >= Contest[1] &&
                            team.getAthleteArr()[i].getTechnique() >= Contest[2])

        {
            System.out.println("К финишу пришёл: " + team.getAthleteArr()[i]);


                }
        }
    }
}




