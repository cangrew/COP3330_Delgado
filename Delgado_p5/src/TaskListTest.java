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
    void editingItemDescriptionFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(5,"test","test2","2020-10-10");
        assertEquals("test", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2020-10-10",test.get(0).getDate());
    }

    @Test
    void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(0,"test2","test2","2022-10-10");
        assertEquals("test2", test.get(0).getTitle());
        assertEquals("test2",test.get(0).getDescription());
        assertEquals("2022-10-10",test.get(0).getDate());
    }

    @Test
    void editingItemDueDateSucceedsWithExpectedValue(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(0,"test","test","2022-10-10");
        assertEquals("test", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2022-10-10",test.get(0).getDate());
    }

    @Test
    void editingItemTitleFailsWithEmptyString(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(0,"","test","2022-10-10");
        assertEquals("test", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2022-10-10",test.get(0).getDate());
    }

    @Test
    void editingItemTitleFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(5,"test2","test","2022-10-10");
        assertEquals("test", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2020-10-10",test.get(0).getDate());
    }

    @Test
    void editingItemTitleSucceedsWithExpectedValue(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(0,"test2","test","2020-10-10");
        assertEquals("test2", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2020-10-10",test.get(0).getDate());
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(0,"test","test","20230-10-10");
        assertEquals("test", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2020-10-10",test.get(0).getDate());
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        test.editTask(5,"test","test","2020-10-10");
        assertEquals("test", test.get(0).getTitle());
        assertEquals("test",test.get(0).getDescription());
        assertEquals("2020-10-10",test.get(0).getDate());
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

    @Test
    void savedTaskListCanBeLoaded(){
        TaskList test = new TaskList();
        test.addTask("test","test","2020-10-10");
        TaskApp.saveList(test,"test.txt");
        TaskList test2 = TaskApp.loadList("test.txt");
        //System.out.println(test2.toString());
        assertEquals(test2.toString(),test.toString());
    }





}