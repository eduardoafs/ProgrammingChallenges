package sorting.football;

import java.util.*;

/**
 * UVa Problem 10194 - Football (aka Soccer)
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1135
 * FIXME wrong answer
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        String tournamentName;
        int teamsCount;
        int gamesCount;
        HashMap<String,Team> teams;
        String[] gameInfo;
        ArrayList<Team> board;
        String format = "%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)";
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            int tournamentsCount = Integer.parseInt(line);
            for (int i=0; i<tournamentsCount;i++) {
                // tournament info
                line = scan.nextLine();
                tournamentName = line;
                line = scan.nextLine();
                teamsCount = Integer.parseInt(line);

                // teams
                teams = new HashMap<String,Team>();
                for (int a=0;a<teamsCount;a++) {
                    line = scan.nextLine();
                    teams.put(line, new Team(line));
                }

                // results
                line = scan.nextLine();
                gamesCount = Integer.parseInt(line);
                for (int a=0; a<gamesCount;a++) {
                    line = scan.nextLine();

                    gameInfo = line.split("#|@");
                    Team teamA = teams.get(gameInfo[0]);
                    int teamAGoals = Integer.parseInt(gameInfo[1]);
                    Team teamB = teams.get(gameInfo[3]);
                    int teamBGoals = Integer.parseInt(gameInfo[2]);

                    teamA.goals+=teamAGoals;
                    teamA.goalsTaken+=teamBGoals;
                    teamB.goals+=teamBGoals;
                    teamB.goalsTaken+=teamAGoals;
                    if (teamAGoals==teamBGoals) { // draw
                        teamA.tie();
                        teamB.tie();
                    }
                    else if (teamAGoals>teamBGoals) {
                        teamA.win();
                        teamB.lose();
                    } else {
                        teamA.lose();
                        teamB.win();
                    }
                }

                // order the games and output the tournment
                board = new ArrayList<Team>(teams.values());
                Collections.sort(board);

                // prints
                if (i!=0) System.out.println();
                System.out.println(tournamentName);
                for (int a=0; a<teamsCount;a++) {
                    Team team = board.get(a);
                    System.out.println(String.format(format, a+1, team.name, team.points(), team.games(), team.victories, team.ties, team.defeats, team.sg(),team.goals, team.goalsTaken));
                }
            }
        }
    }

    static class Team implements Comparable<Team> {
        private String name;
        public int goals;
        public int goalsTaken;
        private int ties;
        private int victories;
        private int defeats;

        public Team(String name) {
            this.name = name;
        }
        public void tie() {
            this.ties++;
        }
        public void win() {
            this.victories++;
        }
        public void lose() {
            this.defeats++;
        }

        public int points() {
            return victories*3 + ties;
        }

        public int games() {
            return victories+ties+defeats;
        }
        public int sg() {
            return this.goals-this.goalsTaken;
        }

        @Override
        public int compareTo(Team o) {
            int compare = Integer.compare(this.points(), o.points());
            if (compare==0) {
                compare = Integer.compare(this.victories, o.victories);
                if (compare==0) {
                    compare = Integer.compare(this.sg(), o.sg());
                    if (compare==0) {
                        compare = Integer.compare(this.goals, o.goals);
                        if (compare==0) {
                            compare = Integer.compare(this.games(), o.games())*-1;
                            if (compare==0) {
                                compare = this.name.compareToIgnoreCase(o.name)*-1;
                            }
                        }
                    }
                }
            }
            return compare*-1;
        }
    }
}
