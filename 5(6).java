import java.util.*;
class Candidate {
int candidateId;
String name;

int aptitude;
int technical;
int communication;
Candidate(int candidateId, String name, int aptitude, int technical, int
communication) {
this.candidateId = candidateId;
this.name = name;
this.aptitude = aptitude;
this.technical = technical;
this.communication = communication;
}
int getTotalScore() {
return aptitude + technical + communication;
}
}
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
int K = sc.nextInt();
Candidate[] c = new Candidate[N];
for (int i = 0; i < N; i++) {
int id = sc.nextInt();
String name = sc.next();
int apt = sc.nextInt();
int tech = sc.nextInt();
int comm = sc.nextInt();
c[i] = new Candidate(id, name, apt, tech, comm);
}
for (int i = 0; i < N - 1; i++) {
for (int j = i + 1; j < N; j++) {
if (c[i].getTotalScore() < c[j].getTotalScore() ||
(c[i].getTotalScore() == c[j].getTotalScore()
&& c[i].candidateId > c[j].candidateId)) {
Candidate temp = c[i];

c[i] = c[j];
c[j] = temp;

}
}
}
System.out.println("Top " + K + " Candidates");
for (int i = 0; i < K; i++) {
System.out.println(c[i].candidateId + " " +
c[i].name + " " +

c[i].getTotalScore());
}
}
}