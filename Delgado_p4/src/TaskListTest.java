import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void addingTaskItemsIncreasesSize() {
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        assertEquals(1,test.size());
    }

    @Test
    void completingTaskItemChangesStatus() {
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.markTask(0);
        assertTrue(test.get(0).isCompleted());
    }

    @Test
    void completingTaskItemFailsWithInvalidIndex() {
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        assertFalse(test.markTask(2));
    }

    @Test
    void editingTaskItemChangesValues() {
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(0,"test2","test2","1000-12-12");
        assertEquals("test2", test.get(0).getTitle());
        assertEquals("test2",test.get(0).getDescription());
        assertEquals("1000-12-12",test.get(0).getDate());

    }

    @Test
    void newTaskListIsEmpty() {
        TaskList test = new TaskList();
        assertEquals(0,test.size());
    }

    @Test
    void removingTaskItemsDecreasesSize() {
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.remove(0);
        assertEquals(0,test.size());
    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex() {
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        assertFalse(test.removeTask(3));
        assertEquals(1,test.size());
    }







}