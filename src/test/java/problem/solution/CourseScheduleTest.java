package problem.solution;

import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleTest {


    @Test
    public void test1() {
        CourseSchedule schedule = new CourseSchedule();
        int numCourses = 5;
        int[][] prerequisites = new int[numCourses][2];
        prerequisites[0][1] = 0; prerequisites[0][0] = 1;
        prerequisites[1][1] = 1; prerequisites[1][0] = 2;
        prerequisites[2][1] = 1; prerequisites[2][0] = 3;
        prerequisites[3][1] = 2; prerequisites[3][0] = 4;
        prerequisites[4][1] = 3; prerequisites[4][0] = 4;
        boolean canFinish = schedule.canFinish(numCourses, prerequisites);
        Assert.assertTrue(canFinish);
    }

    @Test
    public void test2() {
        CourseSchedule schedule = new CourseSchedule();
        int numCourses = 5;
        int[][] prerequisites = new int[numCourses][2];
        prerequisites[0][1] = 0; prerequisites[0][0] = 1;
        prerequisites[1][1] = 1; prerequisites[1][0] = 2;
        prerequisites[2][1] = 2; prerequisites[2][0] = 4;
        prerequisites[3][1] = 4; prerequisites[3][0] = 3;
        prerequisites[4][1] = 3; prerequisites[4][0] = 1;
        boolean canFinish = schedule.canFinish(numCourses, prerequisites);
        Assert.assertFalse(canFinish);
    }

    @Test
    public void test3() {
        CourseSchedule schedule = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = new int[numCourses][2];
        prerequisites[0][1] = 0; prerequisites[0][0] = 1;
        prerequisites[1][1] = 1; prerequisites[1][0] = 0;
        boolean canFinish = schedule.canFinish(numCourses, prerequisites);
        Assert.assertFalse(canFinish);
    }
}