package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.jdbc.entity.TasksEntity;
import com.ita.edu.speakua.jdbc.services.TasksService;
import com.ita.edu.speakua.ui.Pages.TaskPO.AddTaskPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TaskTests extends BaseTestRunner {
    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin();

    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Description("Add Task Without Challenge")
    @Test
    public void addTaskWithoutChallenge() {
        String taskName =  RandomStringUtils.random(10, true, true);
        AddTaskPage enterTaskData = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterTaskData.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterTaskData.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterTaskData.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterTaskData.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterTaskData.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2021-03-03")
                .uploadImage("\\src\\test\\resources\\R.jpeg")
                .enterTaskName(taskName)
                .enterTaskTitle("Positive emotions like curiosity, satisfaction, and liveliness have a massive\n impact on how your brain processes your\n learning.")
                .enterTaskDescription("One of the key benefits of having fun while learning is that it creates a sense of reward in learning.\n That inherently motivates people.")
                .clickSave();
        softAssert.assertTrue(enterTaskData.isContainErrorMessage("Please,select challenge"));
        softAssert.assertAll();
        TasksService service = new TasksService();
        TasksEntity task = service.getByName(taskName);
        Assert.assertNull(task);
    }

    @Description("Add Task with Invalid Description")
    @Test
    public void taskWithInvalidDescription() {
        AddTaskPage enterInvalidData = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidData.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidData.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidData.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidData.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidData.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-03-03")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("LearnTest")
                .enterTaskTitle("Positive emotions like curiosity, satisfaction, and liveliness have a massive\n impact on how your brain processes your\n learning.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("???????? ???????? ???? ???????? ???????? ????????????"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterTaskDescription("??????, ??????, ??, ????????, ??????, ??, ????????, ??????, ??, ????????, ??????, ??, ??")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("???????? '????????' ???????? ?????????????? ???????????? ???????????????????? ???? ???????????????????? ????????????, ?????????? ???? ???????????????????? ??????????????"));
        softAssert = new SoftAssert();
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("LearnTest")
                .enterTaskTitle("Positive emotions like curiosity, satisfaction, and liveliness have a massive\n impact on how your brain processes your\n learning.")
                .enterTaskDescription("Positive emotions like curiosity, satis")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("???????? '????????' ???????? ?????????????? ?????????????? 40 ???????????????? 3000 ????????????????"));
        softAssert = new SoftAssert();
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("LearnTest")
                .enterTaskTitle("Positive emotions like curiosity, satisfaction, and liveliness have a massive\n impact on how your brain processes your\n learning.")
                .enterTaskDescription("Knowing the most effective strategies for how to learn can help you maximize your efforts when you are trying to learn new ideas, concepts, and skills. If you are like many people, your time is limited, so it is important to get the most educational value out of the time you have.\n" +
                        "\n" +
                        "Speed of learning is not the only important factor, however. It is important to be able to accurately remember the information that you learn, recall it at a later time, and use it effectively in a wide variety of situations.\n" +
                        "\n" +
                        "Knowing how to learn well is not something that happens overnight, but putting a few of these learning techniques into daily practice can help you get more out of your study time.There are a number of different strategies that can boost memory. Basic tips such as improving your focus, avoiding cram sessions, and structuring your study time are good places to start, but there are even more lessons from psychology that can dramatically improve your learning efficiency.\n" +
                        "\n" +
                        "Strategies that can help improve your memory include:\n" +
                        "\n" +
                        "Getting regular physical exercise, which is linked to improvements in memory and brain health1\n" +
                        "Spending time socializing with other people\n" +
                        "Getting enough sleep2\n" +
                        "Eliminating distractions so you can focus on what you are learning\n" +
                        "Organizing the information you are studying to make it easier to remember3\n" +
                        "Using elaborative rehearsal when studying; when you learn something new, spend a few moments describing it to yourself in your own words\n" +
                        "Using visual aids like photographs, graphs, and charts\n" +
                        "Reading the information you are studying out loud4\n" +
                        "For example, you might use general learning techniques like setting aside quiet time to study, rehearsing, and reading information aloud. You might combine this with strategies that can foster better memory, such as exercising and socializing.One sure-fire way to become a more effective learner is to simply keep learning. Research has found that the brain is capable of producing new brain cells, a process known as neurogenesis. However, many of these cells will eventually die unless a person engages in some type of effortful learning.\n" +
                        "By learning new things, these cells are kept alive and incorporated into brain circuits.5\n" +
                        "\n" +
                        "So, if you are learning a new language, it is important to keep practicing the language in order to maintain the gains you have achieved. This \"use-it-or-lose-it\" phenomenon involves a brain process known as \"pruning.\"\n" +
                        "\n" +
                        "In pruning, certain pathways in the brain are maintained, while others are eliminated. If you want the new information you just learned to stay put, keep practicing and rehearsing it.Another one of the best ways to learn is to focus on learning in more than one way. For example, instead of just listening to a podcast, which involves auditory learning, find a way to rehearse the information both verbally and visually.\n" +
                        "\n" +
                        "This might involve describing what you learned to a friend, taking notes, or drawing a mind map. By learning in more than one way, you???re furth")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("???????? '????????' ???????? ?????????????? ?????????????? 40 ???????????????? 3000 ????????????????"));
        softAssert.assertAll();
    }


    @Description("addTaskWithInvalidTitle")
    @Test
    public void addTaskWithInvalidTitle() {
        AddTaskPage enterInvalidTitle = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidTitle.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidTitle.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidTitle.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-01-01")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("World Cup task")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????????????' ???? ???????? ???????? ????????????"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("World Cup task")
                .enterTaskTitle("??????, ??????, ??, ????????, ??????, ??, ????????, ??????, ??, ????????, ??????, ??, ??")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????????????' ???????? ?????????????? ???????????? ???????????????????? ???? ???????????????????? ????????????, ?????????? ???? ???????????????????? ??????????????"));
        softAssert = new SoftAssert();
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("LearnTest")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final.")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????????????' ???????? ?????????????? ?????????????? 40 ???????????????? 3000 ????????????????"));
        softAssert = new SoftAssert();
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("FIFA World Cup")
                .enterTaskTitle("Knowing the most effective strategies for how to learn can help you maximize your efforts when you are trying to learn new ideas, concepts, and skills. If you are like many people, your time is limited, so it is important to get the most educational value out of the time you have.\n" +
                        "\n" +
                        "Speed of learning is not the only important factor, however. It is important to be able to accurately remember the information that you learn, recall it at a later time, and use it effectively in a wide variety of situations.\n" +
                        "\n" +
                        "Knowing how to learn well is not something that happens overnight, but putting a few of these learning techniques into daily practice can help you get more out of your study time.There are a number of different strategies that can boost memory. Basic tips such as improving your focus, avoiding cram sessions, and structuring your study time are good places to start, but there are even more lessons from psychology that can dramatically improve your learning efficiency.\n" +
                        "\n" +
                        "Strategies that can help improve your memory include:\n" +
                        "\n" +
                        "Getting regular physical exercise, which is linked to improvements in memory and brain health1\n" +
                        "Spending time socializing with other people\n" +
                        "Getting enough sleep2\n" +
                        "Eliminating distractions so you can focus on what you are learning\n" +
                        "Organizing the information you are studying to make it easier to remember3\n" +
                        "Using elaborative rehearsal when studying; when you learn something new, spend a few moments describing it to yourself in your own words\n" +
                        "Using visual aids like photographs, graphs, and charts\n" +
                        "Reading the information you are studying out loud4\n" +
                        "For example, you might use general learning techniques like setting aside quiet time to study, rehearsing, and reading information aloud. You might combine this with strategies that can foster better memory, such as exercising and socializing.One sure-fire way to become a more effective learner is to simply keep learning. Research has found that the brain is capable of producing new brain cells, a process known as neurogenesis. However, many of these cells will eventually die unless a person engages in some type of effortful learning.\n" +
                        "By learning new things, these cells are kept alive and incorporated into brain circuits.5\n" +
                        "\n" +
                        "So, if you are learning a new language, it is important to keep practicing the language in order to maintain the gains you have achieved. This \"use-it-or-lose-it\" phenomenon involves a brain process known as \"pruning.\"\n" +
                        "\n" +
                        "In pruning, certain pathways in the brain are maintained, while others are eliminated. If you want the new information you just learned to stay put, keep practicing and rehearsing it.Another one of the best ways to learn is to focus on learning in more than one way. For example, instead of just listening to a podcast, which involves auditory learning, find a way to rehearse the information both verbally and visually.\n" +
                        "\n" +
                        "This might involve describing what you learned to a friend, taking notes, or drawing a mind map. By learning in more than one way, you???re furth")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????????????' ???????? ?????????????? ?????????????? 40 ???????????????? 3000 ????????????????"));
        softAssert.assertAll();
    }

    @Description("Add Task with Invalid Name")
    @Test
    public void addInvalidTaskName() {
        AddTaskPage enterInvalidTitle = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidTitle.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidTitle.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidTitle.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-01-01")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams ")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????' ???? ???????? ???????? ????????????"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("??????; ??????, ??, ??")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams ")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????' ???????? ?????????????? ???????????? ???????????????????? ???? ???????????????????? ????????????, ?????????? ???? ???????????????????? ??????????????"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("Test")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams ")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????' ???????? ?????????????? ?????????????? 5 ???????????????? 50 ????????????????"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("As of the 2018 FIFA World Cup, twenty-one final tournaments hav")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams ")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("???????? '??????????' ???????? ?????????????? ?????????????? 5 ???????????????? 50 ????????????????"));
        softAssert.assertAll();
    }

    @Description("Add task with invalid date")
    @Test
    public void addTaskWithInvalidDate() {
        AddTaskPage enterInvalidDate = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidDate.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidDate.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidDate.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidDate.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidDate.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .uploadImage("src/main/resources/R.jpeg")
                .enterTaskName("2018 FIFA World Cup")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidDate.isContainErrorMessage("???????? ?????????????? ???? ???????? ???????? ????????????????"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2018-03-03")
                .clickSave();
        softAssert.assertTrue(enterInvalidDate.isContainErrorMessage("???????? ?????????????? ?????? ???????? ?? ??????????????????????"));
        softAssert.assertAll();
    }

    @Description("Add Task Without Image")
    @Test
    public void addTaskWithoutImage() {
        AddTaskPage uploadImage = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(uploadImage.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(uploadImage.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(uploadImage.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(uploadImage.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(uploadImage.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-03-03")
                .enterTaskName("2018 FIFA World Cup")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(uploadImage.isContainErrorMessage("???????? ???? ???????? ???????? ????????????"));
        softAssert.assertAll();
    }

    @Description("Add Task With Valid Data")
    @Test
    public void addTask() {
        AddTaskPage enterValidData = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage("\\src\\test\\resources\\R.jpeg")
                .enterTaskName("Task test checking")
                .enterTaskTitle("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();
        TasksService service = new TasksService();
        TasksEntity task = service.getByName("Task test checking");
        Assert.assertNotNull(task);
        Assert.assertEquals(task.getChallenge_id(), 424);


    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
