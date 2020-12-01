import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    void constructorFailsWithInvalidDueDate() {
        TaskItem test = TaskItem.newTask("test","description","");
        assertNull(test);
    }

    @Test
    void constructorFailsWithInvalidTitle() {
        TaskItem test = TaskItem.newTask("","description","2000-12-12");
        assertNull(test);
    }

    @Test
    void constructorSucceedsWithValidDueDate() {
        TaskItem test = TaskItem.newTask("test","description","2000-12-21");
        assertNotNull(test);
        assertEquals("test", test.getTitle());
        assertEquals("description",test.getDescription());
        assertEquals("2000-12-21",test.getDate());
    }

    @Test
    void constructorSucceedsWithValidTitle() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertEquals("test", test.getTitle());
        assertEquals("descritption",test.getDescription());
        assertEquals("2000-12-12",test.getDate());
    }

    @Test
    void editingDescriptionSucceedsWithExpectedValue(){

    }


    @Test
    void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertFalse(test.editDate(""));
        assertEquals("2000-12-12",test.getDate());
    }

    @Test
    void editingDueDateSucceedsWithExpectedValue() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertTrue(test.editDate("2000-12-21"));
        assertEquals("2000-12-21",test.getDate());
    }

    @Test
    void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertFalse(test.editTitle(""));
        assertEquals("test",test.getTitle());
    }

    @Test
    void editingTitleSucceedsWithExpectedValue() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertTrue(test.editTitle("other Title"));
        assertEquals("other Title",test.getTitle());
    }



}