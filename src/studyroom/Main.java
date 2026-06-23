package studyroom;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import studyroom.notification.ConsoleNotifier;
import studyroom.student.ArrivalReminder;
import studyroom.student.Student;

public class Main {
    static void main(String[] args) {

        ConsoleNotifier notifier = new ConsoleNotifier();

        List<Student> students = List.of(
                new Student("윤하영", LocalTime.of(20, 0)),
                new Student("이수경", LocalTime.of(21, 0)),
                new Student("김민중", LocalTime.of(21, 0)),
                new Student("장다솔", LocalTime.of(19, 0))
        );

        students.get(2).attend();
        students.get(3).attend();


        List<ArrivalReminder> reminders = new ArrayList<>();

        for (Student member : students) {
            reminders.add(new ArrivalReminder(member));
        }

        LocalTime currentTime = LocalTime.now();

        for(ArrivalReminder reminder : reminders){
            if(reminder.isDue(currentTime)){
                Student student = reminder.getStudent();

                notifier.notify(
                        student.getName() + "학생이 아직 입실하지 않았습니다."
                );

                reminder.scheduleNext();

                System.out.println(reminder.getNextReminderTime());
            }
        }




    }
}
