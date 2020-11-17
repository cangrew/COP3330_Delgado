import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    void creatingTaskItemFailsWithInvalidDueDate() {
        TaskItem test = TaskItem.newTask("test","description","");
        assertNull(test);
    }

    @Test
    void creatingTaskItemFailsWithInvalidTitle() {
        TaskItem test = TaskItem.newTask("","description","2000-12-12");
        assertNull(test);
    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem test = TaskItem.newTask("test","description","2000-12-21");
        assertNotNull(test);
        assertEquals("test", test.getTitle());
        assertEquals("description",test.getDescription());
        assertEquals("2000-12-21",test.getDate());
    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertEquals("test", test.getTitle());
        assertEquals("descritption",test.getDescription());
        assertEquals("2000-12-12",test.getDate());
    }

    @Test
    void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertFalse(test.editDate(""));
        assertEquals("2000-12-12",test.getDate());
    }

    @Test
    void settingTaskItemDueDateSucceedsWithValidDate() {
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
    void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem test = TaskItem.newTask("test","descritption","2000-12-12");
        assertNotNull(test);
        assertTrue(test.editTitle("other Title"));
        assertEquals("other Title",test.getTitle());
    }



}