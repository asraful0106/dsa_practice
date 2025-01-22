package heaps;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQforClassObject {
    static class Student implements Comparable<Student> {
        String name;
        int position;

        public Student(String name, int position) {
            this.name = name;
            this.position = position;
        }

        @Override
        public int compareTo(Student s2) {
            return this.position - s2.position;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Md. Asraful Alom", 150));
        pq.add(new Student("Md. Moez", 15));
        pq.add(new Student("Md. Abir", 100));
        pq.add(new Student("Md. Nahid Hassan", 120));
        pq.add(new Student("Md. Shafikul Islam", 107));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().position);
            pq.remove();
        }
    }
}
