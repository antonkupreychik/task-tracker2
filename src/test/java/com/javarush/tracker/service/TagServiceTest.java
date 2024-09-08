package com.javarush.tracker.service;

import com.javarush.tracker.mapper.TagMapper;
import com.javarush.tracker.model.command.TagCommand;
import com.javarush.tracker.provider.SessionProvider;
import com.javarush.tracker.provider.TaskTrackerSessionProvider;
import com.javarush.tracker.repository.TagRepository;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertEquals;

class TagServiceTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );
    static Connection connection;
    static Liquibase liquibase;

    TagService tagService;
    TagRepository tagRepository;
    SessionProvider sessionProvider;
    TagMapper tagMapper;

    @BeforeAll
    public static void beforeAll() throws Exception {
        postgres.start();
        connection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

        liquibase = new Liquibase("db/changelog/changelog.xml", new ClassLoaderResourceAccessor(), database);
        liquibase.update("");
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {
        sessionProvider = new TaskTrackerSessionProvider(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        tagMapper = TagMapper.INSTANSE;
        tagRepository = new TagRepository();


        tagService = new TagService(sessionProvider.getSessionFactory(),
                tagMapper, tagRepository);
    }

    @AfterEach
    void tearDown() {
        tagRepository.dropAll(sessionProvider.getSessionFactory().openSession());
    }


    @Test
    void should_find_two_saved_tags() {
        tagService.save(new TagCommand("asda", "234"));
        tagService.save(new TagCommand("sdfsd", "34234"));

        var actual = tagService.getAll().size();

        assertEquals(2, actual);
    }


    @Test
    void should_find_no_tags_in_db() {
        tagService.save(new TagCommand("assdfsda", "2564534"));
        tagService.save(new TagCommand("sdfsdfasas", "3424534"));

        var actual = tagService.getAll().size();

        assertEquals(2, actual);
    }


    @Test
    void should_drop_all_tags() {
        tagService.save(new TagCommand("assdfsda", "2564534"));
        tagService.save(new TagCommand("sdfsdfasas", "3424534"));

        tagRepository.dropAll(sessionProvider.getSessionFactory().openSession());

        var actual = tagService.getAll().size();
        assertEquals(0, actual);
    }

}