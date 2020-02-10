import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson8Test {

        @Test
        public void createRobot() throws  Exception{
            Robot robot = new Robot(2,2);
            assertEquals(2, robot.getX());
            assertEquals(2, robot.getY());
        }

        @Test
        public void createMoonWithRobot() throws Exception{
            Moon moon = new Moon(10,10);
            Robot robot = new Robot(2,2);
            moon.setRobot(robot);
            assertEquals(2, moon.getRobot().getX());
            assertEquals(2, moon.getRobot().getY());
        }

        @Test
        public void moveRobot() throws Exception{
            Moon moon = new Moon(30,30);
            Robot robot = new Robot(2,5);
            moon.setRobot(robot);
            assertEquals(2, moon.getRobot().getX());
            assertEquals(5, moon.getRobot().getY());
            moon.getRobot().moveX(1);
            moon.getRobot().moveY(10);
            assertEquals(3, moon.getRobot().getX());
            assertEquals(15, moon.getRobot().getY());

        }

        @Test
        public void testNegativeMoveByX() throws Exception {
            Moon moon = new Moon(10, 10);
            Robot robot = new Robot(1, 5);
            moon.setRobot(robot);

            Exception e = Assertions.assertThrows(Exception.class, () -> {
                robot.moveX(-2);
            });
            assertEquals("Robot cannot go to negative coordinates", e.getMessage());
        }

    @Test
    public void testNegativeMoveByY() throws Exception {
        Moon moon = new Moon(10, 10);
        Robot robot = new Robot(1, 5);
        moon.setRobot(robot);

        Exception e = Assertions.assertThrows(Exception.class, () -> {
            robot.moveY(-6);
        });
        assertEquals("Robot cannot go to negative coordinates", e.getMessage());
    }

        @Test
        public void testAddRobotToNegativeCoordinates(){

            Exception e = Assertions.assertThrows(Exception.class, () -> {
                new Robot(-1,-4);
            });
            assertEquals("Robot cannot has negative coordinates", e.getMessage());
        }

        @Test
        public void testAddRobotOutOfMoon() throws Exception{
            Robot robot = new Robot(1,22);
            Moon moon = new Moon(10,10);

            Exception e = Assertions.assertThrows(Exception.class, () -> {
                moon.setRobot(robot);
            });
            assertEquals("Robot cannot be set with out of Moon coordinates", e.getMessage());
        }

        @Test
        public  void testRobotMoveOutsideMoonByX() throws Exception{
            Robot robot = new Robot(0,0);
            Moon moon = new Moon(10,10);
            moon.setRobot(robot);

            robot.moveX(5);
            assertEquals(5, robot.getX());

            Exception e = Assertions.assertThrows(Exception.class, () -> {
                robot.moveX(6);
            });
            assertEquals("Robot cannot go out of Moon", e.getMessage());
        }

    @Test
    public  void testRobotMoveOutsideMoonByY() throws Exception{
        Robot robot = new Robot(0,0);
        Moon moon = new Moon(10,10);
        moon.setRobot(robot);

        robot.moveY(5);
        assertEquals(5, robot.getY());

        Exception e = Assertions.assertThrows(Exception.class, () -> {
            robot.moveY(6);
        });
        assertEquals("Robot cannot go out of Moon", e.getMessage());
    }
}
